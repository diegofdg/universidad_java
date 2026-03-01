package ejemploenumeraciones;

public class EjemploEnumeraciones {

    public static void main(String[] args) {

        //Valores de la enumeracion
        System.out.println("Valor 1:" + Dias.LUNES);

        //Hacemos un test del dia utiliado
        indicarDia(Dias.VIERNES);        
    }

    public static void indicarDia(Dias dias) {

        switch (dias) {
            //Podemos usar algun valor constante de la enumeracion directamente
            case LUNES:
                System.out.println("Primer dia de la semana");
                break;
            case MARTES:
                System.out.println("Primer dia de la semana");
                break;
            default:
                System.out.println("Y asi seguimos con los demas dias");
        }
    }
}
