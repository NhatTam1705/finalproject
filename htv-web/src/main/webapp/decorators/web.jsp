<%-- 
    Document   : web
    Created on : Nov 18, 2021, 9:18:56 PM
    Author     : 19110
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<!DOCTYPE html>
<html lang="en">

<head>
	<meta charset="UTF-8" />
	<meta http-equiv="X-UA-Compatible" content="IE=edge" />
	<meta name="viewport" content="width=device-width, initial-scale=1.0" />
	<link href="<c:url value='https://maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css'/>" rel="stylesheet" id="bootstrap-css" />
	<link rel="stylesheet" href="<c:url value='/template/web/css/home.css'/>" type="text/css" />
	<link rel="stylesheet" href="<c:url value='/template/font/themify-icons/themify-icons.css'/>" />
	<link rel="stylesheet" href="<c:url value='https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css'/>" />
	<link rel="stylesheet" href="<c:url value='https://kit-pro.fontawesome.com/releases/v5.12.1/css/pro.min.css'/>" />
	<script src="<c:url value='https://maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js'/>"></script>
	<script src="<c:url value='https://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js'/>"></script>
	<link rel="stylesheet" href="<c:url value='https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.css'/>" />
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
        <%@include file="/common/web/footer.jsp"%>
        <%-- end footer --%>    
        </div>
        <script src="<c:url value='/template/web/js/script.js'/>"></script>
    </body>
</html>