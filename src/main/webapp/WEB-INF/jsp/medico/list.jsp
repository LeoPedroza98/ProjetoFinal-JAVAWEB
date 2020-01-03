<%--
  Created by IntelliJ IDEA.
  User: leona
  Date: 10/12/2019
  Time: 03:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page import ="java.util.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Medico List</title>
</head>
<center>
<body>
<table class="table table-striped">
    <tr>
        <th>
            Edit
        </th>

        <th>
            Delete
        </th>

        <th>
            Id
        </th>

        <th>
            Nome
        </th>

        <th>
            crm
        </th>

        <th>
            Minha Especialidade
        </th>
    </tr>
    <c:forEach var="medico" items="${medicoList}">
        <tr>
            <td>
                <a href="<%=request.getContextPath()%>/medico/edit?id=${medico.id}">Edit</a>
            </td>

            <td>
                <a href="<%=request.getContextPath()%>/medico/delete?id=${medico.id}">Delete</a>
            </td>

            <td>
                ${medico.id}
            </td>

            <td>
                ${medico.nome}
            </td>

            <td>
                ${medico.crm}
            </td>

            <td>
                ${medico.mySpecialty.nome}
            </td>
        </tr>
    </c:forEach>
</table>
<br><br>
<a href="<%=request.getContextPath()%>/medico/create">Create Medico</a>

<br><br>

<a href="<%=request.getContextPath()%>/specialty/list">Specialty List</a>

<br><br>

<a href="<%=request.getContextPath()%>/login/logout">Logout</a>

<script src="https://stackpath.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js" integrity="sha384-vhJnz1OVIdLktyixHY4Uk3OHEwdQqPppqYR8+5mjsauETgLOcEynD9oPHhhz18Nw" crossorigin="anonymous"></script>
</body>
</center>
</html>
