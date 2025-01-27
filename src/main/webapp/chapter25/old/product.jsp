<%@page contentType="text/html; charset=UTF-8" %>
<%@taglib prefix="c" uri="jakarta.tags.core" %>
<%@include file="../header.html" %>
<%@include file="menu.jsp" %>

<p>検索キーワードを入力してください。</p>
<form action="Product.action" method="post">
<input type="text" name="keyword">
<input type="submit" value="検索">
</form>
<hr>

<table style="border-collapse:separate;border-spacing:10px;">
<c:forEach var="product" items="${list}">
	<tr>
	<td>商品${product.id}</td>
	<td><img src="image/${product.id}.jpg" height="64" onerror="this.src=('image/syokki_osara.png')"></td>
	<td>${product.name}</td>
	<td>${product.price}円</td>
	<td>
	<select id="${product.id}_count">
	<c:forEach var="i" begin="1" end="9"><option value="${i }">${i }</option></c:forEach>
	</select>
	</td>
	<td><a href="CartAdd.action?id=${product.id}">カートに追加</a></td>
	</tr>
</c:forEach>
</table>

<%@include file="../footer.html" %>
