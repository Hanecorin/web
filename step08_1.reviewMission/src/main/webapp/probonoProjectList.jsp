<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 

<% 
	String url = application.getContextPath() + "/";
	System.out.println(url);
%>
 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html> 
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>모든 책 정보 화면</title>
</head>
<body>
<br><br><br>  
<center>
<h3>book list</h3>
<hr><p>

<table border="1">
	<tr>   
		<th>프로젝트 id</th><th>프로젝트명</th><th>재능기부자 id</th>
		<th>재능 수혜자  id</th><th>재능기부 내용</th>
	</tr>
	
	<!-- ???
		1. 모든 재능 기부 프로젝트 list 출력하기
		2. 재능 기부자 id 클릭하면 상세 보기 화면으로 이동
		3. 재능 수혜자 id 클릭하면 미완성 로직이기 때문에 blank 화면 
	 -->
	<c:forEach items="${requestScope.probonoProjectAll}" var="dataAll"> 
 		<tr>
 			<td>${dataAll.probonoProjectId}</td>
 			<td>${dataAll.probonoProjectName}</td>
 			<td><a href='${pageContext.request.contextPath}/probono?command=activist&activistId=${dataAll.activistId}'>${dataAll.activistId}</a></td>
 			<td><a href='${pageContext.request.contextPath}/probono?command=recipient&recipientId=${dataAll.receiveId}'>${dataAll.receiveId}</a></td>
 			<td>${dataAll.projectContent}</td>
 		</tr>
 	</c:forEach> 
</table>

<br><br><br>
<font color="blue">재능 기부자 id 및 재능 수혜자 id를 클릭하면 상세 정보 확인이 가능합니다</font>

</center>
</body>
</html>