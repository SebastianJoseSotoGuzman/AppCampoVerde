/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controladores;

import DAO.UserDAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.ResultSet;
/**
 *
 * @author Lumar
 */
@WebServlet(name = "LoginServlet", urlPatterns = {"/LoginServlet"})
public class LoginServlet extends HttpServlet {

    private UserDAO userDAO;

    public void init() {
        userDAO = new UserDAO();
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);

        String nombre_usuario = request.getParameter("username");
        String contraseña = request.getParameter("password");
       //PreparedStatement ps = null;
        
        
      try {
            Connection conn = null;
            try {
                conn = ConexionDB.getConnection();
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(LoginServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
            String query = "SELECT contraseña FROM usuarios WHERE usuario = ?";
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, nombre_usuario);            
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                String storedHash = rs.getString("contraseña");
                String salt = rs.getString("salt");

                // Encriptar la contraseña ingresada con el mismo salt
                String hashedPassword = encryptPassword(contraseña, salt);

                // Comparar las contraseñas
                if (hashedPassword.equals(storedHash)) {
                    System.out.println("Inicio de sesión exitoso!");
                    // Aquí puedes redirigir al usuario a la página de bienvenida, por ejemplo.
                } else {
                    System.out.println("Contraseña incorrecta.");
                    // Manejo de error, por ejemplo, redirigir a la página de login con un mensaje de error.
                }
            } else {
                System.out.println("Usuario no encontrado.");
                // Manejo de error, por ejemplo, redirigir a la página de login con un mensaje de error.
            }
        } catch (SQLException e) {
            System.out.println("Error: Problema con la conexión o la consulta SQL.");
            e.printStackTrace();
        }

        try {
            if (userDAO.validate(nombre_usuario, contraseña)) {
                HttpSession session = request.getSession();
                session.setAttribute("username", nombre_usuario);
                response.sendRedirect("principal.jsp");
            } else {
                response.sendRedirect("index.jsp");
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private static String encryptPassword(String password, String salt) {
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            String saltedPassword = password + salt;
            byte[] hash = digest.digest(saltedPassword.getBytes(StandardCharsets.UTF_8));
            StringBuilder hexString = new StringBuilder();
            for (byte b : hash) {
                String hex = Integer.toHexString(0xff & b);
                if (hex.length() == 1) {
                    hexString.append('0');
                }
                hexString.append(hex);
            }
            return hexString.toString();
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

    
}
