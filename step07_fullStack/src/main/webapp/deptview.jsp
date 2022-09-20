<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>deptview.jsp</title>
</head>
<body>

	<h3>하나의 부서 정보 보기</h3>
	<br><hr><br>
	부서번호 : ${requestScope.one.deptno} <br>
	부서명 : ${requestScope.one.dname} <br>
	부서위치 : ${requestScope.one.loc} <br>
</body>
</html>