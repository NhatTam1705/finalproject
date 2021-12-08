<%-- 
    Document   : CPPhone
    Created on : Nov 13, 2021, 11:24:52 PM
    Author     : 19110
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp" %>
<c:url var="changePhoneForm" value="/logincommon-change-phone.html" />
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Welcome to our website</title>
    </head>
    <body>
        <div id="content">
            <form name="loginForm" action="">
                <input type="hidden">
                <input type="hidden">
                <input type="hidden">
                <input type="hidden">
                <input type="hidden">
                <input type="hidden">
            </form>
            <div id="login-form">
                <div id="content-title">
                    <h1>Change Password Phone</h1>
                </div>
                <div id="content_v2">
                    <div id="dialog" style="display: none">
                        <div class="ant-modal-mask"></div>
                        <div class="ant-modal-wrap">
                            <div class="ant-modal group-modal-warp"></div>
                        </div>
                    </div>
                </div>
                <form name="changePhoneForm" id="form-id-email" action="${changePhoneForm}" method="post">
                    <div id="login-main-content" class="reset-pw ">
                        <div class="login-main">
                            <div class="login-box">
                                <p></p>
                                <div id="errormessage" class="errormessage"></div>
                                <div class="pt-24">
                                    <input id="textbox-user" type="tel" required name="pojo.telephone" size="20" tabindex="1"
                                           class="user textbox-input " placeholder="+84">
                                </div>
                                <div class="pt-24 pwd-input">
                                    <input type="password" name="pojo.password" size="20" tabindex="1" class="pass textbox-input"
                                           placeholder="Old Password">
                                    <img class="new-psw-show"
                                         src="<c:url value='/template/img/pictureContent/icon-show-pass.png'/>"
                                         style="visibility: hidden;">
                                    <img class="new-psw-hide"
                                         src="<c:url value='/template/img/pictureContent/icon-hide-pass.png'/>">
                                </div>
                                <div class="pt-24 pwd-input">
                                    <input type="password" name="newPassword" size="20" tabindex="1" class="pass textbox-input"
                                           placeholder="New Password">
                                    <img class="new-psw-show" src="<c:url value='/template/img/pictureContent/icon-show-pass.png'/>"
                                         style="visibility: hidden;">
                                    <img class="new-psw-hide" src="<c:url value='/template/img/pictureContent/icon-hide-pass.png'/>">
                                </div>
                                <div class="pt-24 pwd-input">
                                    <input type="password" name="confirmPassword" size="20" tabindex="1" class="pass textbox-input"
                                           placeholder="Confirm Password">
                                    <img class="confirm-psw-show"
                                         src="<c:url value='/template/img/pictureContent/icon-show-pass.png'/>"
                                         style="visibility: hidden;">
                                    <img class="confirm-psw-hide"
                                         src="<c:url value='/template/img/pictureContent/icon-hide-pass.png'/>">
                                </div>
                                <%-- <div class="pt-24 row">
                                    <a href="#" onclick="createCaptcha()">
                                        <div id="create-captcha" class="captcha textbox-input">
                                            <script>createCaptcha();</script>
                                        </div>
                                    </a>
                                    <div class="input-catpcha">
                                        <input type="text" name="uid" tabindex="1" class="captcha textbox-input"
                                               placeholder="Captcha">
                                    </div>
                                </div> --%>
                                <div class="row">
                                    <div class="">
                                        <a href="<c:url value='/logincommon-home.html?action=login'/>">
                                            <input class="btn-controll btn-cancel" type="button" value="Cancel">
                                        </a>
                                    </div>
                                    <div class="">
                                        <a href="${changePhoneForm}">
                                            <input class="btn-controll btn-submit" type="submit" value="Submit">
                                        </a>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </form>
            </div>
        </div>
        <script src="<c:url value='/template/login/js/CPass.js'/>"></script>
    </body>
</html>
