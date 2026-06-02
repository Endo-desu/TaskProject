<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>タスク登録完了画面</title>
</head>
<body>
	<h2>以下のタスクの登録が完了しました</h2>

	<%@ include file="task-result.jsp" %>
	
	<form action="menu.jsp">
		<input type="submit" value="メニュー画面へ戻る">
	</form>
	
</body>
</html>