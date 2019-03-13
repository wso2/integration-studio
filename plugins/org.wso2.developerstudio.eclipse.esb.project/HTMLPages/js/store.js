var ENDPOINTS = {
		connector_endpoint: "http://localhost:7774/project/connectors",
		list_connector_endpoint: "http://localhost:7774/project/connectors/list",
		download_connector_endpoint: "http://localhost:7774/project/connectors/download",
};

function getConnectors() {
	$.post(ENDPOINTS.list_connector_endpoint, function(data,
			status) {
		loadConnectorNodes(JSON.stringify(data));
	});
};

var connectorNodeArray;
getConnectors();
function loadConnectorNodes(connectorsString) {
	var connectors = JSON.parse(connectorsString);
	var connectorNodes = [];
	connectorNodeArray = connectors;
	drawConnectorNodes();
};

function drawConnectorNodes() {
	connectorNodeArray.forEach(function(connector) {
		templateNode = createTemplateNode(connector.id, connector.attributes.overview_version,
				connector.attributes.overview_name, connector.attributes.overview_description,
				connector.image);
		$("#connector-nodes").append(templateNode);
		$("#" + connector.id).click(function() {
			downloadConnector(connector);
		});

	});
};

function downloadConnector(connector) {
	$.post(ENDPOINTS.download_connector_endpoint, {
		data : JSON.stringify(connector)
	}, function(data, status) {
	});
};

function createTemplateNode(appId, version, templateName, templateDescription,
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

