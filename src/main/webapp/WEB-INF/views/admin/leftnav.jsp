<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<!DOCTYPE html>
<html lang="en">
<head>
</head>
<body class="sb-nav-fixed">
	<div id="layoutSidenav_nav">
		<nav class="sb-sidenav accordion sb-sidenav-dark"
			id="sidenavAccordion">
			<div class="sb-sidenav-menu">
				<div class="nav">
					<div class="sb-sidenav-menu-heading">Main</div>
					<a class="nav-link" href="/spring-mvc/adminPage">
						<div class="sb-nav-link-icon">
							<i class="fas fa-tachometer-alt"></i>
						</div> Trang chủ
					</a>
					<div class="sb-sidenav-menu-heading">Thống kê</div>
					<a class="nav-link" href="/spring-mvc/dataWatch">
						<div class="sb-nav-link-icon">
							<i class="fas fa-book-open"></i>
						</div> Sản phẩm
					</a> <a class="nav-link" href="/spring-mvc/bill">
						<div class="sb-nav-link-icon">
							<i class="fas fa-table"></i>
						</div> Hóa đơn
					</a> <a class="nav-link" href="/spring-mvc/dataBill">
						<div class="sb-nav-link-icon">
							<i class="fas fa-table"></i>
						</div> Chi tiết hóa đơn
					</a>

					<div class="sb-sidenav-menu-heading">Thêm</div>
					<a class="nav-link collapsed" href="#" data-toggle="collapse"
						data-target="#collapseLayouts" aria-expanded="false"
						aria-controls="collapseLayouts">
						<div class="sb-nav-link-icon">
							<i class="fas fa-book-open"></i>
						</div> Đồng hồ
						<div class="sb-sidenav-collapse-arrow">
							<i class="fas fa-angle-down"></i>
						</div>
					</a>
					<div class="collapse" id="collapseLayouts"
						aria-labelledby="headingOne" data-parent="#sidenavAccordion">
						<nav class="sb-sidenav-menu-nested nav">
							<a class="nav-link" href="/spring-mvc/addWatch">Thêm sản phẩm</a>
							<a class="nav-link" href="/spring-mvc/delWatch">Xóa thông tin</a>
							<a class="nav-link" href="/spring-mvc/chaWatch">Sửa thông tin</a>
						</nav>
					</div>
					<a class="nav-link collapsed" href="#" data-toggle="collapse"
						data-target="#collapseLayouts" aria-expanded="false"
						aria-controls="collapseLayouts">
						<div class="sb-nav-link-icon">
							<i class="fas fa-book-open"></i>
						</div> Thống kê
						<div class="sb-sidenav-collapse-arrow">
							<i class="fas fa-angle-down"></i>
						</div>
					</a>
					<div class="collapse" id="collapseLayouts"
						aria-labelledby="headingOne" data-parent="#sidenavAccordion">
						<nav class="sb-sidenav-menu-nested nav">
							<a class="nav-link" href="/spring-mvc/statistic">Sản phấm bán</a>
						</nav>
					</div>

				</div>
			</div>
			<div class="sb-sidenav-footer">
				<div class="small">Logged in as:</div>
				${sessionScope.logged.username}
			</div>
		</nav>
	</div>
</body>
</html>

