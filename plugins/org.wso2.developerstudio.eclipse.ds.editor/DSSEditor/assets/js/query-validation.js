$('#query-add-close-btn').click(function() {
	clearAddQueryForm();
	$("#q-query-add-btn").toggle(true);
    $("#q-queries-table").toggle(true);
    $("#q-add-edit-query-section").toggle(false);
});

function clearAddQueryForm() {
	$('#q-query-id-input').val("");
	$('#q-datasource-select').val("");
	clearOutputMappingForm();
}

/**
 * Shows an alert of a given type in the query editor modal.
 *
 * @param type Type of the alert: success | info | warning | danger
 * @param message Message to be displayed.
 * @param interval Number of milliseconds before the notification disappears. If not provided or '0',
 * notification will stay forever.
 */
function showQueryNotification(type, message, interval) {
    let alertHtml = "<div id='query-notification-alert' class=\"alert " + "alert-" + type + "\"" + ">" + message + "</div>";
    $("#query-notification-alert-holder").html(alertHtml);
    $("#query-notification-alert").show();

    if (interval > 0) {
        window.setTimeout(function () {
            $("#query-notification-alert").fadeTo(500, 0).slideUp(500, function() {
                $(this).remove();
            });
        }, interval);
    }
}
