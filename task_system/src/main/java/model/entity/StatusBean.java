package model.entity;

import java.io.Serializable;

/**
 * タスクのカテゴリ情報を表します。
 * m_categoryのDTOであり、Beanオブジェクトです。
 * @author 板垣
 */
public class StatusBean implements Serializable {
	/**
	 * ステータスコード
	 */
	private String statusCode;

	/**
	 * ステータス名
	 */
	private String statusName;

	/**
	 * StatusBeanを構築します。
	 */
	public StatusBean() {

	}

	/**
	 * フィールドstatusCodeの値を設定します。
	 * @param statusCode ステータスコード
	 */
	public void setStatusCode(String statusCode) {
		this.statusCode = statusCode;
	}

	/**
	 * フィールドstatusCodeの値を返します。
	 * @return ステータスコード
	 */
	public String getStatusCode() {
		return statusCode;
	}

	/**
	 * フィールドstatusNameの値を設定します。
	 * @param statusName 氏名
	 */
	public void setStatusName(String statusName) {
		this.statusName = statusName;
	}

	/**
	 * フィールドstatusNameの値を返します。
	 * @return ステータス名
	 */
	public String getStatusName() {
		return statusName;
	}

}