package servlets;

import java.io.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet(name = "GeneracionExcelServlet", urlPatterns = {"/GeneracionExcelServlet"})
public class GeneracionExcelServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try (PrintWriter out = response.getWriter()) {
            //Especificamos el tipo del documento de respuesta (MIME)
            response.setContentType("application/vnd.ms-excel");
            response.setHeader("Content-Disposition", "attachment; filename=excelEjemplo.xls");
            //Para un uso más profesional de excel usar: https://poi.apache.org/
            response.setHeader("Pragma", "no-cache");
            response.setHeader("Cache-Control", "no-store");
            response.setDateHeader("Expires", -1);

            //Desplegamos el contenido en un excel
            //simplemente modificando el contentType
            out.println("\tValores");
            out.println("\t1");
            out.println("\t2");
            out.println("Total\t=SUMA(B2:B3)");
        }
    }
}
