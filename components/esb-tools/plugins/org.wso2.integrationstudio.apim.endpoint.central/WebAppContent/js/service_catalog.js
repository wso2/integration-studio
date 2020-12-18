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
var projects;
var artifactImage;
var specifications;
var selectedAPIArtifactId;
var selectedAPIArtifactParent;
var entryId;
var selectedProjectName;
var url;

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
 * Extract error message in AJAX response.
 */
function getErrorMessage(jqXHR, errorThrown) {
  if (jqXHR.responseJSON != null && jqXHR.responseJSON.error != null) {
    return jqXHR.responseJSON.error;
  } else {
    return errorThrown;
  }
}

/**
 * Get projects from the servlet.
 */
function getProjects(url) {
  $.ajax({
    url: url,
    type: "GET",
    headers: { "x-operation-type": "get-projects" },
    success: function (data) {
      projects = data;
      populateProjects();
    },
    error: function (jqXHR, textStatus, errorThrown) {
      $(PROJECT_PARENT_DEV).prop(HIDDEN, true);
      $(FAILED_API_ALERT).prop(HIDDEN, false);
      $(FAILED_API_ALERT)[0].innerText = getErrorMessage(jqXHR, errorThrown);
    },
  });
}

/**
 * Get specifications (API definitions in the endpoint registry) from the servlet.
 */
function getSpecifications(url) {
  $.ajax({
    url: url,
    type: "GET",
    headers: { "x-operation-type": "get-registry-entries" },
    success: function (data) {
      specifications = data;
      populateSpacifications();
    },
    error: function (jqXHR, textStatus, errorThrown) {
      $(SPEC_PARENT_DEV).prop(HIDDEN, true);
      $(FAILED_SPEC_ALERT).prop(HIDDEN, false);
      $(FAILED_SPEC_ALERT)[0].innerText = getErrorMessage(jqXHR, errorThrown);
    },
  });
}

/**
 * Initiate API search function.
 */
function searchItems(searchInput, itemList) {
  $(searchInput).keyup(function () {
    var valThis = $(this).val().toLowerCase();
    $(itemList)
      .children()
      .each(function () {
        if (valThis == EMPTY_STRING) {
          $(this).show();
        } else {
          var text = this.childNodes[2].childNodes[1].innerText.toLowerCase();
          text.indexOf(valThis) >= 0 ? $(this).show() : $(this).hide();
        }
      });
  });
}

/**
 * Initiate specifications (API definitions in the endpoint registry) search function.
 */
function searchSpecifications(searchInput, itemList) {
  category = $(SPEC_CATEGORY_SELECT).val();
  $(searchInput).keyup(function () {
    var valThis = $(this).val().toLowerCase();
    $(itemList)
      .children()
      .each(function () {
        selectedCategory = $(SPEC_CATEGORY_SELECT).val();
        category = this.childNodes[2].childNodes[2].innerText;
        if (category == selectedCategory || selectedCategory == DEFAULT_CATEGORY) {
          if (valThis == EMPTY_STRING) {
            $(this).show();
          } else {
            var text = this.childNodes[2].childNodes[1].innerText.toLowerCase();
            text.indexOf(valThis) >= 0 ? $(this).show() : $(this).hide();
          }
        }
      });
  });
}

/**
 * Create a new API artifact element and add it to HTML page.
 */
function createAPIArtifactNode(api, parent) {
  var html =
    "<li><div class='itemIMG'><img src='" +
    API_ARTIFACT_IMAGE +
    "' width='250' height='200'><div class='addCART'> <a href='#' id='api_" +
    api.path +
    "' name='" +
    api.parent +
    "'>Export</a> </div>" +
    "</div> <div class='itemTitle'>	<a href='#'>" +
    api.name +
    "</a><span>" +
    api.parent +
    "</span>" +
    "<p class='des'>" +
    api.path +
    "</p></div></li>";
  $(parent).append(html);
}

/**
 * Create a new Specification (API definitions in the endpoint registry) element and add it to HTML page.
 */
