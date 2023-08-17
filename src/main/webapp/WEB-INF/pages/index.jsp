<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 17/08/2023
  Time: 4:29 pm
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Customer Page</title>
</head>
<body>
${customerList}
<c:if test="${not empty message}">
    <label style="color: red">${message}</label>
</c:if>
</body>
</html>
