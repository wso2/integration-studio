function map_S_employees_S_engineers(employees, engineers) {
		
	for(i in employees.employee){
		map_L_employee_L_engineer(employees.employee[i], engineers.engineer[i]);
	}
	return engineers;
}
function map_L_employee_L_engineer(employee, engineer) {
	
	engineer.fullname = employee.firstname.concat(" " + employee.lastname);
	engineer.address = map_L_address_L_address(employee.address);
	
}
function map_L_address_L_address(empAddress) {
	return empAddress.no + "_" + empAddress.road + "_" + empAddress.city;
}