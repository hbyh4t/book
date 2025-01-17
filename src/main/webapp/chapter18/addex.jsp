<%@page contentType="text/html; charset=UTF-8" %>
<%@include file="../header.html" %>

<p>追加するクッキーの情報を入力してください。</p>
<form action="addex" method="post">
名前<input type="text" name="name">
値<input type="text" name="value">
<input type="submit" value="追加">
</form>

<%@include file="../footer.html" %>