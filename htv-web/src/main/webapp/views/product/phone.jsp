<%-- 
    Document   : home
    Created on : Nov 11, 2021, 1:58:03 PM
    Author     : 19110
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<!DOCTYPE html>
<c:url var="urlList" value="/home-phone.html"/>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>TV-Company</title>
    </head>
    <body>
        <section class="banner margin">
            <img src="<c:url value='template/img/bannner/iphone-13.jpg'/>" class="banner-img" alt="">
        </section>
        <form action="${urlList}" method="get" id="formUrl">
        <section class="filter">
            <div class="filter-box">
                <div class="filter-beetle margin">
                    <div class="filter-title filter-all-items">
                        <div class="dropdown__select" aria-valuetext="1">
                            <i class="fa fa-filter" aria-hidden="true"></i>
                            <span class="filter-text">Filter</span>
                        </div>
                    </div>
                    <div class="filter-title filter-price">
                        <div class="dropdown__select dropdown__price">
                            <span class="filter-text">Price</span>
                            <ion-icon name="caret-down-outline"></ion-icon>
                        </div>
                        <ul class="dropdown__list dropdown-list__price">
                            <a href="" class="c-btnbox">
                                <li class="dropdown__item">
                                    <span class="dropdown__text">Less than 2 million</span>
                                </li>
                            </a>
                            <a href="" class="c-btnbox">
                                <li class="dropdown__item">
                                    <span class="dropdown__text">From 2 - 4 million</span>
                                </li>
                            </a>
                            <a href="" class="c-btnbox">
                                <li class="dropdown__item">
                                    <span class="dropdown__text">From 4 - 7 million</span>
                                </li>
                            </a>
                            <a href="" class="c-btnbox">
                                <li class="dropdown__item">
                                    <span class="dropdown__text">From 7 - 13 million</span>
                                </li>
                            </a>
                            <a href="" class="c-btnbox">
                                <li class="dropdown__item">
                                    <span class="dropdown__text">From 13 - 20 million</span>
                                </li>
                            </a>
                            <a href="" class="c-btnbox">
                                <li class="dropdown__item">
                                    <span class="dropdown__text">Over 20 million</span>
                                </li>
                            </a>
                            <div class="button-find__item">
                                <input type="button" class="button__cancel button__cancel-price" value="Cancel">
                                <a href="" class="c-btnbox">
                                    <input type="button" class="button__submit" value="Submit">
                                </a>
                            </div>
                        </ul>
                    </div>
                    <div class="filter-title filter-type">
                        <div class="dropdown__select dropdown__type">
                            <span class="filter-text">Type of phone</span>
                            <ion-icon name="caret-down-outline"></ion-icon>
                        </div>
                        <ul class="dropdown__list dropdown-list__type">
                            <a href="" class="c-btnbox">
                                <li class="dropdown__item">
                                    <span class="dropdown__text">Android</span>
                                </li>
                            </a>
                            <a href="" class="c-btnbox">
                                <li class="dropdown__item">
                                    <span class="dropdown__text">iOS</span>
                                </li>
                            </a>
                            <div class="button-find__item">
                                <input type="button" class="button__cancel" value="Cancel">
                                <a href="" class="c-btnbox">
                                    <input type="button" class="button__submit" value="Submit">
                                </a>
                            </div>
                        </ul>
                    </div>
                    <div class="filter-title filter-ram">
                        <div class="dropdown__select dropdown__ram">
                            <span class="filter-text">RAM</span>
                            <ion-icon name="caret-down-outline"></ion-icon>
                        </div>
                        <ul class="dropdown__list dropdown-list__ram">
                            <a href="" class="c-btnbox">
                                <li class="dropdown__item">
                                    <span class="dropdown__text">1GB</span></li>
                            </a>
                            <a href="" class="c-btnbox">
                                <li class="dropdown__item">
                                    <span class="dropdown__text">2GB</span></li>
                            </a>
                            <a href="" class="c-btnbox">
                                <li class="dropdown__item">
                                    <span class="dropdown__text">3GB</span></li>
                            </a>
                            <a href="" class="c-btnbox">
                                <li class="dropdown__item">
                                    <span class="dropdown__text">4GB</span></li>
                            </a>
                            <a href="" class="c-btnbox">
                                <li class="dropdown__item">
                                    <span class="dropdown__text">6GB</span></li>
                            </a>
                            <a href="" class="c-btnbox">
                                <li class="dropdown__item">
                                    <span class="dropdown__text">8GB</span></li>
                            </a>
                            <a href="" class="c-btnbox">
                                <li class="dropdown__item">
                                    <span class="dropdown__text">12GB</span></li>
                            </a>
                            <div class="button-find__item">
                                <input type="button" class="button__cancel" value="Cancel">
                                <a href="" class="c-btnbox">
                                    <input type="button" class="button__submit" value="Submit">
                                </a>
                            </div>
                        </ul>
                    </div>
                    <div class="filter-title filter-rom">
                        <div class="dropdown__select dropdown__rom">
                            <span class="filter-text">ROM</span>
                            <ion-icon name="caret-down-outline"></ion-icon>
                        </div>
                        <ul class="dropdown__list dropdown-list__rom">
                            <a href="" class="c-btnbox">
                                <li class="dropdown__item">
                                    <span class="dropdown__text">32GB</span></li>
                            </a>
                            <a href="" class="c-btnbox">
                                <li class="dropdown__item">
                                    <span class="dropdown__text">64GB</span></li>
                            </a>
                            <a href="" class="c-btnbox">
                                <li class="dropdown__item">
                                    <span class="dropdown__text">128GB</span></li>
                            </a>
                            <a href="" class="c-btnbox">
                                <li class="dropdown__item">
                                    <span class="dropdown__text">256GB</span></li>
                            </a>
                            <a href="" class="c-btnbox">
                                <li class="dropdown__item">
                                    <span class="dropdown__text">512GB</span></li>
                            </a>
                            <div class="button-find__item">
                                <input type="button" class="button__cancel" value="Cancel">
                                <a href="" class="c-btnbox">
                                    <input type="button" class="button__submit" value="Submit">
                                </a>
                            </div>
                        </ul>
                    </div>
                </div>
            </div>
        </section>
        <section class="brands margin">
            <div class="brand">
                <div class="brand-lst">
                    <a href="" class="brand-lst-item rd-52">
                        <img src="<c:url value='template/img/brand/iphone.png'/>" alt="" class="brand-lst-img">
                    </a>
                    <a href="" class="brand-lst-item rd-52">
                        <img src="<c:url value='template/img/brand/oppo.jpg'/>" alt="" class="brand-lst-img">
                    </a>
                    <a href="" class="brand-lst-item rd-52">
                        <img src="<c:url value='template/img/brand/realme.png'/>" alt="" class="brand-lst-img">
                    </a>
                    <a href="" class="brand-lst-item rd-52">
                        <img src="<c:url value='template/img/brand/samsung.png'/>" alt="" class="brand-lst-img">
                    </a>
                    <a href="" class="brand-lst-item rd-52">
                        <img src="<c:url value='template/img/brand/vivo.jpg'/>" alt="" class="brand-lst-img">
                    </a>
                    <a href="" class="brand-lst-item rd-52">
                        <img src="<c:url value='template/img/brand/xiaomi.png'/>" alt="" class="brand-lst-img">
                    </a>
                </div>
            </div>
        </section>
        <section id="category-page" data-name="phone">
            <div class="container-productbox margin">
                <div class="cards">
                    <c:forEach var="item" items="${items.listResult}">
                        <div class="card">
                            <c:url value="/product-phone-detail.html" var="detailUrl">
                                <c:param name="productId" value="${item.productId}"/>
                            </c:url>
                            <a href="${detailUrl}" class="c-btnbox">
                                <div class="card-sale">
                                    <p class=text-sale>${item.discountDTO.discountName}</p>
                                </div>
                                <div class="card-box">
                                    <img src="<c:url value='/fileupload/${item.image}'/>"
                                        alt="" class="card-image" />
                                </div>
                                <div class="card-content">
                                    <h3 class="card-content-name">${item.productName}</h3>
                                    <div class="card-content-price">
                                        ${item.price}₫
                                    </div>
                                    <div class="card-content-discount">
                                        Sale ${item.discountDTO.discountPercent * item.price / 100}₫
                                    </div>
                                </div>
                            </a>
                        </div>
                    </c:forEach>
                </div>
        </section>
        <ul id="pagination-demo" class="pagination-sm"></ul>
        <input type="hidden" id="page" name="page"/>
        </form>
    </body>
</html>