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
    <title>Rezerwacje</title>
</head>
<body>
<%
    AvailableRoom availableRoom = (AvailableRoom)request.getAttribute("availableRoom");
    if (availableRoom.getId_room() == 0) {
%>
    <h1>Nie znaleziono wolnego pokoju, przepraszamy.</h1>
<%
} else {
%>
    <h1>Konfiguracja pokoju</h1>
<% } %>
</body>
</html>
