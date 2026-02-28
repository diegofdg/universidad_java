package mx.com.gm.actions;

import com.opensymphony.xwork2.ActionSupport;
import org.apache.logging.log4j.*;
import org.apache.struts2.convention.annotation.*;

@Results({
    @Result(name="success", location="/WEB-INF/content/bienvenido.jsp"),
    @Result(name="input", location="login", type="redirectAction")
})
public class ValidarUsuarioAction extends ActionSupport {

    private String usuario;
    private String password;
    Logger log = LogManager.getLogger(ValidarUsuarioAction.class);

    @Action("validarUsuario")
    @Override
    public String execute() {
        //Si es usuario valido mostramos la pagina de bienvenido.jsp 
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