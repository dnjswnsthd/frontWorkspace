<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
</head>
<body>
<h1>Spring MVC Framework </h1><p>
 <a href="find.jsp" >회원 검색</a><br> 
 
 <c:choose>
 	<c:when test="${!empty vo}">
 		<a href="logout.do" >로그 아웃</a><br>
 		<a href="allmember.do" >전체 회원 보기</a><br>
 		<a href="update.jsp" >회원 정보 수정</a><br>
 	</c:when>
 	<c:otherwise>
 		<a href="login.jsp" >로그인 </a><br>
 		<a href="register.jsp" >회원 가입</a><br>
 	</c:otherwise> 
 </c:choose>
</body>
</html>




















