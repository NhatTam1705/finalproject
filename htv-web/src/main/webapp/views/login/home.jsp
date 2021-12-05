<%-- 
    Document   : home
    Created on : Nov 13, 2021, 9:37:09 PM
    Author     : 19110
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp" %>
<c:url var="formUrl" value="/logincommon-home.html" />
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Welcome to our website</title>
    </head>
    <body>
        <div id="content">
            <div id="content-title">
                <h1>Sign In with Uniportal ID</h1>
            </div>
            <div id="content_v2">
                <div id="dialog" style="display: none">
                    <div class="ant-modal-mask"></div>
                    <div class="ant-modal-wrap">
                        <div class="ant-modal group-modal-warp"></div>
                    </div>
                </div>
            </div>
            <div id="login-main-content" class="reset-pw">
                <div class="reset-tab-box">
                    <div class="set-show " id="text-user">
                        <span class="set-tab font-user">User ID/Email</span>
                    </div>
                    <div class="set-hidden" id="text-phone">
                        <span class="set-tab">User Mobile</span>
                    </div>
                </div>
                <form name="loginForm" id="form-id-email" action="${formUrl}" method="post">
                    <div class="login-main">
                        <div class="login-box">
                            <p></p>
                            <div id="errormessage" class="errormessage">
                                <c:if test="${not empty messageResponse}">
                                    <div class="alert alert-block alert-${alert}">
                                        <!--                                        <button type="button" class="close" data-dismiss="alert">-->
                                        <i class="fas fa-times"></i>
                                        <!--</button>-->
                                        ${messageResponse}
                                    </div>
                                </c:if>
                            </div>
                            <div class="pt-24">
                                <input id="textbox-user" type="email" required size="20" tabindex="1"
                                       class="user textbox-input " placeholder="Email" name="pojo.email">
                            </div>
                            <div class="pt-24 pwd-input">
                                <input type="password" required size="20" tabindex="2"
                                       class="pass textbox-input" placeholder="Password" name="pojo.password">
                                <img class="psw-show-f1" src="<c:url value='/template/img/pictureContent/icon-show-pass.png'/>"
                                     style="visibility: hidden;">
                                <img class="psw-hide-f1" src="<c:url value='/template/img/pictureContent/icon-hide-pass.png'/>">
                            </div>
                            <div>
                                <input class="login-submit-pwd" type="submit" tabindex="3" value="Log In">
                            </div>
                            <div class="modify-url">
                                <a href="<c:url value='/register-email.html'/>" class="registr">Register</a>
                                <a href="<c:url value='/logincommon-change-email.html'/>" class="underline">Change Password</a>
                                <a href="<c:url value='/logincommon-forgot.html'/>" class="underline">Forgot Password</a>
                            </div>
                        </div>
                    </div>
                </form>
                <form name="loginForm" id="form-mobile" class="hide-form" action="${formUrl}" method="post">
                    <div class="login-main">
                        <div class="login-box">
                            <p></p>
                            <div id="errormessage" class="errormessage">
                                <c:if test="${not empty messageResponse}">
                                    <div class="alert alert-block alert-${alert}">
                                        <button type="button" class="close" data-dismiss="alert">
                                            <i class="fas fa-times"></i>
                                        </button>
                                        ${messageResponse}
                                    </div>
                                </c:if>
                            </div>
                            <div class="pt-24">
                                <input id="textbox-phone" type="tel" pattern="[+]{0}[0-9]{10}" required 
                                       size="20" tabindex="1" class="phone textbox-input " placeholder="+84" name="pojo.telephone">
                            </div>
                            <div class="pt-24 pwd-input">
                                <input type="password" required size="20" tabindex="2"
                                       class="pass textbox-input" placeholder="Password" name="pojo.password">
                                <img class="psw-show-f2" src="<c:url value='/template/img/pictureContent/icon-show-pass.png'/>"
                                     style="visibility: hidden;">
                                <img class="psw-hide-f2" src="<c:url value='/template/img/pictureContent/icon-hide-pass.png'/>">
                            </div>
                            <div>
                                <input class="login-submit-pwd" type="submit" tabindex="3" value="Log In">
                            </div>
                            <div class="modify-url">
                                <a href="<c:url value='/register-phone.html'/>" class="registr">Register</a>
                                <a href="<c:url value='/logincommon-change-phone.html'/>" class="underline">Change Password</a>
                                <a href="<c:url value='/logincommon-forgot.html'/>l" class="underline">Forgot Password</a>
                            </div>
                        </div>
                    </div>
                </form>
            </div>
        </div>
        <script src="<c:url value='/template/login/js/login.js'/>"></script>
    </body>
</html>
