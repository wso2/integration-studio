function map_S_employee_S_engineer(input,output){
	
	    output.fullname = input.firstname.concat(" "+input.lastname);
	    output.address = map_S_address_S_address(input.address);
		
		return output;
}
function map_S_address_S_address(empAddress) {
	return empAddress.no + "_" + empAddress.road + "_" + empAddress.city;
}