var portValue = 7774;

// Endpoints
var list_connector_endpoint = "http://localhost:" + portValue
		+ "/project/connectors/list";
var download_connector_endpoint = "http://localhost:" + portValue
		+ "/project/connectors/download";
var search_connector_endpoint = "http://localhost:" + portValue
		+ "/project/connectors/search";

// Pagination constants
var counter = 0;
var count = 50;

var loaderHtml = "<div class='loading'> <svg class='spinner' viewBox='0 0 50 50'> " +
  				  "<circle class='path' cx='25' cy='25' r='20' fill='none' "+
  				  "stroke-width='5'></circle></svg></div>";
var noConnectorHtml = "<div class='alert alert-warning'>Sorry, No Connector Found.</div>";
var searchString = '';

/**
 * Load more connectors on scrolling
 * 
 * @param event
 * @returns
 */
$("#connector-nodes").scroll(function(event) {
	if((searchString == "") && ($(this).scrollTop() + $(this).innerHeight() >= $(this)[0].scrollHeight)) {
        setTimeout(function() {
			counter += 50;
			getConnectors(counter, count);
		}, 1000);
    }
});

$('#search').on('keypress', function (e) {
    if(e.which === 13){
       searchString = $('#search').val();
       $(this).attr("disabled", "disabled");
       searchConnectors(searchString);
       $(this).removeAttr("disabled");
    }
});

$('.input-group-addon').click(function(){
	searchString = $('#search').val();
    searchConnectors(searchString);
});


/**
 * Retrieves the connectors with the specified offset and limit
 * 
 * @param start -
 *            offset value
 * @param count -
 *            limit value
 * @returns
 */
function getConnectors(start, count) {
	$(".template-list").append(loaderHtml);
	$.post(list_connector_endpoint, {
		start : start,
		count : count
	}, function(data, status) {
		$(".loading").remove();
		drawConnectorNodes(data);
	});
}

/**
 * Downloads a particular connector
 * 
 * @param connector
 * @returns
 */
function downloadConnector(connector) {
	$.post(download_connector_endpoint, {
		data : connector
	}, function(data, status) {
	});
};

function searchConnectors(queryString) {
	$(".template-list").empty();
	$(".template-list").append(loaderHtml);
	$.post(search_connector_endpoint, {
		query : queryString
	}, function(data, status) {
		$(".loading").remove();
		if(!Array.isArray(data) || !data.length){
			$(".template-list").append(noConnectorHtml);
		}else{
			redrawConnectorNodes(data);
		}
		
	});
}

/**
 * Render connectors and append them to the div
 * 
 * @param connectors
 * @returns
 */
function drawConnectorNodes(connectors) {
	connectors.forEach(function(connector) {
		console.log(connector);
		connectorNode = createConnectorNode(connector.id,
				connector.attributes.overview_version,
				connector.attributes.overview_name,
				connector.attributes.overview_description, 
				connector.attributes.overview_downloadlink);
		$("#connector-nodes").append(connectorNode);
	});
};

$(".template-list").on("click", ".download", function(){
	var jsonObject = new Object();
	jsonObject.attributes = {};
	jsonObject.attributes.overview_name = $(this).data("name");
	jsonObject.attributes.overview_downloadlink = $(this).data("link");
	var connectorJSON = JSON.stringify(jsonObject);
	downloadConnector(connectorJSON);
	
});

function redrawConnectorNodes(connectors) {
	$(".template-list").empty();
	drawConnectorNodes(connectors);
};

/**
 * Create the node for connector
 * 
 * @param appId
 * @param version
 * @param templateName
 * @param templateDescription
 * @param image
 * @returns
 */
function createConnectorNode(appId, version, templateName, templateDescription,
		downloadLink) {
	var resolvedimage = "src='https://store.wso2.com/store/storage/esbconnector/" + appId + "/images_thumbnail'";
	var html = "<div class='col-lg-2 col-sm-3 col-xs-4 block' data-title='"
			+ templateName
			+ "' id='"
			+ appId
			+ "'> <div class='thumb thumbnail'> <a href='#'>"
			+ " <img "
			+ resolvedimage
			+ " class='img-responsive' data-src='images/template_thumb.png' " 
			+ "> <div class='hover-opaque scrollbar-macosx'>"
			+ templateDescription
			+ "</div></a> </div><div class='thumb thumb-caption text-center'>"
			+ " <figcaption><a href='#' "
			+ "data-toggle='tooltip' data-placement='right' title='"
			+ templateName
			+ "'>"
			+ templateName
			+ "</a><div class='version'> V: "
			+ version
			+ "</div></figcaption>"
			+ "<img class='download' data-toggle='tooltip' data-placement='right' "
			+ "title='Download Connector' data-link='" +
			downloadLink
			+ "' data-name='"
			+ templateName		
			+"' src='images/download_new.png'/></div></div>";
	return html;
};

// invoking functions

getConnectors(counter, count);
