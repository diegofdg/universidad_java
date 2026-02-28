<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Ajax con Jquery y Struts 2</title>
        <sj:head/>
    </head>
    <body>
        <h2>Introduce tu nombre</h2>

        <s:form >
                <s:textfield name="nombre" />
            <div class="type-button">
                <sj:submit
                    targets="mostrar"
                    value="Ajax Submit"
                    indicator="indicator"
                    button="true"
                    />
            </div>
        </s:form>

        <div id="mostrar"><h4><s:property value="nombre"/></h4></div>

    </body>
</html>