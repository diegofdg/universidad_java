package domain;

/**
 *
 * @author Ubaldo
 */
public class OperationException extends Exception {

    public OperationException(String mensaje) {
        //Inicializamos el mensaje de error de la clase padre
        super(mensaje);
    }
}
