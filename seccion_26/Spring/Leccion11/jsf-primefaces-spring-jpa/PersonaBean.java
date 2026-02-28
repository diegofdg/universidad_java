package mx.com.gm.capaweb;

import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import mx.com.gm.capadatos.domain.Persona;
import mx.com.gm.capaservicio.PersonaService;
import org.primefaces.event.RowEditEvent;

@ManagedBean(name = "personaBean")
@RequestScoped
public class PersonaBean {
    
    @ManagedProperty("#{personaService}")
    private PersonaService personaService;

    private Persona personaSeleccionada;

    List<Persona> personas;

    public PersonaBean() {
    }

    @PostConstruct
    public void inicializar() {
        //Iniciamos las variables
        personas = personaService.listarPersonas();
        personaSeleccionada = new Persona();
    }

    public void editListener(RowEditEvent event) {
        Persona persona = (Persona) event.getObject();
        personaService.modificarPersona(persona);
    }

    public List<Persona> getPersonas() {
        return personas;
    }

    public void setPersonas(List<Persona> personas) {
        this.personas = personas;
    }

    public Persona getPersonaSeleccionada() {
        return personaSeleccionada;
    }

    public void setPersonaSeleccionada(Persona personaSeleccionada) {
        this.personaSeleccionada = personaSeleccionada;
    }
    
    public void reiniciarPersonaSeleccionada(){
        this.personaSeleccionada = new Persona();
    }

    public void agregarPersona() {
        personaService.agregarPersona(this.personaSeleccionada);
        this.personaSeleccionada = null;
    }

    public void eliminarPersona() {
        personaService.eliminarPersona(this.personaSeleccionada);
        this.personaSeleccionada = null;
    }
    
      public PersonaService getPersonaService() {
        return personaService;
    }

    public void setPersonaService(PersonaService personaService) {
        this.personaService = personaService;
    }
}