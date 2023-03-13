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

$(document).ready(function ($) {
    var timeout = null;
    var portValue = resolveGetParam("port");
    var url = "http://127.0.0.1:" + portValue + "/datasourceeditor/service";
    // Data model JSON which is transfered between design and source views
    var dataModel = {
        "name": EMPTY_STRING,
        "description": EMPTY_STRING,
        "definition": {
            "type": EMPTY_STRING,
            "rdbms_conf": {
                "provider": EMPTY_STRING,
                "default_conf": {
                    "driverClassName": EMPTY_STRING,
                    "url": EMPTY_STRING,
                    "username": EMPTY_STRING,
                    "password": EMPTY_STRING,
                    "db_engine": EMPTY_STRING
                },
                "ext_conf": {
                    "dsClassName": EMPTY_STRING,
                    "properties": []
                },
                "jndi_conf": {
                    "name": EMPTY_STRING,
                    "useDSFactory": false,
                    "properties": []
                },
                "config_parameters": []

            },
            "custom_conf": {
                "ds_type": EMPTY_STRING,
                "config": EMPTY_STRING
            }

        }
    };
    // XML source code
    var xmlSource;

    var checkSpecialCharacterRegex = /[ `!@#$%^&*()_+\-=\[\]{};':"\\|,.<>\/?~]/;

    window.queryElement = [];
    window.validators = [];
    window.params = [];
    window.isInputMappingEdit = false;
    window.mappingToBeDeleted = EMPTY_STRING;
    $.support.cors = true;
    var currentPage = retrieveDSMetadata(CURRENT_PAGE_KEY, url);

    if (currentPage == CURRENT_PAGE_VAL_DESIGN) {
        // Switching to design view
        //Get xml source code edited by user
        $("#ds-form :input").prop("disabled", true);
        $.ajax({
            url: url,
            type: 'GET',
            dataType: 'text',
            cache: false,
            success: function (result) {
                var parser = new DOMParser();
                xmlSource = parser.parseFromString(result, "text/xml");
                var xmlSourceValidity = retrieveDSMetadata(XML_SOURCE_VALIDITY_KEY, url);
                if (xmlSourceValidity != XML_SOURCE_INVALID) {

                    // Get dataModel from the servlet
                    let retrievedDataModelStr = retrieveDSMetadata(DS_METADATA_DATA_MODEL, url);
                    if (retrievedDataModelStr != null && retrievedDataModelStr != "null") {
                        dataModel = JSON.parse(retrievedDataModelStr);
                    }

                    // Update new changes user created to the xml source code in the source view
                    updateDataModelFromXml(dataModel, xmlSource);

                    // Save updated dataModel in the servlet
                    var metadata = DS_METADATA_DATA_MODEL + DS_METADATA_KEYVALUE_SEPARATOR + JSON.stringify(dataModel);
                    saveDSMetadata(metadata, url, function () {

                        // Populate the design view with new dataModel
                        populateDesignViewFromDataModel(dataModel);
                        $("#ds-form :input").prop("disabled", false);
                    });
                }
            },
            error: function (error) {
                $("#ds-form :input").prop("disabled", false);
            }
        });
    }

    /** Start of Event handlers **/

    $("#ds-form").on("change keyup", function (e) {
        e.preventDefault();

        //input validation
        $("#ds-name-inputgroup-error").remove();
        if ($("#ds-name-input").val().trim() == EMPTY_STRING) {
            $("#ds-name-inputgroup").after("<div id='ds-name-inputgroup-error' class='alert alert-danger'>Please provide a datasource name</div>");
        }

        if (checkSpecialCharacterRegex.test($("#ds-name-input").val().trim())) {
            $("#ds-name-inputgroup").after("<div id='ds-name-inputgroup-error' class='alert alert-danger'>Datasource name can not contain special characters</div>");
        }

        var dsName = $("#ds-name-input").val();
        dataModel.name = dsName;

        var dsDescription = $("#ds-desc-input").val();
        dataModel.description = dsDescription;

        var dsType = $("#ds-type-select").val();
        if (dsType == DS_TYPE_RDBMS) {
            $("#ds-rdbms-input-group").toggle(true);
            $("#ds-custom-input-group").toggle(false);

        } else if (dsType == DS_TYPE_CUSTOM) {
            $("#ds-rdbms-input-group").toggle(false);
            $("#ds-custom-input-group").toggle(true);
        }
        dataModel.definition.type = dsType;

        var dsProvider = $("#ds-provider-select").val();
        if (dsProvider == RDBMS_TYPE_DEFAULT) {
            $("#ds-external-input-group").toggle(false);
            $("#ds-default-input-group").toggle(true);

        } else if (dsProvider == RDBMS_TYPE_EXTERNAL) {
            $("#ds-external-input-group").toggle(true);
            $("#ds-default-input-group").toggle(false);

        }
        dataModel.definition.rdbms_conf.provider = dsProvider;


        var dbEngineType = $("#ds-db-engine-select").val();
        if (dataModel.definition.rdbms_conf.default_conf.db_engine != dbEngineType) {
            populateDBEngineDefaults(dbEngineType);
        }
        dataModel.definition.rdbms_conf.default_conf.db_engine = dbEngineType;

        //input validation
        $("#ds-driver-class-inputgroup-error").remove();
        if ($("#ds-driver-class-input").val().trim() == EMPTY_STRING) {
            $("#ds-driver-class-inputgroup").after("<div id='ds-driver-class-inputgroup-error' class='alert alert-danger'>Please provide a driver class name</div>");
        }
        var dsDriverClass = $("#ds-driver-class-input").val();
        dataModel.definition.rdbms_conf.default_conf.driverClassName = dsDriverClass;

        //input validation
        $("#ds-url-inputgroup-error").remove();
        if ($("#ds-url-input").val().trim() == EMPTY_STRING) {
            $("#ds-url-inputgroup").after("<div id='ds-url-inputgroup-error' class='alert alert-danger'>Please provide a driver class name</div>");
        }
        var dsUrl = $("#ds-url-input").val();
        dataModel.definition.rdbms_conf.default_conf.url = dsUrl;

        var dsUsername = $("#ds-username-input").val();
        dataModel.definition.rdbms_conf.default_conf.username = dsUsername;

        var dsPassword = $("#ds-password-input").val();
        dataModel.definition.rdbms_conf.default_conf.password = dsPassword;

        var dsClassName = $("#ds-class-name-input").val();
        dataModel.definition.rdbms_conf.ext_conf.dsClassName = dsClassName;

        var customDSType = $("#ds-custom-ds-type-input").val();
        dataModel.definition.custom_conf.ds_type = customDSType;

        var customConfig = $("#ds-configuration-input").val();
        dataModel.definition.custom_conf.config = customConfig;

        var parameters = [];

        var defaultAutoCommit = $("#ds-default-auto-commit-select").val();
        var defaultReadOnly = $("#ds-default-read-only-select").val();
        var defaultTransactionIsolation = $("#ds-default-transaction-isolation").val();
        var defaultCatalog = $("#ds-default-catalog-input").val();
        var maxActive = $("#ds-max-active-input").val();
        var maxIdle = $("#ds-max-idle-input").val();
        var minIdle = $("#ds-min-idle-input").val();
        var initialSize = $("#ds-initial-size-input").val();
        var maxWait = $("#ds-max-wait-input").val();
        var testOnBorrow = $("#ds-test-on-borrow-select").val();
        var testOnReturn = $("#ds-test-on-return-select").val();
        var testWhileIdle = $("#ds-test-while-idle-select").val();
        var validationQuery = $("#ds-validation-query-input").val();
        var validatorClassName = $("#ds-validation-class-name-input").val();
        var timeBetweenEvictionRunsMillis = $("#ds-time-between-eviction-runs-input").val();
        var numTestsPerEvictionRun = $("#ds-tests-per-eviction-run-input").val();
        var minEvictableIdleTimeMillis = $("#ds-min-evictable-idle-time-input").val();
        var accessToUnderlyingConnectionAllowed = $("#ds-access-underlying-connection-select").val();
        var removeAbandoned = $("#ds-remove-abandoned-select").val();
        var removeAbandonedTimeout = $("#ds-remove-abandoned-timeout-input").val();
        var logAbandoned = $("#ds-log-abandoned-select").val();
        var connectionProperties = $("#ds-connection-properties-input").val();
        var initSQL = $("#ds-init-sql-input").val();
        var jdbcInterceptors = $("#ds-jdbc-interceptors-input").val();
        var validationInterval = $("#ds-validation-interval-input").val();
        var jmxEnabled = $("#ds-jmx-enabled-select").val();
        var fairQueue = $("#ds-fair-queue-select").val();
        var abandonWhenPercentageFull = $("#ds-abandon-when-percentage-full-input").val();
        var maxAge = $("#ds-max-age-input").val();
        var useEquals = $("#ds-use-equals-select").val();
        var suspectTimeout = $("#ds-suspect-timeout-input").val();
        var validationQueryTimeout = $("#ds-validation-query-timeout-input").val();
        var alternateUsernameAllowed = $("#ds-alternate-username-allowed-select").val();

        if (defaultAutoCommit != FALSE_STRING) parameters.push({ "tag": "defaultAutoCommit", "value": defaultAutoCommit });
        if (defaultReadOnly != FALSE_STRING) { parameters.push({ "tag": "defaultReadOnly", "value": defaultReadOnly }); }
        if (defaultTransactionIsolation != "NONE") parameters.push({ "tag": "defaultTransactionIsolation", "value": defaultTransactionIsolation });
        if (defaultCatalog != EMPTY_STRING) parameters.push({ "tag": "defaultCatalog", "value": defaultCatalog });
        if (maxActive != EMPTY_STRING) parameters.push({ "tag": "maxActive", "value": maxActive });
        if (maxIdle != EMPTY_STRING) parameters.push({ "tag": "maxIdle", "value": maxIdle });
        if (minIdle != EMPTY_STRING) parameters.push({ "tag": "minIdle", "value": minIdle });
        if (initialSize != EMPTY_STRING) parameters.push({ "tag": "initialSize", "value": initialSize });
        if (maxWait != EMPTY_STRING) parameters.push({ "tag": "maxWait", "value": maxWait });
        if (testOnBorrow != FALSE_STRING) parameters.push({ "tag": "testOnBorrow", "value": testOnBorrow });
        if (testOnReturn != FALSE_STRING) parameters.push({ "tag": "testOnReturn", "value": testOnReturn });
        if (testWhileIdle != FALSE_STRING) parameters.push({ "tag": "testWhileIdle", "value": testWhileIdle });
        if (validationQuery != EMPTY_STRING) parameters.push({ "tag": "validationQuery", "value": validationQuery });
        if (validatorClassName != EMPTY_STRING) parameters.push({ "tag": "validatorClassName", "value": validatorClassName });
        if (timeBetweenEvictionRunsMillis != EMPTY_STRING) parameters.push({ "tag": "timeBetweenEvictionRunsMillis", "value": timeBetweenEvictionRunsMillis });
        if (numTestsPerEvictionRun != EMPTY_STRING) parameters.push({ "tag": "numTestsPerEvictionRun", "value": numTestsPerEvictionRun });
        if (minEvictableIdleTimeMillis != EMPTY_STRING) parameters.push({ "tag": "minEvictableIdleTimeMillis", "value": minEvictableIdleTimeMillis });
        if (accessToUnderlyingConnectionAllowed != FALSE_STRING) parameters.push({ "tag": "accessToUnderlyingConnectionAllowed", "value": accessToUnderlyingConnectionAllowed });
        if (removeAbandoned != FALSE_STRING) parameters.push({ "tag": "removeAbandoned", "value": removeAbandoned });
        if (removeAbandonedTimeout != EMPTY_STRING) parameters.push({ "tag": "removeAbandonedTimeout", "value": removeAbandonedTimeout });
        if (logAbandoned != FALSE_STRING) parameters.push({ "tag": "logAbandoned", "value": logAbandoned });
        if (connectionProperties != EMPTY_STRING) parameters.push({ "tag": "connectionProperties", "value": connectionProperties });
        if (initSQL != EMPTY_STRING) parameters.push({ "tag": "initSQL", "value": initSQL });
        if (jdbcInterceptors != EMPTY_STRING) parameters.push({ "tag": "jdbcInterceptors", "value": jdbcInterceptors });
        if (validationInterval != EMPTY_STRING) parameters.push({ "tag": "validationInterval", "value": validationInterval });
        if (jmxEnabled != FALSE_STRING) parameters.push({ "tag": "jmxEnabled", "value": jmxEnabled });
        if (fairQueue != FALSE_STRING) parameters.push({ "tag": "fairQueue", "value": fairQueue });
        if (abandonWhenPercentageFull != EMPTY_STRING) parameters.push({ "tag": "abandonWhenPercentageFull", "value": abandonWhenPercentageFull });
        if (maxAge != EMPTY_STRING) parameters.push({ "tag": "maxAge", "value": maxAge });
        if (useEquals != FALSE_STRING) parameters.push({ "tag": "useEquals", "value": useEquals });
        if (suspectTimeout != EMPTY_STRING) parameters.push({ "tag": "suspectTimeout", "value": suspectTimeout });
        if (validationQueryTimeout != EMPTY_STRING) parameters.push({ "tag": "validationQueryTimeout", "value": validationQueryTimeout });
        if (alternateUsernameAllowed != FALSE_STRING) parameters.push({ "tag": "alternateUsernameAllowed", "value": alternateUsernameAllowed });

        dataModel.definition.rdbms_conf.config_parameters = parameters;

        var dsJndiName = $("#ds-jndi-name-input").val();
        dataModel.definition.rdbms_conf.jndi_conf.name = dsJndiName;

        var dsUseDsFactory = $("#ds-use-factory-check").is(":checked");
        dataModel.definition.rdbms_conf.jndi_conf.useDSFactory = dsUseDsFactory;

        updateDataModelFromJNDIPropTable(true);
        updateDataModelFromExtPropTable(true);

        clearTimeout(timeout);

        timeout = setTimeout(function() {
	        xmlSource = generateXmlSource(dataModel);
	        saveAll(xmlSource, url, function () { });
	        var metadata = DS_METADATA_DATA_MODEL + DS_METADATA_KEYVALUE_SEPARATOR + JSON.stringify(dataModel);
	        saveDSMetadata(metadata, url, function () { });
        }, 500);
    });

    //--- Start of External Datasource - Properties table ---//
    $("#ds-ext-properties-add-btn").click(function () {
        var markup = "<tr><td><input type='text' placeholder='Property Name' class='form-control' style='width: 100%;' autocomplete='off' autocorrect='off' autocapitalize'off' spellcheck='false'/></td><td><input type='text' placeholder='Property Value' class='form-control' style='width: 100%;' autocomplete='off' autocorrect='off' autocapitalize'off' spellcheck='false'/></td><td class='text-center'><i class='fa fa-trash'></i></td></tr>";

        $("#ds-ext-properties-table tbody").append(markup);
    });

    function updateDataModelFromExtPropTable(updateOnly) {
        var props = [];

        $("#ds-ext-properties-table table tbody tr").each(function () {
            var tds = $(this).find('td');
            var propName = tds[0].firstChild.value;
            var propValue = tds[1].firstChild.value;

            if (propName != EMPTY_STRING && propValue != EMPTY_STRING) {
                var newProp = { "name": propName, "value": propValue };
                props.push(newProp);
            }
        });

        dataModel.definition.rdbms_conf.ext_conf.properties = props;

        if (!updateOnly) {
            var metadata = DS_METADATA_DATA_MODEL + DS_METADATA_KEYVALUE_SEPARATOR + JSON.stringify(dataModel);
            saveDSMetadata(metadata, url, function () { });
        }
    }

    $(document).on('change', '#ds-ext-properties-table', function () {
        updateDataModelFromExtPropTable();
    });

    $(document).on('click', '#ds-ext-properties-table .fa-trash', function () {
        var row = $(this);
        var tds = $(this).closest("tr").find('td');
        if (tds[0].firstChild.value == EMPTY_STRING && tds[1].firstChild.value == EMPTY_STRING) {
            row.closest("tr").remove();
            return;
        }
        $("#properties-table-validator-delete-confirm-btn").click(function (event) {
            row.closest("tr").remove();
            $("#properties-table-validator-delete-confirm-modal").modal("hide");
            updateDataModelFromExtPropTable();
        });
        $("#properties-table-validator-delete-confirm-modal").modal("show");


    });
    //--- End of External Datasource - Properties table ---//

    //--- Start of jndi properties table ---//
    $("#jndi-properties-add-btn").click(function () {
        var markup = "<tr><td><input type='text' placeholder='Property Name' class='form-control' style='width: 100%;' autocomplete='off' autocorrect='off' autocapitalize'off' spellcheck='false'/></td><td><input type='text' placeholder='Property Value' class='form-control' style='width: 100%;' autocomplete='off' autocorrect='off' autocapitalize'off' spellcheck='false'/></td><td class='text-center'><i class='fa fa-trash'></i></td></tr>";

        $("#jndi-properties-table tbody").append(markup);
    });

    function updateDataModelFromJNDIPropTable(updateOnly) {
        var props = [];

        $("#jndi-properties-table table tbody tr").each(function () {
            var tds = $(this).find('td');
            var propName = tds[0].firstChild.value;
            var propValue = tds[1].firstChild.value;

            if (propName != EMPTY_STRING && propValue != EMPTY_STRING) {
                var newProp = { "name": propName, "value": propValue };
                props.push(newProp);
            }
        });
        dataModel.definition.rdbms_conf.jndi_conf.properties = props;

        if (!updateOnly) {
            var metadata = DS_METADATA_DATA_MODEL + DS_METADATA_KEYVALUE_SEPARATOR + JSON.stringify(dataModel);
            saveDSMetadata(metadata, url, function () { });
        }
    }

    $(document).on('change', '#jndi-properties-table', function () {
        updateDataModelFromJNDIPropTable();
    });

    $(document).on('click', '#jndi-properties-table .fa-trash', function () {
        var row = $(this);
        var tds = $(this).closest("tr").find('td');
        if (tds[0].firstChild.value == EMPTY_STRING && tds[1].firstChild.value == EMPTY_STRING) {
            row.closest("tr").remove();
            return;
        }
        $("#properties-table-validator-delete-confirm-btn").click(function (event) {
            row.closest("tr").remove();
            $("#properties-table-validator-delete-confirm-modal").modal("hide");
            updateDataModelFromJNDIPropTable();
        });
        $("#properties-table-validator-delete-confirm-modal").modal("show");
    });
    //--- End of jndi properties table ---//


    $("#ds-test-conn-btn").click(function () {
        var dbType = $("#ds-db-engine-select").val();
        var username = $("#ds-username-input").val();
        var password = $("#ds-password-input").val();

        if (dbType == EMPTY_STRING) {
            showDSNotification("danger", "Please select the database engine.", 6000);
            return false;
        }

        var version = $("#ds-db-version-select").val();

        var host = $("#ds-host-input").val();
        var port = $("#ds-port-input").val();
        var dbName = $("#ds-dbname-input").val();

        var connStr = dbType + DS_METADATA_KEYVALUE_SEPARATOR + version + DS_METADATA_KEYVALUE_SEPARATOR + username +
            DS_METADATA_KEYVALUE_SEPARATOR + password + DS_METADATA_KEYVALUE_SEPARATOR + host +
            DS_METADATA_KEYVALUE_SEPARATOR + port + DS_METADATA_KEYVALUE_SEPARATOR + dbName;

        testDBConnection(connStr, url);
    });



    /** End of Event handlers **/

});
