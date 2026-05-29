package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.entity.UserBean;
/**
 * @author　篠田
 */
public class UserDAO {

	public boolean loginCheck(UserBean user)
			throws SQLException, ClassNotFoundException {
		
		String sql = "SELECT * FROM m_user WHERE user_id = ? AND password = ?";

		try (Connection con = ConnectionManager.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql)) {

			String userID = user.getUserId();
			String passWord = user.getPassword();

			pstmt.setString(1, userID);
			pstmt.setString(2, passWord);

			ResultSet res = pstmt.executeQuery();

			if (res.next()) {
				return true;
			} else {
				/*DO NOTHING*/
			}
		}
		return false;
	}
	
	public List<UserBean> selectAll()
			throws SQLException, ClassNotFoundException {

		List<UserBean> userList = new ArrayList<UserBean>();

		String sql = "SELECT * FROM m_user";

		// データベースへの接続の取得、更新系SQLステートメントの実行
		try (Connection con = ConnectionManager.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql);
				ResultSet res = pstmt.executeQuery()) {

			while (res.next()) {

				String userId = res.getString("user_id");
				String password = res.getString("password");
				String userName = res.getString("user_name");

				//リストに入力値を格納
				UserBean user = new UserBean();
				user.setUserId(userId);
				user.setPassword(password);
				user.setUserName(userName);

				userList.add(user);
			}
		}
		return userList;
	}
}
