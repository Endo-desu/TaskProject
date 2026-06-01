<%@page import="java.util.List"%>
<%@page import="model.entity.StatusBean"%>
<%@page import="model.entity.CategoryBean"%>
<%@page import="model.entity.UserBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>タスク管理システム</title>
</head>
<body>

    <form action="task-list-servlet" method="POST">
		<input type="submit" value="タスク一覧">タスク一覧
	</form>
	
	<jsp:useBean id="taskList" class="model.entity.TaskBean" scope="session"/>
	<jsp:useBean id="categoryList" class="model.entity.CategoryBean" scope="session"/>
	<jsp:useBean id="userList" class="model.entity.UserBean" scope="session"/>
	<jsp:useBean id="statusList" class="model.entity.StatusBean" scope="session"/>
	
    <h2>タスク編集ページ</h2>
	<form action="task-change-servlet" method="post">

        <%@ include file="task-form.jsp" %>
		
		<input type="submit" value="変更">
	</form>

</body>
</html>