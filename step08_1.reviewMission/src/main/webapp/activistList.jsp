<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 

<% String url = application.getContextPath() + "/"; %>
 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html> 
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>모든 Activist list 화면</title>
</head>
<body>
<br><br><br>
<center>  
<h3>재능 기부자 list</h3>
<hr><p>

<table border="1">
	<thead>
		<tr>
			<th>기부자 id</th><th>기부자 이름</th><th>주요 분야</th>
		</tr>
	</thead>
	
	<%--???
	 	모든 기부자 정보 보기 : 기부자 id를 클릭하면 "재능 기부자"상세 보기 로직이 실행되어야 함 --%>
	<c:forEach items="${requestScope.activistAll}" var="dataAll"> 
 		<tr>
 			<td><a href='${pageContext.request.contextPath}/probono?command=activist&activistId=${dataAll.id}'>${dataAll.id}</a></td>
 			<td>${dataAll.name}</td>
 			<td>${dataAll.major}</td>
 		</tr>
 	</c:forEach> 
</table>

<br><br><br>
<font color="blue">재능 기부자 id를 클릭하면 상세 정보 확인이 가능합니다</font>

</center>
</body>
</html>