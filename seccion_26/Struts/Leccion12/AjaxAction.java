package mx.com.gm.actions;

import com.opensymphony.xwork2.ActionSupport;

public class AjaxAction extends ActionSupport {

    private String nombre;

    @Override
    public String execute() {
        System.out.println("Nombre:" + nombre);
        return SUCCESS;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}