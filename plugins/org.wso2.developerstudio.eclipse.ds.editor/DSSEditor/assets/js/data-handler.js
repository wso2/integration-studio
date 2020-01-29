$(document).ready(function ($) {

    let portValue = resolveGetParam("port");
    // let url = "http://localhost:" + portValue + "/dsseditor/service";
    let url = "http://localhost:7774/dsseditor/service";
    let root = "";

    // Retrieve the XML source from backend.
    $.get(url, function (data, status) {

        let parser = new DOMParser();
        root = parser.parseFromString(data, "text/xml");

        populateGeneralDetails(root);
        populateTransportSettings(root);
        populateDataSources(root);
        populateQueries(root);
        populateOperations(root);
        populateResources(root);
    });

    /** Start of Event handlers **/

    // Start of Transport settings - Transports
    $("#ts-transport-check-row input").change(function () {
        var transportsStr = $('.ts-transport-checkbox:checked').map(function() {
            return this.name;
        }).get().join(' ');

        root.getElementsByTagName("data")[0].attributes.getNamedItem("transports").value = transportsStr;
    });
    // End of Transport settings - Transports

    // Start of Data sources - Add data source
    $("#create-ds-form").submit(function (e) {
        e.preventDefault();
        let result = addDataSource(root);

        if (result.status) {
            $("#ds-add-edit-ds-modal").modal('hide');
            saveAll(root, url, saveDSMetadata(result.metadata, url));
            this.reset();
        }

    });

    // Start of resource - Add resource
    $("#resource-form").submit(function (e) {
        e.preventDefault();
        let status = addResource(root);
        if (status) {
            $("#r-resource-addedit-modal").modal('hide');
        	saveAll(root, url, function() {
                location.reload();
            });
        	$.get(url, function (data, status) {
                let parser = new DOMParser();
                console.log("From backend: ");
                console.log(parser.parseFromString(data, "text/xml"));
            });
        }

    });

    $(".modal").on("hidden.bs.modal", function() {
        //$(this).removeData();
        $(':input', '#create-ds-form').not(':button, :submit, :reset, :hidden')
            .removeAttr('checked').removeAttr('selected').not(':checkbox, :radio, select').val('');
        //Reset the resource form on modal hide
        $("#r-resource-addedit-modal").find('form').trigger('reset');
    });

    $("#ds-datasource-add-btn").click(function() {
        resetDSAddEditModal();
        $("#create-ds-form").trigger('reset');
        openDSModal(false);
    });

    $("#ds-test-conn-btn").click(function() {
        let dbType = $("#ds-db-engine-select").val();
        let version = $("#ds-db-version-select").val();
        let username = $("#ds-username-input").val();
        let password = $("#ds-password-input").val();
        let host = $("#ds-host-input").val();
        let port = $("#ds-port-input").val();
        let dbName = $("#ds-dbname-input").val();

        let connStr = dbType + DS_METADATA_KEYVALUE_SEPARATOR + version + DS_METADATA_KEYVALUE_SEPARATOR + username +
            DS_METADATA_KEYVALUE_SEPARATOR + password + DS_METADATA_KEYVALUE_SEPARATOR + host +
            DS_METADATA_KEYVALUE_SEPARATOR + port + DS_METADATA_KEYVALUE_SEPARATOR + dbName;

        testDBConnection(connStr, url);
    });

    $(document).on('click','#ds-datasources-table .fa-trash',function() {
        let dsId = $(this).closest("tr").data('id');
        deleteDatasource(root, dsId);
        $(this).closest("tr").remove();
        saveAll(root, url, function() {
            location.reload();
        });
    });

    $(document).on('click','#ds-datasources-table .fa-edit',function() {
        let dsId = $(this).closest("tr").data('id');
        let dsMetadata = retrieveDSMetadata(dsId, url);
        populateDSModal(root, dsId, dsMetadata);
        openDSModal(true);
    });
    // End of Data sources - Add data source

    // Start of queries - Add query
    $("#q-query-add-btn").click(function() {
        $("#q-query-add-btn").toggle(false);
        $("#q-queries-table").toggle(false);
        clearAddQueryForm();
        $("#q-add-edit-query-section").toggle(true);
    });
    // End of queries - Add query

    // Start of query output mapping
    
    $(document).on('click','#q-output-mapping-table .fa-edit',function() {
    	let tds = $(this).closest("tr").find('td');
    	populateQueryOutputMappingModal(root, tds[0].innerText, tds[1].innerText);
    });
    
    $(document).on('click','#q-output-mapping-table .fa-trash',function() {
    	let tds = $(this).closest("tr").find('td');
    	// TODO remove from root
    	deleteQueryOutputMappingFromRoot(root, tds[0].innerText);
    	$(this).closest("tr").remove();
    	saveAll(root, url, function() {
            location.reload();
        });
    });
    
    // End of query output mapping
    
    // Start of input event handlers - General details
    $("#dss-description-input, #dss-namespace-input").change(function() {
        let description = root.getElementsByTagName("description")[0];

        if (description.hasChildNodes()) {
            description.childNodes[0].nodeValue = $('#dss-description-input').val();
        } else {

        }

        saveAll(root, url, function() {
            location.reload();
        });
    });

    $("#dss-namespace-input").change(function() {
        saveAll(root, url, function() {
            location.reload();
        });
    });
    // End of input event handlers - General details
    /** End of Event handlers **/
    
    // Start of Operations
    
    /**
     * Populates query elements and set enableStreaming upon operation modal opening.
     */
    $('#o-operation-add-btn').click(function() {
    	clearOperationForm();
    	populateQueriesForOperationForm(root);
    	$('#o-addedit-enablestreaming-checkbox').prop("checked", true);
    });
    
    /**
     * Updates root content with operation details upon modal save.
     */
    $("#operation-form-save-btn").click(function (e) {
        e.preventDefault();
        let status = addOperation(root);
        if (status) {
        	saveAll(root, url, function() {
                location.reload();
            });
        }
    });
    
    /**
     * Deletes operation table entry and root entry upon delete.
     */
    $(document).on('click','#o-operation-table .fa-trash',function() {
    	let tds = $(this).closest("tr").find('td');
    	deleteOperation(root, tds[0].innerText);
    	$(this).closest("tr").remove();
    	saveAll(root, url, function() {
            location.reload();
        });
    });
    
    /**
     * Populates query parameters upon query id changes.
     */
    $('#o-addedit-queryid-select').change(function(e) {
    	e.preventDefault();
    	let queryid = $("#o-addedit-queryid-select").val(); 
    	populateOperationParamaterTable(root, queryid);
    });
    
    /**
     * Populates operation modal upon edit option.
     */
    $(document).on('click','#o-operation-table .fa-edit',function() {
    	let tds = $(this).closest("tr").find('td');
    	populateOperationForm(root, tds[0].innerText, tds[1].innerText);
    });
    
    // End of Operations

    //Resource related event handlers

    /**
     * Opens modal for adding a new resource
     */
    $("#r-resource-add-btn").click(function() {
    	populateQueriesListForResources("r-queries-item-table", "r-addedit-queryid-select", 1, root);
        openResourcesModal(false);
    });

    /**
     * Deletes specific resource.
     */
    $(document).on('click','#r-resources-table .fa-trash',function() {
    	let tds = $(this).closest("tr").data('id');
    	let method = $(this).closest("tr").find('td')[1].innerText;
    	//deleteOperation(root, tds[0].innerText);
    	deleteResource(root, tds, method);
    	$(this).closest("tr").remove();
    	saveAll(root, url, function() {
            location.reload();
        });
    });
    
    /**
     * Opens modal for editing specific resource.
     */
    $(document).on('click','#r-resources-table .fa-edit',function() {
        let resourceId = $(this).closest("tr").data('id');
        let method = $(this).closest("tr").find('td')[1].innerText;
        populateResourcesModal(root, resourceId, method);
        openResourcesModal(true);
    });

    /** End of Event handlers **/
});

