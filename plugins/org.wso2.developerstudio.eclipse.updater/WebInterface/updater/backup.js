
var countSelectedUpdates = 0;
var countSelectedFeatures = 0;


$(document).ready(function () {
	$(document).on("click", ".update-icon", function(e) {
		var item = $(this).closest(".media");
		var feature = $(item).data("feature");
		var activeClass = "selected";

		// feature is already selected - this is to unselect
		if (feature.selected) {
			feature.selected = false;
			$(this).removeClass(activeClass);
			countSelectedUpdates--;
		} else {
			feature.selected = true;
			$(this).addClass(activeClass);
			countSelectedUpdates++;
		}
		var updateListTxt = "";
		if (countSelectedUpdates === 0) {
			updateListTxt = " No features will be updated.";
			$('#updateBtn').prop('disabled', true);
		} else if (countSelectedUpdates === 1) {
			updateListTxt = " 1 feature will be updated.";
			$('#updateBtn').prop('disabled', false);
		} else {
			updateListTxt = countSelectedUpdates
					+ " features will be updated.";
			$('#updateBtn').prop('disabled', false);
		}
		$("#updateSelectionSummary").text(updateListTxt);
	});
	
	$(document).on("click", ".install-icon", function(e) {
		var item = $(this).closest(".media");
		var feature = $(item).data("feature");
		var activeClass = "selected";

		// feature is already selected - this is to unselect
		if (feature.selected) {
			feature.selected = false;
			$(this).removeClass(activeClass);
			countSelectedFeatures--;
		} else {
			feature.selected = true;
			$(this).addClass(activeClass);
			countSelectedFeatures++;
		}
		var installListTxt = "";
		if (countSelectedFeatures === 0) {
			installListTxt = " No new features will be installed.";
			$('#installBtn').prop('disabled', true);
		} else if (countSelectedFeatures === 1) {
			installListTxt = " 1 new feature will be installed.";
			$('#installBtn').prop('disabled', false);
		} else {
			installListTxt = countSelectedFeatures
					+ " new features will be installed.";
			$('#installBtn').prop('disabled', false);
		}
		$("#installSelectionSummary").text(installListTxt);
	});
	initUpdatesList();
	initAvailableFeaturesList();
});

var installSelectedUpdates = function(){
	//var updates = $("#updateTab").data("updatesMap");
	var selectedUpdates = [];
	
	$('#updateList').children('.media').each(function () {
		var feature =  $(this).data("feature");
		if(feature.selected){
			selectedUpdates.push(feature);
		}
	});
	setSelectedUpdatesCallback(JSON.stringify(selectedUpdates));
	installSelectedUpdatesCallback();
}


var addToolTips = function(){
    $('[data-toggle="tooltip"]').tooltip();   
};


var initUpdatesList = function() {
	try {
		var updatesString = getAvailableUpdatesCallback();
		var updates = $.parseJSON(updatesString);
		$("#updateTab").data("updatesMap", updates);
		var count = 0;
		$("#updateList").empty();
		$.each(updates, function(key, value) {
			var item = createUpdateItem(key, value);
			$(item).data("feature", value);
			$("#updateList").append(item);
			// $("#updateList").append("<hr>");
			count++;
		});
		$("#updateAvailableSummary").text(count + " updates are availbale.");
		$("#updateSelectionSummary").text(
				countSelectedUpdates + " updates will be installed.");
		addToolTips();
		$('#updateBtn').prop('disabled', true);
	} catch (err) {
		alert('Error while loading list of updates. Message: ' + err.message);
	}
}

var installSelectedFeatures = function(){
	var selectedFeatures = [];
	
	$('#installList').children('.media').each(function () {
		var feature =  $(this).data("feature");
		if(feature.selected){
			selectedFeatures.push(feature);
		}
	});
	setSelectedFeaturesCallback(JSON.stringify(selectedFeatures));
	
	installSelectedFeaturesCallback();
}

var initAvailableFeaturesList = function(){
	try {
		var featureString = getAvailableFeaturesCallback();
		var features = $.parseJSON(featureString);
		$("#installTab").data("featuersMap", features);
		var count = 0;
		$("#installList").empty();
		$.each(features, function(key, value) {
			var item = createInstallItem(key, value);
			$(item).data("feature", value);
			$("#installList").append(item);
			// $("#updateList").append("<hr>");
			count++;
		});
		$("#installAvailableSummary").text(count + " new features are availbale.");
		$("#installSelectionSummary").text(
				countSelectedFeatures + " new features will be installed.");
		addToolTips();
		$('#installBtn').prop('disabled', true);
	} catch (err) {
		alert('Error while loading list of available features. Message: ' + err.message);
	}
}

var createUpdateItem = function(id, feature) {
	var item = $.parseHTML("<li class='media'></li>");
	$(item).attr("id", id);
	$(item).data("feature", feature);

	var header = $.parseHTML("<a href='#' class='pull-left'></a>");

	var icon = $.parseHTML("<img class='img-circle'>");
	$(icon).attr("src", feature.iconURL);

	$(header).append(icon);
	$(item).append(header);

	var body = $.parseHTML("<div class='media-body'></div>");
	var version = $
			.parseHTML("<span class='text-muted pull-right'><small class='text-muted'>version: "
					+ feature.version + "</small></span>");
	$(body).append(version);

	var label = $.parseHTML("<strong class='text-success'>" + feature.label
			+ "</strong>");
	$(body).append(label);

	var installBtn = $
			.parseHTML("<span class='glyphicon glyphicon-save update-icon' data-toggle='tooltip' title='install "
					+ feature.label+ " " + feature.version + "'></span>");
	$(body).append(installBtn);

	var description = $.parseHTML("<p></p>");
	$(description).text(feature.description);
	$(body).append(description);

	$(item).append(body);

	return item;
}

