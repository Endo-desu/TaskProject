package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.entity.CategoryBean;

public class CategoryDAO {
	
	/**
	 * カテゴリ情報を全件抽出します
	 * @return カテゴリ情報
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
	public List<CategoryBean> selectAll()
			throws SQLException, ClassNotFoundException {

		List<CategoryBean> categoryList = new ArrayList<CategoryBean>();

		String sql = "SELECT * FROM m_category";

		// データベースへの接続の取得、更新系SQLステートメントの実行
		try (Connection con = ConnectionManager.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql);
				ResultSet res = pstmt.executeQuery()) {

			while (res.next()) {

				String categoryId = res.getString("category_id");
				String categoryName = res.getString("category_name");

				//リストに入力値を格納
				CategoryBean category = new CategoryBean();
				category.setCategoryId(categoryId);
				category.setCategoryName(categoryName);
	
				categoryList.add(category);
			}
		}
		return categoryList;
	}
}
