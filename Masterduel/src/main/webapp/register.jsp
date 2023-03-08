<%@page contentType="text/html;charset=utf-8"%>
<%@page import="bean.*"%>
<jsp:useBean id="ddto" scope="request" class="bean.DeckDTO" />
<html>
<head>
<title>表示画面</title>
</head>
<body>

	<%
	// キャッシュを無効化するコードを追加
	response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); // HTTP 1.1.
	response.setHeader("Pragma", "no-cache"); // HTTP 1.0.
	response.setDateHeader("Expires", 0);
	%>
	<table border="1">
		<tr>
			<th width="50">id</th>
			<th width="150">デッキ</th>
			<th width="50">win</th>
			<th width="50">lose</th>
		</tr>
		<%
		for (int i = 0; i < ddto.size(); i++) {
			DeckBean db = ddto.get(i);
		%>
		<tr>
			<td align="center"><%=db.getId()%></td>
			<td align="center"><%=db.getDeck()%></td>
			<td align="center"><%=db.getWin()%></td>
			<td align="center"><%=db.getLose()%></td>
		</tr>
		<%
		}
		%>
	</table>
	<br />





	<h1>doGetメソッドを使って表示されている</h1>




	<a href="/Masterduel/registerDeck.html">戻る</a>
</body>
</html>