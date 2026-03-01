package gm.com.mx;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;

@WebServlet("/HolaMundoServlet") //http:8080/HolaMundoJavaWeb/HolaMundoServlet
public class HolaMundo extends HttpServlet{
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException{
        response.setContentType("text/html;charset=UTF-8");
        var salida = response.getWriter();
        salida.print("Hola Mundo desde Servlets");
    }
}
