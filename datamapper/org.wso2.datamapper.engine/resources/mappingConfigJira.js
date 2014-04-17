function map_S_ProductRecords_S_jiras(input, output) {
	
	for(var x in input.Product){
	   output.jira[x].Key = input.Product[x].Key;
	   output.jira[x].Summary = input.Product[x].Summary;
	   output.jira[x].Description = input.Product[x].Description;
	   output.jira[x].version = input.Product[x].version;   
	}
	return output;
}