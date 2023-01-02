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
<div align="center">
    <h1>Rejestracja</h1>

    <form action="RegistrationServlet" method="post" onsubmit="return validate()">
        <table>
            <tr><td>Imię:</td><td><input type="text" id="first_name" name="first_name" placeholder="Jan"></td></tr>
            <tr><td>Nazwisko:</td><td><input type="text" id="last_name" name="last_name" placeholder="Kowalski"></td></tr>
            <tr><td>E-mail:</td><td><input type="email" id="mail" name="mail" placeholder="jan.kowalski@domain.com"></td></tr>
            <tr><td>Hasło:</td><td><input type="password" id="password" name="password" placeholder="Hasło"></td></tr>
            <tr><td>Powtórz hasło:</td><td><input type="password" id="password2" name="password2" placeholder="Hasło"></td></tr>
            <tr>
                <td><%=(request.getAttribute("errMessage") == null) ? ""
                        : request.getAttribute("errMessage")%></td>
            </tr>
                <tr><td><input type="submit" value="Zarejestruj"></td>
                <td><a href="login.jsp"><input type="button" value="Logowanie" ></a></td></tr>
        </table>
    </form>
</div>
</body>
</html>
