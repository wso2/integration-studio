/*
* Copyright (c) 2022, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
*
* WSO2 Inc. licenses this file to you under the Apache License,
* Version 2.0 (the "License"); you may not use this file except
* in compliance with the License.
* You may obtain a copy of the License at
*
* http://www.apache.org/licenses/LICENSE-2.0
*
* Unless required by applicable law or agreed to in writing,
* software distributed under the License is distributed on an
* "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
* KIND, either express or implied. See the License for the
* specific language governing permissions and limitations
* under the License.
*/

/**
 * This function generates and returns the xml source code for data source from the data model
 *
 * @param dataModel JSON dataModel object with data source configuration.
 * @returns the "text/xml" source code for data source.
 */
function generateXmlSource(dataModel) {
    var xmlString =
        `<datasource>
            <name>${dataModel.name}</name>
            <description>${dataModel.description}</description>
        </datasource>`;
    var parser = new DOMParser();
    var xmlSourceRoot = parser.parseFromString(xmlString, "text/xml");

    var datasourceElement = xmlSourceRoot.getElementsByTagName("datasource")[0];
    var definitionElement = xmlSourceRoot.createElement("definition");

    if (dataModel.definition.type == DS_TYPE_RDBMS) {

        // Add JNDI configurations
        var jndiName = dataModel.definition.rdbms_conf.jndi_conf.name;
        if (jndiName != EMPTY_STRING) {
            var useDSFactory = dataModel.definition.rdbms_conf.jndi_conf.useDSFactory;
            var jndiConfigElement = xmlSourceRoot.createElement('jndiConfig');
            jndiConfigElement.setAttribute("useDataSourceFactory", useDSFactory);
            datasourceElement.appendChild(jndiConfigElement);

            var jndiNameElement = xmlSourceRoot.createElement('name');
            jndiNameElement.textContent = jndiName;
            jndiConfigElement.appendChild(jndiNameElement);

            //Add properties if available
            var props = dataModel.definition.rdbms_conf.jndi_conf.properties;
            if (props.length > 0) {
                var environmentElement = xmlSourceRoot.createElement("environment");
                jndiConfigElement.appendChild(environmentElement);

                for (var i = 0; i < props.length; i++) {
                    var prop = props[i];
                    var propertyElement = xmlSourceRoot.createElement("property");
                    propertyElement.setAttribute("name", prop.name);
                    propertyElement.textContent = prop.value;
                    environmentElement.appendChild(propertyElement);
                }
            }
        }

        definitionElement.setAttribute("type", "RDBMS");

        var configurationElement = xmlSourceRoot.createElement("configuration");
        definitionElement.appendChild(configurationElement);

        var rdbmsConf = dataModel.definition.rdbms_conf;
        if (rdbmsConf.provider == RDBMS_TYPE_DEFAULT) {

            var defaultConf = rdbmsConf.default_conf;

            var driverClassNameElement = xmlSourceRoot.createElement("driverClassName");
            var urlElement = xmlSourceRoot.createElement("url");

            driverClassNameElement.textContent = defaultConf.driverClassName;
            urlElement.textContent = defaultConf.url;
            configurationElement.appendChild(driverClassNameElement);
            configurationElement.appendChild(urlElement);


            if (defaultConf.username != null && defaultConf.username != "null") {
                var usernameElement = xmlSourceRoot.createElement("username");
                usernameElement.textContent = defaultConf.username;
                configurationElement.appendChild(usernameElement);
            }

            if (defaultConf.password != null && defaultConf.password != "null") {
                var passwordElement = xmlSourceRoot.createElement("password");
                passwordElement.textContent = defaultConf.password;
                configurationElement.appendChild(passwordElement);
            }


        } else if (rdbmsConf.provider == RDBMS_TYPE_EXTERNAL) {
            var externalConf = rdbmsConf.ext_conf;
            var dsClassName = externalConf.dsClassName;
            var dsClassNameElement = xmlSourceRoot.createElement("dataSourceClassName");
            dsClassNameElement.textContent = dsClassName;
            configurationElement.appendChild(dsClassNameElement);

            //add properties if available
            var props = dataModel.definition.rdbms_conf.ext_conf.properties;
            if (props.length > 0) {
                var dsPropsElement = xmlSourceRoot.createElement("dataSourceProps");
                configurationElement.appendChild(dsPropsElement);

                for (var i = 0; i < props.length; i++) {
                    var prop = props[i];
                    var propertyElement = xmlSourceRoot.createElement("property");
                    propertyElement.setAttribute("name", prop.name);
                    propertyElement.textContent = prop.value;
                    dsPropsElement.appendChild(propertyElement);
                }
            }
        }

        //Configuration parameters
        var parameters = dataModel.definition.rdbms_conf.config_parameters;
        for (var i = 0; i < parameters.length; i++) {
            var parameter = parameters[i];
            var parameterElement = xmlSourceRoot.createElement(parameter.tag);
            parameterElement.textContent = parameter.value;
            configurationElement.appendChild(parameterElement);
        }


    } else if (dataModel.definition.type == DS_TYPE_CUSTOM) {
        var customConf = dataModel.definition.custom_conf;
        var customDSType = customConf.ds_type;
        definitionElement.setAttribute("type", customDSType);

        var customConfigStr = customConf.config;
        definitionElement.textContent = customConfigStr;
    }

    datasourceElement.appendChild(definitionElement);

    return xmlSourceRoot;
}

