<%@ page import="com.acme.shoppingcart.admin.AdminClient" %>

<%

    AdminClient client = new AdminClient();
    boolean success = client.deleteCategory(request.getParameter("categoryName"));
    if (success) {
        out.print("Category Deleted Sucessfully");
    } else {
        out.print("Error Deleting Category");
    }
%>