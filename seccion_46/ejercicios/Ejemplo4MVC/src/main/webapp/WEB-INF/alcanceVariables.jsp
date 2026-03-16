<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Alcance de Variables</title>
    </head>
    <body>
        <h1>Alcance de Variables</h1>
        <br/>
        Variable request:
        Base: ${rectanguloRequest.base}
        Altura: ${rectanguloRequest.altura}
        Área: ${rectanguloRequest.area}
        <br/><br/>
        Variable session:
        Base: ${rectanguloSession.base}
        Altura: ${rectanguloSession.altura}
        Área: ${rectanguloSession.area}
        <br/><br/>
        Variable application:
        Base: ${rectanguloApplication.base}
        Altura: ${rectanguloApplication.altura}
        Área: ${rectanguloApplication.area}
        <br/><br/>
        <a href="${pageContext.request.contextPath}/index.jsp">Regresar al inicio</a>
        
    </body>
</html>
