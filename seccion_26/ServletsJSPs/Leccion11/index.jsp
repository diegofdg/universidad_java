<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
  <head>
    <meta charset="UTF-8">
    <title>Hola Mundo JSP</title>
  </head>
  <body>
    <h1>Ejercicio de Hola Mundo con JSPs</h1>
    <!--Impresion de cadenas con diferentes tecnologias-->
    <ul>
      <li> Hola Mundo con HTML
      <li> <% out.print("Hola Mundo con Scriptlets");%>
      <li> ${"Hola Mundo con Expression Language (EL)"}
      <li> <c:out value="Hola Mundo con JSTL" />
    </ul>
    <!-- Algunos valores del lado del servidor -->
    <ul>
      <li> Hola: <%= new java.util.Date()%>
      <li> Nombre del Contexto de la aplicaci&oacute;n:
        <%= request.getContextPath()%>
      <li> Valor del par&aacute;metro x:
        <%= request.getParameter("x")%>
    </ul>
  </body>
</html>
