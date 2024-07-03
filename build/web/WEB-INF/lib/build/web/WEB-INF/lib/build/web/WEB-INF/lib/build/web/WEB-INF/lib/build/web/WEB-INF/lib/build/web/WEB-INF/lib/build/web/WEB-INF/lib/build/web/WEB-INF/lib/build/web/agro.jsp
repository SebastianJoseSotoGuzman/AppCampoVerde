<%-- 
    Document   : agro
    Created on : 27 may 2024, 20:30:31
    Author     : Lumar
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Campo-Verde</title>
        <link rel="stylesheet" href="css/agro.css">
    </head>
    <body>
        <div class="catalog-container">
            <!--  <h1>Bienvenido <%= request.getSession().getAttribute("username") %> </h1> -->
            <h1>Agropecuaria CampoVerde - Sistema de Inventario</h1>
            <div class="product-grid">
                <div class="product-item">
                    <img src="img/baca.jpeg" alt="Product 1">
                    <h2>VACA</h2>
                    <p>S/.</p>
                </div>
                <div class="product-item">
                    <img src="img/cerdo.jpeg" alt="Product 2">
                    <h2>CERDOS</h2>
                    <p>S/.</p>
                </div>
                <div class="product-item">
                    <img src="img/pollo.jpg" alt="Product 3">
                    <h2>POLLOS</h2>
                    <p>S/.</p>
                </div>
                <div class="product-item">
                    <img src="img/uva.jpg" alt="Product 4">
                    <h2>UVAS</h2>
                    <p>S/.</p>
                </div>
                <div class="product-item">
                    <img src="img/palta.jpg" alt="Product 5">
                    <h2>PALTA</h2>
                    <p>S/.</p>
                </div>
                <div class="product-item">
                    <img src="img/mango.jpeg" alt="Product 6">
                    <h2>MANGO</h2>
                    <p>S/.</p>
                </div>
            </div>
        </div>
    </body>
</html>
