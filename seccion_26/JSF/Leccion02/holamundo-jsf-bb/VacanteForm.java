package beans.backing;

import beans.model.Candidato;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

@ManagedBean
@RequestScoped
public class VacanteForm {

  @ManagedProperty(value="#{candidato}")
  private Candidato candidato;

  public void setCandidato(Candidato candidato) {
    this.candidato = candidato;
  }

  public String enviar() {
    if (this.candidato.getNombre().equals("Juan")) {
      return "exito";
    } else {
      return "fallo";
    }
  }
}
