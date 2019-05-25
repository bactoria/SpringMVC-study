<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: bactoria
  Date: 2019-05-25
  Time: 오후 2:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h2>Error</h2>

<h4>
    <c:out value="${exception}"></c:out>
</h4>

<ul>
    <c:forEach items="${exception.getStackTrace() }" var="stack">
        <li><c:out value="${stack}"></c:out></li>
    </c:forEach>
</ul>
</body>
</html>
