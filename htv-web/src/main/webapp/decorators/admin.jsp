<%-- 
    Document   : admin
    Created on : Nov 11, 2021, 10:55:47 AM
    Author     : 19110
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<!DOCTYPE html>
<html lang="en" dir="ltr">
  <head>
    <meta charset="UTF-8">
    <link rel="icon" type="image/x-icon" href="<c:url value='/template/img/icon-logo.ico'/>" />
    <title><dec:title default="TV-Company"/></title>
    <link rel="stylesheet" href="<c:url value='/template/admin/css/style.css'/>">
    <%--  --%>
    <%-- <link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css"> --%>
    <link rel="stylesheet" href="<c:url value='/template/admin/assets/css/bootstrap.min.css' />" />
    <%-- <link rel="stylesheet" href="<c:url value='/template/admin/font-awesome/4.5.0/css/font-awesome.min.css' />" /> --%>
    <%-- <link rel="stylesheet" href="<c:url value='/template/admin/assets/css/ace.min.css' />" class="ace-main-stylesheet" id="main-ace-style" /> --%>
    <link href="<c:url value='https://unpkg.com/boxicons@2.0.7/css/boxicons.min.css'/>" rel='stylesheet'>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <script type='text/javascript' src='<c:url value="/template/admin/js/jquery-2.2.3.min.js" />'></script>
    <script src="<c:url value='/template/admin/assets/js/jquery.2.1.1.min.js' />"></script>
    <!--<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">-->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
    <link rel="stylesheet" href="<c:url value='/template/admin/css/global_admin_style.css'/>">
    <script type="text/javascript" src="<c:url value='/template/admin/js/global_admin_script.js'/>"></script>
    <%-- <script src="<c:url value='/template/admin/assets/js/jquery.validate.min.js' />"></script> --%>
<!--    <script src="<c:url value='https://cdnjs.cloudflare.com/ajax/libs/jquery-validate/1.19.3/jquery.validate.min.js' />"></script>
    <script src="<c:url value='https://cdn.jsdelivr.net/npm/jquery-validation@1.19.3/dist/jquery.validate.min.js' />"></script>-->
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    </head>
<body>
            <%-- begin header --%>
            <%@include file="/common/admin/menu.jsp"%>
            <%-- end header --%>

            <section class="home-section">
                <%-- begin body --%>
                <dec:body/>
                <%-- end body --%>
                
                <%-- begin footer --%>
                <%@include file="/common/admin/footer.jsp"%>
                <%-- end footer --%>
            </section>

    
        <script src="<c:url value='/template/admin/js/script.js'/>"></script>

</body>
</html>
