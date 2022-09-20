package view;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/succ")
public class SuccessView extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("SuccessView doGet");
		
		
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		//step02 - 세션 사용
		/* client별 고유한 세션 객체의 구분값인 id값을 client 몰래 client 시스템에 저장해 놓고
		 * 요청시마다 id값을 server가 받아서 비교 후 해당 id와 일치되는 세션 객체를 반환(제공)
		 */
		HttpSession session = request.getSession(); //이미 생성된 세션 객체
		System.out.println(session.getId());
		
		//세션에 데이터 저장
		out.println(session.getAttribute("msg"));
		
		
		
		//step01 - 쿠키 사용
		//쿠키 데이터 client 시스템으로 부터 획득 및 사용(id값 출력)
		/* Cookie의 getName() - key 반환
		 * Cookie의 getValue() - value 반환
		 * 
		 * Cookie c1 = new Cookie("id",id);
		 * 
		 */
//		Cookie [] all = request.getCookies();
//		
//		for(Cookie c : all) {
//			if(c.getName().equals("id")) {
//				out.println("당신의 id = " + c.getValue());
//			}else if(c.getName().equals("age")) {
//				out.println("당신의 age = " + c.getValue());
//			}
//		}
		
		//로그아웃 버튼 브라우에 출력
		out.println("<button onclick='location.href=\"logout\"'>로그아웃</button>");
		
		
	}

}
