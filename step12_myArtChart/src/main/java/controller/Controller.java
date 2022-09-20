package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/con")
public class Controller extends HttpServlet {

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("tableData","[\n"
				+ "          ['Mike',  {v: 10000, f: '$10,000'}, true],\n"
				+ "          ['Jim',   {v:8000,   f: '$8,000'},  false],\n"
				+ "          ['Alice', {v: 12500, f: '$12,500'}, true],\n"
				+ "          ['Bob',   {v: 7000,  f: '$7,000'},  true]\n"
				+ "        ]");
	
		request.getRequestDispatcher("chartView.jsp").forward(request, response);
	}

}
