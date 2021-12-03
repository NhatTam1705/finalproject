<header>
    <div id="header" class="js-header">
        <div id="top-nav">
            <div class="top-nav-height">
                <div class="container-header">
                    <div class="pull-right">
                        <a href="<c:url value='/logincommon-home.html'/>" class="pull-right-login">
                            <span class="pull-right-icon-login ti-user"></span>
                            <span class="pull-right-text-login">Log in</span>
                        </a>
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
                            <a href="<c:url value='/home-phone.html'/>">
                                <span class="text">Phones</span>
                            </a>
                        </li>
                        <li class="nav-item nav-item__hide">
                            <a href="../../views/product/laptops.html">
                                <span class="text">Laptops</span>
                            </a>
                        </li>
                        <li class="nav-item nav-item__hide">
                            <a href="../../views/product/tablets.html">
                                <span class="text">Tablets</span>
                            </a>
                        </li>
                        <li class="nav-item nav-item__hide">
                            <a href="../../views/product/wearables.html">
                                <span class="text">Wearables</span>
                            </a>
                        </li>
                        <li class="nav-item nav-item__hide">
                            <a href="../../views/product/audio.html">
                                <span class="text">Audios</span>
                            </a>
                        </li>
                        <li class="nav-item nav-item__up">
                            <a href="#">
                                <span class="text">Accessories</span>
                                <span class="icon-angle nav-icon-angle ti-angle-down" style="font-size: 13px"></span>
                            </a>

                            <span class="icon-font-white change-icon-font angle-down">
                            </span>
                            <ul class="subnav">
                                <li><a href="">Backup Charger</a></li>
                                <li><a href="">Adapter, Cap</a></li>
                                <li><a href="">Screen Protector</a></li>
                                <li><a href="">Case</a></li>
                                <li><a href="">Memory Cart</a></li>
                                <li><a href="">Selfie Stick</a></li>
                                <li><a href="">Waterproof Bag</a></li>
                                <li><a href="">Keychains</a></li>
                            </ul>
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
                        <div class="shopping">
                            <!-- <span class="shopping-icon fal fal-shopping-cart"></span> -->
                            <span class="shopping-icon fal fa-shopping-cart"></span>
                            <span class="shopping-text">HV cloud</span>
                        </div>
                    </div>
                </div>
                <div class="nav-search">
                    <div class="nav-search-box">
                        <input type="text" placeholder="Search htv.com" class="nav-search-box-header">
                        <a href="#" class="nav-search-box-btn">
                            <span class="nav-search-box-icon-search ti-search"></span>
                        </a>
                    </div>
                    <a href="#" class="nav-search-btn-close">
                        <span class="nav-search-icon-close ti-close" onclick="hideSearchBox()"></span>
                    </a>
                </div>
            </div>
        </div>
    </div>
</header>