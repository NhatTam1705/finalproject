<c:url value="/admin-user-list.html" var="userListUrl">
    <c:param name="urlType" value="url_list"/>
</c:url>
<c:url value="/admin-product-list.html" var="productListUrl">
    <c:param name="urlType" value="url_list"/>
</c:url>
<div class="sidebar">
    <div class="logo-details">
        <i class='icon'>
            <img src="<c:url value='/template/img/logo.png'/>" alt="logo" border="0" width="30px" height="20px">
        </i>
        <div class="logo_name">TV-Company</div>
        <i class='bx bx-menu' id="btn" ></i>
    </div>
    <ul class="nav-list">
        <%-- <li>
            <i class='bx bx-search' ></i>
            <input type="text" placeholder="Search...">
            <span class="tooltip">Search</span>
        </li> --%>
        <li>
            <a href="${productListUrl}">
                <i class='bx bx-grid-alt'></i>
                <span class="links_name">Product</span>
            </a>
            <span class="tooltip">Product</span>
        </li>
        <li>
            <a href="${userListUrl}">
                <i class='bx bx-user' ></i>
                <span class="links_name">User</span>
            </a>
            <span class="tooltip">User</span>
        </li>
        <%-- <li>
            <a href="#">
                <i class='bx bx-chat' ></i>
                <span class="links_name">Messages</span>
            </a>
            <span class="tooltip">Messages</span>
        </li>
        <li>
            <a href="#">
                <i class='bx bx-pie-chart-alt-2' ></i>
                <span class="links_name">Analytics</span>
            </a>
            <span class="tooltip">Analytics</span>
        </li>
        <li>
            <a href="#">
                <i class='bx bx-folder' ></i>
                <span class="links_name">File Manager</span>
            </a>
            <span class="tooltip">Files</span>
        </li> --%>
        <li>
            <a href="#">
                <i class='bx bx-cart-alt' ></i>
                <span class="links_name">Order</span>
            </a>
            <span class="tooltip">Order</span>
        </li>
        <%-- <li>
            <a href="#">
                <i class='bx bx-heart' ></i>
                <span class="links_name">Saved</span>
            </a>
            <span class="tooltip">Saved</span>
        </li>
        <li>
            <a href="#">
                <i class='bx bx-cog' ></i>
                <span class="links_name">Setting</span>
            </a>
            <span class="tooltip">Setting</span>
        </li> --%>
        <li class="profile">
            <div class="profile-details">
                <img src="<c:url value='/template/img/user-admin.png'/>" alt="profileImg">
                <div class="name_job">
                    <%-- <div class="name">Prem Shahi</div>
                    <div class="job">Web designer</div> --%>
                    <c:if test="${not empty login_name}">
                        <span class="name">Welcome ${login_name}</span>
                    </c:if>
                    <%-- <c:if test="${empty login_name}">
                        <c:url var="loginUrl" value="/logincommon-home.html">
                            <c:param name="action" value="login"/>
                        </c:url>
                        <a href="${loginUrl}">
                            <span class="icon-login ti-user"></span>
                            <span class="text-login">Log in</span>
                        </a>
                    </c:if> --%>
                </div>
            </div>
            <c:if test="${not empty login_name}">
                <c:url var="logoutUrl" value="/logout.html">
                    <c:param name="action" value="logout"/>
                </c:url>
                <a href="${logoutUrl}">
                    <i class='bx bx-log-out' id="log_out" ></i>
                </a>
            </c:if>
        </li>
    </ul>
</div>