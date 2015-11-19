
var countSelectedUpdates = 0;
var countSelectedFeatures = 0;


$(document).ready(function () {
	$(document).on("click", ".update-icon", function(e) {
		var item = $(this).closest(".p2feature");
		var feature = $(item).data("feature");
		var activeClass = "selected";

		// feature is already selected - this is to unselect
		if (feature.selected) {
			feature.selected = false;
			$(this).removeClass(activeClass);
			$(this).removeClass('mif-checkmark');
			$(this).addClass('mif-vertical-align-bottom');
			countSelectedUpdates--;
		} else {
			feature.selected = true;
			$(this).addClass(activeClass);
			$(this).removeClass('mif-vertical-align-bottom');
			$(this).addClass('mif-checkmark');
			countSelectedUpdates++;
		}
		var updateListTxt = "";
		if (countSelectedUpdates === 0) {
			updateListTxt = "";
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
		var item = $(this).closest(".p2feature");
		var feature = $(item).data("feature");
		var activeClass = "selected";

		// feature is already selected - this is to unselect
		if (feature.selected) {
			feature.selected = false;
			$(this).removeClass(activeClass);
			$(this).removeClass('mif-checkmark');
			$(this).addClass('mif-vertical-align-bottom');
			countSelectedFeatures--;
		} else {
			feature.selected = true;
			$(this).addClass(activeClass);
			$(this).removeClass('mif-vertical-align-bottom');
			$(this).addClass('mif-checkmark');
			countSelectedFeatures++;
		}
		var installListTxt = "";
		if (countSelectedFeatures === 0) {
			installListTxt = "";
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
	
	$('#updateList').children('.p2feature').each(function () {
		var feature =  $(this).data("feature");
		if(feature.selected){
			selectedUpdates.push(feature);
		}
	});
	setSelectedUpdatesCallback(JSON.stringify(selectedUpdates));
	installSelectedUpdatesCallback();
}


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
		$('#updateBtn').prop('disabled', true);
	} catch (err) {
		alert('Error while loading list of updates. Message: ' + err.message);
	}
}

var installSelectedFeatures = function(){
	var selectedFeatures = [];
	
	$('#installList').children('.p2feature').each(function () {
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
		$('#installBtn').prop('disabled', true);
	} catch (err) {
		alert('Error while loading list of available features. Message: ' + err.message);
	}
}

var createUpdateItem = function(id, feature) {
	var item = $.parseHTML(" <tr class='p2feature' style='max-height:100px;'></tr>");
	$(item).attr("id", id);
	$(item).data("feature", feature);
	
	var img = $.parseHTML("<td><div class='image-container rounded'><div class='frame'><img src='"
					+ feature.iconURL + "' style='max-width:100px;max-height:80px;'></div></div></td>");
	$(item).append(img);
	
	var body = $.parseHTML(" <td style='max-width:700px;'></td>");
	var heading = $.parseHTML("<h4></h4>");
	$(heading).text(feature.label);
	
	var version = $.parseHTML("&nbsp&nbsp<small></small>");
	$(version).text(feature.version);
	$(heading).append(version);


	var install = $.parseHTML("<span class='mif-vertical-align-bottom update-icon align-right' data-hint-position='top'  data-role='hint' data-hint='Update Feature|"
			+ feature.label+ " " + feature.version + "'  style='cursor:pointer;padding-left:20px;'></span>");
	$(heading).append(install);
	$(body).append(heading);
	
	var description = $.parseHTML("<p>"+ feature.description +"</p>");
	$(body).append(description);


	$(item).append(body);

	return item;
}

var createInstallItem = function(id, feature) {
	var item = $.parseHTML(" <tr  class='p2feature' style='max-height:100px;'></tr>");
	$(item).attr("id", id);
	$(item).data("feature", feature);
	
	var img = $.parseHTML("<td><div class='image-container rounded'><div class='frame'><img src='"
					+ feature.iconURL + "' style='max-width:100px;max-height:80px;'></div></div></td>");
	$(item).append(img);
	
	var body = $.parseHTML(" <td style='max-width:700px;'></td>");
	var heading = $.parseHTML("<h4></h4>");
	$(heading).text(feature.label);
	
	var version = $.parseHTML("&nbsp&nbsp<small></small>");
	$(version).text(feature.version);
	$(heading).append(version);


	var install = $.parseHTML("<span class='mif-vertical-align-bottom install-icon align-right' data-hint-position='top'  data-role='hint' data-hint='Install Feature|"
			+ feature.label+ " " + feature.version + "'  style='cursor:pointer;padding-left:20px;'></span>");
	$(heading).append(install);
	$(body).append(heading);
	
	var description = $.parseHTML("<p>"+ feature.description +"</p>");
	$(body).append(description);


	$(item).append(body);

	return item;
}

var getAvailableUpdatesCallbackTest= function(){
	  var map = '{"org.wso2.developerstudio.carbon.server.feature.feature.group":{"currentVersion":"4.0.0.201511171257","installable":false,"selected":false,"id":"org.wso2.developerstudio.carbon.server.feature.feature.group","label":"Carbon Server Tools","version":"4.0.0.201511171304","provider":"%providerName","descriptionURL":"http://wso2.com","description":"This feature will install plugins related to Carbon Server Tools.","iconURL":"/tmp/DevSUpdaterTmp/org.wso2.developerstudio.carbon.server.feature.feature.jar/4.0.0.201511171304/extracted/icon.png"},"org.wso2.developerstudio.capp.feature.feature.group":{"currentVersion":"4.0.0.201511171257","whatIsNew":"This property tells users about new things in this release/update. You can add a nice description about the new things in here.","bugFixes":"This property tells users about fixes done in this release/patch.You can inform users about the fixes you have done in this patch.","installable":false,"selected":false,"id":"org.wso2.developerstudio.capp.feature.feature.group","label":"Carbon Application Tools","version":"4.0.0.201511171304","provider":"%providerName","descriptionURL":"http://wso2.com","description":"This feature will install plugins related WSO2 Carbon Application Support.","iconURL":"/tmp/DevSUpdaterTmp/org.wso2.developerstudio.capp.feature.feature.jar/4.0.0.201511171304/extracted/icon.png"},"org.wso2.developerstudio.registry.feature.feature.group":{"currentVersion":"4.0.0.201511171257","installable":false,"selected":false,"id":"org.wso2.developerstudio.registry.feature.feature.group","label":"Registry Tools","version":"4.0.0.201511171304","provider":"%providerName","descriptionURL":"http://wso2.com","description":"This feature will install plugins related to Carbon Registry Tools.","iconURL":"/tmp/DevSUpdaterTmp/org.wso2.developerstudio.registry.feature.feature.jar/4.0.0.201511171304/extracted/icon.png"}}';
		return map;
	}

var getAvailableFeaturesCallbackTest= function(){
  var map = '{"org.wso2.developerstudio.carbon.server.feature.feature.group":{"currentVersion":"4.0.0.201511171257","installable":false,"selected":false,"id":"org.wso2.developerstudio.carbon.server.feature.feature.group","label":"Carbon Server Tools","version":"4.0.0.201511171304","provider":"%providerName","descriptionURL":"http://wso2.com","description":"This feature will install plugins related to Carbon Server Tools.","iconURL":"/tmp/DevSUpdaterTmp/org.wso2.developerstudio.carbon.server.feature.feature.jar/4.0.0.201511171304/extracted/icon.png"},"org.wso2.developerstudio.capp.feature.feature.group":{"currentVersion":"4.0.0.201511171257","whatIsNew":"This property tells users about new things in this release/update. You can add a nice description about the new things in here.","bugFixes":"This property tells users about fixes done in this release/patch.You can inform users about the fixes you have done in this patch.","installable":false,"selected":false,"id":"org.wso2.developerstudio.capp.feature.feature.group","label":"Carbon Application Tools","version":"4.0.0.201511171304","provider":"%providerName","descriptionURL":"http://wso2.com","description":"This feature will install plugins related WSO2 Carbon Application Support.","iconURL":"/tmp/DevSUpdaterTmp/org.wso2.developerstudio.capp.feature.feature.jar/4.0.0.201511171304/extracted/icon.png"},"org.wso2.developerstudio.registry.feature.feature.group":{"currentVersion":"4.0.0.201511171257","installable":false,"selected":false,"id":"org.wso2.developerstudio.registry.feature.feature.group","label":"Registry Tools","version":"4.0.0.201511171304","provider":"%providerName","descriptionURL":"http://wso2.com","description":"This feature will install plugins related to Carbon Registry Tools.","iconURL":"/tmp/DevSUpdaterTmp/org.wso2.developerstudio.registry.feature.feature.jar/4.0.0.201511171304/extracted/icon.png"}}';
	return map;
}