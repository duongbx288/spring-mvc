<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>


<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8" />
        <meta http-equiv="X-UA-Compatible" content="IE=edge" />
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
        <meta name="description" content="" />
        <meta name="author" content="" />
        <title>Tables - SB Admin</title>
        <link href="<c:url value="/resources/admin/css/styles.css"/>" rel="stylesheet" type="text/css" media="all" />
        <link href="https://cdn.datatables.net/1.10.20/css/dataTables.bootstrap4.min.css" rel="stylesheet" crossorigin="anonymous" />
        <script src="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.1/js/all.min.js" crossorigin="anonymous"></script>
    </head>
    <body class="sb-nav-fixed">
       <jsp:include page="topnav.jsp"></jsp:include>
        <div id="layoutSidenav">
            <jsp:include page="leftnav.jsp"></jsp:include>
            <div id="layoutSidenav_content">
                <main>
                    <div class="container-fluid">
                        <h1 class="mt-4">Watchs</h1>
                        <ol class="breadcrumb mb-4">
                            <li class="breadcrumb-item"><a href="/spring-mvc/adminPage">Dashboard</a></li>
                            <li class="breadcrumb-item active">Watches</li>
                        </ol>
                        <div class="card mb-4">
                            <div class="card-body">
                               <form action="/spring-mvc/addWatch"><button>Thêm sản phẩm</button></form>
                               <form action="/spring-mvc/delWatch"><button>Xóa sản phẩm</button></form>
                            </div>
                        </div>
                        <div class="card mb-4">
                            <div class="card-header">
                                <i class="fas fa-table mr-1"></i>
                                Watch DataTable
                            </div>
                            <div class="card-body">
                                <div style="overflow: scroll;">
                                    <table class="table table-bordered" id="dataTable" width="130%" cellspacing="0">
                                        <thead>
                                            <tr>
                                                <th style="max-width: 55px;">WatchId</th>
                                                <th style="min-width: 150px;">Tên sản phẩm</th>
                                                <th>Giá</th>
                                                <th style="min-width: 150px;">Nhà sản xuất</th>
                                                <th>Năm sản xuất</th>
                                                <th style="min-width: 350px;">Thông tin</th>
                                                <th>Ảnh</th>
                                            </tr>
                                        </thead>
                                        <tbody>
                                       	 	<c:forEach var="item" items="${allWatch}">
	                                        	<tr>
	                                        		<td><div style="height:60px; overflow:hidden; max-width: 55px">${item.watch_id}</div></td>
	                                        		<td><div style="height:60px; overflow:hidden; min-width: 150px">${item.watch_name}</div></td>
	                                        		<td><div style="height:60px; overflow:hidden">${item.price}</div></td>
	                                        		<td><div style="height:60px; overflow:hidden; min-width: 150px;">${item.publisher}</div></td>
	                                        		<td><div style="height:60px; overflow:hidden">${item.year}</div></td>
	                                        		<td><div style="height:60px; overflow:scroll; min-width: 350px;">${item.intro}</div></td>
	                                        		<td>${item.image}</td>
	                                        	</tr>
                                        	</c:forEach>
                                        </tbody>
                                    </table>
                                </div>
                            </div>
                        </div>
                    </div>
                </main>
                <footer class="py-4 bg-light mt-auto">
                    <div class="container-fluid">
                        <div class="d-flex align-items-center justify-content-between small">
                            <div class="text-muted">Copyright &copy; Your Website 2020</div>
                            <div>
                                <a href="#">Privacy Policy</a>
                                &middot;
                                <a href="#">Terms &amp; Conditions</a>
                            </div>
                        </div>
                    </div>
                </footer>
            </div>
        </div>
        <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.bundle.min.js" crossorigin="anonymous"></script>
        <script type="text/javascript" src="<c:url value="/resources/admin/js/scripts.js"/>"></script>
        <script src="https://cdn.datatables.net/1.10.20/js/jquery.dataTables.min.js" crossorigin="anonymous"></script>
        <script src="https://cdn.datatables.net/1.10.20/js/dataTables.bootstrap4.min.js" crossorigin="anonymous"></script>
        <script type="text/javascript" src="<c:url value="/resources/admin/assets/demo/datatables-demo.js"/>"></script>
    </body>
</html>

