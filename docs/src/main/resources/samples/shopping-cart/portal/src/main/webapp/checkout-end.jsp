<%@page import="com.acme.shoppingcart.portal.PurchasingClient" %>
<%@ page import="com.acme.shoppingcart.portal.purchasing.types.CustomerDetails" %>
<%@ page import="com.acme.shoppingcart.portal.purchasing.types.Order" %>
<%@ page import="com.acme.shoppingcart.portal.purchasing.types.PurchaseOrder" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
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

    <%
        PurchaseOrder purchaseOrder = new PurchaseOrder();

// product-code1:quantity1;product-code2:quantity2;product-code3:quantity3;
        String cart = request.getParameter("cart");
        if(cart != null) {
            String[] products = cart.split(";");
            for (String product : products) {
                String[] strings = product.split(":");
                String productCode = strings[0];
                String quantity = strings[1];
                Order order = new Order();
                order.setCode(productCode);
                order.setQuantity(quantity);
                purchaseOrder.addOrder(order);
            }
        }

        String email = request.getParameter("email");
        String cardHolder = request.getParameter("cardHolder");
        String cardType = request.getParameter("cardType");
        String cardNumber = request.getParameter("cardNumber");
        String shippingAddress = request.getParameter("shippingAddress");

        CustomerDetails customer = new CustomerDetails();
        customer.setName(cardHolder);
        customer.setCardType(cardType);
        customer.setShippingAddress(shippingAddress);
        customer.setCardNumber(cardNumber);
        customer.setEmail(email);

        new PurchasingClient().checkout(purchaseOrder, customer);
    %>
    <div id="content-area">
        <div style="clear:both;"></div>
        <div class="content">

            <table cellpadding="0" cellspacing="0" border="0" class="product-table-tiled">

                <tr>
                    <td>
                        <div>Sucessfully Checked out!</div>
                    </td>
            </table>
        </div>
    </div>

    <script type="text/javascript">
        clear_cart();
    </script>
    <!-- content-area end -->
    <jsp:include page="footer.jsp"/>
</div>
</body>
</html>