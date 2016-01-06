function map_S_queryResponse_S_sfRecords(queryResponse, sfRecords){
	for(var x in queryResponse.result.records){
		map_L_records_L_sfRecord(queryResponse.result.records[x], sfRecords.sfRecord[x]);
		map_S_AccountName_S_sfRecordAccount_Name(queryResponse.result.records[x].Account, sfRecords.sfRecord[x]);
	}
	return sfRecords;
}


function map_S_AccountName_S_sfRecordAccount_Name(Account, sfRecord){

	sfRecord.Account_Name=Account.Name;
}


function map_L_records_L_sfRecord(records, sfRecord){
	sfRecord.Opportunity_Name=records.Name;
	sfRecord.Amount=records.Amount;
}
