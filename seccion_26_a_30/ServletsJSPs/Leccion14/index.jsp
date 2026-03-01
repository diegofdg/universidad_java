<html>
  <head>
    <title>Ejemplo Inclusion Estatica</title>
    <script type='text/JavaScript' src="recursos/funciones.js"></script>
    <link href="recursos/estilos.css" type="text/css" rel="stylesheet">
  </head>
  <body>
    <h1>Inclusi&oacute;n de Archivos Estáticos</h1>

    <!--Esto es por cada menu-->
    <br>
    <!--menu principal-->
    <span class="noticias" align="left">
      <a href="javascript:desplegar ('noticias');">
        <img border="0" src="http://icursos.net/cursos/ServletsJSPs/Leccion14/noticias.gif">
      </a>
    </span>
    <span id="noticias" class="ocultar_menu">
      <!--Submenu-->
      <ul>
        <li><%@include file="pages/noticia1.html" %></li>
        <li><%@include file="pages/noticia2.html" %></li>
      </ul>
    </span>

     <!--Esto es por cada menu-->
    <br>
    <!--menu principal-->
    <span class="videos" align="left">
      <a href="javascript:desplegar ('videos');">
        <img border="0" src="http://icursos.net/cursos/ServletsJSPs/Leccion14/videos.gif">
      </a>
    </span>
    <span id="videos" class="ocultar_menu">
      <!--Submenu-->
      <ul>
        <li><%@include file="pages/video1.html" %></li>
      </ul>
    </span>

  </body>
</html>