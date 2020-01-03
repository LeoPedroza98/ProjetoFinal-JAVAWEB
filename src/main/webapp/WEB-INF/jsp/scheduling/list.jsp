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
</head>
<h1>
    Scheduling List
</h1>
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
            dataScheduling
        </th>

        <th>
            Medico
        </th>

        <th>
            Person
        </th>
    </tr>
    <c:forEach var="scheduling" items="${schedulingList}">
        <tr>
            <td>
                <a href="<%=request.getContextPath()%>/scheduling/edit?id=${scheduling.id}">Edit</a>
            </td>

            <td>
                <a href="<%=request.getContextPath()%>/scheduling/delete?id=${scheduling.id}">Delete</a>
            </td>

            <td>
                    ${scheduling.id}
            </td>

            <td>
                    ${scheduling.dataFormatada}
            </td>

            <td>
                    ${scheduling.medico.nome}
            </td>

            <td>
                    ${scheduling.person.nome}
            </td>
        </tr>
    </c:forEach>
</table>
<a href="<%=request.getContextPath()%>/scheduling/create">Create Scheduling</a>
<br><br>
<a href="<%=request.getContextPath()%>/login/logout">Logout</a>

<script src="https://stackpath.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js" integrity="sha384-vhJnz1OVIdLktyixHY4Uk3OHEwdQqPppqYR8+5mjsauETgLOcEynD9oPHhhz18Nw" crossorigin="anonymous"></script>

</body>
</html>
