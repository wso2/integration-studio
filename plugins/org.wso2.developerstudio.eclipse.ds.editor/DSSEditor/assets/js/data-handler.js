$(document).ready(function ($) {

    let portValue = resolveGetParam("port");
    let url = "http://127.0.0.1:" + portValue + "/dsseditor/service";
    let root = "";
    let resultElement;
    var onKeyChangeTimer;
    var checkSpecialCharacterRegex = /[ `!@#$%^&*()_+\-=\[\]{};':"\\|,.<>\/?~]/;

    window.queryElement = [];
    window.validators = [];
    window.params = [];
    window.isInputMappingEdit = false;
    window.mappingToBeDeleted = "";

    // Retrieve the XML source from backend.
//    $.get(url, {}, function (data, status) {
//
//        let parser = new DOMParser();
//        root = parser.parseFromString(data, "text/xml");
//        populateGeneralDetails(root);
//        populateTransportSettings(root);
//        populateDataSources(root);
//        populateQueries(root);
//        populateQueryTable(root);
//        populateOperations(root);
//        populateResources(root);
//        populateAdvancedProperties(root);
//        verifyDSMetadata(root, url);
//
//        tl.pg.init({ pg_caption: "Open Help" });
//    });



    $.ajax({
                url: url,
                type: 'GET',
                dataType: 'text',
                cache: false,
                success: function (result) {
                   let parser = new DOMParser();
                   root = parser.parseFromString(result, "text/xml");
                   populateGeneralDetails(root);
                   populateTransportSettings(root);
                   populateDataSources(root);
                   populateQueries(root);
                   populateQueryTable(root);
                   populateOperations(root);
                   populateResources(root);
                   populateAdvancedProperties(root);
                   verifyDSMetadata(root, url);
           
                   tl.pg.init({ pg_caption: "Open Help" });
                },
                error: function (error) {
                }
            });
    
    /** Start of Event handlers **/

    // Start of Transport settings - Transports
    $("#ts-transport-check-row input").change(function () {
        var transportsStr = $('.ts-transport-checkbox:checked').map(function() {
            return this.name;
        }).get().join(' ');

        root.getElementsByTagName("data")[0].setAttribute("transports", transportsStr);
        saveAll(root, url, function() { });
    });
    
    $("#ts-txmjndi-name-input").on("keyup", function(){
        clearInterval(onKeyChangeTimer);
        onKeyChangeTimer = setTimeout(function() {
        	let txJndiName = $('#ts-txmjndi-name-input').val();
            if (txJndiName.trim() != "") {
            	root.getElementsByTagName("data")[0].setAttribute("txManagerJNDIName", txJndiName);
            } else {
            	root.getElementsByTagName("data")[0].removeAttribute("txManagerJNDIName");
            }
            saveAll(root, url, function() { });
        }, 200);
    });
    
    $("#ts-auth-prov-class-input").on("keyup", function(){
        clearInterval(onKeyChangeTimer);
        onKeyChangeTimer = setTimeout(function() {
        	let providerClass = $('#ts-auth-prov-class-input').val();
            if (providerClass.trim() != "") {
            	let authProvider = root.getElementsByTagName("data")[0].getElementsByTagName("authorization_provider");
            	if (authProvider.length > 0) {
            		authProvider[0].setAttribute("class", providerClass);
            	} else {
            		let provider = root.createElement("authorization_provider");
            		provider.setAttribute("class", providerClass);
            		root.getElementsByTagName("data")[0].appendChild(provider);
            	}
            } else {
            	let authProvider = root.getElementsByTagName("data")[0].getElementsByTagName("authorization_provider");
            	if (authProvider.length > 0) {
            		root.getElementsByTagName("data")[0].removeChild(authProvider[0]);
            	}
            }
            saveAll(root, url, function() { });
        }, 200);
    });
    // End of Transport settings - Transports

    // Start of Data sources - Add data source
    $('#ds-secret-alias-check').change(function() {
        if (this.checked) {
        	$('#ds-password-inputgroup').toggle(false);
        	$('#ds-password-sa-inputgroup').toggle(true);
        	$('#ds-test-password-sa-inputgroup').toggle(true);
        } else {
        	$('#ds-password-inputgroup').toggle(true);
        	$('#ds-password-sa-inputgroup').toggle(false);
        	$('#ds-test-password-sa-inputgroup').toggle(false);
        }
    });
    
    $("#ds-add-save-btn").click(function (e) {
    	//check validation
    	let RDBMS_DS_TYPE = "rdbms_ds";
    	let MONGO_DB_TYPE = "mongodb_ds";
    	let CSV_DB_TYPE = "csv";
    	
    	if ($("#ds-ds-id-input").val().trim() == "") {
    		showErrorNotification("danger", "Please provide a datasource identifier", 3000, "ds-notification-alert-holder");
    		return false;
    	}
    	
    	if (checkSpecialCharacterRegex.test($("#ds-ds-id-input").val().trim())) {
    		showErrorNotification("danger", "Datasource identifier can not contain special characters", 3000, "ds-notification-alert-holder");
    		return false;
    	}
    	
    	if ($("#ds-dstype-select").val() == RDBMS_DS_TYPE && $("#ds-db-engine-select").val().trim() == "") {
    		showErrorNotification("danger", "Please provide a database engine", 3000, "ds-notification-alert-holder");
            return false;
    	}
    	
    	if ($("#ds-dstype-select").val() == RDBMS_DS_TYPE && $("#ds-driver-class-input").val().trim() == "") {
    		showErrorNotification("danger", "Please provide a driver class", 3000, "ds-notification-alert-holder");
            return false;
    	}
    	
    	if ($("#ds-dstype-select").val() == RDBMS_DS_TYPE && $("#ds-url-input").val().trim() == "") {
    		showErrorNotification("danger", "Please provide a url", 3000, "ds-notification-alert-holder");
            return false;
    	}
    	
    	if ($("#ds-dstype-select").val() == "carbon_ds" && $("#ds-ds-name-input").val().trim() == "") {
    		showErrorNotification("danger", "Please provide a datasource name", 3000, "ds-notification-alert-holder");
            return false;
    	}
    	
    	if ($("#ds-dstype-select").val() == MONGO_DB_TYPE && $("#ds-server-input").val().trim() == "") {
    		showErrorNotification("danger", "Please define servers.", 3000, "ds-notification-alert-holder");
            return false;
    	}
    	
    	if ($("#ds-dstype-select").val() == MONGO_DB_TYPE && $("#ds-mongo-dbname-input").val().trim() == "") {
    		showErrorNotification("danger", "Please provide a datbase name.", 3000, "ds-notification-alert-holder");
            return false;
    	}
    	
    	if ($("#ds-dstype-select").val() == CSV_DB_TYPE && $("#ds-csv-file-location-input").val().trim() == "") {
            showErrorNotification("danger", "Please provide a csv file location.", 3000, "ds-notification-alert-holder");
            return false;
    	}
    	
    	if ($("#ds-dstype-select").val() == CSV_DB_TYPE && $("#ds-col-header-select").val().trim() == "") {
            showErrorNotification("danger", "Please define the column header row existance.", 3000, "ds-notification-alert-holder");
            return false;
    	}
    	
        e.preventDefault();
        let result = addDataSource(root);

        if (result.status) {
            $("#ds-add-edit-ds-modal").modal('hide');
            saveAll(root, url, saveDSMetadata(root, result.metadata, url));
//            $("#create-ds-form").reset();
        }

    });

    // Start of resource - Add resource
    $("#resource-save-btn").click(function (e) {
    	//check validations
    	if ($("#r-addedit-opname-input").val().trim() == "") {
    		showErrorNotification("danger", "Please provide a resource path", 3000, "resource-notification-alert-holder");
            return false;
    	}
    	
    	if ($("#r-addedit-resourcemethod-select").val().trim() == "") {
    		showErrorNotification("danger", "Please provide a resource method", 3000, "resource-notification-alert-holder");
            return false;
    	}
    	
    	if ($("#r-addedit-queryid-select").val().trim() == "") {
    		showErrorNotification("danger", "Please provide a query id", 3000, "resource-notification-alert-holder");
            return false;
    	}
    	
        e.preventDefault();
        let status = addResource(root);
        if (status) {
            $("#r-resource-addedit-modal").modal('hide');
        	saveAll(root, url, function() {
                populateResources(root);
            });
        }

    });

    $(".modal").on("hidden.bs.modal", function() {
        //$(this).removeData();
        $(':input', '#create-ds-form').not(':button, :submit, :reset, :hidden')
            .removeAttr('checked').removeAttr('selected').not(':checkbox, :radio, select').val('');
        //Reset the resource form on modal hide
        $("#r-resource-addedit-modal").find('form').trigger('reset');
    });

    $("#ds-datasource-add-btn").click(function() {
        $("#create-ds-form").trigger('reset');
        resetDSAddEditModal();
        openDSModal(false);
    });

    $("#ds-test-conn-btn").click(function() {
        let dbType = $("#ds-db-engine-select").val();
        let username = $("#ds-username-input").val();
        let password = $("#ds-password-input").val();
        
        if ($("#ds-secret-alias-check").is(":checked")) {
            password = $("#ds-test-password-sa").val();
        }

        if (dbType == "") {
        	showDSNotification("danger", "Please select the database engine.", 6000);
        	return false;
        }
        
//        if (username == "") {
//        	showDSNotification("danger", "Please provide the username of the connection.", 6000);
//        	return false;
//        } 
//        
//        if (password == "") {
//        	showDSNotification("danger", "Please provide the password of the connection.", 6000);
//        	return false;
//        }
        
        let version = $("#ds-db-version-select").val();
        
        let host = $("#ds-host-input").val();
        let port = $("#ds-port-input").val();
        let dbName = $("#ds-dbname-input").val();

        let connStr = dbType + DS_METADATA_KEYVALUE_SEPARATOR + version + DS_METADATA_KEYVALUE_SEPARATOR + username +
            DS_METADATA_KEYVALUE_SEPARATOR + password + DS_METADATA_KEYVALUE_SEPARATOR + host +
            DS_METADATA_KEYVALUE_SEPARATOR + port + DS_METADATA_KEYVALUE_SEPARATOR + dbName;

        testDBConnection(connStr, url);
    });

    $(document).on('click','#ds-datasources-table .fa-trash',function() {
        let dsId = $(this).closest("tr").data('id');

        $("#ds-delete-confirm-btn").click(function(event) {
            deleteDatasource(root, dsId);
            $(this).closest("tr").remove();
            saveAll(root, url, function() {
                populateDataSources(root);
                $("#ds-delete-confirm-modal").modal("hide");
            });
        });

        $("#ds-delete-confirm-modal").modal("show");

    });

    $(document).on('click','#ds-datasources-table .fa-edit',function() {
        let dsId = $(this).closest("tr").data('id');
        let dsMetadata = retrieveDSMetadata(dsId, url);
        populateDSModal(root, dsId, dsMetadata);
        openDSModal(true);
    });

    $('#ds-db-engine-select').change(function(e) {
        e.preventDefault();
        let dbEngineType = $("#ds-db-engine-select").val();
        populateDBEngineDefaults(root, dbEngineType);
        setTestConnectionRDBMSVersion(dbEngineType);
    });
    
    // End of Data sources - Add data source

    // Start of queries - Add query
    $("#q-query-add-btn").click(function() {
        $("#q-query-add-btn").toggle(false);
        $("#q-queries-table").toggle(false);
        $("#q-table-notification-alert-holder").toggle(false);
        clearAddQueryForm();
        $("#q-add-edit-query-section").toggle(true);
        populateDSListForQueries(root);
        $("#q-im-entries-table").toggle(false);
        $("#q-addedit-title").text("Add Query");
        $("#q-query-id-input").prop('disabled', false);

        $("#q-im-return-gk-checkbox").prop('checked', false);
        $("#q-im-return-ukc-checkbox").prop('checked', false);
        $("#q-im-keycolumns-inputgroup").toggle(false);
        $("#q-im-keycolumns-input").val("");

        window.params = [];
        resetInputMappingSection();
        clearQueryAdvancedProperties();
        clearOutputMappingForm();
        populateOutputTypeElements();
    });

    $("#query-add-save-btn").click(function (e) {
        e.preventDefault();
        
        if (!$("#q-query-id-input").val()) {
        	showErrorNotification("danger", "Please provide a Query ID", 3000, "query-notification-alert-holder");
        	return false;
        }
        
        if (checkSpecialCharacterRegex.test($("#q-query-id-input").val().trim())) {
        	showErrorNotification("danger", "Query ID can not contain special characters", 3000, "query-notification-alert-holder");
        	return false;
    	}

        if ($("#q-datasource-select").val().trim() == "") {
        	showErrorNotification("danger", "Please select a datasource", 3000, "query-notification-alert-holder");
            return false;
        }
        
        window.queryElement = root.createElement("query");
        processQueryDetails(root, window.queryElement);
        saveInputMappingsToQueryElement(window.queryElement);
        if (window.ResultElement != null && window.ResultElement != undefined) {
        	resultElement = window.ResultElement;
        }
        if (resultElement == undefined) {
        	resultElement = root.createElement("result");
        }
        resultElement = saveResultToQueryElement(resultElement, root);
        let queryElement = replaceResultInQuery(resultElement);
        queryElement = replacePropertiesInQuery(root, queryElement);
        let result = addQuery(root, queryElement);

        if (result) {
            saveAll(root, url, function() {
                $("#q-add-edit-query-section").toggle(false);
                $("#q-query-add-btn").toggle(true);
                populateQueryTable(root);

                window.params = [];
                window.validators = [];
            });
        }
    });

    $("#q-input-mapping-generate-btn").click(function() {
        generateInputMappings(root);
    });

    // End of queries - Add query

    // Start of query general
    $("#q-query-id-input").change(function() {
        // Check if data source name already exists
        let queries = root.getElementsByTagName("query");
        let queryId = $("#q-query-id-input").val();

        for (let i = 0, len = queries.length; i < len; i++) {
            if (queries[i].getAttribute("id") == queryId && !$("#q-query-id-input").prop('disabled')) {
                showNotificationAlertModal("Error", "A query with ID " + queryId + " already exists.");
                $("#q-query-id-input").val("");
                return false;
            }
        }
    });

    // Start of query input mapping
    $("#q-im-validators-add-btn").click(function() {
        if ($("#im-mappingname-input").val().trim() === "") {
            showInputMappingNotification("danger", "Please enter a mapping name.", 4000);
            return false;
        }
        $("#q-im-validators-add-btn").toggle(false);
        $("#q-im-validators-table").toggle(false);
        $("#q-im-addedit-validator-section").toggle(true);

        resetValidatorsForm();
    });

    $("#validator-close-btn").click(function() {
        $("#q-im-validators-add-btn").toggle(true);
        $("#q-im-validators-table").toggle(true);
        $("#q-im-addedit-validator-section").toggle(false);

        resetValidatorsForm();
    });

    $("#q-im-validators-save-btn").click(function (e) {
        e.preventDefault();
        
        let validator = $('#q-im-validator-select').val().trim();
        if (validator == "default") {
        	showNotificationAlertModal("Error", "Please select a validator type.");
        	return false;
        }
        
        if (validator != "validatePattern") {
        	let min = $('#im-val-minvalue-input').val().trim();
            if (min == "") {
            	showNotificationAlertModal("Error", "Please define a minimum value.");
            	return false;
            }
            
            let max = $('#im-val-maxvalue-input').val().trim();
            if (max == "") {
            	showNotificationAlertModal("Error", "Please define a maximum value.");
            	return false;
            }
            
        } else {
        	let pattern = $('#im-val-pattern-input').val().trim();
        	if (pattern == "") {
        		showNotificationAlertModal("Error", "Please define a pattern.");
        		return false;
        	}
        }
        
        let selectedValidator = $("#q-im-validator-select").val();
        addValidator(root, selectedValidator);
    });

    $("#q-im-validator-select").change(function() {
    	$("#im-val-maxvalue-input").val(EMPTY_STRING);
    	$("#im-val-minvalue-input").val(EMPTY_STRING);
        validateValidatorsForm();
    });

    $("#im-mappingname-input").change(function() {
        let mappingName = $("#im-mappingname-input").val();
        if(checkIfIMappingExists(root, mappingName)) {
            showInputMappingNotification("danger", "A mapping with the name " + mappingName +
                " already exists.", 4000);
            $("#im-mappingname-input").val("");
        }
    });

    $(document).on('click','#q-im-validators-table .fa-edit',function() {
        let validatorName = $(this).closest("tr").attr('name');
        editValidator(root, validatorName);
    });

    $(document).on('click','#q-im-validators-table .fa-trash',function() {
    	let validatorName = $(this).closest("tr").attr('name');
    	let row = $(this);
    	
    	$("#q-input-mapping-validator-delete-confirm-btn").click(function(event) {
    		removeIfValidatorExists(validatorName);
    		row.closest("tr").remove();
        	$("#q-input-mapping-validator-delete-confirm-modal").modal("hide");
        });
    	
    	$("#q-input-mapping-validator-delete-confirm-modal").modal("show");
    });

    $(document).on('click','#q-im-entries-table .fa-edit',function() {
        let mappingName = $(this).closest("tr").attr('name');
        editInputMapping(root, mappingName);
    });

    $(document).on('click','#q-im-entries-table .fa-trash',function() {
        let mappingName = $(this).closest("tr").attr('name');
        
        $("#q-im-delete-confirm-btn").click(function(event) {
        	deleteInputMapping(mappingName);
        	$("#q-im-delete-confirm-modal").modal("hide");
        });

        $("#q-im-delete-confirm-modal").modal("show");
        
    });

    $("#im-val-maxvalue-input").keypress(function(e){
    	let validatorType = $("#q-im-validator-select").val();
    	if (validatorType == "validateLength") {
    		return isInputEventAllowedForNonNegativeIntegerField(e);
    	}
    	return isInputEventAllowedForNumericField(e,"#im-val-maxvalue-input");
    });

    $("#im-val-minvalue-input").keypress(function(e){
    	let validatorType = $("#q-im-validator-select").val();
    	if (validatorType == "validateLength") {
    		return isInputEventAllowedForNonNegativeIntegerField(e);
    	}
    	return isInputEventAllowedForNumericField(e,"#im-val-minvalue-input");
    });

    // End of query input mapping

    // Start of query output mapping
    
    $(document).on('click','#q-output-mapping-table .fa-edit',function() {
    	$('#output-mapping-modal-header').text("Edit Output Mapping");
    	let tds = $(this).closest("tr").find('td');
    	populateQueryOutputMappingModal(resultElement, tds, root);
    });
    
    $(document).on('click','#q-output-mapping-table .fa-trash',function() {
    	let tds = $(this).closest("tr").find('td');
    	let row = $(this);
    	
    	$("#q-om-delete-confirm-btn").click(function(event) {
    		deleteQueryOutputMappingFromResult(resultElement, tds);
        	row.closest("tr").remove();
        	$("#q-om-delete-confirm-modal").modal("hide");
        });

        $("#q-om-delete-confirm-modal").modal("show");
    	
    });

    $(document).on('click','#q-queries-table .fa-edit',function() {
        let queryId = $(this).closest("tr").attr('data-id');
        resultElement = editQuery(root, queryId);
    });

    $(document).on('click','#q-queries-table .fa-trash',function() {
        let queryId = $(this).closest("tr").attr('data-id');

        $("#q-delete-confirm-btn").click(function(event) {
            let result = deleteQuery(root, queryId);
            if (result) {
                saveAll(root, url, function() {
                    populateQueryTable(root);
                    $("#q-delete-confirm-modal").modal("hide");
                });
            }
        });

        $("#q-delete-confirm-modal").modal("show");
    });

    $('#query-add-close-btn').click(function() {
        window.ResultElement = null;
        clearAddQueryForm();
        $("#q-query-add-btn").toggle(true);
        $("#q-queries-table").toggle(true);
        $("#q-add-edit-query-section").toggle(false);

        populateQueryTable(root);
    });
    
    $('#q-om-addedit-mappingtype-select').change(function(e) {
    	e.preventDefault();
    	populateOutputMappingModal(root, true);
    });
    
    //generate output mapping
    $('#q-output_mapping-gen-btn').click(function (e) {
    	let rslt = generateOutputMapping(root, portValue);
    	if (rslt != null) {
    		resultElement = rslt;
    	}
    });
    
    $('#q-om-addedit-query-select').change(function(e) {
    	let queryid = $("#q-om-addedit-query-select").val(); 
    	populateQueryOutputMappingParamaterTable(root, queryid);
    });
    
    $('#input-mapping-modal-save').click(function(e) {
    	e.preventDefault();
    	
    	let mappingType = $('#q-om-addedit-mappingtype-select').val();
    	if (mappingType == "element" || mappingType == "attribute") {
    		if ($('#q-om-addedit-outputfn-input').val() == "") {
    			showOutputMappingNotification("danger", "Output field name cannot be empty.", 4000);
    			return false;
    		}
    		
    	} else if (mappingType == "query") {
    		if ($('#q-om-addedit-query-select').val() == "") {
    			showOutputMappingNotification("danger", "Select a query.", 4000);
    			return false;
    		}
    		
    	} else if (mappingType == "complex-element") {
    		if ($('#q-om-addedit-elename-input').val() == "") {
    			showOutputMappingNotification("danger", "Element name cannot be empty.", 4000);
    			return false;
    		}
    		
    		let childElementString = $('#om-complex-child-input').val();
    		
    		if (childElementString == "") {
    			showOutputMappingNotification("danger", "Child elements cannot be empty.", 4000);
    			return false;
    		}
    	}
    			
    	let element = processOutputMappingModal(root);
    	resultElement = updateResultElement(root, resultElement, element);
    	
    });
    
    // End of query output mapping
    
    // Start of query advanced properties
    $("#q-timeout-input").keypress(function(e){
        return isInputEventAllowedForNonNegativeIntegerField(e);
    });

    $("#q-adv-fetchsize-input").keypress(function(e){
        return isInputEventAllowedForNonNegativeIntegerField(e);
    });

    $("#q-adv-max-field-size-input").keypress(function(e){
        return isInputEventAllowedForNonNegativeIntegerField(e);
    });

    $("#q-adv-maxrows-input").keypress(function(e){
        return isInputEventAllowedForNonNegativeIntegerField(e);
    });

    // End of query advanced properties

    // Start of input event handlers - General details
    $("#dss-description-input").on("keyup", function(){
        clearInterval(onKeyChangeTimer);
        onKeyChangeTimer = setTimeout(function() {
        	let exists = false;
        	let description = root.getElementsByTagName("description");
            if (description.length > 0) {
            	for (let i = 0, len = description.length; i < len; i++) {
            		if ((description[i].parentElement != undefined && description[i].parentElement != null && description[i].parentElement.localName == "data") 
            				|| (description[i].parentNode != undefined && description[i].parentNode != null && description[i].parentNode.localName == "data")) {
            			exists = true;
            			description[i].textContent = $('#dss-description-input').val();
            			break;
            		}
            	}
            }
            
            if (!exists && $('#dss-description-input').val().trim() != "") {
            	let descriptionElement = root.createElement("description");
                let text_node = root.createTextNode($('#dss-description-input').val());
                descriptionElement.appendChild(text_node);
                root.getElementsByTagName("data")[0].appendChild(descriptionElement);
            }

            saveAll(root, url, function() { });
        }, 200);
    });

    $("#dss-namespace-input").on("keyup", function(){
        clearInterval(onKeyChangeTimer);
        onKeyChangeTimer = setTimeout(function() {
        	let namespaceValue = $('#dss-namespace-input').val();
        	if (namespaceValue != undefined && namespaceValue != "") {
        		root.getElementsByTagName("data")[0].setAttribute("serviceNamespace", namespaceValue);
        	} else {
        		root.getElementsByTagName("data")[0].removeAttribute("serviceNamespace");
        	}
            
            saveAll(root, url, function() { });
        }, 200);
    });
    
    $("#dss-service-group-input").on("keyup", function(){
        clearInterval(onKeyChangeTimer);
        onKeyChangeTimer = setTimeout(function() {
        	
        	let serviceGroupValue = $('#dss-service-group-input').val();
        	if (serviceGroupValue != undefined && serviceGroupValue != "") {
        		root.getElementsByTagName("data")[0].setAttribute("serviceGroup", serviceGroupValue);
        	} else {
        		root.getElementsByTagName("data")[0].removeAttribute("serviceGroup");
        	}
            
            saveAll(root, url, function() { });
        }, 200);
    });
    
    $("#dss-publish-swagger-input").on("keyup", function(){
        clearInterval(onKeyChangeTimer);
        onKeyChangeTimer = setTimeout(function() {
        	
        	let publishSwaggerValue = $('#dss-publish-swagger-input').val();
        	if (publishSwaggerValue != undefined && publishSwaggerValue != "") {
        		root.getElementsByTagName("data")[0].setAttribute("publishSwagger", publishSwaggerValue);
        	} else {
        		root.getElementsByTagName("data")[0].removeAttribute("publishSwagger");
        	}
            
            saveAll(root, url, function() { });
        }, 200);
    });
    
    $(document).on('click','#auth-provider-param-table .fa-trash',function() {
    	let tds = $(this).closest("tr").find('td');
    	let row = $(this);
    	if (tds[0].firstChild.value === "" && tds[1].firstChild.value === "") {
    		row.closest("tr").remove();
    		return;
    	}
    	
    	$("#transport-auth-param-delete-confirm-btn").click(function(event) {
        	let authProvider = root.getElementsByTagName("data")[0].getElementsByTagName("authorization_provider");
        	if (authProvider.length > 0) {
        		let props = authProvider[0].getElementsByTagName("property");
        		for (let i = 0, len = props.length; i < len; i++) {
        			if (props[i].attributes.getNamedItem("name").value == tds[0].firstChild.value) {
        				authProvider[0].removeChild(props[i]);
        				break;
        			}
        		}
        	}
        	row.closest("tr").remove();
        	saveAll(root, url, function() { });
        	$("#transport-auth-param-delete-confirm-modal").modal("hide");
        });
    	
    	$("#transport-auth-param-delete-confirm-modal").modal("show");
    });
    
    $("#auth-provider-param-table > tbody").on("keyup", function(){
        clearInterval(onKeyChangeTimer);
        onKeyChangeTimer = setTimeout(function() {
        	let authProvider;
        	let authProviders = root.getElementsByTagName("data")[0].getElementsByTagName("authorization_provider");
            if (authProviders.length == 0) {
            	authProvider = root.createElement("authorization_provider");
            } else {
            	authProvider = authProviders[0];
            	let props = authProvider.children;
            	if (props == undefined) {
            		props = authProvider.childNodes;
            	}
        		for (let i = 0, len = props.length; i < len; i++) {
        			if (authProvider.children != undefined) {
        				authProvider.children[0].remove();
        			} else if (authProvider.childNodes != undefined) {
        				authProvider.childNodes[0].parentNode.removeChild(authProvider.childNodes[0]);
        			}
        			
            	}
            }
            
            let trs = $('#auth-provider-param-table').find('tr');
            for (let i = 1, len = trs.length; i < len; i++) {
            	let prop = root.createElement("property");
            	prop.setAttribute("name", trs[i].cells[0].firstChild.value);
            	prop.textContent = trs[i].cells[1].firstChild.value;
            	authProvider.appendChild(prop);
        	}
            
            saveAll(root, url, function() { });
        }, 200);
    });
    
    // End of input event handlers - General details
    /** End of Event handlers **/
    
    // Start of Operations
    
    /**
     * Populates query elements and set enableStreaming upon operation modal opening.
     */
    $('#o-operation-add-btn').click(function() {
    	clearOperationForm();
    	populateQueriesForOperationForm(root);
    	$('#o-addedit-enablestreaming-checkbox').prop("checked", true);
    	$("#o-addedit-opname-input").prop('disabled', false);
    });
    
    /**
     * Updates root content with operation details upon modal save.
     */
    $("#operation-form-save-btn").click(function (e) {
        e.preventDefault();
        
        let opName = $('#o-addedit-opname-input').val().trim();
        if (opName == "") {
        	showErrorNotification("danger", "Please define an Operation Name", 3000, "operation-notification-alert-holder");
        	return false;
        }
        
        if (checkSpecialCharacterRegex.test(opName)) {
        	showErrorNotification("danger", "Operation Name can not contain special characters", 3000, "operation-notification-alert-holder");
        	return false;
        }

        
        let qId = $('#o-addedit-queryid-select').val().trim();
        if (qId == "") {
        	showErrorNotification("danger", "Please provide a query ID", 3000, "operation-notification-alert-holder");
        	return false;
        }
        
        // Check for empty values in parameters
        let op_parameters = $('#operation-param-table > tbody')[0].rows;
        for (let i = 0, len = op_parameters.length; i < len; i++) {
        	if (op_parameters.item(i).cells[0].firstChild.value != EMPTY_STRING || op_parameters.item(i).cells[1].firstChild.value != EMPTY_STRING) {
	    		if (op_parameters.item(i).cells[0].firstChild.value == EMPTY_STRING) {
	    			showErrorNotification("danger", "Please provide a query parameter name", 3000, "operation-notification-alert-holder");
	    			return false;
	    		}else if (op_parameters.item(i).cells[1].firstChild.value == EMPTY_STRING) {
	    			showErrorNotification("danger", "Please provide an operation parameter name", 3000, "operation-notification-alert-holder");
	    			return false;
	    		}
        	}
    	}

        let status = addOperation(root);
        if (status) {
        	saveAll(root, url, function() { });
        }
    });
    
    /**
     * Deletes operation table entry and root entry upon delete.
     */
    $(document).on('click','#o-operation-table .fa-trash',function() {
    	let tds = $(this).closest("tr").find('td');

        $("#o-delete-confirm-btn").click(function(event) {
            deleteOperation(root, tds[0].innerText);
            $(this).closest("tr").remove();
            saveAll(root, url, function() {
                populateOperations(root);
                $("#o-delete-confirm-modal").modal("hide");
            });
        });

        $("#o-delete-confirm-modal").modal("show");
    });
    
    /**
     * Populates query parameters upon query id changes.
     */
    $('#o-addedit-queryid-select').change(function(e) {
    	e.preventDefault();
    	let queryid = $("#o-addedit-queryid-select").val(); 
    	populateOperationParamaterTable(root, queryid);
    });
    
    /**
     * Populates operation modal upon edit option.
     */
    $(document).on('click','#o-operation-table .fa-edit',function() {
    	let tds = $(this).closest("tr").find('td');
    	populateOperationForm(root, tds[0].innerText, tds[1].innerText);
    });
    
    // End of Operations

    //Resource related event handlers

    /**
     * Opens modal for adding a new resource
     */
    $("#r-resource-add-btn").click(function() {
    	$('#r-addedit-enablestreaming-checkbox').prop("checked", true);
    	$('#r-addedit-opname-input').prop('disabled', false);
    	populateQueriesListForResources("r-queries-item-table", "r-addedit-queryid-select", 1, root);
        openResourcesModal(false);
    });

    /**
     * Deletes specific resource.
     */
    $(document).on('click','#r-resources-table .fa-trash',function() {
    	let tds = $(this).closest("tr").data('id');
    	let method = $(this).closest("tr").find('td')[1].innerText;

        $("#r-delete-confirm-btn").click(function(event) {
            //deleteOperation(root, tds[0].innerText);
            deleteResource(root, tds, method);
            $(this).closest("tr").remove();
            saveAll(root, url, function() {
                populateResources(root);
                $("#r-delete-confirm-modal").modal("hide");
            });
        });

        $("#r-delete-confirm-modal").modal("show");


    });
    
    /**
     * Opens modal for editing specific resource.
     */
    $(document).on('click','#r-resources-table .fa-edit',function() {
        let resourceId = $(this).closest("tr").data('id');
        let method = $(this).closest("tr").find('td')[1].innerText;
        populateResourcesModal(root, resourceId, method);
        openResourcesModal(true);
    });

    $("#input-mapping-save-btn").click(function (e) {
        e.preventDefault();

        let inMappingName = $('#im-mappingname-input').val();
        if (inMappingName.trim() == "") {
        	showInputMappingNotification("danger", "Please enter a mapping name.", 4000);
        	return false;
        }
        
        let result = addInputMapping(root);

        if (result) {
            $("#q-input-mapping-modal").modal('hide');
//            $("#input-mapping-form").reset();
        }

    });

    $("#q-input-mapping-add-btn").click(function (e) {
        e.preventDefault();

        if (!$("#q-query-id-input").val()) {
            showNotificationAlertModal("Error", "Please provide a query ID.");
            return false;
        }

        if ($("#q-datasource-select").val().trim() == "") {
            showNotificationAlertModal("Error", "Please select a datasource.");
            return false;
        }

        $("#input-mapping-form").trigger('reset');

        resetValidatorsForm();
        resetValidatorsSection();
        updateInputMappingTable();

        $("#q-im-addedit-title").text("Add Input Mapping");
        $('#q-input-mapping-modal').modal({backdrop: 'static', show: false});
        $("#q-input-mapping-modal").modal("show");
    });

    $('#q-im-return-gk-checkbox').change(function () {
        if (this.checked) {
            $("#q-im-keycolumns-inputgroup").toggle(true);
        } else {
            $("#q-im-keycolumns-inputgroup").toggle(false);
        }
    });

    /** End of Event handlers **/
    
    /** Start of advanced properties **/
    
    $("#ac-enable-boxcarring-check").change(function() {
        if (this.checked) {
        	root.getElementsByTagName("data")[0].setAttribute("enableBoxcarring", "true");
        	$('#ac-disable-legacy-boxcarring-group').toggle(true);
        	
        } else {
        	$('#ac-disable-legacy-boxcarring-check').prop("checked", false);
        	$('#ac-disable-legacy-boxcarring-group').toggle(false);
        	let enableBoxcarring = root.getElementsByTagName("data")[0].attributes.getNamedItem("enableBoxcarring");
        	if (enableBoxcarring != null && enableBoxcarring != undefined) {
        		root.getElementsByTagName("data")[0].removeAttribute("enableBoxcarring");
        	}
        	let disableLegacyBoxcarringMode = root.getElementsByTagName("data")[0].attributes.getNamedItem("disableLegacyBoxcarringMode");
        	if (disableLegacyBoxcarringMode != null && disableLegacyBoxcarringMode != undefined) {
        		root.getElementsByTagName("data")[0].removeAttribute("disableLegacyBoxcarringMode");
        	}
        }
        saveAll(root, url, function() { });
    });

    $("#ac-enable-streaming-check").change(function() {
        if (this.checked) {
        	let disableStreaming = root.getElementsByTagName("data")[0].attributes.getNamedItem("disableStreaming");
        	if (disableStreaming != null && disableStreaming != undefined) {
        		root.getElementsByTagName("data")[0].removeAttribute("disableStreaming");
        	}
        } else {
        	root.getElementsByTagName("data")[0].setAttribute("disableStreaming", "true");
        }
        saveAll(root, url, function() { });
    });

    $("#ac-enable-batch-check").change(function() {
        if (this.checked) {
        	root.getElementsByTagName("data")[0].setAttribute("enableBatchRequests", "true");
        } else {
        	let enableBatchRequests = root.getElementsByTagName("data")[0].attributes.getNamedItem("enableBatchRequests");
        	if (enableBatchRequests != null && enableBatchRequests != undefined) {
        		root.getElementsByTagName("data")[0].removeAttribute("enableBatchRequests");
        	}
        }
        saveAll(root, url, function() { });
    });
    
    $("#ac-active-service-status").change(function() {
        if (this.checked) {
        	root.getElementsByTagName("data")[0].setAttribute("serviceStatus", "active");
        } else {
        	let activeServiceStatus = root.getElementsByTagName("data")[0].attributes.getNamedItem("serviceStatus");
        	if (activeServiceStatus != null && activeServiceStatus != undefined) {
        		root.getElementsByTagName("data")[0].removeAttribute("serviceStatus");
        	}
        }
        saveAll(root, url, function() { });
    });

    $("#ac-disable-legacy-boxcarring-check").change(function() {
        if (this.checked) {
        	root.getElementsByTagName("data")[0].setAttribute("disableLegacyBoxcarringMode", "true");
        } else {
        	let disableLegacyBoxcarringMode = root.getElementsByTagName("data")[0].attributes.getNamedItem("disableLegacyBoxcarringMode");
        	if (disableLegacyBoxcarringMode != null && disableLegacyBoxcarringMode != undefined) {
        		root.getElementsByTagName("data")[0].removeAttribute("disableLegacyBoxcarringMode");
        	}
        }
        saveAll(root, url, function() { });
    });

    $("#ds-url-input").change(function () {
        populateDSTestConDetails($("#ds-url-input").val());
    });
    
    /** End of advanced properties **/
});

/**
 * Populates the UI with general DSS data.
 *
 * @param root Document object.
 */
function populateGeneralDetails(root) {
    $('#dss-name-header').text(root.getElementsByTagName("data")[0].attributes.getNamedItem("name").value);

    $('#dss-description-input').val("");
    let description = root.getElementsByTagName("description");
    if (description.length > 0) {
    	for (let i = 0, len = description.length; i < len; i++) {
    		if ((description[i].parentElement != undefined && description[i].parentElement != null && description[i].parentElement.localName == "data")
    				|| (description[i].parentNode != undefined && description[i].parentNode != null && description[i].parentNode.localName == "data")) {
    			$('#dss-description-input').val(description[i].textContent);
    			break;
    		}
    	}
    }
    
    let dataObject = root.getElementsByTagName("data")[0];
    if (dataObject != undefined && dataObject.hasChildNodes()) {
    	let serviceNamespace = dataObject.attributes.getNamedItem("serviceNamespace");
    	if (serviceNamespace != undefined && serviceNamespace != null) {
    		$('#dss-namespace-input').val(serviceNamespace.value);
    	} else {
    		$('#dss-namespace-input').val("");
    	}
    	
    	let serviceGroup = dataObject.attributes.getNamedItem("serviceGroup");
    	if (serviceGroup != undefined && serviceGroup != null) {
    		$('#dss-service-group-input').val(serviceGroup.value);
    	} else {
    		$('#dss-service-group-input').val("");
    	}
    	
    	let publishSwagger = dataObject.attributes.getNamedItem("publishSwagger");
    	if (publishSwagger != undefined && publishSwagger != null) {
    		$('#dss-publish-swagger-input').val(publishSwagger.value);
    	} else {
    		$('#dss-publish-swagger-input').val("");
    	}
    }
}

/**
 * Populates Transport settings data.
 *
 * @param root Document object.
 */
function populateTransportSettings(root) {
    let transports = root.getElementsByTagName("data")[0].attributes.getNamedItem("transports");
    let transportValues;

    if (transports !== undefined && transports !== null) {
        transportValues = transports.value.split(" ");
        $('#ts-http-check').prop('checked', (transportValues.indexOf("http") >= 0));
        $('#ts-https-check').prop('checked', (transportValues.indexOf("https") >= 0));
        $('#ts-local-check').prop('checked', (transportValues.indexOf("local") >= 0));
        $('#ts-jms-check').prop('checked', (transportValues.indexOf("jms") >=0 ));
    }
    
    let txManagerJNDIName = root.getElementsByTagName("data")[0].attributes.getNamedItem("txManagerJNDIName");
    if (txManagerJNDIName != null && txManagerJNDIName != undefined) {
    	$('#ts-txmjndi-name-input').val(txManagerJNDIName.value);
    }
    let authProvider = root.getElementsByTagName("data")[0].getElementsByTagName("authorization_provider");
    if (authProvider.length > 0) {
    	let className = authProvider[0].attributes.getNamedItem("class");
    	$('#ts-auth-prov-class-input').val(className.value);
    	$('#auth-provider-param-table').find('tbody').find('tr').detach();
    	let props = authProvider[0].getElementsByTagName("property");
    	$.each(props, function (index, prop) {
    		let propVal = prop.innerHTML;
    		if (propVal == undefined) {
    			propVal = prop.textContent;
    		}
    		let prop_row = "<tr><td><input type=\"text\" placeholder=\"Name\" style=\"width: 100%;\" value='" + prop.attributes.getNamedItem("name").value + "' /></td><td>" 
    			+ "<input type=\"text\" placeholder=\"Value\" style=\"width: 100%;\" value='" + propVal + "' /></td><td class=\"text-center\"><i class=\"fa fa-trash\"></i></td></tr>";
    		$('#auth-provider-param-table > tbody').append(prop_row);
    	});
    } else {
    	$('#ts-auth-prov-class-input').val("");
    	$('#auth-provider-param-table').find('tbody').find('tr').detach();
    }
}

/**
 * Populated query details.
 *
 * @param root Document object.
 */
function populateQueries(root) {
    let queryConfigs = root.getElementsByTagName("query");
    if (queryConfigs.length == 0 || queryConfigs === undefined || queryConfigs === null)  {
        $("#q-queries-table").hide();
        showQueriesTableNotification("info", "No queries available. Click 'Add New' to create a new query.", 0);
        return;
    }
}


/**
 * Opens the resource Add/Edit modal.
 *
 * @param isEditEnabled 'True' to open a data source in edit mode. 'False' to add a new data source.
 */
function openResourcesModal(isEditEnabled) {
    if (isEditEnabled) {
        $("#resource-modal-header").text("Edit Resource");
    } else {
        $("#resource-modal-header").text("Create Resource");
    }
    $('#r-resource-addedit-modal').modal({backdrop: 'static', show: false});
    $("#r-resource-addedit-modal").modal('show');
}

/**
 * Shows an alert of a given type in the resource table.
 *
 * @param type Type of the alert: success | info | warning | danger
 * @param message Message to be displayed.
 * @param interval Number of milliseconds before the notification disappears. If not provided or '0',
 * notification will stay forever.
 */
function showResourceTableNotification(type, message, interval) {
    let alertHtml = "<span><div id='resource-table-notification-alert' class=\"alert " + "alert-" + type + "\"" + ">" + message + "</div></span>";
    $("#resource-table-notification-alert-holder").html(alertHtml);
    $("#resource-table-notification-alert").show();

    showAlert("resource-table-notification-alert", interval);
}

/**
 * Shows an alert of a given type in the resource editor modal.
 *
 * @param type Type of the alert: success | info | warning | danger
 * @param message Message to be displayed.
 * @param interval Number of milliseconds before the notification disappears. If not provided or '0',
 * notification will stay forever.
 */
function showResourceNotification(type, message, interval) {
    let alertHtml = "<div id='resource-notification-alert' class=\"alert " + "alert-" + type + "\"" + ">" + message + "</div>";
    $("#resource-notification-alert-holder").html(alertHtml);
    $("#resource-notification-alert").show();

    showAlert("resource-notification-alert", interval);
}

/**
 * Shows a bootstrap alert for a given interval. If the interval is 0, it will be shown infinitely.
 *
 * @param selector ID of the alert.
 */
function showAlert(selector, interval) {
    if (interval > 0) {
        window.setTimeout(function () {
            $("#" + selector).fadeTo(500, 0).slideUp(500, function () {
                $(this).remove();
            });
        }, interval);
    }
}

/**
 * Creates and returns a new 'property' node.
 *
 * @param root Document object.
 * @param name Name of the property.
 * @returns {HTMLElement | any | ActiveX.IXMLDOMElement} Created node.
 */
function createPropertyNode(root, name) {
    let newNode = root.createElement("property");
    newNode.setAttribute("name", name);
    return newNode;
}

/**
 * Creates a text node in a given parent node.
 *
 * @param root Document object.
 * @param parentNode Parent Node.
 * @param textContent Text content.
 * @returns {*} Parent node object.
 */
function createTextNode(root, parentNode, textContent) {
    let newTextNode = root.createTextNode(textContent);
    parentNode.appendChild(newTextNode);
    return parentNode;
}

/**
 * Creates and returns a new 'with-param' node.
 *
 * @param root Document object.
 * @param name Name of the with param node.
 * @param queryParam queryParam property.
 * @returns {HTMLElement | any | ActiveX.IXMLDOMElement} Created node.
 */
function createWithParamNode(root, name, queryParam) {
    let newNode = root.createElement("with-param");
    newNode.setAttribute("name", name);
    newNode.setAttribute("query-param", queryParam);
    return newNode;
}

/**
 * Inserts a node after a given reference node.
 *
 * @param newNode New node.
 * @param refNode Reference node.
 */
function insertAfter(newNode, refNode) {
    refNode.parentNode.insertBefore(newNode, refNode.nextSibling);
}

/**
 * Replace a node with a given reference node.
 *
 * @param newNode New node.
 * @param refNode Reference node.
 */
function replaceNode(newNode, refNode) {
    refNode.replaceWith(newNode);
}

/**
 * This function sends the modified source to the back-end and invokes the save operation.
 *
 * @param root Document object.
 * @param url Back-end URL.
 * @param successFunc Success callback function.
 */
function saveAll(root, url, successFunc) {
    let serializedData = new XMLSerializer().serializeToString(root);
    serializedData = serializedData.split(/xmlns\:NS[0-9]+=\"\" NS[0-9]+\:/).join("");
    let prettyXmlText;
    let isIE = false || !!document.documentMode;

    prettyXmlText = new XmlBeautify().beautify(serializedData, 
         {indent: "  ",useSelfClosingElement: true});

    let request = $.ajax({
        url: url,
        type: "post",
        headers: {"x-operation-type":OPERATION_TYPE_HEADER_SAVE_ALL},
        data: {content: prettyXmlText},
        success: successFunc
    });
}


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
 * Processes the add resources view.
 *
 * @param root Document object
 * @param editResource whether to edit the resource
 */
function addResource(root) {
    // Check if data source name already exists
    let resourceConfigs = root.getElementsByTagName("resource");
    let resourceId = $("#r-addedit-opname-input").val();
    let methodValue = $("#r-addedit-resourcemethod-select-original").val();
    let resourceMethod = $("#r-addedit-resourcemethod-select").val();
    let resourceIndex = -1;
    let editResource = false;
    let isValid = validateResourceFields(resourceId, resourceMethod);
    if (!isValid) {
    	showResourceNotification("danger",
		"Please complete all the required fields", 4000);
		return false;
    }

    // resource method is used here only to determine the current node
    // Actual serialized value is fetch in processResourceInputData function
    if (!(methodValue == null || methodValue.trim() == '')) {
    	resourceMethod = methodValue;
    }
    
    // Check whether 
    if ($("#resource-modal-header").text() == "Edit Resource") {
    	editResource = true;
    }

	for (let i = 0, len = resourceConfigs.length; i < len; i++) {
		if ((resourceConfigs[i].getAttribute("path") == resourceId)
				&& (resourceConfigs[i].getAttribute("method").toLowerCase() == resourceMethod.toLowerCase())) {
			if (editResource) {
				resourceIndex = i;
				break;
			} else {
				showResourceNotification("danger",
						"A resource with the given name already exists.", 4000);
				return false;
			}
		}
	}

    // Process the form
    let formData = $("#resource-form").find(':visible').serializeArray();
    let dataObj = {};

    $(formData).each(function(i, field){
        dataObj[field.name] = field.value;
    });

    processResourceInputData(root, dataObj, resourceIndex, editResource);

    return true;
}

/**
 * Populates the Resource modal when editing an existing resource.
 *
 * @param root Document root object.
 * @param resourceId resource ID.
 */
function populateResourcesModal(root, resourceId, method) {
	let resourceConfigs = root.getElementsByTagName("resource");
	$('#r-addedit-opname-input').val(resourceId);
	$("#r-addedit-opname-input").prop('disabled', true);
    for (let i = 0, len = resourceConfigs.length; i < len; i++) {
        if ((resourceConfigs[i].getAttribute("path") == resourceId) && (resourceConfigs[i].getAttribute("method") == method)) {
			let resourceMethod = resourceConfigs[i].getAttribute("method").toLowerCase();
			$('#r-addedit-resourcemethod-select').val(resourceMethod.toUpperCase());
			$('#r-addedit-resourcemethod-select-original').val(resourceMethod);
			let queryName = resourceConfigs[i]
					.getElementsByTagName("call-query")[0].getAttribute("href");
			$('#r-addedit-queryid-select').val(queryName).trigger('change');
			if (resourceConfigs[i].getElementsByTagName("description")[0] != undefined) {
				$('#r-addedit-description-input').val(resourceConfigs[i]
				.getElementsByTagName("description")[0].textContent);
			}
			let returnRequest = resourceConfigs[i]
					.getAttribute("returnRequestStatus");
			if (returnRequest == "true") {
				$('#r-addedit-returnreqstatus-checkbox').prop("checked", true);
			} else {
				$('#r-addedit-returnreqstatus-checkbox').prop("checked", false);
			}
			
			let disableStreaming = resourceConfigs[i].getAttribute("disableStreaming");
			if (disableStreaming == "true") {
				$('#r-addedit-enablestreaming-checkbox').prop("checked", false);
			} else {
				$('#r-addedit-enablestreaming-checkbox').prop("checked", true);
			}
        }
    }
}

/**
 * Processes form input data of the create/edit resource form.
 * 
 * @param root
 *            Document root element.
 * @param data
 *            Form data in data['field-name'] format.
 * @param index
 *            index of the resource node
 */
function processResourceInputData(root, data, index, editResource) {
    let dataRoot = root.getElementsByTagName("data")[0];
    let resourceConfigs = root.getElementsByTagName("resource");

    let resourceMethod = $("#r-addedit-resourcemethod-select").val();
    let resourcePath = $("#r-addedit-opname-input").val();
    let queryID = $("#r-addedit-queryid-select").val();
    let description = $("#r-addedit-description-input").val();
    let returnRequest = $("#r-addedit-returnreqstatus-checkbox:checked").val() ? true : false;
    let disableStreaming = $("#r-addedit-enablestreaming-checkbox:checked").val() ? true : false;

    // Create a new config element
    let resourceElement = root.createElement("resource");
    resourceElement.setAttribute("method", resourceMethod);
    resourceElement.setAttribute("path", resourcePath);
    if (returnRequest) {
    	resourceElement.setAttribute("returnRequestStatus", true);
    }
    
    if (!disableStreaming) {
    	resourceElement.setAttribute("disableStreaming", true);
    }

    let descriptionElement = root.createElement("description");
    descriptionElement.textContent = description;
    resourceElement.appendChild(descriptionElement);

    let callQueryElement = root.createElement("call-query");
    callQueryElement.setAttribute("href", queryID);
    resourceElement.appendChild(callQueryElement);

    let properties = [];

	var items=[];
	//Iterate all tr's in second column
	$('#resource-param-table tbody tr').each( function(){
	   //add item to array
	   var $tds = $(this).find('td');
	      var row = [];
	      $tds.each(function (i, el){
	        row.push($(this).text());
	      });
	   items.push(row);
	});

	//restrict array to unique items
	var items = $.unique( items );
    // Append properties to config node
    for (let i = 0, len = items.length; i < len; i++) {
    	properties.push(createWithParamNode(root, items[i][0], items[i][1]));
    }

    // Append properties to config node
    for (let i = 0, len = properties.length; i < len; i++) {
    	callQueryElement.appendChild(properties[i]);
    }

//    if (editResource && index != -1) {
//    	replaceNode(resourceElement, resourceConfigs[index]);
//    }
    
    let exists = editResource && index != -1;
    if (resourceConfigs.length > 0 && exists) {
    	// Deletes if operation node exists
        for (let i = 0, len = resourceConfigs.length; i < len; i++) {
            if (index == i) {
            	// Delete the node.
            	dataRoot.removeChild(resourceConfigs[0]);
            	dataRoot.appendChild(resourceElement);
            } else {
            	let current_op = resourceConfigs[0];
            	dataRoot.removeChild(resourceConfigs[0]);
            	dataRoot.appendChild(current_op);
            }
        }
    } else {
    	dataRoot.appendChild(resourceElement);
    }
    
    if (resourceConfigs.length > 0 && !exists) {
    	dataRoot.appendChild(resourceElement);
    }
    
    

//    if (resourceConfigs.length > 0) {
//		insertAfter(resourceElement,
//				resourceConfigs[resourceConfigs.length - 1]);
//	} else {
//		dataRoot.appendChild(resourceElement);
//	}
}

/**
 * Populate queries list for resources modal
 * 
 * @param tableId
 *            queries table element ID
 * @param selectId
 *            select element which should be populated
 * @param columnNo
 *            table's column number of the queryID column
 * @param root
 *            Document root element.
 */
function populateQueriesListForResources(tableId, selectId, columnNo, root) {
	var items=[], options=[];

	$('#'+selectId).find('option').remove();
	let option = new Option("-- Select Query --", "", true, "");
	$('#'+selectId).append(option);
	let queries = root.getElementsByTagName("query");
	for (let i = 0, len = queries.length; i < len; i++) {
		let name = queries[i].getAttribute("id");
		items.push(name);
	}

	//restrict array to unique items
	var items = $.unique( items );

	//iterate unique array and build array of select options
	$.each( items, function(i, item){
	    options.push('<option value="' + item + '">' + item + '</option>');
	})

	//finally empty the select and append the items from the array
	$('#'+selectId).append( options.join());

    $('#'+selectId).change(function(e) {
    	e.preventDefault();
    	let queryid = $('#'+selectId).val();
    	populateResourceParameterTable(root, queryid);
    });
    $('#'+selectId).trigger('change');
}

/**
 * Populates Data sources data.
 *
 * @param root Document object.
 */
function populateResources(root) {
    var resourceConfigs = root.getElementsByTagName("resource");

    if (resourceConfigs.length == 0 || resourceConfigs === undefined || resourceConfigs === null)  {
        $("#r-resources-table").hide();
        $("#resource-table-notification-alert-holder").show();
        showResourceTableNotification("info", "No resources available. Click 'Add New' to create a new resource.", 0);
        return;
    }

    $("#r-resources-table").show();
    $("#resource-table-notification-alert-holder").hide();
    $("#r-resources-table tbody").empty();
    for (let i = 0, len = resourceConfigs.length; i < len; i++) {
        let resourceName = resourceConfigs[i].getAttribute("path");
        let method = resourceConfigs[i].getAttribute("method");
        let queryID = resourceConfigs[i].getElementsByTagName("call-query")[0].getAttribute("href");
        let markup = "<tr" + " data-id='" + resourceName + "'" + "><td>" + resourceName + "</td><td>" + method + "</td><td>" + queryID + "</td><td class='text-center'>" +
            "<i class='fa fa-edit'></i><i class='fa fa-trash'></i></td></tr>";

        $("#r-resources-table tbody").append(markup);
    }

    populateQueriesListForResources("r-queries-item-table", "r-addedit-queryid-select", 1, root);
}

/**
 * Function that deletes a specific node from the DOM tree.
 *
 * @param root Document root object.
 * @param resourceName resource name which should be deleted.
 */
function deleteResource(root, resourceName, method) {
    let resources = root.getElementsByTagName("resource");
    let deletables = [];
    for (let i = 0, len = resources.length; i < len; i++) {
        if ((resources[i].getAttribute("path") == resourceName) && (resources[i].getAttribute("method") == method)) {
            // Delete the node.
            deletables.push(resources[i]);
        }
    }

    for (let i = 0, len = deletables.length; i < len; i++) {
       root.documentElement.removeChild(deletables[i]);
    }

}

/**
 * Populates resource parameter table in resources modal upon query ID selection
 *
 * @param root Document root object.
 * @param queryId query name which should be deleted.
 */
function populateResourceParameterTable(root, queryId) {
    let queries = root.getElementsByTagName("query");
    let items = [];
    for (let i = 0, len = queries.length; i < len; i++) {
		if (queries[i].getAttribute("id") == queryId) {
			// Delete the node.
			let params = queries[i].getElementsByTagName("param");
			for (let j = 0, len = params.length; j < len; j++) {
				let paramName = params[j].getAttribute("name");
				items.push(paramName);
			}
		}
    }

    $("#resource-param-table tbody").empty();
    for (let i = 0, len = items.length; i < len; i++) {
        let markup = "<tr" + " data-id='" + items[i] + "'" + "><td>" + items[i] + "</td><td>" + items[i] + "</td></tr>";
        $("#resource-param-table tbody").append(markup);
    }
}

function validateResourceFields(resourcePath, methodValue) {
	if(resourcePath == null || resourcePath.trim() == '') {
		return false;
	} else if (methodValue == null || methodValue.trim() == 'select') {
		return false;
	}
	return true;
}

function showNotificationAlertModal(title, content) {
    $("#alert-modal-title").text(title);
    $("#alert-modal-content").text(content);

    $('#alert-modal').modal({backdrop: 'static', show: false});
    $("#alert-modal").modal('show');
}

function showErrorNotification(type, message, interval, modalId) {
	let errorTagId = "error-notification-alert-" + message.replace(/\s/g, "").toLowerCase();
    let alertHtml = "<div id='" + errorTagId + "' class=\"alert " + "alert-" + type + "\"" + ">" + message + "</div>";
    $("#" + modalId).html(alertHtml);
    $("#" + errorTagId).show();

    showAlert(errorTagId, interval);
}

/**
 * Given an input event of a field which should allow only non negative integers,
 * the method decide whether the event is allowed or not.
 *
 * @param event On key press event.
 * @param isInputEventAllowedForNonNegativeIntegerField event validity.
 */
function isInputEventAllowedForNonNegativeIntegerField(event) {
	 return !isNaN(String.fromCharCode(event.keyCode));
}

/**
 * Given an input event of a numeric field the method decide whether the event is allowed or not.
 *
 * @param event On key press event.
 * @param inputFieldName name of the input field.
 * @param isInputEventAllowedForNumericField event validity.
 */
function isInputEventAllowedForNumericField(event,inputFieldName) {
	let oldValue = $(inputFieldName).val();
	let characterPosition = $(inputFieldName).prop('selectionStart');
	// Allow negative sign or . as the first character
	if (oldValue == EMPTY_STRING && (event.keyCode == 45 || event.keyCode == 46)) {
		return true;
	}
	let newValue = oldValue.slice(0, characterPosition) + String.fromCharCode(event.keyCode) + oldValue.slice(characterPosition);
	return !isNaN(newValue);
}

function isIE() {
	return false || !!document.documentMode;
}