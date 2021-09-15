<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<link rel="stylesheet" type="text/css" href="../css/BackEnd.css" />
<link rel="stylesheet" type="text/css"
	href="../css/bootstrap-4.4.1-dist/css/bootstrap.min.css" />
<script type="text/javascript"
	src="../css/bootstrap-4.4.1-dist/js/bootstrap.bundle.min.js"></script>
<title>後台系統</title>
<style type="text/css">
</style>

</head>
<body>

	<div class="sidenav">
		<a class="logo" href="/manage/back.page" style="height:80px; font-size:30px; padding-left:60px;">Logo</a>

		<li><a href="/manage/product.page">餐點管理</a></li>
		<li><a href="/manage/order.page">訂單管理</a></li>
		<button class="dropdown-btn">
			銷量分析 <i class="fa fa-caret-down"></i>
		</button>
		<div class="dropdown-container">
			<li><a href="/manage/sales.page">網路訂餐</a></li>
			<li class="active"><a href="/manage/delivery.page">外送訂餐</a></li>
		</div>
		<li><a href="/manage/Preferential.page">優惠管理</a></li>
	</div>

	<div class="main">
		<div style="width:80%; padding-top:20px; border-bottom-style:solid ; border-bottom-width:20%; margin:auto;">
		<center>
			<h2>外送訂餐銷量分析</h2>
		</center>
		</div>
		<center>
			<p>內容</p>
		</center>
	</div>



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
</body>
</html>