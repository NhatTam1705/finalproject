<%-- 
    Document   : RBPhone
    Created on : Nov 13, 2021, 4:06:06 PM
    Author     : 19110
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Welcome to our website</title>
    </head>
    <body>
        <div id="mainbox">
            <div id="content-title" class="about">
                <h1>
                    &nbsp;&nbsp;Register
                    <font>Create a new account</font>
                </h1>
            </div>
            <div id="content">
                <div id="content-top"></div>
                <div class="register">
                    <div class="reset-tab-box">
                        <a href="<c:url value='/register-email.html'/>">
                            <span class="set-offtab set-tab">Register by Email</span>
                        </a>
                        <span class="set-ontab set-tab">Register by Mobile</span>
                    </div>
                    <div class="register-main-box">
                        <div class="register-message">
                            <a name="message">
                                <span id="spanmessage" class="redtips"></span>
                            </a>
                        </div>
                        <div class="register-online">
                            <div class="register-text">
                                Mobile Number
                                <span class="register-red-star">*</span>
                            </div>
                            <input type="text" name="registerVO.phone" class="register-input" tabindex="1"
                                   id="registerVO.phone" onblur="checkPhone()">
                            <span class="redtips" id="spanphoneinfo"></span>
                        </div>
                        <div class="register-online">
                            <div class="register-text">
                                Password
                                <span class="register-red-star">*</span>
                            </div>
                            <input type="password" name="registerVO.password" class="register-input" tabindex="6"
                                   id="registerVO.password" onblur="checkPassword()" style="padding-right: 30px">
                            <img class="psw-show" src="<c:url value='/template/img/pictureContent/icon-show-pass.png'/>"
                                 style="visibility: hidden;">
                            <img class="psw-hide" src="<c:url value='/template/img/pictureContent/icon-hide-pass.png'/>">
                            <span class="redtips" id="spanpwdinfo"></span>
                        </div>
                        <div class="register-online">
                            <div class="register-text">
                                SMS code
                                <span class="register-red-star">*</span>
                            </div>
                            <div>
                                <input type="text" name="registerVO.sms" class="phone-vercode-input" tabindex="7"
                                       id="registerVO.sms" onblur="checkSMS()">
                                <input id="sendButton" type="button" class="phone-button" value="Get code"
                                       tabindex="8">
                            </div>
                            <span class="redtips" id="spansmsinfo"></span>
                        </div>
                        <div class="tip">
                            <span class="redtip1"></span>
                        </div>
                        <input type="button" class="sub-bottom register-submit" name="regbtn" value="Register"
                               onclick="userRegister()" tabindex="9" id="regbtn" onclick="userRegister()">
                        <div class="bottom"></div>
                    </div>
                </div>
                <div id="content-bottom"></div>
            </div>
        </div>
        <script src="<c:url value='/template/login/js/SPhone.js'/>"></script>
    </body>
</html>
