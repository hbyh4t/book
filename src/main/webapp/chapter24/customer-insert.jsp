<%@page contentType="text/html; charset=UTF-8" %>
<%@include file="../header.html" %>

<p>追加するユーザーを入力してください。</p>
<form action="CustomerInsert.action" method="post">
ログイン名<input type="text" name="login">
パスワード<input type="password" name="password">
<input type="submit" value="追加">
</form>

<%@include file="../footer.html" %>
