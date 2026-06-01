<%@page import="java.util.List"%>
<%@page import="model.entity.TaskBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name = 'author' content = '篠田'> 
<title>タスク一覧表示</title>
</head>
<body>
<form action = "menu-servlet" method = "POST">
<input type = "submit" value = "メニュー">
</form>
<h1>タスク一覧</h1>
	<% List<TaskBean> taskList = 
 		(List<TaskBean>)request.getAttribute("taskList");
	%>
	<table>
		<caption>タスク一覧</caption>
		<tr><th><!-- タスク名 --></th></tr>
		<tr><th><!-- カテゴリ名 --></th></tr>
		<tr><th><!-- 期限 --></th></tr>
		<tr><th><!-- 担当 --></th></tr>
		<tr><th><!-- 担当者名 --></th></tr>
		<tr><th><!-- メモ --></th></tr>
		
		<%for (TaskBean task : taskList) {%>
		<tr><td><%=task.getTaskName() %></td></tr>
		<tr><td><%=task.getCategoryName() %></td></tr>
		<tr><td><%=task.getLimitDate() %></td></tr>
		<tr><td><%=task.getUserName() %></td></tr>
		<tr><td><%=task.getStatusName() %></td></tr>
		<tr><td><%=task.getMemo() %></td></tr>
		
		<tr><td>
			<form action = "task-change-form-servlet" method = "POST">
			
			<!-- タスクIDの転送 -->
					<input type = "hidden" name = "taskId" value ="<%=task.getTaskId() %>">		
					<input type = "hidden" name = "taskName" value ="<%=task.getTaskName() %>">		
					<input type = "hidden" name = "categoryName" value ="<%=task.getCategoryName() %>">		
					<input type = "hidden" name = "limitDate" value ="<%=task.getLimitDate() %>">		
					<input type = "hidden" name = "userName" value ="<%=task.getUserName() %>">		
					<input type = "hidden" name = "statusName" value ="<%=task.getStatusName() %>">		
					<input type = "hidden" name = "memo" value ="<%=task.getMemo() %>">		
					

				<input type = "submit" value = "編集">
			</form>
			<form action = "task-erasure-form" method = "POST">
			
			<!-- タスクIDの転送 -->
				    <input type = "hidden" name = "taskId" value ="<%=task.getTaskId() %>">
				    <input type = "hidden" name = "taskName" value ="<%=task.getTaskName() %>">
				    
	
				<input type = "submit" value = "削除">
			</form>
		</td></tr>
		
		
		<%} %>
		</table>
	
</body>
</html>