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
		<%= request.getAttribute("taskName") %>
		<p>を削除しますか？</p>
		<div>
			<input type="submit" value="はい">
			<input type="submit" formaction="" value="いいえ">
		</div>
	</form>
</body>
</html>