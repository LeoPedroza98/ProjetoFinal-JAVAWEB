<%--
  Created by IntelliJ IDEA.
  User: leona
  Date: 10/12/2019
  Time: 03:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page import ="java.util.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Edit Specialty</title>
</head>
<body>
${message}
<br><br>
<form method="post" action="<%=request.getContextPath()%>/specialty/edit">
    Name:
    <input type="text" name="nome" value="${specialty.nome}">

    <br><br>

    <input type="hidden" name="id" value="${specialty.id}">

    <input type="submit" value="save">
</form>
<br><br>

<a href="<%=request.getContextPath()%>/specialty/list">Specialty List</a>
</body>
</html>
