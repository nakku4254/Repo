<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>登録画面</title>
</head>
<body>
  <h1>デッキの新規登録</h1>
  <form action="/Masterduel/CreateServlet" method="post">
    <label>デッキ名:</label>
    <input type="text" name="deckName"><br>
    <input type="submit" value="登録">
  </form>
</body>
</html>