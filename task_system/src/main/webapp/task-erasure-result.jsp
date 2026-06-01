<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>削除完了</title>
</head>
<body>
	<form action="menu-servlet" method="post">
		<%= request.getAttribute("deleteTaskName") %>
		<p>を削除しました</p>
		<br>
		<input type="submit" value="メニュー画面へ戻る">
	</form>
</body>
</html>