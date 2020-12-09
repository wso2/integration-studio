var apijson = resolveGetParam("apidetails");
var proxyjson = resolveGetParam("proxydetails");
var dataservicejson = resolveGetParam("dataservicedetails");
var port = resolveGetParam("port");
var HIDDEN = "hidden";
var SHOW = "show";
var HIDE = "hide";
var FAILED_ALERT = "#failed-alert";
var LOADING_ALERT = "#open-dashboard-modal";
var CREDENTIAL_ALERT = "#credential-alert";

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
	    $table.append('<tr><td><pre><code class="language-bash">' + item.name + '</code></pre></td><td><pre><code class="language-bash">' + item.url + '</code></pre></td></tr>');
	}
	
	if (apiList.length == 0) {
		$table = $('#table-container-api table tbody');
		$table.append('<tr><td>No services</td><td>-</td><td>-</td>');
		
	}
	
	return apiList;
}

function populateProxyList() {
	var proxyjsontemp = JSON.parse(proxyjson);
	var proxyList = proxyjsontemp.list;
	for(var i = 0; i < proxyList.length; i++) {
	    var item = proxyList[i];
	    $table = $('#table-container-proxy table tbody');
		$table.append('<tr><td><pre><code class="language-bash">' + item.name + '</code></pre></td><td><pre><code class="language-bash">' + 
				item.wsdl1_1 + '</code></pre></td><td><pre><code class="language-bash">' + item.wsdl2_0 + '</code></pre></td></tr>');
	}
	
	if (proxyList.length == 0) {
		$table = $('#table-container-proxy table tbody');
		$table.append('<tr><td>No services</td><td>-</td><td>-</td>');
		
	}
	
	return proxyList;
}

function populateDataServiceList() {
	var dataservicejsontemp = JSON.parse(dataservicejson);
	var dataserviceList = dataservicejsontemp.list;
	for(var i = 0; i < dataserviceList.length; i++) {
	    var item = dataserviceList[i];
	    $table = $('#table-container-ds table tbody');
		$table.append('<tr><td><pre><code class="language-bash">' + item.name + '</code></pre></td><td><pre><code class="language-bash">' + 
				item.wsdl1_1 + '</code></pre></td><td><pre><code class="language-bash">' + item.wsdl2_0 + '</code></pre></td></tr>');
	}

	if (dataserviceList.length == 0) {
		$table = $('#table-container-ds table tbody');
		$table.append('<tr><td>No services</td><td>-</td><td>-</td>');
		
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
		cache: false,
		success: function(data) {
			$(LOADING_ALERT).modal(HIDE);
			$(CREDENTIAL_ALERT).prop(HIDDEN, false);
			setTimeout(function() {
				$(CREDENTIAL_ALERT).prop(HIDDEN, true);
			}, 20000);
		},
		error: function(jqXHR, textStatus, errorThrown) {
			$(LOADING_ALERT).modal(HIDE);
			errorMessage = getErrorMessage(jqXHR, errorThrown);
			if (errorMessage != null && errorMessage != "") {
				$(FAILED_ALERT).prop(HIDDEN, false);
				$(FAILED_ALERT)[0].innerText = errorMessage;
				setTimeout(function() {
					$(FAILED_ALERT).prop(HIDDEN, true);
				}, 10000);
			}
		},
	});
}


$("#open-monitoring-dashboard").click(function(){
	openDashboard();
});