/**
 * Populates the UI with general DSS data.
 *
 * @param root Document object.
 */
function populateGeneralDetails(root) {
    $('#dss-name-header').text(root.getElementsByTagName("data")[0].attributes.getNamedItem("name").value);

    let description = root.getElementsByTagName("description")[0];
    let namespace = root.getElementsByTagName("data")[0];

    if (description.hasChildNodes()) {
        $('#dss-description-input').val(description.childNodes[0].nodeValue);
    }

    if (namespace.hasChildNodes()) {
        $('#dss-namespace-input').val(namespace.attributes.getNamedItem("serviceNamespace").value);
    }
}

/**
 * Populates Transport settings data.
 *
 * @param root Document object.
 */
function populateTransportSettings(root) {
    let transports = root.getElementsByTagName("data")[0].attributes.getNamedItem("transports");
    let transportValues;

    if (transports !== undefined && transports !== null) {
        transportValues = transports.value.split(" ");
        transportValues.forEach(function (item, index) {
            item = item.trim();
            if (item == "http") {
                $('#ts-http-check').prop('checked', true);
            } else if (item == "https") {
                $('#ts-https-check').prop('checked', true);
            } else if (item == "local") {
                $('#ts-local-check').prop('checked', true);
            } else if (item == "jms") {
                $('#ts-jms-check').prop('checked', true);
            }
        });
    }
}

