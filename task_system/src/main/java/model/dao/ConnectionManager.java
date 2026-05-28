package model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionManager{
	/* データベースURL */
	private static final String URL = "jdbc:mysql://localhost:3306/task_db";
	
	/* ユーザ */
	private static final String USER = "taskU";
	
	/* パスワード */
	private static final String PASSWORD = "taskP";
	
	/**
	 * データベースへ接続し、Connectionオブジェクトを返す。
	 */
	public static Connection getConnection() throws SQLException, ClassNotFoundException {
		
		//JDBCドライバの読み込み
		Class.forName("com.mysql.cj.jdbc.Driver");
		return DriverManager.getConnection(URL, USER, PASSWORD);
	}
}