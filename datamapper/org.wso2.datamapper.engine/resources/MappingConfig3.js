function map_L_employee_L_engineer(input,output){
	
		output.fullname = input.firstname.concat(" "+input.lastname);
		output.address = map_S_address_S_address(input.address);
		return output;
}

function map_S_address_S_address(address){
	return   address.no.concat(" "+address.city);
}