/**
 * Populated query details.
 *
 * @param root Document object.
 */
function populateQueries(root) {
    let queryConfigs = root.getElementsByTagName("query");

    if (queryConfigs.length == 0 || queryConfigs === undefined || queryConfigs === null)  {
        $("#q-queries-table").hide();
        showQueriesTableNotification("info", "No queries available. Click 'Add New' to create a new query.", 0);
        return;
    }
    
//    $.each(queryConfigs, function(index, query) {
//    	populateOueryOutputMappings(query);
//    });
}


/**
 * Opens the resource Add/Edit modal.
 *
 * @param isEditEnabled 'True' to open a data source in edit mode. 'False' to add a new data source.
 */
function openResourcesModal(isEditEnabled) {
    if (isEditEnabled) {
        $("#resource-modal-header").text("Edit Resource");
    } else {
        $("#resource-modal-header").text("Create Resource");
    }

    $("#r-resource-addedit-modal").modal('show');
}

/**
 * Shows an alert of a given type in the data source editor modal.
 *
 * @param type Type of the alert: success | info | warning | danger
 * @param message Message to be displayed.
 * @param interval Number of milliseconds before the notification disappears. If not provided or '0',
 * notification will stay forever.
 */
function showDSNotification(type, message, interval) {
    let alertHtml = "<div id='ds-notification-alert' class=\"alert " + "alert-" + type + "\"" + ">" + message + "</div>";
    $("#ds-notification-alert-holder").html(alertHtml);
    $("#ds-notification-alert").show();

    showAlert("ds-notification-alert", interval);
}

/**
 * Shows an alert of a given type in the data sources table.
 *
 * @param type Type of the alert: success | info | warning | danger
 * @param message Message to be displayed.
 * @param interval Number of milliseconds before the notification disappears. If not provided or '0',
 * notification will stay forever.
 */
function showDSTableNotification(type, message, interval) {
    let alertHtml = "<span><div id='ds-table-notification-alert' class=\"alert " + "alert-" + type + "\"" + ">" + message + "</div></span>";
    $("#ds-table-notification-alert-holder").html(alertHtml);
    $("#ds-table-notification-alert").show();

    showAlert("ds-table-notification-alert", interval);
}

/**
 * Shows an alert of a given type in the data sources table.
 *
 * @param type Type of the alert: success | info | warning | danger
 * @param message Message to be displayed.
 * @param interval Number of milliseconds before the notification disappears. If not provided or '0',
 * notification will stay forever.
 */
function showQueriesTableNotification(type, message, interval) {
    let alertHtml = "<span><div id='q-table-notification-alert' class=\"alert " + "alert-" + type + "\"" + ">" + message + "</div></span>";
    $("#q-table-notification-alert-holder").html(alertHtml);
    $("#q-table-notification-alert").show();

    showAlert("q-table-notification-alert", interval);
}

/**
 * Shows an alert of a given type in the resource table.
 *
 * @param type Type of the alert: success | info | warning | danger
 * @param message Message to be displayed.
 * @param interval Number of milliseconds before the notification disappears. If not provided or '0',
 * notification will stay forever.
 */
function showResourceTableNotification(type, message, interval) {
    let alertHtml = "<span><div id='resource-table-notification-alert' class=\"alert " + "alert-" + type + "\"" + ">" + message + "</div></span>";
    $("#resource-table-notification-alert-holder").html(alertHtml);
    $("#resource-table-notification-alert").show();

    showAlert("resource-table-notification-alert", interval);
}

