<%@page contentType="text/html; charset=UTF-8" %>
<%@include file="../header.html" %>

<p>検索キーワードを入力してください。</p>
<form action="search_books" method="post">
<div class="container" display="flex">
<div class="item">
書籍名：<input type="text" name="title">
</div>
<div class="item">
価格：<input type="text" name="number_of_pages">
</div>
<div class="item">
価格：<select name="pricerange">
<option value="0-1000">0-1000</option>
<option value="1001-2000">1001-2000</option>
<option value="2001-3000">2001-3000</option>
</select>
</div>
<div class="item">
<input type="submit" value="検索">
</div>
</form>

<%@include file="../footer.html" %>