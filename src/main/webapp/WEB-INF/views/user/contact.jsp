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
<link href="<c:url value="/resources/user/css/slider.css"/>"
	rel="stylesheet" type="text/css" media="all" />
<script type="text/javascript"
	src="<c:url value="/resources/user/js/jquery-1.7.2.min.js"/>"></script>
<script type="text/javascript"
	src="<c:url value="/resources/user/js/move-top.js"/>"></script>
<script type="text/javascript"
	src="<c:url value="/resources/user/js/easing.js"/>"></script>
</head>
<body style="background-image: linear-gradient(#020024,#0a0a5d)">
	<div class="wrap" style="padding: 0px 20px; background-color: #fff;">
		<jsp:include page="header.jsp"></jsp:include>
		<div class="main">
			<div class="content">
				<div class="section group">
					<div class="col span_2_of_3">
						<div class="contact-form">
							<h2>Liên lạc với chúng tôi</h2>
							<form>
								<div>
									<span><label>Họ và tên</label></span> <span><input
										type="text" class="textbox"></span>
								</div>
								<div>
									<span><label>E-mail</label></span> <span><input
										type="text" class="textbox"></span>
								</div>
								<div>
									<span><label>Vấn đề</label></span> <span><textarea> </textarea></span>
								</div>
								<div>
									<span><input type="submit" value="Submit"
										class="myButton"></span>
								</div>
							</form>
						</div>
					</div>
					<div class="col span_1_of_3">
						<div class="contact_info">
							<h3>Find Us Here</h3>
							<div class="map">
								<iframe width="100%" height="175" frameborder="0" scrolling="no"
									marginheight="0" marginwidth="0"
									src="https://maps.google.co.in/maps?f=q&amp;source=s_q&amp;hl=en&amp;geocode=&amp;q=Lighthouse+Point,+FL,+United+States&amp;aq=4&amp;oq=light&amp;sll=26.275636,-80.087265&amp;sspn=0.04941,0.104628&amp;ie=UTF8&amp;hq=&amp;hnear=Lighthouse+Point,+Broward,+Florida,+United+States&amp;t=m&amp;z=14&amp;ll=26.275636,-80.087265&amp;output=embed"></iframe>
								<br> <small><a
									href="https://maps.google.co.in/maps?f=q&amp;source=embed&amp;hl=en&amp;geocode=&amp;q=Lighthouse+Point,+FL,+United+States&amp;aq=4&amp;oq=light&amp;sll=26.275636,-80.087265&amp;sspn=0.04941,0.104628&amp;ie=UTF8&amp;hq=&amp;hnear=Lighthouse+Point,+Broward,+Florida,+United+States&amp;t=m&amp;z=14&amp;ll=26.275636,-80.087265"
									style="color: #666; text-align: left; font-size: 12px">View
										Larger Map</a></small>
							</div>
						</div>
						<div class="company_address">
							<h3>Thông tin về cửa hàng :</h3>
							<p>15 Hai Bà Trưng Hà Nội</p>
							<p>VN</p>
							<p>Phone:(00) 222 666 444</p>
							<p>Fax: (000) 000 00 00 0</p>
							<p>
								Email: <span><a href="mailto:@example.com">info@watchstore.com</a></span>
							</p>
							<p>
								Follow on: <span>Facebook</span>, <span>Twitter</span>
							</p>
						</div>
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

