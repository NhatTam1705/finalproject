<%-- 
    Document   : home
    Created on : Nov 12, 2021, 9:47:53 AM
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
        <link rel="stylesheet" href="<c:url value='/template/login/css/SRegister.css'/>">
        <link rel="stylesheet" href="<c:url value='/template/font/themify-icons/themify-icons.css'/>">
        <script src="<c:url value='/template/login/js/jQuery.js'/>"></script>
        <script src="<c:url value='/template/login/js/common.js'/>"></script>

    </head>

    <body>
        <form id="form-register" name="registerInfoForm" action="" method="post">
            <div id="main">
                <!--begin header-->
                <%@include file="/common/login/register/header.jsp"%>
                <!--end header-->

                <!--begin body-->
                <dec:body/>
                <!--end body-->
                
                <!--begin footer-->
                <%@include file="/common/login/footercommon.jsp" %>
                <!--end footer-->
                
                <script src="<c:url value='/template/login/js/showpass.js'/>"></script>
            </div>
        </form>
    </body>

</html>