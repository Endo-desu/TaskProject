package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.entity.TaskBean;

public class TaskDAO{
	
	/**
	 * 登録済みのタスク情報を全件抽出します
	 * @return タスク情報
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
	public List<TaskBean> selectAll()
			throws SQLException, ClassNotFoundException {

		List<TaskBean> taskList = new ArrayList<TaskBean>();

		String sql = "SELECT t.task_name "
						+ "c.category_name "
						+ "t.limit_date "
						+ "u.user_name "
						+ "s.status_name "
						+ "t.memo"
				  + " FROM "
						+ "t_task t "
					+ "JOIN m_user u"
						+ "ON t.user_id = u.user_id"
					+ "JOIN m_category c"
						+ "ON t.category_id = c.category_id"
					+ "JOIN m_status s"
						+ "ON t.status_code = s.status_code";

		// データベースへの接続の取得、更新系SQLステートメントの実行
		try (Connection con = ConnectionManager.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql);
				ResultSet res = pstmt.executeQuery()) {

			while (res.next()) {

				String taskName = res.getString("task_name");
				String category = res.getString("category_name");
				String limitDate = res.getString("limit_date");
				String manager = res.getString("user_name");
				String status = res.getString("status_name");
				String memo = res.getString("memo");

				//リストに入力値を格納
				TaskBean task = new TaskBean();
				task.setTaskName(taskName);
				task.setCategory(category);
				task.setLimitDate(limitDate);
				task.setManager(manager);
				task.setStatus(status);
				task.setMemo(memo);

				taskList.add(task);
			}
		}
		return taskList;
	}
	
	/**
	 * タスクを登録します。
	 * @param task タスクオブジェクト
	 * @return 処理件数
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
	public int insert(TaskBean task) throws SQLException, ClassNotFoundException {
		int count = 0; //処理件数

		// データベースへの接続の取得、PreparedStatementの取得
		try (Connection con = ConnectionManager.getConnection();
				PreparedStatement pstmt = con.prepareStatement("INSERT INTO t_task(task_name, category_id, limite_date, user_id, status_code, memo) VALUES(?, ?, ?, ?, ?, ?)")) {

			// DTOからのデータの取り出し
			String taskName = task.getTaskName();
			String category = task.getCategory();
			String limitDate = task.getLimitDate();
			String maneger = task.getManager();
			String status = task.getStatus();
			String memo = task.getMemo();

			// プレースホルダへの値の設定
			pstmt.setString(1, taskName);
			pstmt.setString(2, category);
			pstmt.setString(3, limitDate);
			pstmt.setString(4, maneger);
			pstmt.setString(5, status);
			pstmt.setString(6, memo);

			// SQLステートメントの実行
			count = pstmt.executeUpdate();
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

		String sql = "UPDATE t_task SET task_name = ?, category_id = ?, limit_date = ?, memo = ? WHERE task_id = ?";

		// データベースへの接続の取得、PreparedStatementの取得
		try (Connection con = ConnectionManager.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql)) {

			// DTOからのデータの取り出し
			String taskName = task.getTaskName();
			String category = task.getCategory();
			String limitdate  = task.getLimitDate();
			String memo = task.getMemo();
			String taskId = task.getTaskId();

			// プレースホルダへの値の設定
			pstmt.setString(1, taskName);
			pstmt.setString(2, category);
			pstmt.setString(3, limitdate);
			pstmt.setString(4, memo);
			pstmt.setString(5, taskId);
			

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
		
		/* ユーザIDとパスワードが一致するか数えるSQL */
		String sql = "DELETE FROM t_task WHERE task_id = ?";
		
		try(Connection con = ConnectionManager.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql)){
			
			//プレースホルダへの値の設定
			pstmt.setString(1, task.getTaskId());
			
			//SQLステートメントの実行
			count = pstmt.executeUpdate();
			
		}catch (SQLException e) {
			e.printStackTrace();
		}
		
		return count;
	}
	
}