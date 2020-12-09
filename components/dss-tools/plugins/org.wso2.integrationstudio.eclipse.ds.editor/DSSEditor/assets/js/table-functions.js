$(document).ready(function(){
    
    //--- Start of Transport Settings param table ---//
    $("#ts-params-add-btn").click(function() {
    	let authProviderClass = $('#ts-auth-prov-class-input').val().trim();
    	if (authProviderClass == "") {
    		showNotificationAlertModal("Error", "Please specify an authorization provider class.");
            return false;
    	}
    	
        var markup = "<tr><td><input type='text' placeholder='Name' style='width: 100%;'/></td><td><input type='text' placeholder='Value' style='width: 100%;'/></td><td class='text-center'><i class='fa fa-trash delete-row'></i></td></tr>";
        $("#ts-parameter-table tbody").append(markup);
    });
    
//    $(document).on('click','#ts-parameter-table .fa-trash',function(){
//        $(this).closest("tr").remove();
//    });
    //--- End of Transport Settings param table --/
    
    //--- Start of Data Sources table ---//
    
    // $("#ds-datasource-add-btn").click(function() {
    //     var markup = "<tr><td>Data_Source_Name_Placeholder</td><td class='text-center'><i class='fa fa-edit'></i><i class='fa fa-trash'></i></td></tr>";
    //     $("#ds-datasources-table tbody").append(markup);
    // });
    
    // $(document).on('click','#ds-datasources-table .fa-trash',function(){
    //     $(this).closest("tr").remove();
    // });
    //--- End of Data Sources table ---//
    
    //--- Start of Data Sources - Dynamic Auth table ---//
    $("#ds-dynamic-auth-add-btn").click(function() {
        var markup = "<tr><td><input type='text' placeholder='Carbon Username' class='form-control' style='width: 100%;' /></td><td><input type='text' placeholder='DB Username' class='form-control' style='width: 100%;'/></td><td><input type='password' placeholder='DB Password' class='form-control' style='width: 100%;' /></td><td class='text-center'><i class='fa fa-trash'></i></td></tr>";

        $("#ds-dynamic-auth-usermapping-table tbody").append(markup);
    });
    
    $(document).on('click','#ds-dynamic-auth-usermapping-table .fa-trash',function(){
    	let row = $(this);
    	let tds = $(this).closest("tr").find('td');
    	if (tds[0].firstChild.value === "" && tds[1].firstChild.value === "" && tds[2].firstChild.value === "") {
    		row.closest("tr").remove();
    		return;
    	}
    	$("#ds-dynamic-auth-usermapping-validator-delete-confirm-btn").click(function(event) {
    		row.closest("tr").remove();
        	$("#ds-dynamic-auth-usermapping-validator-delete-confirm-modal").modal("hide");
        	});
    	$("#ds-dynamic-auth-usermapping-validator-delete-confirm-modal").modal("show");
    });
    //--- End of Data Sources - Dynamic Auth table ---//
    
    //--- Start of External Datasource - Properties table ---//
    $("#ds-ext-properties-add-btn").click(function() {
        var markup = "<tr><td><input type='text' placeholder='Property Name' class='form-control' style='width: 100%;' /></td><td><input type='text' placeholder='Property Value' class='form-control' style='width: 100%;' /></td><td class='text-center'><input type='checkbox' /></td><td class='text-center'><i class='fa fa-trash'></i></td></tr>";

        $("#ds-ext-properties-table tbody").append(markup);
    });
    
    $(document).on('click','#ds-ext-properties-table .fa-trash',function(){
    	let row = $(this);
    	let tds = $(this).closest("tr").find('td');
    	if (tds[0].firstChild.value === "" && tds[1].firstChild.value === "") {
    		row.closest("tr").remove();
    		return;
    	}
    	$("#ds-ext-properties-table-validator-delete-confirm-btn").click(function(event) {
    		row.closest("tr").remove();
        	$("#ds-ext-properties-table-validator-delete-confirm-modal").modal("hide");
        	});
    	$("#ds-ext-properties-table-validator-delete-confirm-modal").modal("show");
    });
    //--- End of External Datasource - Properties table ---//
    
    //$("#ds-add-ds-modal").modal({ show : true });
        
});

