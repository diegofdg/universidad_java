package mx.com.gm.actions;

import com.opensymphony.xwork2.ActionSupport;
import org.apache.logging.log4j.*;

public class MensajesAction extends ActionSupport {

    Logger log = LogManager.getLogger(MensajesAction.class);

    private String nombre;

    @Override
    public String execute() {
        log.info("Valor nombre:" + nombre);
        return SUCCESS;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}