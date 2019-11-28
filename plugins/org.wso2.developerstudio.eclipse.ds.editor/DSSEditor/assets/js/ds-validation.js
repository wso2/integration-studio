$(document).ready(function(){

    setVisibleDSTypeRDBMS(true);
    setVisibleDSTypeCarbon(false);
    
    //--- Start of Data Source Type ---//
    $("#ds-dstype-select").change(function() {
        if ($(this).val() == "carbon_ds") {
            setVisibleDSTypeCarbon(true);
            setVisibleDSTypeRDBMS(false);
        } else if ($(this).val() == "rdbms_ds") {
            setVisibleDSTypeRDBMS(true);
            setVisibleDSTypeCarbon(false);
        }
    });

    $("#ds-dstype-select").trigger("change");
    //--- End of Data Source Type ---//
    
        //--- Start of Data Source Type 2 ---//
    $("#ds-dstype-2-select").change(function() {
        if ($(this).val() == "external_ds") {
            setVisibleDSType2Ext(true);
            setVisibleDSType2Default(false);
        } else if ($(this).val() == "default_ds") {
            setVisibleDSType2Ext(false);
            setVisibleDSType2Default(true);
        }
    });

    $("#ds-dstype-2-select").trigger("change");
    //--- End of Data Source Type 2 ---//
        
});

function setVisibleDSTypeRDBMS(isVisible) {
    $('#ds-db-engine-formgroup').toggle(isVisible);
    $('#ds-config-params-collapse').toggle(isVisible);
    $('#ds-dynamic-auth-collapse').toggle(isVisible);
    $('#ds-test-conn-btn-formgroup').toggle(isVisible);
    $('#ds-dstype-2-select').toggle(isVisible);

    $('#ds-db-engine-select').attr('required', isVisible);
    
    if (isVisible) {
        if ($("#ds-dstype-2-select").val() == "external_ds") {
            setVisibleDSType2Ext(true);
            setVisibleDSType2Default(false);
        } else if ($("#ds-dstype-2-select").val() == "default_ds") {
            setVisibleDSType2Ext(false);
            setVisibleDSType2Default(true);
        }
    } else {
        setVisibleDSType2Ext(isVisible);
        setVisibleDSType2Default(isVisible);
    }
    
}

function setVisibleDSTypeCarbon(isVisible) {
    $('#ds-ds-name-inputgroup').toggle(isVisible);
    $('#ds-ds-name-input').attr('required', isVisible);
}

function setVisibleDSType2Ext(isVisible) {
    $('#ds-class-name-inputgroup').toggle(isVisible);
    $('#ds-class-name-input').attr('required', isVisible);
    $('#ds-ext-prop-group').toggle(isVisible);
}

function setVisibleDSType2Default(isVisible) {
    $('#ds-driver-class-inputgroup').toggle(isVisible);
    $('#ds-driver-class-input').attr('required', isVisible);
    $('#ds-url-inputgroup').toggle(isVisible);
    $('#ds-url-input').attr('required', isVisible);
    $('#ds-username-inputgroup').toggle(isVisible);
    $('#ds-password-formgroup').toggle(isVisible);
}
