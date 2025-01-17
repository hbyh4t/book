<%@page contentType="text/html; charset=UTF-8" %>
<%@include file="../header.html" %>
<%
System.out.println("Tomcatなぜ赤字");
System.err.println("事業が赤字だから");
%>
<p><% out.println(Math.random()); %></p>
<p><%=Math.random() %></p>

<%@include file="../footer.html" %>
