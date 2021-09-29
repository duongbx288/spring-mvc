
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<title>Shop đồng hồ</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1">
<link rel="stylesheet" type="text/css"
	href="<c:url value="/resources/user/css/style.css"/>" media="all" />
<link href="<c:url value="/resources/user/css/slider.css"/>"
	rel="stylesheet" type="text/css" media="all" />
<script type="text/javascript"
	src="<c:url value="/resources/user/js/jquery-1.7.2.min.js"/>"></script>
<script type="text/javascript"
	src="<c:url value="/resources/user/js/move-top.js"/>"></script>
<script type="text/javascript"
	src="<c:url value="/resources/user/js/easing.js"/>"></script>
<script type="text/javascript"
	src="<c:url value="/resources/user/js/startstop-slider.js"/>"></script>
</head>
<body style="background-image: linear-gradient(#020024,#0a0a5d)">
	<div class="wrap"style="padding: 0px 20px; background-color: #fff;">
		<jsp:include page="header.jsp"></jsp:include>
					<div class="header_slide">
				<div class="header_bottom_left">
					<div class="categories">
						<ul>
							<h3>Danh mục đồng hồ</h3>
							<li><a href="${contextPath}/spring-mvc/search.htm?type=Chronograph watch">Đồng hồ Chronograph</a></li>
							<li><a href="${contextPath}/spring-mvc/search.htm?type=Automatic">Đồng hồ cơ - Automatic</a></li>
							<li><a href="${contextPath}/spring-mvc/search.htm?type=Quartz Movement">Đồng hồ chạy pin</a></li>
							<li><a href="${contextPath}/spring-mvc/search.htm?type=Smart Watch">Đồng hồ thông minh</a></li>
							<li><a href="${contextPath}/spring-mvc/search.htm?type=Electric Watch">Đồng hồ điện tử</a></li>
							<li><a href="${contextPath}/spring-mvc/search.htm?type=Solar Watch">Đồng hồ solar</a></li>
							<li><a href="${contextPath}/spring-mvc/search.htm?type=Hybrid Watch">Hybrid Watch</a></li>
						</ul>
					</div>
				</div>
				<div class="header_bottom_right">
					<div class="slider">
						<div id="slider">
							<div id="mover">
								<div id="slide-1" class="slide" style="width=50%;">
									<div class="slider-img" style="width=50%;">
										<a href="/spring-mvc/trang-chu"><img src="<c:url value="/resources/user/images/bocasio2.jpg"/>"
											alt="learn more" /></a>
									</div>
									<div class="slider-text" style="width=50%;">
										<h1>ĐỒNG HỒ <br>
											<h1>CASIO</h1>
										</h1>
										<h2>Trọn bộ</h2>
										<div class="features_list">
											<h2>Giảm giá tới 20%</h2>
											<br>
											<h4>Cặp 3 đồng hồ cho cả gia đình</h4>									
										</div>
										<a href="/spring-mvc/trang-chu" class="button">Shop now</a>
									</div>
									<div class="clear"></div>
								</div>
								<div class="slide">
									<div class="slider-text">
										<h1>
											CHRISTMAS EVENT<br>
										</h1>
										<h2>UP to 40% OFF</h2>
										<div class="features_list">
											<h4>Cơ hội mua sắm online giá hủy diệt, nhiều khuyến mãi hấp dẫn, miễn phí vận chuyển toàn quốc.</h4>
											<h4></h4>
										</div>
										<a href="/spring-mvc/trang-chu" class="button">Shop Now</a>
									</div>
									<div class="slider-img">
										<a href="/spring-mvc/trang-chu"><img src="<c:url value="/resources/user/images/slide-3-image.jpg"/>"
											alt="learn more" /></a>
									</div>
									<div class="clear"></div>
								</div>
								<div class="slide">
									<div class="slider-img">
										<a href="/spring-mvc/trang-chu"><img src="<c:url value="/resources/user/images/slide-2-image.jpg"/>"
											alt="learn more" /></a>
									</div>
									<div class="slider-text">
										<h1>
											Clearance<br>
											<span>SALE</span>
										</h1>
										<h2>UP to 10% OFF</h2>
										<div class="features_list">
											<h4>Get to Know More About Our Memorable Services</h4>
										</div>
										<a href="/spring-mvc/news" class="button">Shop Now</a>
									</div>
									<div class="clear"></div>
								</div>
							</div>
						</div>
						<div class="clear"></div>
					</div>
				</div>
				<div class="clear"></div>
			</div>
		<div class="main">
			<div class="content">
				<div class="content_top" style="background-color: #FFF1D6;">
					<div class="heading">
						<h3>Sản phẩm mới</h3>
					</div>
					<div class="see">
						<p>
							<a href="/spring-mvc/type.htm?type=new">Xem tất cả</a>
						</p>
					</div>
					<div class="clear"></div>
				</div>
				<div class="section group">
				<c:forEach var="item" items="${watch}" begin="0" end="3" step="1">
					<div class="grid_1_of_4 images_1_of_4">
							<div class = "hover_image">
						<a href="/spring-mvc/preview.htm?watchId=${item.watch_id}"><img height="300" width="250" src="<c:url value="${item.image}"/>"
							alt="" /></a>
							</div>
						<a href="/spring-mvc/preview.htm?watchId=${item.watch_id}"><h2>${item.watch_name}</h2></a>
						<div class="price-details">
							<div class="price-number">
								<p>
									<span style="font-size: 2em; color: red;" class="rupees">${item.price} đ</span>
								</p>
							</div>
							<div class="clear"></div>
						</div>

					</div>
				</c:forEach>
				</div>
				<div class="content_bottom" style="background-color: #FFF1D6;">
					<div class="heading">
						<h3>Sản phẩm đặc biệt</h3>
					</div>
					<div class="see">
						<p>
							<a href="/spring-mvc/type.htm?type=featured">Xem tất cả</a>
						</p>
					</div>
					<div class="clear"></div>
				</div>
				<div class="section group">
				<c:forEach var="item" items="${randomProduct}" begin="0" end="3" step="1">
					<div class="grid_1_of_4 images_1_of_4">
						<div class="hover_image">
							<a href="/spring-mvc/preview.htm?watchId=${item.watch_id}"><img height="300" width="250" src="<c:url value="${item.image}"/>"
							alt="" /></a>
						</div>
						<a href="/spring-mvc/preview.htm?watchId=${item.watch_id}"><h2>${item.watch_name}</h2></a>
						<div class="price-details">
							<div class="price-number">
								<p>
									<span style="font-size: 2em; color: red;" class="rupees">${item.price} đ</span>
								</p>
							</div>
							<div class="clear"></div>
						</div>
					</div>
				</c:forEach>
				</div>
			</div>
		</div>
	</div>
	<jsp:include page="footer.jsp"></jsp:include>
	<script type="text/javascript">
		$(document).ready(function() {
			$().UItoTop({
				easingType : 'easeOutQuart'
			});

		});
	</script>
	<a href="#" id="toTop"><span id="toTopHover"> </span></a>
</body>
</ html>