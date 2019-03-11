function getConnectors() {
	$.get("http://localhost:" + 7774 + "/servlet/connectors", function(data,
			status) {
		loadWelcomeNodes(JSON.stringify(data));
	});
};

var welcomeNodeArray;
getConnectors();
function loadWelcomeNodes(connectorsString) {
	var connectors = JSON.parse(connectorsString);
	console.log(connectors);
	var connectorNodes = [];
//	connectors.forEach(function(connector) {
//		var connectorNode = {};
//		console.log(connector);
//		connectorNode.id = connector.id;
//		connectorNode.title = connector.attributes.overview_name;
//		connectorNode.description = connector.attributes.overview_downloadlink;
//		connectorNode.label = connector.attributes.overview_version;
//		console.log("Connector Node");
//		console.log(connectorNode);
//		connectorNodes.push(connectorNode);
//
//	});
	welcomeNodeArray = connectors;
	drawWelcomeNodes();
};

function drawWelcomeNodes() {
	console.log("Welcome Nodes");
	console.log(welcomeNodeArray);
	welcomeNodeArray.forEach(function(connector) {
		templateNode = createTemplateNode(connector.id, connector.attributes.overview_version,
				connector.attributes.overview_name, connector.attributes.overview_downloadlink,
				connector.image);
		$("#test").append(templateNode);
		$("#" + connector.id).click(function() {
			downloadConnector(connector);
		});

	});
};

function downloadConnector(connector) {
	console.log(connector);
	$.post("http://localhost:7774/servlet/connectors", {
		data : JSON.stringify(connector)
	}, function(data, status) {
		// loadWelcomeNodes(JSON.stringify(data));

	});
};

function createTemplateNode(appId, version, templateName, templateDescription,
		image) {
	if (image != null || image != "") {
		resolvedimage = "src='../images/template_thumb.jpg'";
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

