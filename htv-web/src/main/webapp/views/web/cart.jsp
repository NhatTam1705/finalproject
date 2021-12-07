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
        <link rel="stylesheet" href="<c:url value='/template/product/css/shopping.css'/>">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>TV-Company</title>
    </head>
    <body>
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
                                            <span class="card-item-price-text">${item.product.price}₫</span>
                                            <strike class="card-item-price-text">${item.product.price - item.product.price * item.product.discountDTO.discountPercent / 100}</strike>
                                        </div>
                                        <div class="card-item-chose-number">
                                            <div class="card-minus">
                                                <i></i>
                                            </div>
                                            <input class="card-number" min="0" value="0" type="number">
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
                                <span class="pay-top-price">222000</span>
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
        <script src="../../scripts/product/SCommon.js"></script>
        <script src="../../scripts/shopping/script.js"></script>
    </body>
</html>
