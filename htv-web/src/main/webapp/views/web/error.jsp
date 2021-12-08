<%-- 
    Document   : error
    Created on : Dec 8, 2021, 9:00:54 PM
    Author     : 19110
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="icon" type="image/x-icon" href="<c:url value='/template/img/icon-logo.ico'/>" />
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="<c:url value='/template/web/css/error.css'/>">
        <title>TV-Company</title>
    </head>
    <body>
        <section class="wrapper">
        <div class="container">

            <div id="scene" class="scene" data-hover-only="false">


                <div class="circle" data-depth="1.2"></div>

                <div class="one" data-depth="0.9">
                    <div class="content">
                        <span class="piece"></span>
                        <span class="piece"></span>
                        <span class="piece"></span>
                    </div>
                </div>

                <div class="two" data-depth="0.60">
                    <div class="content">
                        <span class="piece"></span>
                        <span class="piece"></span>
                        <span class="piece"></span>
                    </div>
                </div>

                <div class="three" data-depth="0.40">
                    <div class="content">
                        <span class="piece"></span>
                        <span class="piece"></span>
                        <span class="piece"></span>
                    </div>
                </div>

                <p class="p404" data-depth="0.50">TV-Company</p>
                <p class="p404" data-depth="0.10">TV-Company</p>

            </div>

            <div class="text">
                <article>
                    <p>Uh oh! Looks like you got lost. <br>Go back to the homepage if you dare!</p>
                    <a href="<c:url value='/home.html'/>">
                        <button>BACK TO HOME!</button>
                    </a>
                </article>
            </div>

        </div>
    </section>
    </body>
</html>
