/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import Modelo.clsECargo;
import ModeloDAO.CargoDAO;
import javax.servlet.RequestDispatcher;

@WebServlet("/ControladorCargo")
public class ControladorCargo extends HttpServlet {
    String listar = "VistaCargo/listar.jsp";
    String add = "VistaCargo/agregar.jsp";
    String edit = "VistaCargo/editar.jsp";
    clsECargo cargo = new clsECargo();
    CargoDAO dao = new CargoDAO();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ControladorCargo</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ControladorCargo at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String acceso = "";
        String action = request.getParameter("accion");
        
        if (action.equalsIgnoreCase("listar")) {
            acceso = listar;
        } else if (action.equalsIgnoreCase("add")) {
            acceso = add;
        } else if (action.equalsIgnoreCase("Agregar")) {
            String descripcion = request.getParameter("txtdescripcion");
            cargo.setDescripcion(descripcion);
            dao.agregar(cargo);
            acceso = listar;
        } else if (action.equalsIgnoreCase("edit")) {
            request.setAttribute("id_cargo", request.getParameter("id_cargo"));
            acceso = edit;
        } else if (action.equalsIgnoreCase("Actualizar")) {
            int id_cargo = Integer.parseInt(request.getParameter("txtid_cargo"));
            String descripcion = request.getParameter("txtdescripcion");
            cargo.setId_cargo(id_cargo);
            cargo.setDescripcion(descripcion);
            dao.editar(cargo);
            acceso = listar;
        } else if (action.equalsIgnoreCase("eliminar")) {
            int id_cargo = Integer.parseInt(request.getParameter("id_cargo"));
            dao.eliminar(id_cargo);
            acceso = listar;
        }
        RequestDispatcher vista = request.getRequestDispatcher(acceso);
        vista.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }
}

