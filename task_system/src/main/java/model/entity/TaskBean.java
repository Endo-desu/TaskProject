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

	/* タスクID */
	private String taskId;
	
	/* タスク名 */
	private String taskName;

	/* カテゴリ名 */
	private String category;

	/* 期限 */
	private String limitDate;

	/* 担当者情報 */
	private String manager;

	/* ステータス */
	private String status;

	/* メモ */
	private String memo;

	/* TaskBeanを構築します。 */
	public TaskBean() {

	}
	
	/**
	 * フィールドtaskの値を設定します。
	 * @param task タスク名
	 */
	public void setTaskId(String taskId) {
		this.taskId = taskId;
	}

	/**
	 * フィールドtaskの値を返します。
	 * @return タスク名
	 */
	public String getTaskId() {
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
	 * フィールドcategoryの値を設定します。
	 * @param category カテゴリ名
	 */
	public void setCategory(String category) {
		this.category = category;
	}

	/**
	 * フィールドcategoryの値を返します。
	 * @return カテゴリ名
	 */
	public String getCategory() {
		return category;
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
	 * フィールドmanagerの値を設定します。
	 * @param manager 担当者情報
	 */
	public void setManager(String manager) {
		this.manager = manager;
	}

	/**
	 * フィールドmanagerの値を返します。
	 * @return 担当者情報
	 */
	public String getManager() {
		return manager;
	}

	/**
	 * フィールドstatusの値を設定します。
	 * @param status ステータス
	 */
	public void setStatus(String status) {
		this.status = status;
	}

	/**
	 * フィールドstatusの値を返します。
	 * @return ステータス
	 */
	public String getStatus() {
		return status;
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