<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
    <head>
        <title><s:text name="bienvenido.titulo" /></title>
    </head>
    <body>
        <h1><s:text name="bienvenido.titulo" /></h1>
        <h2>
            <s:text name="bienvenido.mensaje" />: <s:property value="usuario"/>
        </h2>
        <div>
            <a href="<s:url action="login"/>"><s:text name="bienvenido.regresar" /></a>
        </div>
    </body>
</html>