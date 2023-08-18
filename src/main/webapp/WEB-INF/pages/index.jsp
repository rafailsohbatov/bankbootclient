<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 17/08/2023
  Time: 4:29 pm
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>Customer Page</title>
</head>
<body>
<table border="1">
    <thead>
    <tr>
        <th>Id</th>
        <th>Name</th>
        <th>Surname</th>
        <th>Date Of Birth</th>
        <th>Address</th>
        <th>Phone</th>

    </tr>
    </thead>
    <tbody>
    <a href="${pageContext.request.contextPath}/NewCustomerView"><input type="button" value="New Customer"/></a>
    <c:forEach items="${customerList}" var="cl">
    <tr>
        <td>${cl.customerId}</td>
        <td>${cl.name}</td>
        <td>${cl.surname}</td>
        <td>${cl.dob}</td>
        <td>${cl.address}</td>
        <td>${cl.phone}</td>
    </tr>
    </c:forEach>
    </tbody>
</table>
<c:if test="${not empty message}">
    <label style="color: red">${message}</label>
</c:if>
</body>
</html>
