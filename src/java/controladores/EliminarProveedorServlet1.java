package controladores;

import DAO.DAOListadoProveedor;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@WebServlet(name = "EliminarProveedorServlet1", urlPatterns = {"/EliminarProveedorServlet1"})
public class EliminarProveedorServlet1 extends HttpServlet {

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
                int proveedorId = Integer.parseInt(id);
                DAOListadoProveedor dao = new DAOListadoProveedor();
                dao.eliminarProveedor(proveedorId);
            } catch (NumberFormatException e) {
                e.printStackTrace();
            }
        }
        response.sendRedirect("proveedores.jsp");

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
