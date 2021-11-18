<%-- 
    Document   : logincommon
    Created on : Nov 13, 2021, 4:37:01 PM
    Author     : 19110
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp" %>
<!DOCTYPE html>
<html lang="en">

    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title><dec:title default="Welcome to our website"/></title>
        <link rel="stylesheet" href="<c:url value='/template/login/css/SCommon.css'/>">
        <link rel="stylesheet" href="<c:url value='/template/font/themify-icons/themify-icons.css'/>">
        <script src="<c:url value='/template/login/js/app.js'/>"></script>
        <!--    <script src="https://code.jquery.com/jquery-3.3.1.js"
                integrity="sha256-2Kok7MbOyxpgUVvAk/HJ2jigOSYS2auK4Pfzbm7uH60=" crossorigin="anonymous">
                </script>
            <script>
                $(function () {
                    $("#header").load("../../views/login/header.html");
                });
            </script>-->
    </head>

    <body>
        <div id="main">

            <!--begin header-->
            <%@include file="/common/login/header.jsp" %>
            <!--end header-->

            <!--begin body-->
            <dec:body/>
            <!--end body-->

            <!--begin footer-->
            <%@include file="/common/login/footercommon.jsp" %>
            <!--end footer-->


        </div>
    </body>
</html>
