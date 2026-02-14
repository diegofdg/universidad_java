package EncapsulamientoPersona.persona;

public class PruebaPersona {
    public static void main(String[] args) {
        System.out.println("*** Creacion de Clase y Objetos Persona ***");
        var objeto1 = new Persona("Layla", "Acosta");
        objeto1.mostrarPersona();
        // Segundo objeto
        System.out.println();
        var objeto2 = new Persona("Ian", "Gomez");
        objeto2.mostrarPersona();
    }

}
