<%@page contentType="text/html; charset=UTF-8" %>
<%@include file="../header.html" %>
<jsp:useBean id="product" class="bean.Product" />
<jsp:setProperty property="id" value="2" name="product"/>
<jsp:setProperty property="name" value="サーモン" name="product"/>
<jsp:setProperty property="price" value="100" name="product"/>
<jsp:getProperty property="id" name="product"/>：
<jsp:getProperty property="name" name="product"/>：
<jsp:getProperty property="price" name="product"/>
<%@include file="../footer.html" %>