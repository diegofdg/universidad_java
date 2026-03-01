package utilerias;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author Ubaldo
 */
public class Conversiones {

  private static final String FORMATO_FECHA = "dd-MM-yyyy";

  /**
   * Método que permite convertir una fecha en una cadena
   * con el formato especificado
   * @param fecha
   * @return
   */
  public static String format(Date fecha){
    SimpleDateFormat formateador =
            new SimpleDateFormat(FORMATO_FECHA);
    return formateador.format( fecha );
  }

}
