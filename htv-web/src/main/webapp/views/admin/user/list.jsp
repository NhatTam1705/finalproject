<%-- 
    Document   : list
    Created on : Nov 26, 2021, 7:33:09 AM
    Author     : 19110
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp"%>
<c:url var="editUserUrl" value="/ajax-admin-user-edit.html" >
    <c:param name="urlType" value="url_edit" />
</c:url>
<c:url var="listUserUrl" value="/admin-user-list.html">
    <c:param name="urlType" value="url_list"/>
</c:url>
<c:url var="importUrl" value="/admin-user-import.html">
    <c:param name="urlType" value="show_import_user"/>
</c:url>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>User Management</title>
    </head>
    <body>
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
                    <form action="${listUserUrl}" method="get" id="formUrl">
                    <div class="row">
                        <div class="col-xs-12">
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
                                                <label class="col-sm-2 control-label">Last Name</label>
                                                <div class="col-sm-8">
                                                    <div class="fg-line">
                                                        <input type="text" value="${items.pojo.lastName}" class="form-control input-sm" name="pojo.lastName"/>
                                                    </div>
                                                </div>
                                            </div>
                                            <div class="form-group">
                                                <label class="col-sm-2 control-label"></label>
                                                <div class="col-sm-8">
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
                                    <div class="dt-buttons btn-overlap btn-group">
                                        <a flag="info" class="dt-button buttons-colvis btn btn-white btn-primary btn-bold" onclick="update(this)">
                                                <span>
                                                    <i class="fa fa-plus-circle bigger-110 purple"></i>
                                                </span>
                                        </a>
                                        <button type="button" class="dt-button buttons-html5 btn btn-white btn-primary btn-bold" id="deleteAll" disabled
                                            data-toggle="tooltip" title="Delete All">
                                                <span>
                                                    <i class="fa fa-trash-o bigger-110 pink"></i>
                                                </span>
                                        </button>
                                        <a flag="info" class="dt-button buttons-colvis btn btn-white btn-primary btn-bold" href="${importUrl}">
                                                <span>
                                                    <i class="fa fa-file" aria-hidden="true"></i>
                                                </span>
                                        </a>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="table-responsive">
                            <display:table id="tableList" name="items.listResult" partialList="true" size="${items.totalItems}"
                                            pagesize="${items.maxPageItems}" sort="external" requestURI="${requestUrl}"
                                            class="table table-fcv-ace table-striped table-bordered table-hover dataTable no-footer"
                                            style="margin: 3em 0 1.5em;">
                                <display:column title="<fieldset class='form-group'>
												            <input type='checkbox' id='checkAll' class='check-box-element'>
												        </fieldset>" class="center select-cell" headerClass="center select-cell">
                                    <fieldset>
                                        <input type="checkbox" name="checkList" id="checkbox_${tableList.userId}" value="${tableList.userId}" class="check-box-element"/>
                                    </fieldset>
                                </display:column>
                                <display:column property="firstName" titleKey="First Name" sortable="true" sortName="firstName"/>
                                <display:column property="lastName" titleKey="Last Name" sortable="true" sortName="lastName"/>
                                <display:column property="address" titleKey="Address" sortable="true" sortName="address"/>
                                <display:column property="telephone" titleKey="Phone" sortable="true" sortName="telephone"/>
                                <display:column property="email" titleKey="Email" sortable="true" sortName="email"/>
                                <display:column headerClass="col-actions" titleKey="Operation">
                                    <c:url var="editUrl" value="/ajax-admin-user-edit.html">
                                        <c:param name="urlType" value="url_edit"/>
                                        <c:param name="pojo.userId" value="${tableList.userId}"/>
                                    </c:url>
                                    <a class="btn btn-sm btn-primary btn-edit" sc-url="${editUrl}" onclick="update(this)" data-toggle="tooltip" title="Edit User"><i class="fa fa-pencil-square-o" aria-hidden="true"></i></a>
                                    <a class="btn btn-sm btn-danger btn-cancel" data-toggle="tooltip" title="Delete User"><i class="fa fa-trash" aria-hidden="true"></i></a>
                                </display:column>
                            </display:table>
                    </div>
                    <input type="hidden" name="crudaction" id="crudaction"/>
                    <input type="hidden" name="urlType" id="urlType"/>
                    </form>
                </div>
            </div>
        </div>
        <!-- Modal -->
        <div class="modal fade" id="myModal" role="dialog"></div>
        <script type="text/javascript">
            $(document).ready(function () {
                $('#btnSearch').click(function () {
                    $('#crudaction').val('redirect_search');
                    $('#urlType').val('url_list');
                    $('#formUrl').submit();
                });
                // $('#editUserForm').validate({
                //     rules: [],
                //     messages: []
                // });
                // $("#password").rules( "add", {
                //     required: true,
                //     messages: {
                //         required: "Please enter password."
                //     }
                // });
                // $("#email").rules( "add", {
                //     required: true,
                //     messages: {
                //         required: "Please enter email."
                //     }
                // });
                // $("#phone").rules( "add", {
                //     required: true,
                //     messages: {
                //         required: "Please enter phone."
                //     }
                // });
                // $("#role").rules( "add", {
                //     required: true,
                //     messages: {
                //         required: "Please enter role."
                //     }
                // });
            }); 
            function update(btn) {
        var editUrl = $(btn).attr('sc-url');
        if (typeof editUrl == 'undefined') {
            editUrl = '${editUserUrl}';
        }
        $('#myModal').load(editUrl,'', function () {
            $('#myModal').modal('toggle');
            addOrEditUser();
        });
    }
    function addOrEditUser() {
        $('#btnSave').click(function () {
            $('#editUserForm').submit();
        });
        $('#editUserForm').submit(function (e) {
            e.preventDefault();
            $('#crudactionEdit').val('insert_update');
            $.ajax({
                type: $(this).attr('method'),
                url: $(this).attr('action'),
                data: $(this).serialize(),
                dataType: 'html',
                success: function(res){
                    if (res.trim() == "redirect_insert") {
                        $('#crudaction').val('redirect_insert');
                        $('#urlType').val('url_list');
                        $('#formUrl').submit();
                    } else if (res.trim() == "redirect_update") {
                        $('#crudaction').val('redirect_update');
                        $('#urlType').val('url_list');
                        $('#formUrl').submit();
                    } else if (res.trim() == "redirect_error") {
                        $('#crudaction').val('redirect_error');
                        $('#urlType').val('url_list');
                        $('#formUrl').submit();
                    }
                },
                error: function (res) {
                    console.log(res);
                }
            });
        });
    }
        </script>
    </body>
</html>
