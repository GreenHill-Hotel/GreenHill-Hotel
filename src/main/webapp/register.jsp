<%--
  Created by IntelliJ IDEA.
  User: jjay31
  Date: 08.11.2022
  Time: 18:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Rejestracja</title>

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

    <script>
        function validate()
        {
            let first_name = document.getElementById('first_name').value;
            let last_name = document.getElementById('last_name').value;
            let email = document.getElementById('mail').value;
            let password = document.getElementById('password').value;
            let password2= document.getElementById('password2').value;

            if (first_name==null || first_name==="" || first_name === undefined)
            {
                alert("First name can't be blank");
                return false;
            }
            else if (last_name==null || last_name==="")
            {
                alert("Last name can't be blank");
                return false;
            }
            else if (email==null || email==="")
            {
                alert("Email can't be blank");
                return false;
            }

            else if(password.length<6)
            {
                alert("Password must be at least 6 characters long.");
                return false;
            }
            else if (password!==password2)
            {
                alert("Passwords should match");
                return false;
            }
        }
        </script>
</head>
<body>
<div class="main">
    <h1>Rejestracja</h1>

    <form action="RegistrationServlet" method="post" onsubmit="return validate()">

        <section>
            <label for="first_name">Imię:</label>
            <input type="text" class="book_n" id="first_name" name="first_name" placeholder="Jan">
        </section>

        <section>
            <label for="last_name">Nazwisko:</label>
            <input type="text" class="book_n" id="last_name" name="last_name" placeholder="Kowalski">
        </section>

        <section>
            <label for="mail">E-mail:</label>
            <input type="email" class="book_n" id="mail" name="mail" placeholder="jan.kowalski@domain.com">
        </section>

        <section>
            <label for="password">Utwórz hasło:</label>
            <input type="password" class="book_n" id="password" name="password" placeholder="Hasło">
        </section>

        <section>
            <label for="password2">Powtórz hasło:</label>
            <input type="password" class="book_n" id="password2" name="password2" placeholder="Hasło">
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
            <button class="book_btn" type="submit" id="if-captcha" disabled>Zarejestruj</button>
            <a href="login.jsp"><button class="book_btn" type="button">Logowanie</button></a>
        </section>
    </form>
</div>
</body>
</html>
