<%@ page import="com.acme.shoppingcart.admin.AdminClient" %>
<%@ page import="com.acme.shoppingcart.admin.product.types.Category" %>
<h3>Categories</h3>
<ul class="editable-catagory-list">
    <%
        AdminClient client = new AdminClient();
        Category[] categories = client.listProductCategories();
    %>


                <%
                    if (categories == null || categories.length == 0) {
                %>
                <li>No items available</li>
                <%
                } else {
                    for (Category category : categories) {
                %>
                <li>
        		<table>
                <tr>
                <td><a><%= category.getCategoryName()%>
                </a></td>
                <td class="line-conect"></td>
                <td>
                    <a class="delete-icon" onclick="delete_category('<%= category.getCategoryName()%>')"></a>
                </td>
            </tr>
            </table>
    </li>
                <%
                        }
                    }
                %>


</ul>