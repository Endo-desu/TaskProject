<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>タスク削除確認</title>
</head>
<body>
	<form action="task-erasure" method="post">
		<p><%= request.getAttribute("deleteTaskName") %>を削除しますか？</p>
		<div>
			<input type = "hidden" name = "delete-task-id" value ="<%= request.getAttribute("deleteTaskId") %>">
			<input type = "hidden" name = "delete-task-name" value ="<%= request.getAttribute("deleteTaskName") %>">
		
			<input type="submit" value="はい">
			<input type="submit" formaction="task-list-servlet" value="いいえ">
		</div>
	</form>
</body>
</html>