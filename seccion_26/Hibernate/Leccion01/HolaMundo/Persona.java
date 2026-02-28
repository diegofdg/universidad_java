package mx.com.gm.domain;

import java.io.Serializable;
import javax.persistence.*;

@Entity
public class Persona implements Serializable {

	private static final long serialVersionUID = 1L;

	@Column(name = "id_persona")
	@Id
	private int idPersona;

	private String apellido;

	private String nombre;

	public Persona() {
	}

	public String getApellido() {
		return this.apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public int getIdPersona() {
		return this.idPersona;
	}

	public void setIdPersona(int idPersona) {
		this.idPersona = idPersona;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Override
	public String toString() {
		return "Persona [apellido=" + apellido + ", idPersona=" + idPersona + ", nombre=" + nombre + "]";
	}
}