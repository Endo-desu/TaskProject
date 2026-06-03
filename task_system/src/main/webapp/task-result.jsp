<%@page import="model.entity.TaskBean"%>
<%@ page pageEncoding="UTF-8"%>
		<% TaskBean sessionTask = (TaskBean)session.getAttribute("TaskBean"); %>
		<% TaskBean requestTask = (TaskBean)request.getAttribute("TaskBean"); %>

		<jsp:useBean id="TaskBean" scope="request" class="model.entity.TaskBean"/>
		
		<div class="form-group">
			<label>タスク名</label>
			<div class="result-text"><jsp:getProperty name="TaskBean" property="taskName"/></div>
		</div>
		
		<div class="form-group">
			<label>カテゴリ情報</label>
			<div class="result-text"><jsp:getProperty name="TaskBean" property="categoryName"/></div>
		</div>
		
		<div class="form-group">
			<label>期限</label>
			<% if(sessionTask.getLimitDate() == null) {%>
			<div class="result-text">なし</div>
			<% } else if(sessionTask.getLimitDate() != null || requestTask.getLimitDate() != null) { %>
			<div class="result-text"><jsp:getProperty name="TaskBean" property="limitDate"/></div>
			<% } else {
				/* DO NOTHING */
			   } %>
		</div>
		
		<div class="form-group">
			<label>担当者情報</label>
			<div class="result-text"><jsp:getProperty name="TaskBean" property="userName"/></div>
		</div>
		
		<div class="form-group">
			<label>ステータス情報</label>
			<div class="result-text"><jsp:getProperty name="TaskBean" property="statusName"/></div>
		</div>
		
		<div class="form-group">
			<label>メモ</label>
			<div class="result-text"><jsp:getProperty name="TaskBean" property="memo"/></div>
		</div>
		
