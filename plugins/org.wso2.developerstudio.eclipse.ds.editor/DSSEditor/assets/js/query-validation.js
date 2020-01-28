$('#query-add-close-btn').click(function() {
	clearAddQueryForm();
	$("#q-query-add-btn").toggle(true);
    $("#q-queries-table").toggle(true);
    $("#q-add-edit-query-section").toggle(false);
});

$('#query-add-save-btn').click(function() {
	console.log("save");
});

function clearAddQueryForm() {
	$('#q-query-id-input').val("");
	$('#q-datasource-select').val("");
	clearOutputMappingForm();
}