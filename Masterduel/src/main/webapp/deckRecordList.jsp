<%@page contentType="text/html;charset=utf-8" %>
<%@page import="bean.*" %>
<jsp:useBean id ="ddto" scope="request" class="bean.DeckDTO" />
<jsp:useBean id ="action" scope="request" class="java.lang.String" />
<html>
  <head>
    <title>表示画面</title>
  </head>
<body>

<table border="1">
  <tr>
  	<th width="50">id</th>
    <th width="150">デッキ</th>
    <th width="50">win</th>
    <th width="50">lose</th>
  </tr>
<%
  for(int i = 0; i < ddto.size(); i++){
    DeckBean db = ddto.get(i);
%>
  <tr>
    <td align="center"><%= db.getId() %></td>
    <td align="center"><%= db.getDeck() %></td>
    <td align="center"><%= db.getWin() %></td>
    <td align="center"><%= db.getLose() %></td>
  </tr>
<% } %>

</table><br />

<form action="/Masterduel/ViewServlet" method="get">
  <input type="submit" value="対戦履歴">
</form>







</body>
</html>