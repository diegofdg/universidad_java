package mx.com.gm.capaweb;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import mx.com.gm.capadatos.domain.Persona;
import mx.com.gm.capaservicio.PersonaService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.DynaActionForm;
import org.apache.struts.actions.DispatchAction;

public class PersonaAction extends DispatchAction {

    // Atributo que sera inyectado por Spring
    private PersonaService personaService;

    public void setPersonaService(PersonaService personaService) {
        this.personaService = personaService;
    }

    private final Logger logger = LogManager.getRootLogger();

    public ActionForward accionListar(ActionMapping mapping, ActionForm form,
            HttpServletRequest req, HttpServletResponse res) throws Exception {
        logger.info("Ejecutando metodo listar");
        this.setListaPersonas(req);
        return mapping.findForward("listar");
    }

    private void setListaPersonas(HttpServletRequest req) {
        List<Persona> personas = this.personaService.listarPersonas();
        // Compartimos la lista de objetos persona con el JSP
        req.setAttribute("personas", personas);
        // Desplegamos solo para validar
        for (Persona persona : personas) {
            logger.info("Persona:" + persona);
        }
    }
}