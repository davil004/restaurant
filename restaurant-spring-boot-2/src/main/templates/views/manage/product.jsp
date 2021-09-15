<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en" xmlns:layout="http://www.ultraq.net.nz/thymeleaf/layout"
	xmlns:th="http://www.thymeleaf.org">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<link rel="stylesheet" type="text/css" href="../css/main.css" />
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<link rel="stylesheet" type="text/css" href="../css/BackEnd.css" />
<link rel="stylesheet" type="text/css"
	href="../css/bootstrap-4.4.1-dist/css/bootstrap.min.css" />
<script type="text/javascript"
	src="../css/bootstrap-4.4.1-dist/js/bootstrap.bundle.min.js"></script>
<!-- Custom CSS -->
<link rel="stylesheet" href="style4.css">
<script type="text/javascript" src="font-awesome/js1/fontawesome.js"></script>
<script type="text/javascript" src=""></script>	
<title>後台系統</title>
<script type="text/javascript">
	function clearForm() {
		var inputs = document.getElementsByTagName("input");
		for (var i = 0; i < inputs.length; i++) {
			if (inputs[i].type == "text") {
				inputs[i].value = "";
			}
		}
	}
</script>
</head>
<body>
	<div class="sidenav">
		<a class="logo" href="/manage/back.page" style="height:80px; font-size:30px; padding-left:60px;">Logo</a>

		<li class="active"><a href="/manage/product.page">餐點管理</a></li>
		<li><a href="/manage/order.page">訂單管理</a></li>
		<button class="dropdown-btn">
			銷量分析 <i class="fa fa-caret-down"></i>
		</button>
		<div class="dropdown-container">
			<li><a href="/manage/sales.page">網路訂餐</a></li>
			<li><a href="/manage/delivery.page">外送訂餐</a></li>
		</div>
		<li><a href="/manage/Preferential.page">優惠管理</a></li>
	</div>

	<div class="main">

		<div style="width:80%; padding-top:20px; border-bottom-style:solid ; border-bottom-width:20%; margin:auto;">
		<center>
		<h2>餐點管理</h2>
		</center>
		</div>
		<center>
		<br>
		<form action="<c:url value="/manage/product.controller" />"
			method="get">
			<table>
				<tr>
					<td>ID :</td>
					<td><input type="text" name="id" value="${param.id}"></td>
					<td><span class="error">${errors.id}</span></td>
				</tr>
				<tr>
					<td>Name :</td>
					<td><input type="text" name="name" value="${param.name}"></td>
					<td></td>
				</tr>

				<tr>
					<td>Price :</td>
					<td><input type="text" name="price" value="${param.price}"></td>
					<td><span class="error">${errors.price}</span></td>
				</tr>
				<tr>
					<td>Make :</td>
					<td><input type="text" name="make" value="${param.make}"></td>
					<td><span class="error">${errors.make}</span></td>
				</tr>
				<tr>
					<td>Expire :</td>
					<td><input type="text" name="expire" value="${param.expire}"></td>
					<td><span class="error">${errors.expire}</span></td>
				</tr>
				<tr>
					<td><input type="submit" name="prodaction" value="Insert">
						<input type="submit" name="prodaction" value="Update"></td>
					<td><input type="submit" name="prodaction" value="Delete">
						<input type="submit" name="prodaction" value="Select"> <input
						type="button" value="Clear" onclick="clearForm()"></td>
				</tr>
			</table>
		</form>
		<h3>
			<span class="error">${errors.action}</span>
		</h3>
		</center>
		
		<div id="content">
			<nav th:fragment="sidebar" class="navbar navbar-expand-lg navbar-light"
				style="border-bottom: 4px solid #7386D5;">
				<div class="container-fluid">
					<button type="button" id="sidebarCollapse"
						class="btn btn-info mr-4">
						<i class="fas fa-align-left"></i>
						<!-- <span>Toggle Sidebar</span> -->
					</button>
					<form class="form-inline frm">
						<input class="form-control mr-sm-2" type="search"
							placeholder="Search" aria-label="Search">
						<button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
					</form>
					<button class="btn btn-light d-inline-block d-lg-none ml-auto"
						type="button" data-toggle="collapse"
						data-target="#navbarSupportedContent"
						aria-controls="navbarSupportedContent" aria-expanded="false"
						aria-label="Toggle navigation">
						<i class="fas fa-align-justify"></i>
					</button>
					<div class="collapse navbar-collapse" id="navbarSupportedContent">
						<ul class="nav navbar-nav ml-auto">
							<!-- <li class="nav-item"><a class="nav-link fl mr-4 btn btn-light" href="#">
									<i class="fa fa-shopping-cart" title="View Cart"
									style="color: red;"></i><span class="label">10</span>
							</a></li> -->
							<li class="nav-item  active"><a class="nav-link btn btn-light mr-2" th:href="@{/Admin/product}"
								>add Product</a></li>
							<li class="nav-item"><a onclick=" handleListProduct(event);" class="nav-link btn btn-light mr-2" href="#">Products</a></li>
							<li class="nav-item"><a class="nav-link btn btn-light" href="#"><i class="fas fa-sign-out-alt"></i></a></li>
						</ul>
					</div>
				</div>
			</nav>
			<div class="line"></div>
			<div class="container" id="app">
				
				 <div class="col-12">
            <h5 class="text-center">list of products</h5>
			<hr>
			<table class="table">
				<thead class="thead-dark">
					<tr>
						<th scope="col">image</th>
						<th scope="col">name</th>
						<th scope="col">description</th>
						<th scope="col">quantity</th>
						<th scope="col">price</th>
						<th scope="col">Discount</th>
						<th scope="col">delete product</th>
					</tr>
				</thead>
				<tbody>
					<tr th:each="product : ${products}">
						<th scope="row"><img alt="" th:src="*{'data:image/jpeg;base64,'+{product.image}}" style="width: 100px;height: 100px;"></th>
						<td>[[*{product.name}]] 
						<!-- Button trigger modal --> <br>
							<button type="button" class="btn btn-success btn-sm mt-2"
								data-toggle="modal"
								th:attr="data-target='#exampleModalCenter'+*{product.id}">change
								</button> <!-- Modal -->

							<div class="modal fade"
								th:id="*{'exampleModalCenter'+{product.id}}" tabindex="-1"
								role="dialog" aria-labelledby="exampleModalCenterTitle"
								aria-hidden="true">
								<div class="modal-dialog modal-dialog-centered" role="document">
									<div class="modal-content">
										<div class="modal-header">
											<h5 class="modal-title" id="exampleModalCenterTitle">change
												</h5>
											<button type="button" class="close" data-dismiss="modal"
												aria-label="Close">
												<span aria-hidden="true">&times;</span>
											</button>
										</div>
										<div class="modal-body">
											<form action="/Admin/changeName" method="post">
												<div class="form-group">
													 <input type="hidden"
														th:value="*{product.id}" class="form-control" name="id">
													<label>new Product name</label> <input type="text"
														name="newPname" class="form-control"> <br>
													<button type="submit" class="btn btn-primary">submit</button>
												</div>
											</form>

										</div>
									
									</div>
								</div>
							</div>

						</td>
						<td>[[*{product.description}]] <!-- Button trigger modal -->
							<br>
							<button type="button" class="btn btn-success btn-sm mt-2"
								data-toggle="modal"
								th:attr="data-target='#exampleModalCenterDesc'+${product.id}">change
								</button> <!-- Modal -->
							<div class="modal fade"
								th:id="*{'exampleModalCenterDesc'+{product.id}}" tabindex="-1"
								role="dialog" aria-labelledby="exampleModalCenterTitle"
								aria-hidden="true">
								<div class="modal-dialog modal-dialog-centered" role="document">
									<div class="modal-content">
										<div class="modal-header">
											<h5 class="modal-title" id="exampleModalCenterTitle">change
												product description</h5>
											<button type="button" class="close" data-dismiss="modal"
												aria-label="Close">
												<span aria-hidden="true">&times;</span>
											</button>
										</div>
										<div class="modal-body">

											<form action="/Admin/changeDescription" method="post">
												<div class="form-group">
												 <input type="text"  hidden="hidden"
														th:value="*{product.id}" class="form-control" name="id">
													<label>new Product description</label> <textarea rows="2"
														name="newDescription" class="form-control"></textarea> <br>
													<button type="submit" class="btn btn-primary">submit</button>
												</div>
											</form>
										</div>
										
									</div>
								</div>
							</div>
						</td>
						<td>[[*{product.quantity}]] <!-- Button trigger modal --> <br>
							<button type="button" class="btn btn-success btn-sm mt-2"
								data-toggle="modal"
								th:attr="data-target='#exampleModalCenterquantity'+${product.id}">change
								</button> <!-- Modal -->
							<div class="modal fade"
								th:id="*{'exampleModalCenterquantity'+{product.id}}" tabindex="-1"
								role="dialog" aria-labelledby="exampleModalCenterTitle"
								aria-hidden="true">
								<div class="modal-dialog modal-dialog-centered" role="document">
									<div class="modal-content">
										<div class="modal-header">
											<h5 class="modal-title" id="exampleModalCenterTitle">change
												product quantity</h5>
											<button type="button" class="close" data-dismiss="modal"
												aria-label="Close">
												<span aria-hidden="true">&times;</span>
											</button>
										</div>
										<div class="modal-body">

											<form action="/Admin/changeQuantity" method="post">
												<div class="form-group">
													 <input type="text" hidden="hidden"
														th:value="*{product.id}" class="form-control" name="id">
													<label>new Product quantity</label> <input type="number" th:value="${product.quantity}"
														name="newQuantity" class="form-control"> <br>
													<button type="submit" class="btn btn-primary">submit</button>
												</div>
											</form>
										</div>
										
									</div>
								</div>
							</div>
						</td>
						
						<td>[[*{product.price}]]$<!-- Button trigger modal --> <br>
							<button type="button" class="btn btn-success btn-sm mt-2"
								data-toggle="modal"
								th:attr="data-target='#exampleModalCenterPrice'+${product.id}">change
								</button> <!-- Modal -->
							<div class="modal fade"
								th:id="*{'exampleModalCenterPrice'+{product.id}}" tabindex="-1"
								role="dialog" aria-labelledby="exampleModalCenterTitle"
								aria-hidden="true">
								<div class="modal-dialog modal-dialog-centered" role="document">
									<div class="modal-content">
										<div class="modal-header">
											<h5 class="modal-title" id="exampleModalCenterTitle">change
												product price</h5>
											<button type="button" class="close" data-dismiss="modal"
												aria-label="Close">
												<span aria-hidden="true">&times;</span>
											</button>
										</div>
										<div class="modal-body">

											<form action="/Admin/changePrice" method="post">
												<div class="form-group">
													 <input type="text" hidden="hidden"
														th:value="*{product.id}" class="form-control" name="id">
													<label>new Product price</label> <input type="text"
														name="newPrice" class="form-control"> <br>
													<button type="submit" class="btn btn-primary">submit</button>
												</div>
											</form>
										</div>
										
									</div>
								</div>
							</div>
						</td>
						
						<td>-[[*{product.discount.discount}]]%<!-- Button trigger modal --> <br>
							<button type="button" class="btn btn-success btn-sm mt-2"
								data-toggle="modal"
								th:attr="data-target='#exampleModalCenterDiscount'+${product.id}">change
								</button> <!-- Modal -->
							<div class="modal fade"
								th:id="*{'exampleModalCenterDiscount'+{product.id}}" tabindex="-1"
								role="dialog" aria-labelledby="exampleModalCenterTitle"
								aria-hidden="true">
								<div class="modal-dialog modal-dialog-centered" role="document">
									<div class="modal-content">
										<div class="modal-header">
											<h5 class="modal-title" id="exampleModalCenterTitle">change
												product discount</h5>
											<button type="button" class="close" data-dismiss="modal"
												aria-label="Close">
												<span aria-hidden="true">&times;</span>
											</button>
										</div>
										<div class="modal-body">

											<form action="/Admin/changeDiscount" method="post">
												<div class="form-group">
													 <input type="text" hidden="hidden"
														th:value="*{product.id}" class="form-control" name="id">
													<label>new Product Discount</label> <input type="number" th:value="${product.discount.discount}"
														min="0" max="75" name="newDiscount" class="form-control"> <br>
													<button type="submit" class="btn btn-primary">submit</button>
												</div>
											</form>
										</div>
										
									</div>
								</div>
							</div>
						</td>
						<td><a th:href="@{/Admin/deleteProd/{id}(id=${product.id})}"
							class="btn btn-danger btn-sm mt-4">delete</a></td>
					</tr>
				</tbody>
			</table>
			<hr>
		</div>
				
			 </div>
			<div class="line"></div>
		</div>
	</div>
