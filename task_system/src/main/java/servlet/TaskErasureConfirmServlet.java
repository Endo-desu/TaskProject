package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * タスクの削除完了画面への遷移を制御する
 * @author 遠藤
 */
@WebServlet("/task-erasure-confirm")
public class TaskErasureConfirmServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public TaskErasureConfirmServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		boolean loginFlg = false;
		
		if(session != null && session.getAttribute("loginFlg") != null) {
			loginFlg = (boolean)session.getAttribute("loginFlg");
		} else {
			/* DO NOTHING */
		}
		
		if(loginFlg) {
			
			// リクエストの転送
			RequestDispatcher rd = request.getRequestDispatcher("task-erasure-result.jsp");
			rd.forward(request, response);
			
		}else {
			// リクエストの転送
			RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
			rd.forward(request, response);
		}
	}

}
