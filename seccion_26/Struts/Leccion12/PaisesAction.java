package mx.com.gm.actions;

import com.opensymphony.xwork2.*;
import java.util.*;
import org.apache.logging.log4j.*;

public class PaisesAction extends ActionSupport implements Preparable {

    private final String datos = "Mexico, Colombia, Argentina, China, Japon";
    private List<String> paises;
    private String pais;
    Logger log = LogManager.getLogger(PaisesAction.class);

    @Override
    public void prepare() {
        log.info("Cargamos la lista de paises");
        paises = new ArrayList<>();
        StringTokenizer st = new StringTokenizer(datos, ",");

        while (st.hasMoreTokens()) {
            paises.add(st.nextToken().trim());
        }
    }

    @Override
    public String execute() {
        log.info("Pais seleccionado: " + pais);
        return SUCCESS;
    }

    public String getPais() {
        return this.pais;
    }

    public List<String> getPaises() {
        return paises;
    }

    public void setPaises(List<String> paises) {
        this.paises = paises;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }
}