package sga.web;

import java.util.List;
import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import org.primefaces.event.RowEditEvent;
import sga.domain.Persona;
import sga.servicio.PersonaService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Named("personaBean")
@RequestScoped
public class PersonaBean {

    private static final Logger log = LoggerFactory.getLogger(PersonaBean.class);

    @Inject
    private PersonaService personaService;

    List<Persona> personas;

    private Persona personaSeleccionada;

    @PostConstruct
    public void inicializar() {
        //Inciamos las variables
        this.personas = personaService.listarPersonas();
        log.debug("personas recuperadas en ManagedBean:" + this.personas);
        this.personaSeleccionada = new Persona();
    }

    public void agregarPersona() {
        this.personaService.registrarPersona(personaSeleccionada);
        this.personas.add(personaSeleccionada);
        this.personaSeleccionada = new Persona();
    }

    public void eliminarPersona() {
        this.personaService.eliminarPersona(personaSeleccionada);
        this.personas.remove(this.personaSeleccionada);
        this.personaSeleccionada = null;
    }

    public void editListener(RowEditEvent<Persona> event) {
        Persona persona = event.getObject();
        personaService.modificarPersona(persona);
    }
    
    public void reiniciarPersonaSeleccionada(){
        this.personaSeleccionada = new Persona();
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

}
