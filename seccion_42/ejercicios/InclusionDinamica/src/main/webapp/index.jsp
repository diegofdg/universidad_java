<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Ejemplo de Inclusión Dinámica</title>
    </head>
    <body>
        <h1>Ejemplo de Inclusión Dinámica</h1>
        <br/>
        <!--Inclusion de un recurso publico-->
        <jsp:include page="paginas/recursoPublico.jsp"/>
        <br/>
        <!--Inclusion de un recurso privado con parametros-->
        <jsp:include page="WEB-INF/recursoPrivado.jsp">
            <jsp:param name="colorFondo" value="blue"/>
        </jsp:include>
    </body>
</html>
