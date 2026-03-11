package utilerias;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author ubaldo
 */
public class Conversiones {
    private static final String FORMATO_FECHA = "dd-MM";
    
    public static String format(Date fecha){
        var formateador = new SimpleDateFormat(FORMATO_FECHA);
        return formateador.format(fecha);
    }
    
     public static String format(String fecha){
        var formateador = new SimpleDateFormat(FORMATO_FECHA);
        return formateador.format(fecha);
    }
    
    
}
