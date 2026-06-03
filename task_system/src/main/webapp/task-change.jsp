<%@page import="java.util.List"%>
<%@page import="model.entity.StatusBean"%>
<%@page import="model.entity.CategoryBean"%>
<%@page import="model.entity.UserBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ja">
<head>
<meta charset="UTF-8">
<title>タスク管理システム</title>
<link rel="stylesheet" type="text/css" href="style-sheet.css">
</head>
<body>

	<div class="main-header">
		<div class="menu-link">
			<a href="menu.jsp">メニュー</a>
		</div>
		<div class="header-title">タスク管理システム</div>
		<div></div> 
	</div>
	
	<jsp:useBean id="taskList" class="model.entity.TaskBean" scope="session"/>
	<jsp:useBean id="categoryList" class="model.entity.CategoryBean" scope="session"/>
	<jsp:useBean id="userList" class="model.entity.UserBean" scope="session"/>
	<jsp:useBean id="statusList" class="model.entity.StatusBean" scope="session"/>
	
	<div class="form-container">
		<h1>タスク編集ページ</h1>
		
		<form action="task-change-servlet" method="post">

			<%@ include file="task-form.jsp" %>
			
			<div class="btn-group">
				<input type="submit" value="変更" class="submit-btn">
			</div>
		</form>
	</div>

</body>
</html>