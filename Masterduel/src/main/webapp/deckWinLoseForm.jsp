<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="bean.*" %>
<jsp:useBean id ="deckId" scope="request" class="java.lang.String" />
<jsp:useBean id ="deckName" scope="request" class="java.lang.String" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>登録画面</title>
</head>
<body>
	<h1>勝敗登録</h1>
	<form action="/Masterduel/WinLoseServlet" method="post">
		<input type="hidden" name="deckId" value="<%=deckId%>"> 
		<input type="hidden" name="deckName" value="<%=deckName%>">
		<p>どちらかを選んでください:</p>
		<input type="radio" name="winLose" value="win"> 勝ち<br> 
		<input type="radio" name="winLose" value="lose"> 負け<br> 
		<input type="submit" value="送信">
	</form>
</body>
</html>