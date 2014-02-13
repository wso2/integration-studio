<%@ page import="com.acme.shoppingcart.portal.ProductsClient" %>
<%@ page import="com.acme.shoppingcart.portal.product.types.Product" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">

<%
    String category = request.getParameter("category");
    ProductsClient client = new ProductsClient();
    Product[] products = client.listProducts(category);
%>
<html>
<head>
    <jsp:include page="header_includes.jsp"/>
</head>
<body>
<div id="container">
    <div id="header-area">
        <jsp:include page="header.jsp"/>
    </div>
    <!-- Header-are end -->
    <div id="content-area">
    <ul class="breadcrumb">
        <li><a href="index.jsp">Home </a></li>
        <li><a>Products</a></li>
        <li><a class="last"><%= category %>
        </a></li>
    </ul>
    <div style="clear:both;"></div>

    <div class="content">
        <div class="page-headding"><h1>
            <% if (products != null ) { %>
                <%= products.length %> items found in <%= category %>
            <% } %>
        </h1></div>
        <%
            int product_count = 0;
        %>
        <table cellpadding="0" cellspacing="0" border="0" class="product-table-tiled">

                <%
                    if (products == null || products.length == 0) {
                %>
                <td>
                    <div>No items available</div>
                </td>
                <%
                } else {
                    for (Product product : products) {
                        product_count++;
                %>
                <% if(product_count%3 == 1){%><tr><% } %>
                <td>
                    <strong><%= product.getProductName() %></strong>  <br/><br/>
                    <a class="link-to-product" href="view-product.jsp?productCode=<%= product.getProductCode()%>">
                        <img src="imageServlet?productCode=<%= product.getProductCode() %>"
                             width="100" alt="<%= product.getProductName() %>">
                    </a>
                    <br/>
                    <br/>
                    <div>
                        <%= product.getProductDescription()%>
                    </div>
                    <table>
                        <tr>
                            <td class="price" align="left">$<%= product.getPrice()%>
                            </td>
                            <td align="right">
                                <a class="add-to-cart"
                                   onclick="addToCart('<%= product.getProductCode()%>',
                                                      '<%=product.getPrice()%>',
                                                      '<%= product.getProductName() %>')">
                                    Add to Cart
                                </a>
                            </td>
                        </tr>
                    </table>
                </td>
                <% if(product_count%3 == 0){%></tr><% } %>
                <%
                        }
                        %>
            <%if( product_count%3 == 1){%><td></td><td></td></tr><%}%>
            <%if( product_count%3 == 2){%><td></td></tr><%}%>
        <%
                    }
                %>
        </table>
    </div>
        </div>

    <!-- content-area end -->
    <jsp:include page="footer.jsp"/>
</div>
</body>
</html>