package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.entity.StatusBean;

public class StatusDAO {
	public List<StatusBean> selectAll()
			throws SQLException, ClassNotFoundException {

		List<StatusBean> statusList = new ArrayList<StatusBean>();

		String sql = "SELECT * FROM m_status";

		// データベースへの接続の取得、更新系SQLステートメントの実行
		try (Connection con = ConnectionManager.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql);
				ResultSet res = pstmt.executeQuery()) {

			while (res.next()) {

				String statusCode = res.getString("status_code");
				String statusName = res.getString("status_name");

				//リストに入力値を格納
				StatusBean status = new StatusBean();
				status.setStatusCode(statusCode);
				status.setStatusName(statusName);

				statusList.add(status);
			}
		}
		return statusList;
	}
}
