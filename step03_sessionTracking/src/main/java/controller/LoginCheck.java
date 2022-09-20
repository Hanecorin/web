package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/check")
public class LoginCheck extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("LoginCheck doPost");
		String id = request.getParameter("id");		
		String pw = request.getParameter("pw");
		
		if(id.equals("user") &  pw.equals("11")) {
			
			//step02 - 세션
			//세션 생성
			HttpSession session = request.getSession(); //생성
			System.out.println(session.getId());
			
			//세션에 데이터 저장
			session.setAttribute("msg", "playdata");
			session.setAttribute("name", "예찬");
			
			//step01 - 쿠키
//			//쿠키 생성 - key 와 value
//			Cookie c1 = new Cookie("id", id);
//			Cookie c2 = new Cookie("age","10");
//			
//			//쿠키의 잔존 시간 설정
//			c1.setMaxAge(06*60*24); //초단위
//			c1.setMaxAge(60*60*24*365); //초단위
//			
//			
//			//쿠키를 client 시스템에 응답해서 저장
//			
//			response.addCookie(c1);
//			response.addCookie(c2);
			
			
			
//			response.sendRedirect("succ");  //servlet으로 이동
			response.sendRedirect("success.jsp");  //jsp로 이동
		}else {
			response.sendRedirect("login.html"); 
		}
	}

}


