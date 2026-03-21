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
    private String nombre;
    private String apellido;
    private String salarioDeseado;
    
    public Candidato(){
        log.info("Creando el objeto Candidato");
        this.nombre = "Introduce tu nombre";
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        log.info("Actualizando nombre: " + nombre);
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        log.info("Actualizando apellido: " + apellido);
        this.apellido = apellido;
    }

    public String getSalarioDeseado() {
        return salarioDeseado;
    }

    public void setSalarioDeseado(String salarioDeseado) {
        log.info("Actuaizando salario: " + salarioDeseado);
        this.salarioDeseado = salarioDeseado;
    }
    
    
    
    
}
