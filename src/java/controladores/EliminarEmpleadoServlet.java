/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controladores;

import DAO.DAOListadoEmpleado;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@WebServlet(name = "EliminarEmpleadoServlet", urlPatterns = {"/EliminarEmpleadoServlet"})
public class EliminarEmpleadoServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);

        String id = request.getParameter("id");
        if (id != null && !id.isEmpty()) {
            try {
                int empleadoId = Integer.parseInt(id);
                DAOListadoEmpleado dao = new DAOListadoEmpleado();
                dao.eliminarEmpleado(empleadoId);
            } catch (NumberFormatException e) {
                e.printStackTrace();
            }
        }
        response.sendRedirect("empleados.jsp");

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
