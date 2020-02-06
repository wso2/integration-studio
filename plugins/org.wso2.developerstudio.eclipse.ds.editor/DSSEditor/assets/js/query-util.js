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

/**
 * Populates Datasource select with existing data sources.
 *
 * @param root Document object.
 */
function populateDSListForQueries(root) {
    let datasources = root.getElementsByTagName("config");
    var items = [], options = [];

    $('#q-datasource-select').find("option").remove();
    let option = new Option("- Select Datasource -", "", true, true);
    $('#q-datasource-select').append(option);

    for (let i = 0, len = datasources.length; i < len; i++) {
        let name = datasources[i].getAttribute("id");
        items.push(name);
    }

    items = $.unique(items);

    $.each( items, function(i, item){
        options.push('<option value="' + item + '">' + item + '</option>');
    })

    $('#q-datasource-select').append(options.join());

    // $('#' + selectId).change(function(e) {
    //     e.preventDefault();
    //     let queryid = $('#' + selectId).val();
    //     populateResourceParameterTable(root, queryid);
    // });
    //
    // $('#' + selectId).trigger('change');
}

/**
 * Populates the input mappings table in Queries view.
 *
 * @param root Document object.
 */
function populateInputMappingsTable(root, queryId) {
    let queries = root.getElementsByTagName("query");

    if (queries.length == 0 || queries === undefined || queries === null)  {
        $("#inputMappingTable").hide();
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
 * Shows an alert of a given type in the input mappings table.
 *
 * @param type Type of the alert: success | info | warning | danger
 * @param message Message to be displayed.
 * @param interval Number of milliseconds before the notification disappears. If not provided or '0',
 * notification will stay forever.
 */
function showInputMappingsTableNotification(type, message, interval) {
    let alertHtml = "<span><div id='q-im-table-notification-alert' class=\"alert " + "alert-" + type + "\"" + ">" + message + "</div></span>";
    $("#q-im-table-notification-alert-holder").html(alertHtml);
    $("#q-im-table-notification-alert").show();

    showAlert("q-im-table-notification-alert", interval);
}

/**
 * Creates a new input mapping configuration.
 * @param root Document root.
 * @returns {boolean} 'True' if successful, 'False' otherwise.
 */
function addInputMapping(root) {
    // Extract form data
    let formData = $("#input-mapping-form").find(':visible').serializeArray();
    let dataObj = {};
    let paramElement = root.createElement("param");

    $(formData).each(function(i, field){
        dataObj[field.name] = field.value;
    });

    paramElement.setAttribute("name", dataObj["im-mappingname-input"]);
    paramElement.setAttribute("paramType", dataObj["q-im-paramtype-select"]);
    paramElement.setAttribute("sqlType", dataObj["q-im-sqltype-select"]);
    paramElement.setAttribute("defaultValue", dataObj["im-defaultvalue-input"]);
    paramElement.setAttribute("type", dataObj["q-im-inout-select"]);
    paramElement.setAttribute("ordinal", dataObj["im-ordinal-input"]);

    return true;
}