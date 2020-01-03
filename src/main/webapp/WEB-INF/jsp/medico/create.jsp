<%--
  Created by IntelliJ IDEA.
  User: leona
  Date: 10/12/2019
  Time: 02:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page import ="java.util.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <!-- Latest compiled and minified CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css" integrity="sha384-PmY9l28YgO4JwMKbTvgaS7XNZJ30MK9FAZjjzXtlqyZCqBY6X6bXIkM++IkyinN+" crossorigin="anonymous">

    <!-- Optional theme -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap-theme.min.css" integrity="sha384-jzngWsPS6op3fgRCDTESqrEJwRKck+CILhJVO5VvaAZCq8JYf8HsR/HPpBOOPZfR" crossorigin="anonymous">

</head>
<center>
<body>
<h1>
    Create Medico
</h1>
${message}
<br><br>
<form method="post" action="<%=request.getContextPath()%>/medico/create">
    Name:
    <input type="text" class="form-text text-muted" name="nome">
    <br><br>

    CRM:
    <input type="text" class="form-text text-muted" name="crm">
    <br><br>

    Especialidade:
    <select name="idSpecialty">
        <c:forEach var="specialty" items="${mySpecialty}">
            <option value="${specialty.id}">${specialty.nome}</option>
        </c:forEach>
    </select>
    <br><br>
    <input type="submit" class="btn btn-primary" value="save">
</form>

<br><br>
<a href="<%=request.getContextPath()%>/medico/list">Medico List</a>
<br><br>
<a href="<%=request.getContextPath()%>/scheduling/create">Create Scheduling</a>
</body>
</center>
</html>
