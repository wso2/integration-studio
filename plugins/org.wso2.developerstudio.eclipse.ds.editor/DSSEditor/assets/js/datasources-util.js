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
        $("#ds-ds-id-input").prop('disabled', false);
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
 * @param metadata Data source metadata.
 */
function populateDSModal(root, dsId, metadata) {
    let dataMap = resolveMetadata(metadata);

    let dsType = dataMap.get(DS_METADATA_DS_TYPE);
    let rdbmsType = dataMap.get(DS_METADATA_RDBMS_TYPE);
    let dbEngine = dataMap.get(DS_METADATA_DB_ENGINE);

    let dsConfigs = root.getElementsByTagName("config");

    for (let i = 0, len = dsConfigs.length; i < len; i++) {
        let config = dsConfigs[i];
        if (config.attributes.getNamedItem("id").value == dsId) {
            let properties = config.getElementsByTagName("property");

            // Populate data source ID
            $("#ds-ds-id-input").val(dsId);
            $("#ds-ds-id-input").prop('disabled', true);

            if (dsType == DS_TYPE_RDBMS) {
                $("#ds-dstype-select").val(DS_TYPE_RDBMS);
                setVisibleDSTypeRDBMS(true);

                if (rdbmsType == RDBMS_TYPE_DEFAULT) {
                    $("#ds-dstype-2-select").val(RDBMS_TYPE_DEFAULT);
                    setVisibleDSType2Default(true);

                    // driver class
                    let driverClass = getDSConfigPropertyValue(properties, "driverClassName");
                    if (driverClass != null && driverClass != undefined) {
                        $("#ds-driver-class-input").val(driverClass);
                    }
                    // url
                    let url = getDSConfigPropertyValue(properties, "url");
                    if (url != null && url != undefined) {
                        $("#ds-url-input").val(url);
                    }
                    // username
                    let username = getDSConfigPropertyValue(properties, "username");
                    if (username != null && username != undefined) {
                        $("#ds-username-input").val(username);
                    }
                    // password
                    let password = getDSConfigPropertyValue(properties, "password");
                    if (password != null && password != undefined) {
                        $("#ds-password-input").val(password);
                    }

                } else if (rdbmsType == RDBMS_TYPE_EXTERNAL) {
                    $("#ds-dstype-2-select").val(RDBMS_TYPE_EXTERNAL);
                    if (dbEngine == DB_ENGINE_MYSQL) {
                        $("#ds-db-engine-select").val(DB_ENGINE_MYSQL);
                    }
                    setVisibleDSType2Ext(true);

                    // datasource class name
                }
            } else if (dsType == DS_TYPE_CARBONDS) {
                $("#ds-dstype-select").val(DS_TYPE_CARBONDS);
                setVisibleDSTypeRDBMS(false);
                setVisibleDSTypeCarbon(true);

                // datasource name
                let carbonDSName = getDSConfigPropertyValue(properties, "carbon_datasource_name");
                if (carbonDSName != null && carbonDSName != undefined) {
                    $("#ds-ds-name-input").val(carbonDSName);
                }
            }
        }
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
        if (dsConfigs[i].id == datasourceId && !$("#ds-ds-id-input").prop('disabled')) {
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

    let metadata = processDSInputData(root, dataObj, true);

    return {
        status: true,
        metadata: metadata
    }
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

    let dsType = $("#ds-dstype-select").val();
    let dbTypeExt = $("#ds-dstype-2-select").val();
    let dsId = $("#ds-ds-id-input").val();
    let dbEngine = $("#ds-db-engine-select").val();

    // Delete if existing config node exists
    if (deleteIfExists) {
        for (let i = 0, len = dsConfigs.length; i < len; i++) {
            if (dsConfigs[i].id == dsId) {
                // Delete the node.
                root.documentElement.removeChild(dsConfigs[i]);
            }
        }
    }

    // Create a new config element
    let configElement = root.createElement("config");
    configElement.setAttribute("id", dsId);

    let properties = [];

    if (dsType === "rdbms_ds") {
        if (dbTypeExt === "default_ds") {
            properties.push(createTextNode(root, createPropertyNode(root, "driverClassName"), data['ds-driver-class-input']));
            properties.push(createTextNode(root, createPropertyNode(root, "url"), data['ds-url-input']));
            properties.push(createTextNode(root, createPropertyNode(root, "username"), data['ds-username-input']));
            properties.push(createTextNode(root, createPropertyNode(root, "password"), data['ds-password-input']));
        }

        if (dbTypeExt === "external_ds") {
            properties.push(createTextNode(root, createPropertyNode(root, "dataSourceClassName"), data['ds-class-name-input']));
        }
    } else if (dsType === "carbon_ds") {
        properties.push(createTextNode(root, createPropertyNode(root, "carbon_datasource_name"), data['ds-ds-name-input']));
    }

    // Append properties to config node
    for (let i = 0, len = properties.length; i < len; i++) {
        configElement.appendChild(properties[i]);
    }

    // OData enabled
    configElement.setAttribute("enableOData", $('#ds-enable-odata-check').is(":checked"));

    if (root.getElementsByTagName("config").length > 0) {
        insertAfter(configElement, dsConfigs[dsConfigs.length - 1]);
    } else {
        dataRoot.appendChild(configElement);
    }

    // Save data source metadata
    let dsMetadataStr = dsId + DS_METADATA_ID_SEPARATOR + DS_METADATA_DS_TYPE + DS_METADATA_KEYVALUE_SEPARATOR +
        dsType + DS_METADATA_SEPARATOR + DS_METADATA_RDBMS_TYPE + DS_METADATA_KEYVALUE_SEPARATOR + dbTypeExt +
        DS_METADATA_SEPARATOR + DS_METADATA_DB_ENGINE + DS_METADATA_KEYVALUE_SEPARATOR + dbEngine;

    return dsMetadataStr;
}

/**
 * This function sends the modified source to the back-end and invokes the save operation.
 *
 * @param root Document object.
 * @param url Back-end URL.
 */
function saveDSMetadata(metadata, url) {
    let request = $.ajax({
        url: url,
        type: "post",
        headers: {"x-operation-type":HEADER_VALUE_SAVE_DS_METADATA},
        data: {xmlcontent: metadata},
        success: function () {
            location.reload();
        }
    });
}

/**
 * This function retrieved metadata for a specific data source from the backend.
 *
 * @param datasourceId Data source ID.
 * @param url Backend URL.
 * @returns response
 */
function retrieveDSMetadata(datasourceId, url) {
    let metadata = "";

    // Synchronous request
    let response = $.ajax({
        url: url,
        type: "post",
        async: false,
        headers: {"x-operation-type":HEADER_VALUE_RETRIEVE_DS_METADATA},
        data: {xmlcontent: datasourceId},
        success: function (msg, status, jqXHR) {
            metadata = msg.toString();
        }
    });

    return metadata;
}

/**
 * This function resolved metadata into a key-value map.
 *
 * @param metadata Metadata string.
 * @returns {Map<any, any>} A map containing metadata.
 */
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
 * Returns the value of a property in a datasource config element.
 *
 * @param propertyArr Property array.
 * @param propertyName  Property name.
 * @returns {string|string | string}    Property value if exists, empty string otherwise.
 */
function getDSConfigPropertyValue(propertyArr, propertyName) {
    for (let i = 0, len = propertyArr.length; i < len; i++) {
        let property = propertyArr[i];
        let propName = property.attributes.getNamedItem("name").value;

        if (propName == propertyName) {
            return property.textContent;
        }
    }

    return "";
}

function resetDSAddEditModal() {
    setVisibleDSTypeRDBMS(true);
    setVisibleDSTypeCarbon(false);
}
