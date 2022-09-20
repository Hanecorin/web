package step01;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/formTest")
public class FormTagTest extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		//요청 객체에 한글 인코딩 처리
		request.setCharacterEncoding("UTF-8");
		
		System.out.println(request.getParameter("fav_language")); //radio
		
		System.out.println("*** 2. checkbox");
		//checkbox - 다중 선택
		String [] ck = request.getParameterValues("vehicle");
		if(ck != null) {
		for(String s : ck) {
			System.out.println(s);
		}
	}
		System.out.println("**** 3. color");
		System.out.println(request.getParameter("favcolor"));
		
		System.out.println("**** 4. Tel");
		System.out.println("**** 5. TextArea");
		System.out.println(request.getParameter("ta"));

		System.out.println("**** 6. select");
		System.out.println(request.getParameter("cars"));
	}
}
