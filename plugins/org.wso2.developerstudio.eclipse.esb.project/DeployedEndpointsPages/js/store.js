var apijson = resolveGetParam("apidetails");
var proxyjson = resolveGetParam("proxydetails");
var dataservicejson = resolveGetParam("dataservicedetails");
var port = resolveGetParam("port");
var HIDDEN = "hidden";
var SHOW = "show";
var HIDE = "hide";
var FAILED_ALERT = "#failed-alert";
var LOADING_ALERT = "#open-dashboard-modal";

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

loadContent();

function loadContent() {
	populateAPIList();
	populateProxyList();
	populateDataServiceList();
}

function populateAPIList() {
	apijsontemp = JSON.parse(apijson);
	apiList = apijsontemp.list;
	
	for(var i = 0; i < apiList.length; i++) {
	    var item = apiList[i];
	    $table = $('#table-container-api table tbody');
	    $table.append('<tr><td>' + item.name + '</td><td>' + item.url + '</td></tr>');
	}
	
	return apiList;
}

function populateProxyList() {
	var proxyjsontemp = JSON.parse(proxyjson);
	var proxyList = proxyjsontemp.list;
	for(var i = 0; i < proxyList.length; i++) {
	    var item = proxyList[i];
	    $table = $('#table-container-proxy table tbody');
		$table.append('<tr><td>' + item.name + '</td><td>' + item.wsdl1_1 + '</td><td>' + item.wsdl2_0 + '</td></tr>');
	}
	
	return apiList;
}

function populateDataServiceList() {
	var dataservicejsontemp = JSON.parse(dataservicejson);
	var dataserviceList = dataservicejsontemp.list;
	for(var i = 0; i < dataserviceList.length; i++) {
	    var item = dataserviceList[i];
	    $table = $('#table-container-ds table tbody');
		$table.append('<tr><td>' + item.name + '</td><td>' + item.wsdl1_1 + '</td><td>' + item.wsdl2_0 + '</td></tr>');
	}

	return dataserviceList;
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
 * Send request to open dashboard.
 */
function openDashboard() {
	$(LOADING_ALERT).modal(SHOW);
	$.ajax({
		url: "http://127.0.0.1:" + port + "/project/endpoints/services",
		type: "GET",
		dataType: "text",
		cache: true,
		success: function(data) {
			$(LOADING_ALERT).modal(HIDE);
		},
		error: function(jqXHR, textStatus, errorThrown) {
			$(LOADING_ALERT).modal(HIDE);
			$(FAILED_ALERT).prop(HIDDEN, false);
			$(FAILED_ALERT)[0].innerText = getErrorMessage(jqXHR, errorThrown);
			setTimeout(function() {
				$(FAILED_ALERT).prop(HIDDEN, true);
			}, 10000);
		},
	});
}

$(document).ready(function($) {
	document.onclick = function(e) {
		e = e || window.event;
		var element = e.target || e.srcElement;
		// catch event of open monitoring dashboard.
		if (element.tagName == "A" && element.id && element.id == "open-monitoring-dashboard") {
			openDashboard();
			return false;
		}
	};
});
