<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>メニュー画面</title>
</head>
<body>
	<h1>タスク管理システム　メニュー</h1>
	<form action = "task-addition-servlet" method = "POST">
	<input type = "submit" value = "新規タスク登録">
	</form>
	<form action = "task-list-servlet" method = "POST">
	<input type = "submit" value = "タスク一覧表示">
	</form>
	<form action = "logout-confirm-servlet" method = "POST">
	<input type = "submit" value = "ログアウトする">
	</form>

</body>
</html>