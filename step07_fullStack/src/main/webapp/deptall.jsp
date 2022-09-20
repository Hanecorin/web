<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
	System.out.println("deptall.jsp 실행 확인");
%>    
    
<!DOCTYPE html>
<html>
<head>

	<meta charset="UTF-8">
	<title>deptall.jsp</title>
	
	<link rel="stylesheet" href="css/style.css">
</head>

<body>
	<h3>모든 부서 정보 보기</h3>
	<br><hr><br>

<!-- #customers -->
<table id="depts">
  <tr>
    <th>부서번호</th>  <!--  table header의 약어 -->
    <th>부서명</th>
    <th>부서위치</th>
  </tr>
  
  	<c:forEach items="${requestScope.allDept}" var="dept">  		
  
		 <tr>
		    <td>${dept.deptno}</td>
		    <td>${dept.dname}</td>
		    <td>${dept.loc}</td>
		 </tr>
	  
	</c:forEach>
 
</table>


</body>
</html>


    