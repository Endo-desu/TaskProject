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
import javax.servlet.http.HttpSession;

import model.dao.CategoryDAO;
import model.dao.StatusDAO;
import model.dao.UserDAO;
import model.entity.CategoryBean;
import model.entity.StatusBean;
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
		
		HttpSession session = request.getSession();
		boolean loginFlg = false;
		
		if(session.getAttribute("loginFlg") != null) {
			loginFlg = (boolean)session.getAttribute("loginFlg");
		} else {
			/* DO NOTHING */
		}
		
		if(loginFlg) {
			
			UserDAO userDao = new UserDAO();
			CategoryDAO categoryDao = new CategoryDAO();
			StatusDAO statusDao = new StatusDAO();

			List<UserBean> userList = null;
			List<CategoryBean> categoryList = null;
			List<StatusBean> statusList = null;

			try {
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

			request.setAttribute("userList", userList);
			request.setAttribute("categoryList", categoryList);
			request.setAttribute("statusList", statusList);

			// リクエストの転送
			RequestDispatcher rd = request.getRequestDispatcher("task-addition.jsp");
			rd.forward(request, response);
			
		}else {
			// リクエストの転送
			RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
			rd.forward(request, response);
		}
	}

}
