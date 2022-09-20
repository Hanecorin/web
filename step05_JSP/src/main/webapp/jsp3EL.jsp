<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" 
	import="model.domain.Customer, java.util.ArrayList" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>jsp3EL.jsp</title>
</head>
<body>
	<h3>EL 학습</h3>
	<br><hr><br>

	<h5>1. 연산식 학습</h5>
	<table border="1">
		<tr>
			<td>2+3</td>
			<td>${2+3}</td>
		</tr>
		<tr>
			<td>5/2</td>
			<td>${5/2}</td>
		</tr>
		<tr>
			<td>'a' == 'a'</td>
			<td>${'a' == 'a'}</td>
		</tr>
		<tr>
			<td>'a' == 'b'</td>
			<td>${'a' == 'b'}</td>
		</tr>
	</table>
	
	<br><hr><br>

	<h5>2. java 데이터를 출력하는 학습</h5>
	<% 
		//controller에서 데이터를 저장 하고 출력만 jsp에게 위임하는 구조라 생각
		//test 데이터 구성 
		//request와 session은 jsp에선 무조건 내장 객체 즉 이미 존재
		request.setAttribute("rd1", "1. 요청 데이터");
		request.setAttribute("rd2", new Customer("user01", 11));
		
		session.setAttribute("sd1", new Customer("user11", 22));
		
		Customer [] custs = {new Customer("user100", 22), 
							 new Customer("user101", 22)};
		
		ArrayList<Customer> allCusts = new ArrayList<>();
		allCusts.add(new Customer("user2001", 22));
		allCusts.add(new Customer("user2002", 22));
		allCusts.add(new Customer("user2003", 22));
		
		session.setAttribute("sd2", custs);
		session.setAttribute("sd3", allCusts);
			
	%>
	1. ${requestScope.rd1}  <br>
	2. ${requestScope.rd2.id}  <br> <%-- getId() 호출 --%>
	3. ${sessionScope.sd1.id}  <br> <%-- session의 sd1이라는 key에 매핑된 user11 출력 --%>
	4. ${sessionScope.sd2[0].id}  <br> <%-- 세션에 저장된 배열의 첫번째 고객의 id값만 출력 --%>
	5. ${sessionScope.sd3[1].id}  <br> <%-- user2002 --%>
	6. <%
		ArrayList<Customer> all = (ArrayList<Customer>)session.getAttribute("sd3");
		out.println(all.get(1).getId());
	%> <br>
	7. <%
		out.println( ( (ArrayList<Customer>)session.getAttribute("sd3") ).get(1).getId());
	%> <br>
	8. <%=  ( (ArrayList<Customer>)session.getAttribute("sd3") ).get(1).getId() %>
	
	
</body>
</html>

