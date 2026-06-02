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
	
	<input type = "hidden" name = "taskId" value ="<%= request.getAttribute("taskId") %>">	
    タスク名：<input type="text" name="taskName"
        value="<%= request.getAttribute("taskName") != null ? request.getAttribute("taskName") : "" %>"><br>
    カテゴリ情報：<select  name="categoryId">
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
    
    </select><br>
        
    期限：<input type="date" name="date"
        value="<%= request.getAttribute("limitDate") %>"><br>
    担当者情報：<select  name="userId">
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
       </select><br>
    ステータス情報：<select  name="StatusCode">
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
        </select><br>
    メモ：<input type="textarea" name="memo"
        value="<%= request.getAttribute("memo") != null ? request.getAttribute("memo") : "" %>"><br>
        
        

</body>
</html>