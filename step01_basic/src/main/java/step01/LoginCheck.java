package step01;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/login")
public class LoginCheck extends HttpServlet {

	//http의 get 요청만 처리하는 메소드
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("doGet()");
		process(request, response);

	}
	//http의 post 요청만 처리하는 메소드
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("doPost()");
		process(request, response);
	}

	//사용자 정의 공통 로직의 메소드 추가 구현
	protected void process(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("process()");
		//응답시 html형식의 한글로 응답
		response.setContentType("text/html;charset=utf-8");
		
		//client가 입력한 id/pw값 뽑기
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		System.out.println(id + " " + pw);
		
		//접속된 브라우저에게만 출력
		PrintWriter out = response.getWriter();
		
		if(id.equals("user") && pw.equals("11")) {
			out.println("안녕하세요");
			
		}else {
			out.println("너 누구야..");
			
		}
		
		
	}

}
//검증 결과에 따른 분기문으로 응답