<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="model.domain.Customer, java.util.ArrayList"%>
    <%-- jstl 사용하겠다는 설정 
    - 기본 jstl tag를 c라는 별칭으로 구분해서 사용하겠다는 설정
    --%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>jsp4JSTL.jsp</title>
</head>
<body>
	<h3>JSTL tag 학습</h3>
	<br><hr><br>
	
	<h5>[1] if 조건 tag : 단일 조건(else 표현법 없음)</h5>
	
	<%-- jstl 조건 tag --%>
	<c:if test="${ 2==2 }">
		1. 조건이 true인 경우 실행 <br>
	</c:if>
	
	<c:if test="${ 2!=2 }">
		2. 조건이 true인 경우 실행 <br>
	</c:if>
	
	<c:if test="${ 'a' != 'b'}">
		3. 조건이 true인 경우 실행 <br>
	</c:if>
	
	<br><hr><br>
	
	<h5>[2] when, choose 조건 tag : 다중 조건</h5>
	
	<c:choose>
		<c:when test="${'a' == 'b' }">
			'a' == 'b' <br>
		</c:when>
		
		<c:when test="${'a' == 'a' }">
			'a' == 'a' <br>
		</c:when>
		<c:otherwise>
			when tag 조건식들 모두 false 인 경우 실행 <br>
		</c:otherwise>
	</c:choose>
	
	
	<% 
	
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
	
	<br><hr><br>
	<h5>[3] java 데이터로 조건 검증</h5>
	<%-- user2001이 맞다면 pw 출력 --%>
	<c:if test="${sessionScope.sd3[0].id == 'user2001'}">
		1. id가 user2001 맞음 : ${sessionScope.sd3[0].pw}<br>
	</c:if>
	
	<br><hr><br>
	<h5>[4] 반복 tag</h5>
	 
	<c:forEach begin="1" end="5" var="data">
		${data}-
	</c:forEach>
	<%--
		for(int data=1; data <= 5; data++){
			out.println(data + "-");
		}
	 --%>
	
	<br><hr><br>
	<h5>[5] 반복 tag - c:forEach 와 list(배열)</h5>
	<c:forEach items="${sessionScope.sd3 }" var="data">
		${data.id}-${data.pw} <br>
	
	</c:forEach>
		
</body>
</html>