package beans.backing;

import beans.model.Candidato;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;

@Named("vacanteForm")
@RequestScoped
public class VacanteForm {
    
    @Inject 
    private Candidato candidato;
    
    public void setCandidato(Candidato candidato){
        this.candidato = candidato;
    }
    
    public String enviar(){
        if(this.candidato.getNombre().equals("Juan")){
            return "exito?faces-redirect=true";//exito.xhtml
        }
        else{
            return "fallo?faces-redirect=true";//fallo.xhtml
        }
    }
}
