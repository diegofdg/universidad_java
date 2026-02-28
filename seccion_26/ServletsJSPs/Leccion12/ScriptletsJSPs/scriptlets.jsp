<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP con ScripletsPage</title>
    </head>
    <body>
        <h1>JSP con Scriplets</h1>
        <br>
        <!--Scriplet para enviar informacion al navegador-->
        <%
            out.println("Saludos desde un scriplet");
        %>
        <br>
        <!-- Scriplet para manipular los objetos implicitos-->
        <%
            String nombreAplicacion = request.getContextPath();
            out.println("nombreAplicacion:" + nombreAplicacion);
        %>
        <br>
        <!--Scriplet con codigo condicionado -->
        <%
            if (session != null && session.isNew()) {
        %>
        la sesion SI es nueva
        <%
        } else if (session != null) {
        %>
        la sesion NO es nueva
        <%
            }
        %>
    </body>
</html>
