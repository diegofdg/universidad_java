package aritmetica.prueba;

import aritmetica.Aritmetica;

public class PruebaAritmetica {
    public static void main(String[] args) {
        System.out.println("*** Ejemplo aritmetica.Aritmetica ***");
        var aritmetica1 = new Aritmetica(5,7);
        System.out.println("Valor Operando 1: " + aritmetica1.getOperando1());
        aritmetica1.setOperando1(9);
        System.out.println("Valor Operando 1: " + aritmetica1.getOperando1());
        aritmetica1.sumar();
        System.out.println("Valor Operando 2: " + aritmetica1.getOperando2());
    }
}
