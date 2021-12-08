<%-- 
    Document   : cart
    Created on : Dec 7, 2021, 9:55:41 AM
    Author     : 19110
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" rel="stylesheet"
              id="bootstrap-css" />
        <link rel="stylesheet" href="<c:url value='/template/web/css/home.css'/>" type="text/css" />
        <link rel="stylesheet" href="<c:url value='/template/product/css/shopping.css'/>">
        <link rel="stylesheet" href="<c:url value='/template/font/themify-icons/themify-icons.css'/>" />
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css" />
        <link rel="stylesheet" href="https://kit-pro.fontawesome.com/releases/v5.12.1/css/pro.min.css" />
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.css" />
        <script src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
        <script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
        <script type="module" src="https://unpkg.com/ionicons@5.5.2/dist/ionicons/ionicons.esm.js"></script>
        <link rel="stylesheet" href="myProjects/webProject/icofont/css/icofont.min.css">
        <script src="https://unpkg.com/ionicons@5.5.2/dist/ionicons/ionicons.js"></script>
        <title>TV-Company</title>
    </head>
    <body>
        <header>
            <div id="header" class="js-header">
                <div id="top-nav">
                    <div class="top-nav-height">
                        <div class="container-header">
                            <div class="pull-right">
                                <c:if test="${not empty login_name}">
                                    <span class="pull-right-icon-login">Welcome ${login_name.lastName}</span>
                                    <c:url var="logoutUrl" value="/logout.html">
                                        <c:param name="action" value="logout"/>
                                    </c:url>
                                    <a href="${logoutUrl}" class="pull-right-login">
                                        <span class="pull-right-text-login">Log out</span>
                                    </a>
                                </c:if>
                                <c:if test="${empty login_name}">
                                    <c:url var="loginUrl" value="/logincommon-home.html">
                                        <c:param name="action" value="login"/>
                                    </c:url>
                                    <a href="${loginUrl}" class="pull-right-login">
                                        <span class="pull-right-icon-login ti-user"></span>
                                        <span class="pull-right-text-login">Log in</span>
                                    </a>
                                </c:if>
                            </div>
                        </div>
                    </div>
                </div>
                <div id="navbar">
                    <div class="container-header nav-container">
                        <div class="navbar-header">
                            <a href="<c:url value='/home.html'/>" class="logo navbar-brand">
                                <img src="<c:url value='/template/img/logo.png'/>" alt="" />
                            </a>
                        </div>
                        <nav id="htv-navbar" class="js-htv-navbar">
                            <ul id="nav">
                                <li class="nav-item nav-item__hide">
                                    <a href="<c:url value='/home.html'/>">
                                        <span class="text">Home</span>
                                    </a>
                                </li>
                                <li class="nav-item nav-item__hide">
                                    <a href="<c:url value='/home-phone.html'/>">
                                        <span class="text">Product</span>
                                    </a>
                                </li>
                                <li class="nav-item nav-item__hide">
                                    <a href="<c:url value='/home-about.html'/>">
                                        <span class="text">About</span>
                                    </a>
                                </li>
                                <li class="nav-item nav-item__hide">
                                    <a href="<c:url value='/home-support.html'/>">
                                        <span class="text">Support</span>
                                    </a>
                                </li>
                            </ul>
                        </nav>
                        <div class="nav-right">
                            <span class="icon-search ti-search"></span>
                            <div class="icon">
                                <span class="fal fa-shopping-bag"></span>
                                <span class="text icon-hide">Buy</span>
                                <span class="icon-font icon-angle ti-angle-down icon-hide"
                                      style="margin-top:2px; font-size: 13px"></span>
                                <span class="icon-font-white change-icon-font ti-angle-down icon-hide"
                                      style="margin-top: 2px; margin-left: 2px"></span>
                                <input type="text" class="input-search" placeholder="Search htv.com">
                                <span class="btn-menu icon-menu ti-menu"></span>
                                <a href="<c:url value='/shopping-cart.html'/>">
                                    <div class="shopping">
                                        <!-- <span class="shopping-icon fal fal-shopping-cart"></span> -->
                                        <span class="shopping-icon fal fa-shopping-cart"></span>
                                        <span class="shopping-text">HV cloud</span>
                                    </div>
                                </a>
                            </div>
                        </div>
                        <c:url var="urlList" value="/home-phone.html"/>
                        <form action="${urlList}" method="get" >
                            <div class="nav-search">
                                <div class="nav-search-box">
                                    <input type="text" name="pojo.productName" value="${items.pojo.productName}" placeholder="Search tv.com" class="nav-search-box-header">
                                    <a href="#" class="nav-search-box-btn">
                                        <%-- <button> --%>
                                        <span class="nav-search-box-icon-search ti-search"></span>
                                        <%-- </button> --%>
                                    </a>
                                </div>
                                <a href="#" class="nav-search-btn-close">
                                    <span class="nav-search-icon-close ti-close" onclick="hideSearchBox()"></span>
                                </a>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </header>
        <div class="main">
            <c:if test="${empty order.orderItemsDTOList}">
                <div class="notification">
                    <div class="notification-icon">
                        <i class="fad fa-shopping-cart"></i>
                    </div>
                    <div class="notification-text">
                        <span>There are no products in the cart</span>
                    </div>
                    <a href="<c:url value='/home.html'/>" class="notification-btn" value="back-to-home">
                        <span class="notification-btn-text">BACK TO HOME</span>
                    </a>
                    <div class="notification-info">
                        <span> When you need help please call&nbsp</span>
                        <a href="tel:0782883871">0782888371</a>
                        <span>or&nbsp</span>
                        <a href="tel:0334193816">0334193816</a>
                        <span>&nbsp(7h30 - 22h)</span>
                    </div>
                </div>
            </c:if>
            <c:if test="${not empty order.orderItemsDTOList}">
                <div class="content" >
                    <div class="content-header">
                        <a href="<c:url value='/home-phone.html'/>" class="content-header__back">
                            <i class="content-header-icon-left fad fa-chevron-left"></i>
                            <span class="content-header-text__blue">&nbspBuy more products</span>
                        </a>
                        <span class="content-header-text__black">Your shopping cart</span>
                    </div>
                    <div class="content-bottom">
                        <div class="cards">
                            <ul class="card">
                                <c:forEach var="item" items="${order.orderItemsDTOList}">
                                    <li class="card-item">
                                    <div class="card-item-left">
                                        <img src="/htv-web/fileupload/${item.product.image}"
                                            alt="" class="card-item-img">
                                        <button class="btn-close" value="Delete">
                                            <i class="fad fa-times-circle"></i>
                                            Delete
                                        </button>
                                    </div>
                                    <div class="card-item-center">
                                        <div class="card-item-text">${item.product.productName}</div>
                                    </div>
                                        <div class="card-item-right">
                                            <div class="card-item-price">
                                                <span class="card-item-price-text">${item.product.price - item.product.price * item.product.discountDTO.discountPercent / 100}₫</span>
                                                <strike class="card-item-price-text">${item.product.price}</strike>
                                                <div class="card-item-chose-number">
                                                    <div class="card-minus">
                                                        <i></i>
                                                </div>
                                                <input class="card-number" value="${item.quantity}" type="number">
                                                <div class="card-plus">
                                                    <i></i>
                                                    <i></i>
                                                </div>
                                            </div>
                                        </div>
                                    </li>
                                </c:forEach>
                            </ul>
                        </div>
                        <div class="pay">
                            <div class="pay-top">
                                <span class="pay-top-text">Total money:</span>
                                <span class="pay-top-price">${order.total}</span>
                            </div>
                            <div class="pay-bottom">
                                <button class="pay-bottom-btn" value="Pay">Pay</button>
                                <span class="pay-bottom-text">Choose a payment method when placing an order</span>
                            </div>
                        </div>
                    </div>
                </div>
            </c:if>
            <span class="primary" style="display: none">By placing an order you agree to the terms of HV phone</span>
        </div>
        <script src="<c:url value='/template/web/js/script.js'/>"></script>
        <script src="<c:url value='/template/product/js/script.js'/>"></script>
    </body>
</html>
