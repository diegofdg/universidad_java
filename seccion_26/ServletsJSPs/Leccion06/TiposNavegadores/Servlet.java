package servlets;

import java.io.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet(name = "Servlet", urlPatterns = {"/Servlet"})
public class Servlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            //Creamos las variables para procesar el titulo y
            //el mensaje de nuestra pagina web
            String titulo = null, mensaje = null;
            //Detectamos el tipo de navegador que hizo la peticion
            String tipoNavegador = request.getHeader("User-Agent");
            System.out.println("Tipo de Navegador: " + tipoNavegador);

            //Verificamos el tipo de navegador y personalizamos
            //el mensaje a enviar
            if (tipoNavegador != null && tipoNavegador.contains("Trident")) {
                titulo = "Navegador Internet Explorer";
                mensaje = "Estas navegando con Internet Explorer";
            } else if (tipoNavegador != null && tipoNavegador.contains("Firefox")) {
                titulo = "Navegador Firefox";
                mensaje = "Estas navegando con Firefox";
            } else if (tipoNavegador != null && tipoNavegador.contains("Chrome")) {
                titulo = "Navegador Chrome";
                mensaje = "Estas navegando con Chrome";
            }

            out.println("<html>");
            out.println("<head>");
            out.println("<title>" + titulo + "</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Tipo de Navegador</h1>");
            out.println("<br>");
            out.println(mensaje);
            out.println("</body>");
            out.println("</html>");
        }
    }

}
