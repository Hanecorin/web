package controlloer;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import DAO.BookDAO;

@WebServlet("/contr")
public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public Controller() {
		super();
	}

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");
		System.out.println("servie check");

		String command = request.getParameter("command");
		if (command.equals("getAllBooks")) {
			getAllBooks(request, response);
		} else {
			System.out.println("Fail");
		}
	}

	public void getAllBooks(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String url = "showError.jsp";
		try {
			request.setAttribute("getAllBooks", BookDAO.getAllBooks());
			url = "tableView.jsp";
		} catch (Exception s) {
			s.printStackTrace();
			request.setAttribute("errorMsg", s.getMessage());
		}
		request.getRequestDispatcher(url).forward(request, response);
	}
}
