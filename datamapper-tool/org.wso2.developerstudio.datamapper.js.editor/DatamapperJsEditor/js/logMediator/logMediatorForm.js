
  $(document).ready(function() {

    console.log('logmediatorForm doc ready');
    var logMediatorElement =  window.parent.CurElement.data('jsonConfig');
    console.log(window.parent.CurElement);
    var logMediator = logMediatorElement.log;
    console.log(logMediator);
    $("#mediator_log_log_separator").val(logMediator.seperator);
    $('#mediator_log_category').prop("selectedIndex", logMediator._category);
    $('#mediator_log_log_level').prop("selectedIndex", logMediator._logLevel);
    $("#propertyName0").val(logMediator.description);


    $("#mybutton").click(function() {

        var propertyName = $('#propertyName0').val();
        var category = $('#mediator_log_category :selected').val();
        var logLevel =  $('#mediator_log_log_level :selected').val();
        var separator = $("#mediator_log_log_separator").val();
        console.log(propertyName + "    "  + category + "    " + logLevel + "     " + separator);

        var logMediatorElement =  window.parent.CurElement.data('jsonConfig');
        var logMediatorData2 = logMediatorElement.log;

        logMediatorData2._logLevel = logLevel;
        logMediatorData2._category = category;
        logMediatorData2.description = propertyName;
        logMediatorData2.seperator = separator;
        console.log(logMediatorData2);

        logMediatorElement.log = logMediatorData2;
        window.parent.setUpdatedDataCallBack(logMediatorElement);

    });

});