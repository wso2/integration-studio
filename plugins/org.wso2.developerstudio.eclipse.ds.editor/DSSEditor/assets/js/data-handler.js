$(document).ready(function ($) {

    let portValue = resolveGetParam("port");
    let url = "http://localhost:" + portValue + "/dsseditor/service";
    let root = "";

    // Retrieve the XML source from backend.
    $.get(url, function (data, status) {

        let parser = new DOMParser();
        root = parser.parseFromString(data, "text/xml");

        populateGeneralDetails(root);
        populateTransportSettings(root);
        populateDataSources(root);

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
        let status = addDataSource(root);

        if (status) {
            $("#ds-add-edit-ds-modal").modal('hide');
            save(root, url);
s
            $.get(url, function (data, status) {
                let parser = new DOMParser();
                console.log("From backend: ");
                console.log(parser.parseFromString(data, "text/xml"));
            });
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
        save(root, url);
    });

    $(document).on('click','#ds-datasources-table .fa-edit',function() {
        let dsId = $(this).closest("tr").data('id');
        populateDSModal(root, dsId);
        openDSModal(true);
    });
    // End of Data sources - Add data source

    // Start of input event handlers - General details
    $("#dss-description-input, #dss-namespace-input").change(function() {
        save(root, url);
    });

    $("#dss-namespace-input").change(function() {
        save(root, url);
    });
    // End of input event handlers - General details

    /** End of Event handlers **/

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
 */
function populateDSModal(root, dsId) {

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

    processDSInputData(root, dataObj, true);

    return true;
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

    let rdbmsType = $("#ds-dstype-select").val();
    let dbTypeExt = $("#ds-dstype-2-select").val();
    let dsId = $("#ds-ds-id-input").val();

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

    if (rdbmsType === "rdbms_ds") {
        if (dbTypeExt === "default_ds") {
            properties.push(createTextNode(root, createPropertyNode(root, "driverClassName"), data['ds-driver-class-input']));
            properties.push(createTextNode(root, createPropertyNode(root, "url"), data['ds-url-input']));
            properties.push(createTextNode(root, createPropertyNode(root, "username"), data['ds-username-input']));
            properties.push(createTextNode(root, createPropertyNode(root, "password"), data['ds-password-input']));
        }

        if (dbTypeExt === "external_ds") {
            properties.push(createTextNode(root, createPropertyNode(root, "dataSourceClassName"), data['ds-class-name-input']));
        }
    } else if (rdbmsType === "carbon_ds") {
        properties.push(createTextNode(root, createPropertyNode(root, "carbon_datasource_name"), data['ds-ds-name-input']));
    }

    // Append properties to config node
    for (let i = 0, len = properties.length; i < len; i++) {
        configElement.appendChild(properties[i]);
    }

    // OData enabled
    configElement.setAttribute("enableOData", $('#ds-enable-odata-check').is(":checked"));

    if (dsConfigs.length > 0) {
        insertAfter(configElement, dsConfigs[dsConfigs.length - 1]);
    } else {
        dataRoot.appendChild(configElement);
    }

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

    if (interval > 0) {
        window.setTimeout(function () {
            $("#ds-notification-alert").fadeTo(500, 0).slideUp(500, function () {
                $(this).remove();
            });
        }, interval);
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
function showDSTableNotification(type, message, interval) {
    let alertHtml = "<span><div id='ds-table-notification-alert' class=\"alert " + "alert-" + type + "\"" + ">" + message + "</div></span>";
    $("#ds-table-notification-alert-holder").html(alertHtml);
    $("#ds-table-notification-alert").show();

    if (interval > 0) {
        window.setTimeout(function () {
            $("#ds-table-notification-alert").fadeTo(500, 0).slideUp(500, function () {
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
 * @returns {*|{getAllResponseHeaders, abort, setRequestHeader, readyState,
 * getResponseHeader, overrideMimeType, statusCode}} Status code
 */
function save(root, url) {
    let serializedData = new XMLSerializer().serializeToString(root);
    console.log(serializedData);

    let request = $.ajax({
        url: url,
        type: "post",
        headers: {"x-operation-type":OPERATION_TYPE_HEADER_SAVE_ALL},
        data: {xmlcontent: serializedData},
        success: function (resData) {
            location.reload();
        }
    });

    return request;
}

