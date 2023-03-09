<%@page contentType="text/html;charset=utf-8" %>
<%@page import="bean.*" %>
<jsp:useBean id ="ddto" scope="request" class="bean.DeckDTO" />
<html>
<head>
<title>編集画面</title>
</head>
<body>

<編集>

<form action="/Masterduel/servlet" method="post">
<select name="deck">
  <% for(int i= 0; i <  ddto.size() ; i++) {
  		DeckBean db = ddto.get(i); 
  %>
  		 <option value="<%= db.getId() + " " + db.getDeck() %>"><%= db.getDeck() %></option>
  <% } %>
</select>



<input type="radio" name="action" value="delete" />削除　
<input type="radio" name="action" value="create" />新規追加
<input type="submit" value="送信">



	<h1>doGetメソッドを使って表示されている</h1>
	





</body>
</html>