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

/**
 * Load more connectors on scrolling
 * 
 * @param event
 * @returns
 */
$("#connector-nodes").scroll(function(event) {
	if ($(window).scrollTop() + $(window).height() == $(document).height()) {
		setTimeout(function() {
			counter += 50;
			getConnectors(counter, count);
		}, 1000);
	}
});

$('#search').on('keypress', function (e) {
    if(e.which === 13){
       $(this).attr("disabled", "disabled");
       searchConnectors($('#search').val());
       $(this).removeAttr("disabled");
    }
});

window.addEventListener('keypress', function (e) {
    if (e.keyCode !== 13) {
        chars.push(e.key);
    }
}, false);

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
	$.post(list_connector_endpoint, {
		start : start,
		count : count
	}, function(data, status) {
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
		data : JSON.stringify(connector)
	}, function(data, status) {
	});
};

function searchConnectors(queryString) {
	$.post(search_connector_endpoint, {
		query : queryString
	}, function(data, status) {
		redrawConnectorNodes(data);
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
		connectorNode = createConnectorNode(connector.id,
				connector.attributes.overview_version,
				connector.attributes.overview_name,
				connector.attributes.overview_description, connector.image);
		$("#connector-nodes").append(connectorNode);
		$("#" + connector.id).click(function() {
			downloadConnector(connector);
		});

	});
};

function redrawConnectorNodes(connectors) {
	$(".template").remove();
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
		image) {
	if (image != null || image != "") {
		resolvedimage = "src='./images/template_thumb.jpg'";
	} else {
		resolvedimage = "src='data:image/png;base64, " + image + "'";
	}
	var html = "<div class='col-xs-6 col-sm-6 col-md-3 col-lg-3 template' data-title='"
			+ templateName
			+ "' id='"
			+ appId
			+ "'> <div class='thumb'> <a href='#'>"
			+ " <img "
			+ resolvedimage
			+ " class='img-responsive'> <div class='hover-opaque scrollbar-macosx'>"
			+ templateDescription
			+ "</div></a> </div><div class='thumb thumb-caption text-center'> <figcaption><a href='#' "
			+ "data-toggle='tooltip' data-placement='right' title='"
			+ templateName
			+ "'>"
			+ templateName
			+ "</a></figcaption> </div></div>";
	return html;
};

// invoking functions

getConnectors(counter, count);
