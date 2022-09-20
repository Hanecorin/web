package view;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/logout")
public class Logout extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Logout servlet");
		//step02 - 세션 소멸(삭제)
		
		HttpSession session = request.getSession();
		session.invalidate();
		session = null;
		
		
		//step01 - 쿠키 소멸
		//id/age값을 무효화 즉 client에 의미없는 데이터로 재전송
		
//		Cookie c1 = new Cookie("id", null);
//		Cookie c2 = new Cookie("age","");
//			
//		response.addCookie(c1);
//		response.addCookie(c2);
	}

}
