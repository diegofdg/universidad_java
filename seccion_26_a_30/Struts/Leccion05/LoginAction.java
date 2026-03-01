package mx.com.gm.actions;

import com.opensymphony.xwork2.ActionSupport;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LoginAction extends ActionSupport {

    private String usuario;

    private String password;

    Logger log = LogManager.getLogger(LoginAction.class);

    @Override
    public String execute() {
        //Si es usuario valido mostramos la pagina de bievenido.jsp 
        if ("admin".equals(this.usuario)) {
            return SUCCESS;
        } else {
            //Si es usuario NO valido, regresamos al login
            return INPUT;
        }
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
