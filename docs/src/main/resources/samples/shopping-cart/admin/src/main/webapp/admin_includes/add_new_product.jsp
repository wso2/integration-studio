<%@ page import="com.acme.shoppingcart.admin.AdminClient" %>
<%@ page import="com.acme.shoppingcart.admin.product.types.Category"%>
<h1>Add new Product</h1>

<form id="saveProduct" action="admin_includes/save_product.jsp" method="post" enctype="multipart/form-data">
    <div class="form-back" id="form_back">
    <%
        AdminClient client = new AdminClient();
        Category[] categories = client.listProductCategories();
    %>
        <table>
            <tr>
                <td class="left-col">Category</td>
                <td>
                    <select id="categoryName" name="categoryName">
                   <%
                    if (categories == null || categories.length == 0) {
                   %>
                        <option value="None">&lt;No Categories&gt;</option>
                   <%
                    } else {
                     for (Category category : categories) {
                  %>
                        <option value="<%= category.getCategoryName()%>"><%= category.getCategoryName()%></option>
                  <%
                        }
                    }
                  %>
                    </select>
                </td>
            </tr>
            <tr>
                <td><label for="code">Code</label></td>
                <td><input type="text" class="textinput" id="code" name="code"/></td>
            </tr>
            <tr>
                <td><label for="productName">Name</label></td>
                <td><input type="text" class="textinput" id="productName" name="productName"/></td>
            </tr>
             <tr>
                <td><label for="productVendor">Vendor</label></td>
                <td><input type="text" class="textinput" id="productVendor" name="productVendor"/></td>
            </tr>
             <tr>
                <td><label for="quantityInStock">Quantity</label></td>
                <td><input type="text" class="textinput" id="quantityInStock" name="quantityInStock"/></td>
            </tr>
            <tr>
                <td>Image</td>
                <td><input type="file" name="imageFile"/></td>
            </tr>
            <tr>
                <td><label for="description">Description</label></td>
                <td><textarea id="description" name="description"></textarea></td>
            </tr>
            <tr>
                <td><label for="price">Price</label></td>
                <td>
                    <div class="form_sign">$</div>
                    <input id="price" name="price" type="text" class="textinput indented"/></td>
            </tr>
            <tr>
                <td><label for="reorderLevel">Reorder Level</label></td>
                <td><input type="text" class="textinput" id="reorderLevel" name="reorderLevel"/></td>
            </tr>
            <tr>
                <td><label for="reorderQuantity">Reorder Quantity</label></td>
                <td><input type="text" class="textinput" name="reorderQuantity" id="reorderQuantity"/></td>
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