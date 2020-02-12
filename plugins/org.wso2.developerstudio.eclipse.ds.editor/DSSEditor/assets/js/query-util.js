/**
 * Populates Query data.
 *
 * @param root Document object.
 */
function populateQueryTable(root) {
    let queryConfigs = root.getElementsByTagName("query");

    if (queryConfigs.length == 0 || queryConfigs === undefined || queryConfigs === null)  {
        $("#q-queries-table").hide();
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

    // $('#' + selectId).change(function(e) {
    //     e.preventDefault();
    //     let queryid = $('#' + selectId).val();
    //     populateResourceParameterTable(root, queryid);
    // });
    //
    // $('#' + selectId).trigger('change');
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
    // Extract form data
    let formData = $("#input-mapping-form").find(':visible').serializeArray();
    let dataObj = {};
    let paramElement = root.createElement("param");

    $(formData).each(function(i, field){
        dataObj[field.name] = field.value;
    });

    paramElement.setAttribute("name", dataObj["im-mappingname-input"]);
    paramElement.setAttribute("paramType", dataObj["q-im-paramtype-select"]);
    paramElement.setAttribute("sqlType", dataObj["q-im-sqltype-select"]);
    paramElement.setAttribute("defaultValue", dataObj["im-defaultvalue-input"]);
    paramElement.setAttribute("type", dataObj["q-im-inout-select"]);
    paramElement.setAttribute("ordinal", dataObj["im-ordinal-input"]);

    return true;
}

/**
 * Resets the add/edit validator form.
 */
function resetValidatorsForm() {
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
    $("#add-edit-validator-section").toggle(false);

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
    let existingParams = window.queryElement.getElementsByTagName("param");

    if (existingParams.length == 0 || existingParams === undefined || existingParams === null)  {
        for (let i = 0, len = existingParams.length; i < len; i++) {
            let paramNameCurr = existingParams[i].name;
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
            window.validators.splice(i, 1 );
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

        let markup = "<tr><td>" + validatorName + "</td><td>" + validation + "</td><td class=\"text-center\">" +
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