package model.entity;

import java.io.Serializable;

/**
 * システムの利用者情報を表します。
 * m_userのDTOであり、Beanオブジェクトです。
 * @author 板垣
 */
public class UserBean implements Serializable {

	/**
	 * ユーザID
	 */
	private String userId;

	/**
	 * パスワード
	 */
	private String password;

	/**
	 * ユーザ名
	 */
	private String userName;

	/**
	 * UserBeanを構築します。
	 */
	public UserBean() {

	}

	/**
	 * フィールドuserIdの値を設定します。
	 * @param userId ユーザID
	 */
	public void setUserId(String userId) {
		this.userId = userId;
	}

	/**
	 * フィールドuserIdの値を返します。
	 * @return ユーザID
	 */
	public String getUserId() {
		return userId;
	}

	/**
	 * フィールドpasswordの値を設定します。
	 * @param password パスワード
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * フィールドpasswordの値を返します。
	 * @return パスワード
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * フィールドuserNameの値を設定します。
	 * @param userName ユーザ名
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}

	/**
	 * フィールドuserNameの値を返します。
	 * @return ユーザ名
	 */
	public String getUserName() {
		return userName;
	}
}