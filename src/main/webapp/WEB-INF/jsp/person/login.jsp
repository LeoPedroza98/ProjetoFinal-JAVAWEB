<%--
  Created by IntelliJ IDEA.
  User: Leo
  Date: 28/11/2019
  Time: 23:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" pageEncoding="UTF-8"%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page import ="java.util.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <!-- Latest compiled and minified CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css" integrity="sha384-PmY9l28YgO4JwMKbTvgaS7XNZJ30MK9FAZjjzXtlqyZCqBY6X6bXIkM++IkyinN+" crossorigin="anonymous">

    <!-- Optional theme -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap-theme.min.css" integrity="sha384-jzngWsPS6op3fgRCDTESqrEJwRKck+CILhJVO5VvaAZCq8JYf8HsR/HPpBOOPZfR" crossorigin="anonymous">

</head>
<body>
<center>
<title>Login</title>

  ${message}
  <br><br>
   <form method="post" action="<%=request.getContextPath()%>/login/doLogin">
       UserName:
       <input type="text" class="form-text text-muted" name="username">
       <br><br>
       PassWord:
       <input type="password" class="form-text text-muted"  name="password">
       <br><br>
       <input type="submit" class="btn btn-primary" value="Login">
   </form>
<br><br>
    <a href="<%=request.getContextPath()%>/person/create">Person create</a>
    <br><br>
</center>
</body>
</html>
