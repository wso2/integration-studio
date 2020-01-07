$(document).ready(function(){
    
    //--- Start of Transport Settings param table ---//
    $("#ts-params-add-btn").click(function() {
        var markup = "<tr><td><input type='text' placeholder='Name' style='width: 100%;'/></td><td><input type='text' placeholder='Value' style='width: 100%;'/></td><td class='text-center'><i class='fa fa-trash delete-row'></i></td></tr>";
        $("#ts-parameter-table tbody").append(markup);
    });
    
    $(document).on('click','#ts-parameter-table .fa-trash',function(){
        $(this).closest("tr").remove();
    });
    //--- End of Transport Settings param table --/
    
    //--- Start of Data Sources table ---//
    
    // $("#ds-datasource-add-btn").click(function() {
    //     var markup = "<tr><td>Data_Source_Name_Placeholder</td><td class='text-center'><i class='fa fa-edit'></i><i class='fa fa-trash'></i></td></tr>";
    //     $("#ds-datasources-table tbody").append(markup);
    // });
    
    $(document).on('click','#ds-datasources-table .fa-trash',function(){
        $(this).closest("tr").remove();
    });
    //--- End of Data Sources table ---//
    
    //--- Start of Data Sources - Dynamic Auth table ---//
    $("#ds-dynamic-auth-add-btn").click(function() {
        var markup = "<tr><td><input type='text' placeholder='Carbon Username' class='form-control' style='width: 100%;' /></td><td><input type='text' placeholder='DB Username' class='form-control' style='width: 100%;'/></td><td><input type='password' placeholder='DB Password' class='form-control' style='width: 100%;' /></td><td class='text-center'><i class='fa fa-trash'></i></td></tr>";

        $("#ds-dynamic-auth-usermapping-table tbody").append(markup);
    });
    
    $(document).on('click','#ds-dynamic-auth-usermapping-table .fa-trash',function(){
        $(this).closest("tr").remove();
    });
    //--- End of Data Sources - Dynamic Auth table ---//
    
    //--- Start of External Datasource - Properties table ---//
    $("#ds-ext-properties-add-btn").click(function() {
        var markup = "<tr><td><input type='text' placeholder='Property Name' class='form-control' style='width: 100%;' /></td><td><input type='text' placeholder='Property Value' class='form-control' style='width: 100%;' /></td><td class='text-center'><input type='checkbox' /></td><td class='text-center'><i class='fa fa-trash'></i></td></tr>";

        $("#ds-ext-properties-table tbody").append(markup);
    });
    
    $(document).on('click','#ds-ext-properties-table .fa-trash',function(){
        $(this).closest("tr").remove();
    });
    //--- End of External Datasource - Properties table ---//
    
    //$("#ds-add-ds-modal").modal({ show : true });
        
});

