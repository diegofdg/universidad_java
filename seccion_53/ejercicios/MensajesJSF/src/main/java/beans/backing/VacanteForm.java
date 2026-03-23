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
    
     private static final Logger log = LoggerFactory.getLogger(VacanteForm.class);
    
    @Inject 
    private Candidato candidato;
    
    public void setCandidato(Candidato candidato){
        this.candidato = candidato;
    }
    
    public String enviar(){
        log.info("Procesando solicitud para: " + this.candidato.getNombre());
        
        if("Juan".equals(this.candidato.getNombre()) && "Perez".equals(this.candidato.getApellido())){
            String msg = "Gracias Juan Perez, te has registrado correctamente";
            FacesMessage facesMessage = new FacesMessage(FacesMessage.SEVERITY_INFO, msg, null);
            FacesContext.getCurrentInstance().addMessage(null, facesMessage);
            log.info("Usuario registrado correctamente");
            //return "exito?faces-redirect=true";//exito.xhtml
            return "index";
        }
        else{
            log.info("Datos de usuario invalidos");
            return "fallo?faces-redirect=true";//fallo.xhtml
        }
    }
}
