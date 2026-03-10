<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSPs con Expresiones</title>
    </head>
    <body>
        <h1>JSPs con Expresiones!</h1>
        Concatenación: <%= "Saludos" + " " + "desde un JSPs" %>
        <br/>
        Operación Matemática: <%= 2 * 3 / 2 %>
        <br/>
        Id de la sesión: <%= session.getId() %>
        <br/><br/>
        <a href="index.html">Regresar al inicio</a>
    </body>
</html>
