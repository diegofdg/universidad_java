<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib  prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
    <head>
        <title>Formulario Personas</title>
        <%--Agregamos los estilos basicos de Struts 2 --%>
        <s:head />
    </head>
    <body>
        <h1>Formulario de Personas (OGNL)</h1>
        <s:form>
            <s:textfield label="Nombre" name="persona.nombre" />
            <s:textfield label="Calle (Domicilio)" name="persona.domicilio.calle" />
            <s:textfield label="No. Calle (Domicilio)" name="persona.domicilio.numeroCalle" />
             <s:textfield label="Pais" name="persona.domicilio.pais" />
             <s:submit value="Enviar"/>
        </s:form>
        
        <h2>Valores proporcionados</h2>
        Nombres: <s:property value="persona.nombre"/></br>
        Calle <s:property value="persona.domicilio.calle"/></br>
        No. Calle: <s:property value="persona.domicilio.numeroCalle"/></br>
        Pais: <s:property value="persona.domicilio.pais"/></br>
        
    </body>
</html>
