package servlets;

import java.io.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet(name = "Servlet", urlPatterns = {"/Servlet"})
public class Servlet extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse res)
            throws IOException {
        PrintWriter out = res.getWriter();
        out.println("<html>");
        out.println("<body>");
        out.println("Método doGet no soportado en el Servlet");
        out.println("</body>");
        out.println("</html>");
        out.close();
    }

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException {
        //Leemos los parametros del formulario
        //por default el formulario es de tipo Get
        String usuario = req.getParameter("usuario");
        String password = req.getParameter("password");

        System.out.println("usuario:" + usuario);
        System.out.println("password:" + password);

        PrintWriter out = res.getWriter();
        out.println("<html>");
        out.println("<body>");
        out.println("El parametro usuario es: " + usuario);
        out.println("<br>");
        out.println("El parametro password es: " + password);
        out.println("</body>");
        out.println("</html>");
        out.close();
    }
}
