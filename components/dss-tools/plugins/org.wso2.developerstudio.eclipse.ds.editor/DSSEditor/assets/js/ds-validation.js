$(document).ready(function(){

    setVisibleDSTypeCarbon(false);
    setVisibleDSTypeMongo(false);
    setVisibleDSTypeCSV(false);
    setVisibleDSTypeRDBMS(true);
    
    //--- Start of Data Source Type ---//
    $("#ds-dstype-select").change(function() {
        if ($(this).val() == "carbon_ds") {
        	setVisibleDSTypeRDBMS(false);
        	setVisibleDSTypeMongo(false);
        	setVisibleDSTypeCSV(false);
            setVisibleDSTypeCarbon(true);
            
        } else if ($(this).val() == "rdbms_ds") {
            setVisibleDSTypeMongo(false);
            setVisibleDSTypeCarbon(false);
            setVisibleDSTypeCSV(false);
            setVisibleDSTypeRDBMS(true);
            
        } else if ($(this).val() == "mongodb_ds") {
            setVisibleDSTypeRDBMS(false);
            setVisibleDSTypeCarbon(false);
            setVisibleDSTypeCSV(false);
            setVisibleDSTypeMongo(true);
            
        } else if ($(this).val() == "csv") {
            setVisibleDSTypeRDBMS(false);
            setVisibleDSTypeCarbon(false);
            setVisibleDSTypeMongo(false);
            setVisibleDSTypeCSV(true);
            
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

function setVisibleDSTypeCSV(isVisible) {
	$('#ds-csv-file-location-inputgroup').toggle(isVisible);
	$('#ds-col-separator-inputgroup').toggle(isVisible);
	$('#ds-start-row-inputgroup').toggle(isVisible);
	$('#ds-max-read-rows-inputgroup').toggle(isVisible);
	$('#ds-col-header-input').toggle(isVisible);
	$('#ds-header-row-inputgroup').toggle(isVisible);
}

function setVisibleDSTypeMongo(isVisible) {
	$('#ds-server-inputgroup').toggle(isVisible);
	$('#ds-mongo-dbname-inputgroup').toggle(isVisible);
	$('#ds-auth-method-input').toggle(isVisible);
	$('#ds-username-inputgroup').toggle(isVisible);
	$('#ds-password-formgroup').toggle(isVisible);
	$('#ds-write-concern-input').toggle(isVisible);
	$('#ds-read-pref-input').toggle(isVisible);
	$('#ds-con-timeout-inputgroup').toggle(isVisible);
	$('#ds-max-wait-inputgroup').toggle(isVisible);
	$('#ds-socket-timeout-inputgroup').toggle(isVisible);
	$('#ds-connections-inputgroup').toggle(isVisible);
	$('#ds-threads-for-mul-inputgroup').toggle(isVisible);
}

function setVisibleDSTypeRDBMS(isVisible) {
    $('#ds-db-engine-formgroup').toggle(isVisible);
    $('#ds-config-params-collapse').toggle(isVisible);
    $('#ds-dynamic-auth-collapse').toggle(isVisible);
    $('#ds-test-conn-btn-formgroup').toggle(isVisible);
    $('#ds-dstype-2-select').toggle(isVisible);
    $('#ds-test-con-collapse-group').toggle(isVisible);

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
