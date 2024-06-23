<%-- 
    Document   : index
    Created on : 27 may 2024, 1:12:05
    Author     : Lumar
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Campo-Verde</title>
    <link rel="stylesheet" href="css/sider.css">
</head>
<body>
    <div class="container">
        <div class="sidebar">
            <div class="user-profile">
                <img src="img/user.png" alt="User Image">
                <h2>Bienvenido</h2>
                <h2><%= request.getSession().getAttribute("username") %></h2>
            </div>
            <ul class="menu">
                <li>
                    <a href="#" onclick="loadPage('agro.jsp')">
                        <img src="img/home.png" alt="Home Icon">
                        <span>Home</span>
                    </a>
                </li>
                <li>
                    <a href="#">
                        <img src="img/registro.png" alt="Profile Icon">
                        <span>Registro</span>
                    </a>
                    <ul class="submenu">
                        <li><a href="#" onclick="loadPage('empleados.jsp')">Empleado</a></li>
                        <li><a href="#" onclick="loadPage('productos.jsp')">Productos</a></li>
                        <li><a href="#" onclick="loadPage('proveedores.jsp')">Proveedores</a></li>
                        <li><a href="#" onclick="loadPage('usuario.jsp')">Usuario</a></li>
                    </ul>
                </li>
                <li>
                    <a href="#">
                        <img src="img/report.png" alt="Profile Icon">
                        <span>Almacen</span>
                    </a>
                    <ul class="submenu">
                        <li><a href="#" onclick="loadPage('empleados.jsp')">Entradas</a></li>
                        <li><a href="#" onclick="loadPage('productos.jsp')">Salidas</a></li>                        
                    </ul>
                </li>
                <li>
                    <a href="#">
                        <img src="img/report.png" alt="Profile Icon">
                        <span>Reportes</span>
                    </a>
                    <ul class="submenu">
                        <li><a href="#" onclick="loadPage('empleados.jsp')">Empleado</a></li>
                        <li><a href="#" onclick="loadPage('productos.jsp')">Productos</a></li>
                        <li><a href="#" onclick="loadPage('proveedores.jsp')">Proveedores</a></li>
                    </ul>
                </li>
                
            </ul>
        </div>
        <div class="main-content">
            <iframe id="content-frame" src="agro.jsp" frameborder="0"></iframe>
        </div>
    </div>

    <script>
        function loadPage(page) {
            document.getElementById('content-frame').src = page;
        }
    </script>
</body>
</html>


