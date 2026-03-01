package mx.com.gm.sga.beans;

import java.util.List;
import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.inject.Named;
import mx.com.gm.sga.domain.Persona;
import mx.com.gm.sga.servicio.PersonaService;
import org.primefaces.event.RowEditEvent;
import javax.enterprise.context.RequestScoped;

@Named("personaBean")
@RequestScoped
public class PersonaBean {

    @Inject
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

    public void reiniciarPersonaSeleccionada() {
        this.personaSeleccionada = new Persona();
    }

    public void agregarPersona() {
        personaService.registrarPersona(this.personaSeleccionada);
        this.personaSeleccionada = null;
        //actualizamos la lista
        this.inicializar();
    }

    public void eliminarPersona() {
        personaService.eliminarPersona(this.personaSeleccionada);
        this.personaSeleccionada = null;
        //actualizamos la lista
        this.inicializar();
    }

    public PersonaService getPersonaService() {
        return personaService;
    }

    public void setPersonaService(PersonaService personaService) {
        this.personaService = personaService;
    }
}
