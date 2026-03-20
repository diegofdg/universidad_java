package beans.model;

import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Named;
import java.io.Serializable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Named("candidato")
@SessionScoped
public class Candidato implements Serializable{
    
    private static final Logger log = LoggerFactory.getLogger(Candidato.class);
    private String nombre = "Valor";

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        log.info("Actualizando nombre: " + nombre);
        this.nombre = nombre;
    }
    
    
}
