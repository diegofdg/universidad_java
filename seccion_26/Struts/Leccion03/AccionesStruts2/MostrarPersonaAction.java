package mx.com.gm.actions;

import com.opensymphony.xwork2.ActionSupport;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class MostrarPersonaAction extends ActionSupport {

    private String nombre;

    Logger log = LogManager.getLogger(MostrarPersonaAction.class);

    @Override
    public String execute() {
        log.info("El nombre es:" + this.nombre);
        return SUCCESS;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

}
