<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>タスク削除確認</title>
<link rel="stylesheet" type="text/css" href="style-sheet.css">
</head>
<body>

	<header class="main-header">
		<div class="menu-link"><a href="menu.jsp">メニュー</a></div>
		<div class="header-title">タスク管理システム</div>
		<div></div>
	</header>

	<div class="form-container text-center">
		<h1>削除の確認</h1>
		
		<div class="delete-message">
			<span class="delete-task-name">
				<p>「<%= request.getAttribute("deleteTaskName") %>」を本当に削除しますか？</p>
			</span>
		</div>
		
		<form action="task-erasure" method="post">
			<input type = "hidden" name = "delete-task-id" value ="<%= request.getAttribute("deleteTaskId") %>">
			<input type = "hidden" name = "delete-task-name" value ="<%= request.getAttribute("deleteTaskName") %>">
		
			<div class="delete-btn-group">
				<input type="submit" value="はい（削除）" class="submit-btn delete-yes-btn">
				<input type="submit" formaction="task-list-servlet" value="いいえ（戻る）" class="submit-btn delete-no-btn">
			</div>
		</form>
	</div>

</body>
</html>