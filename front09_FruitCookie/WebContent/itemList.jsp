<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<c:import url="head.html"></c:import>
<table align='center' border="2">
	<tr>
		<c:forEach items="${list}" var="item">
			<td>
				<a href="itemView.do?itemnumber=${item.itemNumber}"><img alt="" src="${item.url}" width="150" height="150"></a><br/>
				상품명 : ${item.name}<br/>
				가  격 : ${item.price}
			</td>
		</c:forEach>
	</tr>
</table>

<c:if test="${!empty fruits}">
	<h3 align="center"><font color="purple">오늘 본 상품 정보</font></h3>
	<table align="center" bgcolor="lightgray">
		<tr>
			<c:forEach var="fruit" items="${fruits}">
				<td><img src="${fruit}" width="100" height="100"></td>
			</c:forEach>
		</tr>	
	</table>
</c:if>

</body>
</html>










