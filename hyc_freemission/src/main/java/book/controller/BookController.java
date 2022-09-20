package book.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import book.model.dao.BookDAO;
import book.model.dto.BookDTO;




@WebServlet("/bc")
public class BookController extends HttpServlet {   
    public BookController() {
        super();

    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		process(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		process(request,response);
	}
	protected void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		String command = request.getParameter("command");
		
		try{
			if(command.equals("AllBooks")){//모든 book 정보 검색
				AllBooks(request, response);
			}
			else if(command.equals("OneBook")){//특정 재능 기부자 정보 검색
				OneBook(request, response);
			}
			else if(command.equals("addBook")) {
				AddBook(request, response);
			}
			else if(command.equals("bookDelete")) {
				bookDelete(request, response);
			}
		}catch(Exception s){
			request.setAttribute("errorMsg", s.getMessage());
			request.getRequestDispatcher("showError.jsp").forward(request, response);
			s.printStackTrace();
		}
	}



//모두 book 검색 메소드
	public void AllBooks(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "showError.jsp";
		try {
			request.setAttribute("AllBooks", BookDAO.getAllBooks());
			url = "bookList.jsp";
		}catch(Exception s){
			request.setAttribute("errorMsg", s.getMessage());
			s.printStackTrace();
		}
		request.getRequestDispatcher(url).forward(request, response);
	}
//하나의책검색
	public void OneBook(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "showError.jsp";
		try {
			request.setAttribute("OneBook", BookDAO.getBook(request.getParameter("bookNo")));
			url = "oneBook.jsp";
		}catch(Exception s){
			request.setAttribute("errorMsg", s.getMessage());
			s.printStackTrace();
		}
		request.getRequestDispatcher(url).forward(request, response);
	}
	//책 정보 추가
	protected void AddBook(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "showError.jsp";
		
		String bookNo = request.getParameter("bookNo");
		String bookName = request.getParameter("bookName");
		String writer = request.getParameter("writer");
		String publisher = request.getParameter("publisher");
		String inventory = request.getParameter("inventory");
		
		BookDTO book = new BookDTO(bookNo, bookName, writer, publisher, inventory);
		try{
			boolean result = BookDAO.addBook(book);
			if(result){
				request.setAttribute("book", book);
				request.setAttribute("successMsg", "정보등록완료");
				url = "addBook.jsp";
			}else{
				request.setAttribute("errorMsg", "다시 시도하세요");
			}
		}catch(Exception s){
			request.setAttribute("errorMsg", s.getMessage());
		}
		request.getRequestDispatcher(url).forward(request, response);
	}
	//책 정보 삭제
	public static void bookDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "showError.jsp";
		try {
			String bookNo= request.getParameter("bookNo");
			if(BookDAO.deleteBook(bookNo)) {
				request.setAttribute("AllBooks", BookDAO.getAllBooks());
				request.setAttribute("successMsg", "삭제완료");
				url = "deleteBook.jsp";
			}else {
				request.setAttribute("errorMsg", "다시 실행 해 주세요");
				}
		}catch(Exception s) {
			request.setAttribute("errorMsg", "진행중인 검색이 있습니다.");
		}
		request.getRequestDispatcher(url).forward(request, response);
	}
	
}