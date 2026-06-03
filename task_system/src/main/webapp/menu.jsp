<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>メニュー画面</title>
<link rel="stylesheet" type="text/css" href="style-sheet.css">
</head>
<body>

	<header class="main-header">
		<div></div> <div class="header-title">タスク管理システム</div>
		<div></div> </header>

	<div class="form-container">
		<h1>メインメニュー</h1>
		
		<div class="menu-btn-group">
			<form action="task-addition-form-servlet" method="POST">
				<input type="submit" value="新規タスク登録" class="submit-btn menu-btn">
			</form>
			
			<form action="task-list-servlet" method="POST">
				<input type="submit" value="タスク一覧表示" class="submit-btn menu-btn">
			</form>
			
			<form action="logout-confirm.html" method="POST">
				<input type="submit" value="ログアウトする" class="submit-btn menu-btn logout-btn">
			</form>
		</div>
	</div>

</body>
</html>