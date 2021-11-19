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
    <link href="<c:url value='https://unpkg.com/boxicons@2.0.7/css/boxicons.min.css'/>" rel='stylesheet'>
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
