package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.EmpDeptDAO;
import model.domain.entity.Dept;


@WebServlet("/com")
public class CompanyController extends HttpServlet {

	/* 1단계 : 어떤 요청인지 구분
	 * 2단계 : 요청에 맞게 로직 처리
	 * 
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//<input type="hidden" name="command" value="all">
		//<input type="hidden" name="command" value="deptone">
		String command = request.getParameter("command");
//		System.out.println(command);
		
		if(command != null) {
			EmpDeptDAO dao = EmpDeptDAO.getInstance();
			
			if(command.equals("deptone")) {
				String deptno = request.getParameter("search");
				
				if(deptno != null && deptno.length() != 0) {  // ""
					try {
						Dept dept = dao.findDept(Integer.parseInt(deptno));
						request.setAttribute("one", dept);
						request.getRequestDispatcher("deptview.jsp").forward(request, response);
					} catch (Exception e) {
						e.printStackTrace();
						
					}
				}
		
			}else if(command.equals("all")) {
				try {
					List<Dept> all = dao.findElementDept();
					
					request.setAttribute("allDept", all);
					request.getRequestDispatcher("deptall.jsp").forward(request, response);
					
				} catch (Exception e) {
					e.printStackTrace();
				}				
			}else { 
				
			}
		}else {
			
		}		
	}

}