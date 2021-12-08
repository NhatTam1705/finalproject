<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/common/taglib.jsp"%>
<c:url var="requestUrl" value="/admin-order-list.html"/>
<c:url value="/admin-order-edit.html" var="OrderEditUrl">
    <c:param name="urlType" value="url_edit"/>
</c:url>
<c:url var="formUrl" value="/admin-order-list.html"/>
<html>
<head>
    <title>Order Management</title>
</head>
<body>
<div class="main-content">
    <div class="main-content-inner">
        <div class="page-content">
            <div class="row">
                <div class="col-xs-12">
                    <%--<a href="${listenGuidelineEditUrl}" type="button">Thêm bài hd</a>--%>
                    <c:if test="${not empty messageResponse}">
                        <div class="alert alert-block alert-${alert}">
                            <button type="button" class="close" data-dismiss="alert">
                                <i class="ace-icon fa fa-times"></i>
                            </button>
                                ${messageResponse}
                        </div>
                    </c:if>
                    <form action="${formUrl}" method="get" id="formUrl">
                        <div class="row">
                            <div class="search">
                                <div class="widget-box table-filter">
                                    <div class="widget-header">
                                        <h4 class="widget-title">Search</h4>
                                        <div class="widget-toolbar">
                                            <a href="#" data-action="collapse">
                                                <i class="ace-icon fa fa-chevron-up"></i>
                                            </a>
                                        </div>
                                    </div>
                                    <div class="widget-body">
                                        <div class="widget-main">
                                            <div class="form-horizontal">
                                                <div class="form-group">
                                                    <label class="col-sm-2 control-label">Create Date</label>
                                                    <div class="col-sm-8">
                                                        <div class="fg-line">
                                                            <input type="text" value="${items.pojo.createdDate}" class="form-control input-sm" name="pojo.createdDate"/>
                                                        </div>
                                                    </div>
                                                </div>
                                                <div class="form-group">
                                                    <label class="col-sm-2 control-label"></label>
                                                    <div class="col-sm-8 search-btn">
                                                        <button id="btnSearch" class="btn btn-sm btn-success">
                                                            Search Now
                                                            <i class="ace-icon fa fa-arrow-right icon-on-right bigger-110"></i>
                                                        </button>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                <div class="table-btn-controls">
                                    <div class="pull-right tableTools-container">
                                        <div class="dt-buttons btn-overlap btn-group border-button">
                                            <c:url var="addUrl" value="/admin-order-edit.html">
                                                <c:param name="urlType" value="url_edit"/>
                                            </c:url>
                                            <%-- <a flag="info" class="dt-button buttons-colvis btn btn-white btn-add btn-bold" href="${addUrl}"
                                                data-toggle="tooltip" title="Add Product">
                                                    <span>
                                                        <i class="fas fa-plus"></i>
                                                    </span>
                                            </a> --%>
                                            <button type="button" class="dt-button buttons-html5 btn btn-white btn-del btn-bold" id="deleteAll" disabled onclick="warningBeforeDelete()"
                                                    data-toggle="tooltip" title="Delete All">
                                                     <span>
                                                        <i class="fas fa-trash-alt"></i>
                                                    </span>
                                            </button>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="table-responsive info">
                        <display:table id="tableList" name="items.listResult" partialList="true" size="${items.totalItems}"
                                           pagesize="${items.maxPageItems}" sort="external" requestURI="${requestUrl}"
                                           class="table table-fcv-ace table-striped table-bordered table-hover dataTable no-footer"
                                           style="margin: 3em 0 1.5em;">
                                <display:column title="<fieldset class='form-group'>
                                                <input type='checkbox' id='checkAll' class='check-box-element'>
                                                </fieldset>" class="center select-cell" headerClass="center select-cell">
                                    <fieldset>
                                        <input type="checkbox" name="checkList" id="checkbox_${tableList.orderItemId}" value="${tableList.orderItemId}" class="check-box-element"/>
                                    </fieldset>
                                </display:column>
                                <display:column property="orderDetails.users.lastName" titleKey="Last Name" sortable="true" sortName="orderDetails.users.lastName"/>
                                <display:column property="product.productName" titleKey="Product Name" sortable="true" sortName="product.productName"/>
                                <display:column property="quantity" titleKey="Quantity" sortable="true" sortName="quantity"/>
                                <display:column property="createdDate" titleKey="Created Date" sortable="true" sortName="createdDate"/>
                                <%-- <display:column headerClass="col-actions" titleKey="Operation">
                                    <c:url var="editUrl" value="/admin-product-edit.html">
                                        <c:param name="urlType" value="url_edit"/>
                                        <c:param name="pojo.productId" value="${tableList.productId}"/>
                                    </c:url>
                                    <a class="btn btn-sm btn-primary btn-edit" href="${editUrl}" data-toggle="tooltip" title="Edit Product"><i class="fa fa-pencil-square-o" aria-hidden="true"></i></a>
                                </display:column> --%>
                                </display:table>
                        </div>
                        <input type="hidden" name="urlType" id="urlType" value="url_list"/>
                        <input type="hidden" name="crudaction" id="crudaction"/>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>
<script>
    $('.fa-chevron-up').click(function(){
                    $('.widget-body').slideToggle()
                    $('.fa-chevron-up').toggleClass('fa-chevron-up__rotate')
                })
    $(document).ready(function () {
         $('#btnSearch').click(function () {
             $('#formUrl').submit();
         });
    });
    function warningBeforeDelete() {
        showAlertBeforeDelete(function () {
            $('#crudaction').val('redirect_delete');
            $('#formUrl').submit();
        });
    }
</script>
</body>
</html>