/**
 * This function updates the dataModel by extracting details from xml source code of a data source
 *
 * @param dataModel JSON dataModel object to be updated with data source configuration.
 * @param xmlSourceRoot XML source code object
 */
function updateDataModelFromXml(dataModel, xmlSourceRoot) {

    if (typeof xmlSourceRoot == "object") {
        let dss = xmlSourceRoot.getElementsByTagName("datasource");
        if (dss.length > 0) {

            let ds = dss[0];
            let nameElements = ds.getElementsByTagName("name");
            let dsName = nameElements.length > 0 ? nameElements[0].innerHTML : EMPTY_STRING;
            dataModel.name = dsName;

            let descriptionElements = ds.getElementsByTagName("description");
            let dsDescription = descriptionElements.length > 0 ? descriptionElements[0].innerHTML : EMPTY_STRING;
            dataModel.description = dsDescription;

            //JNDI configs
            let jndiConfigElements = ds.getElementsByTagName("jndiConfig");
            if (jndiConfigElements.length > 0) {
                var jndiNameElements = jndiConfigElements[0].getElementsByTagName("name");
                var jndiName = jndiNameElements.length > 0 ? jndiNameElements[0].innerHTML : EMPTY_STRING;
                dataModel.definition.rdbms_conf.jndi_conf.name = jndiName;
                var useDSFactory = jndiConfigElements[0].getAttribute("useDataSourceFactory") == TRUE_STRING ? true : false;

                dataModel.definition.rdbms_conf.jndi_conf.useDSFactory = useDSFactory;

                var jndiEnvElements = jndiConfigElements[0].getElementsByTagName("environment");
                if (jndiEnvElements.length > 0) {
                    var propertyElements = jndiEnvElements[0].getElementsByTagName('property');
                    props = [];
                    for (var i = 0; i < propertyElements.length; i++) {
                        var propElement = propertyElements[i];
                        var propName = propElement.getAttribute('name');
                        var propValue = propElement.innerHTML;
                        if (propName != EMPTY_STRING && propValue != EMPTY_STRING) {
                            var newProp = { "name": propName, "value": propValue };
                            props.push(newProp);
                        }
                    }
                    dataModel.definition.rdbms_conf.jndi_conf.properties = props;
                }

            }

            let definitionElements = ds.getElementsByTagName('definition');
            if (definitionElements.length > 0) {
                let dsType = definitionElements[0].getAttribute("type");
                if (dsType == "RDBMS") {
                    dataModel.definition.type = DS_TYPE_RDBMS;

                    var configurationElements = definitionElements[0].getElementsByTagName('configuration');
                    if (configurationElements.length > 0) {

                        var driverClassNameElements = configurationElements[0].getElementsByTagName('driverClassName');
                        var dataSourceClassNameElements = configurationElements[0].getElementsByTagName('dataSourceClassName');

                        if (dataSourceClassNameElements.length > 0 && driverClassNameElements.length == 0) {
                            dataModel.definition.rdbms_conf.provider = RDBMS_TYPE_EXTERNAL;

                            var dsClassName = dataSourceClassNameElements[0].innerHTML;
                            dataModel.definition.rdbms_conf.ext_conf.dsClassName = dsClassName;

                            var dsPropsElements = configurationElements[0].getElementsByTagName('dataSourceProps');
                            if (dsPropsElements.length > 0) {
                                var propertyElements = dsPropsElements[0].getElementsByTagName('property');
                                props = [];
                                for (var i = 0; i < propertyElements.length; i++) {
                                    var propElement = propertyElements[i];
                                    var propName = propElement.getAttribute('name');
                                    var propValue = propElement.innerHTML;
                                    if (propName != EMPTY_STRING && propValue != EMPTY_STRING) {
                                        var newProp = { "name": propName, "value": propValue };
                                        props.push(newProp);
                                    }
                                }
                                dataModel.definition.rdbms_conf.ext_conf.properties = props;
                            }

                        } else {
                            dataModel.definition.rdbms_conf.provider = RDBMS_TYPE_DEFAULT;

                            if (driverClassNameElements.length > 0) {
                                var dbEngine = getDBEngineFromDriverClass(driverClassNameElements[0].innerHTML);
                                dataModel.definition.rdbms_conf.default_conf.db_engine = dbEngine;
                            } else {
                                dataModel.definition.rdbms_conf.default_conf.db_engine = EMPTY_STRING;
                            }

                            var driverClassNameElements = configurationElements[0].getElementsByTagName('driverClassName');
                            var driverClass = driverClassNameElements.length > 0 ? driverClassNameElements[0].innerHTML : EMPTY_STRING;
                            dataModel.definition.rdbms_conf.default_conf.driverClassName = driverClass;

                            var urlElements = configurationElements[0].getElementsByTagName('url');
                            var url = urlElements.length > 0 ? urlElements[0].innerHTML : EMPTY_STRING;
                            dataModel.definition.rdbms_conf.default_conf.url = url;

                            var usernameElements = configurationElements[0].getElementsByTagName('username');
                            var username = usernameElements.length > 0 ? usernameElements[0].innerHTML : EMPTY_STRING;
                            dataModel.definition.rdbms_conf.default_conf.username = username;

                            var passwordElements = configurationElements[0].getElementsByTagName('password');
                            var password = passwordElements.length > 0 ? passwordElements[0].innerHTML : EMPTY_STRING;
                            dataModel.definition.rdbms_conf.default_conf.password = password;

                        }

                        //Configuration parameters
                        parameters = [];
                        var allParameterTagNames = Object.keys(configParameterTagToId);
                        for (var i = 0; i < allParameterTagNames.length; i++) {
                            var tagName = allParameterTagNames[i];
                            var parameterElements = configurationElements[0].getElementsByTagName(tagName);
                            if (parameterElements.length > 0) {
                                var value = parameterElements[0].innerHTML;
                                parameters.push({ "tag": tagName, "value": value });

                            }
                        }
                        dataModel.definition.rdbms_conf.config_parameters = parameters;
                    }

                } else {
                    dataModel.definition.type = DS_TYPE_CUSTOM;
                    dataModel.definition.custom_conf.ds_type = dsType;
                    var config = definitionElements[0].innerHTML;
                    dataModel.definition.custom_conf.config = config;
                }
            }

        }
    }

}

