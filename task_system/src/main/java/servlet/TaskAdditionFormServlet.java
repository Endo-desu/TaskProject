/*
 * プロジェクト型演習
 * servlet.TaskAdditionFormServlet.java
 */
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
/**
 * タスク登録画面への遷移を行うサーブレットクラスです。
 * メニュー画面からのリクエストを受け取り、画面を転送します。
 * @author 坂爪
 */

import model.dao.CategoryDAO;
import model.dao.StatusDAO;
import model.dao.TaskDAO;
import model.dao.UserDAO;
import model.entity.CategoryBean;
import model.entity.StatusBean;
import model.entity.TaskBean;
import model.entity.UserBean;

/**
 * Servlet implementation class TaskAdditionFormServlet
 */
@WebServlet("/task-addition-form-servlet")
public class TaskAdditionFormServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public TaskAdditionFormServlet() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// リクエストのエンコーディング方式を指定
		request.setCharacterEncoding("UTF-8");

		TaskDAO taskDAO = new TaskDAO();
		UserDAO userDao = new UserDAO();
		CategoryDAO categoryDao = new CategoryDAO();
		StatusDAO statusDao = new StatusDAO();

		List<TaskBean> taskList = null;
		List<UserBean> userList = null;
		List<CategoryBean> categoryList = null;
		List<StatusBean> statusList = null;

		try {
			taskList = taskDAO.selectAll();
			userList = userDao.selectAll();
			categoryList = categoryDao.selectAll();
			statusList = statusDao.selectAll();
		} catch (ClassNotFoundException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}

		request.setAttribute("taskName", request.getParameter("taskName"));
		request.setAttribute("categoryName", request.getParameter("categoryName"));
		request.setAttribute("limitDate", request.getParameter("limitDate"));
		request.setAttribute("userName", request.getParameter("userName"));
		request.setAttribute("statusName", request.getParameter("statusName"));
		request.setAttribute("memo", request.getParameter("memo"));
		request.setAttribute("taskList", taskList);
		request.setAttribute("userList", userList);
		request.setAttribute("categoryList", categoryList);
		request.setAttribute("statusList", statusList);

		// リクエストの転送
		RequestDispatcher rd = request.getRequestDispatcher("task-addition.jsp");
		rd.forward(request, response);
	}

}
