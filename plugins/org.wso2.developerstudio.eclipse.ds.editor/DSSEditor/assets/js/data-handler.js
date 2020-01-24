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
            this.reset();
        }

    });

    $(".modal").on("hidden.bs.modal", function() {
        //$(this).removeData();
        $(':input', '#create-ds-form').not(':button, :submit, :reset, :hidden')
            .removeAttr('checked').removeAttr('selected').not(':checkbox, :radio, select').val('');
    });

    $("#ds-datasource-add-btn").click(function() {
        $("#create-ds-form").trigger('reset');
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
 * Populated query details.
 *
 * @param root Document object.
 */
function populateQueries(root) {
    let queryConfigs = root.getElementsByTagName("query2");

    if (queryConfigs.length == 0 || queryConfigs === undefined || queryConfigs === null)  {
        $("#q-queries-table").hide();
        showQueriesTableNotification("info", "No queries available. Click 'Add New' to create a new query.", 0);
        return;
    }
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


