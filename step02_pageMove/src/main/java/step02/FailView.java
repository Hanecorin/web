package step02;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/fail")
public class FailView extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("FailView doGet()");

		response.setContentType("text/html;charset=utf-8");

		PrintWriter out = response.getWriter();
		
		out.println("무효한 회원입니다 <br>");
		out.println("<a href='step02/login.html'>main으로 이동</a>");

	}

}
