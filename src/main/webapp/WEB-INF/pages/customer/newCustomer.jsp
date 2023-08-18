<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 18/08/2023
  Time: 5:07 pm
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html >
<head>
    <title>Title</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/main.css" />
    <script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/jquery-3.6.1.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/main.js"></script>
</head>
<body>
<label class="lblDesign">Username</label><input type="text" id="usernameId" placeholder="Username"><br>
<label class="lblDesign">Password</label><input type="text" id="passwordId" placeholder="Password"><br>
<label class="lblDesign">Name</label><input type="text" id="nameId" placeholder="Name"><br>
<label class="lblDesign">Surname</label><input type="text" id="surnameId" placeholder="Surname"><br>
<label class="lblDesign">Phone</label><input type="text" id="phoneId" placeholder="Phone"><br>
<input type="button" value="Add" id="addBtnId"> &nbsp; <input type="button" value="Clear" id="clearBtnId">
</body>
</html>
