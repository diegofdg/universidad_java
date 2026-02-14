package MetodosEstaticos.persona;

public class PruebaPersona {
    public static void main(String[] args) {
        System.out.println("*** Creacion de Objetos de la Clase Persona ***");
        var objeto1 = new Persona("Layla", "Acosta");
        System.out.println(objeto1);//De manera automatica se llama .toString()
        var objeto2 = new Persona("Ian", "Gomez");
        System.out.println(objeto2);
        System.out.println("Valor contadorPersonas: "
                + Persona.getContadorPersonas());
    }
}
