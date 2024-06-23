<%-- 
    Document   : proveedores
    Created on : 26 may 2024, 22:43:27
    Author     : Lumar
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Registro de Empleado</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
    </head>
    <body>
        <div class="container">
            <h1>Registro de Usuarios</h1><br>
            <form action="RegistrarUsuario" method="post" class="row g-3 needs-validation" novalidate>
                <div class="row">
                    <div class="col-sm-4">
                        <label for="usuario" class="form-label">Usuario:</label>
                        <input type="text" name="usuario" id="usuario" class="form-control" placeholder="" required>
                        <div class="valid-feedback">
                            Completado
                        </div> 
                    </div>
                    <div class="col-sm-4">
                        <label for="pass" class="form-label">Constrseña:</label>
                        <input type="password" name="pass" id="pass" class="form-control" placeholder="" required>
                        <div class="valid-feedback">
                            Completado
                        </div> 
                    </div>
                </div>
                <div class="row">
                    <div class="col-sm-4">
                        <label for="empleado" class="form-label">Empleado:</label>
                        <select class="form-select" id="empleado" name="empleado" required>
                            <option selected disabled value="">Seleccione...</option>
                            <option value="1">3</option>
                            <option value="2">4</option>
                            <option value="2">5</option>
                        </select>
                        <div class="invalid-feedback">
                            Por favor seleccione.
                        </div>
                    </div>
                   
                </div>
                <div class="col-sm-12">
                    <button type="button" class="btn btn-success" onclick="return limpiar();">
                        Nuevo
                    </button>
                    <button type="submit" class="btn btn-primary" value="Registrar">
                        Registrar
                    </button>
                    <button type="submit" class="btn btn-warning">
                        Modificar
                    </button>
                    <button type="button" class="btn btn-danger">
                        Eliminar
                    </button> 
                </div>

            </form>
        </div>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL" crossorigin="anonymous"></script>
    </body>

</html>
