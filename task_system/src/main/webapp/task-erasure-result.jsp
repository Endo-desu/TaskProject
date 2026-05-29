<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="">
		<%= request.getAttribute("taskName") %>
		<p>を削除しました</p>
		<br>
		<input type="submit" value="メニュー画面へ戻る">
	</form>
</body>
</html>