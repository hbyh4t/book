<%@page contentType="text/html; charset=UTF-8" %>
<%@include file="../header.html" %>
<%@taglib prefix="c" uri="jakarta.tags.core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>


<fmt:formatNumber value="12345.6789" /><br>
<!-- 結果: 12,345.679 -->
<fmt:setLocale value="en-US"/>
<fmt:formatNumber value="12345.6789" type="currency" /><br>
<!-- 結果: $12,345.68 （ロケールに基づく） -->
<fmt:formatNumber value="0.875" type="percent" /><br>
<!-- 結果: 87% -->
<fmt:formatNumber value="12345.6789" pattern="#,##0.00" /><br>
<!-- 結果: 12,345.68 -->
<fmt:formatNumber value="12345.6789" maxFractionDigits="2" /><br>
<!-- 結果: 12,345.68 -->
<fmt:formatNumber value="12345.6789" var="formattedValue" /><br>
<p>フォーマットされた値: ${formattedValue}</p>

<jsp:useBean id="now" class="java.util.Date" />

<fmt:setLocale value="ja-JP"/>
<fmt:formatDate value="${now}" /><br>
<!-- 結果: 2024/12/23（ロケールによる） -->
<fmt:formatDate value="${now}" type="both" /><br>
<!-- 結果: 2024/12/23 10:30:45（ロケールによる） -->
<fmt:formatDate value="${now}" type="both" dateStyle="full" timeStyle="short" /><br>
<!-- 結果: 2024年12月23日 月曜日 10:30 -->
<fmt:formatDate value="${now}" pattern="yyyy-MM-dd HH:mm:ss" /><br>
<!-- 結果: 2024-12-23 10:30:45 -->
<fmt:formatDate value="${now}" type="both" timeZone="Asia/Tokyo" /><br>
<!-- 結果: タイムゾーンに基づいた日付と時刻 -->
<fmt:formatDate value="${now}" pattern="yyyy-MM-dd" var="formattedDate" />
<p>フォーマットされた日付: ${formattedDate}</p>

<c:if test="${fn:contains('hello world', 'world')}">
    <p>hello worldにworldが含まれています。</p>
</c:if>

<c:if test="${fn:containsIgnoreCase('Hello', 'hello')}">
    <p>含まれています（大文字小文字無視）。</p>
</c:if>

<p>文字列の長さ: ${fn:length('abcdef')}</p>

<p>置換後の文字列: ${fn:replace('hello world', 'world', 'JSTL')}</p>

<p>切り出し: ${fn:substring('abcdef', 1, 4)}</p>

<%
String[] fruits = {"りんご", "みかん", "バナナ"};
pageContext.setAttribute("fruits", fruits);
%>
${fn:join(fruits, '、')}

<c:forEach var="lst" item="${fn:split('apple,banana,car',',') }">
	${lst }
</c:forEach>

<%@include file="../footer.html" %>
