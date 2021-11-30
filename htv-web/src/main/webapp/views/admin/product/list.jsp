<%-- 
    Document   : list
    Created on : Nov 25, 2021, 9:23:47 PM
    Author     : 19110
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Product</title>
    </head>
    <body>
        <display:table name="testList" sort="external" defaultsort="1" id="element">
            <display:column property="id" title="ID" sortable="true" sortName="id" />
            <display:column property="firstName" sortable="true" sortName="firstName" title="First Name" />
            <display:column property="lastName" sortable="true" sortName="lastName" title="Last Name" />
            <display:column property="address" sortable="true" sortName="address" title="Email Address"/>
        </display:table>
    </body>
</html>
