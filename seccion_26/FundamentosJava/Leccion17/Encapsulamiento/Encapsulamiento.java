package encapsulamiento;

public class Encapsulamiento {

    public static void main(String[] args) {
        //Creamos el objeto
        Persona p1 = new Persona("Juan","Perez",false);
        //Accedemos al atributo nombre
        System.out.println("Nombre de p1: " + p1.getNombre());
        
       //Creamos el objeto
        Persona p2 = new Persona("Karla","Gonzalez",false);
        //Imprimimos el estado completo del objeto
        System.out.println("Estado objeto p2:" + p2);        
        
        //Marcamos como elminada a la persona
        p2.setBorrado(true);
        //Imprimimos el estado completo del objeto
        System.out.println("Estado objeto p2:" + p2);     
        
        //Creamos un tercer objeto vacio
        Persona p3 = new Persona();
        //Imprimimos el estado completo del objeto
        System.out.println("Estado objeto p3:" + p3);       
    }
}