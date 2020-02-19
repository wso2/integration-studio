/**
 * Populates Query data.
 *
 * @param root Document object.
 */
function populateQueryTable(root) {
    $("#q-queries-table tbody tr").remove();
    let queryConfigs = root.getElementsByTagName("query");

    if (queryConfigs.length == 0 || queryConfigs === undefined || queryConfigs === null)  {
        $("#q-queries-table").hide();
        $("#q-table-notification-alert-holder").toggle(true);
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
 * Shows an alert of a given type in the input mappings editor modal.
 *
 * @param type Type of the alert: success | info | warning | danger
 * @param message Message to be displayed.
 * @param interval Number of milliseconds before the notification disappears. If not provided or '0',
 * notification will stay forever.
 */
function showInputMappingNotification(type, message, interval) {
    let alertHtml = "<div id='q-im-notification-alert' class=\"alert " + "alert-" + type + "\"" + ">" + message + "</div>";
    $("#q-im-notification-alert-holder").html(alertHtml);
    $("#q-im-notification-alert").show();

    showAlert("q-im-notification-alert", interval);
}

/**
 * Creates a new input mapping configuration.
 * @param root Document root.
 * @returns {boolean} 'True' if successful, 'False' otherwise.
 */
function addInputMapping(root) {
    // Delete if mapping already exists
    if (window.isInputMappingEdit) {
        for (let i = 0, len = window.params.length; i < len; i++) {
            let paramElement = window.params[i];

            if (paramElement.getAttribute("name") === window.mappingToBeDeleted) {
                window.params.splice(i, 1);
                break;
            }
        }
    }

    // Extract form data
    let formData = $("#input-mapping-form").find(':visible').serializeArray();
    let dataObj = {};
    let paramElement = root.createElement("param");

    $(formData).each(function(i, field){
        dataObj[field.name] = field.value;
    });

    paramElement.setAttribute("name", $("#im-mappingname-input").val());
    paramElement.setAttribute("paramType", $("#q-im-paramtype-select").val());
    paramElement.setAttribute("sqlType", $("#q-im-sqltype-select").val());
    paramElement.setAttribute("defaultValue", $("#im-defaultvalue-input").val());
    paramElement.setAttribute("type", $("#q-im-inout-select").val());
    paramElement.setAttribute("ordinal", $("#im-ordinal-input").val());

    // Append validators
    if (window.validators.length !== 0 || window.validators !== undefined || window.validators !== null) {
        for (let i = 0, len = window.validators.length; i < len; i++) {
            paramElement.appendChild(window.validators[i]);
        }
    }

    window.params.push(paramElement);
    window.validators = [];

    $("#q-im-table-notification-alert-holder").toggle(false);
    $("#q-im-entries-table").toggle(true);

    updateInputMappingTable();

    window.isInputMappingEdit = false;

    return true;
}

/**
 * Resets the add/edit validator form.
 */
function resetValidatorsForm() {
    $("#q-im-addedit-validator-section-header").text("Add Validator");
    $("#q-im-validator-select").val("default");
    $("#im-val-maxvalue-input").val("");
    $("#im-val-minvalue-input").val("");
    $("#im-val-pattern-input").val("");

    $("#im-val-maxvalue-inputgroup").toggle(false);
    $("#im-val-minvalue-inputgroup").toggle(false);
    $("#im-val-pattern-inputgroup").toggle(false);
}

function resetValidatorsSection() {
    $("#q-im-validators-add-btn").toggle(true);
    $("#q-im-validators-table").toggle(true);
    $("#q-im-addedit-validator-section").toggle(false);

    resetValidatorsForm();
}

/**
 * Validate validators form input fields.
 */
function validateValidatorsForm() {
    let selected = $("#q-im-validator-select").val();

    if (selected === VALIDATOR_LONGRANGE) {
        $("#im-val-maxvalue-inputgroup").toggle(true);
        $("#im-val-maxvalue-input").attr('required', true);
        $("#im-val-minvalue-inputgroup").toggle(true);
        $("#im-val-minvalue-input").attr('required', true);
        $("#im-val-pattern-inputgroup").toggle(false);
        $("#im-val-pattern-input").attr('required', false);
    } else if (selected === VALIDATOR_DOUBLERANGE) {
        $("#im-val-maxvalue-inputgroup").toggle(true);
        $("#im-val-maxvalue-input").attr('required', true);
        $("#im-val-minvalue-inputgroup").toggle(true);
        $("#im-val-minvalue-input").attr('required', true);
        $("#im-val-pattern-inputgroup").toggle(false);
        $("#im-val-pattern-input").attr('required', false);
    } else if (selected === VALIDATOR_LENGTH) {
        $("#im-val-maxvalue-inputgroup").toggle(true);
        $("#im-val-maxvalue-input").attr('required', true);
        $("#im-val-minvalue-inputgroup").toggle(true);
        $("#im-val-minvalue-input").attr('required', true);
        $("#im-val-pattern-inputgroup").toggle(false);
        $("#im-val-pattern-input").attr('required', false);
    } else if (selected === VALIDATOR_PATTERN) {
        $("#im-val-maxvalue-inputgroup").toggle(false);
        $("#im-val-maxvalue-input").attr('required', false);
        $("#im-val-minvalue-inputgroup").toggle(false);
        $("#im-val-minvalue-input").attr('required', false);
        $("#im-val-pattern-inputgroup").toggle(true);
        $("#im-val-pattern-input").attr('required', true);
    } else if (selected === "default") {
        $("#im-val-maxvalue-inputgroup").toggle(false);
        $("#im-val-minvalue-inputgroup").toggle(false);
        $("#im-val-pattern-inputgroup").toggle(false);
        $("#im-val-maxvalue-input").attr('required', true);
        $("#im-val-minvalue-input").attr('required', true);
        $("#im-val-pattern-input").attr('required', true);
    }
}

function checkIfIMappingExists(root, paramName) {
    if (window.params.length !== 0 || window.params !== undefined || window.params !== null)  {
        for (let i = 0, len = window.params.length; i < len; i++) {
            let paramNameCurr = window.params[i].getAttribute("name");
            if (paramNameCurr === paramName) {
                return true;
            }
        }
    }

    return false;
}

function createQueryElement(root, queryId) {
    let queryElement = root.createElement("query");
    queryElement.setAttribute("id", queryId);

    window.queryElement = queryElement;
}

function removeIfValidatorExists(validatorTagName) {
    for (let i = 0, l = window.validators.length; i < l; i++) {
        let validator = window.validators[i];
        if (validator.tagName === validatorTagName) {
            window.validators.splice(i, 1);
            break;
        }
    }
}

function createValidatorElement(root, validatorType, dataObj) {
    let validatorElement = root.createElement(validatorType);

    if (validatorType === VALIDATOR_LONGRANGE || validatorType === VALIDATOR_DOUBLERANGE ||
        validatorType === VALIDATOR_LENGTH) {
        validatorElement.setAttribute("maximum", dataObj.maxRange);
        validatorElement.setAttribute("minimum", dataObj.minRange);
    } else if (validatorType === VALIDATOR_PATTERN) {
        validatorElement.setAttribute("pattern", dataObj.pattern);
    }

    return validatorElement;
}

function addValidator(root, selectedValidator) {
    if (selectedValidator === VALIDATOR_LONGRANGE) {
        let maxRange = $("#im-val-maxvalue-input").val();
        let minRange = $("#im-val-minvalue-input").val();
        removeIfValidatorExists(VALIDATOR_LONGRANGE);
        window.validators.push(createValidatorElement(root, VALIDATOR_LONGRANGE, {maxRange: maxRange, minRange: minRange}));
    } else if (selectedValidator === VALIDATOR_DOUBLERANGE) {
        let maxRange = $("#im-val-maxvalue-input").val();
        let minRange = $("#im-val-minvalue-input").val();
        removeIfValidatorExists(VALIDATOR_DOUBLERANGE);
        window.validators.push(createValidatorElement(root, VALIDATOR_DOUBLERANGE, {maxRange: maxRange, minRange: minRange}));
    } else if (selectedValidator === VALIDATOR_LENGTH) {
        let maxRange = $("#im-val-maxvalue-input").val();
        let minRange = $("#im-val-minvalue-input").val();
        removeIfValidatorExists(VALIDATOR_LENGTH);
        window.validators.push(createValidatorElement(root, VALIDATOR_LENGTH, {maxRange: maxRange, minRange: minRange}));
    } else if (selectedValidator === VALIDATOR_PATTERN) {
        let pattern = $("#im-val-pattern-input").val();
        removeIfValidatorExists(VALIDATOR_PATTERN);
        window.validators.push(createValidatorElement(root, VALIDATOR_PATTERN, {pattern: pattern}));
    }

    $("#q-im-validators-table tbody tr").remove();
    for (let i = 0, len = window.validators.length; i < len; i++) {
        let validatorElement = window.validators[i];
        let validatorName = getValidatorDetails(validatorElement).validatorName;
        let validation = getValidatorDetails(validatorElement).validation;

        let markup = "<tr name=\"" + validatorElement.tagName + "\"><td>" + validatorName + "</td><td>" + validation + "</td><td class=\"text-center\">" +
            "<i class=\"fa fa-edit\"></i><i class=\"fa fa-trash\"></i></td></tr>";

        $("#q-im-validators-table tbody").append(markup);
    }

    resetValidatorsSection();
}

function getValidatorDetails(validatorElement) {
    let validatorName = "";
    let validation = "";

    if (validatorElement.tagName === VALIDATOR_LONGRANGE) {
        validatorName = "Long Range Validator";
        validation = "maximum = " + validatorElement.attributes.getNamedItem("maximum").value +
            ", minimum = " + validatorElement.attributes.getNamedItem("minimum").value;
    } else if (validatorElement.tagName === VALIDATOR_DOUBLERANGE) {
        validatorName = "Double Range Validator";
        validation = "maximum = " + validatorElement.attributes.getNamedItem("maximum").value +
            ", minimum = " + validatorElement.attributes.getNamedItem("minimum").value;
    } else if (validatorElement.tagName === VALIDATOR_LENGTH) {
        validatorName = "Length Validator";
        validation = "maximum = " + validatorElement.attributes.getNamedItem("maximum").value +
            ", minimum = " + validatorElement.attributes.getNamedItem("minimum").value;
    } else if (validatorElement.tagName === VALIDATOR_PATTERN) {
        validatorName = "Pattern Validator";
        validation = "pattern = " + validatorElement.attributes.getNamedItem("pattern").value;
    }

    return {
        validatorName: validatorName,
        validation: validation
    }
}

function editValidator(root, validatorName) {
    resetValidatorsSection();
    $("#q-im-addedit-validator-section-header").text("Edit Validator");
    $("#q-im-addedit-validator-section").toggle(true);

    for (let i = 0, len = window.validators.length; i < len; i++) {
        let validatorElement = window.validators[i];

        if (validatorElement.tagName === validatorName) {
            if (validatorElement.tagName === VALIDATOR_LONGRANGE) {
                $("#q-im-validator-select").val(VALIDATOR_LONGRANGE);
                validateValidatorsForm();
                $("#im-val-maxvalue-input").val(validatorElement.attributes.getNamedItem("maximum").value);
                $("#im-val-minvalue-input").val(validatorElement.attributes.getNamedItem("minimum").value);
            } else if (validatorElement.tagName === VALIDATOR_DOUBLERANGE) {
                $("#q-im-validator-select").val(VALIDATOR_DOUBLERANGE);
                validateValidatorsForm();
                $("#im-val-maxvalue-input").val(validatorElement.attributes.getNamedItem("maximum").value);
                $("#im-val-minvalue-input").val(validatorElement.attributes.getNamedItem("minimum").value);
            } else if (validatorElement.tagName === VALIDATOR_LENGTH) {
                $("#q-im-validator-select").val(VALIDATOR_LENGTH);
                validateValidatorsForm();
                $("#im-val-maxvalue-input").val(validatorElement.attributes.getNamedItem("maximum").value);
                $("#im-val-minvalue-input").val(validatorElement.attributes.getNamedItem("minimum").value);
            } else if (validatorElement.tagName === VALIDATOR_PATTERN) {
                validateValidatorsForm();
                $("#q-im-validator-select").val(VALIDATOR_PATTERN);
                validateValidatorsForm();
                $("#im-val-pattern-input").val(validatorElement.attributes.getNamedItem("pattern").value);
            }
        }
    }

    $("#q-im-validators-table").toggle(false);
    $("#q-im-validators-add-btn").toggle(false);
}

function editInputMapping(root, mappingName) {
    resetValidatorsSection();
    $("#q-im-addedit-title").text("Edit Input Mapping");

    for (let i = 0, len = window.params.length; i < len; i++) {
        let paramElement = window.params[i];

        if (paramElement.getAttribute("name") === mappingName) {
            $("#im-mappingname-input").val(paramElement.attributes.getNamedItem("name").value);
            $("#q-im-paramtype-select").val(paramElement.attributes.getNamedItem("paramType").value.toLowerCase());
            $("#q-im-sqltype-select").val(paramElement.attributes.getNamedItem("sqlType").value.toLowerCase());

            if (paramElement.attributes.getNamedItem("defaultValue") !== null) {
                $("#im-defaultvalue-input").val(paramElement.attributes.getNamedItem("defaultValue").value);
            }

            if (paramElement.attributes.getNamedItem("type") !== null) {
                $("#q-im-inout-select").val(paramElement.attributes.getNamedItem("type").value);
            }

            if (paramElement.attributes.getNamedItem("ordinal") !== null) {
                $("#im-ordinal-input").val(paramElement.attributes.getNamedItem("ordinal").value);
            }

            window.validators = Array.from(paramElement.childNodes);
            updateValidatorsTable();
        }
    }

    window.isInputMappingEdit = true;
    window.mappingToBeDeleted = mappingName;
    $("#q-input-mapping-modal").modal("show");
}

function deleteInputMapping(mappingName) {
    for (let i = 0, len = window.params.length; i < len; i++) {
        let paramElement = window.params[i];
        if (paramElement.getAttribute("name") === mappingName) {
            window.params.splice(i, 1);
            break;
        }
    }
    updateInputMappingTable();

    if (window.params.length === 0) {
        $("#q-im-entries-table").toggle(false);
        $("#q-im-table-notification-alert-holder").toggle(true);
        showInputMappingsTableNotification("info", "No input mappings available. Click 'Add New' to create a new mapping.", 0);
    }
}

function updateInputMappingTable() {
    $("#q-im-entries-table tbody tr").remove();
    for (let i = 0, len = window.params.length; i < len; i++) {
        let paramElement = window.params[i];
        let paramName = paramElement.getAttribute("name");
        let paramParameterType = paramElement.getAttribute("paramType");
        let paramType = paramElement.getAttribute("sqlType");

        let markup = "<tr name=\"" + paramName  + "\"><td>" + paramName + "</td><td>" + paramParameterType +
            "</td><td>" + paramType + "</td><td class=\"text-center\"><i class=\"fa fa-edit\"></i>" +
            "<i class=\"fa fa-trash\"></i></td></tr>";

        $("#q-im-entries-table tbody").append(markup);
    }
}

function updateValidatorsTable() {
    $("#q-im-validators-table tbody tr").remove();
    for (let i = 0, len = window.validators.length; i < len; i++) {
        let validatorElement = window.validators[i];
        let validatorName = getValidatorDetails(validatorElement).validatorName;
        let validation = getValidatorDetails(validatorElement).validation;

        let markup = "<tr name=\"" + validatorElement.tagName + "\"><td>" + validatorName + "</td><td>" + validation + "</td><td class=\"text-center\">" +
            "<i class=\"fa fa-edit\"></i><i class=\"fa fa-trash\"></i></td></tr>";

        $("#q-im-validators-table tbody").append(markup);
    }
}

function saveInputMappingsToQueryElement(queryElement) {
    for (let i = 0, len = window.params.length; i < len; i++) {
        queryElement.appendChild(window.params[i]);
    }
}

function processQueryDetails(root, queryElement) {
    queryElement.setAttribute("id", $("#q-query-id-input").val());
    queryElement.setAttribute("useConfig", $("#q-datasource-select").val());

    let sqlQueryElement = root.createElement("sql");
    sqlQueryElement.appendChild(root.createTextNode($("#q-sql-query-input").val()));

    queryElement.appendChild(sqlQueryElement);
}

function addQuery(root, queryElement) {
    let queries = root.getElementsByTagName("query");
    let queryId = $("#q-query-id-input").val();

    for (let i = 0, len = queries.length; i < len; i++) {
        if (queries[i].id == queryId && !$("#q-query-id-input").prop('disabled')) {
            root.documentElement.removeChild(queries[i]);
            break;
        }
    }

    let dataRoot = root.getElementsByTagName("data")[0];
    let queryElements = root.getElementsByTagName("query");

    if (queryElements.length > 0) {
        insertAfter(queryElement, queryElements[queryElements.length - 1]);
    } else {
        dataRoot.appendChild(queryElement);
    }

    return true;
}

function resetInputMappingSection() {
    if (window.params.length === 0) {
        $("#q-im-entries-table").toggle(false);
        $("#q-im-table-notification-alert-holder").toggle(true);
        showInputMappingsTableNotification("info", "No input mappings available. Click 'Add New' to create a new mapping.", 0);
    } else {
        $("#q-im-entries-table").toggle(true);
        $("#q-input-mapping-add-btn").toggle(true);
        updateInputMappingTable();
    }
}

function editQuery(root, queryId) {
    let queries = root.getElementsByTagName("query");
    let sql = "";

    populateDSListForQueries(root);

    for (let i = 0, len = queries.length; i < len; i++) {
        let queryElement = queries[i];
        if (queryElement.attributes.getNamedItem("id").value === queryId) {
            window.queryElement = queryElement;
            window.params = [];

            let queryChildren = Array.from(queryElement.childNodes);
            for (let i = 0, len = queryChildren.length; i < len; i++) {
                if (queryChildren[i].tagName === "param") {
                    window.params.push(queryChildren[i]);
                } else if (queryChildren[i].tagName === "sql") {
                    sql = queryChildren[i].innerHTML;
                }
            }

            updateInputMappingTable();

            $("#q-query-id-input").val(queryElement.attributes.getNamedItem("id").value);
            $("#q-datasource-select").val(queryElement.attributes.getNamedItem("useConfig").value);
            $("#q-sql-query-input").val(sql);

            $("#q-add-edit-query-section").toggle(true);
            $("#q-queries-table").toggle(false);
            $("#q-query-add-btn").toggle(false);
            
            populateQueryAdvancedProperties();
        }
    }
    clearQueryAdvancedProperties();
    populateQueryAdvancedProperties();
    return populateOueryOutputMappings(window.queryElement);
}

function deleteQuery(root, queryId) {
    let queries = root.getElementsByTagName("query");

    for (let i = 0, len = queries.length; i < len; i++) {
        if (queries[i].id == queryId) {
            root.documentElement.removeChild(queries[i]);
            break;
        }
    }

    return true;
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