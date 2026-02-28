package beans;

import java.io.Serializable;

//1. Implementa la interface Serializable del paquete java.io
public class PersonaBean implements Serializable {

    //2. Cada propiedad es de tipo private
    private String nombre;
    private int edad;

    //3. Siempre tiene un Constructor sin argumentos
    public PersonaBean() {
    }

    // Constructor del JavaBean (No requerido)
    public PersonaBean(String nombre, int edad) {
        this.nombre = nombre;
        this.edad = edad;
    }

    //4. Por cada propiedad agrega un get y set 
    //o solo alguno de ellos si es que no requiere de ambos
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getNombre() {
        return nombre;
    }

    public int getEdad() {
        return edad;
    }
}
