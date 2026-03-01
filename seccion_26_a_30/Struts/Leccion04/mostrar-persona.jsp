<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib  prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
    <head>
        <title><s:property value="titulo" /></title>
    </head>
    <body>
        <%--Formulario Struts 2--%>
        <h1><s:property value="titulo" /></h1>
        <s:form>
            <s:textfield name="nombre" />
            <s:submit key="persona.boton" name="submit" />
        </s:form>

        <%--Desplegamos el valor del atributo nombre de la clase Action--%> 
        <div><s:property value="valor" />:
            <s:property value="nombre" /></div>
    </body>
</html>
