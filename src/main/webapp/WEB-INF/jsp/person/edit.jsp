<%@ page language="java" pageEncoding="UTF-8"%>
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
<center>
    <h1>
         Edit Person
    </h1>
    ${message}
    <form method="post" action="<%=request.getContextPath()%>/person/edit">
        Name:
        <input type="text"  class="form-text text-muted" name="name" value="${person.name}">
        <br><br>
        Email:
        <input type="email" class="form-text text-muted" name="email" value="${person.email}">
        Password:
        <input type="password" class="form-text text-muted" name="password" value="${person.password}">
        <br><br>
        <input type="hidden"  class="form-text text-muted" name="idPerson" value="${person.id}">
        <input type="submit"  class="btn btn-primary" value="save"/>
    </form>
    <br><bn>
    <a href="<%=request.getContextPath()%>/person/list">Person List</a>
</body>
</center>
</html>