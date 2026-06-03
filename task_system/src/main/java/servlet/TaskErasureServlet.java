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

import model.entity.TaskBean;

/**
 * タスクの削除処理を制御する
 * @author 遠藤
 */
@WebServlet("/task-erasure")
public class TaskErasureServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public TaskErasureServlet() {
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

		// リクエストのエンコーディング方式を指定
		request.setCharacterEncoding("UTF-8");
		
		HttpSession session = request.getSession();
		boolean loginFlg = false;
		
		if(session != null && session.getAttribute("loginFlg") != null) {
			loginFlg = (boolean)session.getAttribute("loginFlg");
		} else {
			/* DO NOTHING */
		}
		
		if(loginFlg) {
			
			TaskBean task = new TaskBean();
			int deleteCnt = 0;

			try {

				//データベースアクセスオブジェクトの生成
				model.dao.TaskDAO dao = new model.dao.TaskDAO();

				//データベースアクセスオブジェクトの利用
				task.setTaskId(Integer.parseInt(request.getParameter("delete-task-id")));

				deleteCnt = dao.delete(task);

			} catch (SQLException | ClassNotFoundException e) {
				e.printStackTrace();
			}

			request.setAttribute("deleteTaskName", request.getParameter("delete-task-name"));

			boolean deleteError = false;

			if (deleteCnt == 1) {
				//転送先のパスを指定して転送処理用オブジェクトを取得
				RequestDispatcher rd = request.getRequestDispatcher("task-erasure-confirm");

				//リクエストの転送
				rd.forward(request, response);
			} else {
				deleteError = true;

				request.setAttribute("deleteError", deleteError);

				//転送先のパスを指定して転送処理用オブジェクトを取得
				RequestDispatcher rd = request.getRequestDispatcher("task-erasure-result.jsp");

				//リクエストの転送
				rd.forward(request, response);
			}
			
		}else {
			// リクエストの転送
			RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
			rd.forward(request, response);
		}

	}

}
