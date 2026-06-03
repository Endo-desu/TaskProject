package servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.dao.TaskDAO;
import model.entity.TaskBean;

/**
 * タスク情報の結果画面への遷移を制御する
 * @author 板垣
 */
@WebServlet("/task-change-confirm-servlet")
public class TaskChangeConfirmServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public TaskChangeConfirmServlet() {
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

		// 文字コーディングを設定
		request.setCharacterEncoding("UTF-8");
		
		HttpSession session = request.getSession();
		boolean loginFlg = false;
		
		if(session != null && session.getAttribute("loginFlg") != null) {
			loginFlg = (boolean)session.getAttribute("loginFlg");
		} else {
			/* DO NOTHING */
		}
		
		if(loginFlg) {
			
			TaskDAO dao = new TaskDAO();
			TaskBean task = new TaskBean();

			try {
				task = dao.select(Integer.parseInt(request.getParameter("taskId")));
			} catch (ClassNotFoundException | SQLException e) {
				e.printStackTrace();
			}
			
			System.out.println(task.getLimitDate());
			
			request.setAttribute("TaskBean", task);

			// JSPへリクエストの転送
			RequestDispatcher rd = request.getRequestDispatcher("task-change-result.jsp");
			rd.forward(request, response);
			
		}else {
			// リクエストの転送
			RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
			rd.forward(request, response);
		}

	}

}