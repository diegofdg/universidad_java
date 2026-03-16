<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Ejemplo MVC</title>
    </head>
    <body>
        <h1>Ejemplo MVC</h1>
        <br/>
        <div style="color:red">${mensaje}</div>
        <br/>
        <a href="${pageContext.request.contextPath}/ServletControlador">
            Link al servlet controlador SIN parámetros
        </a>
        <br/><br/>
        <a href="${pageContext.request.contextPath}/ServletControlador?accion=agregarVariables">
            Link al servlet controlador para agregar las variables
        </a>
        <br/><br/>
        <a href="${pageContext.request.contextPath}/ServletControlador?accion=listarVariables">
            Link al servlet controlador para listar variables
        </a>
    </body>
</html>
