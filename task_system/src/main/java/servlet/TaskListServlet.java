package servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.dao.TaskDAO;
import model.entity.TaskBean;

/**
 * タスク一覧表示画面への遷移を制御
 * @author 篠田
 */
@WebServlet("/task-list-servlet")
public class TaskListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public TaskListServlet() {
		super();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		List<TaskBean> taskList = null;

		//taskDAOの利用
		TaskDAO dao = new TaskDAO();

		try {
			taskList = dao.selectAll();
		} catch (SQLException | ClassNotFoundException e) {
			e.getStackTrace();
		}

		request.setAttribute("taskList", taskList);

		//タスク一覧表示画面へリクエスト転送
		RequestDispatcher rd = request.getRequestDispatcher("task-list.jsp");
		rd.forward(request, response);
	}

}
