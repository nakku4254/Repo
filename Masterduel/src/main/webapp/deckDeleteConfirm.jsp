<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="bean.*" %>
<jsp:useBean id ="deckId" scope="request" class="java.lang.String" />
<jsp:useBean id ="deckName" scope="request" class="java.lang.String" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>削除確認画面</title>
</head>
<body>

<h1>確認</h1>
  <form action="/Masterduel/DeleteServlet" method="post">
    <input type="hidden" name="deckId" value="<%= deckId %>">
    <input type="hidden" name="deckName" value="<%= deckName %>">
    <p><%= deckName %>を削除しますか？</p>
    <input type="submit" value="削除する">
  </form>
</body>
</html>