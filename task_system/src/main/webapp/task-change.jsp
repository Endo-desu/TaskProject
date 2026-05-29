<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>タスク管理システム</title>
</head>
<body>
    <form action="task-list-servlet" method="POST">
		<input type="submit" value="タスク一覧">タスク一覧
	</form>
	<jsp:useBean id="task" class="model.entity.TaskBean" scope="session"/>
    <h2>タスク編集ページ</h2>
	<form action="task-change-servlet" method="post">

        <%@ include file="task-form.jsp" %>
		
		<input type="submit" value="変更">
	</form>

</body>
</html>