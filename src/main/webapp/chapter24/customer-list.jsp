<%@page contentType="text/html; charset=UTF-8" %>
<%@include file="../header.html" %>
<%@taglib prefix="c" uri="jakarta.tags.core" %>

<c:forEach var="p" items="${list}">
	<p>${p.id}：${p.login}：${p.password}</p>
</c:forEach>

<%@include file="../footer.html" %>
