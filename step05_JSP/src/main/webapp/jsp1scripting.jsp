<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<%--  jsp 주석 --%>
	<!-- html 주석 -->
	<%!
		//servlet 객체수는 user수와 무관하게 only one
		//모든 client가 공유하는 변수
		// 멤버 변수 또는 메소드 구현 tag
		String msg = "멤버 문자열";
	
	%>
	<%= msg %> <br>
	<% 
		out.println(msg); //출력 내장 객체
		msg = "새로운 문자열"; //멤버 변수값 수정
		out.println(msg);
	%>

</body>
</html>

<%-- http://localhost:8080/step05_JSP/jsp1scripting.jsp --%>