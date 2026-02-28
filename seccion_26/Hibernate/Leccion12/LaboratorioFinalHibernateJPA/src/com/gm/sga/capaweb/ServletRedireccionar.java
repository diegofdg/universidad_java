package com.gm.sga.capaweb;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "ServletRedireccionar", urlPatterns = {"/ServletRedireccionar"})
public class ServletRedireccionar extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String accion = request.getParameter("accion");
        if ("agregar".equals(accion)) {
            //Redireccionamos a la pagina de Agregar Alumno
            request.getRequestDispatcher("WEB-INF/agregarAlumno.jsp").forward(request, response);
        } else if ("buscar".equals(accion)) {
            //Redireccionamos a la pagina de Busqueda avanzada para usar criteria
            request.getRequestDispatcher("WEB-INF/busquedaAvanzada.jsp").forward(request, response);
        }
    }
}