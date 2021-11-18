<%-- 
    Document   : home
    Created on : Nov 11, 2021, 1:58:03 PM
    Author     : 19110
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>TV-Company</title>
    </head>
    <body>
        <div id="slider" class="slider">
			<div class="slide active">
				<img src="<c:url value='/template/img/backgroundSilder/poster-1.jpg'/>" alt="" />
				<!-- <div class="info">
					<h2>Winter Mountains</h2>
					<p>
						Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do
						eiusmod tempor incididunt ut labore et dolore magna aliqua.
					</p>
				</div> -->
			</div>
			<div class="slide">
				<img src="<c:url value='/template/img/backgroundSilder/poster-2.jpg'/>" alt="" />
				<!-- <div class="info">
					<h2>Tropical Desert</h2>
					<p>
						Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do
						eiusmod tempor incididunt ut labore et dolore magna aliqua.
					</p>
				</div>    -->

			</div>
			<div class="slide">
				<img src="<c:url value='/template/img/backgroundSilder/poster-3.jpg'/>" alt="" />
				<!-- <div class="info">
					<h2>Steaming Volcanoes</h2>
					<p>
						Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do
						eiusmod tempor incididunt ut labore et dolore magna aliqua.
					</p>
				</div> -->
			</div>
			<div class="navigation">
				<i class="fas fa-chevron-left prev-btn"></i>
				<i class="fas fa-chevron-right next-btn"></i>
			</div>
			<div class="navigation-visibility">
				<div class="slide-icon active"></div>
				<div class="slide-icon"></div>
				<div class="slide-icon"></div>
			</div>
		</div>
		<div id="content">
			<div class="new-content">
				<div class="new-top">
					<h2 class="title">What's New</h2>
				</div>
				<div class="panel-list-img">
					<div class="list-top-img">
						<div class="img-box">
							<a href="">
								<img src="<c:url value='/template/img/pictureContent/slider-1.jpg'/>" alt="" class="img-click">
								<div class="mask">
									<div class="text-box">
										<div class="category">PRODUCT</div>
										<div class="name js-text-dot-en">MacBook Pro</div>
										<div class="text-in-img">Undeveloped Feature</div>
										<div class="more">
											<span>Learn More</span>
											<i class="iconfont ti-angle-right"></i>
										</div>
									</div>
								</div>
							</a>
						</div>
						<div class="img-box">
							<a href="">
								<img src="<c:url value='/template/img/pictureContent/slider-2.jpg'/>" alt="" class="img-click">
								<div class="mask">
									<div class="text-box">
										<div class="category">PRODUCT</div>
										<div class="name js-text-dot-en">Phone</div>
										<div class="text-in-img">Undeveloped Feature</div>
										<div class="more">
											<span>Learn More</span>
											<i class="iconfont ti-angle-right"></i>
										</div>
									</div>
								</div>

							</a>
						</div>
					</div>
					<div class="list-center-img">
						<div class="img-box">
							<a href="">
								<img src="<c:url value='/template/img/pictureContent/slider-3.jpg'/>" alt="" class="img-click">
								<div class="mask">
									<div class="text-box">
										<div class="category">PRODUCT</div>
										<div class="name js-text-dot-en">Iphone 12</div>
										<div class="text-in-img">Undeveloped Feature</div>
										<div class="more">
											<span>Learn More</span>
											<i class="iconfont ti-angle-right"></i>
										</div>
									</div>
								</div>
							</a>
						</div>
						<div class="img-box">
							<a href="">
								<img src="<c:url value='/template/img/pictureContent/slider-7.jpg'/>" alt="" class="img-click">
								<div class="mask">
									<div class="text-box">
										<div class="category">PRODUCT</div>
										<div class="name js-text-dot-en">Asus ROG 3</div>
										<div class="text-in-img">Undeveloped Feature</div>
										<div class="more">
											<span>Learn More</span>
											<i class="iconfont ti-angle-right"></i>
										</div>
									</div>
								</div>
							</a>
						</div>
					</div>
					<div class="list-bottom-img">
						<div class="img-box">
							<a href="">
								<img src="<c:url value='/template/img/pictureContent/slider-5.jpg'/>" alt="" class="img-click">
								<div class="mask">
									<div class="text-box">
										<div class="category">PRODUCT</div>
										<div class="name js-text-dot-en">Phone</div>
										<div class="text-in-img">Undeveloped Feature</div>
										<div class="more">
											<span>Learn More</span>
											<i class="iconfont ti-angle-right"></i>
										</div>
									</div>
								</div>
							</a>
						</div>
						<div class="img-box">
							<a href="">
								<img src="<c:url value='/template/img/pictureContent/slider-6.jpg'/>" alt="" class="img-click">
								<div class="mask">
									<div class="text-box">
										<div class="category">PRODUCT</div>
										<div class="name js-text-dot-en">Airport</div>
										<div class="text-in-img">Undeveloped Feature</div>
										<div class="more">
											<span>Learn More</span>
											<i class="iconfont ti-angle-right"></i>
										</div>
									</div>
								</div>
							</a>
						</div>
						<div class="img-box">
							<a href="">
								<img src="<c:url value='/template/img/pictureContent/slider-4.jpg'/>" alt="" class="img-click">
								<div class="mask">
									<div class="text-box">
										<div class="category">PRODUCT</div>
										<div class="name js-text-dot-en">Xiaomi</div>
										<div class="text-in-img">Undeveloped Feature</div>
										<div class="more">
											<span>Learn More</span>
											<i class="iconfont ti-angle-right"></i>
										</div>
									</div>
								</div>
							</a>
						</div>
					</div>
				</div>
			</div>
			<div class="story">
				<img src="<c:url value='/template/img/Huawei-P30.jpg'/>" alt="">
			</div>
			<div class="new-content" style="cursor: pointer">
				<div class="new-top">
					<h2 class="title">News & Events</h2>
				</div>
				<div class="event-main">
					<div class="col-event col-third pr-15">
						<img class="place-img-event" src="<c:url value='/template/img/pictureContent/slider-8.jpg'/>" alt="">
						<div class="topic">Event</div>
						<div class="event-text-box">
							<h4 class="sub-title">
								Better World Summit for Green ICT for Green Development 
							</h4>
							<div class="info">
								<div class="info-address">
									<span class="iconfont ti-location-pin"></span>
									<span class="name-location">Viet Nam</span>
								</div>
								<div class="info-text">
									Huawei and Informa Tech will jointly host the Better World Summit and discuss green development...
								</div>
							</div>
						</div>
					</div>
					<div class="col-event col-third pr-15 pl-15">
						<img class="place-img-event" src="<c:url value='/template/img/pictureContent/slider-9.jpg'/>" alt="">
						<div class="topic">Event</div>
						<div class="event-text-box">
							<h4 class="sub-title">
								Better World Summit for Green ICT for Green Development 
							</h4>
							<div class="info">
								<div class="info-address">
									<span class="iconfont ti-location-pin"></span>
									<span class="name-location">Viet Nam</span>
								</div>
								<div class="info-text">
									Connect with experts and leaders, explore opportunities and new innovations and solutions.
								</div>
							</div>
						</div>
					</div>
					<div class="col-event col-third pl-15">
						<div class="topic">News</div>
						<div class="new-text-box">
							<div class="scrool">
								<div class="info">
									<div class="info-text">
										<h4 class="sub-title">
											Better World Summit for Green ICT for Green Development
										</h4>
										<div class="time">
											NOV 18, 2021
										</div>
									</div>
									<div class="info-text">
										<h4 class="sub-title">
											Better World Summit for Green ICT for Green Development
										</h4>
										<div class="time">
											NOV 18, 2021
										</div>
									</div>
									<div class="info-text">
										<h4 class="sub-title">
											Better World Summit for Green ICT for Green Development
										</h4>
										<div class="time">
											NOV 18, 2021
										</div>
									</div>
									<div class="info-text">
										<h4 class="sub-title">
											Better World Summit for Green ICT for Green Development
										</h4>
										<div class="time">
											NOV 18, 2021
										</div>
									</div>
									<div class="info-text">
										<h4 class="sub-title">
											Better World Summit for Green ICT for Green Development
										</h4>
										<div class="time">
											NOV 18, 2021
										</div>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
				<div class="btn-group">
					<a href="#" class="btn-more mr-25-15">More Events</a>
					<a href="#" class="btn-more ml-15">More News</a>
				</div>
			</div>

			<div id="back-to-top" class="back-to-top">
				<button id="back-to-top-btn" title="Back to top">
					<i class="fas fa-angle-double-up"></i>
				</button>
			</div>
			<div class="toggle-container">
				<button class="theme-light theme-btn light" onclick="setTheme('light')" title="Light mode">
					<i class="fas fa-sun-cloud"></i>
				</button>
				<button class="theme-dark theme-btn dark" onclick="setTheme('dark')" title="Dark mode">
					<i class="fas fa-moon-cloud"></i>
				</button>
			</div>
		</div>
    </body>
</html>
