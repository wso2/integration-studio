<%

   /* Item[] items = mgr.listProducts("TODO"); // TODO
//if empty, populate cart manager with items
    if ((items == null) || (items.length <= 3)) {
        mgr.createItem("500D",
                       "Canon EOS 500D / Rebel T1i Kit with  EF-S 18-55mm IS Lens 15.1..",
                       "images/tmp/Canon.jpg", 620.0);
        mgr.createItem("600D",
                       "Canon EOS 600D / Rebel T1i Kit with  EF-S 20-55mm IS Lens 18.1.. ",
                       "images/tmp/Canon.jpg", 720.0);
        mgr.createItem("700D",
                       "Canon EOS 700D / Rebel T1i Kit with  EF-S 30-55mm IS Lens 20.1.. ",
                       "images/tmp/Canon.jpg", 920.0);

    }*/
%>
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

    <div id="content-area">
        <jsp:include page="realhome.jsp"/>
    </div>
    <!-- content-area end -->
    <jsp:include page="footer.jsp"/>
</div>
</body>
</html>