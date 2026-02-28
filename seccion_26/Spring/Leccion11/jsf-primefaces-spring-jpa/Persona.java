package mx.com.gm.capadatos.domain;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Persona implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_persona")
    private long idPersona;
    private String nombre;
    @Column(name = "apellido_paterno")
    private String apellidoPaterno;
    @Column(name = "apellido_materno")
    private String apellidoMaterno;
    private String email;

    public Persona() {
    }

    public Persona(long idPersona) {
        this.idPersona = idPersona;
    }

    public long getIdPersona() {
        return idPersona;
    }

    public void setIdPersona(long idPersona) {
        this.idPersona = idPersona;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidoPaterno() {
        return apellidoPaterno;
    }

    public void setApellidoPaterno(String apellidoPaterno) {
        this.apellidoPaterno = apellidoPaterno;
    }

    public String getApellidoMaterno() {
        return apellidoMaterno;
    }

    public void setApellidoMaterno(String apellidoMaterno) {
        this.apellidoMaterno = apellidoMaterno;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Persona [idPersona=" + idPersona + ", nombre=" + nombre
                + ", apePaterno=" + apellidoPaterno + ", apeMaterno=" + apellidoMaterno
                + ", email=" + email + "]";
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result
                + ((apellidoMaterno == null) ? 0 : apellidoMaterno.hashCode());
        result = prime * result
                + ((apellidoPaterno == null) ? 0 : apellidoPaterno.hashCode());
        result = prime * result + ((email == null) ? 0 : email.hashCode());
        result = prime * result + (int) (idPersona ^ (idPersona >>> 32));
        result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        Persona other = (Persona) obj;
        if (apellidoMaterno == null) {
            if (other.apellidoMaterno != null) {
                return false;
            }
        } else if (!apellidoMaterno.equals(other.apellidoMaterno)) {
            return false;
        }
        if (apellidoPaterno == null) {
            if (other.apellidoPaterno != null) {
                return false;
            }
        } else if (!apellidoPaterno.equals(other.apellidoPaterno)) {
            return false;
        }
        if (email == null) {
            if (other.email != null) {
                return false;
            }
        } else if (!email.equals(other.email)) {
            return false;
        }
        if (idPersona != other.idPersona) {
            return false;
        }
        if (nombre == null) {
            if (other.nombre != null) {
                return false;
            }
        } else if (!nombre.equals(other.nombre)) {
            return false;
        }
        return true;
    }
}
