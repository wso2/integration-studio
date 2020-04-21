var apijson = resolveGetParam("apidetails");
var proxyjson = resolveGetParam("proxydetails");

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

//getAccessToken();
//
//function getAccessToken() {
//	accessToken = "";
//	$.ajax({
//	    url: login_endpoint,
//	    type: 'get',
//	    headers: {
//	        "Authorization": 'Basic YWRtaW46YWRtaW4='  //for object property name, use quoted notation shown in second
//	    },
//	    dataType: 'json',
//	    success: function (data) {
//	    	accessToken = data.AccessToken;
//	        loadContent(accessToken);
//	    }
//	});
//	return accessToken;
//}

function loadContent(){
	populateAPIList();
	populateProxyList();
}

function populateAPIList() {
	apijsontemp = JSON.parse(apijson);
	apiList = apijsontemp.list;
//	$.ajax({
//	    url: apis_endpoint,
//	    type: 'get',
//	    headers: {
//	        "Authorization": 'Bearer ' + accessToken  //for object property name, use quoted notation shown in second
//	    },
//	    dataType: 'json',
//	    success: function (data) {
//	    	apiList = data.list;
////	    	$.each(apiList, function(i, item) {
////	    		$table = $('#table-container-api table tbody');
////	    		$table.append('<tr><td>' + item.name + '</td><td>' + item.url + '</td></tr>');
////	    	});
//	    	
//	    	for(var i = 0; i < apiList.length; i++) {
//	    	    item = apiList[i];
//	    	    $table = $('#table-container-api table tbody');
//	    		$table.append('<tr><td>' + item.name + '</td><td>' + item.url + '</td></tr>');
//	    	}
//	    }
//	});
	
	
	for(var i = 0; i < apiList.length; i++) {
	    item = apiList[i];
	    $table = $('#table-container-api table tbody');
	    $table.append('<tr><td>' + item.name + '</td><td>' + item.url + '</td></tr>');
	}
	
	return apiList;
}

function populateProxyList() {
	proxyjsontemp = JSON.parse(proxyjson);
	proxyList = proxyjsontemp.list;
	for(var i = 0; i < proxyList.length; i++) {
	    item = proxyList[i];
	    $table = $('#table-container-proxy table tbody');
		$table.append('<tr><td>' + item.name + '</td><td>' + item.wsdl1_1 + '</td><td>' + item.wsdl2_0 + '</td></tr>');
	}
	
	return apiList;
}

//function populateProxyList() {
//	proxyList = "";
//	$.ajax({
//	    url: proxy_endpoint,
//	    type: 'get',
//	    headers: {
//	        "Authorization": 'Bearer ' + accessToken  //for object property name, use quoted notation shown in second
//	    },
//	    dataType: 'jsonp',
//	    success: function (data) {	    	
//	    	proxyList = data.list;
//	    	$.each(proxyList, function(i, item) {
//	    		$table = $('#table-container-proxy table tbody');
//	    		$table.append('<tr><td>' + item.name + '</td><td>' + item.wsdl1_1 + '</td><td>' + item.wsdl2_0 + '</td></tr>');
//	    	});
//	    }
//	});
//	return proxyList;
//}