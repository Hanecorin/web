<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" session="false" %>
    <%-- session="false" : 이미 존재하는 session 삭제 --%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	로그아웃 되셨습니다
	<%
		System.out.println("logout.jsp의 session id");
	// System.out.println(session.getId()); 문법 에러 왜? session false이기 때문에 사용 불가
	%>

</body>
</html>