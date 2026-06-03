<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>タスク登録画面</title>
<link rel="stylesheet" type="text/css" href="style-sheet.css">

</head>
<body>
	<div class="main-header">
		<div class="menu-link">
			<a href="menu.jsp">メニュー</a>
		</div>
		<div class="header-title">タスク管理システム</div>
		<div></div> 
	</div>
	
	<div class="form-container">
		<h1>タスク登録ページ</h1>
	
		<form action="task-addition-servlet" method="post">
		
			<%@ include file="task-form.jsp" %>
		
			<div class="btn-group">
				<input type="submit" value="登録" class="submit-btn">
			</div>
		</form>
	</div>		
	
</body>
</html>