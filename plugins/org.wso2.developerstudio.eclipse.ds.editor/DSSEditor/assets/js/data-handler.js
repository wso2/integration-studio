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
        let status = addDataSource(root);

        if (status) {
            $("#ds-add-edit-ds-modal").modal('hide');
            save(root, url);
s
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
    });

    $("#ds-datasource-add-btn").click(function() {
        console.log(root);
        openDSModal(false);
    });

    $(document).on('click','#ds-datasources-table .fa-trash',function() {
        let dsId = $(this).closest("tr").data('id');
        deleteDatasource(root, dsId);
        $(this).closest("tr").remove();
        save(root, url);
    });

    $(document).on('click','#ds-datasources-table .fa-edit',function() {
        let dsId = $(this).closest("tr").data('id');
        populateDSModal(root, dsId);
        openDSModal(true);
    });
    // End of Data sources - Add data source

    // Start of queries - Add query
    $("#q-query-add-btn").click(function() {
        $("#q-query-add-btn").toggle(false);
        $("#q-queries-table").toggle(false);
        $("#q-add-edit-query-section").toggle(true);
    });
    // End of queries - Add query

    // Start of input event handlers - General details
    $("#dss-description-input, #dss-namespace-input").change(function() {
        let description = root.getElementsByTagName("description")[0];

        if (description.hasChildNodes()) {
            description.childNodes[0].nodeValue = $('#dss-description-input').val();
        } else {

        }

        save(root, url);
    });

    $("#dss-namespace-input").change(function() {
        save(root, url);
    });
    // End of input event handlers - General details
    /** End of Event handlers **/
    
    // Start of Operations
    
    /**
     * Populates query elements and set enableStreaming upon operation modal opening.
     */
    $('#o-operation-add-btn').click(function() {
    	populateQueriesForOperationForm(root);
    	$('#o-addedit-enablestreaming-checkbox').prop("checked", true);
    });
    
    /**
     * Updates root content with operation details upon modal save.
     */
    $("#operation-form-save-btn").click(function (e) {
        e.preventDefault();
        addOperation(root);
    });
    
    /**
     * Deletes operation table entry and root entry upon delete.
     */
    $(document).on('click','#o-operation-table .fa-trash',function() {
    	let tds = $(this).closest("tr").find('td');
    	deleteOperation(root, tds[0].innerText);
    	$(this).closest("tr").remove();
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
 * Populates Data sources data.
 *
 * @param root Document object.
 */
function populateDataSources(root) {
    let dsConfigs = root.getElementsByTagName("config");

    if (dsConfigs.length == 0 || dsConfigs === undefined || dsConfigs === null)  {
        $("#ds-datasources-table").hide();
        showDSTableNotification("info", "No data sources available. Click 'Add New' to create a new data source.", 0);
        return;
    }

    $("#ds-datasources-table").show();

    for (let i = 0, len = dsConfigs.length; i < len; i++) {
        let dsName = dsConfigs[i].id;
        let markup = "<tr" + " data-id='" + dsName + "'" + "><td>" + dsName + "</td><td class='text-center'>" +
            "<i class='fa fa-edit'></i><i class='fa fa-trash'></i></td></tr>";

        $("#ds-datasources-table tbody").append(markup);
    }

}

/**
 * Populates the data source modal when editing an existing data source.
 * @param root Document root object.
 * @param dsId Data source ID.
 */
function populateDSModal(root, dsId) {

}

function populateQueries(root) {
    let queryConfigs = root.getElementsByTagName("query2");

    if (queryConfigs.length == 0 || queryConfigs === undefined || queryConfigs === null)  {
        $("#q-queries-table").hide();
        showQueriesTableNotification("info", "No queries available. Click 'Add New' to create a new query.", 0);
        return;
    }
}

/**
 * Processes the add data source view.
 *
 * @param root Document object
 */
function addDataSource(root) {
    // Check if data source name already exists
    let dsConfigs = root.getElementsByTagName("config");
    let datasourceId = $("#ds-ds-id-input").val();

    for (let i = 0, len = dsConfigs.length; i < len; i++) {
        if (dsConfigs[i].id == datasourceId) {
            showDSNotification("danger", "A data source with the given name already exists.", 4000);
            return false;
        }
    }

    // Process the form
    let formData = $("#create-ds-form").find(':visible').serializeArray();
    let dataObj = {};

    $(formData).each(function(i, field){
        dataObj[field.name] = field.value;
    });

    processDSInputData(root, dataObj, true);

    return true;
}

/**
 * Processes form input data of the create/edit data source form.
 *
 * @param root Document root element.
 * @param data Form data in data['field-name'] format.
 * @param deleteIfExists Delete the config node if exists already.
 */
function processDSInputData(root, data, deleteIfExists) {
    let dataRoot = root.getElementsByTagName("data")[0];
    let dsConfigs = root.getElementsByTagName("config");

    let rdbmsType = $("#ds-dstype-select").val();
    let dbTypeExt = $("#ds-dstype-2-select").val();
    let dsId = $("#ds-ds-id-input").val();

    // Delete if existing config node exists
    if (deleteIfExists) {
        for (let i = 0, len = dsConfigs.length; i < len; i++) {
            if (dsConfigs[i].id == dsId) {
                // Delete the node.
                root.documentElement.removeChild(dsConfigs[i]);
                return;
            }
        }
    }

    // Create a new config element
    let configElement = root.createElement("config");
    configElement.setAttribute("id", dsId);

    let properties = [];

    if (rdbmsType === "rdbms_ds") {
        if (dbTypeExt === "default_ds") {
            properties.push(createTextNode(root, createPropertyNode(root, "driverClassName"), data['ds-driver-class-input']));
            properties.push(createTextNode(root, createPropertyNode(root, "url"), data['ds-url-input']));
            properties.push(createTextNode(root, createPropertyNode(root, "username"), data['ds-username-input']));
            properties.push(createTextNode(root, createPropertyNode(root, "password"), data['ds-password-input']));
        }

        if (dbTypeExt === "external_ds") {
            properties.push(createTextNode(root, createPropertyNode(root, "dataSourceClassName"), data['ds-class-name-input']));
        }
    } else if (rdbmsType === "carbon_ds") {
        properties.push(createTextNode(root, createPropertyNode(root, "carbon_datasource_name"), data['ds-ds-name-input']));
    }

    // Append properties to config node
    for (let i = 0, len = properties.length; i < len; i++) {
        configElement.appendChild(properties[i]);
    }

    // OData enabled
    configElement.setAttribute("enableOData", $('#ds-enable-odata-check').is(":checked"));

    if (dsConfigs.length > 0) {
        insertAfter(configElement, dsConfigs[dsConfigs.length - 1]);
    } else {
        dataRoot.appendChild(configElement);
    }

}

/**
 * Opens the data sources Add/Edit modal.
 *
 * @param isEditEnabled 'True' to open a data source in edit mode. 'False' to add a new data source.
 */
function openDSModal(isEditEnabled) {
    if (isEditEnabled) {
        $("#ds-modal-header").text("Edit Datasource");
    } else {
        $("#ds-modal-header").text("Create Datasource");
    }

    $("#ds-add-edit-ds-modal").modal('show');
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
 * Inserts a node after a given reference node.
 *
 * @param newNode New node.
 * @param refNode Reference node.
 */
function insertAfter(newNode, refNode) {
    refNode.parentNode.insertBefore(newNode, refNode.nextSibling);
}

/**
 * This function sends the modified source to the back-end and invokes the save operation.
 *
 * @param root Document object.
 * @param url Back-end URL.
 * @returns Status code
 */
function save(root, url) {
    let serializedData = new XMLSerializer().serializeToString(root);
    console.log(serializedData);

    let request = $.ajax({
        url: url,
        type: "post",
        headers: {"x-operation-type":OPERATION_TYPE_HEADER_SAVE_ALL},
        data: {xmlcontent: serializedData},
        success: function (resData) {
            location.reload();
        }
    });

    return request;
}

/**
 * Processes the add operation.
 *
 * @param root Document object
 */
function addOperation(root) {
    // Check if operation name already exists
    let operations = root.getElementsByTagName("operation");
    let new_operation_name = $("#o-addedit-opname-input").val();
    
    for (let i = 0, len = operations.length; i < len; i++) {
        if (operations[i].attributes.getNamedItem("name").value == new_operation_name) {
        	showOperationNotification("danger", "An operation with the given name already exists.", 4000);
            return false;
        }
    }

    // Process operation modal data
    let formData = $("#operation-form").find(':visible').serializeArray();
    let dataObj = {};

    $(formData).each(function(i, field){
        dataObj[field.name] = field.value;
    });

    processOperationInputData(root, dataObj, true);
    return true;
}

/**
 * Shows an alert of a given type in the operation editor modal.
 *
 * @param type Type of the alert: success | info | warning | danger
 * @param message Message to be displayed.
 * @param interval Number of milliseconds before the notification disappears. If not provided or '0',
 * notification will stay forever.
 */
function showOperationNotification(type, message, interval) {
    let alertHtml = "<div id='operation-notification-alert' class=\"alert " + "alert-" + type + "\"" + ">" + message + "</div>";
    $("#operation-notification-alert-holder").html(alertHtml);
    $("#operation-notification-alert").show();

    if (interval > 0) {
        window.setTimeout(function () {
            $("#operation-notification-alert").fadeTo(500, 0).slideUp(500, function() {
                $(this).remove();
            });
        }, interval);
    }
}

/**
 * Processes form input data of the create/edit operation form.
 *
 * @param root Document root element.
 * @param data Form data in data['field-name'] format.
 * @param deleteIfExists Delete the operation node if exists already.
 */
function processOperationInputData(root, data, deleteIfExists) {
    let dataRoot = root.getElementsByTagName("data")[0];
    let operations = root.getElementsByTagName("operation");
    let new_operation_name = $("#o-addedit-opname-input").val();

    // Deletes if operation node exists
    if (deleteIfExists) {
        for (let i = 0, len = operations.length; i < len; i++) {
            if (operations[i].name == new_operation_name) {
                // Delete the node.
                root.documentElement.removeChild(operations[i]);
                return;
            }
        }
    }

    // Creates a new operation element
    let operationElement = root.createElement("operation");
    operationElement.setAttribute("name", new_operation_name);
    
    //Creates description element
    let description = $('#o-addedit-description-input').val();
    let descriptionElement = root.createElement("description");
    let text_node = root.createTextNode(description);
    descriptionElement.appendChild(text_node);
    operationElement.appendChild(descriptionElement);
    
    //Creates a new call-query element
    let callqueryElement = root.createElement("call-query");
    let query_id = $('#o-addedit-queryid-select').val();
    callqueryElement.setAttribute("href", query_id);
    
    //Creates with-param elements
    let op_parameters = $('#operation-param-table > tbody').find('tr');
    $.each(op_parameters, function(index, op_parameter) {
		let withparamElement = root.createElement("with-param");
		withparamElement.setAttribute("name", op_parameter.cells[0].firstChild.value);
		withparamElement.setAttribute("query-param", op_parameter.cells[1].firstChild.value);
		callqueryElement.appendChild(withparamElement);
	});
    
    //Creates Enable Stream element
    if (!$('#o-addedit-enablestreaming-checkbox').is(":checked")) {
    	operationElement.setAttribute("disableStreaming", true);
    }
    
    //Creates Return request status element
    if ($('#o-addedit-returnreqstatus-checkbox').is(":checked")) {
    	operationElement.setAttribute("returnRequestStatus", true);
    }
    
    operationElement.appendChild(callqueryElement);
    
    //Appends to operations table
    dataRoot.appendChild(operationElement);
        
    //Adds a row to operations table
    let op_row = '<tr><td>' + new_operation_name + '</td><td>' + query_id + '</td><td class="text-center"><i class="fa fa-edit"></i><i class="fa fa-trash"></i></td></tr>';
	$('#o-operation-table > tbody').append(op_row);
	$('#o-operation-addedit-modal').removeClass('show');
	$('.modal-backdrop.fade.show').removeClass('show');
	clearOperationForm();
}

/**
 * Populates operation modal data.
 * 
 * @param root Root document
 * @param operation_name Operation name
 * @param query_name Query id
 */
function populateOperationForm(root, operation_name, query_name) {
	let operations = root.getElementsByTagName("operation");
	
	$.each(operations, function (index, op) {
		let op_name = op.attributes.getNamedItem("name").value;
		
		if (op_name == operation_name) {
			let call_query = op.getElementsByTagName('call-query');
			let q_id = call_query[0].attributes.getNamedItem("href").value;
			
			if (q_id == query_name) {
				$('#o-addedit-opname-input').val(op_name);
				$('#o-addedit-description-input').val(op.getElementsByTagName('description')[0].textContent);
				populateQueriesForOperationForm(root);
				$('#o-addedit-queryid-select').val(q_id);
				populateOperationParamaterTable(root, q_id);
				
				let disableStreaming = op.attributes.getNamedItem("disableStreaming").value;
				if (disableStreaming == "true") {
					$('#o-addedit-enablestreaming-checkbox').prop( "checked", false );
				} else {
					$('#o-addedit-enablestreaming-checkbox').prop( "checked", true );
				}
				
				let returnRequestStatus = op.attributes.getNamedItem("returnRequestStatus").value;
				if (returnRequestStatus == "true") {
					$('#o-addedit-returnreqstatus-checkbox').prop( "checked", true );
				} else {
					$('#o-addedit-returnreqstatus-checkbox').prop( "checked", false );
				}
				
				$("#o-operation-addedit-modal").modal('show');
			}
		}
	});
}

/**
 * Populates operation entries to operations table.
 * 
 * @param root Root document
 */
function populateOperations(root) {
	$('#o-operation-table').find('tbody').find('tr').detach();
	let operations = root.getElementsByTagName("operation");
	
	$.each(operations, function (index, op) {
		let op_name = op.attributes.getNamedItem("name").value;
		let call_query = op.getElementsByTagName('call-query');
		let q_id = call_query[0].attributes.getNamedItem("href").value;
		let op_row = '<tr><td>' + op_name + '</td><td>' + q_id + '</td><td class="text-center"><i class="fa fa-edit"></i><i class="fa fa-trash"></i></td></tr>';
		$('#o-operation-table > tbody').append(op_row);
	});
}

/**
 * Populates query list.
 * 
 * @param root Root document
 */
function populateQueriesForOperationForm(root) {
	let select = $('#o-addedit-queryid-select');
	select.find("option").detach();
	let option = new Option("-- Select Query --", "", true, "");
	select.append(option);
	let queries = root.getElementsByTagName("query");
	
	$.each(queries, function (index, query) {
		let query_id = query.attributes.getNamedItem("id").value;
		select.append(new Option(query_id));
	});
}

/**
 * Populates operation parameters table.
 * 
 * @param root Root document
 * @param queryid Query id
 */
function populateOperationParamaterTable(root, queryid) {
		
	$('#operation-param-table').find('tbody').find('tr').detach();
	$('#o-addedit-returnreqstatus-checkbox').prop("checked", false);
	
	if (queryid != "") {
		$('#operation-query-param-area').toggle(true);
		$('#op-table').collapse("show");
    	
    	let queries = root.getElementsByTagName("query");
    	for (let i = 0, len = queries.length; i < len; i++) {
    		var query_id = queries[i].attributes.getNamedItem("id").value;
    		
    		if (queryid == query_id) {
    			let params = queries[i].getElementsByTagName("param");
    			
            	if (params.length > 0) {
            		$('#returnreqstatus-area').toggle(true);
            	} else {
            		$('#returnreqstatus-area').toggle(false);
            		$('#o-addedit-returnreqstatus-checkbox').prop("checked", false);
            	}
            	
        		$.each(params, function (i, param) {
        			let param_name = param.attributes.getNamedItem("name").value;
        			let row = "<tr><td><input type='text' placeholder='Query param name' class='form-control' value='" + param_name 
        				+ "' style='width: 100%;' /></td><td><input type='text' placeholder='Operation param name' value='" + param_name 
        				+ "' class='form-control' style='width: 100%;'/></td><td class='text-center'><i class='fa fa-trash'></i></td></tr>";
        			$('#operation-param-table > tbody').append(row);
        			
        		});
    		}
    	}	
	} else {
		$('#operation-query-param-area').toggle(false);
		$('#returnreqstatus-area').toggle(false);
	}
}
