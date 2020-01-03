<%--
  Created by IntelliJ IDEA.
  User: leona
  Date: 10/12/2019
  Time: 02:18
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
<h1>
    Scheduling
</h1>
<body>
${message}
<br><br>
<form method="post" action="<%=request.getContextPath()%>/scheduling/create">
    Data:
    <input type="date" class="form-text text-muted" name="dataScheduling">
    <br><br>

    Medico:
    <select name="idMedico">
        <c:forEach var="medico" items="${medicoList}">
            <option value="${medico.id}">${medico.nome}</option>
        </c:forEach>
    </select>

    Person:
    <select  name="idPerson">
        <c:forEach var="person" items="${personList}">
            <option value="${person.id}">${person.nome}</option>
        </c:forEach>
    </select>
    <input type="submit"  class="btn btn-primary"  value="save"/>
</form>
<br><br>
<a href="<%=request.getContextPath()%>/scheduling/list"> Scheduling List </a>
<br><br>
    <a href="<%=request.getContextPath()%>/medico/create">Medico Create</a>
<br><br>
    <a href="<%=request.getContextPath()%>/specialty/create">Specialty Create</a>
    <br><br>

</body>
</center>
</html>
