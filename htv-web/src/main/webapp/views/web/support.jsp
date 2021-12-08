<%-- 
    Document   : support
    Created on : Dec 8, 2021, 9:00:45 PM
    Author     : 19110
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="icon" type="image/x-icon" href="<c:url value='/template/img/icon-logo.ico'/>" />
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="<c:url value='/template/web/css/support.css'/>">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css" />
        <title>TV-Company</title>
    </head>
    <body>
        <div class="main">
        <div class="content">
            <div class="content-left">
                <h3 class="title">SUPPORT 24/24</h3>
                <br/>
                <p>TV-Company's companion!</p>
                <br/>
                <br/>
                <div class="info">
                    <i class="fas fa-map"></i>
                    <span class="text-location">HCMC University of Technology and Education</span>
                    <i class="fas fa-phone-alt"></i>
                    <span class="text-numberphone">
                        <a href="[0782883871]">0782883871</a>
                        or
                        <a href="[034193816]">0334193816</a>
                    </span>
                    <i class="fas fa-envelope"></i>
                    <span class="text-email">
                        <a href="[19110318@student.hcmute.edu.vn]">19110318@student.hcmute.edu.vn</a>
                        or
                        <a href="[19110318@student.hcmute.edu.vn]">19110283@student.hcmute.edu.vn</a>
                    </span>
                </div>
            </div>
            <div class="content-right">
                <label for="" class="text">Name</label>
                <input type="text">
                <label for="" class="text">Email</label>
                <input type="text">
                <label for="" class="text">Message</label>
                <input type="text">
                <button class="send" value="submit">Submit</button>
            </div>
        </div>
    </div>
    </body>
</html>
