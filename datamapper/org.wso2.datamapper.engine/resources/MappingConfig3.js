function map_L_employee_L_engineer(input,output){
		
		output.fullname = input.firstname.concat(" "+input.lastname);
		output.address = input.address.no.concat(" "+input.address.city);
		
		return output;
}