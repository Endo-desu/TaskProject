<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>タスク登録完了画面</title>
<link rel="stylesheet" type="text/css" href="style-sheet.css">
</head>
<body>

	<header class="main-header">
		<div></div> 
		<div class="header-title">タスク管理システム</div>
		<div></div> 
	</header>
	
	<div class="form-container">
		<h1>以下のタスクの登録が完了しました</h1>

		<%@ include file="task-result.jsp" %>
	
	<div class="btn-group">
			<form action="menu-servlet" method="POST">
				<input type="submit" value="メニュー画面に戻る" class="submit-btn">
			</form>
	</div>
	
</body>
</html>