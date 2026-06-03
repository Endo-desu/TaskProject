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
import javax.servlet.http.HttpSession;

import model.dao.CategoryDAO;
import model.dao.StatusDAO;
import model.dao.TaskDAO;
import model.dao.UserDAO;
import model.entity.CategoryBean;
import model.entity.StatusBean;
import model.entity.TaskBean;
import model.entity.UserBean;

/**
 * タスク情報の変更入力フォーム画面への遷移を制御する
 * @author 板垣
 */
@WebServlet("/task-change-form-servlet")
public class TaskChangeFormServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public TaskChangeFormServlet() {
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
		}
		
		if(loginFlg) {
			
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

			request.setAttribute("taskId", request.getParameter("taskId"));
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
			RequestDispatcher rd = request.getRequestDispatcher("task-change.jsp");
			rd.forward(request, response);

			
		}else {
			// リクエストの転送
			RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
			rd.forward(request, response);
		}
	}

}
