<%--
  Created by IntelliJ IDEA.
  User: leona
  Date: 10/12/2019
  Time: 03:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page import ="java.util.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Create Specialty</title>
</head>
<body>
<br><br>
<form method="post" action="<%=request.getContextPath()%>/specialty/create">
    Name:
    <input type="text" name="nome">
    <br><br>
    <input type="submit" value="Save"/>
</form>

<br><br>
<a href="<%=request.getContextPath()%>/specialty/list">Specialty List</a>


</body>
</html>
