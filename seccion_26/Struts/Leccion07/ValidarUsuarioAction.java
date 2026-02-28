package mx.com.gm.actions;

import com.opensymphony.xwork2.ActionSupport;
import org.apache.logging.log4j.*;
import org.apache.struts2.convention.annotation.*;

@Results({
    @Result(name = "success", location = "/WEB-INF/content/bienvenido.jsp"),
    @Result(name = "input", location = "/WEB-INF/content/login.jsp")
})
public class ValidarUsuarioAction extends ActionSupport {

    private String usuario;
    private String password;
    Logger log = LogManager.getLogger(ValidarUsuarioAction.class);

    @Action("validarUsuario")
    @Override
    public String execute() {
        //Si es usuario valido mostramos la pagina de bienvenido.jsp 
        if (usuarioValido()) {
            addActionMessage(getText("usuario.valido"));
            return SUCCESS;
        } else {
            //Si es usuario NO valido, regresamos al login
            return INPUT;
        }
    }

    @Override
    public void validate() {
        if (this.usuario == null || "".equals(this.usuario.trim())) {
            addFieldError("usuario", getText("val.usuario"));
        } else if (!usuarioValido()) {
            addActionError(getText("usuario.invalido"));
        }

        if (this.password == null || "".equals(this.password.trim())) {
            addFieldError("password", getText("val.password"));
        } else if (this.password.length() < 3) {
            addFieldError("password", getText("val.pass.min.length"));
        }
    }

    private boolean usuarioValido() {
        //Valor de usuario valido = "admin" en codigo duro 
        return "admin".equals(this.usuario);
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
