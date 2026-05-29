<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang='ja'>
<head>
    <meta charset='utf-8'>
    <meta name='author' content='shinoda'>
    <title> ログイン画面</title>
    <link rel='stylesheet' href='main.css'>
</head>
<body>
    <% //ここでメッセージ取得
	request.setCharacterEncoding("UTF-8");
    
    String errorMessage = request.getParameter("errorMessaga");
    
    if (errorMessage == null){
    	errorMessage = "";
    } else {
    	/*DO NOTHING*/
    }
    %>
   <h1>ログイン画面</h1> 
   <!--エラーメッセージを表示-->
   <%= errorMessage%>
   <form action = "login-servlet" method = "POST">
    ユーザID：<input type = "text" name = "userId"><br>
    パスワード：<input type = "text" name = "password"><br>
    <input type = "submit" value = "ログインする">
   </form>
</body>
</html>