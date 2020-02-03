/**
 * Populates Query data.
 *
 * @param root Document object.
 */
function populateQueryTable(root) {
    let queryConfigs = root.getElementsByTagName("query");

    if (queryConfigs.length == 0 || queryConfigs === undefined || queryConfigs === null)  {
        $("#q-queries-table").hide();
        showQueriesTableNotification("info", "No queries available. Click 'Add New' to create a new query.", 0);
        return;
    }

    $("#q-queries-table").show();

    for (let i = 0, len = queryConfigs.length; i < len; i++) {
        let queryId = queryConfigs[i].id;

        let markup = "<tr" + " data-id='" + queryId + "'" + "><td>" + queryId + "</td>" +
            "<td class=\"text-center\"><i class=\"fa fa-edit\"></i><i class=\"fa fa-trash\"></i></td>" + "</tr>";

        $("#q-queries-table tbody").append(markup);
    }

}