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