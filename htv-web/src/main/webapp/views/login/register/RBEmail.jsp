<%-- 
    Document   : RBEmail
    Created on : Nov 13, 2021, 10:53:37 AM
    Author     : 19110
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<c:url var="registerUrl" value="/register-email.html" />
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
                <img src="<c:url value='/template/img/register/boxTop_Bg.png'/>" id="content-top">
                <form name="registerForm" action="${registerUrl}" method="post" id="registerForm">
                <div class="register">
                    <div class="reset-tab-box">
                        <%-- <img src="<c:url value='/template/img/register/tab_bg.gif'/>"> --%>
                        <span class="set-ontab set-tab">Register by Email</span>
                        <%-- <a href="<c:url value='/register-phone.html'/>">
                            <span class="set-offtab set-tab">Register by Mobile</span>
                        </a> --%>
                    </div>
                    <div class="register-main-box">
                        <div class="register-message">
                            <a name="message">
                                <span id="spanmessage" class="redtips"></span>
                            </a>
                        </div>
                        <!--                        <div class="register-online">
                                                    <div class="register-text">
                                                        User Id
                                                        <span class="register-red-star">*</span>
                                                    </div>
                                                    <input type="text" name="registerVO.userId" tabindex="1" value="" class="register-input"
                                                           id="registerVO.userId" onblur="checkAccount()">
                                                    <span class="redtips white-space-text" id="spanuinfo"></span>
                                                </div>-->
                        <div class="register-online">
                            <div class="register-text">
                                Email
                                <span class="register-red-star">*</span>
                            </div>
                            <input type="text" name="pojo.email" class="register-input" tabindex="2"
                                   id="registerVO.email" onblur="checkEmail()">
                            <span class="redtips" id="spanmailinfo"></span>
                        </div>
                        <div class="register-online">
                            <div class="register-text">
                                Password
                                <span class="register-red-star">*</span>
                            </div>
                            <input type="password" name="pojo.password" class="register-input" tabindex="3"
                                   id="registerVO.password" onblur="checkPassword()" style="padding-right: 30px">
                            <img class="psw-show" src="<c:url value='/template/img/pictureContent/icon-show-pass.png'/>"
                                 style="visibility: hidden;">
                            <img class="psw-hide" src="<c:url value='/template/img/pictureContent/icon-hide-pass.png'/>">
                            <span class="redtips" id="spanpwdinfo"></span>
                        </div>
                        <!-- <div class="register-online">
                            <div class="register-text">
                                First Name
                                <span class="register-red-star">*</span>
                                <span class="redtips"></span>
                            </div>
                            <input type="text" class="register-input" tabindex="4">
                        </div> -->
                        <div class="register-online">
                            <div class="register-text">
                                First Name
                                <span class="register-red-star">*</span>
                            </div>
                            <input type="text" name="pojo.firstName" class="register-input" tabindex="4">
                                   <%-- id="registerVO.name" onblur="checkName()"> --%>
                            <span class="redtips" id="spannameinfo"></span>
                        </div>
                        <div class="register-online">
                            <div class="register-text">
                                Last Name
                                <span class="register-red-star">*</span>
                            </div>
                            <input type="text" name="pojo.lastName" class="register-input" tabindex="5"
                                   id="registerVO.name" onblur="checkName()">
                            <span class="redtips" id="spannameinfo"></span>
                        </div>
                        <div class="register-online">
                            <div class="register-text">
                                Phone Number
                                <span class="register-red-star">*</span>
                            </div>
                            <input type="text" name="pojo.telephone" class="register-input" tabindex="6"
                                   id="registerVO.phone" onblur="checkPhone()">
                            <span class="redtips" id="spanphoneinfo"></span>
                        </div>
                        <!-- <div class="register-online">
                            <div class="register-text"></div>
                            <input type="checkbox" class="verify-check agree-input" tabindex="7">
                            Verify mobile number (
                            <b>You can use a verified number to log in, reset password, and change password.</b>
                            )
                        </div> -->
                        <!-- <div class="register-online">
                            <div class="register-text">
                                Code in the
                                <span class="register-red-star">*</span>
                            </div>
                            <div class="float-left">
                            </div>
                            <input type="text" class="register-input" tabindex="8">
                        </div> -->

                        <%-- <div class="register-online">
                            <div class="register-text">
                                SMS code
                                <span class="register-red-star">*</span>
                            </div>
                            <div>
                                <input type="text" name="registerVO.sms" class="phone-vercode-input" tabindex="6"
                                       id="registerVO.sms" onblur="checkSMS()">
                                <input id="sendButton" type="button" class="phone-button" value="Get code"
                                       tabindex="7">
                            </div>
                            <span class="redtips" id="spansmsinfo"></span>
                        </div> --%>
                    </div>
                    <div class="register-agree">
                        <div class="register-text" style="width: 0px">
                        </div>
                        <input type="checkbox" value="yes" onclick="toAgree(this)" class="agree-input"
                               id="agreement" tabindex="9">
                        &nbsp;
                        <span class="register-red-star">*</span>
                        I have read and agree
                    </div>
                    <div class="tip">
                        <span class="redtip1"></span>
                    </div>
                    <input type="submit" class="sub-bottom register-submit" name="regbtn" value="Register"
                           onclick="userRegister()" tabindex="10" id="regbtn" onclick="userRegister()" disabled>
                    <div class="bottom"></div>
                </div>
                </form>
                <img src="<c:url value='/template/img/register/boxBottom_Bg.gif'/>" id="content-bottom">
            </div>
        </div>
        <script src="<c:url value='/template/login/js/SEmail.js'/>"></script>
        <script>
        $(document).ready(function {

        });
        // $('#regbtn').click(function () {
        //     $('#registerForm').submit();
        // });
        // $('#registerForm').submit(function (e) {
        //     e.preventDefault();
        //     $.ajax({
        //         type: $(this).attr('method'),
        //         url: $(this).attr('action'),
        //         data: $(this).serialize(),
        //         dataType: 'html',
        //         success: function(res){
        //             if (res.trim() == "redirect_insert") {
        //                 $('#crudaction').val('redirect_insert');
        //                 $('#urlType').val('url_list');
        //                 $('#formUrl').submit();
        //             } else if (res.trim() == "redirect_update") {
        //                 $('#crudaction').val('redirect_update');
        //                 $('#urlType').val('url_list');
        //                 $('#formUrl').submit();
        //             } else if (res.trim() == "redirect_error") {
        //                 $('#crudaction').val('redirect_error');
        //                 $('#urlType').val('url_list');
        //                 $('#formUrl').submit();
        //             }
        //         },
        //         error: function (res) {
        //             console.log(res);
        //         }
        //     });
        // });
        </script>
    </body>
</html>
