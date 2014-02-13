<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <jsp:include page="header_includes.jsp"/>
    <script type="text/javascript">
        yEvent.onDOMReady(function() {
            document.getElementById("cartCheckout").style.display = "none";
            document.getElementById("cartTotal").innerHTML = get_cart_total();
        });
    </script>
</head>
<body>
<div id="container">
    <div id="header-area">
        <jsp:include page="header.jsp"/>
    </div>
    <!-- Header-are end -->

    <div id="content-area">

        <form action="checkout-end.jsp" method="post">
            <table cellpadding="0" cellspacing="0" border="0" class="formTable">
                <tr>
                    <td class="first">Sub total</td>
                    <td><span id="cartTotal"></span></td>
                </tr>
                <tr>
                    <td class="first">Email</td>
                    <td><input type="text" name="email"/></td>
                </tr>
                <tr>
                    <td class="first">Card Holder Name</td>
                    <td><input type="text" name="cardHolder"/></td>
                </tr>
                <tr>
                    <td>Payment Method</td>
                    <td>
                        <select name="cardType">
                            <option>VISA</option>
                            <option>MasterCard</option>
                            <option>PayPal</option>
                        </select>

                    </td>
                </tr>
                <tr>
                    <td>Shipping Address</td>
                    <td><textarea class="pro-description" name="shippingAddress"></textarea></td>
                </tr>
                <tr>
                    <td>Card Number</td>
                    <td><input type="text" name="cardNumber"/></td>
                </tr>
                <tr>
                    <td><input type="hidden" name="cart" value="<%= request.getParameter("cart")%>"/></td>
                    <td><input type="submit" value="Pay Now"/>&nbsp;<input type="button" value="Cancel"/></td>
                </tr>
            </table>
        </form>
    </div>
    <!-- content-area end -->
    <jsp:include page="footer.jsp"/>
</div>
</body>
</html>
