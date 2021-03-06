<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/common/taglib.jsp"%>
<c:url var="formUrl" value="/admin-product-edit.html"/>
<html>
    <head>
        <title>Edit Product</title>
        <style>
            .error{
                color: red;
            }
        </style>
    </head>
    <body>
        <div class="main-content">
            <div class="main-content-inner">
                <div class="page-content">
                    <div class="row">
                        <div class="col-xs-12">
                            <c:if test="${not empty messageResponse}">
                                <div class="alert alert-block alert-${alert}">
                                    <button type="button" class="close" data-dismiss="alert">
                                        <i class="ace-icon fa fa-times"></i>
                                    </button>
                                    ${messageResponse}
                                </div>
                            </c:if>
                            <div class="form-center">
                                <form action="${formUrl}" method="post" enctype="multipart/form-data" id="formEdit">
                                    <div class="form-edit__left">
                                        <div class="form-group">
                                            <label class="width-200 control-label no-padding-right padding-right">Product Name</label>
                                            <div class="">
                                                <input type="text" name="pojo.productName" id="productName" value="${item.pojo.productName}"/>
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label class="width-200 control-label no-padding-right padding-right">Description</label>
                                            <div class="">
                                                <input type="text" name="pojo.description" id="description" value="${item.pojo.description}"/>
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label class="width-200 control-label no-padding-right padding-right">Quantity Left</label>
                                            <div class="">
                                                <input type="text" name="pojo.quantityLeft" id="quantityLeft" value="${item.pojo.quantityLeft}"/>
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label class="width-200 control-label no-padding-right padding-right">Price</label>
                                            <div class="">
                                                <input type="text" name="pojo.price" id="price" value="${item.pojo.price}"/>
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label class="width-200 control-label no-padding-right padding-right">Style</label>
                                            <div class="">
                                                <input type="text" name="pojo.style" id="style" value="${item.pojo.style}"/>
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label class="width-200 control-label no-padding-right padding-right">ROM</label>
                                            <div class="">
                                                <input type="text" name="pojo.rom" id="rom" value="${item.pojo.rom}"/>
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label class="width-200 control-label no-padding-right padding-right">RAM</label>
                                            <div class="">
                                                <input type="text" name="pojo.ram" id="ram" value="${item.pojo.ram}"/>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="form-edit__right">
                                        <div class="form-group">
                                            <c:choose>
                                                <c:when test="${not empty item.pojo.productId}">
                                                    <select id="discount" name="discountId">
                                                        <option value="${item.pojo.discountDTO.discountId}">${item.pojo.discountDTO.discountName}</option>
                                                        <c:forEach items="${item.discounts}" var="itemDiscount">
                                                            <c:if test="${itemDiscount.discountId ne item.pojo.discountDTO.discountId}">
                                                                <option value="${itemDiscount.discountId}">${itemDiscount.discountName}</option>
                                                            </c:if>
                                                        </c:forEach>
                                                    </select>
                                                </c:when>
                                                <c:otherwise>
                                                    <select id="discount" name="discountId">
                                                        <option value="-1">Choose Discount</option>
                                                        <c:forEach items="${item.discounts}" var="itemDiscount">
                                                            <option value="${itemDiscount.discountId}">${itemDiscount.discountName}</option>
                                                        </c:forEach>
                                                    </select>
                                                </c:otherwise>
                                            </c:choose>
                                        </div>
                                        <br/>
                                        <br/>
                                        <div class="form-group">
                                            <c:choose>
                                                <c:when test="${not empty item.pojo.productId}">
                                                    <select id="manufacter" name="manufacterId">
                                                        <option value="${item.pojo.manuFacterDTO.manufacterId}">${item.pojo.manuFacterDTO.manufacterName}</option>
                                                        <c:forEach items="${item.manuFacters}" var="itemManufacter">
                                                            <c:if test="${itemManufacter.manufacterId ne item.pojo.manuFacterDTO.manufacterId}">
                                                                <option value="${itemManufacter.manufacterId}">${itemManufacter.manufacterName}</option>
                                                            </c:if>
                                                        </c:forEach>
                                                    </select>
                                                </c:when>
                                                <c:otherwise>
                                                    <select id="manufacter" name="manufacterId">
                                                        <option value="-1">Choose Manufacter</option>
                                                        <c:forEach items="${item.manuFacters}" var="itemManufacter">
                                                            <option value="${itemManufacter.manufacterId}">${itemManufacter.manufacterName}</option>
                                                        </c:forEach>
                                                    </select>
                                                </c:otherwise>
                                            </c:choose>
                                        </div>
                                        <br/>
                                        <br/>
                                        <div class="form-group">
                                            <label class="width-200 control-label no-padding-right">View Image</label>
                                            <div class="">
                                                <c:if test="${not empty item.pojo.image}">
                                                    <c:set var="image" value="/fileupload/${item.pojo.image}"/>
                                                </c:if>
                                                <img src="${image}" id="viewImage" width="150px" height="150ox">
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label class="width-200 control-label no-padding-right">Image</label>
                                            <div class="">
                                                <input type="file" name="file" id="uploadImage"/>
                                            </div>
                                        </div>
                                        <br/>
                                        <br/>
                                    </div>
                                    <div class="form-group btn-submit">
                                        <div class="col-sm-12 box-btn">
                                            <input class="add-product" type="submit" class="btn btn-white btn-warning btn-bold" value="ADD PRODUCT NOW"/>
                                        </div>
                                    </div>
                                    <c:if test="${not empty item.pojo.productId}">
                                        <input type="hidden" name="pojo.productId" value="${item.pojo.productId}"/>
                                    </c:if>
                                </form>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <script>
            var productId = '';
            <c:if test="${not empty item.pojo.productId}">
            productId = ${item.pojo.productId};
            </c:if>
            $(document).ready(function () {
                $('#uploadImage').change(function () {
                    readURL(this, "viewImage");
                });
            });
            function readURL(input, imageId) {
                if (input.files && input.files[0]) {
                    var reader = new FileReader();
                    reader.onload = function (e) {
                        $('#' + imageId).attr('src', reader.result);
                    }
                    reader.readAsDataURL(input.files[0]);
                }
            }
        </script>
    </body>
</html>
