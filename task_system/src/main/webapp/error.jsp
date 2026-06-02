<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>エラー</title>
</head>
<body>

	<%-- 追加エラーの判定 --%>
	<%
	if (request.getAttribute("hasError") != null && (boolean) request.getAttribute("hasError")) {
	%>
	<form action="task-addition-form-servlet" method="post">
		<h2>タスクを登録できませんでした。</h2>
		<br>
		<%
		for (String errors : (List<String>) request.getAttribute("errors")) {
		%>
		<%=errors%>
		<%
		}
		%>
		<br> <input type="submit" value="登録画面へ戻る">
	</form>
	<%
	} else {
	/* DO NOTHING */
	}
	%>

	<%-- 編集エラーの判定 --%>
	<%
	if (request.getAttribute("changeError") != null && (boolean) request.getAttribute("changeError")) {
	%>
	<form action="task-change-form-servlet" method="post">
		<h2>タスクを編集できませんでした。</h2>
		<br>
		<%
		for (String errors : (List<String>) request.getAttribute("errors")) {
		%>
		<%=errors%>
		<%
		}
		%>
		<br> <input type="submit" value="編集画面へ戻る">
	</form>
	<%
	} else {
	/* DO NOTHING */
	}
	%>

	<%-- 削除エラーの判定 --%>
	<%
	if (request.getAttribute("deleteError") != null && (boolean) request.getAttribute("deleteError")) {
	%>
	<form action="task-list-servlet" method="post">
		<%=request.getAttribute("taskName")%>
		<p>を削除できませんでした。</p>

		<br> <input type="submit" value="タスク一覧へ戻る">
	</form>
	<%
	} else {
	/* DO NOTHING */
	}
	%>

</body>
</html>