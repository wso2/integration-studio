/**
 * Set up elements for advanced properties while initializing.
 */
$(document).ready(function() {
	$('#ac-enable-streaming-check').prop("checked", true);
	$('#ac-enable-batch-check').prop("checked", false);
	$('#ac-active-service-status').prop("checked", false);
	$('#ac-enable-boxcarring-check').prop("checked", false);
	$('#ac-disable-legacy-boxcarring-check').prop("checked", false);
	$('#ac-disable-legacy-boxcarring-group').toggle(false);
});

function populateAdvancedProperties(root) {
	let data = root.getElementsByTagName("data")[0];
	
	let enableBatchRequests = data.attributes.getNamedItem("enableBatchRequests");
	if (enableBatchRequests != null && enableBatchRequests != undefined && enableBatchRequests.value == "true") {
		$('#ac-enable-batch-check').prop("checked", true);
	} else {
		$('#ac-enable-batch-check').prop("checked", false);
	}
	
	let activeServiceStatus = data.attributes.getNamedItem("serviceStatus");
	if (activeServiceStatus != null && activeServiceStatus != undefined && activeServiceStatus.value == "active") {
		$('#ac-active-service-status').prop("checked", true);
	} else {
		$('#ac-active-service-status').prop("checked", false);
	}

	let enableBoxcarring = data.attributes.getNamedItem("enableBoxcarring");
	if (enableBoxcarring != null && enableBoxcarring != undefined && enableBoxcarring.value == "true") {
		$('#ac-enable-boxcarring-check').prop("checked", true);
		$('#ac-disable-legacy-boxcarring-group').toggle(true);
		
		let disableLegacyBoxcarringMode = data.attributes.getNamedItem("disableLegacyBoxcarringMode");
		if (disableLegacyBoxcarringMode != null && disableLegacyBoxcarringMode != undefined && disableLegacyBoxcarringMode.value == "true") {
			$('#ac-disable-legacy-boxcarring-check').prop("checked", true);
		} else {
			$('#ac-disable-legacy-boxcarring-check').prop("checked", false);
		}
		
	} else {
		$('#ac-enable-boxcarring-check').prop("checked", false);
		$('#ac-disable-legacy-boxcarring-check').prop("checked", false);
	}
	
	let disableStreaming = data.attributes.getNamedItem("disableStreaming");
	if (disableStreaming != null && disableStreaming != undefined && disableStreaming.value == "true") {
		$('#ac-enable-streaming-check').prop("checked", false);
	} else {
		$('#ac-enable-streaming-check').prop("checked", true);
	}
}