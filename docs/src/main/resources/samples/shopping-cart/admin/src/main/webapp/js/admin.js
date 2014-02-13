function load_new_category_page() {
    var url = "admin_includes/add_new_category.jsp";
    $.ajax({
        url: url,
        async: false,
        success: function(data) {
            $('#admin_content').html(data);
            $('#form_back').corner();
            $(document).ready(function() {
                //Asdd validation rules
                $("#saveCategory").validate({
                    rules: {
                        categoryName: "required",
                        categoryDescription: "required",
                        file:"required"
                        
                    },
                    messages: {
                        categoryName: "Please enter a category name",
                        categoryDescription: "Please enter a description",
                        file:"Please enter a image"
                    },
                    submitHandler: function(form) {
                        $(form).ajaxSubmit(function() {  //Ajax binding to the form submit button
                        	 //alert(data);
                        	$('#saveCategory').resetForm();
                        });
                    }
                });
            });
        }
    });
}
function load_new_product_page() {
    var url = "admin_includes/add_new_product.jsp";
    $.ajax({
        url: url,
        async: false,
        success: function(data) {
            $('#admin_content').html(data);
            $('#form_back').corner();
            $(document).ready(function() {
                //Add validation rules
                $("#saveProduct").validate({
                    rules: {
                        code: "required",
                        productName: "required",
                        description: "required",
                        price: {required:true,number:true},
                        reorderLevel: "required",
                        reorderQuantity: "required",
                        productVendor: "required",
                        price: {required:true,number:true}
                        	
                    },
                    messages: {
                        code: "Please enter a code",
                        productName: "Please enter a name",
                        description: "Please enter a description",
                        price: {required:"Please enter a price",number:"Please enter a valid number"},
                        reorderQuantity: "Please enter a reorder quantity",
                        productVendor: "Please enter a product vendor",
                        quantityInStock: "Please enter a quantity"
                    },
                    submitHandler: function(form) {//Ajax binding to the form submit button
                        $(form).ajaxSubmit(function(data) {
                            //alert(data);
                        	 list_products();
                        });
                    }
                });
            });
        }
    });
}

function list_products() {
    var url = "admin_includes/list_products.jsp";
    $.ajax({
        url: url,
        async: false,
        success: function(data) {
            $('#admin_content').html(data);
        }
    });
}

function populate_edit_product_page(code){
	   var url = "admin_includes/update_product_ui.jsp";
	    $.ajax({
	        url: url,
	        async: false,
	        data : {
	        	productCode : code
	        },
	        success: function(data) {
	        	$('#admin_content').html(data);
	            $('#form_back').corner();
	            $(document).ready(function() {
	                //Add validation rules
	                $("#editProduct").validate({
	                    rules: {
	                        code: "required",
	                        productName: "required",
	                        description: "required",
	                        price: {required:true,number:true},
	                        reorderLevel: "required",
	                        reorderQuantity: "required",
	                        productVendor: "required",
	                        price: {required:true,number:true}
	                        	
	                    },
	                    messages: {
	                        code: "Please enter a code",
	                        productName: "Please enter a name",
	                        description: "Please enter a description",
	                        price: {required:"Please enter a price",number:"Please enter a valid number"},
	                        reorderQuantity: "Please enter a reorder quantity",
	                        productVendor: "Please enter a product vendor",
	                        quantityInStock: "Please enter a quantity"
	                    },
	                    submitHandler: function(form) {//Ajax binding to the form submit button
	                        $(form).ajaxSubmit(function(data) {
	                            //alert(data);
	                        	 list_products();
	                        });
	                    }
	                });
	            });
	          
	        }
	    });

}
function delete_product(code){
     var url = "admin_includes/delete_products.jsp";
    $.ajax({
        url: url,
        async: false,
        data : {
        	productCode : code
        },
        success: function(data) {
        	alert(data);
            list_products();
        }
    });
}
function add_new_category() {

}
$(document).ready(function() {
    load_new_category_page();
    list_categories();
});

function list_categories(){
     var url = "admin_includes/list_categories.jsp";
     $.ajax({
        url: url,
        async: false,
        success: function(data) {
            $('#categories_list').html(data);
        }
    });
}
function delete_category(name){
    var url = "admin_includes/delete_category.jsp";
     $.ajax({
        url: url,
        async: false,
        data: {
        	categoryName : name
        },
        success: function(data) {
        	alert(data);
            list_categories();
        }
    });
}
