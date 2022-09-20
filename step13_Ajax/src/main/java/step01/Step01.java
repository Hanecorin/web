package step01;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//http://ip:port/step13_Ajax/step01
@WebServlet("/step01")
public class Step01 extends HttpServlet {
	
	public void doGet(HttpServletRequest req, HttpServletResponse res) 
			throws ServletException, IOException{
		System.out.println("Step01 doGet()");
		
		dataPrint(req, res);		
	}

	
	public void doPost(HttpServletRequest req, HttpServletResponse res) 
			throws ServletException, IOException{
		System.out.println("Step01 doPost()");
		
		req.setCharacterEncoding("UTF-8");
		
		dataPrint(req, res);
	}
	
	public void dataPrint(HttpServletRequest req, HttpServletResponse res) 
			throws ServletException, IOException{
		
		res.setContentType("text/html;charset=UTF-8");
		PrintWriter out = res.getWriter();
		
		out.println("재석 " + req.getParameter("name"));
		
	}
	
}