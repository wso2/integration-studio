<img src="images/logo.png" alt="Zbay" vspace="10"/>
<table cellpadding="0" cellspacing="0" border="0" class="top-bar">
    <tr>
        <td style="width:5px;"><img src="images/top-bar-left.gif" alt="-"/></td>
        <td class="top-bar-center">
            <jsp:include page="menu.jsp"/>
        </td>
        <td style="width:5px;"><img src="images/top-bar-right.gif" alt="-"/></td>
    </tr>
</table>
<div id="cartData" class="cartData" style="display:none"></div>
<form action="checkout-start.jsp" id="checkoutForm" method="post">
    <input type="hidden" id="cart" name="cart"/>
</form>
