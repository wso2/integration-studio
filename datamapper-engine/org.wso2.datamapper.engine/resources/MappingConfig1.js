function map_S_pizza_S_pizza(inpizza, outpizza) {
	
	outpizza.name = inpizza.name;
	outpizza.price = inpizza.price;
	map_S_toppingsList_S_toppingsList(inpizza.toppingsList, outpizza.toppingsList);

	return outpizza;
}

function map_S_toppingsList_S_toppingsList(intoppingsList, outtoppingsList) {
	
	for(i in intoppingsList.toppings){
		map_L_toppings_L_toppings(intoppingsList.toppings[i], outtoppingsList.toppings[i]);
	}
	
}

function map_L_toppings_L_toppings(intoppings, outtoppings) {
	
	outtoppings.id = intoppings.id+"_"+intoppings.name; 
	
}
