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
                    <form action="${formUrl}" method="post" enctype="multipart/form-data" id="formEdit">
                        <div class="form-group">
                            <label class="col-sm-3 control-label no-padding-right">Product Name</label>
                            <div class="col-sm-9">
                                <input type="text" name="pojo.productName" id="productName" value="${item.pojo.productName}"/>
                            </div>
                        </div>
                        <br/>
                        <br/>
                        <div class="form-group">
                            <label class="col-sm-3 control-label no-padding-right">Description</label>
                            <div class="col-sm-9">
                                <input type="text" name="pojo.description" id="description" value="${item.pojo.description}"/>
                            </div>
                        </div>
                        <br/>
                        <br/>
                        <div class="form-group">
                            <label class="col-sm-3 control-label no-padding-right">Quantity Left</label>
                            <div class="col-sm-9">
                                <input type="text" name="pojo.quantityLeft" id="quantityLeft" value="${item.pojo.quantityLeft}"/>
                            </div>
                        </div>
                        <br/>
                        <br/>
                        <div class="form-group">
                            <label class="col-sm-3 control-label no-padding-right">Price</label>
                            <div class="col-sm-9">
                                <input type="text" name="pojo.price" id="price" value="${item.pojo.price}"/>
                            </div>
                        </div>
                        <br/>
                        <br/>
                        <div class="form-group">
                            <label class="col-sm-3 control-label no-padding-right">Style</label>
                            <div class="col-sm-9">
                                <input type="text" name="pojo.style" id="style" value="${item.pojo.style}"/>
                            </div>
                        </div>
                        <br/>
                        <br/>
                        <div class="form-group">
                            <label class="col-sm-3 control-label no-padding-right">ROM</label>
                            <div class="col-sm-9">
                                <input type="text" name="pojo.rom" id="rom" value="${item.pojo.rom}"/>
                            </div>
                        </div>
                        <br/>
                        <br/>
                        <div class="form-group">
                            <label class="col-sm-3 control-label no-padding-right">RAM</label>
                            <div class="col-sm-9">
                                <input type="text" name="pojo.ram" id="ram" value="${item.pojo.ram}"/>
                            </div>
                        </div>
                        <br/>
                        <br/>
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
                            <label class="col-sm-3 control-label no-padding-right">Image</label>
                            <div class="col-sm-9">
                                <input type="file" name="file" id="uploadImage"/>
                            </div>
                        </div>
                        <br/>
                        <div class="form-group">
                            <label class="col-sm-3 control-label no-padding-right">View Image</label>
                            <div class="col-sm-9">
                                <c:if test="${not empty item.pojo.image}">
                                    <c:set var="image" value="/htv-web/fileupload/${item.pojo.image}"/>
                                </c:if>
                                <img src="${image}" id="viewImage" width="150px" height="150ox">
                            </div>
                        </div>
                        <br/>
                        <br/>
                        <div class="form-group">
                            <div class="col-sm-12">
                                <input type="submit" class="btn btn-white btn-warning btn-bold" value="Submit"/>
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
                $('#' +imageId).attr('src', reader.result);
            }
            reader.readAsDataURL(input.files[0]);
        }
    }
</script>
</body>
</html>