/**
 * Shows an alert of a given type in the resource editor modal.
 *
 * @param type Type of the alert: success | info | warning | danger
 * @param message Message to be displayed.
 * @param interval Number of milliseconds before the notification disappears. If not provided or '0',
 * notification will stay forever.
 */
function showResourceNotification(type, message, interval) {
    let alertHtml = "<div id='resource-notification-alert' class=\"alert " + "alert-" + type + "\"" + ">" + message + "</div>";
    $("#resource-notification-alert-holder").html(alertHtml);
    $("#resource-notification-alert").show();

    showAlert("resource-notification-alert", interval);
}

/**
 * Shows a bootstrap alert for a given interval. If the interval is 0, it will be shown infinitely.
 *
 * @param selector ID of the alert.
 */
function showAlert(selector, interval) {
    if (interval > 0) {
        window.setTimeout(function () {
            $("#" + selector).fadeTo(500, 0).slideUp(500, function () {
                $(this).remove();
            });
        }, interval);
    }
}

/**
 * Creates and returns a new 'property' node.
 *
 * @param root Document object.
 * @param name Name of the property.
 * @returns {HTMLElement | any | ActiveX.IXMLDOMElement} Created node.
 */
function createPropertyNode(root, name) {
    let newNode = root.createElement("property");
    newNode.setAttribute("name", name);
    return newNode;
}

/**
 * Creates a text node in a given parent node.
 *
 * @param root Document object.
 * @param parentNode Parent Node.
 * @param textContent Text content.
 * @returns {*} Parent node object.
 */
function createTextNode(root, parentNode, textContent) {
    let newTextNode = root.createTextNode(textContent);
    parentNode.appendChild(newTextNode);
    return parentNode;
}

/**
 * Creates and returns a new 'with-param' node.
 *
 * @param root Document object.
 * @param name Name of the with param node.
 * @param queryParam queryParam property.
 * @returns {HTMLElement | any | ActiveX.IXMLDOMElement} Created node.
 */
function createWithParamNode(root, name, queryParam) {
    let newNode = root.createElement("with-param");
    newNode.setAttribute("name", name);
    newNode.setAttribute("query-param", queryParam);
    return newNode;
}

/**
 * Inserts a node after a given reference node.
 *
 * @param newNode New node.
 * @param refNode Reference node.
 */
function insertAfter(newNode, refNode) {
    refNode.parentNode.insertBefore(newNode, refNode.nextSibling);
}

/**
 * Replace a node with a given reference node.
 *
 * @param newNode New node.
 * @param refNode Reference node.
 */
function replaceNode(newNode, refNode) {
    refNode.replaceWith(newNode);
}

/**
 * This function sends the modified source to the back-end and invokes the save operation.
 *
 * @param root Document object.
 * @param url Back-end URL.
 * @param successFunc Success callback function.
 */
function saveAll(root, url, successFunc) {
    let serializedData = new XMLSerializer().serializeToString(root);

    let request = $.ajax({
        url: url,
        type: "post",
        headers: {"x-operation-type":OPERATION_TYPE_HEADER_SAVE_ALL},
        data: {content: serializedData},
        success: successFunc
    });
}


function resolveMetadata(metadata) {
    let dataPairs = metadata.split(",");
    let mdMap = new Map();

    for (i = 0; i < dataPairs.length; i++) {
        let tempArr = dataPairs[i].split(":");
        mdMap.set(tempArr[0], tempArr[1]);
    }

    return mdMap;
}
/**
 * Processes the add resources view.
 *
 * @param root Document object
 * @param editResource whether to edit the resource
 */
function addResource(root) {
    // Check if data source name already exists
    let resourceConfigs = root.getElementsByTagName("resource");
    let resourceId = $("#r-addedit-opname-input").val();
    let methodValue = $("#r-addedit-resourcemethod-select-original").val();
    let resourceMethod = $("#r-addedit-resourcemethod-select").val();
    let resourceIndex = -1;
    let editResource = false;
    let isValid = validateResourceFields(resourceId, resourceMethod);
    if (!isValid) {
    	showResourceNotification("danger",
		"Please complete all the required fields", 4000);
		return false;
    }

    // resource method is used here only to determine the current node
    // Actual serialized value is fetch in processResourceInputData function
    if (!(methodValue == null || methodValue.trim() == '')) {
    	resourceMethod = methodValue;
    }
    
    // Check whether 
    if ($("#resource-modal-header").text() == "Edit Resource") {
    	editResource = true;
    }

	for (let i = 0, len = resourceConfigs.length; i < len; i++) {
		if ((resourceConfigs[i].getAttribute("path") == resourceId)
				&& (resourceConfigs[i].getAttribute("method") == resourceMethod)) {
			if (editResource) {
				resourceIndex = i;
			} else {
				showResourceNotification("danger",
						"A resource with the given name already exists.", 4000);
				return false;
			}
		}
	}

    // Process the form
    let formData = $("#resource-form").find(':visible').serializeArray();
    let dataObj = {};

    $(formData).each(function(i, field){
        dataObj[field.name] = field.value;
    });

    processResourceInputData(root, dataObj, resourceIndex, editResource);

    return true;
}

