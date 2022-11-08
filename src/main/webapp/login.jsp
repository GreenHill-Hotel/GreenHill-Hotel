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
</head>
<body>
<div align="center">
    <h1>Logowanie</h1>

<form action="LoginServlet" method="post">
<table>
    <tr>
        <td>E-mail:</td>
        <td><input type="email" name="txtName" placeholder="jan.kowalski@domain.com"></td>
    </tr>
    <tr>
        <td>Hasło:</td>
        <td><input type="password" name="txtPwd" placeholder="Hasło"></td>
    </tr>
    <tr>
        <td><input type="submit" value="Zaloguj"></td>
        <td><a href="register.jsp"><input type="button" value="Rejestracja" ></a></td>
    </tr>
</table>
</form>
</div>
</body>
</html>
