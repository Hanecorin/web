package step01;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//http://ip:port/context/A
@WebServlet("/A")
public class A extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("A doGet()");
	
		//B로 forward page이동 방식으로 이동
		//요청객체에 새로운 데이터 저장(장바구니에 물건 저장과 흡사)
		request.setAttribute("myname", "한예찬");
		//http://ip:port/context명/A -> http://ip:port/context명/B
		
		
		//forward
		//request.getRequestDispatcher("B").forward(request, response);
		
		//redirect
		response.sendRedirect("B");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("A doPost()");
		
		//B로 redirect page이동 방식으로 이동
	}

}