/**
 * Populates the Resource modal when editing an existing resource.
 *
 * @param root Document root object.
 * @param resourceId resource ID.
 */
function populateResourcesModal(root, resourceId, method) {
	let resourceConfigs = root.getElementsByTagName("resource");
	$('#r-addedit-opname-input').val(resourceId);
    for (let i = 0, len = resourceConfigs.length; i < len; i++) {
        if ((resourceConfigs[i].getAttribute("path") == resourceId) && (resourceConfigs[i].getAttribute("method") == method)) {
			$('#r-addedit-resourcemethod-select').val(
					resourceConfigs[i].getAttribute("method"));
			$('#r-addedit-resourcemethod-select-original').val(
					resourceConfigs[i].getAttribute("method"));
			let queryName = resourceConfigs[i]
					.getElementsByTagName("call-query")[0].getAttribute("href");
			$('#r-addedit-queryid-select').val(queryName).trigger('change');
			let description = resourceConfigs[i]
					.getElementsByTagName("description")[0].textContent;
			$('#r-addedit-description-input').val(description);
			let returnRequest = resourceConfigs[i]
					.getAttribute("returnRequestStatus");
			if (returnRequest == "true") {
				$('#r-addedit-returnreqstatus-checkbox').prop("checked", true);
			} else {
				$('#r-addedit-returnreqstatus-checkbox').prop("checked", false);
			}
        }
    }
}

/**
 * Processes form input data of the create/edit resource form.
 * 
 * @param root
 *            Document root element.
 * @param data
 *            Form data in data['field-name'] format.
 * @param index
 *            index of the resource node
 */
function processResourceInputData(root, data, index, editResource) {
    let dataRoot = root.getElementsByTagName("data")[0];
    let resourceConfigs = root.getElementsByTagName("resource");

    let resourceMethod = $("#r-addedit-resourcemethod-select").val();
    let resourcePath = $("#r-addedit-opname-input").val();
    let queryID = $("#r-addedit-queryid-select").val();
    let description = $("#r-addedit-description-input").val();
    let returnRequest = $("#r-addedit-returnreqstatus-checkbox:checked").val() ? true : false;

    // Create a new config element
    let resourceElement = root.createElement("resource");
    resourceElement.setAttribute("method", resourceMethod);
    resourceElement.setAttribute("path", resourcePath);
    resourceElement.setAttribute("returnRequestStatus",returnRequest);

    let descriptionElement = root.createElement("description");
    descriptionElement.textContent = description;
    resourceElement.appendChild(descriptionElement);

    let callQueryElement = root.createElement("call-query");
    callQueryElement.setAttribute("href", queryID);
    resourceElement.appendChild(callQueryElement);

    let properties = [];

	var items=[];
	//Iterate all tr's in second column
	$('#resource-param-table tbody tr').each( function(){
	   //add item to array
	   var $tds = $(this).find('td');
	      var row = [];
	      $tds.each(function (i, el){
	        row.push($(this).text());
	      });
	   items.push(row);
	});

	//restrict array to unique items
	var items = $.unique( items );
    // Append properties to config node
    for (let i = 0, len = items.length; i < len; i++) {
    	properties.push(createWithParamNode(root, items[i][0], items[i][1]));
    }

    // Append properties to config node
    for (let i = 0, len = properties.length; i < len; i++) {
    	callQueryElement.appendChild(properties[i]);
    }

    if(editResource && index != -1) {
    	replaceNode(resourceElement, resourceConfigs[index]);
    }

    if (resourceConfigs.length > 0) {
		insertAfter(resourceElement,
				resourceConfigs[resourceConfigs.length - 1]);
	} else {
		dataRoot.appendChild(resourceElement);
	}
}

