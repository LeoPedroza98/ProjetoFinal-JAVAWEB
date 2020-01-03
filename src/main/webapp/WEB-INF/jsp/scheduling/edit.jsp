<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<%--
  Created by IntelliJ IDEA.
  User: leona
  Date: 10/12/2019
  Time: 03:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <!-- Latest compiled and minified CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css" integrity="sha384-PmY9l28YgO4JwMKbTvgaS7XNZJ30MK9FAZjjzXtlqyZCqBY6X6bXIkM++IkyinN+" crossorigin="anonymous">

    <!-- Optional theme -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap-theme.min.css" integrity="sha384-jzngWsPS6op3fgRCDTESqrEJwRKck+CILhJVO5VvaAZCq8JYf8HsR/HPpBOOPZfR" crossorigin="anonymous">

</head>
<h1>
    Edit Scheduling
</h1>
<body>
<center>


<form method="post" action="<%=request.getContextPath()%>/scheduling/edit">
    Data:
    <input type="date" class="form-text text-muted" name="dataScheduling" value="${scheduling.dataScheduling}">

    <br><br>

    Medico:
    <select name="idMedico">
        <c:forEach var="medico" items="${medicoList}">
            <option value="${medico.id}" ${medico.id == scheduling.medico.id ? 'selected' : ''}>${medico.nome}</option>
        </c:forEach>
    </select>

    Person:
    <select name="idPerson">
        <c:forEach var="person" items="${personList}">
            <option value="${person.id}" ${person.id == scheduling.person.id ? 'selected' : ''}>${person.nome}</option>
        </c:forEach>
    </select> <br>
    <input type="submit" class="btn btn-primary" value="Salvar">
    <input type="hidden" value="${scheduling.id}" name="idScheduling">
</form>
<a href="<%=request.getContextPath()%>/scheduling/list">Scheduling List</a>
</center>
</body>
</html>
