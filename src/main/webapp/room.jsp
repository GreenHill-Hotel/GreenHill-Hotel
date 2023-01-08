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
    <title>Rezerwacja pobytu</title>

    <link rel="stylesheet" href="css/style.css">
    <link rel="stylesheet" href="css/checked.css">
    <link rel="stylesheet" href="css/responsive.css">
    <link rel="stylesheet" href="css/configurator.css">
    <link rel="stylesheet" href="css/checked.css">
</head>
<body>
    <%
        AvailableRoom availableRoom = (AvailableRoom)session.getAttribute("availableRoom");
        if (availableRoom.getId_room() == 0) {
    %>

        <main class="error">
            <h1>Nie znaleziono wolnego pokoju.</h1>
            <h2>Przepraszamy, spróbuj zmienić parametry wyszukiwania!</h2>
        </main>

    <%
    } else {
    %>

        <main class="configurator">

            <h1>Rezerwacja pobytu:</h1>

            <section class="box">

                <form action="ReservationServlet" method="post">

                    <section class="info">
                        <h2 class="info-title">Informacje:</h2>

                        <span class="room-id">Pokój numer: <span class="highlight"><%=availableRoom.getId_room()%></span></span>
                        <span class="accommodation">Data przyjazdu: <span class="highlight"><%=availableRoom.getAccommodation()%></span></span>
                        <span class="checkout">Data wymeldowania: <span class="highlight"><%=availableRoom.getCheckout()%></span></span>
                        <span class="people">Liczba osób: <span class="highlight"><%=availableRoom.getPeople()%></span></span>
                        <span class="balcony">Balkon: <span class="highlight"><%=availableRoom.getBalconyText()%></span></span>
                    </section>

                    <section class="conf">
                        <h2 class="conf-title">Konfiguracja:</h2>

                        <section class="beds">
                            <label for="bed-set">Wybierz układ łóżek:</label>

                            <select name="bed-set" id="bed-set">

                            <% if (availableRoom.getPeople() == 1) { %>
                                <option value="1">1</option>
                            <% } else if (availableRoom.getPeople() == 2) { %>
                                <option value="1+1">1+1</option>
                                <option value="2">2</option>
                            <% } else { %>
                                <option value="1+1+1">1+1+1</option>
                                <option value="2+1">2+1</option>
                            <% } %>

                            </select>

                        </section>

                        <section class="tv">
                            <span>Telewizor w pokoju:</span>

                            <div class="toggle-pill-color" id="with-balcony-check">
                                <input type="checkbox" id="pill3" name="tv" value="tv">
                                <label for="pill3"></label>
                            </div>
                        </section>

                    </section>

                    <section class="summary">

                        <button class="reserve book_btn" type="submit">Zarezerwuj</button>

                    </section>

                </form>

            </section>

        </main>

    <% } %>
</body>
</html>
