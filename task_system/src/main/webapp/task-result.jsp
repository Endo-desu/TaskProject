<%@ page pageEncoding="UTF-8"%>

    <jsp:useBean id="TaskBean" scope="request" class="model.entity.TaskBean"/>
	
	タスク名	
	<jsp:getProperty name="TaskBean" property="taskName"/><br>
	
	カテゴリ情報	
	<jsp:getProperty name="TaskBean" property="categoryName"/><br>
	
	期限	
	<jsp:getProperty name="TaskBean" property="limitDate"/><br>
	
	担当者情報	
	<jsp:getProperty name="TaskBean" property="userName"/><br>
	
	ステータス情報
	<jsp:getProperty name="TaskBean" property="statusName"/><br>
	
	メモ	
	<jsp:getProperty name="TaskBean" property="memo"/><br>