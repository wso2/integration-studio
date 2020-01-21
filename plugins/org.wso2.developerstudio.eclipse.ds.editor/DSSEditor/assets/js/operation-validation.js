/**
 * Set up elements for operations modal while initializing.
 */
$(document).ready(function() {
    $('#operation-query-param-area').toggle(false);
    $('#returnreqstatus-area').toggle(false);
    $('#o-addedit-enablestreaming-checkbox').prop("checked", true);
});

/**
 * Adds an empty table row upon button click on adding new operation parameters.
 */
$("#op-param-add-btn").click(function() {
	let param_row = "<tr><td><input type='text' placeholder='Query param name' class='form-control' style='width: 100%;' /></td><td><input type='text' " 
		+ "placeholder='Operation param name' class='form-control' style='width: 100%;'/></td><td class='text-center'><i class='fa fa-trash'></i></td></tr>";
    $("#operation-param-table > tbody").append(param_row);
});

/**
 * Clears operation modal upon cancel.
 * 
 * @param e Error
 */
$('#operation-form-close-btn').click(function (e) {
	clearOperationForm();
});

/**
 * Removes operation parameter row upon delete.
 */
$(document).on('click', '#operation-param-table .fa-trash', function() {
    $(this).closest("tr").remove();
});

/**
 * Function that clears operation modal.
 */
function clearOperationForm() {
	$("#o-addedit-opname-input").val("");
	$('#o-addedit-description-input').val("");
	$('#operation-param-table').find('tbody').find('tr').detach();
	$('#op-table').collapse("hide");
	$('#operation-query-param-area').toggle(false);
}

/**
 * Function that deletes a specific node from the DOM tree.
 *
 * @param root Document root object.
 * @param operationName Operation name which should be deleted.
 */
function deleteOperation(root, operationName) {
    let operations = root.getElementsByTagName("operation");
    for (let i = 0, len = operations.length; i < len; i++) {
        if (operations[i].name == operationName) {
            // Delete the node.
            root.documentElement.removeChild(operations[i]);
        }
    }
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
        	showOperationNotification("warning", "An operation with the given name will be updated.", 4000);
        	let trs = $('#o-operation-table').find('tr');
        	for (let i = 0; i < trs.length; i++) {
        		if (new_operation_name == trs[i].cells[0].firstChild.textContent) {
        			trs[i].remove();
        		}
        	}
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
				if (op.getElementsByTagName('description')[0] != null && op.getElementsByTagName('description')[0] != undefined) {
					$('#o-addedit-description-input').val(op.getElementsByTagName('description')[0].textContent);
				}
				populateQueriesForOperationForm(root);
				
				$('#o-addedit-queryid-select').val(q_id);
				populateWithParams(call_query[0]);
				
				let disableStreaming = op.attributes.getNamedItem("disableStreaming");
				if (disableStreaming != null && disableStreaming.value == "true") {
					$('#o-addedit-enablestreaming-checkbox').prop("checked", false);
				} else {
					$('#o-addedit-enablestreaming-checkbox').prop("checked", true);
				}
				
				let returnRequestStatus = op.attributes.getNamedItem("returnRequestStatus");
				if (returnRequestStatus != null && returnRequestStatus == "true") {
					$('#o-addedit-returnreqstatus-checkbox').prop("checked", true);
				} else {
					$('#o-addedit-returnreqstatus-checkbox').prop("checked", false);
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

/**
 * Populates with-params to operation parameters table.
 * 
 * @param op Operation element
 */
function populateWithParams(callQuery) {
		
	$('#operation-param-table').find('tbody').find('tr').detach();
	$('#o-addedit-returnreqstatus-checkbox').prop("checked", false);
	
	$('#operation-query-param-area').toggle(true);
	$('#op-table').collapse("show");
    	
    let params = callQuery.getElementsByTagName("with-param");
    
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