package gm.domain;

import java.io.Serializable;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;

@Entity
@Table(name="rol")
public class Rol implements Serializable{
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idRol;
    
    @NotEmpty
    private String nombre;

    public Rol() {
    }

    public Rol(Long idRol, String nombre) {
        this.idRol = idRol;
        this.nombre = nombre;
    }
    
    public Long getIdRol() {
        return idRol;
    }

    public void setIdRol(Long idRol) {
        this.idRol = idRol;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "Rol{" + "idRol=" + idRol + ", nombre=" + nombre + '}';
    }
    
}
