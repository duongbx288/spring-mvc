<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!--A Design by W3layouts
Author: W3layout
Author URL: http://w3layouts.com
License: Creative Commons Attribution 3.0 Unported
License URL: http://creativecommons.org/licenses/by/3.0/
-->
<!DOCTYPE HTML>

<!-- Mirrored from p.w3layouts.com/demos/home_shoppe/web/preview.html by HTTrack Website Copier/3.x [XR&CO'2014], Sat, 26 Dec 2020 08:53:39 GMT -->
<!-- Added by HTTrack -->

<!-- /Added by HTTrack -->
<html>
<head>
<title>Shop đồng hồ - cartfornone</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1">
<link rel="stylesheet" type="text/css"
	href="<c:url value="/resources/user/css/style.css"/>" media="all" />
<script type="text/javascript"
	src="<c:url value="/resources/user/js/jquery-1.7.2.min.js"/>"></script>
<script type="text/javascript"
	src="<c:url value="/resources/user/js/move-top.js"/>"></script>
<script type="text/javascript"
	src="<c:url value="/resources/user/js/easing.js"/>"></script>
<script type="text/javascript"
	src="<c:url value="/resources/user/js/easyResponsiveTabs.js"/>"></script>
<link rel="stylesheet" type="text/css"
	href="<c:url value="/resources/user/css/easy-responsive-tabs.css"/>"
	media="all" />
<link rel="stylesheet" type="text/css"
	href="<c:url value="/resources/user/css/global.css"/>" media="all" />
<link rel="stylesheet" type="text/css"
	href="<c:url value="/resources/user/css/custom.css"/>" media="all" />
<script type="text/javascript"
	src="<c:url value="/resources/user/js/slides.min.jquery.js"/>"></script>
<script>
	$(function() {
		$('#products').slides({
			preload : true,
			preloadImage : 'img/loading.gif',
			effect : 'slide, fade',
			crossfade : true,
			slideSpeed : 350,
			fadeSpeed : 500,
			generateNextPrev : true,
			generatePagination : false
		});
	});
</script>

<style>
.bd-placeholder-img {
	font-size: 1.125rem;
	text-anchor: middle;
	-webkit-user-select: none;
	-moz-user-select: none;
	-ms-user-select: none;
	user-select: none;
}

@media ( min-width : 768px) {
	.bd-placeholder-img-lg {
		font-size: 3.5rem;
	}
}
</style>

<style type="text/css">
span {
	display: inline #-block;
	font-size: 16px;
}

.z {
	font-weight: bold;
}
</style>
</head>
<body style="background-image: linear-gradient(#020024, #0a0a5d)">

	<script type="text/javascript">
		function showCart(id) {
			if (confirm("Xác nhận xóa?")) {
				$
						.ajax({
							type : "POST",
							url : "deleteCart",
							dataType : "json",
							data : {
								watchId : id
							},
							success : function(data) {
								var y = '';

								$
										.each(
												data,
												function(key, value) {
													y = y
															+ '<div class="wish-list" style="width: 80%; margin-left: 10%; height: 50px"> <div style="display: flex;align-items: center;"> <span style="width: 80px; text-align: center;">1</span> <span style="width: 150px; text-align: center;"><img style="max-height: 50px;" src="<c:url value="/resources/user/images/' + value['product']['image'] + '"/>" alt="learn more" /></span> <span style="width: 350px; text-align: center;">'
															+ value['product']['watch_name']
															+ '</span> <span style="width: 100px; text-align: center;">'
															+ value['quantity']
															+ '</span> <span style="width: 200px; text-align: center;">'
															+ value['product']['price']
															+ 'đ</span> <span class="z" style="width: 80px; text-align: center;"><p onclick="showCart('
															+ "'"
															+ value['product']['watch__id']
															+ "'"
															+ ')">Xóa</p></span> </div> </div>';
												});

								document.getElementById("cartDetail").innerHTML = y;

							}
						});
			}
		};
	</script>


	<script>
		function tt() {
			
			alert('Thanh toán thành công! Đơn hàng sẽ được giao trong 1 tuần tới!');
		}
	</script>


	<div class="wrap" style="padding: 0px 20px; background-color: #fff;">
		<jsp:include page="header.jsp"></jsp:include>
		<br style="margin-top: 5px">
		<h3 style="width: 80%; margin-left: 10%">GIỎ HÀNG</h3>
		<br>
		<div class="wish-list" style="width: 80%; margin-left: 10%">
			<div style="display: flex; align-items: center;">
				<span class="z" style="width: 80px; text-align: center;">STT</span>
				<span class="z" style="width: 150px; text-align: center;">Ảnh</span>
				<span class="z" style="width: 350px; text-align: center;">Tiêu
					đề</span> <span class="z" style="width: 100px; text-align: center;">Số
					lượng</span> <span class="z" style="width: 200px; text-align: center;">Thành
					tiền</span> <span class="z" style="width: 80px; text-align: center;"></span>
			</div>
		</div>
		<div id="cartDetail">
			<c:forEach var="item" items="${listCart}">
				<div class="wish-list"
					style="width: 80%; margin-left: 10%; height: 50px">
					<div style="display: flex; align-items: center;">
						<span style="width: 80px; text-align: center;">1</span> <span
							style="width: 150px; text-align: center;"><img
							style="max-height: 50px;"
							src="<c:url value="${item.product.image}"/>" alt="learn more" /></span>
						<span style="width: 350px; text-align: center;">${item.product.watch_name}</span>
						<span style="width: 100px; text-align: center;">${item.quantity}</span>
						<span style="width: 200px; text-align: center;">${item.product.price}
							đ</span> <button><span class="z" style="width: 80px; text-align: center;"><a
							onclick="showCart('${item.product.watch_id}')">Xóa</a></span></button>
					</div>
				</div>
			</c:forEach>
		</div>
		<br>
		<div style="margin-left: 75%">
			<c:set var="Total" value="${0}" />
			<c:forEach var="item" items="${listCart}">
				<c:set var="Total" value="${Total + item.product.price}"/>
			</c:forEach>
			<h3 style="color: purple;">Tổng tiền: ${Total} đ</h3>
			<c:set var="totalAmount" value="${Total}"/>
		</div>
		<br>
		<div class="wish-list" style="width: 80%; margin-left: 10%; height: 50px">
			<form action="/spring-mvc/thanhtoan1">
				<div style="width: 100%; height: 50px;">
					<span style="float: left">
						<h5>Tên đầy đủ:</h5>
					</span> <span style="float: left; padding-left: 20px;"> <input
						name="fullname" style="width: 100px;" type="text">
					</span> <span style="float: left; padding-left: 50px;">
						<h5>Số điện thoại:</h5>
					</span> <span style="padding-left: 20px;"> <input name="phone"
						style="width: 350px;" type="text">
					</span>
				</div>
				<div style="width: 100%; height: 50px;">
					<span style="float: left;">
						<h5>Địa chỉ:</h5>
					</span> <span style="float: left; padding-left: 50px;"> <input
						name="address" style="width: 398px;" type="text">
					</span>
				</div>
				<div style="width: 100%; height: 50px;">
			    <span
					style="float: left; padding-up: 20px; padding-left: 20px;">
					<input onclick="tt()" value="Thanh toán" style="width: 605px; margin-down: 70%; "
					type="submit">	
				</span>
				</div>
			</form>
		</div>



		<br> <br>
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

<!-- Mirrored from p.w3layouts.com/demos/home_shoppe/web/preview.html by HTTrack Website Copier/3.x [XR&CO'2014], Sat, 26 Dec 2020 08:53:44 GMT -->
</html>

