package servlets;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet(name = "FechaServlet", urlPatterns = {"/FechaServlet"})
public class FechaServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try (PrintWriter out = response.getWriter()) {
            response.setContentType("text/html;charset=UTF-8");
            response.setHeader("refresh", "1");//dado en segundos
            //Obtenemos la fecha actual y le aplicamos un formato 
            Date fecha = new Date();
            //API para utilizar la clase SimpleDateFormat
            //https://docs.oracle.com/javase/8/docs/api/java/text/SimpleDateFormat.html
            //SimpleDateFormat formateador = new SimpleDateFormat("dd 'de' MMMM 'de' yyyy 'a las' HH:mm:ss");
            SimpleDateFormat formateador = new SimpleDateFormat("'Hora actualizada' HH:mm:ss");
            String fechaConFormato = formateador.format(fecha);
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet FechaServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Fecha actualizada: " + fechaConFormato + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }
}
