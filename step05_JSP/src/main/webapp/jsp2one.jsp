<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <% System.out.println("jsp2one.jsp"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	jsp2one.jsp start <br>
	
	------------ <br>
	
	<%-- 동일
	 request.getRequestDispatcher("jsp2two.jsp").forward(request,response); 
	--%>
	<%-- <jsp:forward page= "jsp2two.jsp" /> --%>
	
	<%-- 동일
	 request.getRequestDispatcher("jsp2two.jsp").forward(request,response); 
	--%>
	<jsp:include page="jsp2two.jsp"/>
	
	
	------------ <br>
 	jsp2one.jsp end
	
</body>
</html>