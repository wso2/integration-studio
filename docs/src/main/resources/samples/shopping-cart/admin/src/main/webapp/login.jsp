<%!
    private String getTenantDomain(HttpServletRequest request) {
        String requestURI = request.getRequestURI();
        String temp = requestURI.substring(requestURI.indexOf("/t/") + 3);
        String tenantDomain = temp.substring(0, temp.indexOf("/"));
        return tenantDomain;
    }
%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <link rel="stylesheet" href="css/cart-styles.css" type="text/css"/>
    <link rel="stylesheet" href="css/navigation-styles.css" type="text/css"/>
    <link rel="stylesheet" href="css/admin-styles.css" type="text/css"/>

    <%--Additional Includes--%>
    <script type="text/javascript">
        function submitForm() {
            document.loginFrm.j_username.value = document.loginFrm.tmpUsername.value;
            document.loginFrm.submit();
        }
    </script>
</head>
<body>
<div id="container">
    <div id="header-area">
        <jsp:include page="admin_header.jsp"/>
    </div>
    <!-- Header-are end -->

    <div id="content-area">
        <div class="home-top-msg">
            <table>
                <tbody>
                <tr>
                    <td align="left">Acme Administration Panel</td>
                </tr>
                </tbody>
            </table>
        </div>
        <form method="POST" name="loginFrm" action='<%= response.encodeURL("j_security_check") %>'>
            <table border="0" cellspacing="5">
                <tr>
                    <th align="right">Username:</th>
                    <td align="left"><input type="text" name="tmpUsername"/><input type="hidden"
                                                                                   name="j_username">
                    </td>
                </tr>
                <tr>
                    <th align="right">Password:</th>
                    <td align="left"><input type="password" name="j_password"></td>
                </tr>
                <tr>
                    <td align="right">&nbsp;</td>
                    <td align="left"><input type="button" value="Log In" onclick="submitForm()">&nbsp;<input
                            type="reset"></td>
                </tr>
            </table>
        </form>
    </div>
    <!-- content-area end -->
    <div id="footer-area"><p>Copyright &copy; 1995-2010 Acme Inc</p></div>
</div>
</body>
</html>