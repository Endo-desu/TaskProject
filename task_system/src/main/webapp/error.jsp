<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>エラー</title>
<link rel="stylesheet" type="text/css" href="style-sheet.css">
</head>
<body>

	<header class="main-header">
		<div class="menu-link"><a href="menu.jsp">メニュー</a></div>
		<div class="header-title">タスク管理システム</div>
		<div></div>
	</header>
	
	<%-- 追加エラーの判定 --%>
	<div class="form-container">
	<%
	if (request.getAttribute("hasError") != null && (boolean) request.getAttribute("hasError")) {
	%>
	<form action="task-addition-form-servlet" method="post">
		<h1>タスクを登録できませんでした。</h1>
		<br>
		<%
		for (String errors : (List<String>) request.getAttribute("errors")) {
		%>
		<div class="form-group" style="justify-content: center; margin: 30px 0;">
				<div class="delete-complete-message">
					<strong><%=errors%></strong>
				</div>
		</div>
		<%
		}
		%>
		<div class="btn-group">
				<input type="submit" value="登録画面へ戻る" class="submit-btn">
		</div>
	</form>
	<%
	} else {
	/* DO NOTHING */
	}
	%>
	</div>

	<%-- 編集エラーの判定 --%>
	<div class="form-container">
	<%
	if (request.getAttribute("changeError") != null && (boolean) request.getAttribute("changeError")) {
	%>
	<form action="task-change-form-servlet" method="post">
		<h1>タスクを編集できませんでした。</h1>
		<br>
		<%
		for (String errors : (List<String>) request.getAttribute("errors")) {
		%>
		<div class="form-group" style="justify-content: center; margin: 30px 0;">
				<div class="delete-complete-message">
					<strong><%=errors%></strong>
				</div>
		</div>
		<%
		}
		%>
		<div class="btn-group">
				<input type="submit" value="編集画面へ戻る" class="submit-btn">
		</div>
	</form>
	<%
	} else {
	/* DO NOTHING */
	}
	%>
	</div>

	<%-- 削除エラーの判定 --%>
	<div class="form-container">
	<%
	if (request.getAttribute("deleteError") != null && (boolean) request.getAttribute("deleteError")) {
	%>
	<form action="task-list-servlet" method="post">
	
		<div class="form-group" style="justify-content: center; margin: 30px 0;">
			<div class="delete-complete-message">
				<strong><%=request.getAttribute("taskName")%>を削除できませんでした。</strong>
			</div>
		</div>
	
		<div class="btn-group">
				<input type="submit" value="タスク一覧へ戻る" class="submit-btn">
		</div>
	</form>
	<%
	} else {
	/* DO NOTHING */
	}
	%>
	</div>

</body>
</html>