function createSpecificationNode(specification, parent) {
  var html =
    "<li><div class='itemIMG'><img src='" +
    SPECIFICATION_IMAGE +
    "' width='250' height='200'><div class='addCART'> <a href='#' id='spec_" +
    specification.id +
    "'>Import</a> </div>" +
    "</div> <div class='itemTitle'>	<a href='#'>" +
    specification.entryName +
    "</a><span>" +
    specification.serviceCategory +
    "</span>" +
    "<p class='des'>" +
    specification.serviceUrl +
    "</p></div></li>";
  $(parent).append(html);
}

/**
 * Add projects.
 */
function populateProjects() {
  apiCount = 0;
  if (projects != null) {
    if (projects.length > 0) {
      $(NO_CONFIG_PROJECT_ALERT).prop(HIDDEN, true);
    }
    projects.forEach(function (project) {
      apiCount += project.apis.length;
    });
  }

  if (apiCount == 0) {
    $(PROJECT_PARENT_DEV).prop(HIDDEN, true);
    $(NO_API_ALERT).prop(HIDDEN, false);
  }

  projects.forEach(function (project) {
    createProjectSelectElement(project, IMPORT_SPECIFICATION_BODY);
    project.apis.forEach(function (api) {
      createAPIArtifactNode(api, API_ARTIFACTS);
    });
  });
}

/**
 * When a project is selected in the import wizard, enable button and set selected project.
 */
function setSelectedProject(element) {
  selectedProjectName = element.id;
  $(IMPORT_SPECIFICATION_MODAL_BUTTON).prop(DISABLED, false);
}

/**
 * When import button is clicked, open modal to select which project it should be created.
 */
function openSelectProjectModal() {
  $(IMPORT_SPECIFICATION_MODAL_BUTTON).prop(DISABLED, true);
  $("input[name='groupOfDefaultRadios'").each(function () {
    this.checked = false;
  });
  $(IMPORT_SPECIFICATION).modal(SHOW);
}

/**
 * Add an entry to select project modal.
 */
function createProjectSelectElement(project, parent) {
  var html =
    "<div class='custom-control custom-radio'>" +
    "<input type='radio' class='custom-control-input' onclick='setSelectedProject(this)' id='" +
    project.projectName +
    "' name='groupOfDefaultRadios'>" +
    "<label class='custom-control-label' for='" +
    project.projectName +
    "'>" +
    project.projectName +
    "</label></div>";
  $(parent).append(html);
}

/**
 * Add specifications (API definitions in the endpoint registry) to the HTML page.
 */
function populateSpacifications() {
  if (specifications == null || specifications.length == 0) {
    $(SPEC_PARENT_DEV).prop(HIDDEN, true);
    $(NO_SPEC_ALERT).prop(HIDDEN, false);
  }

  specifications.forEach(function (specification) {
    createSpecificationNode(specification, SPECIFICATIONS);
  });
}

/**
 * Enabling switching between list and grid view.
 */
$(".view a").on("click", function () {
  $(".products ul").toggleClass("list");
  return false;
});

/**
 * Hanlde API export button click action.
 */
$("#export-api-modal-button").click(function () {
  selectedAPIArtifact = null;
  projects.forEach(function (project) {
    project.apis.forEach(function (api) {
      if (api.path == selectedAPIArtifactId && api.parent == selectedAPIArtifactParent) {
        selectedAPIArtifact = api;
      }
    });
  });

  $.ajax({
    url: url,
    type: "POST",
    headers: { "x-operation-type": "create-registry-entry", "Content-Type": APPLICATION_JSON },
    data: JSON.stringify({
      name: selectedAPIArtifact.name,
      path: selectedAPIArtifact.path,
      parent: selectedAPIArtifact.parent,
    }),
    success: function (data) {
      if (data.id != null) {
        showModalAlert(EXPORT_CONFIRM_MODAL, EXPORT_SUCCESS_ALERT, "Succesfully exported the API", true, 1000);
      }
    },
    error: function (jqXHR, textStatus, errorThrown) {
      showModalAlert(EXPORT_CONFIRM_MODAL, EXPORT_FAILED_ALERT, getErrorMessage(jqXHR, errorThrown), false, 1000);
    },
  });
});

/**
 * Show the given message in the alert-box of the modal.
 */
function showModalAlert(modelId, alertId, message, reload, time) {
  $(alertId).prop(HIDDEN, false);
  $(alertId)[0].innerText = message;
  setTimeout(function () {
    if (reload) {
      location.reload();
    }
    $(alertId).prop(HIDDEN, true);
    $(modelId).modal(TOGGLE);
  }, time);
}

