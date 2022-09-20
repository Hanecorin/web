<%@ page contentType="text/html; charset=UTF-8" pageEncoding="utf-8"%>

<% 
		System.out.println("success.jsp");
		System.out.println(session.getId());
%>		



<%-- jsp에서의 내장 객체 따라서 session 변수 선언 없이 호출 가능 --%>
<%= session.getAttribute("msg") %>
		
		
		
<% 		 
//		Cookie [] all = request.getCookies();
//		
//		for(Cookie c : all) {
//			if(c.getName().equals("id")) {
//				out.println("ë¹ì ì id = " + c.getValue());
//			}else if(c.getName().equals("age")) {
//				out.println("ë¹ì ì age = " + c.getValue());
//			}
//		}
%>

<button onclick='location.href="logout.jsp"'>logout</button>
		
