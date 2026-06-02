/*
 * プロジェクト型演習
 * servlet.TaskAdditionConfirmServlet.java
 */
package servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.entity.TaskBean;

/**
 * タスク登録の入力チェックを行うサーブレットクラスです。
 * エラーがある場合はエラー画面へ、正常な場合はセッションに値を保持して登録実行サーブレットへフォワードします。
 * @author 坂爪
 */

/**
 * Servlet implementation class TaskAdditionConfirmServlet
 */
@WebServlet("/task-addition-confirm-servlet")
public class TaskAdditionConfirmServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public TaskAdditionConfirmServlet() {
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

		// 入力画面（JSP）からのデータの取得）
		String taskName = request.getParameter("taskName");
		String category = request.getParameter("categoryId");
		String limitDate = request.getParameter("updateDate");
		String userName = request.getParameter("userId");
		String statusCode = request.getParameter("statusCode");
		String memo = request.getParameter("memo");

		// 取得したデータをTaskBeanに設定
		TaskBean task = new TaskBean();
		task.setTaskName(taskName);
		task.setCategoryName(category);
		task.setLimitDate(limitDate);
		task.setUserName(userName);
		task.setStatusName(statusCode);
		task.setMemo(memo);

		// エラー文章の格納リストの生成
		List<String> errors = new ArrayList<>();

		// boolean型の変数
		boolean hasError = false;

		// 入力値のエラーチェック
		if (taskName == null || taskName.isEmpty()) {
			errors.add("タスク名は必須入力です。");
		} else if (taskName.length() > 20) {
			errors.add("タスク名は20文字以内で入力してください。");
		}

		if (memo != null && memo.length() > 100) {
			errors.add("メモは100文字以内で入力してください。");
		}

		// エラー時の処理
		if (!errors.isEmpty()) {
			hasError = true;
			// リクエストスコープに保存
			request.setAttribute("errors", errors);
			request.setAttribute("hasError", hasError);
			request.setAttribute("TaskBean", task);

			// JSPへリクエストの転送
			RequestDispatcher rd = request.getRequestDispatcher("error.jsp");
			rd.forward(request, response);

			// エラーがない場合の処理
		} else {
			// セッションに保存
			HttpSession session = request.getSession();
			session.setAttribute("TaskBean", task);

			// JSPへリクエストの転送
			RequestDispatcher rd = request.getRequestDispatcher("task-addition-result.jsp");
			rd.forward(request, response);
		}
	}
}