var createInstallItem = function(id, feature) {
	var item = $.parseHTML("<li class='media'></li>");
	$(item).attr("id", id);
	$(item).data("feature", feature);

	var header = $.parseHTML("<a href='#' class='pull-left'></a>");

	var icon = $.parseHTML("<img class='img-circle'>");
	$(icon).attr("src", feature.iconURL);

	$(header).append(icon);
	$(item).append(header);

	var body = $.parseHTML("<div class='media-body'></div>");
	var version = $
			.parseHTML("<span class='text-muted pull-right'><small class='text-muted'>version: "
					+ feature.version + "</small></span>");
	$(body).append(version);

	var label = $.parseHTML("<strong class='text-success'>" + feature.label
			+ "</strong>");
	$(body).append(label);

	var installBtn = $
			.parseHTML("<span class='glyphicon glyphicon-save install-icon' data-toggle='tooltip' title='install "
					+ feature.label+ " " + feature.version + "'></span>");
	$(body).append(installBtn);

	var description = $.parseHTML("<p></p>");
	$(description).text(feature.description);
	$(body).append(description);

	$(item).append(body);

	return item;
}

var getAvailableUpdatesCallbackTest = function(){
	  var map = '{"org.wso2.developerstudio.carbon.server.feature.feature.group":{"currentVersion":"4.0.0.201511171257","installable":false,"selected":false,"id":"org.wso2.developerstudio.carbon.server.feature.feature.group","label":"Carbon Server Tools","version":"4.0.0.201511171304","provider":"%providerName","descriptionURL":"http://wso2.com","description":"This feature will install plugins related to Carbon Server Tools.","iconURL":"/tmp/DevSUpdaterTmp/org.wso2.developerstudio.carbon.server.feature.feature.jar/4.0.0.201511171304/extracted/icon.png"},"org.wso2.developerstudio.capp.feature.feature.group":{"currentVersion":"4.0.0.201511171257","whatIsNew":"This property tells users about new things in this release/update. You can add a nice description about the new things in here.","bugFixes":"This property tells users about fixes done in this release/patch.You can inform users about the fixes you have done in this patch.","installable":false,"selected":false,"id":"org.wso2.developerstudio.capp.feature.feature.group","label":"Carbon Application Tools","version":"4.0.0.201511171304","provider":"%providerName","descriptionURL":"http://wso2.com","description":"This feature will install plugins related WSO2 Carbon Application Support.","iconURL":"/tmp/DevSUpdaterTmp/org.wso2.developerstudio.capp.feature.feature.jar/4.0.0.201511171304/extracted/icon.png"},"org.wso2.developerstudio.registry.feature.feature.group":{"currentVersion":"4.0.0.201511171257","installable":false,"selected":false,"id":"org.wso2.developerstudio.registry.feature.feature.group","label":"Registry Tools","version":"4.0.0.201511171304","provider":"%providerName","descriptionURL":"http://wso2.com","description":"This feature will install plugins related to Carbon Registry Tools.","iconURL":"/tmp/DevSUpdaterTmp/org.wso2.developerstudio.registry.feature.feature.jar/4.0.0.201511171304/extracted/icon.png"}}';
		return map;
	}

var getAvailableFeaturesCallbackTest = function(){
  var map = '{"org.wso2.developerstudio.carbon.server.feature.feature.group":{"currentVersion":"4.0.0.201511171257","installable":false,"selected":false,"id":"org.wso2.developerstudio.carbon.server.feature.feature.group","label":"Carbon Server Tools","version":"4.0.0.201511171304","provider":"%providerName","descriptionURL":"http://wso2.com","description":"This feature will install plugins related to Carbon Server Tools.","iconURL":"/tmp/DevSUpdaterTmp/org.wso2.developerstudio.carbon.server.feature.feature.jar/4.0.0.201511171304/extracted/icon.png"},"org.wso2.developerstudio.capp.feature.feature.group":{"currentVersion":"4.0.0.201511171257","whatIsNew":"This property tells users about new things in this release/update. You can add a nice description about the new things in here.","bugFixes":"This property tells users about fixes done in this release/patch.You can inform users about the fixes you have done in this patch.","installable":false,"selected":false,"id":"org.wso2.developerstudio.capp.feature.feature.group","label":"Carbon Application Tools","version":"4.0.0.201511171304","provider":"%providerName","descriptionURL":"http://wso2.com","description":"This feature will install plugins related WSO2 Carbon Application Support.","iconURL":"/tmp/DevSUpdaterTmp/org.wso2.developerstudio.capp.feature.feature.jar/4.0.0.201511171304/extracted/icon.png"},"org.wso2.developerstudio.registry.feature.feature.group":{"currentVersion":"4.0.0.201511171257","installable":false,"selected":false,"id":"org.wso2.developerstudio.registry.feature.feature.group","label":"Registry Tools","version":"4.0.0.201511171304","provider":"%providerName","descriptionURL":"http://wso2.com","description":"This feature will install plugins related to Carbon Registry Tools.","iconURL":"/tmp/DevSUpdaterTmp/org.wso2.developerstudio.registry.feature.feature.jar/4.0.0.201511171304/extracted/icon.png"}}';
	return map;
}