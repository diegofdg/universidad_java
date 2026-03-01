package personas;

public class PersonaPrueba {
    public static void main(String args[]){
        //Creacion de un objeto
        Persona p1 = new Persona();
        
        //LLamando a un metodo del objeto creado
        System.out.println("Valores por default del objeto Persona");
        p1.desplegarNombre();
        
        //Modificar valores
        p1.nombre = "Juan";
        p1.apellidoPaterno = "Esparza";
        p1.apellidoMaterno = "Lara";
        
        //Volvemos a llamar al metodo
        System.out.println("\nNuevos valores del objeto Persona");
        p1.desplegarNombre();
        
    }
}