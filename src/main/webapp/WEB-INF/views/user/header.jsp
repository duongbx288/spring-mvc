<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
</head>
<body>
	<div class="header">
		<div class="headertop_desc">
			<div class="call">
				<p>
					<span>Cần trợ giúp?</span>---Gọi cho chúng tôi:<span class="number">1-2-3-45677</span>
				</p>
			</div>
			<div class="account_desc">
				<c:if test="${sessionScope.logged==null}">
					<ul>
						<li><a href="/spring-mvc/login">Đăng kí</a></li>
						<li><a href="/spring-mvc/login">Đăng nhập</a></li>
					</ul>
				</c:if>
				<c:if test="${sessionScope.logged!=null}">
					<ul>
						<li><a href=""
							style="font-weight: bold; color: #000; font-family: serif; font-size: 16px">${sessionScope.logged.username}</a></li>
						<li><a href="logout" style="color: #000; font-family: serif;">Đăng
								xuất</a></li>
					</ul>
				</c:if>
			</div>
			<div class="clear"></div>
		</div>
		<div class="header_top">
			<div class="logo">
				<a href="/spring-mvc/trang-chu"> <img
					src="${pageContext.request.contextPath}/resources/user/images/watch-logo.png"
					alt="" /></a>
			</div>
			<div class="cart">
				<c:choose>
					<c:when test="${sessionScope.logged!=null}">
						<span style="padding-right: 5px;"><a style="color: red;"
							href="/spring-mvc/cart">Giỏ hàng</a></span>
						<span><a href="/spring-mvc/cart"><img
								style="width: 30px;"
								src="<c:url value="/resources/user/images/cart.png"/>"
								alt="cart image" /></a></span>
					</c:when>
					<c:otherwise>
						<span style="padding-right: 5px;"><a style="color: red;"
							href="/spring-mvc/cartfornone">Giỏ hàng</a></span>
						<span><a href="/spring-mvc/cartfornone"><img
								style="width: 30px;"
								src="<c:url value="/resources/user/images/cart.png"/>"
								alt="cart image" /></a></span>
					</c:otherwise>
				</c:choose>
				</p>
			</div>
			<script type="text/javascript">
				function DropDown(el) {
					this.dd = el;
					this.initEvents();
				}
				DropDown.prototype = {
					initEvents : function() {
						var obj = this;

						obj.dd.on('click', function(event) {
							$(this).toggleClass('active');
							event.stopPropagation();
						});
					}
				}

				$(function() {

					var dd = new DropDown($('#dd'));

					$(document).click(function() {
						// all dropdowns
						$('.wrapper-dropdown-2').removeClass('active');
					});

				});
			</script>
			<div class="clear"></div>
		</div>
		<div class="header_bottom">
			<div class="menu">
				<ul>
					<li class="active"><a href="/spring-mvc/trang-chu">Trang
							chủ</a></li>
					<li><a href="/spring-mvc/delivery">Sản phẩm</a></li>
					<li><a href="/spring-mvc/about">Thông tin cửa hàng</a></li>
					<li><a href="/spring-mvc/news">Tin tức</a></li>
					<li><a href="/spring-mvc/contact">Liên lạc</a></li>
					<div class="clear"></div>
				</ul>
			</div>
			<div class="search_box">
				<form action="/spring-mvc/searchByName" method="get">
					<input name="watchName" type="text" value="Tìm kiếm"
						onfocus="this.value = '';"
						onblur="if (this.value == '') {this.value = 'Search';}"><input
						type="submit" value="">
				</form>
			</div>
			<div class="clear"></div>
		</div>

	</div>
</body>
</html>