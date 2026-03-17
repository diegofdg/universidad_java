<!doctype html>
<html data-bs-theme="dark">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Control de Clientes</title>
    <!--Bootstrap CSS-->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    <!--Bootstrap Iconos-->
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.3/font/bootstrap-icons.min.css">
  </head>
  <body>
      <!--Cabecero-->
      <jsp:include page="/WEB-INF/paginas/comunes/cabecero.jsp"/>
      
      <!--Botones de Navegación-->
      <jsp:include page="/WEB-INF/paginas/comunes/botonesNavegacion.jsp"/>
      
      <!--Listado de Clientes-->
      <jsp:include page="/WEB-INF/paginas/cliente/listadoClientes.jsp"/>
      
      <!--Modal agregar un cliente-->
      <jsp:include page="/WEB-INF/paginas/cliente/agregarCliente.jsp"/>
      
      <!--Pie página-->
      <jsp:include page="/WEB-INF/paginas/comunes/piePagina.jsp"/>
      
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
  </body>
</html>