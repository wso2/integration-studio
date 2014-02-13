<%
    ProductsClient client = new ProductsClient();
    Category[] categories = client.listProductCategories();
%>

<%@page import="com.acme.shoppingcart.portal.ProductsClient" %>
<%@ page import="com.acme.shoppingcart.portal.product.types.Category" %>
<div class="home-top-msg">
    <table>
        <tr>
            <td align="left">Welcome to Acme</td>
            <td align="right"></td>
        </tr>
    </table>
</div>
<table cellpadding="0" cellspacing="0">
    <tr>
        <td style="padding-right:10px;">
            <div class="catagories-block" id="catagories_block">
                <div class="catagories-top">&nbsp;</div>
                <div class="catagories-mid">
                    <h3>Your Favorite Categories</h3>
                    <ul class="catagories-list">
                        <% if (categories != null) { %>
                        <% for (Category category : categories) {%>
                        <li>
                            <a href="view-category.jsp?category=<%= category.getCategoryName() %>">
                                <%= category.getCategoryName() %>
                            </a>
                        </li>
                        <% } %>
                        <% } %>
                    </ul>
                </div>
                <div class="catagories-bottom">&nbsp;</div>
            </div>
        </td>
        <!-- TODO: Following should not be hard coded -->
        <td>
            <table cellpadding="0" cellspacing="0">
                <tr>
                    <td colspan="2"><img src="images/home-add-back.png"/></td>
                </tr>
                <tr>
                    <td colspan="2">
                        <h2>Recommendations for You in Electronics</h2>
                        <table cellpadding="0" cellspacing="0" border="0"
                               class="product-table-tiled">
                            <tr>
                                <td>
                                    <a class="link-to-product"><img
                                            src="images/tmp/Canon.jpg"
                                            width="100" alt="Canon"></a>

                                    <div>Canon EOS 500D / Rebel T1i Kit with EF-S 18-55mm IS Lens
                                         15.1 ...
                                    </div>
                                    <table>
                                        <tr>
                                            <td class="price" align="left">$620</td>
                                            <td align="right"><a class="add-to-cart" onclick=""
                                                                 id="item200">add to cart</a>
                                            </td>
                                        </tr>
                                    </table>
                                </td>
                                <td>
                                    <div><img
                                            src="images/tmp/Canon.jpg"
                                            width="100" alt="Canon">
                                    </div>
                                    <div>Canon EOS 500D / Rebel T1i Kit with EF-S 18-55mm IS Lens
                                         15.1 ...
                                    </div>
                                    <table>
                                        <tr>
                                            <td class="price" align="left">$620</td>
                                            <td align="right"><a class="add-to-cart" onclick=""
                                                                 id="item300">add to cart</a>
                                            </td>
                                        </tr>
                                    </table>
                                </td>
                            </tr>
                        </table>
                    </td>
                </tr>
            </table>
        </td>
    </tr>
</table>

