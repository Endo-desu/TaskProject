package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.entity.TaskBean;

public class TaskDAO {

	/**
	 * 登録済みのタスク情報を全件抽出します
	 * @return タスク情報
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
	public List<TaskBean> selectAll()
			throws SQLException, ClassNotFoundException {

		List<TaskBean> taskList = new ArrayList<TaskBean>();

		String sql = "SELECT t.task_id, "
				+ "t.task_name, "
				+ "c.category_name, "
				+ "t.limit_date, "
				+ "u.user_name, "
				+ "s.status_name, "
				+ "t.memo"
				+ " FROM "
				+ "t_task t "
				+ "JOIN m_user u "
				+ "ON t.user_id = u.user_id "
				+ "JOIN m_category c "
				+ "ON t.category_id = c.category_id "
				+ "JOIN m_status s "
				+ "ON t.status_code = s.status_code ";

		// データベースへの接続の取得、更新系SQLステートメントの実行
		try (Connection con = ConnectionManager.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql);
				ResultSet res = pstmt.executeQuery()) {

			while (res.next()) {

				int taskId = res.getInt("task_id");
				String taskName = res.getString("task_name");
				String categoryName = res.getString("category_name");
				String limitDate = res.getString("limit_date");
				String manager = res.getString("user_name");
				String status = res.getString("status_name");
				String memo = res.getString("memo");

				//リストに入力値を格納
				TaskBean task = new TaskBean();
				task.setTaskId(taskId);
				task.setTaskName(taskName);
				task.setCategoryName(categoryName);
				task.setLimitDate(limitDate);
				task.setUserName(manager);
				task.setStatusName(status);
				task.setMemo(memo);

				taskList.add(task);
			}
		}
		return taskList;
	}

	/**
	 * 登録済みのタスク情報を1件抽出します
	 * @return タスク情報
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
	public TaskBean select(int taskId)
			throws SQLException, ClassNotFoundException {

		TaskBean task = null;

		String sql = "SELECT t.task_id, "
				+ "t.task_name, "
				+ "c.category_id, "
				+ "c.category_name, "
				+ "t.limit_date, "
				+ "u.user_id, "
				+ "u.user_name, "
				+ "s.status_code, "
				+ "s.status_name, "
				+ "t.memo"
				+ " FROM "
				+ "t_task t "
				+ "JOIN m_user u "
				+ "ON t.user_id = u.user_id "
				+ "JOIN m_category c "
				+ "ON t.category_id = c.category_id "
				+ "JOIN m_status s "
				+ "ON t.status_code = s.status_code "
				+ "WHERE t.task_id = ?";

		// データベースへの接続の取得、更新系SQLステートメントの実行
		try (Connection con = ConnectionManager.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql);) {

			pstmt.setInt(1, taskId);

			ResultSet res = pstmt.executeQuery();

			if (res.next()) {

				taskId = res.getInt("task_id");
				String taskName = res.getString("task_name");
				int categoryId = res.getInt("category_id");
				String categoryName = res.getString("category_name");
				String limitDate = res.getString("limit_date");
				String userId = res.getString("user_id");
				String userName = res.getString("user_name");
				String statusCode = res.getString("status_code");
				String statusName = res.getString("status_name");
				String memo = res.getString("memo");

				//リストに入力値を格納
				task = new TaskBean();
				task.setTaskId(taskId);
				task.setTaskName(taskName);
				task.setCategoryId(categoryId);
				task.setCategoryName(categoryName);
				task.setLimitDate(limitDate);
				task.setUserId(userId);
				task.setUserName(userName);
				task.setStatusCode(statusCode);
				task.setStatusName(statusName);
				task.setMemo(memo);

			} else {
				/* DO NOTHING */
			}
		}
		return task;
	}

	/**
	 * タスクを登録します。
	 * @param task タスクオブジェクト
	 * @return 処理件数
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
	public int insert(TaskBean task) throws SQLException, ClassNotFoundException {

		int count = 0; // 処理件数
		int newTaskId = 0;// タスクID

		String insertsql = "INSERT INTO t_task(task_name, category_id, limit_date, user_id, status_code, memo) VALUES(?, ?, ?, ?, ?, ?)";

		String selectsql = "SELECT t.task_name, c.category_name, t.limit_date, u.user_name, s.status_name, t.memo "
				+ "FROM t_task t "
				+ "JOIN m_user u ON t.user_id = u.user_id "
				+ "JOIN m_category c ON t.category_id = c.category_id "
				+ "JOIN m_status s ON t.status_code = s.status_code "
				+ "WHERE t.task_id = ?";

		// データベースへの接続の取得、PreparedStatementの取得
		try (Connection con = ConnectionManager.getConnection();
				PreparedStatement pstmt = con.prepareStatement(insertsql, java.sql.Statement.RETURN_GENERATED_KEYS)) {

			// DTOからのデータの取り出し
			String taskName = task.getTaskName();
			int categoryId = task.getCategoryId();
			String limitDate = task.getLimitDate();
			String userName = task.getUserName();
			String statusName = task.getStatusName();
			String memo = task.getMemo();

			// プレースホルダへの値の設定
			pstmt.setString(1, taskName);
			pstmt.setInt(2, categoryId);
			pstmt.setString(3, limitDate);
			pstmt.setString(4, userName);
			pstmt.setString(5, statusName);
			pstmt.setString(6, memo);

			// SQLステートメントの実行
			count = pstmt.executeUpdate();

			// 現在登録したタスクのタスクIDを取得する
			try (ResultSet keys = pstmt.getGeneratedKeys()) {
				if (keys.next()) {
					newTaskId = keys.getInt(1);
				} else {
					/* DO NOTHING */
				}
			}

			// 内部結合した日本語名データを取得する
			try (PreparedStatement pstmtSelect = con.prepareStatement(selectsql)) {
				pstmtSelect.setInt(1, newTaskId);

				try (ResultSet rs = pstmtSelect.executeQuery()) {
					if (rs.next()) {
						task.setCategoryName(rs.getString("category_name"));
						task.setUserName(rs.getString("user_name"));
						task.setStatusName(rs.getString("status_name"));
					} else {
						/* DO NOTHING */
					}
				}
			}
		}

		return count;
	}

	/**
	 * 指定された内容のタスク情報を更新します。
	 * @param Task タスクオブジェクト
	 * @return 処理件数
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
	public int update(TaskBean task) throws SQLException, ClassNotFoundException {
		int processingNumber = 0; //処理件数

		String sql = "UPDATE t_task t "
				+ "SET t.task_name = ?, t.category_id = ?, t.limit_date = ?, t.user_id = ?, t.status_code = ?, t.memo = ? "
				+ "WHERE t.task_id = ? ";

		// データベースへの接続の取得、PreparedStatementの取得
		try (Connection con = ConnectionManager.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql)) {

			// DTOからのデータの取り出し
			String taskName = task.getTaskName();
			int categoryId = task.getCategoryId();
			String limitdate = task.getLimitDate();
			String userId = task.getUserId();
			String statusCode = task.getStatusCode();
			String memo = task.getMemo();
			int taskId = task.getTaskId();

			// プレースホルダへの値の設定
			pstmt.setString(1, taskName);
			pstmt.setInt(2, categoryId);
			pstmt.setString(3, limitdate);
			pstmt.setString(4, userId);
			pstmt.setString(5, statusCode);
			pstmt.setString(6, memo);
			pstmt.setInt(7, taskId);

			// SQLステートメントの実行
			processingNumber = pstmt.executeUpdate();
		}
		return processingNumber;
	}

	/**
	 * タスク情報の削除
	 * @param task タスクオブジェクト
	 * @return 処理件数
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
	public int delete(TaskBean task) throws SQLException, ClassNotFoundException {
		int count = 0; //処理件数

		// ユーザIDとパスワードが一致するか数えるSQL 
		String sql = "DELETE FROM t_task WHERE task_id = ?";

		try (Connection con = ConnectionManager.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql)) {

			//プレースホルダへの値の設定
			pstmt.setInt(1, task.getTaskId());

			//SQLステートメントの実行
			count = pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return count;
	}

}