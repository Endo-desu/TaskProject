/*
 * プロジェクト型演習
 * model.entity.CategoryBean.java
 */
package model.entity;

import java.io.Serializable;

/**
 * タスクを表します。
 * m_categoryのDTOであり、Beanオブジェクトです。
 * @author 坂爪
 */
public class CategoryBean implements Serializable {

	/**
	 * カテゴリID
	 */
	private String categoryId;

	/**
	 * カテゴリー名
	 */
	private String categoryName;

	/**
	 * CategoryBeanを構築します。
	 */
	public CategoryBean() {

	}

	/**
	 * フィールドtaskの値を設定します。
	 * @param task タスク
	 */
	public void setCategoryId(String categoryId) {
		this.categoryId = categoryId;
	}

	/**
	 * フィールドtaskの値を返します。
	 * @return タスク
	 */
	public String getCategoryId() {
		return categoryId;
	}

	/**
	 * フィールドcategoryの値を設定します。
	 * @param category カテゴリー名
	 */
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	/**
	 * フィールドcategoryの値を返します。
	 * @return カテゴリー名
	 */
	public String getCategoryName() {
		return categoryName;
	}

}
