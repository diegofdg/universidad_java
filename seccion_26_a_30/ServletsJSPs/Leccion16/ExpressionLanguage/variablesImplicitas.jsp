<html>
    <head>
        <meta charset="UTF-8">
        <title>El y Variables Implicitas</title>
    </head>
    <body>
        <h1>EL y Variables Implicitas</h1>

        <ul>
            <li>Nombre Aplicaci&oacute;n: ${pageContext.request.contextPath}</li>
            <li>Navegador del Cliente: ${ header["User-Agent"] }
            <li>Id Session: ${cookie.JSESSIONID.value}</li>
            <li>Web Server: ${pageContext.servletContext.serverInfo}
            <li>Valor Par&aacute;metro Usuario: ${param["usuario"]}</li>
        </ul>

        <br>
        <br>
        <a href="index.jsp">Regresar al Inicio</a>

    </body>
</html>
