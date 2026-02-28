package ejemplostatic;

public class Persona {
    
    private String nombre;
    private int idPersona;
    private static int contadorPersonas;
    
    public Persona(String nombre){
        //Cada que creamos un objeto persona incrementamos el contador 
        //para obtener un nuevo idPersona
        contadorPersonas++;
        //asignamos el nuevo valor al idPersona
        idPersona = contadorPersonas;
        //Asignamos el nombre recibido
        this.nombre = nombre;
    }
    
    public String toString(){
        return "Persona[idPersona: " + idPersona + ", nombre: " + nombre + "]";
    }
    
    public static int getContadorPersonas(){
        return contadorPersonas;
    }
    
}
