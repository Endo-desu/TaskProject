<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>削除完了</title>
<link rel="stylesheet" type="text/css" href="style-sheet.css">
</head>
<body>

	<header class="main-header">
		<div class="menu-link"><a href="menu.jsp">メニュー</a></div>
		<div class="header-title">タスク管理システム</div>
		<div></div>
	</header>

	<div class="form-container">
		<h1>以下のタスクの削除が完了しました</h1>
		
		<form action="menu-servlet" method="post">
			
			<div class="form-group" style="justify-content: center; margin: 30px 0;">
				<div class="delete-complete-message">
					「<strong><%= request.getAttribute("deleteTaskName") %></strong>」を削除しました。
				</div>
			</div>
			
			<div class="btn-group">
				<input type="submit" value="メニュー画面へ戻る" class="submit-btn">
			</div>
			
		</form>
		
	</div>

</body>
</html>