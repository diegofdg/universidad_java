<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Ejemplo de Inclusi&oacute;n Din&aacute;mica</title>
    </head>
    <body>
      <br>
      <jsp:include page="WEB-INF/recursoPrivado.jsp">
        <jsp:param name="colorFondo" value="yellow" />
      </jsp:include>

      <br>
      <jsp:include page="recursoPublico.jsp" />
    </body>
</html>