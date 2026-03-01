package mx.com.gm.actions;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class SaludarAction {
    
    Logger log = LogManager.getLogger(SaludarAction.class);
    
    private String saludosAtr;
    
    public String execute(){
        log.info("Ejecutando método execute de Struts 2");
        setSaludosAtr("Hola desde Struts2 con Convenciones");
        return "exito";
    }

    public String getSaludosAtr() {
        return saludosAtr;
    }

    public void setSaludosAtr(String saludosAtr) {
        this.saludosAtr = saludosAtr;
    }
}
