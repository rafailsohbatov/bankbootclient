<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 17/08/2023
  Time: 3:23 pm
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <%--    ${pageContext.request.contextPath} -- localhost:8084/client
    Base url goturmek ucun--%>
    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/main.css">
</head>
<body>

<div style="text-align: center">
    <form action="${pageContext.request.contextPath}/login" method="post">
        Username: <input type="text" placeholder="Username" name="username"/><br>
        Password: <input type="text" placeholder="Password" name="password"/><br>
        <input type="submit" value="Log In"> &nbsp; <input type="reset" value="Clear">
    </form> <br>
    <c:if test="${not empty message}">
        <label style="color: red">${message}</label>
    </c:if>
</div>


</body>
</html>
