package test;

import servletunit.struts.MockStrutsTestCase;

public class TestPersonaAction extends MockStrutsTestCase {

    public void testListar() {
        System.out.println();
        logger.info("Inicio test Listar con Struts");
        setRequestPathInfo("/inicio");
        addRequestParameter("metodo", "accionListar");
        actionPerform();
        verifyForward("listar");
        logger.info("Se redirecciono exitosamente");
        verifyNoActionErrors();
        logger.info("Fin test Listar con Struts");
        System.out.println();
    }
}