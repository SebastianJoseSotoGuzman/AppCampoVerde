<%-- 
    Document   : proveedores
    Created on : 26 may 2024, 22:43:27
    Author     : Lumar
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Registro de Empleado</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
    </head>
    <body>
        <div class="container">
            <h1>Registro de Empleado</h1><br>

            <form action="RegistrarEmpleado" method="post" class="row g-3 needs-validation" novalidate>


                <div class="row">
                    <div class="col-sm-4">
                        <label for="nombres" class="form-label">Nombre:</label>
                        <input type="text" name="nombres" id="nombres" class="form-control" placeholder="" required>
                        <div class="valid-feedback">
                            Completado
                        </div> 
                    </div>
                    <div class="col-sm-4">
                        <label for="apellidos" class="form-label">Apellidos:</label>
                        <input type="text" name="apellidos" id="apellidos" class="form-control" placeholder="" required>
                        <div class="valid-feedback">
                            Completado
                        </div> 
                    </div>
                    <div class="col-sm-4">
                        <label for="dni" class="form-label">DNI:</label>
                        <input type="text" name="dni" id="dni" class="form-control" placeholder="" required>
                        <div class="valid-feedback">
                            Completado
                        </div> 
                    </div>
                </div>

                <div class="row">
                    <div class="col-sm-4">
                        <label for="telefono" class="form-label">Telefono:</label>
                        <input type="tel" class="form-control" name="telefono" id="telefono" placeholder="" required>
                        <div class="valid-feedback">
                            Completado
                        </div> 
                    </div>
                    <div class="col-sm-4">
                        <label for="area_id" class="form-label">Area:</label>
                        <select class="form-select" id="area_id" name="area_id" required>
                            <option selected disabled value="">Seleccione...</option>
                            <option value="1">Administracion</option>
                            <option value="2">Almacen</option>
                            <option value="2">Vendedores</option>
                        </select>
                        <div class="invalid-feedback">
                            Por favor seleccione.
                        </div>
                    </div>
                    <div class="col-sm-4">
                        <label for="cargo_id" class="form-label">Cargo:</label>
                        <select class="form-select" id="cargo_id" name="cargo_id" required>
                            <option selected disabled value="">Seleccione...</option>
                            <option value="1">Administrador</option>
                            <option value="2">Almacenero</option>
                            <option value="2">Vendedor</option>
                        </select>
                        <div class="invalid-feedback">
                            Por favor seleccione.
                        </div>
                    </div>
                </div>

                <div class="row">
                    <div class="col-sm-4">
                        <label for="fecha_hora">Fecha de Registro:</label>
                        <input type="date" id="fecha_hora" name="fecha_hora" class="form-control" required>
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
