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
<form action = "manu-servlet" method = "POST">
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
		<tr><td><%=task.getCategory() %></td></tr>
		<tr><td><%=task.getLimitDate() %></td></tr>
		<tr><td><%=task.getManager() %></td></tr>
		<tr><td><%=task.getStatus() %></td></tr>
		<tr><td><%=task.getMemo() %></td></tr>
		
		<tr><td>
			<form action = "task-change-servlet" method = "POST">
			
			<!-- タスクIDの転送 -->
					<input type = "hidden" name = "taskId" value ="<%=task.getTaskId() %>">		
					
	<!--	ミス	<input type = "hidden" name = "taskName"value = "<%=task.getTaskName() %>">-->
	<!--			<input type = "hidden" name = "category"value = "<%=task.getCategory() %>">-->
	<!--			<input type = "hidden" name = "limitDate"value = "<%=task.getLimitDate() %>">-->
	<!--			<input type = "hidden" name = "manager"value = "<%=task.getManager() %>">-->
	<!--			<input type = "hidden" name = "taskName"value = "<%=task.getTaskName() %>">-->
	<!--			<input type = "hidden" name = "taskName"value = "<%=task.getTaskName() %>">-->
				<input type = "submit" value = "編集">
			</form>
			<form action = "task-erasure-servlet" method = "POST">
			
			<!-- タスクIDの転送 -->
				    <input type = "hidden" name = "taskId" value ="<%=task.getTaskId() %>">
				    
	<!--	ミス	<input type = "hidden" name = "taskName"value = "<%=task.getTaskName() %>">-->
	<!--			<input type = "hidden" name = "category"value = "<%=task.getCategory() %>">-->
	<!--			<input type = "hidden" name = "limitDate"value = "<%=task.getLimitDate() %>">-->
	<!--			<input type = "hidden" name = "manager"value = "<%=task.getManager() %>">-->
	<!--			<input type = "hidden" name = "taskName"value = "<%=task.getTaskName() %>">-->
	<!--			<input type = "hidden" name = "taskName"value = "<%=task.getTaskName() %>">-->
				<input type = "submit" value = "削除">
			</form>
		</td></tr>
		
		
		<%} %>
		</table>
	
</body>
</html>