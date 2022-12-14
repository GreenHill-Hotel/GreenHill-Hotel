<%--
  Created by IntelliJ IDEA.
  User: jjay31
  Date: 08.11.2022
  Time: 17:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Logowanie</title>

    <link rel="stylesheet" href="css/style.css">
    <link rel="stylesheet" href="css/checked.css">
    <link rel="stylesheet" href="css/responsive.css">
    <link rel="stylesheet" href="css/register-login.css">

    <script src="https://www.google.com/recaptcha/api.js" async defer></script>

    <script defer>
        var onRecaptchaSuccess = function() {
            document.querySelector('#if-captcha').disabled = false
        }
    </script>
</head>
<body>
<div class="main">
    <h1>Logowanie</h1>

    <form action="LoginServlet" method="post">
        <section>
            <label for="mail">E-mail:</label>
            <input type="email" class="book_n" id="mail" name="mail" placeholder="jan.kowalski@domain.com">
        </section>

        <section>
            <label for="password">Hasło:</label>
            <input type="password" class="book_n" id="password" name="password" placeholder="Hasło">
        </section>

        <section class="captcha">
            <div
                    class="g-recaptcha"
                    data-sitekey="6Lffq9UjAAAAAByKOAuSqL8JzgepMUwnNkjBO_vq"
                    data-callback="onRecaptchaSuccess"
                    <%--                    data-expired-callback="onRecaptchaResponseExpiry"--%>
                    <%--                    data-error-callback="onRecaptchaError"--%>
            >
            </div>
        </section>

        <section class="button-wrapper">
            <button class="book_btn right" type="submit" id="if-captcha" disabled>Zaloguj się</button>
            <a href="register.jsp"><button class="book_btn" type="button">Rejestracja</button></a>
        </section>
    </form>
</div>
</body>
</html>
