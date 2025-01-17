<%@page contentType="text/html; charset=UTF-8" %>
<%@include file="../header.html" %>
<%@taglib prefix="c" uri="jakarta.tags.core" %>
<%@page buffer="1024kb" %>

<c:import url="/chapter3/hello"/>

<c:import url="/chapter8/greeting-out.jsp">
<c:param name="user" value="ひぐぺん工房"/>
</c:import>

<c:url var="result" value="/chapter8/greeting-out.jsp">
<c:param name="user" value="ひぐぺん工房" />
</c:url>
<p>${result }</p>

<c:catch var="exception">
<% int a=2,b=0,c=a/b; %>
</c:catch>
${exception }


<%-- <c:import url="https://tomcat.apache.org/"/> --%>

<%-- <c:redirect url="https://tomcat.apache.org/"/> --%>

<%@include file="../footer.html" %>
