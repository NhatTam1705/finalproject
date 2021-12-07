<%-- 
    Document   : product
    Created on : Dec 6, 2021, 11:31:17 PM
    Author     : 19110
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" rel="stylesheet"
            id="bootstrap-css" />
        <link rel="stylesheet" href="<c:url value='/template/product/css/details.css'/>">
        <link rel="stylesheet" href="<c:url value='/template/product/css/shopping.css'/>">
        <link rel="stylesheet" href="<c:url value='/template/font/themify-icons/themify-icons.css'/>" />
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css" />
        <link rel="stylesheet" href="https://kit-pro.fontawesome.com/releases/v5.12.1/css/pro.min.css" />
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.css" />
        <script src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
        <script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
        <script type="module" src="https://unpkg.com/ionicons@5.5.2/dist/ionicons/ionicons.esm.js"></script>
        <link rel="stylesheet" href="myProjects/webProject/icofont/css/icofont.min.css">
        <script src="https://unpkg.com/ionicons@5.5.2/dist/ionicons/ionicons.js"></script>
        <title><dec:title default="TV-Company"/></title>
    </head>
    <body>
        <div id="main">
            <%-- begin header --%>
            <%@include file="/common/web/header.jsp"%>
            <%-- end header --%>

            <%-- begin body --%>
            <dec:body/>
            <%-- end body --%>

            <%-- begin footer --%>
            
            <%-- end footer --%>
        </div>
        <script src="<c:url value='/template/web/js/script.js'/>"></script>
        <script src="<c:url value='/template/web/js/product.js'/>"></script>
    </body>
</html>
