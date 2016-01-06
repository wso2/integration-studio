function map_S_employees_S_engineers(employees, engineers) {
	
	engineers.types = employees.types + "_2014/03/30";
	
	for(i in employees.employee){
		map_L_employee_L_engineer(employees.employee[i], engineers.engineer[i]);
	}
	return engineers;
}
function map_L_employee_L_engineer(employee, engineer) {
	
	engineer.fullname = employee.firstname.concat(" " + employee.lastname);
	
	for(j in employee.address){
		 map_L_address_L_address(employee.address[j], engineer.address[j]);
	}
}
function map_L_address_L_address(empAddress, engAddress) {
	engAddress.addresscode = empAddress.no + "_" + empAddress.road + "_" + empAddress.city;
	engAddress.city = empAddress.city;
}

