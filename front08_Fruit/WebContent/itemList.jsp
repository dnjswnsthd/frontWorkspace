<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
<script
	src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>
	
</head>
<body>
	<div class="container">
		<div class="jumbotron text-center">
			<h1>Fruit Total List</h1>
		</div>
		<table align="center" border="2px">
			<tr>
				<c:forEach var="item" items="${list}">
					<td>
						<a href="itemView.do?itemnuber=${item.itemNumber}"><img alt="" src="${item.url}" width="150", height="150"></a><br>
						상품명: ${item.name}<br>
						가 격 : ${item.price}<br>
					</td>
				</c:forEach>				
			</tr>
		</table>
	</div>
</body>
</html>