<%@page import="model.entity.TaskBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8" import="java.util.List, model.entity.UserBean, model.entity.CategoryBean, model.entity.StatusBean" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>完了画面(パーツ)</title>
</head>
<body>
	
	<input type = "hidden" name = "taskId" 
			value ="<%= request.getAttribute("taskId") %>">	

	<div class="form-group">
		<label>タスク名</label>
		<input type="text" name="taskName"
        	value="<%= request.getAttribute("taskName") != null ? request.getAttribute("taskName") : "" %>">
	</div>

	<div class="form-group">
		<label>カテゴリ情報</label>
		<select  name="categoryId">
			<% 
				for(CategoryBean cat : (List<CategoryBean>) request.getAttribute("categoryList")){ 
					if(cat.getCategoryName().equals((String)request.getAttribute("categoryName"))){
			%>
			 <option value="<%= cat.getCategoryId() %>" selected><%= cat.getCategoryName() %></option>
			<%
					}else{
			%>
			 <option value="<%= cat.getCategoryId() %>"><%= cat.getCategoryName() %></option>
			<%
					}
				}
			%>
		</select>
	</div>
        
	<div class="form-group">
		<label>期限</label>
		<input type="date" name="date"
			value="<%= request.getAttribute("limitDate") %>">
	</div>

	<div class="form-group">
		<label>担当者情報</label>
		<select  name="userId">
		   <% 
				for(UserBean user : (List<UserBean>) request.getAttribute("userList")){ 
					if(user.getUserName().equals((String)request.getAttribute("userName"))){
		   %>
			 <option value="<%= user.getUserId() %>" selected><%= user.getUserName() %></option>
		   <%
					}else{
		   %>
			 <option value="<%= user.getUserId() %>"><%= user.getUserName() %></option>
		   <%
					}
				}
		   %>
		</select>
	</div>

	<div class="form-group">
		<label>ステータス情報</label>
		<select  name="StatusCode">
		   <% 
				for(StatusBean sta : (List<StatusBean>) request.getAttribute("statusList")){ 
					if(sta.getStatusName().equals((String)request.getAttribute("statusName"))){
		   %> 
			 <option value="<%= sta.getStatusCode() %>" selected><%= sta.getStatusName() %></option>
		   <%
					}else{
		   %>
			 <option value="<%= sta.getStatusCode() %>"><%= sta.getStatusName() %></option>
		   <%
					}
				}
		   %>
		</select>
	</div>

	<div class="form-group">
		<label>メモ</label>
		<textarea name="memo" rows="3"><%= request.getAttribute("memo") != null ? request.getAttribute("memo") : "" %></textarea></div>
        
</body>
</html>