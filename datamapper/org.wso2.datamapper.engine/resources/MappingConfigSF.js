function map_S_queryResponse_S_sfRecords(input, output) {
	
	for(var x in input.result.records){
		
	   output.sfRecord[x].Opportunity_Name = input.result.records[x].Name;
	   output.sfRecord[x].Account_Name = input.result.records[x].Account.Name;
	   output.sfRecord[x].Amount = input.result.records[x].Amount;
	   
	}
	return output;
}
