<%@page contentType="text/html; charset=UTF-8" %>
<%@include file="../header.html" %>

<p>検索キーワードを入力してください。</p>
<form action="searchex" method="post">
商品名：<input type="text" name="name">
金額：<input type="text" name="price">
<input type="submit" value="検索">
</form>

<%@include file="../footer.html" %>