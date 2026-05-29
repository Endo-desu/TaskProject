<%@ page language="java" contentType="text/html; charset=UTF-8"pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>完了画面(パーツ)</title>
</head>
<body>

    <jsp:useBean id="task" scope="session" class="model.entity.TaskBean" />
    <jsp:useBean id="category" scope="session" class="model.entity.CategoryBean" />
    <jsp:useBean id="user" scope="session" class="model.entity.UserBean" />
    <jsp:useBean id="status" scope="session" class="model.entity.StatusBean" />
    
    タスク名<jsp:getProperty name="task" property="taskName" /><br>
	カテゴリ名<jsp:getProperty name="category" property="categoryName" /><br>
	期限<jsp:getProperty name="task" property="limitDate" /><br>
	担当者情報：<jsp:getProperty name="user" property="userName" /><br>
	ステータス情報：<jsp:getProperty name="status" property="statusName" /><br>
	メモ：<jsp:getProperty name="task" property="memo" /><br>

</body>
</html>