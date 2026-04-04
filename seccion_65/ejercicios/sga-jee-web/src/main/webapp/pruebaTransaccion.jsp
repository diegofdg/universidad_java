<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Prueba de Manejo Transaccional</title>
</head>
<body>
    <h2>Modificar Persona</h2>
    <form action="pruebaTransaccion" method="post">
        <label>ID Persona:</label>
        <input type="number" name="idPersona" required>
        <br>
        <label>Nuevo Apellido:</label>
        <input type="text" name="apellido" required>
        <br>
        <button type="submit">Modificar</button>
    </form>
</body>
</html>
