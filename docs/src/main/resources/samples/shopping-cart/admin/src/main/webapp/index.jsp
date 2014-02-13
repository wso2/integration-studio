<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <jsp:include page="admin_header_includes.jsp"/>
    <%--Additional Includes--%>
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
                    <td align="right"><a href="logout.jsp">Logout</a></td>
                </tr>
                </tbody>
            </table>
        </div>
        <ul class="admin-links">
            <li><a class="new-category-link" onclick="load_new_category_page()">Add New Category</a></li>
            <li><a class="new-product-link" onclick="load_new_product_page()">Add New Product</a></li>
            <li><a class="list-product-link" onclick="list_products()">List Product</a></li>
        </ul>
        <table cellpadding="0" cellspacing="0" class="main-table">
            <tr>
                <td class="catagories-container">
                    <div class="catagories-block" id="categories_list"></div>
                </td>
                <td id="admin_content">
                </td>
            </tr>
        </table>

    </div>
    <!-- content-area end -->
    <div id="footer-area"><p>Copyright &copy; 1995-2010 Acme Inc</p></div>
</div>
</body>
</html>