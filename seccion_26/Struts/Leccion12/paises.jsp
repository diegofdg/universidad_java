<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>
<html>
    <head>
        <title>Paises</title>
        <sj:head />
    </head>
    <body>
        <h2>Ejemplo autocompletar con Struts 2 y JQuery (Drop down)</h2>

        <s:form >
            Pais: <sj:autocompleter size="15" list="paises" name="pais"></sj:autocompleter>
                <div class="type-button">
                <sj:submit
                    targets="mostrar"
                    value="Ajax Submit"
                    indicator="indicator"
                    button="true"
                    />
            </div>
        </s:form>

        <br/>
        
        <div id="mostrar">Pais seleccionado:<s:property value="pais"/></div>
    </body>

</html>