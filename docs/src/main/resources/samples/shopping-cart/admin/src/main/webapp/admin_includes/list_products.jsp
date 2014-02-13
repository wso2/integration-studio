<%@ page import="com.acme.shoppingcart.admin.AdminClient" %>
<%@ page import="com.acme.shoppingcart.admin.product.types.ProductE" %>
<h1>Products</h1>
<%
    AdminClient client = new AdminClient();
    ProductE[] products = client.listProducts();
%>
<table cellpadding="0" cellspacing="0" class="sortable-table">
    <thead>
    <tr>
        <th>Code</th>
        <th>Product Name</th>
        <th>Product Description</th>
        <th>Qty</th>
        <th>Re-order Level</th>
        <th>Action</th>
    </tr>
    </thead>
    <tbody>
    
        <%
           if (products == null || products.length == 0) {
        %>
        <tr>
        <td>
            <div>No items available</div>
        </td>
        </tr>
        <%
        } else {
            for (ProductE product : products) {
        %>

	<tr>
        <td><%= product.getProductCode()%>
        </td>
        <td><%= product.getProductName()%>
        </td>
        <td><%= product.getProductDescription() %>
        </td>
        <td><%= product.getQuantityInStock() %>
        </td>
        <td><%= product.getReorderLevel() %>
        </td>
         <td>
            <table>
                <tr>
                    <td><a class="edit-icon" onclick="populate_edit_product_page('<%= product.getProductCode()%>')"></a></td>
                    <td><a class="delete-icon" onclick="delete_product('<%= product.getProductCode()%>')"></a></td>
                </tr>
            </table>
        </td>
    </tr>
        <%
                }
            }
        %>
       
    </tbody>
</table>