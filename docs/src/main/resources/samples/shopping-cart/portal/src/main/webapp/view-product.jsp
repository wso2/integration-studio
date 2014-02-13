s<%@ page import="com.acme.shoppingcart.portal.PortalUtils" %>
<%@ page import="com.acme.shoppingcart.portal.ProductsClient" %>
<%@ page import="com.acme.shoppingcart.portal.product.types.Product" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">

<%
	String productCode = request.getParameter("productCode");
	ProductsClient client = new ProductsClient();
	Product product = client.getProduct(productCode);
%>
<html>
<head>
    <jsp:include page="header_includes.jsp"/>
    <!-- Related Products Includes -->
    <script src="js/WSRequest.js" type="text/javascript"></script>
    <script src="js/relatedProductsStub.js" type="text/javascript"></script>
    <script type="text/javascript">
        var serviceEPR = '<%= PortalUtils.getEndpoint("related.products.epr") %>';
    </script>
    <script src="js/relatedProducts.js" type="text/javascript"></script>
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
            <li><a class="last">Digital Cameras</a></li>
        </ul>
        <div style="clear:both;"></div>
        <div class="content">
            <div id="product-title" class="page-headding">
                <h1><%=product.getProductName()%></h1></div>
                <div class="item-picture-box">
                <img src="imageServlet?productCode=<%=product.getProductCode()%>"
                width="100" alt="<%=product.getProductName()%>">
	            </div>
<div class="item-content-box">
                <table class="data-table">
                    <tbody>
                    <tr>
                        <th>Category :</th>
                        <td><%=product.getCategoryName()%></td>
                    </tr>
                    <tr>
                        <th>Description :</th>
                        <td><%=product.getProductDescription()%></td>
                    </tr>
                    <tr>
                        <th>Price:</th>
                        <td class="item-price"><%=product.getPrice()%></td>
                    </tr>
                    <tr>
                        <th>Vendor :</th>
                        <td><%=product.getProductVendor()%></td>
                    </tr>
                    </tbody>
                </table>
            </div>
            <div style="clear:both"></div>
            <div id="related-products-heading" class="page-headding" style="display:none"><h1>Related Items</h1></div>
            <!-- TODO: From Mashup -->
            <div id="related-products" style="display:none"></div>
        </div>
    </div>
</div>
<!-- content-area end -->
<jsp:include page="footer.jsp"/>
</body>
</html>