/**
 * This function updates the design view elements according to the given dataModel
 *
 * @param dataModel JSON dataModel object with data source configuration.
 */
function populateDesignViewFromDataModel(dataModel) {

    $("#ds-name-input").val(dataModel.name);
    $("#ds-desc-input").val(dataModel.description);

    //JNDI configs
    var jndiConf = dataModel.definition.rdbms_conf.jndi_conf;
    $("#ds-jndi-name-input").val(jndiConf.name);
    $("#ds-use-factory-check").prop('checked', jndiConf.useDSFactory);;

    var props = jndiConf.properties;

    for (var i = 0; i < props.length; i++) {
        var prop = props[i];
        if (i == 0) {
            var tr = $("#jndi-properties-table table tbody tr")
            var tds = tr.find('td');
            tds[0].firstChild.value = prop.name;
            tds[1].firstChild.value = prop.value;

        } else {

            var markup = `<tr>
                <td><input type='text' placeholder='Property Name' class='form-control' style='width: 100%;' value="${prop.name}" autocomplete='off' autocorrect='off' autocapitalize'off' spellcheck='false'/></td>
                <td><input type='text' placeholder='Property Value' class='form-control' style='width: 100%;' value="${prop.value}" autocomplete='off' autocorrect='off' autocapitalize'off' spellcheck='false'/></td>
                <td class='text-center'><i class='fa fa-trash'></i></td></tr>`;

            $("#jndi-properties-table tbody").append(markup);
        }
    }

    $("#ds-type-select").val(dataModel.definition.type);

    var rdbmsConf = dataModel.definition.rdbms_conf;
    $("#ds-provider-select").val(rdbmsConf.provider);

    var defaultConf = rdbmsConf.default_conf;
    $("#ds-db-engine-select").val(defaultConf.db_engine);
    $("#ds-driver-class-input").val(defaultConf.driverClassName);
    $("#ds-url-input").val(defaultConf.url);
    $("#ds-username-input").val(defaultConf.username);
    $("#ds-password-input").val(defaultConf.password);

    var externalConf = rdbmsConf.ext_conf;
    $("#ds-class-name-input").val(externalConf.dsClassName);

    var props = dataModel.definition.rdbms_conf.ext_conf.properties;

    for (var i = 0; i < props.length; i++) {
        var prop = props[i];
        if (i == 0) {
            var tr = $("#ds-ext-properties-table table tbody tr")
            var tds = tr.find('td');
            tds[0].firstChild.value = prop.name;
            tds[1].firstChild.value = prop.value;

        } else {

            var markup = `<tr>
                <td><input type='text' placeholder='Property Name' class='form-control' style='width: 100%;' value="${prop.name}" autocomplete='off' autocorrect='off' autocapitalize'off' spellcheck='false'/></td>
                <td><input type='text' placeholder='Property Value' class='form-control' style='width: 100%;' value="${prop.value}" autocomplete='off' autocorrect='off' autocapitalize'off' spellcheck='false'/></td>
                <td class='text-center'><i class='fa fa-trash'></i></td></tr>`;

            $("#ds-ext-properties-table tbody").append(markup);
        }
    }

    //Configuration parameters
    var parameters = dataModel.definition.rdbms_conf.config_parameters;
    for (var i = 0; i < parameters.length; i++) {
        var tagName = parameters[i].tag;
        var value = parameters[i].value;

        var elementId = configParameterTagToId[tagName];
        if (elementId != null) {
            $(elementId).val(value);
        }
    }

    var customConf = dataModel.definition.custom_conf;
    $("#ds-custom-ds-type-input").val(customConf.ds_type);
    $("#ds-configuration-input").val(customConf.config);

    // Change event to UI according to drop-down selections 
    if (dataModel.definition.type == DS_TYPE_RDBMS) {
        $("#ds-rdbms-input-group").toggle(true);
        $("#ds-custom-input-group").toggle(false);

    } else if (dataModel.definition.type == DS_TYPE_CUSTOM) {
        $("#ds-rdbms-input-group").toggle(false);
        $("#ds-custom-input-group").toggle(true);
    }
    if (dataModel.definition.rdbms_conf.provider == RDBMS_TYPE_DEFAULT) {
        $("#ds-external-input-group").toggle(false);
        $("#ds-default-input-group").toggle(true);

    } else if (dataModel.definition.rdbms_conf.provider == RDBMS_TYPE_EXTERNAL) {
        $("#ds-external-input-group").toggle(true);
        $("#ds-default-input-group").toggle(false);

    }

    $("#ds-driver-class-input").val(dataModel.definition.rdbms_conf.default_conf.driverClassName);
    $("#ds-url-input").val(dataModel.definition.rdbms_conf.default_conf.url);

    if (jndiConf.name != EMPTY_STRING || jndiConf.properties.length > 0) {
        $("#jndi-collapse").collapse("show");
    } else {
        $("#jndi-collapse").collapse("hide");
    }

    if (dataModel.definition.rdbms_conf.config_parameters.length > 0) {
        $("#ds-conf-para-collapse").collapse("show");
    } else {
        $("#ds-conf-para-collapse").collapse("hide");
    }

}

