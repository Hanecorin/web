package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



@WebServlet("/con")
public class Controller extends HttpServlet {
	
	//db의 데이터 검색해서 charView.jsp에게 데이터 제공한다 가정
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("==================");
		// ...
		request.setAttribute("chartData", "[['Task', 'Hours per Day'],['작업', 11], ['Eat',  2],['Commute',  2],['Watch TV', 2],['Sleep', 7]]");
		// ...
		
		request.getRequestDispatcher("chartView.jsp").forward(request, response);;
	}

}