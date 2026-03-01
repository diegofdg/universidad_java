
<html>
    <head>
        <meta charset="UTF-8">
        <title>JSP que lee valores del JavaBean</title>
    </head>
    <body>
        <h1>JSP que lee valores del JavaBean</h1>
        <!-- Declaramos el javabean a utilizar
        si ya existe un bean en la sesion llamado "rectangulo",
        regresa el mismo objeto y no crea uno nuevo-->
        <jsp:useBean id="rectangulo"
                     class="beans.Rectangulo" scope="session" />

        <!--REcuperamos los valores y los desplegamos-->
        <br>
        Valor base: <jsp:getProperty name="rectangulo" property="base" />
        <br>
        Valor altura: <jsp:getProperty name="rectangulo" property="altura" />
        <br>
        <!-- En este caso, no importa que la propiedad no exista
        en el JavaBean, solo con tener un metodo llamado getArea()
        es posible simular una propiedad -->
        Valor &aacute;rea: <jsp:getProperty name="rectangulo" property="area" />
        <br>
        <br>
        <a href="index.jsp">Regresar al Inicio</a>

    </body>
</html>