/**
 * This function sends the modified source to the back-end and invokes the save operation.
 *
 * @param xmlSourceRoot Document object.
 * @param url Back-end URL.
 * @param successFunc Success callback function.
 */
function saveAll(xmlSourceRoot, url, successFunc) {
    var serializedData = new XMLSerializer().serializeToString(xmlSourceRoot);
    serializedData = serializedData.split(/xmlns\:NS[0-9]+=\"\" NS[0-9]+\:/).join(EMPTY_STRING);
    var prettyXmlText;
    var isIE = false || !!document.documentMode;

    prettyXmlText = new XmlBeautify().beautify(serializedData,
        { indent: "  ", useSelfClosingElement: true });

    var request = $.ajax({
        url: url,
        type: "post",
        headers: { "x-operation-type": OPERATION_TYPE_HEADER_SAVE_ALL },
        data: { content: prettyXmlText },
        success: successFunc
    });
}



/**
 * This function sends the modified source to the back-end and invokes the save operation.
 *
 * @param root Document object.
 * @param url Back-end URL.
 */
function saveDSMetadata(metadata, url, successFunc) {
    let request = $.ajax({
        url: url,
        type: "post",
        async: false,
        headers: { "x-operation-type": HEADER_VALUE_SAVE_DS_METADATA },
        data: { content: metadata },
        success: successFunc
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
    let metadata = EMPTY_STRING;

    // Synchronous request
    let response = $.ajax({
        url: url,
        type: "post",
        async: false,
        headers: { "x-operation-type": HEADER_VALUE_RETRIEVE_DS_METADATA },
        data: { content: datasourceId },
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
        headers: { "x-operation-type": HEADER_VALUE_TEST_DS_CONNECTION },
        data: { content: connectionDetails },
        success: function (msg, status, jqXHR) {
            showDSNotification("success", "Successfully connected to database.", 6000);
        },
        error: function (msg, status, jqXHR) {
            showDSNotification("danger", "Connection failed. Could not connect to database.", 6000);
        }
    });
}

/**
 * Loads default parameters for DB engine types.
 *
 * @param root Document root object.
 * @param dbEngineType Database engine type.
 */
function populateDBEngineDefaults(dbEngineType) {
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

function getDBEngineFromDriverClass(driverClass) {
    if (driverClass === DEFAULT_MYSQL_DRIVER_CLASS) {
        return DB_ENGINE_MYSQL;
    } else if (driverClass === DEFAULT_MSSQL_DRIVER_CLASS) {
        return DB_ENGINE_MSSQL;
    } else if (driverClass === DEFAULT_ORACLE_DRIVER_CLASS) {
        return DB_ENGINE_ORACLE;
    } else if (driverClass === DEFAULT_H2_DRIVER_CLASS) {
        return DB_ENGINE_H2;
    } else if (driverClass === DEFAULT_POSTGRESQL_DRIVER_CLASS) {
        return DB_ENGINE_POSTGRESQL;
    } else if (driverClass === DEFAULT_INFORMIX_DRIVER_CLASS) {
        return DB_ENGINE_INFORMIX;
    } else if (driverClass === DEFAULT_HSQL_DRIVER_CLASS) {
        return DB_ENGINE_HSQLDB;
    } else if (driverClass === DEFAULT_SYBASE_DRIVER_CLASS) {
        return DB_ENGINE_SYBASE;
    } else if (driverClass === DEFAULT_DERBY_DRIVER_CLASS) {
        return DB_ENGINE_APACHEDERBY;
    } else if (driverClass === DEFAULT_IBMDB2_DRIVER_CLASS) {
        return DB_ENGINE_IBMDB2;
    } else {
        EMPTY_STRING;
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
    if (testRDBMSversion != null && testRDBMSversion != undefined) {
        $("#ds-db-version-select").val(testRDBMSversion);
    }
}

function populateDSTestConDetails(urlStr) {
    // Auto setting test connection only for jdbc
    if (urlStr.substring(0, 4) == "jdbc") {
        let host = EMPTY_STRING;
        let port = EMPTY_STRING;
        let dbname = EMPTY_STRING;
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
