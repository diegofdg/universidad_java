<html>
  <head>
    <meta charset="UTF-8">
    <title>Ejemplo MVC 2</title>
  </head>
  <body>
    <h1>Ejemplo MVC 2</h1>
    <div style="color:red"> ${mensaje} </div>
    <br>
    <a href="${pageContext.request.contextPath}/ServletControlador">
      Link al servlet controlador sin parametros
    </a>
    <br><br>
    <a href="${pageContext.request.contextPath}/ServletControlador?accion=agregaVariables">
      Link al servlet controlador para agregar las variables
    </a>
    <br><br>
    <a href="${pageContext.request.contextPath}/ServletControlador?accion=listarVariables">
      Link al servlet controlador para listar las variables
    </a>
  </body>
</html>