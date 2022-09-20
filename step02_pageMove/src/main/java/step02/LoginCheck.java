package step02;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/encore/check")
//http://ip:port/context/encore/check
//http://localhost:8080/step02_pageMove/encore/check
//http://172.30.1.23:8080/step02_pageMove/encore/check
public class LoginCheck extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//입력 데이터 획득
		//web query string으로 전송된 데이터만 획득
		//url ? key1=value1 & key2=value2
		//url ? id=value1 & pw=value2
		//http://localhost:8080/step02_pageMove/encore/check?id=value1&pw=value2
		//단 post따라서 주소줄에 오픈되지 않은 상태로 은닉되어 서버에 전송
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		
		System.out.println(id+ " " + pw);
		
		// 검증 및 web page이동
		if(id.equals("user") & pw.equals("11")) {
			//요청 객체에 새로운 데이터 저장
			request.setAttribute("name", "재석");
			request.setAttribute("friend", "미주");
			
			//요청 객체가 손실되지 않게 다른 servlet으로 web page 이동	
			request.getRequestDispatcher("../succ").forward(request, response); //post 유지
		}else {
			//client에게 새로 접속할 url 정보만 제공
			//client는 현 접속된 url의 마지막 부분만 fail로 변환해서 재요청
			//http://172.30.1.23:8080/step02_pageMove/encore/check
			//http://172.30.1.23:8080/step02_pageMove/fail
			response.sendRedirect("../fail"); //get방식 (default)
		}
	}

}
