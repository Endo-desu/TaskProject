<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8" import="java.util.List, model.entity.UserBean, model.entity.CategoryBean, model.entity.StatusBean" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>完了画面(パーツ)</title>
</head>
<body>

    タスク名：<input type="text" name="taskName"
        value="<jsp:getProperty name="task" property="taskName" />"><br>
    カテゴリ情報：<select  name="categoryName">
        <% for(CategoryBean cat : (List<CategoryBean>) request.getAttribute("categoryList")){ 7
        %>
         <option value="<% cat.getCategoryId() %>"><% cat.getCategoryName() %></option>
        <%
        }
        %>
    
    </select><br>
        
    期限：<input type="date" name="date"
        value="<jsp:getProperty name="task" property="limitDate" />"><br>
    担当者情報：<select  name="userName">
       <% for(UserBean user : (List<UserBean>) request.getAttribute("userList")){ 7
        %>
         <option value="<% user.getUserId() %>"><% user.getUserName() %></option>
        <%
        }
        %>
       </select><br>
    ステータス情報：<select  name="StatusName">
       <% for(StatusBean sta : (List<StatusBean>) request.getAttribute("statusList")){ 7
        %>
         <option value="<% sta.getStatusId() %>"><% sta.getStatusName() %></option>
        <%
        }
        %>
        </select><br>
    メモ：<input type="textarea" name="memo"
        value="<jsp:getProperty name="task" property="memo" />"><br>
        
        

</body>
</html>