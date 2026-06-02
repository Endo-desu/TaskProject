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
import model.entity.CategoryBean;
import model.entity.TaskBean;
import model.entity.UserBean;

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

		// リクエストのエンコーディング方式を指定
		request.setCharacterEncoding("UTF-8");

		int taskId = Integer.parseInt(request.getParameter("taskId"));
		String taskName = request.getParameter("taskName");
		String category = request.getParameter("categoryId");
		String limitDate = request.getParameter("date");
		String userName = request.getParameter("userId");
		String statusCode = request.getParameter("StatusCode");
		String memo = request.getParameter("memo");

		// 2. 取得したデータを新しく作った TaskBean にしっかり設定する
		TaskBean taskBean = new TaskBean();
		taskBean.setTaskName(taskName);
		taskBean.setCategoryId(Integer.parseInt(category));
		taskBean.setLimitDate(limitDate);
		taskBean.setUserId(userName);
		taskBean.setStatusCode(statusCode);
		taskBean.setMemo(memo);
		taskBean.setTaskId(taskId);

		UserBean userbean = new UserBean();
		userbean.setUserName(userName);

		CategoryBean categorybean = new CategoryBean();
		categorybean.setCategoryName(category);

		// エラー文章の格納リストの生成
		List<String> errors = new ArrayList<>();

		// 入力値のエラーチェック
		if (taskName == null || taskName.isEmpty()) {
			errors.add("タスク名は必須入力です。");
		} else if (taskName.length() > 20) {
			errors.add("タスク名は20文字以内で入力してください。");
		}

		if (memo != null && memo.length() > 100) {
			errors.add("メモは100文字以内で入力してください。");
		}

		// 3. エラー時の処理
		if (!errors.isEmpty()) {
			boolean changeError = true;
			// リクエストスコープに保存してエラー画面へ
			request.setAttribute("errors", errors);
			request.setAttribute("changeError", changeError);
			request.setAttribute("TaskBean", taskBean); // 新しいデータを画面に戻す

			RequestDispatcher rd = request.getRequestDispatcher("error.jsp");
			rd.forward(request, response);

			// 4. エラーがない場合の処理（ここで初めて安全にDBを更新する！）
		} else {

			// DAOの生成と利用
			TaskDAO dao = new TaskDAO();
			int processingNumber = 0; // 処理件数

			try {
				// ★ここが超重要！セッションの空のデータではなく、
				// 画面の値を詰め込んだ「taskBean」をDAOに渡してアップデートする！
				processingNumber = dao.update(taskBean);
			} catch (ClassNotFoundException | SQLException e) {
				e.printStackTrace();
			}

			// 結果画面で「1件更新しました」と表示できるようにリクエストに詰める
			request.setAttribute("processingNumber", processingNumber);

			// 更新した最新データを結果画面でも使えるようにセッションを上書き保存しておく
			HttpSession session = request.getSession();
			session.setAttribute("task", taskBean);

			// 結果画面（あるいは結果画面用サーブレット）へリクエストの転送
			// ※DB更新後はリダイレクト（sendRedirect）にするのが理想ですが、まずは動かすためにforwardのままとします
			RequestDispatcher rd = request.getRequestDispatcher("task-change-confirm-servlet");
			rd.forward(request, response);
		}
	}
}