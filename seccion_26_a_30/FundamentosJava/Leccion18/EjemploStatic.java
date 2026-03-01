package ejemplostatic;

public class EjemploStatic {

    public static void main(String[] args) {
        Persona p1 = new Persona("Juan");
        System.out.println("Persona1: " + p1);
        
        Persona p2 = new Persona("Karla");
        System.out.println("Persona2: " + p2);
        
        //Imprimimos el contadorPersonas
        System.out.println("No. Personas:" + Persona.getContadorPersonas());
        
    }
    
}
