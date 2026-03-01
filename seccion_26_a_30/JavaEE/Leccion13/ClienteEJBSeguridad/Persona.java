package mx.com.gm.sga.domain;

import java.io.Serializable;

public class Persona implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer idPersona;

    private String nombre;

    private String apellidoPaterno;

    private String apellidoMaterno;

    private String email;

    private String telefono;

    public Persona() {
    }

    public Persona(Integer idPersona) {
        this.idPersona = idPersona;
    }

    public Persona(String nombre, String apePaterno, String apeMaterno,
            String email, String telefono) {
        this.nombre = nombre;
        this.apellidoPaterno = apePaterno;
        this.apellidoMaterno = apeMaterno;
        this.email = email;
        this.telefono = telefono;
    }

    public Persona(Integer idPersona, String nombre, String apellidoPaterno, String email) {
        this.idPersona = idPersona;
        this.nombre = nombre;
        this.apellidoPaterno = apellidoPaterno;
        this.email = email;
    }

    public Persona(Integer idPersona, String nombre, String apellidoPaterno, String apellidoMaterno,
            String email, String telefono) {
        this.idPersona = idPersona;
        this.nombre = nombre;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
        this.email = email;
        this.telefono = telefono;
    }

    public Integer getIdPersona() {
        return idPersona;
    }

    public void setIdPersona(Integer idPersona) {
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

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    @Override
    public String toString() {
        return "Persona{" + "idPersona=" + idPersona + ", nombre=" + nombre + ", apellidoPaterno=" + apellidoPaterno + ", apellidoMaterno=" + apellidoMaterno + ", email=" + email + ", telefono=" + telefono + '}';
    }
}
