$(document).ready(function(){

    setVisibleDSTypeCarbon(false);
    setVisibleDSTypeMongo(false);
    setVisibleDSTypeCSV(false);
    setVisibleDSTypeCassandra(false);
    setVisibleDSTypeRDBMS(true);
    
    //--- Start of Data Source Type ---//
    $("#ds-dstype-select").change(function() {
        if ($(this).val() == "carbon_ds") {
        	setVisibleDSTypeRDBMS(false);
        	setVisibleDSTypeMongo(false);
        	setVisibleDSTypeCSV(false);
            setVisibleDSTypeCassandra(false);
            setVisibleDSTypeCarbon(true);
            
        } else if ($(this).val() == "rdbms_ds") {
            setVisibleDSTypeMongo(false);
            setVisibleDSTypeCarbon(false);
            setVisibleDSTypeCSV(false);
            setVisibleDSTypeCassandra(false);
            setVisibleDSTypeRDBMS(true);
            
        } else if ($(this).val() == "mongodb_ds") {
            setVisibleDSTypeRDBMS(false);
            setVisibleDSTypeCarbon(false);
            setVisibleDSTypeCSV(false);
            setVisibleDSTypeCassandra(false);
            setVisibleDSTypeMongo(true);
            
        } else if ($(this).val() == "csv") {
            setVisibleDSTypeRDBMS(false);
            setVisibleDSTypeCarbon(false);
            setVisibleDSTypeMongo(false);
            setVisibleDSTypeCassandra(false);
            setVisibleDSTypeCSV(true);

        } else if ($(this).val() == "cassandra") {
            setVisibleDSTypeRDBMS(false);
            setVisibleDSTypeCarbon(false);
            setVisibleDSTypeMongo(false);
            setVisibleDSTypeCSV(false);
            setVisibleDSTypeCassandra(true);
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

function setVisibleDSTypeCassandra(isVisible) {
    $('#ds-cassandra-cassandra-servers-inputgroup').toggle(isVisible);
    $('#ds-cassandra-keyspace-inputgroup').toggle(isVisible);
    $('#ds-cassandra-port-inputgroup').toggle(isVisible);
    $('#ds-cassandra-cluster-name-inputgroup').toggle(isVisible);
    $('#ds-cassandra-compression-input').toggle(isVisible);
    $('#ds-cassandra-user-name-inputgroup').toggle(isVisible);
    $('#ds-cassandra-password-inputgroup').toggle(isVisible);
    $('#ds-cassandra-password-inputgroup').toggle(isVisible);
    $('#ds-cassandra-loadbalancing-policy-input').toggle(isVisible);
    $('#ds-cassandra-data-center-inputgroup').toggle(isVisible);
    $('#ds-cassandra-allow-remotedcs-input').toggle(isVisible);
    $('#ds-cassandra-enable-jmx-input').toggle(isVisible);
    $('#ds-cassandra-enable-matrics-input').toggle(isVisible);
    $('#ds-cassandra-local-core-connections-inputgroup').toggle(isVisible);
    $('#ds-cassandra-remote-core-connections-inputgroup').toggle(isVisible);
    $('#ds-cassandra-local-max-host-inputgroup').toggle(isVisible);
    $('#ds-cassandra-remote-max-host-inputgroup').toggle(isVisible);
    $('#ds-cassandra-local-new-connection-inputgroup').toggle(isVisible);
    $('#ds-cassandra-remote-new-connection-inputgroup').toggle(isVisible);
    $('#ds-cassandra-local-max-connection-inputgroup').toggle(isVisible);
    $('#ds-cassandra-remote-max-connection-inputgroup').toggle(isVisible);
    $('#ds-cassandra-protocol-version-input').toggle(isVisible);
    $('#ds-cassandra-consistency-level-input').toggle(isVisible);
    $('#ds-cassandra-fetch-size-inputgroup').toggle(isVisible);
    $('#ds-cassandra-serial-consistency-level-input').toggle(isVisible);
    $('#ds-cassandra-reconnection-policy-input').toggle(isVisible);
    $('#ds-cassandra-policy-dealay-inputgroup').toggle(isVisible);
    $('#ds-cassandra-policy-base-dealay-inputgroup').toggle(isVisible);
    $('#ds-cassandra-policy-max-dealay-inputgroup').toggle(isVisible);
    $('#ds-cassandra-retry-policy-input').toggle(isVisible);
    $('#ds-cassandra-connection-timeout-inputgroup').toggle(isVisible);
    $('#ds-cassandra-keep-alive-input').toggle(isVisible);
    $('#ds-cassandra-read-timeout-inputgroup').toggle(isVisible);
    $('#ds-cassandra-receive-buffer-size-inputgroup').toggle(isVisible);
    $('#ds-cassandra-send-buffer-size-inputgroup').toggle(isVisible);
    $('#ds-cassandra-reuse-address-input').toggle(isVisible);
    $('#ds-cassandra-so-linger-inputgroup').toggle(isVisible);
    $('#ds-cassandra-tcp-no-delay-input').toggle(isVisible);
    $('#ds-cassandra-enable-ssl-input').toggle(isVisible);
    $('#ds-enable-odata-check-inputgroup').toggle(isVisible);
}

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
	$('#ds-enable-odata-check-inputgroup').toggle(isVisible);
}

function setVisibleDSTypeRDBMS(isVisible) {
    $('#ds-db-engine-formgroup').toggle(isVisible);
    $('#ds-config-params-collapse').toggle(isVisible);
    $('#ds-dynamic-auth-collapse').toggle(isVisible);
    $('#ds-test-conn-btn-formgroup').toggle(isVisible);
    $('#ds-dstype-2-select').toggle(isVisible);
    $('#ds-test-con-collapse-group').toggle(isVisible);
    $('#ds-db-engine-select').attr('required', isVisible);
    $('#ds-enable-odata-check-inputgroup').toggle(isVisible);
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
    $('#ds-enable-odata-check-inputgroup').toggle(isVisible);
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
