<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
<html>
<head>
    <title>List Specialty</title>
</head>
<body>
<table>
    <tr>
        <th>
            Edit
        </th>
        <th>
            Id
        </th>
        <th>
            Name
        </th>
    </tr>
    <c:forEach var="specialty" items="${specialtyList}">
        <tr>
        <td>
           <a href="<%=request.getContextPath()%>/specialty/edit?id=${specialty.id}">Edit</a>
        </td>

        <td>
        <c:out value="${specialty.id}"/>
        </td>

        <td>
            <c:out value="${specialty.nome}"/>
            </td>
        </tr>
        </c:forEach>
</table>

<br><br>
<a href="<%=request.getContextPath()%>/specialty/create">Create Specialty</a>
<br><br>
<a href="<%=request.getContextPath()%>/login/logout">Logout</a>
</body>
</html>
