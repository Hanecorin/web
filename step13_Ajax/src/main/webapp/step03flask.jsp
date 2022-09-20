<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
	//동일한 도메인 서버가 아닌 다른 서버에서의 모든 요청 수락하는 설정
	response.setHeader("Access-Control-Allow-Origin", "*");
	//요청 확인을 위한 단순 출력
	System.out.println("요청 수락");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>step03flask.jsp</title>
</head>
<body>
	비동기로 flask 기반의 요청 수락 및 응답중....<br>
	<%--
	${param.msg}
	 --%>
	jsp의 EL tag를 활용한 출력 : ${param.msg}
</body>
</html>