<%-- 
    Document   : index
    Created on : 7 may 2024, 1:35:19
    Author     : Lumar
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Login Form</title>
    <link rel="stylesheet" href="css/login.css">
</head>
<body>
    <div class="login-container">
        <div class="login-box">
            <img src="img/user.png" alt="Logo" class="logo">
            <h2>Login</h2>
            <form action="LoginServlet" method="post">
                <div class="input-group">
                    <input type="text" id="username" name="username"equired>
                    <label for="username">Usuario</label>
                </div>
                <div class="input-group">
                    <input type="password" id="password" name="password"required>
                    <label for="password">Constraseña</label>
                </div>
                <button type="submit" class="button">Ingresar</button>
               
            </form>
        </div>
    </div>
</body>
</html>
