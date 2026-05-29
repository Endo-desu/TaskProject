/*
 /* プロジェクト型演習
 * servlet.TaskAdditionServlet.java
 */
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
 * タスク登録処理を行うサーブレットクラスです。
 * セッションからタスク情報を取得し、DAOを呼び出してデータベースへの登録を実行します。
 * @author 坂爪
 */

/**
 * Servlet implementation class TaskAdditionServlet
 */
@WebServlet("/task-addition-servlet")
public class TaskAdditionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public TaskAdditionServlet() {
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

		// 文字コーディングを設定
		request.setCharacterEncoding("UTF-8");

		// セッションオブジェクトの取り出し
		HttpSession session = request.getSession();
		TaskBean task = (TaskBean) session.getAttribute("TaskBean");

		// DAO（データアクセスオブジェクト）の生成
		TaskDAO dao = new TaskDAO();

		int processingNumber = 0; // 処理件数を格納する変数を定義

		try {
			// taskBeanを引数に渡して、DBに登録
			processingNumber = dao.insert(task);

		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}

		// リクエストスコープへ設定
		request.setAttribute("TaskBean", task);

		// セッションデータの削除
		session.removeAttribute("TaskBean");

		// リクエストの転送
		RequestDispatcher rd = request.getRequestDispatcher("task-addition-result.jsp");
		rd.forward(request, response);
	}

}
