<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
    <head>
        <title>Listado Usuarios</title>
    </head>
    <body>
        <h1>Listado de Usuarios</h1>
        <table border="1">
            <tr>
                <th>Username</th>
                <th>Password</th>
                <th>Nombre</th>
                <th>Apellido</th>
            </tr>
            <c:forEach var="usuario" items="${usuarios}">
                <tr>
                    <td>${usuario.username}</td>
                    <td>${usuario.password}</td>
                    <td>${usuario.persona.nombre}</td>
                    <td>${usuario.persona.apellidoPaterno}</td>
                </tr>
            </c:forEach>
        </table>
        <br>
        <a href="index.html">Regresar al Inicio</a>
    </body>
</html>