/**
 * Populate queries list for resources modal
 * 
 * @param tableId
 *            queries table element ID
 * @param selectId
 *            select element which should be populated
 * @param columnNo
 *            table's column number of the queryID column
 * @param root
 *            Document root element.
 */
function populateQueriesListForResources(tableId, selectId, columnNo, root) {
	var items=[], options=[];

	$('#'+selectId).find('option').remove();
	let option = new Option("-- Select Query --", "", true, "");
	$('#'+selectId).append(option);
	let queries = root.getElementsByTagName("query");
	for (let i = 0, len = queries.length; i < len; i++) {
		let name = queries[i].getAttribute("id");
		items.push(name);
	}

	//restrict array to unique items
	var items = $.unique( items );

	//iterate unique array and build array of select options
	$.each( items, function(i, item){
	    options.push('<option value="' + item + '">' + item + '</option>');
	})

	//finally empty the select and append the items from the array
	$('#'+selectId).append( options.join());

    $('#'+selectId).change(function(e) {
    	e.preventDefault();
    	let queryid = $('#'+selectId).val();
    	populateResourceParameterTable(root, queryid);
    });
    $('#'+selectId).trigger('change');
}

/**
 * Populates Data sources data.
 *
 * @param root Document object.
 */
function populateResources(root) {
    var resourceConfigs = root.getElementsByTagName("resource");

    if (resourceConfigs.length == 0 || resourceConfigs === undefined || resourceConfigs === null)  {
        $("#r-resources-table").hide();
        showResourceTableNotification("info", "No resources available. Click 'Add New' to create a new resource.", 0);
        return;
    }

    $("#r-resources-table").show();
    $("#r-resources-table tbody").empty();
    for (let i = 0, len = resourceConfigs.length; i < len; i++) {
        let resourceName = resourceConfigs[i].getAttribute("path");
        let method = resourceConfigs[i].getAttribute("method");
        let queryID = resourceConfigs[i].getElementsByTagName("call-query")[0].getAttribute("href");
        let markup = "<tr" + " data-id='" + resourceName + "'" + "><td>" + resourceName + "</td><td>" + method + "</td><td>" + queryID + "</td><td class='text-center'>" +
            "<i class='fa fa-edit'></i><i class='fa fa-trash'></i></td></tr>";

        $("#r-resources-table tbody").append(markup);
    }

    populateQueriesListForResources("r-queries-item-table", "r-addedit-queryid-select", 1, root);
}

/**
 * Function that deletes a specific node from the DOM tree.
 *
 * @param root Document root object.
 * @param resourceName resource name which should be deleted.
 */
function deleteResource(root, resourceName, method) {
    let resources = root.getElementsByTagName("resource");
    let deletables = [];
    for (let i = 0, len = resources.length; i < len; i++) {
        if ((resources[i].getAttribute("path") == resourceName) && (resources[i].getAttribute("method") == method)) {
            // Delete the node.
            deletables.push(resources[i]);
        }
    }

    for (let i = 0, len = deletables.length; i < len; i++) {
       root.documentElement.removeChild(deletables[i]);
    }

}

/**
 * Populates resource parameter table in resources modal upon query ID selection
 *
 * @param root Document root object.
 * @param queryId query name which should be deleted.
 */
function populateResourceParameterTable(root, queryId) {
    let queries = root.getElementsByTagName("query");
    let items = [];
    for (let i = 0, len = queries.length; i < len; i++) {
		if (queries[i].getAttribute("id") == queryId) {
			// Delete the node.
			let params = queries[i].getElementsByTagName("param");
			for (let j = 0, len = params.length; j < len; j++) {
				let paramName = params[j].getAttribute("name");
				items.push(paramName);
			}
		}
    }

    $("#resource-param-table tbody").empty();
    for (let i = 0, len = items.length; i < len; i++) {
        let markup = "<tr" + " data-id='" + items[i] + "'" + "><td>" + items[i] + "</td><td>" + items[i] + "</td></tr>";
        $("#resource-param-table tbody").append(markup);
    }
}

function validateResourceFields(resourcePath, methodValue) {
	if(resourcePath == null || resourcePath.trim() == '') {
		return false;
	} else if (methodValue == null || methodValue.trim() == 'select') {
		return false;
	}
	return true;
}
