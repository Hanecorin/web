package step01;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/playdata")


public class ServletTest extends HttpServlet{
	public ServletTest() {
		System.out.println("생성자-----");
	
	}
	
	protected void service(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {
		
		System.out.println("서버에 출력");
		
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		out.print("한글---???");
	}
}
