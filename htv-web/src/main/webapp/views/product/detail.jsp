<%-- 
    Document   : detail
    Created on : Dec 6, 2021, 4:11:52 PM
    Author     : 19110
--%>

<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>TV-Company</title>
    </head>
    <body>
    <c:url var="urlCart" value="/product-phone-cart.html"/>
    <form action="${urlCart}" method="get" style="margin-top:108px; padding-bottom:60px">
        <div class="content">
            <div class="content-header">
                <ul class="bread-crumbs">
                    <li>
                        <a href="<c:url value='/home.html'/>">Home</a>
                        <meta>
                    </li>
                    <li>
                        &nbsp
                        <i class="fal fa-chevron-right"></i>
                        &nbsp
                        <a href="#">Product</a>
                    </li>
                </ul>
                <div class="name-phone">
                    ${item.pojo.productName}
                </div>
                <hr>
            </div>
            <div class="content-bottom">
                <div class="details">
                    <div class="details-box">
                        <div class="details-box-left">
                            <div class="details-box-img">
                                <img src="<c:url value='/fileupload/${item.pojo.image}'/>"
                                    alt="" class="procduct-img">
                            </div>
                            <div class="delivery">
                                <span class="delivery-text">
                                    Stocking
                                </span>
                            </div>
                            <div class="policy">
                                <div class="policy-box">
                                    <i class="fad fa-ballot"></i>
                                    <div class="policy-text">
                                        What's bad, 12 months at 2869 supermarkets nationwide (first month free)
                                    </div>
                                </div>
                                <div class="policy-box">
                                    <i class="fad fa-shield-check"></i>
                                    <div class="policy-text">
                                        Genuine phone warranty 1 year
                                    </div>
                                </div>
                                <div class="policy-box">
                                    <i class="fad fa-box"></i>
                                    <div class="policy-text">
                                        Package includes: Box, Manual, Sim tree, Type C Cable
                                    </div>
                                </div>
                            </div>
                            <div class="pay">
                                <input type="hidden" name="productId" value="${item.pojo.productId}">
                                <div class="pay-top">
                                    <button type="submit" class="pay-btn">ADD TO CARD</button>
                                </div>
                                <%-- <div class="pay-bottom">
                                    <button class="pay-left">installment purchase</button>
                                    <button class="pay-right">Installment via card</button>
                                </div> --%>
                            </div>
                        </div>
                        <div class="details-box-right">
                            <%-- <div class="ram">
                                <div class="ram-select">
                                    <span>256GB</span>
                                </div>
                                <div class="ram-select">
                                    <span>512GB</span>
                                </div>
                            </div>
                            <div class="color">
                                <div class="color-select">
                                    <span>Black</span>
                                </div>
                                <div class="color-select">
                                    <span>White</span>
                                </div>
                                <div class="color-select">
                                    <span>Blue</span>
                                </div>
                            </div> --%>
                            <div class="price">
                                <div class="price-location">
                                    Price at Viet Nam
                                </div>
                                <div class="price-text">
                                    <span class="price-text-cost"><fmt:formatNumber type="number" value="${item.pojo.price}"/>₫</span>
                                    <span class="price-text-discount">0% installment</span>
                                </div>
                                <br/>
                                <input name='quantity' min="1" value="1" type="number" style="width: 50px; boder: 1px solid #ccc; background: transparent">
                                <br/>
                                <br/>
                                <div class="price-box">
                                    <div class="price-box-top">
                                        <div class="price-promotion">
                                            <span class="price-promotion-text">
                                                Promotion worth 1,000,000 VND
                                            </span>
                                            <span class="price-promotion-text">
                                                Prices and promotions are expected to be applied until 23:00 December 31
                                            </span>
                                        </div>
                                    </div>
                                    <div class="price-box-bottom">
                                        <div class="price-info">
                                            <div class="price-info-number">1</div>
                                            <div class="price-info-text">
                                                Discount <fmt:formatNumber type="number" value="${item.pojo.price * item.pojo.discountDTO.discountPercent / 100}"/> VND (Not applicable with old and new collection)
                                            </div>
                                        </div>
                                        <div class="price-info">
                                            <div class="price-info-number">2</div>
                                            <div class="price-info-text">
                                                Extra 5% off when buying the same product with any higher price
                                            </div>
                                        </div>
                                        <div class="price-info">
                                            <div class="price-info-number">3</div>
                                            <div class="price-info-text">
                                                Premium Priority Packages and Business Class Lounge
                                            </div>
                                        </div>
                                        <div class="price-info">
                                            <div class="price-info-number">4</div>
                                            <div class="price-info-text">
                                                Discount up to 4,000,000 VND when participating in new and old
                                                collection (Depending on old model, not applicable with 1 million
                                                discount)
                                            </div>
                                        </div>
                                        <div class="price-info">
                                            <div class="price-info-number">5</div>
                                            <div class="price-info-text">
                                                Installment 0% credit card
                                            </div>
                                        </div>
                                        <div class="price-info">
                                            <div class="price-info-number">6</div>
                                            <div class="price-info-text">
                                                Enter code TGDD12, get 5% off up to 500,000 VND for bill from 500,000
                                                VND when paying via Moca Wallet on Grab app
                                            </div>
                                        </div>
                                        <div class="price-info">
                                            <div class="price-info-number">7</div>
                                            <div class="price-info-text">
                                                Enter code DMX100, discount 3%, up to 100,000 VND when paying by
                                                scanning QRcode via the bank's App
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </form>
    </body>
</html>
