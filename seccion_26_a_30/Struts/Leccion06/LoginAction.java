package mx.com.gm.actions;

import static com.opensymphony.xwork2.Action.SUCCESS;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;

@Result(name = "success", location = "/WEB-INF/content/login.jsp")
public class LoginAction extends ActionSupport {

    @Action("login")
    @Override
    public String execute() {
        return SUCCESS;
    }

}