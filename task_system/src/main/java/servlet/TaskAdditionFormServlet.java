/*
 * プロジェクト型演習
 * servlet.TaskAdditionFormServlet.java
 */
package servlet;

import java.io.IOException;

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
		// リクエストの転送
		RequestDispatcher rd = request.getRequestDispatcher("task-addition.jsp");
		rd.forward(request, response);
	}

}
