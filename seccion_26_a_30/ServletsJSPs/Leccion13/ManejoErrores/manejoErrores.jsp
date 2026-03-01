<%@page isErrorPage="true" %>
<%@ page import="java.io.*" %>

<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Manejo Errores</title>
    <script type="text/javascript" src="<%=request.getContextPath()%>/recursos/funciones.js">
    </script>
  </head>
  <body>
    <h1>Manejo de Errores</h1>
    <br>
    <br>
    Ocurri&oacute; un error:
    <%= exception.getMessage()%>
    <br>
    <br>
    <a href="<%=request.getContextPath()%>/index.html">Regresar al Inicio</a>
    <br>
    <br>
    <a href="#" onclick="cambio('mensaje1')">
      Ver detalles
    </a>
    <div id="mensaje1" style="position:relative;visibility: hidden">
      <PRE>
        <% exception.printStackTrace(new PrintWriter(out));%>
      </PRE>
    </div>

  </body>
</html>
