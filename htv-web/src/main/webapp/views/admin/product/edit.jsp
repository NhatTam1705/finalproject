<%-- 
    Document   : edit
    Created on : Nov 27, 2021, 7:16:21 PM
    Author     : 19110
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp"%>
<c:url var="editProductUrl" value="/ajax-admin-product-edit.html">
    <c:param name="urlType" value="url_edit"/>
</c:url>
<c:choose>
    <c:when test="${not empty messageResponse}">
        ${messageResponse}
    </c:when>
    <c:otherwise>
        <div class="modal-dialog">
            <!-- Modal content-->
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal">&times;</button>
                    <c:if test="${not empty item.pojo.productId}">
                        <h4 class="modal-title">Edit Product</h4>
                    </c:if>
                    <c:if test="${empty item.pojo.productId}">
                        <h4 class="modal-title">Add Product</h4>
                    </c:if>
                </div>
                <form action="${editProductUrl}" method="POST" id="editProductForm">
                    <div class="modal-body">
                        <div class="row">
                            <div class="col-md-12">
                                <div class="md-form">
                                    <input type="text" placeholder="Product Name" class="form-control" value="${item.pojo.productName}" name="pojo.productName" id="productName" required/>
                                </div>
                            </div>
                            <br/>
                            <br/>
                            <div class="col-md-12">
                                <div class="md-form">
                                    <input type="text" placeholder="Description" class="form-control" value="${item.pojo.description}" name="pojo.description"/>
                                </div>
                            </div>
                            <br/>
                            <br/>
                            <div class="col-md-12">
                                <div class="md-form">
                                    <input type="number" placeholder="Quantity Left" class="form-control" value="${item.pojo.quantityLeft}" name="pojo.quantityLeft"/>
                                </div>
                            </div>
                            <br/>
                            <br/>
                            <div class="col-md-12">
                                <div class="md-form">
                                    <input type="number" placeholder="Price" class="form-control" value="${item.pojo.price}" name="pojo.price"/>
                                </div>
                            </div>
                            <br/>
                            <br/>
                            <div class="col-md-12">
                                <div class="md-form">
                                    <input type="text" placeholder="Style" class="form-control" value="${item.pojo.style}" name="pojo.style"/>
                                </div>
                            </div>
                            <br/>
                            <br/>
                            <div class="col-md-12">
                                <div class="md-form">
                                    <input type="number" placeholder="ROM" class="form-control" value="${item.pojo.rom}" name="pojo.rom"/>
                                </div>
                            </div>
                            <br/>
                            <br/>
                            <div class="col-md-12">
                                <div class="md-form">
                                    <input type="number" placeholder="RAM" class="form-control" value="${item.pojo.ram}" name="pojo.ram"/>
                                </div>
                            </div>
                            <br/>
                            <br/>
                            <div class="col-md-12">
                                <div class="md-form">
                                    <input type="file" placeholder="Image" class="form-control" value="${item.pojo.image}" name="pojo.image"/>
                                </div>
                            </div>
                            <br/>
                            <br/>
                            <div class="col-md-12">
                                <div class="md-form">
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
                            </div>
                            <br/>
                            <br/>
                            <div class="col-md-12">
                                <div class="md-form">
                                    <c:choose>
                                        <c:when test="${not empty item.pojo.productId}">
                                            <select id="manuFacter" name="manuFacterId">
                                                <option value="${item.pojo.manuFacterDTO.manufacterId}">${item.pojo.manuFacterDTO.manufacterName}</option>
                                                <c:forEach items="${item.manuFacters}" var="itemManuFacter">
                                                    <c:if test="${itemManuFacter.manufacterId ne item.pojo.manuFacterDTO.manufacterId}">
                                                        <option value="${itemManuFacter.manufacterId}">${itemManuFacter.manufacterName}</option>
                                                    </c:if>
                                                </c:forEach>
                                            </select>
                                        </c:when>
                                        <c:otherwise>
                                            <select id="manuFacter" name="manuFacterId">
                                                <option value="-1">Choose Manufacter</option>
                                                <c:forEach items="${item.manuFacters}" var="itemManuFacter">
                                                    <option value="${itemManuFacter.manufacterId}">${itemManuFacter.manufacterName}</option>
                                                </c:forEach>
                                            </select>
                                        </c:otherwise>
                                    </c:choose>
                                </div>
                            </div>
                        </div>
                    </div>
                    <c:if test="${not empty item.pojo.productId}">
                        <input type="hidden" name="pojo.productId" value="${item.pojo.productId}"/>
                    </c:if>
                    <input type="hidden" name="crudaction" id="crudactionEdit"/>
                </form>
                <div class="modal-footer">
                    <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                    <button type="button" id="btnSave" class="btn btn-primary">Save</button>
                </div>
            </div>
        </div>
    </c:otherwise>
</c:choose>
