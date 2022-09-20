<%@page import="org.hibernate.internal.build.AllowSysOut"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="model.EmpDeptDAO"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<%
		EmpDeptDAO dao = EmpDeptDAO.getInstance();
		System.out.println(dao.findDept(10));

	%>

</body>
</html>