<%@ page import="com.acme.shoppingcart.admin.AdminClient" %>
<%@ page import="com.acme.shoppingcart.admin.product.types.ProductE"%>
<h1>Add new Product</h1>


<form id="editProduct" action="admin_includes/update_product.jsp" method="post" enctype="multipart/form-data">
    <div class="form-back" id="form_back">
    <%
        AdminClient client = new AdminClient();
   		ProductE[] products = client.getProductByCode(request.getParameter("productCode"));
   		String categoryName =products[0].getCategoryName();
   		String code = request.getParameter("productCode");
   		String productName = products[0].getProductName();
   		String productVendor = products[0].getProductVendor();
   		String quantityInStock = products[0].getQuantityInStock().toString();
   		String description = products[0].getProductDescription();
   		double price = products[0].getPrice();
   		String reorderLevel =  products[0].getReorderLevel().toString();
   	    String reorderQuantity  = products[0].getReorderQuantity().toString();
   	    session.setAttribute("productImage", products[0].getImage());
   			
    %>
        <table>
            <tr>
             <tr> 
                <td><label for="categoryName">categorycName</label></td>
                <td><input type="text" class="textinput" id="categoryName" name="categoryName" value="<%=categoryName%>" readonly="readonly" /></td>
            </tr>
             
            </tr>
            <tr> 
                <td><label for="code">Code</label></td>
                <td><input type="text" class="textinput" id="code" name="code"  value="<%=code%>" readonly="readonly" /></td>
            </tr>
            <tr>
                <td><label for="productName">Name</label></td>
                <td><input type="text" class="textinput" id="productName" name="productName"  value="<%=productName%>"/></td>
            </tr>
             <tr>
                <td><label for="productVendor">Vendor</label></td>
                <td><input type="text" class="textinput" id="productVendor" name="productVendor"  value="<%=productVendor%>"/></td>
            </tr>
             <tr>
                <td><label for="quantityInStock">Quantity</label></td>
                <td><input type="text" class="textinput" id="quantityInStock" name="quantityInStock"  value="<%=quantityInStock%>"/></td>
            </tr>
            <tr>
            	<td></td>
            	<td><img src="imageServlet?productCode=<%=code%>" width="100" alt="product image"/></td>
            <tr>
                <td>Image</td>
                <td><input type="file" name="imageFile"/></td>
            </tr>
            <tr>
                <td><label for="description">Description</label></td>
                <td><textarea id="description" name="description"><%=description%></textarea></td>
            </tr>
            <tr>
                <td><label for="price">Price</label></td>
                <td>
                    <div class="form_sign">$</div>
                    <input id="price" name="price" type="text" class="textinput indented"  value="<%=price%>"/></td>
            </tr>
            <tr>
                <td><label for="reorderLevel">Reorder Level</label></td>
                <td><input type="text" class="textinput" id="reorderLevel" name="reorderLevel"  value="<%=reorderLevel%>"/></td>
            </tr>
            <tr>
                <td><label for="reorderQuantity">Reorder Quantity</label></td>
                <td><input type="text" class="textinput" name="reorderQuantity" id="reorderQuantity"  value="<%=reorderQuantity%>"/></td>
            </tr>
            <tr>
                <td></td>
                <td><input type="submit" value="Save" class="button"/><input class="button"
                                                                                                         type="button"
                                                                                                         value="Cancel"/>
                </td>
            </tr>
            
            
        </table>
    </div>
</form>