<!-- Bootstrap JS & jQuery -->
	<script src="script/jquery-3.1.1.min.js"></script>
	<script src="script/bootstrap.js"></script>
	<!-- Popper.JS -->
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.0/umd/popper.min.js"
		integrity="sha384-cs/chFZiN24E4KMATLdqdvsezGxaGsi4hLGOzlXwp5UZB1LY//20VyM2taTB4QvJ"
		crossorigin="anonymous"></script>
	<script type="text/javascript" src="api/ajaxFetch.js"></script>
<script type="text/javascript">
		$(document).ready(function() {
			$('#sidebarCollapse').on('click', function() {
				$('#sidebar').toggleClass('active');
			});
		});
	</script>
<script type="text/javascript">
		var dropdown = document.getElementsByClassName("dropdown-btn");
		var i;

		for (i = 0; i < dropdown.length; i++) {
			dropdown[i].addEventListener("click", function() {
				this.classList.toggle("active");
				var dropdownContent = this.nextElementSibling;
				if (dropdownContent.style.display === "block") {
					dropdownContent.style.display = "none";
				} else {
					dropdownContent.style.display = "block";
				}
			});
		}
	</script>


	<c:if test="${not empty delete}">
		<h3>Delete Product Table Success : ${delete} row deleted</h3>
		<script type="text/javascript">
			clearForm();
		</script>
	</c:if>

	<c:if test="${not empty insert}">
		<h3>Insert Product Table Success</h3>
		<table border="1">
			<tr>
				<td>Id</td>
				<td>${insert.id}</td>
			</tr>
			<tr>
				<td>Name</td>
				<td>${insert.name}</td>
			</tr>
			<tr>
				<td>Price</td>
				<td>${insert.price}</td>
			</tr>
			<tr>
				<td>Make</td>
				<td>${insert.make}</td>
			</tr>
			<tr>
				<td>Expire</td>
				<td>${insert.expire}</td>
			</tr>
		</table>
		<script type="text/javascript">
			clearForm();
		</script>
	</c:if>

	<c:if test="${not empty update}">
		<h3>Update Product Table Success</h3>
		<table border="1">
			<tr>
				<td>Id</td>
				<td>${update.id}</td>
			</tr>
			<tr>
				<td>Name</td>
				<td>${update.name}</td>
			</tr>
			<tr>
				<td>Price</td>
				<td>${update.price}</td>
			</tr>
			<tr>
				<td>Make</td>
				<td>${update.make}</td>
			</tr>
			<tr>
				<td>Expire</td>
				<td>${update.expire}</td>
			</tr>
		</table>
		<script type="text/javascript">
			clearForm();
		</script>
	</c:if>

</body>
</html>