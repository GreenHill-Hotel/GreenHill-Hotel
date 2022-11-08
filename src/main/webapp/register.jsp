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
</head>
<body>
<div align="center">
    <h1>Rejestracja</h1>

    <form action="RegistrationServlet" method="post">
        <table>
            <tr><td>Imię:</td><td><input type="text" name="txtName" placeholder="Jan"></td></tr>
            <tr><td>Nazwisko:</td><td><input type="text" name="txtName" placeholder="Kowalski"></td></tr>
            <tr><td>E-mail:</td><td><input type="email" name="txtName" placeholder="jan.kowalski@domain.com"></td></tr>
            <tr><td>Hasło:</td><td><input type="password" name="txtPwd" placeholder="Hasło"></td></tr>
            <tr><td>Powtórz hasło:</td><td><input type="password" name="txtPwd" placeholder="Hasło"></td></tr>
                <tr><td><input type="submit" value="Zarejestruj"></td>
                <td><a href="login.jsp"><input type="button" value="Logowanie" ></a></td></tr>
        </table>
    </form>
</div>
</body>
</html>
