<%-- 
    Document   : forgot
    Created on : Nov 13, 2021, 10:27:41 PM
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
        <div id="content">
            <div id="content-title">
                <h1>Forgot Password</h1>
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
                <form name="loginForm" id="form-id-email" action="">
                    <div class="login-main">
                        <div class="login-box">
                            <p></p>
                            <div id="errormessage" class="errormessage"></div>
                            <div class="pt-24">
                                <input id="textbox-user" type="email" required name="uid" size="20" tabindex="1"
                                       class="user textbox-input " placeholder="Email">
                            </div>
                            <div class="row">
                                <div class="col col-half">
                                    <a href="../../views/login/home.html">
                                        <input class="btn-controll btn-cancel" type="button" value="Cancel">
                                    </a>
                                </div>
                                <div class="col col-half">
                                    <a href="../../views/login/forgot.html">
                                        <input class="btn-controll btn-submit" type="submit" value="Submit">
                                    </a>
                                </div>
                            </div>
                        </div>
                    </div>
                </form>
                <form name="loginForm" id="form-mobile" class="hide-form" action="">
                    <div class="login-main">
                        <div class="login-box">
                            <p></p>
                            <div id="errormessage" class="errormessage"></div>
                            <div class="pt-24">
                                <input id="textbox-phone" type="tel" pattern="[+]{0}[0-9]{10}" required name="uid"
                                       size="20" tabindex="1" class="phone textbox-input " placeholder="+84">
                            </div>
                            <div class="row">
                                <div class="col col-half">
                                    <a href="../../views/login/home.html">
                                        <input class="btn-controll btn-cancel" type="button" value="Cancel">
                                    </a>
                                </div>
                                <div class="col col-half">
                                    <a href="../../views/login/home.html">
                                        <input class="btn-controll btn-submit" type="submit" value="Submit">
                                    </a>
                                </div>
                            </div>
                        </div>
                    </div>
                </form>
            </div>
        </div>
        <script src="<c:url value='/template/login/js/login.js'/>"></script>
    </body>
</html>
