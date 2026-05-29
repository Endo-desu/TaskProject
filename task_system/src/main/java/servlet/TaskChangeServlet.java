package servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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
 * タスク情報の変更処理を制御する
 * @author 板垣
 */
@WebServlet("/task-change-servlet")
public class TaskChangeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public TaskChangeServlet() {
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
		// セッションオブジェクトの取得
		HttpSession session = request.getSession();

		// セッションスコープからの属性値の取得
		TaskBean task = (TaskBean) session.getAttribute("task");

		// DAOの生成
		TaskDAO dao = new TaskDAO();

		int processingNumber = 0; //処理件数

		try {
			// DAOの利用
			processingNumber = dao.update(task);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}

		// リクエストスコープへの属性の設定
		request.setAttribute("processingNumber", processingNumber);

		// 入力画面（JSP）からのデータの取得）
		String taskName = request.getParameter("taskName");
		String category = request.getParameter("categoryId");
		String limitDate = request.getParameter("updateDate");
		String userName = request.getParameter("userId");
		String statusCode = request.getParameter("statusCode");
		String memo = request.getParameter("memo");

		// 取得したデータをTaskBeanに設定
		TaskBean taskBean = new TaskBean();
		taskBean.setTaskName(taskName);
		taskBean.setCategoryName(category);
		taskBean.setLimitDate(limitDate);
		taskBean.setUserName(userName);
		taskBean.setStatusName(statusCode);
		taskBean.setMemo(memo);

		// エラー文章の格納リストの生成
		List<String> errors = new ArrayList<>();

		// boolean型の変数
		boolean changeError = false;

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
			changeError = true;
			// リクエストスコープに保存
			request.setAttribute("errors", errors);
			request.setAttribute("changeError", changeError);
			request.setAttribute("TaskBean", task);

			// JSPへリクエストの転送
			RequestDispatcher rd = request.getRequestDispatcher("error.jsp");
			rd.forward(request, response);

			// エラーがない場合の処理
		} else {
			session.setAttribute("TaskBean", task);

			// JSPへリクエストの転送
			RequestDispatcher rd = request.getRequestDispatcher("task-change-confirm-servlet");
			rd.forward(request, response);
		}

	}

}