/**
 * Hanlde Specification (API definitions in the endpoint registry) import button click action.
 */
$(IMPORT_SPECIFICATION_MODAL_BUTTON).click(function () {
  registryEntry = null;
  specifications.forEach(function (specification) {
    if (specification.id == entryId) {
      registryEntry = specification;
    }
  });
  $.ajax({
    url: url,
    type: "POST",
    headers: { "x-operation-type": "import-api", "Content-Type": APPLICATION_JSON },
    data: JSON.stringify({ id: registryEntry.id, projectName: selectedProjectName, 
    	apiName: registryEntry.entryName }),
    success: function (data) {
      showModalAlert(IMPORT_SPECIFICATION, IMPORT_SUCCESS_ALERT, "Succesfully imported the Specification", true, 
    		  1000);
    },
    error: function (jqXHR, textStatus, errorThrown) {
      showModalAlert(IMPORT_SPECIFICATION, IMPORT_FAILED_ALERT, getErrorMessage(jqXHR, errorThrown), false, 1000);
    },
  });
});

/**
 * Hanlde logout button click action.
 */
$(LOGOUT).click(function () {
  $.ajax({
    url: url,
    type: "GET",
    headers: { "x-operation-type": "logout", "Content-Type": APPLICATION_JSON },
    success: function (data) {
      $(location).attr("href", url.substr(0, url.length - 7) + "index.html?logout=true");
    },
    error: function (jqXHR, textStatus, errorThrown) {
      alert(getErrorMessage(jqXHR, errorThrown));
    },
  });
});

/**
 * Initiate specification (API definitions in the endpoint registry) filtering.
 */
function filterByCategory(searchText, itemList) {
  $(SPEC_CATEGORY_SELECT).change(function () {
    $(searchText).val(EMPTY_STRING);
    selectedCategory = $(SPEC_CATEGORY_SELECT).val();
    $(itemList)
      .children()
      .each(function () {
        var category = this.childNodes[2].childNodes[2].innerText;
        category == selectedCategory || selectedCategory == DEFAULT_CATEGORY ? $(this).show() : $(this).hide();
      });
    return false;
  });
}

/**
 * Populate user profile data (Username).
 */
function populateProfile() {
  $.ajax({
    url: url,
    type: "GET",
    headers: { "x-operation-type": "profile-data" },
    success: function (data) {
      $(USER_NAME)[0].innerText = data.userName;
    },
    error: function (jqXHR, textStatus, errorThrown) {
      $(location).attr("href", url.substr(0, url.length - 8));
    },
  });
}

$(document).ready(function ($) {
  // Set default values in search and filter boxes.
  $(SPECIFICATION_SEARCH).val(EMPTY_STRING);
  $(API_ARTIFACT_SEARCH).val(EMPTY_STRING);
  $(SPEC_CATEGORY_SELECT).val(DEFAULT_CATEGORY);

  let portValue = resolveGetParam("port");
  if (portValue == null) {
    portValue = serverDetails.port;
  }
  url = serverDetails.servlet + portValue + serverDetails.servletContext + serverDetails.servletServicePath;

  // load and populate data.
  populateProfile();
  getProjects(url);
  getSpecifications(url);

  // Switch to list view.
  $(".products ul").toggleClass("list");

  // set up searching and filtering.
  searchItems(API_ARTIFACT_SEARCH, API_ARTIFACTS);
  searchSpecifications(SPECIFICATION_SEARCH, SPECIFICATIONS);
  filterByCategory(SPECIFICATION_SEARCH, SPECIFICATIONS);

  // Override onclick event to extract export and import button clicks.
  document.onclick = function (e) {
    e = e || window.event;
    var element = e.target || e.srcElement;
    if (element.tagName == "A" && element.id != null) {
      itemType = element.id.split("_")[0];
      if (itemType == "api") {
        selectedAPIArtifactId = element.id.substr(4);
        selectedAPIArtifactParent = element.name;
        $(EXPORT_CONFIRM_MODAL).modal(SHOW);
        return false;
      } else if (itemType == "spec") {
        entryId = element.id.substr(5);
        openSelectProjectModal();
        return false;
      }
    }
  };
});
