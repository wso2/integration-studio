function map_S_employee_S_engineer(input,output){
	
	    output.fullname = input.firstname.concat(" "+input.lastname);
	    output.address = input.address;
		
		return output;
}
