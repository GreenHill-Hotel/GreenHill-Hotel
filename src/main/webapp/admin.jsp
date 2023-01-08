<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="pl.greenhillhotel.greenhillhotel.ReservationBean" %>
<%@ page import="java.util.List" %>

<%--
  Created by IntelliJ IDEA.
  User: jjay31
  Date: 07.01.2023
  Time: 23:23
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>

<html>
<head>
    <title>Panel administracyjny</title>

    <link rel="stylesheet" href="css/style.css">
    <link rel="stylesheet" href="css/checked.css">
    <link rel="stylesheet" href="css/responsive.css">
    <link rel="stylesheet" href="css/admin.css">
</head>

<body>

<% List <ReservationBean> reservationList = (List <ReservationBean>) request.getAttribute("adminReservations"); %>

<main>

    <c:forEach items="${adminReservations}" var="reservation">

        <section class="card">

            <section class="reservation-id">
                <span>${reservation.id_reservation}</span>
            </section>

            <section class="reservation-details">
                <span>Pokój numer ${reservation.id_room}</span>
                <span>${reservation.name} ${reservation.surname}</span>
                <span>Układ łóżek: ${reservation.bed_config}</span>
                <span>Telewizor: ${reservation.tvText}</span>
                <span>Od: ${reservation.accommodation}</span>
                <span>Do: ${reservation.checkout}</span>
            </section>

            <form class="remove-reservation" method="post" action="CancelReservationServlet">
                <button type="submit" name="cancel" value="${reservation.id_reservation}">Anuluj</button>
            </form>

        </section>
    </c:forEach>

</main>

</body>
</html>