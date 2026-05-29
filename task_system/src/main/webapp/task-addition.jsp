<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>タスク登録画面</title>
</head>
<body>
	<a href="menu.jsp">メニュー</a>
	<h1>タスク登録ページ</h1>
	<form action="task-addition-confirm-servlet" method="post">
		タスク名：<input type="text" name="taskName"><br>
		カテゴリ情報：
		<select name="categoryId">
			<option value="1">新商品A：開発プロジェクト</option>
			<option value="2">既存商品B：改良プロジェクト</option>
		</select><br>
		期限：<input type="date" name="updateDate"><br>
		担当者情報：
		<select name="userId">
			<option value="00000">篠田</option>
			<option value="00001">横内</option>
		</select><br>
		ステータス情報：
		<select name="statusCode">
			<option value="00">未着手</option>
			<option value="50">着手</option>
			<option value="99">完了</option>
		</select><br>
		メモ： <textarea name="memo" cols="30" rows="1"></textarea><br>
		<input type="submit" value="登録">
	</form>
</body>
</html>