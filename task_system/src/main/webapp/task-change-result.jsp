<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>編集完了画面</title>
</head>
<body>
	
	タスクの内容を編集しました。<br>
	

    <%@ include file="task-result.jsp" %>

	
	<form action="menu.html" method="POST">
		<input type="submit" value="メニュー画面に戻る">
	</form>

	<% session.invalidate(); %>

</body>
</html>