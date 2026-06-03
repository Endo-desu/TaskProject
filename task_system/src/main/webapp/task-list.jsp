<%@page import="java.util.List"%>
<%@page import="model.entity.TaskBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ja">
<head>
<meta charset="UTF-8">
<meta name='author' content='篠田'>
<title>タスク一覧表示</title>
<link rel="stylesheet" type="text/css" href="style-sheet.css">
</head>
<body>

	<header class="main-header">
		<div class="menu-link"><a href="menu.jsp">メニュー</a></div>
		<div class="header-title">タスク管理システム</div>
	</header>

	<div class="task-list-container">

		<%
		List<TaskBean> taskList = (List<TaskBean>) request.getAttribute("taskList");
		if (taskList != null && !taskList.isEmpty()) {
			for (TaskBean task : taskList) {
		%>
		<div class="task-card">

			<div class="task-row task-name-box">
				<span class="label-inline">タスク名：</span> <span
					class="value-text font-bold"><%=task.getTaskName()%></span>
			</div>

			<div class="task-info-group">
				<div class="info-item">
					<span class="label-inline">カテゴリ：</span><%=task.getCategoryName()%>
				</div>
				
				<div class="info-item">
					<span class="label-inline">期限：</span>
					<% if (task.getLimitDate() != null) { %>
						<%=task.getLimitDate()%>
					<% } /* nullのときは何も表示しない */ %>
				</div>
				
				<div class="info-item">
					<span class="label-inline">担当：</span><%=task.getUserName()%></div>
				<div class="info-item">
					<span class="label-inline">ステータス：</span><span class="status-badge"><%=task.getStatusName()%></span>
				</div>
			</div>

			<div class="task-row task-memo-box">
				<div class="label-inline">メモ：</div>
				<div class="memo-content"><%=(task.getMemo() != null) ? task.getMemo() : ""%></div>
			</div>

			<div class="task-btn-group">
				<form action="task-change-form-servlet" method="POST"
					class="flex-btn-form">
					<input type="hidden" name="taskId" value="<%=task.getTaskId()%>">
					<input type="hidden" name="taskName" value="<%=task.getTaskName()%>"> 
					<input type="hidden" name="categoryName" value="<%=task.getCategoryName()%>">
					
					<input type="hidden" name="limitDate" value="<%=(task.getLimitDate() != null) ? task.getLimitDate() : ""%>"> 
					
					<input type="hidden" name="userName" value="<%=task.getUserName()%>"> 
					<input type="hidden" name="statusName" value="<%=task.getStatusName()%>">
					<input type="hidden" name="memo" value="<%=task.getMemo()%>">
					<button type="submit" class="submit-btn edit-btn">編集</button>
				</form>

				<form action="task-erasure-form" method="POST" class="flex-btn-form">
					<input type="hidden" name="taskId" value="<%=task.getTaskId()%>">
					<input type="hidden" name="taskName"
						value="<%=task.getTaskName()%>">
					<button type="submit" class="submit-btn delete-action-btn">削除</button>
				</form>
			</div>

		</div>
		<%
		}
		} else {
		%>
		<p class="no-task-message">タスクがありません。</p>
		<%
		}
		%>

	</div>
</body>
</html>