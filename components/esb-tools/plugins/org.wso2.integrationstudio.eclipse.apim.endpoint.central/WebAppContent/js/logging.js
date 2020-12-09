/*
 * Copyright (c) 2020, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.

 * WSO2 Inc. licenses this file to you under the Apache License,
 * Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License.
 * You may obtain a copy of the License at

 *      http://www.apache.org/licenses/LICENSE-2.0

 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
/**
 * Get paremeter from url.
 */
function resolveGetParam(param) {
  var paramValue = null,
    tmp = [];
  location.search
    .substr(1)
    .split("&")
    .forEach(function (item) {
      tmp = item.split("=");
      if (tmp[0] === param) paramValue = decodeURIComponent(tmp[1]);
    });
  return paramValue;
}

/**
 * If not logged in, try to login with default login details.
 */
function checkIfLogged(url, nextPageUrl, logged) {
  if (logged == TRUE_STRING) {
    window.location.replace(nextPageUrl);
  }
  $.ajax({
    url: url,
    type: "GET",
    headers: { "x-operation-type": "check-login" },
    success: function (data) {
      if (data.logged == TRUE_STRING) {
        $(location).attr("href", nextPageUrl);
      }
    },
    error: function (jqXHR, textStatus, errorThrown) {
      performLogin(
        url,
        nextPageUrl,
        serverDetails.username,
        serverDetails.password,
        serverDetails.host,
        serverDetails.productVersions[0].endpointRegistryVersion,
        serverDetails.productVersions[0].clientRegistrationVersion
      );
    },
  });
}

/**
 * Hanlde failed AJAX requests.
 */
function errorFunction(jqXHR, textStatus, errorThrown) {
  if (jqXHR.responseJSON != null && jqXHR.responseJSON.error != null) {
    showErrorMessage(jqXHR.responseJSON.error);
  } else {
    showErrorMessage(errorThrown);
  }
}

/**
 * Send login request to the servlet.
 */
function performLogin(
  url,
  nextPageUrl,
  username,
  password,
  host,
  endpointRegistryVersion,
  clientRegistrationVersion
) {
  $.ajax({
    url: url,
    type: "POST",
    headers: { "x-operation-type": "login", "Content-Type": APPLICATION_JSON },
    data: JSON.stringify({
      username: username,
      password: password,
      host: host,
      endpointRegistryVersion: endpointRegistryVersion,
      clientRegistrationVersion: clientRegistrationVersion,
    }),
    success: function (data) {
      $(location).attr("href", nextPageUrl);
    },
    error: function (jqXHR, textStatus, errorThrown) {
      errorFunction(jqXHR, textStatus, errorThrown);
    },
  });
}

/**
 * Populate options in the production version dropdown.
 */
function populateVersions() {
  serverDetails.productVersions.forEach(function (item) {
    $(PRODUCT_VERSION).append("<option value='" + item.productVersion + "'>" + item.productVersion + "</option>");
  });
}

/**
 * Display error message in the error message box.
 */
function showErrorMessage(message) {
  $(LOGIN_ERROR_MESSAGE_BOX).attr("hidden", false);
  $(LOGIN_ERROR_MESSAGE_BOX).html(message);
}

/**
 * Validate the host url format.
 */
function validateHostUrl(hostUrl) {
  if (hostUrl.substr(0, 8) != "https://") {
    showErrorMessage("Host url should start with https://.");
    return false;
  }
  if (hostUrl.substr(-1) == "/") {
    showErrorMessage("Please remove the ending / from the host url.");
    return false;
  }
  return true;
}

$(document).ready(function ($) {
  let portValue = resolveGetParam("port");
  if (portValue == null) {
    portValue = serverDetails.port;
  }
  var logged = resolveGetParam("logged");
  var logout = resolveGetParam("logout");
  var url = serverDetails.servlet + portValue + serverDetails.servletContext;
  var nextPageUrl = url + "service_catalog.html?port=" + portValue;
  var serviceUrl = url + "service";

  populateVersions();
  if (logout == null || logout == "false") {
    checkIfLogged(serviceUrl, nextPageUrl, logged);
  }

  // Override default event in sign-in button
  $("#sign_in_button")
    .unbind(CLICK)
    .bind(CLICK, function (e) {
      e.preventDefault();
      let username = $("#username").val();
      let password = $("#password").val();
      let host = $("#hostUrl").val();
      let productVersion = $(PRODUCT_VERSION).val();
      let endpointRegistryVersion;
      let clientRegistrationVersion;
      serverDetails.productVersions.forEach(function (item) {
        if ((item.productVersion = productVersion)) {
          endpointRegistryVersion = item.endpointRegistryVersion;
          clientRegistrationVersion = item.clientRegistrationVersion;
        }
      });
      if (username == EMPTY_STRING || password == EMPTY_STRING || host == EMPTY_STRING) {
        showErrorMessage("Plese enter missing details.");
      } else if (validateHostUrl(host)) {
        performLogin(
          serviceUrl,
          nextPageUrl,
          username,
          password,
          host,
          endpointRegistryVersion,
          clientRegistrationVersion
        );
      }
    });
});
