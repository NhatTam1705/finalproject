<header>
    <div id="header" class="js-header">
        <div id="top-nav">
            <div class="top-nav-height">
                <div class="container-header">
                    <div class="pull-right">
                        <c:if test="${not empty login_name}">
                            <span class="pull-right-icon-login">Welcome ${login_name.lastName}</span>
                            <c:url var="logoutUrl" value="/logout.html">
                                <c:param name="action" value="logout"/>
                            </c:url>
                            <a href="${logoutUrl}" class="pull-right-login">
                                <span class="pull-right-text-login">Log out</span>
                            </a>
                        </c:if>
                        <c:if test="${empty login_name}">
                            <c:url var="loginUrl" value="/logincommon-home.html">
                                <c:param name="action" value="login"/>
                            </c:url>
                            <a href="${loginUrl}" class="pull-right-login">
                                <span class="pull-right-icon-login ti-user"></span>
                                <span class="pull-right-text-login">Log in</span>
                            </a>
                        </c:if>
                    </div>
                </div>
            </div>
        </div>
        <div id="navbar">
            <div class="container-header nav-container">
                <div class="navbar-header">
                    <a href="<c:url value='/home.html'/>" class="logo navbar-brand">
                        <img src="<c:url value='/template/img/logo.png'/>" alt="" />
                    </a>
                </div>
                <nav id="htv-navbar" class="js-htv-navbar">
                    <ul id="nav">
                        <li class="nav-item nav-item__hide">
                            <a href="<c:url value='/home.html'/>">
                                <span class="text">Home</span>
                            </a>
                        </li>
                        <li class="nav-item nav-item__hide">
                            <a href="<c:url value='/home-phone.html'/>">
                                <span class="text">Product</span>
                            </a>
                        </li>
                        <li class="nav-item nav-item__hide">
                            <a href="<c:url value='/home-about.html'/>">
                                <span class="text">About</span>
                            </a>
                        </li>
                        <li class="nav-item nav-item__hide">
                            <a href="<c:url value='/home-support.html'/>">
                                <span class="text">Support</span>
                            </a>
                        </li>
                    </ul>
                </nav>
                <div class="nav-right">
                    <span class="icon-search ti-search"></span>
                    <div class="icon">
                        <span class="fal fa-shopping-bag"></span>
                        <span class="text icon-hide">Buy</span>
                        <span class="icon-font icon-angle ti-angle-down icon-hide"
                              style="margin-top:2px; font-size: 13px"></span>
                        <span class="icon-font-white change-icon-font ti-angle-down icon-hide"
                              style="margin-top: 2px; margin-left: 2px"></span>
                        <input type="text" class="input-search" placeholder="Search htv.com">
                        <span class="btn-menu icon-menu ti-menu"></span>
                        <a href="<c:url value='/shopping-cart.html'/>">
                        <div class="shopping">
                            <!-- <span class="shopping-icon fal fal-shopping-cart"></span> -->
                            <span class="shopping-icon fal fa-shopping-cart"></span>
                            <span class="shopping-text">HV cloud</span>
                        </div>
                        </a>
                    </div>
                </div>
                <c:url var="urlList" value="/home-phone.html"/>
                <form action="${urlList}" method="get" >
                <div class="nav-search">
                    <div class="nav-search-box">
                        <input type="text" name="pojo.productName" value="${items.pojo.productName}" placeholder="Search tv.com" class="nav-search-box-header">
                        <a href="#" class="nav-search-box-btn">
                            <%-- <button> --%>
                                <span class="nav-search-box-icon-search ti-search"></span>
                            <%-- </button> --%>
                        </a>
                    </div>
                    <a href="#" class="nav-search-btn-close">
                        <span class="nav-search-icon-close ti-close" onclick="hideSearchBox()"></span>
                    </a>
                </div>
                </form>
            </div>
        </div>
    </div>
</header>