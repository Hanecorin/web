package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.EmpDeptDAO;
import model.domain.entity.Dept;

@WebServlet("/con")
public class Controller extends HttpServlet {

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String command = request.getParameter("command");
		request.setAttribute("tableData","command");
	
		request.getRequestDispatcher("chartView.jsp").forward(request, response);
	
	
	
		//<input type="hidden" name="command" value="all">
		//<input type="hidden" name="command" value="deptone">
		
//		System.out.println(command);
		
		if(command != null) {
			EmpDeptDAO dao = EmpDeptDAO.getInstance();
			
			if(command.equals("deptone")) {
				String deptno = request.getParameter("search");
				
				if(deptno != null && deptno.length() != 0) {  // ""
					try {
						Dept dept = dao.findDept(Integer.parseInt(deptno));
						request.setAttribute("one", dept);
						request.getRequestDispatcher("chartView.jsp").forward(request, response);
					} catch (Exception e) {
						e.printStackTrace();
						
					}
				}
		
			}else if(command.equals("all")) {
				try {
					List<Dept> all = dao.findElementDept();
					
					request.setAttribute("allDept", all);
					request.getRequestDispatcher("chartView.jsp").forward(request, response);
					
				} catch (Exception e) {
					e.printStackTrace();
				}				
			}else { 
				
			}
		}else {
			
		}		
	
	
	}
	
	
}
