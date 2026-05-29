<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>タスク登録完了画面</title>
</head>
<body>
	<h2>以下のタスクの登録が完了しました</h2>

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
	
	<form action="menu.jsp">
		<input type="submit" value="メニュー画面へ戻る">
	</form>
	
</body>
</html>