<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib  prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
    <head>
        <title><s:text name="titulo" /></title>
        <s:head />
    </head>
    <body>
        <h1><s:text name="titulo" /></h1>
        <s:form>
            <s:textfield name="nombre" key="nombre" />
            <s:submit key="enviar"/>
        </s:form>

        <s:if test='nombre!=null && !"".equals(nombre.trim())'>
            <s:text name="nombre.enviado" /> <s:property value="nombre" />     
        </s:if>

        <br/>
        <br/>
        <%-- Creamos los URL--%>
        <s:url var="localeES" action="mensajes" >
            <s:param name="request_locale" >es</s:param>
        </s:url>
        <s:url var="localeEN" action="mensajes" >
            <s:param name="request_locale" >en</s:param>
        </s:url>

        <%-- Utilizamos los URL. El parametro request_locale cambia de idioma --%>    
        <s:a href="%{localeES}" ><s:text name="idioma.espanol" /></s:a>
        |
        <s:a href="%{localeEN}" ><s:text name="idioma.ingles" /></s:a>

    </body>
</html>
