package step01;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

//http://ip:port/step13_Ajax/step02
@WebServlet("/step02")
public class Step02 extends HttpServlet {
	
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{
		System.out.println("Step02 doGet()");
		process(req, res);		
	}
	
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{
		System.out.println("Step02 doPost()");
		req.setCharacterEncoding("UTF-8");
		process(req, res);
	}
	
	public void process(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{

		JSONArray allEmp = new JSONArray();
		for(int i=0; i < 5 ; i++ ){
			JSONObject obj4 = new JSONObject();
			obj4.put("사번", "사원"+i);
			obj4.put("사원명", "이름"+i);
			obj4.put("급여", 1000+i);
			
			allEmp.add(obj4);
		}
		
		req.setAttribute("allEmp", allEmp); //[{"사번":"사원0","급여":1000,"사원명":"이름0"},{"사번":"사원1","급여":1001,"사원명":"이름1"},{"사번":"사원2","급여":1002,"사원명":"이름2"},{"사번":"사원3","급여":1003,"사원명":"이름3"},{"사번":"사원4","급여":1004,"사원명":"이름4"}]

		req.getRequestDispatcher("view.jsp").forward(req, res);
	}
	
}