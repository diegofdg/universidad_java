package ejemplopalabrafinal;

public class EjemploPalabraFinal {

    public static void main(String[] args) {
        //Marca error, no se puede modificar el valor de una variable final
        //ClaseFinal.persona = 10;
        
        //No es posible cambiar la refEjeerencia de la variable persona
        //ClaseFinal.persona = new Persona();
        
         System.out.println("Nombre persona:" + ClaseFinal.persona.getNombre());
        
        //Pero si es posible cambiar el estado del objeto 
        //referenciado por la variable persona
        ClaseFinal.persona.setNombre("Otro");
        
        System.out.println("Nombre persona:" + ClaseFinal.persona.getNombre());
    }   
}
