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
	<form action="task-addition-servlet" method="post">
		
		<%@ include file="task-form.jsp" %>
		
		<input type="submit" value="登録">
	</form>
</body>
</html>