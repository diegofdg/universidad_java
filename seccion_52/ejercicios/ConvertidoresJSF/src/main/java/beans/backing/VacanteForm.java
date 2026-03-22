package beans.backing;

import beans.model.Candidato;
import jakarta.enterprise.context.RequestScoped;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Named("vacanteForm")
@RequestScoped
public class VacanteForm {
    private final Logger log = LoggerFactory.getLogger(VacanteForm.class);

    @Inject
    private Candidato candidato;

    public String enviar() {
        if ("Juan".equals(candidato.getNombre()) && "Perez".equals(candidato.getApellido())) {
            String msg = "Gracias Juan Perez, te has registrado correctamente.";
            FacesMessage facesMessage = new FacesMessage(FacesMessage.SEVERITY_ERROR, msg, null);
            FacesContext.getCurrentInstance().addMessage(null, facesMessage);
            log.info("Usuario registrado correctamente");
            return "index"; // Redirige a la misma página
        }
        log.info("Datos de usuario inválidos");
        return "fallo"; // Redirige a una página de éxito
    }
}
