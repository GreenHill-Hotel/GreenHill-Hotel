<%@ page import="pl.greenhillhotel.greenhillhotel.AvailableRoom" %><%--
  Created by IntelliJ IDEA.
  User: jjay31
  Date: 05.01.2023
  Time: 19:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%
        AvailableRoom availableRoom = (AvailableRoom)request.getAttribute("availableRoom");
        if (availableRoom.getId_room() == 0) {
    %>
    <title>Nie znaleziono wolnego pokoju, przepraszamy.</title>
    <%
        } else {
    %>
    <title>Konfiguracja pokoju</title>
    <% } %>
</head>
<body>

</body>
</html>
