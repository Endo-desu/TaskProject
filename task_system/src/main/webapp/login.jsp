<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang='ja'>
<head>
<meta charset='utf-8'>
<meta name='author' content='shinoda'>
<title>ログイン画面</title>
<link rel='stylesheet' href='style_sheet.css'>
</head>
<body>
	<div class='login-wrapper'>
		<div class='login-card'>
			<h1 class = 'title'>ログイン画面</h1>
			<div class = 'form-group'>
				<form action="login-servlet" method="POST">
					<label>ユーザID：
					<input type="text" name="userId"></label><br> 
					<label>パスワード：
					<input type="text" name="password"></label><br>
					<!--エラーメッセージを表示-->

					<%
					//エラーメッセージのnullチェック
					if (request.getAttribute("errorMessage") != null) {
					%>
					<a class = 'worning'><%=(String) request.getAttribute("errorMessage")%>
					</a>
					<%
					} else {
					/*Do NOTHING*/
					}
					%>
					<br>
					<button type="submit">ログインする</button>
				</form>
			</div>
		</div>
	</div>
</body>
</html>