<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>エラー</title>
</head>
<body>
	<% if(additonError){  %>
		<form action="">
			<h2>タスクを登録できませんでした。</h2>
			<br>
			<p>以下の内容が無効です。</p>
			<br>
			<p>(不適切な項目)</p>
			<% if() %>
			<br>
			<input type="submit" value="登録画面へ戻る"> 
		</form>
	<% } else if(changeError){ %>
		<form action="">
			<h2>タスクを編集できませんでした。</h2>
			<br>
			<p>以下の内容が無効です。</p>
			<br>
			<p></p>
			<% if((不適切な項目)) %>
			<br>
			<input type="submit" value="編集画面へ戻る"> 
		</form>
	<% } else if(deleteError){ %>
		<form action="">
			<%= request.getAttribute("taskName") %>
			<p>を削除できませんでした。</p>
			
			<br>
			
			<input type="submit" value="タスク一覧へ戻る"> 
		</form>
	<% } %>	
</body>
</html>