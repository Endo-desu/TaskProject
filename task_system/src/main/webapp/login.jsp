<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang='ja'>
<head>
<meta charset='utf-8'>
<meta name='author' content='shinoda'>
<title>ログイン画面</title>
<link rel='stylesheet' href='main.css'>
</head>
<body>
	<h1>ログイン画面</h1>

	<form action="login-servlet" method="POST">
		ユーザID：<input type="text" name="userId"><br> 
		パスワード：<input type="text" name="password"><br>
		<!--エラーメッセージを表示-->

		<%
		//エラーメッセージのnullチェック
		if (request.getAttribute("errorMessage") != null) {
		%>
		<%=(String) request.getAttribute("errorMessage")%>
		<%
		}else {
			/*Do NOTHING*/
		}
		%><br>

		<input type="submit" value="ログインする">
	</form>
</body>
</html>