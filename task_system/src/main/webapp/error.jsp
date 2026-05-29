<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>エラー</title>
</head>
<body>
	<% if(request.getAttribute("additonError")){  %>
		<form action="">
			<h2>タスクを登録できませんでした。</h2>
			<br>
			
	
			<br>
			<input type="submit" value="登録画面へ戻る"> 
		</form>
	<% 
		} else{ 
			/* DO NOTHING */
		}
	%>
	
	
	<% if(request.getAttribute("changeError")){ %>
		<form action="">
			<h2>タスクを編集できませんでした。</h2>
			<br>
			
			
			<br>
			<input type="submit" value="編集画面へ戻る"> 
		</form>
	<% 
		}else{ 
			/* DO NOTHING */
		}
	%>
	
	
	<% if(request.getAttribute("deleteError")){ %>
		<form action="">
			<%= request.getAttribute("taskName") %>
			<p>を削除できませんでした。</p>
			
			<br>
			
			<input type="submit" value="タスク一覧へ戻る"> 
		</form>
	<% 
		} else{ 
			/* DO NOTHING */
		}
	%>
		
</body>
</html>