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
        $("#ds-table-notification-alert-holder").show();
        showDSTableNotification("info", "No data sources available. Click 'Add New' to create a new data source.", 0);
        return;
    }

    $("#ds-datasources-table").show();
    $("#ds-table-notification-alert-holder").hide();
    $("#ds-datasources-table tbody tr").remove();
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
            $("#ds-ds-id-input").val(dsId.trim());
            $("#ds-ds-id-input").prop('disabled', true);

            if (dsType === DS_TYPE_RDBMS) {
                $("#ds-dstype-select").val(DS_TYPE_RDBMS);
                setVisibleDSTypeRDBMS(true);

                if (rdbmsType === RDBMS_TYPE_DEFAULT) {
                    $("#ds-dstype-2-select").val(RDBMS_TYPE_DEFAULT);
                    setVisibleDSType2Default(true);
                    setVisibleDSType2Ext(false);

                    // driver class
                    let driverClass = getDSConfigPropertyValue(properties, "driverClassName");
                    if (driverClass === "") {
                        driverClass = getDSConfigPropertyValue(properties, "org.wso2.ws.dataservice.driver");
                    }

                    if (driverClass) {
                        $("#ds-driver-class-input").val(driverClass.trim());
                    }

                    // url
                    let url = getDSConfigPropertyValue(properties, "url");
                    if (url === "") {
                        url = getDSConfigPropertyValue(properties, "org.wso2.ws.dataservice.protocol");
                    }

                    if (url != null && url != undefined) {
                        $("#ds-url-input").val(url.trim());
                    }

                    // username
                    let username = getDSConfigPropertyValue(properties, "username");
                    if (username === "") {
                        username = getDSConfigPropertyValue(properties, "org.wso2.ws.dataservice.user");
                    }

                    if (username != null && username != undefined) {
                        $("#ds-username-input").val(username.trim());
                    }

                    // password
                    let password = "";
                    let secretAlias = checkForSecretAlias(properties);
                    if (secretAlias.status) {
                        password = secretAlias.value;
                        $("#ds-secret-alias-check").prop('checked', true);
                    } else {
                        password = getDSConfigPropertyValue(properties, "password");
                    }

                    if (password === "") {
                        password = getDSConfigPropertyValue(properties, "org.wso2.ws.dataservice.password");
                    }
                    if (password != null && password != undefined) {
                        $("#ds-password-input").val(password.trim());
                    }

                    if (dbEngine != null && dbEngine != undefined) {
                        $("#ds-db-engine-select").val(dbEngine.trim());
                    }

                } else if (rdbmsType === RDBMS_TYPE_EXTERNAL) {
                    $("#ds-dstype-2-select").val(RDBMS_TYPE_EXTERNAL);

                    if (dbEngine != null && dbEngine != undefined) {
                        $("#ds-db-engine-select").val(dbEngine.trim());
                    }

                    setVisibleDSType2Ext(true);
                    setVisibleDSType2Default(false);

                    // datasource class name
                    let dsClassName = getDSConfigPropertyValue(properties, "dataSourceClassName");
                    if (dsClassName != null && dsClassName != undefined) {
                        $("#ds-class-name-input").val(dsClassName.trim());
                    }
                }
            } else if (dsType === DS_TYPE_CARBONDS) {
                $("#ds-dstype-select").val(DS_TYPE_CARBONDS);
                setVisibleDSTypeRDBMS(false);
                setVisibleDSTypeCarbon(true);

                // datasource name
                let carbonDSName = getDSConfigPropertyValue(properties, "carbon_datasource_name");
                if (carbonDSName != null && carbonDSName != undefined) {
                    $("#ds-ds-name-input").val(carbonDSName.trim());
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

            // check if secret alias is enabled
            if ($("#ds-secret-alias-check").is(":checked")) {
                let propertyNode = createPropertyNode(root, "password");
                propertyNode.setAttribute(SECRET_ALIAS_NAMESPACE_ATTRIBUTE, SECRET_ALIAS_NAMESPACE);
                propertyNode.setAttribute(SECRET_ALIAS_ATTRIBUTE, data['ds-password-input']);

                properties.push(propertyNode);
            } else {
                properties.push(createTextNode(root, createPropertyNode(root, "password"), data['ds-password-input']));
            }
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
function saveDSMetadata(root, metadata, url) {
    let request = $.ajax({
        url: url,
        type: "post",
        headers: {"x-operation-type":HEADER_VALUE_SAVE_DS_METADATA},
        data: {content: metadata},
        success: function () {
            populateDataSources(root);
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
        data: {content: datasourceId},
        success: function (msg, status, jqXHR) {
            metadata = msg.toString();
        }
    });

    return metadata.trim();
}

/**
 * Tests connection to a RDBMS server.
 * @param connectionDetails Connection details as a string.
 * @param url Back-end URL.
 */
function testDBConnection(connectionDetails, url) {
    // Synchronous request
    let response = $.ajax({
        url: url,
        type: "post",
        headers: {"x-operation-type":HEADER_VALUE_TEST_DS_CONNECTION},
        data: {content: connectionDetails},
        success: function (msg, status, jqXHR) {
            showDSNotification("success", "Successfully connected to database.", 6000);
        },
        error: function (msg, status, jqXHR) {
            showDSNotification("danger", "Connection failed. Could not connect to database.", 6000);
        }
    });
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

    for (let i = 0; i < dataPairs.length; i++) {
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
 * @returns {string}    Property value if exists, empty string otherwise.
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

/**
 * Resets data source add/edit wizard.
 */
function resetDSAddEditModal() {
    setVisibleDSTypeRDBMS(true);
    setVisibleDSTypeCarbon(false);
}

/**
 * Loads default parameters for DB engine types.
 *
 * @param root Document root object.
 * @param dbEngineType Database engine type.
 */
function populateDBEngineDefaults(root, dbEngineType) {
    if (dbEngineType === DB_ENGINE_MYSQL) {
        $("#ds-driver-class-input").val(DEFAULT_MYSQL_DRIVER_CLASS);
        $("#ds-url-input").val(DEFAULT_MYSQL_URL);
    } else if (dbEngineType === DB_ENGINE_MSSQL) {
        $("#ds-driver-class-input").val(DEFAULT_MSSQL_DRIVER_CLASS);
        $("#ds-url-input").val(DEFAULT_MSSQL_URL);
    } else if (dbEngineType === DB_ENGINE_ORACLE) {
        $("#ds-driver-class-input").val(DEFAULT_ORACLE_DRIVER_CLASS);
        $("#ds-url-input").val(DEFAULT_ORACLE_URL);
    } else if (dbEngineType === DB_ENGINE_H2) {
        $("#ds-driver-class-input").val(DEFAULT_H2_DRIVER_CLASS);
        $("#ds-url-input").val(DEFAULT_H2_URL);
    } else if (dbEngineType === DB_ENGINE_POSTGRESQL) {
        $("#ds-driver-class-input").val(DEFAULT_POSTGRESQL_DRIVER_CLASS);
        $("#ds-url-input").val(DEFAULT_POSTGRESQL_URL);
    } else if (dbEngineType === DB_ENGINE_INFORMIX) {
        $("#ds-driver-class-input").val(DEFAULT_INFORMIX_DRIVER_CLASS);
        $("#ds-url-input").val(DEFAULT_INFORMIX_URL);
    } else if (dbEngineType === DB_ENGINE_HSQLDB) {
        $("#ds-driver-class-input").val(DEFAULT_HSQL_DRIVER_CLASS);
        $("#ds-url-input").val(DEFAULT_HSQL_URL);
    } else if (dbEngineType === DB_ENGINE_SYBASE) {
        $("#ds-driver-class-input").val(DEFAULT_SYBASE_DRIVER_CLASS);
        $("#ds-url-input").val(DEFAULT_SYBASE_URL);
    } else if (dbEngineType === DB_ENGINE_APACHEDERBY) {
        $("#ds-driver-class-input").val(DEFAULT_DERBY_DRIVER_CLASS);
        $("#ds-url-input").val(DEFAULT_DERBY_URL);
    } else if (dbEngineType === DB_ENGINE_IBMDB2) {
        $("#ds-driver-class-input").val(DEFAULT_IBMDB2_DRIVER_CLASS);
        $("#ds-url-input").val(DEFAULT_IBMDB2_URL);
    }
}

/**
 * This function is used to verify metadata of existing datasources.
 *
 * @param root Document root object.
 */
function verifyDSMetadata(root, url) {
    // Iterate through configs
    let dsConfigs = root.getElementsByTagName("config");

    for (let i = 0, len = dsConfigs.length; i < len; i++) {
        let configElement = dsConfigs[i];
        let dsId = configElement.attributes.getNamedItem("id").value
        let metadata = retrieveDSMetadata(dsId, url);

        if (metadata === "" || metadata === "null" || metadata === null || metadata === undefined) {
            extractMetadata(configElement, url);
        }
    }
}

function extractMetadata(configElement, url) {
    let dsId = configElement.attributes.getNamedItem("id").value;
    let propertyElements = configElement.getElementsByTagName("property");
    let metadata = dsId + DS_METADATA_ID_SEPARATOR;

    for (let i = 0, len = propertyElements.length; i < len; i++) {
        let propertyName = propertyElements[i].attributes.getNamedItem("name").value;

        if (propertyName === "driverClassName" || propertyName === "org.wso2.ws.dataservice.driver") {
            metadata += DS_METADATA_DS_TYPE + DS_METADATA_KEYVALUE_SEPARATOR + DS_TYPE_RDBMS + DS_METADATA_SEPARATOR +
                DS_METADATA_RDBMS_TYPE + DS_METADATA_KEYVALUE_SEPARATOR + RDBMS_TYPE_DEFAULT + DS_METADATA_SEPARATOR +
                DS_METADATA_DB_ENGINE + DS_METADATA_KEYVALUE_SEPARATOR + extractDBEngineTypeFromURL(configElement);
        } else if (propertyName === "dataSourceClassName" || propertyName === "org.wso2.ws.dataservice.dataSourceClassName") {
            metadata += DS_METADATA_DS_TYPE + DS_METADATA_KEYVALUE_SEPARATOR + DS_TYPE_RDBMS + DS_METADATA_SEPARATOR +
                DS_METADATA_RDBMS_TYPE + DS_METADATA_KEYVALUE_SEPARATOR + RDBMS_TYPE_EXTERNAL + DS_METADATA_SEPARATOR +
                DS_METADATA_DB_ENGINE + DS_METADATA_KEYVALUE_SEPARATOR + extractDBEngineTypeFromURL(configElement);
        } else if (propertyName === "carbon_datasource_name") {
            metadata += DS_METADATA_DS_TYPE + DS_METADATA_KEYVALUE_SEPARATOR + DS_TYPE_CARBONDS;
        }
    }

    saveDSMetadata(metadata, url);

}

function extractDBEngineTypeFromURL(configElement) {
    let propertyElements = configElement.getElementsByTagName("property");

    for (let i = 0, len = propertyElements.length; i < len; i++) {
        let propertyName = propertyElements[i].attributes.getNamedItem("name").value;

        if (propertyName === "url" || propertyName === "org.wso2.ws.dataservice.protocol") {
            let url = propertyElements[i].textContent;
            if (url.includes("mysql")) {
                return DB_ENGINE_MYSQL;
            } else if (url.includes("oracle")) {
                return DB_ENGINE_ORACLE;
            } else if (url.includes("sqlserver")) {
                return DB_ENGINE_MSSQL;
            } else if (url.includes("h2")) {
                return DB_ENGINE_H2;
            } else if (url.includes("derby")) {
                return DB_ENGINE_APACHEDERBY;
            } else if (url.includes("db2")) {
                return DB_ENGINE_IBMDB2;
            } else if (url.includes("hsqldb")) {
                return DB_ENGINE_HSQLDB;
            } else if (url.includes("informix")) {
                return DB_ENGINE_INFORMIX;
            } else if (url.includes("postgresql")) {
                return DB_ENGINE_POSTGRESQL;
            } else if (url.includes("sybase")) {
                return DB_ENGINE_SYBASE;
            }
        }
    }
}

function checkForSecretAlias(propertyArr) {
    for (let i = 0, len = propertyArr.length; i < len; i++) {
        let property = propertyArr[i];
        let propName = property.attributes.getNamedItem("name").value;

        if (propName == "password") {
            if (property.hasAttribute(SECRET_ALIAS_ATTRIBUTE)) {
                let passwordValue = property.attributes.getNamedItem(SECRET_ALIAS_ATTRIBUTE).value;

                return {
                    status: true,
                    value: passwordValue
                }
            }
        }
    }

    return {
        status: false
    }
}