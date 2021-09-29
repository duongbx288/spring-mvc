<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE HTML>
<html>
<head>
<title>Shop đồng hồ</title>
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
<link rel="stylesheet" type="text/css"
	href="<c:url value="/resources/user/css/easy-responsive-tabs.css"/>"
	media="all" />
<link rel="stylesheet"
	href="<c:url value="/resources/user/css/global.css"/>" />
<script type="text/javascript"
	src="<c:url value="/resources/user/js/easyResponsiveTabs.js"/>"></script>
<script src="<c:url value="/resources/user/js/slides.min.jquery.js"/>"></script>


<script src="js/slides.min.jquery.js"></script>
<script type="text/javascript">
	function themdongho() {
		alert("Thêm sản phẩm thành công!");
	}
</script>
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
</head>

<c:if test="${sessionScope.logged==null}">
	<script type="text/javascript">
		function rate() {
			alert('Vui lòng đăng nhập trước!');
		};
	</script>
</c:if>
<c:if test="${sessionScope.logged!=null}">
	<script type="text/javascript">
		function rate() {
			alert('Cảm ơn đã góp ý!');
		};
	</script>
</c:if>

<body style="background-image: linear-gradient(#020024, #0a0a5d)">
	<div class="wrap" style="padding: 0px 20px; background-color: #fff;">
		<jsp:include page="header.jsp"></jsp:include>
		<div class="main">
			<div class="content">
				<div class="content_top">
					<div class="back-links">
						<p>
							<a href="/spring-mvc/index">Home</a>
						</p>
					</div>
					<div class="clear"></div>
				</div>
				<div class="section group">
					<div class="cont-desc span_1_of_2">
						<div class="product-details">
							<div class="grid images_3_of_2">
								<div id="container">
									<div id="products_example">
										<div id="products" style="width: 90%; background-color: #eee;">
											<img src="<c:url value="${watchSelected.image}"/>"
												alt="learn more" />
										</div>
									</div>
								</div>
							</div>
							<div class="desc span_3_of_2b">
								<h2>${watchSelected.watch_name}</h2>
								<span>
									<div class="grid images_3_of_2b">
										<p>
										<h3>Nhà sản xuất: ${watchSelected.publisher}</h3>
										</p>
										<br>
										<p>
										<h3>Năm sản xuất: ${watchSelected.year}</h3>
										</p>
										<p>
										<h3></h3>
										</p>
										<br>
										<p>
										<h3>Màu:${watchSelected.color}</h3>
										</p>
									</div>
								</span> <br> <br> <br> <br> <br>
								<div class="price">
									<p>
										Gía: <span>${watchSelected.price} đ</span>
									</p>
								</div>
								<div class="share-desc">
									<div class="button">
										<form action="/spring-mvc/addCart" method="get">
											<input name="watchId" type="text"
												style="background: #fff; border: none; color: #fff; padding: 0; width: 0px"
												value="${watchSelected.watch_id}"> <input
												name="number" type="number"
												style="font-size: 20px; padding: 10px 10px 10px 20px; width: 70px"
												value="1"> <input type="submit"
												onclick="themdongho()"
												style="color: #fff; font-size: 20px; background: grey; font-weight: bold; padding: 10px 10px 10px 10px;"
												class="buttoncustom" value="Thêm vào giỏ hàng"> <br>
											<div class="clear"></div>
										</form>
									</div>
								</div>
								<div class="wish-list">
									<ul>
										<li class="wish"><a href="#">Sản phẩm mới</a></li>
										<li class="compare"><a href="#">Bảo hành chu đáo</a></li>
									</ul>
								</div>
							</div>
							<div class="clear"></div>
						</div>
						<div class="product_desc">
							<div id="horizontalTab">
								<ul class="resp-tabs-list">
									<li>Thông tin sản phẩm</li>
									<li>Đánh giá về sản phẩm</li>
									<div class="clear"></div>
								</ul>
								<div class="resp-tabs-container">
									<div class="product-desc">
										<p>${watchSelected.intro}</p>
									</div>
									<div class="product-tags">
										<div class="review">
											<h4>Đánh giá sản phẩm</h4>
											<div class="your-review">
												<div class="wish-list">
													<form action="/spring-mvc/comment">
														<div>
															<input id="userComment" type="hidden" name="user"
																value="${sessionScope.logged.username}"> <input
																name="watchId" type="text"
																style="background: #fff; border: none; color: #fff; padding: 0; width: 0px;"
																value="${watchSelected.watch_id}"> <input
																name="username" type="text"
																style="background: #fff; border: none; color: #fff; padding: 0; width: 0px;"
																value="${sessionScope.logged.username}"> <span><label>Bình
																	luận<span class="red">*</span>
															</label></span> <span><input name="comment" type="text" value=""></span>
														</div>
														<div>
															<span><input onclick="rate()" type="submit"
																value="Gửi bình luận"></span>
														</div>
													</form>
												</div>
											</div>
											<c:forEach var="item" items="${listComment}">
												<div>
													<p
														style="padding-bottom: 0px; padding-left: 15px; width: 200px; float: left; color: #000; font-weight: 600; font-size: 14.5px;">${item.username}<br>
													<p style="font-style: italic;">${item.date_cmt}</p>
													</p>
													<p
														style="margin-left: 215px; margin-top: -20px; color: #333; font-weight: 400; font-size: 14.5px; width: 700px;">${item.content}</p>
													<br>
												</div>
											</c:forEach>
										</div>
									</div>
								</div>
							</div>
						</div>
						<script type="text/javascript">
							$(document).ready(function() {
								$('#horizontalTab').easyResponsiveTabs({
									type : 'default', //Types: default, vertical, accordion           
									width : 'auto', //auto or any width like 600px
									fit : true
								// 100% fit in a container
								});
							});
						</script>
					</div>
					<div class="rightsidebar span_3_of_1">
						<h2>Danh mục đồng hồ</h2>
						<ul class="side-w3ls">
							<li><a
								href="${contextPath}/spring-mvc/search.htm?type=Chronograph watch">Đồng
									hồ Chronograph</a></li>
							<li><a
								href="${contextPath}/spring-mvc/search.htm?type=Automatic">Đồng
									hồ cơ - Automatic</a></li>
							<li><a
								href="${contextPath}/spring-mvc/search.htm?type=Quartz Movement">Đồng
									hồ chạy pin</a></li>
							<li><a
								href="${contextPath}/spring-mvc/search.htm?type=Smart Watch">Đồng
									hồ thông minh</a></li>
							<li><a
								href="${contextPath}/spring-mvc/search.htm?type=Electric Watch">Đồng
									hồ điện tử</a></li>
							<li><a
								href="${contextPath}/spring-mvc/search.htm?type=Solar Watch">Đồng
									hồ solar</a></li>
							<li><a
								href="${contextPath}/spring-mvc/search.htm?type=Hybrid Watch">Hybrid
									Watch</a></li>
						</ul>
					</div>
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
</html>

