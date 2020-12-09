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

    $('#ds-add-edit-ds-modal').modal({backdrop: 'static', show: false});  
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
	if (typeof root == "object") {
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
	        if (dsName == undefined) {
	        	dsName = dsConfigs[i].attributes.getNamedItem("id").value;
	        }
	        let markup = "<tr" + " data-id='" + dsName + "'" + "><td>" + dsName + "</td><td class='text-center'>" +
	            "<i class='fa fa-edit'></i><i class='fa fa-trash'></i></td></tr>";

	        $("#ds-datasources-table tbody").append(markup);
	    }
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
    
    $("#ds-secret-alias-check").prop('checked', false);
    $('#ds-password-inputgroup').toggle(true);
    $('#ds-password-sa-inputgroup').toggle(false);
    $('#ds-test-password-sa-inputgroup').toggle(false);

    for (let i = 0, len = dsConfigs.length; i < len; i++) {
        let config = dsConfigs[i];
        if (config.attributes.getNamedItem("id").value == dsId) {
        	
        	let oDataEnabled = config.attributes.getNamedItem("enableOData");
        	if (oDataEnabled != null && oDataEnabled != undefined && oDataEnabled.value == "true") {
        		$('#ds-enable-odata-check').prop("checked", true);
        	} else {
        		$('#ds-enable-odata-check').prop("checked", false);
        	}
        		
            let properties = config.getElementsByTagName("property");

            // Populate data source ID
            $("#ds-ds-id-input").val(dsId.toString().trim());
            $("#ds-ds-id-input").prop('disabled', true);

            if (dsType === DS_TYPE_RDBMS) {
                $("#ds-dstype-select").val(DS_TYPE_RDBMS);
                setVisibleDSTypeMongo(false);
                setVisibleDSTypeCSV(false);
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
                        
                        // populate data source test connection details from url
                        if (url != "") {
                            populateDSTestConDetails(url.trim());
                        }
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
                        $('#ds-password-inputgroup').toggle(false);
                        $('#ds-password-sa-inputgroup').toggle(true);
                        $('#ds-test-password-sa-inputgroup').toggle(true);
                        
                    } else {
                        password = getDSConfigPropertyValue(properties, "password");
                        
                    }

                    if (password === "") {
                        password = getDSConfigPropertyValue(properties, "org.wso2.ws.dataservice.password");
                    }
                    if (secretAlias.status) {
                    	if (password != null && password != undefined) {
                            $("#ds-password-sa-input").val(password.trim());
                        }
                    } else {
                    	if (password != null && password != undefined) {
                            $("#ds-password-input").val(password.trim());
                        }
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
                setVisibleDSTypeMongo(false);
                setVisibleDSTypeRDBMS(false);
                setVisibleDSTypeCSV(false);
                setVisibleDSTypeCarbon(true);

                // datasource name
                let carbonDSName = getDSConfigPropertyValue(properties, "carbon_datasource_name");
                if (carbonDSName != null && carbonDSName != undefined) {
                    $("#ds-ds-name-input").val(carbonDSName.trim());
                }
            } else if (dsType === DS_TYPE_MONGODB) {
            	$("#ds-dstype-select").val(DS_TYPE_MONGODB);
            	
            	let servers = getDSConfigPropertyValue(properties, "mongoDB_servers");
            	$('#ds-server-input').val(servers);
            	
            	let mongoDbName = getDSConfigPropertyValue(properties, "mongoDB_database");
            	$('#ds-mongo-dbname-input').val(mongoDbName);
            	
            	let authMethod = getDSConfigPropertyValue(properties, "mongoDB_authentication_type");
            	if (authMethod != null && authMethod != "") {
            		$('#ds-auth-method-select').val(authMethod);
            	} else {
            		$('#ds-auth-method-select').val("NONE");
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
                    $('#ds-password-inputgroup').toggle(false);
                    $('#ds-password-sa-inputgroup').toggle(true);
                    
                } else {
                    password = getDSConfigPropertyValue(properties, "password");
                    
                }

                if (password === "") {
                    password = getDSConfigPropertyValue(properties, "org.wso2.ws.dataservice.password");
                }
                if (secretAlias.status) {
                	if (password != null && password != undefined) {
                        $("#ds-password-sa-input").val(password.trim());
                    }
                } else {
                	if (password != null && password != undefined) {
                        $("#ds-password-input").val(password.trim());
                    }
                }
                
                let writeConcern = getDSConfigPropertyValue(properties, "mongoDB_write_concern");
                if (writeConcern != null && writeConcern != "") {
                	$('#ds-write-concern-select').val(writeConcern);
                } else {
                	$('#ds-write-concern-select').val("");
                }
                
                let readPerf = getDSConfigPropertyValue(properties, "mongoDB_read_preference");
                if (readPerf != null && readPerf != "") {
                	$('#ds-read-pref-select').val(readPerf);
                } else {
                	$('#ds-read-pref-select').val("");
                }
                
                let connectTimeout = getDSConfigPropertyValue(properties, "mongoDB_connectTimeout");
                $('#ds-con-timeout-input').val(connectTimeout);
                
                let maxWait = getDSConfigPropertyValue(properties, "mongoDB_maxWaitTime");
                $('#ds-max-wait-input').val(maxWait);
                
                let socketTimeout = getDSConfigPropertyValue(properties, "mongoDB_socketTimeout");
                $('#ds-socket-timeout-input').val(socketTimeout);
                
                let conPerHost = getDSConfigPropertyValue(properties, "mongoDB_connectionsPerHost");
                $('#ds-connections-input').val(conPerHost);
                
                let threadsForBlock = getDSConfigPropertyValue(properties, "mongoDB_threadsAllowedToBlockForConnectionMultiplier");
                $('#ds-threads-for-mul-input').val(threadsForBlock);

                setVisibleDSTypeRDBMS(false);
                setVisibleDSTypeCarbon(false);
                setVisibleDSTypeCSV(false);
                setVisibleDSTypeMongo(true);
                
            } else if (dsType === DS_TYPE_CSV) {
            	
                $("#ds-dstype-select").val(DS_TYPE_CSV);
                
                $('#ds-csv-file-location-input').val(getDSConfigPropertyValue(properties, "csv_datasource"));
                
                let colSeparator = getDSConfigPropertyValue(properties, "csv_columnseperator");
                if (colSeparator != null && colSeparator != "") {
                	$('#ds-col-separator-input').val(colSeparator);
                }
            	
                let startRow = getDSConfigPropertyValue(properties, "csv_startingrow");
                if (startRow != null && startRow != "") {
                	$('#ds-start-row-input').val(startRow);
                }
                
                let maxReadRows = getDSConfigPropertyValue(properties, "csv_maxrowcount");
                if (maxReadRows != null && maxReadRows != "") {
                	$('#ds-max-read-rows-input').val(maxReadRows);
                }
                
                let colHeader = getDSConfigPropertyValue(properties, "csv_hasheader");
                if (colHeader != null && colHeader != "" && (colHeader == "true" || colHeader == true)) {
                	$('#ds-col-header-select').val("true");
                } else {
                	$('#ds-col-header-select').val("false");
                }
                
                let headerRow = getDSConfigPropertyValue(properties, "csv_headerrow");
                if (headerRow != null && headerRow != "") {
                	$('#ds-header-row-input').val(headerRow);
                }
                
                setVisibleDSTypeRDBMS(false);
                setVisibleDSTypeCarbon(false);
                setVisibleDSTypeMongo(false);
                setVisibleDSTypeCSV(true);
            }

            // dynamic auth details
            //// auth class
            let dynamicAuthClass = getDSConfigPropertyValue(properties, "dynamicUserAuthClass");
            if (dynamicAuthClass === "") {
                dynamicAuthClass = getDSConfigPropertyValue(properties, "org.wso2.ws.dataservice.driver");
            }

            if (dynamicAuthClass) {
                $("#ds-dynamic-auth-class-input").val(dynamicAuthClass.trim());
            }

            //// auth mappings
            $("#ds-dynamic-auth-usermapping-table tbody tr").remove();

            for (let i = 0, len = properties.length; i < len; i++) {
                if (properties[i].attributes.getNamedItem("name").value == "dynamicUserAuthMapping") {
                    let configurationElement = properties[i].getElementsByTagName("configuration")[0];

                    if (configurationElement) {
                        let entries = configurationElement.getElementsByTagName("entry");

                        if (entries) {
                            $.each(entries, function (index, entry) {
                                let name, username, password = "";

                                if (entry.attributes.getNamedItem("request")) {
                                    if (entry.attributes.getNamedItem("request").value != undefined) {
                                        name = entry.attributes.getNamedItem("request").value;
                                    }
                                }

                                let usernameElement = entry.getElementsByTagName("username")[0];
                                if (usernameElement && usernameElement.textContent != undefined) {
                                    username = usernameElement.textContent;
                                }

                                let passwordElement = entry.getElementsByTagName("password")[0];
                                if (passwordElement && passwordElement.textContent != undefined) {
                                    password = passwordElement.textContent;
                                }

                                let tableRow = "<tr><td><input class=\"form-control\" type=\"text\" " +
                                    "placeholder=\"Carbon Username\" style=\"width: 100%;\" value='" + name + "'></td>" +
                                    "<td><input class=\"form-control\" type=\"text\" placeholder=\"DB Username\" " +
                                    "style=\"width: 100%;\" value='" + username + "'></td><td><input " +
                                    "class=\"form-control\" type=\"password\" placeholder=\"DB Password\" " +
                                    "style=\"width: 100%;\" value='" + password + "'></td><td class=\"text-center\">" +
                                    "<i class=\"fa fa-trash\"></i></td></tr>";

                                $('#ds-dynamic-auth-usermapping-table > tbody').append(tableRow);
                            });
                        }
                    }
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
        if (dsConfigs[i].getAttribute("id") == datasourceId && !$("#ds-ds-id-input").prop('disabled')) {
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

    let dynamicAuthClass = $("#ds-dynamic-auth-class-input").val();

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
                propertyNode.setAttribute(SECRET_ALIAS_ATTRIBUTE, data['ds-password-sa-input']);

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
    } else if (dsType === "mongodb_ds") {
    	
    	properties.push(createTextNode(root, createPropertyNode(root, "mongoDB_servers"), data['ds-server-input']));
    	properties.push(createTextNode(root, createPropertyNode(root, "mongoDB_database"), data['ds-mongo-dbname-input']));
    	
    	let authMethod = data['ds-auth-method-select'];
    	if (authMethod != "" && authMethod != "NONE") {
    		properties.push(createTextNode(root, createPropertyNode(root, "mongoDB_authentication_type"), authMethod));
    	}
    	
    	let user = data['ds-username-input'];
    	if (user != "") {
    		properties.push(createTextNode(root, createPropertyNode(root, "username"), user));
    	}

        // check if secret alias is enabled
        if ($("#ds-secret-alias-check").is(":checked")) {
        	let passwordSA = data['ds-password-sa-input'];
        	if (passwordSA != "") {
        		let propertyNode = createPropertyNode(root, "password");
                propertyNode.setAttribute(SECRET_ALIAS_NAMESPACE_ATTRIBUTE, SECRET_ALIAS_NAMESPACE);
                propertyNode.setAttribute(SECRET_ALIAS_ATTRIBUTE, passwordSA);
                properties.push(propertyNode);
        	}
            
        } else {
        	let pw = data['ds-password-input'];
        	if (pw != "") {
        		properties.push(createTextNode(root, createPropertyNode(root, "password"), pw));
        	}
        }
    	
        let writeConcern = data['ds-write-concern-select'];
        if (writeConcern != "") {
        	properties.push(createTextNode(root, createPropertyNode(root, "mongoDB_write_concern"), writeConcern));
        }
        
        let readPref = data['ds-read-pref-select'];
        if (readPref != "") {
        	properties.push(createTextNode(root, createPropertyNode(root, "mongoDB_read_preference"), readPref));
        }
        
        let conTimeout = data['ds-con-timeout-input'];
        if (conTimeout != "") {
        	properties.push(createTextNode(root, createPropertyNode(root, "mongoDB_connectTimeout"), conTimeout));
        }
        
        let maxWait = data['ds-max-wait-input'];
        if (maxWait != "") {
        	properties.push(createTextNode(root, createPropertyNode(root, "mongoDB_maxWaitTime"), maxWait));
        }
        
        let socketTimeout = data['ds-socket-timeout-input'];
        if (socketTimeout != "") {
        	properties.push(createTextNode(root, createPropertyNode(root, "mongoDB_socketTimeout"), socketTimeout));
        }
        
        let connections = data['ds-connections-input'];
        if (connections != "") {
        	properties.push(createTextNode(root, createPropertyNode(root, "mongoDB_connectionsPerHost"), connections));
        }
        
        let threads = data['ds-threads-for-mul-input'];
        if (threads != "") {
        	properties.push(createTextNode(root, createPropertyNode(root, "mongoDB_threadsAllowedToBlockForConnectionMultiplier"), threads));
        }
        
    } else if (dsType === "csv") {
    	
    	properties.push(createTextNode(root, createPropertyNode(root, "csv_datasource"), data['ds-csv-file-location-input']));
    	properties.push(createTextNode(root, createPropertyNode(root, "csv_hasheader"), data['ds-col-header-select']));
    	
    	let colSeparator = data['ds-col-separator-input'];
    	if (colSeparator != "") {
    		properties.push(createTextNode(root, createPropertyNode(root, "csv_columnseperator"), colSeparator));
    	}
    	
    	let startRow = data['ds-start-row-input'];
    	if (startRow != "") {
    		properties.push(createTextNode(root, createPropertyNode(root, "csv_startingrow"), startRow));
    	}
    	
    	let maxReadRows = data['ds-max-read-rows-input'];
    	if (maxReadRows != "") {
    		properties.push(createTextNode(root, createPropertyNode(root, "csv_maxrowcount"), maxReadRows));
    	}
    	
    	let headerRow = data['ds-header-row-input'];
    	if (headerRow != "") {
    		properties.push(createTextNode(root, createPropertyNode(root, "csv_headerrow"), headerRow));
    	}
    }

    if (dynamicAuthClass !== "" && dynamicAuthClass !== undefined) {
        properties.push(createTextNode(root, createPropertyNode(root, "dynamicUserAuthClass"), dynamicAuthClass));
    }

    // Append properties to config node
    for (let i = 0, len = properties.length; i < len; i++) {
        configElement.appendChild(properties[i]);
    }

    let rows = $('#ds-dynamic-auth-usermapping-table').find('tr');
    
    if (rows.length > 1) {
    	// Process dynamic auth mappings
        let dynamicAuthMappingElement = createPropertyNode(root, "dynamicUserAuthMapping");
        let configurationElement = root.createElement("configuration");

        for (let i = 1, len = rows.length; i < len; i++) {
            let entryElement = root.createElement("entry");
            entryElement.setAttribute("request", rows[i].cells[0].firstChild.value);

            let usernameElement = root.createElement("username");
            createTextNode(root, usernameElement, rows[i].cells[1].firstChild.value);

            let passwordElement = root.createElement("password");
            createTextNode(root, passwordElement, rows[i].cells[2].firstChild.value);

            entryElement.appendChild(usernameElement);
            entryElement.appendChild(passwordElement);

            configurationElement.appendChild(entryElement);
        }

        dynamicAuthMappingElement.appendChild(configurationElement);
        configElement.appendChild(dynamicAuthMappingElement);
    }

    // OData enabled
    let enableOData = $('#ds-enable-odata-check').is(":checked");
    if (enableOData) {
    	configElement.setAttribute("enableOData", true);
    }
    
    let exists = false;
    if (dsConfigs.length > 0) {
    	// Deletes if query node exists
        for (let i = 0, len = dsConfigs.length; i < len; i++) {
        	let dsID = dsConfigs[0].id;
        	if (dsID == undefined) {
        		dsID = dsConfigs[0].attributes.getNamedItem("id").value;
        	}
            if (dsID == dsId) {
            	// Delete the node.
            	exists = true;
            	dataRoot.removeChild(dsConfigs[0]);
            	dataRoot.appendChild(configElement);
            } else {
            	let current_ds = dsConfigs[0];
            	dataRoot.removeChild(dsConfigs[0]);
            	dataRoot.appendChild(current_ds);
            }
        }
    } else {
    	dataRoot.appendChild(configElement);
    }
    
    if (dsConfigs.length > 0 && !exists) {
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

function getMappings(connectionUrl, sqlQuery, credentials, url, root, result) {
    // Synchronous request
    let response = $.ajax({
        url: url,
        type: "post",
        headers: {"x-operation-type":HEADER_VALUE_GENERATE_MAPPINGS},
        data: {conurl: connectionUrl, query: sqlQuery, credentials: credentials},
        success: function (msg, status, jqXHR) {
        	msg = msg.replace("\n", " ");
        	let mappings = msg.split(",");
        	if (mappings.length > 0) {
        		result = root.createElement("result");
        		
        		$.each(mappings, function (i, val) {
        			let name = $.trim(val);
        			if (name != "") {
        				result = addGeneratedMappingsToRoot(root, result, name);
        			}
        		});
        		window.ResultElement = result;
        	}
        },
        error: function (msg, status, jqXHR) {
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
    $('#ds-password-sa-inputgroup').toggle(false);
    $('#ds-test-password-sa-inputgroup').toggle(false);
    setVisibleDSTypeCarbon(false);
    clearDynamicAuthTable();
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
 * This function is used to set the test connection RDBMS Version once the Database Engine is selected.
 *
 * @param dbEngineType Database Engine type.
 */
function setTestConnectionRDBMSVersion(dbEngineType) {
    let testRDBMSversion;
    let testRDBMSVersionSelector = $("#ds-db-version-select");
    switch (dbEngineType) {
    case DB_ENGINE_MYSQL:
        testRDBMSversion = testRDBMSVersionSelector.find("[label='MySQL']").children()[0].value;
        break;
    case DB_ENGINE_MSSQL:
        testRDBMSversion = testRDBMSVersionSelector.find("[label='MSSQL']").children()[0].value;
        break;
    case DB_ENGINE_POSTGRESQL:
        testRDBMSversion = testRDBMSVersionSelector.find("[label='PostgreSQL']").children()[0].value;
        break;
    case DB_ENGINE_APACHEDERBY:
        testRDBMSversion = testRDBMSVersionSelector.find("[label='Derby']").children()[0].value;
        break;
    case "generic":
        testRDBMSversion = testRDBMSVersionSelector.find("[label='Generic']").children()[0].value;
        break;
    case DB_ENGINE_H2:
        testRDBMSversion = testRDBMSVersionSelector.find("[label='H2']").children()[0].value;
        break;
    }
    if (testRDBMSversion != null && testRDBMSversion != undefined){
        $("#ds-db-version-select").val(testRDBMSversion);
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
            extractMetadata(root, configElement, url);
        }
    }
}

function extractMetadata(root, configElement, url) {
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

    saveDSMetadata(root, metadata, url);

}

function extractDBEngineTypeFromURL(configElement) {
    let propertyElements = configElement.getElementsByTagName("property");

    for (let i = 0, len = propertyElements.length; i < len; i++) {
        let propertyName = propertyElements[i].attributes.getNamedItem("name").value;

        if (propertyName === "url" || propertyName === "org.wso2.ws.dataservice.protocol") {
            let url = propertyElements[i].textContent;
            if (url.indexOf("mysql") != -1) {
                return DB_ENGINE_MYSQL;
            } else if (url.indexOf("oracle") != -1) {
                return DB_ENGINE_ORACLE;
            } else if (url.indexOf("sqlserver") != -1) {
                return DB_ENGINE_MSSQL;
            } else if (url.indexOf("h2") != -1) {
                return DB_ENGINE_H2;
            } else if (url.indexOf("derby") != -1) {
                return DB_ENGINE_APACHEDERBY;
            } else if (url.indexOf("db2") != -1) {
                return DB_ENGINE_IBMDB2;
            } else if (url.indexOf("hsqldb") != -1) {
                return DB_ENGINE_HSQLDB;
            } else if (url.indexOf("informix") != -1) {
                return DB_ENGINE_INFORMIX;
            } else if (url.indexOf("postgresql") != -1) {
                return DB_ENGINE_POSTGRESQL;
            } else if (url.indexOf("sybase") != -1) {
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

function populateDSTestConDetails(urlStr) {
    // Auto setting test connection only for jdbc
    if (urlStr.substring(0, 4) == "jdbc") {
        let host = "";
        let port = "";
        let dbname = "";
        let delimiterSlash = "/";
        let delimiterColon = ":";
        let delimiterUrl = "://";
        let url;
        dbEngine = urlStr.split(delimiterColon)[1];
        switch (dbEngine) {
        case "mysql":
        case "postgresql":
        case "derby":
            if (urlStr.match(/.+\/\/.*:.+/)) {
                url = urlStr.split(delimiterUrl)[1].split(delimiterColon);
                host = url[0];
                port = url[1].split(delimiterSlash)[0];
                dbname = url[1].split(delimiterSlash)[1];
            }
            break;
        case "sqlserver":
            if (urlStr.match(/.+\/\/.+:.+;.+=.+/)) {
                url = urlStr.split(delimiterUrl)[1].split(delimiterColon);
                host = url[0];
                port = url[1].split(";")[0];
                dbname = url[1].split("=")[1];
            }
            break;
        case "oracle":
            if (urlStr.match(/.+:.+:.+:.+@.+:.+\/.+/)) {
                url = urlStr.split("@")[1].split(delimiterColon);
                host = url[0];
                port = url[1].split(delimiterSlash)[0];
                dbname = url[1].split(delimiterSlash)[1];
            }
            break;
        case "hsqldb":
        case "db2":
            url = urlStr.split(delimiterColon);
            if (url.length >= 3) {
                dbname = urlStr.split(delimiterColon)[2];
            }
            break;
        case "informix-sqli":
            if (urlStr.match(/.+\/\/.+:/)) {
                url = urlStr.split(delimiterUrl)[1].split(delimiterColon);
                host = url[0];
                port = url[1].split(delimiterSlash)[0];
                dbname = url[1].split(delimiterSlash)[1];
            }
            break;
        case "h2":
        	url = urlStr.split(delimiterColon);
        	if (urlStr.match(/.+:.+:.+:.+\~\/.+/)) {
        		let context = url[3];
        		if (context.substring(0, 2) == "//") {
        			context = context.substring(2);
        		}
        		hostAndDb = context.split(delimiterSlash);
        		port = "8082";
        		host = hostAndDb[0];
                dbname = hostAndDb[2];
        	} else if (urlStr.match(/.+:.+:\~\/.+/)) {
        		port = "8082";
        		host = "localhost";
                dbname = url[2].split(delimiterSlash)[1];
        	} else if (urlStr.match(/.+:.+:.+:.+:.+\/.+/)) {
        		let hostname = url[3];
        		if (hostname.substring(0, 2) == "//") {
        			hostname = hostname.substring(2);
        		}
                host = hostname;
                port = url[4].split(delimiterSlash)[0];
                dbname = url[4].split(delimiterSlash)[1];
        	}
        	break;
        case "sybase":
            if (urlStr.match(/.+:.+:.+:.+:.+\/.+/)) {
                url = urlStr.split(delimiterColon);
                host = url[3];
                port = url[4].split(delimiterSlash)[0];
                dbname = url[4].split(delimiterSlash)[1];
            }
            break;
        }
        $("#ds-host-input").val(host);
        $("#ds-port-input").val(port);
        $("#ds-dbname-input").val(dbname);
    }

}

function clearDynamicAuthTable() {
    $("#ds-dynamic-auth-usermapping-table tbody tr").remove();
}