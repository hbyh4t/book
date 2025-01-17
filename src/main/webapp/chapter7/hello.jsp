<%@page contentType="text/html; charset=UTF-8"%>

<!DOCTYPE html>
<html lang="ja">
<head>
<meta charset="UTF-8" />
<title>Servlet/JSP Samples</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
</head>
<body>
	<%-- メッセージ出力 --%>
	<p>Hello!</p>
	<p>こんにちは！</p>
	<p>
		<%
		out.println(new java.util.Date());
		%>
	</p>
</body>
</html>
