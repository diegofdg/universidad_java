package IdPersonaUnico.persona;

public class PruebaPersona {
    public static void main(String[] args) {
        System.out.println("*** Creacion de Clase y Objetos Persona ***");
        System.out.println("Variable estática: " + Persona.contadorPersonas);
        var objeto1 = new Persona("Layla", "Acosta");
        System.out.println(objeto1); // automaticamente se llama toString
        System.out.println("Variable estática: " + Persona.contadorPersonas);
        // Segundo objeto
        var objeto2 = new Persona("Ian", "Gomez");
        System.out.println(objeto2);
        System.out.println("Variables estática: " + Persona.contadorPersonas);
    }
}
