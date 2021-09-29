<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE HTML>
<html>
<head>
<title>Shop bán đồng hồ</title>
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
	src="<c:url value="/resources/user/js/jquery.accordion.js"/>"></script>
<script type="text/javascript">
	$(document).ready(function() {
		$("#posts").accordion({
			header : "div.tab",
			alwaysOpen : false,
			autoheight : false
		});
	});
</script>
</head>
<body style="background-image: linear-gradient(#020024,#0a0a5d)">
	<div class="wrap" style="padding: 0px 20px; background-color: #fff;">
		<jsp:include page="header.jsp"></jsp:include>
		<div class="main">
			<div class="header_slide">
				<br>
				<br>
				<br>		
				
				<%for(int i = 0; i < 100; i+=4) { %> 
					<div class="section group">
					<c:forEach var="item" items="${allProduct}" begin="<%= i %>" end="<%= i+3 %>">
					<div class="grid_1_of_4 images_1_of_4" >
					<div class="hover_image">
						<a href="/spring-mvc/preview.htm?watchId=${item.watch_id}"><img width=200 height=250 src="<c:url value="${item.image}" />"
							alt="" /></a>
					</div>
						<h2>${item.watch_name}</h2>
						<div class="price-details">
							<div class="price-number">
								<p>
									<span style="font-size: 2em; color: red;" class="rupees">${item.price}đ</span>
								</p>
							</div>
							
							<div class="clear"></div>
						</div>
					</div>
				</c:forEach>	
				</div>
				<%}%>
				</div>
		</div>
	</div>
	<br>
	<br>
	<br>
	<br>
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

