function map_L_employee_L_engineer(input, output) {

	output.fullname = input.firstname.concat(" " + input.lastname);
	
	input.address.forEach(function (address, index, array) {
		output.address[index].addresscode = address.no + ", " + address.road + ", " + address.city;
	});
	return output;
}