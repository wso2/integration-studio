
/////////////////////////  set the data acording to the mediator     ///////////////////////////////////
function setData(element, type) {

if (type == 'logMediator') {
   var logMediatorObject = $.parseJSON('{"log": {"_logLevel":0, "_separator":",", "_category":0, "properties":[], "description":"susindas log mediator"}}');
   element.data('jsonConfig' , logMediatorObject);
} 
if (type == 'propertyMediator') {
   var propertyMediatorObject = $.parseJSON('{"property": {"_name":"", "_value":""}}');
   element.data('jsonConfig' , propertyMediatorObject);
} 

}


////////////////////////////  this will openup the config dialog acording to the mediator   /////////////////////////////////
function openPopupDialog() {

var type = $(this).attr('id');

if(type.indexOf('logMediator') != -1){
   openMediatorConfigDialog('js/logMediator/logMediatorForm.html', 'Log Mediator');
}

if(type.indexOf('propertyMediator') != -1){
   //replace with a dialog for property mediator
   openMediatorConfigDialog('js/logMediator/logMediatorForm.html', 'Property Mediator');
}

} 


