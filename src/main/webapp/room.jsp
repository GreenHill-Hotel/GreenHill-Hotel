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
        AvailableRoom availableRoom = (AvailableRoom)request.getAttribute("availableRoom");
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

                <form action="RegistrationServlet" method="post">

                    <section class="info">
                        <h2 class="info-title">Informacje:</h2>

                        <span class="room-id">Pokój numer: <span class="highlight">ID</span></span>
                        <span class="accommodation">Data przyjazdu: <span class="highlight">01-02-2023</span></span>
                        <span class="checkout">Data wymeldowania: <span class="highlight">01-04-2023</span></span>
                        <span class="people">Liczba osób: <span class="highlight">2</span></span>
                        <span class="balcony">Balkon: <span class="highlight">Nie</span></span>
                    </section>

                    <section class="conf">
                        <h2 class="conf-title">Konfiguracja:</h2>

                        <section class="beds">
                            <label for="bed-set">Wybierz uklad lozek:</label>

                            <select name="bed-set" id="bed-set">
                                <option value="11">1+1</option>
                                <option value="2">2</option>
                            </select>
                        </section>

                        <section class="tv">
                            <span>Telewizor w pokoju:</span>

                            <div class="toggle-pill-color" id="with-balcony-check">
                                <input type="checkbox" id="pill3" name="balcony" value="balcony">
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
