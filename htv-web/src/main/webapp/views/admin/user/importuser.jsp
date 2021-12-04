<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/common/taglib.jsp"%>
<c:url var="validateExcel" value="/admin-user-import-validate.html"/>
<c:url var="importExcel" value="/admin-user-import.html"/>
<html>
    <head>
        <title>Import User</title>
    </head>
    <body>
        <div class="page-content">
            <div class="row">
                <div class="col-xs-12">
                    <c:if test="${messageResponse!=null}">
                        <div class="alert alert-block alert-${alert}">
                            <button type="button" class="close" data-dismiss="alert">
                                <i class="ace-icon fa fa-times"></i>
                            </button>
                            ${messageResponse}
                        </div>
                    </c:if>
                    <form action="${validateExcel}" method="post" enctype="multipart/form-data" id="formImport">
                        <div class="row">
                            <div class="col-xs-12">
                                <div class="col-sm-12">
                                    <input type="file" name="file"/>
                                    <br/>
                                    <button type="button" class="dt-button buttons-html5 btn btn-white btn-primary btn-bold" id="validateData">
                                        Check File Import
                                    </button>
                                </div>
                            </div>
                        </div>
                        <c:if test="${not empty items.userImportDTOS}">
                            <div class="row">
                                <div class="col-xs-12">
                                    <div class="table-responsive">
                                            <display:table name="items.userImportDTOS" cellspacing="0" cellpadding="0" requestURI="${requestUrl}"
                                                           partialList="true" sort="external" size="${items.totalItems}" id="tableList" excludedParams="checkList"
                                                           pagesize="${items.maxPageItems}" export="false"
                                                           class="table table-fcv-ace table-striped table-bordered table-hover dataTable no-footer"
                                                           style="margin: 3em 0 1.5em;">
                                                <display:column headerClass="text-left" property="password" titleKey="Password"/>
                                                <display:column headerClass="text-left" property="firstName" titleKey="First Name"/>
                                                <display:column headerClass="text-left" property="lastName" titleKey="Last Name"/>
                                                <display:column headerClass="text-left" property="address" titleKey="Address"/>
                                                <display:column headerClass="text-left" property="phone" titleKey="Phone"/>
                                                <display:column headerClass="text-left" property="email" titleKey="Email"/>
                                                <display:column headerClass="text-left" property="roleName" titleKey="Role Name"/>
                                                <display:column headerClass="text-left" property="error" titleKey="Error"/>
                                            </display:table>
                                    </div>
                                </div>
                            </div>
                            <button type="button" class="dt-button buttons-html5 btn btn-white btn-primary btn-bold" id="importData">
                                Import User
                            </button>
                        </c:if>
                        <input type="hidden" name="urlType" id="urlType"/>
                    </form>
                </div>
            </div>
        </div>
        <script>
            $(document).ready(function () {
                $('#validateData').click(function () {
                    $('#urlType').val('read_excel');
                    $('#formImport').submit();
                });
                $('#importData').click(function () {
                    $('#urlType').val('import_data');
                    $('#formImport').prop('enctype', false);
                    $('#formImport').attr('action', '${importExcel}');
                    $('#formImport').submit();
                });
            });
        </script>
    </body>
</html>
