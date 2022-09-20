<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%
String url = application.getContextPath() + "/";
System.out.println(url);
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>삭제 완료</title>
</head>
<body>
	<br>
	<br>
	<br>
	<center>

		${requestScope.successMsg}

		<h3>책 정보를 삭제하였습니다.</h3>
		<hr>
		<p>
		<table border="1">
			<tr>
				<th>책 번호</th>
				<th>책 이름</th>
			</tr>
			<c:forEach items="${requestScope.AllBooks}" var="dataAll">
				<tr>
					<td>${dataAll.bookNo}</td>
					<td>${dataAll.bookName}</td>
					<td>${dataAll.writer}</td>
					<td>${dataAll.publisher}</td>
					<td>${dataAll.inventory}</td>

				</tr>
			</c:forEach>

		</table>

		<br> <br> <br> &nbsp;&nbsp;&nbsp;<a
			href="${pageContext.request.contextPath}/main.html">메인 화면 이동</a>

	</center>
</body>
</html>







