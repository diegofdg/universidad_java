package domain;

/**
 * Clase Division, para efectuar la operacion division
 *
 * @author Ubaldo
 */
public class Division {

    //atributo de la clase
    private int numerador;
    //atributo de la clase
    private int denominador;

    /**
     * Construye el objeto División
     *
     * @param numerador int
     * @param denominador int
     */
    public Division(int numerador, int denominador) throws OperationException {

        if (denominador == 0) {
            //throw new IllegalArgumentException("Denominador igual a cero");
            throw new OperationException("Denominador igual a cero");
        }
        this.numerador = numerador;
        this.denominador = denominador;
    }

    public void visualizarOperacion() {
        System.out.println("El resultado de la división es: " + numerador / denominador);
    }
}
