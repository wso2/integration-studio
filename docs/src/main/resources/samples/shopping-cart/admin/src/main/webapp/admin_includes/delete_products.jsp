<%@ page import="com.acme.shoppingcart.admin.AdminClient" %>

<%

    AdminClient client = new AdminClient();
    boolean success = client.deleteProduct(request.getParameter("productCode"));
    if (success) {
        out.print("Product Deleted Sucessfully");
    } else {
        out.print("Error Deleting Product");
    }
%>