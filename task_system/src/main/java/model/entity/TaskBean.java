/*
 * プロジェクト型演習
 * model.entity.TaskBean.java
 */
package model.entity;

import java.io.Serializable;

/**
 * タスクを表します。
 * t_taskのDTOであり、Beanオブジェクトです。
 * @author 坂爪
 */
public class TaskBean implements Serializable {

	/**
	 *  タスクID 
	 */
	private int taskId;
	
	/**
	 *  タスク名 
	 */
	private String taskName;
	
	/**
	 *  担当者情報 
	 */
	private String userName;
	
	/**
	 *  期限 
	 */
	private String limitDate;

	/**
	 *  カテゴリ名 
	 */
	private String categoryName;

	/**
	 *  ステータス 
	 */
	private String statusName;

	/**
	 *  メモ 
	 */
	private String memo;

	/**
	 *  TaskBeanを構築します。 
	 */
	public TaskBean() {

	}
	
	/**
	 * フィールドtaskの値を設定します。
	 * @param task タスク名
	 */
	public void setTaskId(int taskId) {
		this.taskId = taskId;
	}

	/**
	 * フィールドtaskの値を返します。
	 * @return タスク名
	 */
	public int getTaskId() {
		return taskId;
	}

	/**
	 * フィールドtaskの値を設定します。
	 * @param task タスク名
	 */
	public void setTaskName(String taskName) {
		this.taskName = taskName;
	}

	/**
	 * フィールドtaskの値を返します。
	 * @return タスク名
	 */
	public String getTaskName() {
		return taskName;
	}
	
	/**
	 * フィールドuserNameの値を設定します。
	 * @param userName 担当者情報
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}

	/**
	 * フィールドuserNameの値を返します。
	 * @return 担当者情報
	 */
	public String getUserName() {
		return userName;
	}
	
	/**
	 * フィールドlimitDateの値を設定します。
	 * @param limitDate 期限
	 */
	public void setLimitDate(String limitDate) {
		this.limitDate = limitDate;
	}

	/**
	 * フィールドlimitDateの値を返します。
	 * @return 期限
	 */
	public String getLimitDate() {
		return limitDate;
	}

	/**
	 * フィールドcategoryNameの値を設定します。
	 * @param categoryName カテゴリ名
	 */
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	/**
	 * フィールドcategoryNameの値を返します。
	 * @return カテゴリ名
	 */
	public String getCategoryName() {
		return categoryName;
	}

	/**
	 * フィールドstatusNameの値を設定します。
	 * @param statusName ステータス
	 */
	public void setStatusName(String statusName) {
		this.statusName = statusName;
	}

	/**
	 * フィールドstatusNameの値を返します。
	 * @return ステータス
	 */
	public String getStatusName() {
		return statusName;
	}

	/**
	 * フィールドmemoの値を設定します。
	 * @param memo メモ
	 */
	public void setMemo(String memo) {
		this.memo = memo;
	}

	/**
	 * フィールドmemoの値を返します。
	 * @return メモ
	 */
	public String getMemo() {
		return memo;
	}

}