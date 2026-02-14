package Paquetes.prueba;
import Paquetes.aritmetica.Aritmetica;

public class PruebaAritmetica {
    public static void main(String[] args) {
        System.out.println("*** Ejemplo Aritmetica ***");
        var aritmetica1 = new Aritmetica(5, 7);
        aritmetica1.sumar();
        aritmetica1.restar();
        // Creamos un segundo objeto
        System.out.println();
        var aritmetica2 = new Aritmetica(12, 16);
        aritmetica2.sumar();
    }
}
