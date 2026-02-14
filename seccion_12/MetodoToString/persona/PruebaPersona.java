package MetodoToString.persona;

public class PruebaPersona {
    public static void main(String[] args) {
        System.out.println("*** Creacion de Clase y Objetos Persona ***");
        var objeto1 = new Persona("Layla", "Acosta");
        System.out.println(objeto1); // automaticamente se llama toString
    }
}
