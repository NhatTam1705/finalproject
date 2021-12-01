<%-- 
    Document   : edit
    Created on : Nov 27, 2021, 7:16:21 PM
    Author     : 19110
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp"%>
<c:url var="editUserUrl" value="/ajax-admin-users-edit.html">
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
                    <c:if test="${not empty item.pojo.userId}">
                        <h4 class="modal-title">Edit User</h4>
                    </c:if>
                    <c:if test="${empty item.pojo.userId}">
                        <h4 class="modal-title">Add User</h4>
                    </c:if>
                </div>
                <form action="${editUserUrl}" method="POST" id="editUserForm">
                    <div class="modal-body">
                        <div class="row">
                            <div class="col-md-12">
                                <div class="md-form">
                                    <input type="text" placeholder="First Name" class="form-control" value="${item.pojo.firstName}" name="pojo.firstName"/>
                                </div>
                            </div>
                            <br/>
                            <br/>
                            <div class="col-md-12">
                                <div class="md-form">
                                    <input type="text" placeholder="Last Name" class="form-control" value="${item.pojo.lastName}" name="pojo.lastName"/>
                                </div>
                            </div>
                            <br/>
                            <br/>
                            <div class="col-md-12">
                                <div class="md-form">
                                    <input type="password" placeholder="Password" class="form-control" value="${item.pojo.password}" id="password" required name="pojo.password"/>
                                </div>
                            </div>
                            <br/>
                            <br/>
                            <div class="col-md-12">
                                <div class="md-form">
                                    <input type="email" placeholder="Email" class="form-control" value="${item.pojo.email}" id="email" required name="pojo.email"/>
                                </div>
                            </div>
                            <br/>
                            <br/>
                            <div class="col-md-12">
                                <div class="md-form">
                                    <input type="number" placeholder="Phone" class="form-control" value="${item.pojo.telephone}" id="phone" required name="pojo.telephone"/>
                                </div>
                            </div>
                            <br/>
                            <br/>
                            <div class="col-md-12">
                                <div class="md-form">
                                    <input type="text" placeholder="Address" class="form-control" value="${item.pojo.address}" required name="pojo.address"/>
                                </div>
                            </div>
                            <br/>
                            <br/>
                            <div class="col-md-12">
                                <div class="md-form">
                                    <c:choose>
                                        <c:when test="${not empty item.pojo.userId}">
                                            <select id="role" name="roleId">
                                                <option value="${item.pojo.rolesDTO.roleId}">${item.pojo.rolesDTO.roleName}</option>
                                                <c:forEach items="${item.roles}" var="itemRole">
                                                    <c:if test="${itemRole.roleId ne item.pojo.rolesDTO.roleId}">
                                                        <option value="${itemRole.roleId}">${itemRole.roleName}</option>
                                                    </c:if>
                                                </c:forEach>
                                            </select>
                                        </c:when>
                                        <c:otherwise>
                                            <select id="role" name="roleId">
                                                <option value="-1">Choose Role</option>
                                                <c:forEach items="${item.roles}" var="itemRole">
                                                    <option value="${itemRole.roleId}">${itemRole.roleName}</option>
                                                </c:forEach>
                                            </select>
                                        </c:otherwise>
                                    </c:choose>
                                </div>
                            </div>
                        </div>
                    </div>
                    <c:if test="${not empty item.pojo.userId}">
                        <input type="hidden" name="pojo.userId" value="${item.pojo.userId}"/>
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