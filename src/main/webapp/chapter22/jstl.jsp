<%@page contentType="text/html; charset=UTF-8" %>
<%@include file="../header.html" %>

<%@taglib prefix="c" uri="jakarta.tags.core" %>

<c:forEach var="p" items="${list}">
	${p.id}：${p.name}：${p.price}<br>
</c:forEach>

<ul>
    <c:forEach var="name" items="${names}">
        <li>${name}</li>
    </c:forEach>
</ul>

<table>
    <c:forEach var="fruit" items="${fruits}">
        <tr><td>${fruit}</td></tr>
    </c:forEach>
</table>

<c:forEach var="i" begin="1" end="5">
    <p>Number: ${i}</p>
</c:forEach>

<table>
    <c:forEach var="entry" items="${capitals}">
        <tr>
            <td>${entry.key}</td>
            <td>${entry.value}</td>
        </tr>
    </c:forEach>
</table>

<%@include file="../footer.html" %>
