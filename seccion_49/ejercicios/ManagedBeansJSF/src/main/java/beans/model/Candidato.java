package beans.model;

import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Named;

@Named("candidato")
@RequestScoped
public class Candidato {
    private String nombre = "Valor";

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    
}
