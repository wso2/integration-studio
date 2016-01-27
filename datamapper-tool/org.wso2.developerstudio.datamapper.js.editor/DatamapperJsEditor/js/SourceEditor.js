
function generateOutput() {
	var inScriptableRecord = {"address": {"city": "Negombo", "no": "No.123", "road": "Main Street"}, "firstname": "Susinda", "lastname": "Perera"}
	var outScriptableRecord = {"address": null, "fullname": null}
	var functionToExecute = 'function map_S_employee_S_engineer(input,output){		    output.fullname = input.firstname.concat(" "+input.lastname);	    output.address = map_S_address_S_address(input.address);				return output;}function map_S_address_S_address(empAddress) {	return empAddress.no + "_" + empAddress.road + "_" + empAddress.city;}';
	var strfun = "function myfun(arg) { return arg * 3; }";
	eval(functionToExecute);
	var res = map_S_employee_S_engineer(inScriptableRecord, outScriptableRecord);
	//alert(JSON.stringify(res));
	var outputTBox = $('#outputPayload');
	outputTBox.val(JSON.stringify(res));
}