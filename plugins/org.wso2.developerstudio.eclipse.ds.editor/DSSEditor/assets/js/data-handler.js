$(document).ready(function ($) {

    let portValue = resolveGetParam("port");
    // let url = "http://localhost:" + portValue + "/dsseditor/service";
    let url = "http://localhost:7774/dsseditor/service";
    let root = "";

    // Retrieve the XML source from backend.
    $.get(url, function (data, status) {

        let parser = new DOMParser();
        root = parser.parseFromString(data, "text/xml");

        populateGeneralDetails(root);
        populateTransportSettings(root);
        populateDataSources(root);
        populateQueries(root);
        populateOperations(root);

    });

    /** Start of Event handlers **/

    // Start of Transport settings - Transports
    $("#ts-transport-check-row input").change(function () {
        var transportsStr = $('.ts-transport-checkbox:checked').map(function() {
            return this.name;
        }).get().join(' ');

        root.getElementsByTagName("data")[0].attributes.getNamedItem("transports").value = transportsStr;
    });
    // End of Transport settings - Transports

    // Start of Data sources - Add data source
    $("#create-ds-form").submit(function (e) {
        e.preventDefault();
        let result = addDataSource(root);

        if (result.status) {
            $("#ds-add-edit-ds-modal").modal('hide');
            saveAll(root, url, saveDSMetadata(result.metadata, url));
        }

    });

    $(".modal").on("hidden.bs.modal", function() {
        //$(this).removeData();
        $(':input', '#create-ds-form').not(':button, :submit, :reset, :hidden')
            .removeAttr('checked').removeAttr('selected').not(':checkbox, :radio, select').val('');
    });

    $("#ds-datasource-add-btn").click(function() {
        console.log(root);
        openDSModal(false);
    });

    $(document).on('click','#ds-datasources-table .fa-trash',function() {
        let dsId = $(this).closest("tr").data('id');
        deleteDatasource(root, dsId);
        $(this).closest("tr").remove();
        saveAll(root, url, function() {
            location.reload();
        });
    });

    $(document).on('click','#ds-datasources-table .fa-edit',function() {
        let dsId = $(this).closest("tr").data('id');
        let dsMetadata = retrieveDSMetadata(dsId, url);
        populateDSModal(root, dsId, dsMetadata);
        openDSModal(true);
    });
    // End of Data sources - Add data source

    // Start of queries - Add query
    $("#q-query-add-btn").click(function() {
        $("#q-query-add-btn").toggle(false);
        $("#q-queries-table").toggle(false);
        $("#q-add-edit-query-section").toggle(true);
    });
    // End of queries - Add query

    // Start of input event handlers - General details
    $("#dss-description-input, #dss-namespace-input").change(function() {
        let description = root.getElementsByTagName("description")[0];

        if (description.hasChildNodes()) {
            description.childNodes[0].nodeValue = $('#dss-description-input').val();
        } else {

        }

        saveAll(root, url, function() {
            location.reload();
        });
    });

    $("#dss-namespace-input").change(function() {
        saveAll(root, url, function() {
            location.reload();
        });
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
    });
    
    /**
     * Updates root content with operation details upon modal save.
     */
    $("#operation-form-save-btn").click(function (e) {
        e.preventDefault();
        let status = addOperation(root);
        if (status) {
        	saveAll(root, url, function() {
                location.reload();
            });
        }
    });
    
    /**
     * Deletes operation table entry and root entry upon delete.
     */
    $(document).on('click','#o-operation-table .fa-trash',function() {
    	let tds = $(this).closest("tr").find('td');
    	deleteOperation(root, tds[0].innerText);
    	$(this).closest("tr").remove();
    	saveAll(root, url, function() {
            location.reload();
        });
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


});


/**
 * Populates the UI with general DSS data.
 *
 * @param root Document object.
 */
function populateGeneralDetails(root) {
    $('#dss-name-header').text(root.getElementsByTagName("data")[0].attributes.getNamedItem("name").value);

    let description = root.getElementsByTagName("description")[0];
    let namespace = root.getElementsByTagName("data")[0];

    if (description.hasChildNodes()) {
        $('#dss-description-input').val(description.childNodes[0].nodeValue);
    }

    if (namespace.hasChildNodes()) {
        $('#dss-namespace-input').val(namespace.attributes.getNamedItem("serviceNamespace").value);
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
        transportValues.forEach(function (item, index) {
            item = item.trim();
            if (item == "http") {
                $('#ts-http-check').prop('checked', true);
            } else if (item == "https") {
                $('#ts-https-check').prop('checked', true);
            } else if (item == "local") {
                $('#ts-local-check').prop('checked', true);
            } else if (item == "jms") {
                $('#ts-jms-check').prop('checked', true);
            }
        });
    }
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


}

function populateQueries(root) {
    let queryConfigs = root.getElementsByTagName("query2");

    if (queryConfigs.length == 0 || queryConfigs === undefined || queryConfigs === null)  {
        $("#q-queries-table").hide();
        showQueriesTableNotification("info", "No queries available. Click 'Add New' to create a new query.", 0);
        return;
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
        if (dsConfigs[i].id == datasourceId) {
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
    };
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
                return;
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
 * Opens the data sources Add/Edit modal.
 *
 * @param isEditEnabled 'True' to open a data source in edit mode. 'False' to add a new data source.
 */
function openDSModal(isEditEnabled) {
    if (isEditEnabled) {
        $("#ds-modal-header").text("Edit Datasource");
    } else {
        $("#ds-modal-header").text("Create Datasource");
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
 * Shows an alert of a given type in the data sources table.
 *
 * @param type Type of the alert: success | info | warning | danger
 * @param message Message to be displayed.
 * @param interval Number of milliseconds before the notification disappears. If not provided or '0',
 * notification will stay forever.
 */
function showQueriesTableNotification(type, message, interval) {
    let alertHtml = "<span><div id='q-table-notification-alert' class=\"alert " + "alert-" + type + "\"" + ">" + message + "</div></span>";
    $("#q-table-notification-alert-holder").html(alertHtml);
    $("#q-table-notification-alert").show();

    showAlert("q-table-notification-alert", interval);
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
 * Inserts a node after a given reference node.
 *
 * @param newNode New node.
 * @param refNode Reference node.
 */
function insertAfter(newNode, refNode) {
    refNode.parentNode.insertBefore(newNode, refNode.nextSibling);
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

    let request = $.ajax({
        url: url,
        type: "post",
        headers: {"x-operation-type":OPERATION_TYPE_HEADER_SAVE_ALL},
        data: {xmlcontent: serializedData},
        success: successFunc
    });
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

function retrieveDSMetadata(datasourceId, url) {
    let response = $.ajax({
        url: url,
        type: "post",
        async: false,
        headers: {"x-operation-type":HEADER_VALUE_RETRIEVE_DS_METADATA},
        data: {xmlcontent: datasourceId},
        success: function (resData) {
            return resData;
        }
    });

    return response;
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
