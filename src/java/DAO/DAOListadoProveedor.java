package DAO;

import controladores.ConexionDB;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import modelo.empleado;
import modelo.proveedor;

public class DAOListadoProveedor {

    public ArrayList<proveedor> ListaProveedor() {
        ArrayList<proveedor> listapro = null;

        Connection conn = null;
        Statement stmt = null;
        ConexionDB conexionServlet = new ConexionDB();
        ResultSet rs = null;

        try {
            conn = conexionServlet.getConnection();
            stmt = conn.createStatement();
            String sql = "SELECT proveedor_id,razon_social,ruc,telefono,correo,servicio FROM proveedores";
            listapro = new ArrayList<proveedor>();
            rs = stmt.executeQuery(sql);
            while (rs.next()) {
                proveedor prov = new proveedor();
                prov.setProvid(rs.getInt("proveedor_id"));
                prov.setRazonsocial(rs.getString("razon_social"));
                prov.setRuc(rs.getString("ruc"));
                prov.setTelefono(rs.getString("telefono"));
                prov.setCorreo(rs.getString("correo"));
                prov.setServicio(rs.getString("servicio"));
                listapro.add(prov);
            }
            stmt.close();
            // desconectar();
        } catch (Exception e1) {
            System.exit(0);
        }
        return listapro;
    }

    /*public empleado obtenerEmpleadoPorId(int id) throws ClassNotFoundException {
        empleado emp = null;
        Connection conn = null;
        PreparedStatement stmt = null;
        ConexionDB conexionServlet = new ConexionDB();
        ResultSet rs = null;
        try {
            conn = conexionServlet.getConnection();
            String sql = "SELECT * FROM empleados WHERE id = ?";
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);
            rs = stmt.executeQuery();
            if (rs.next()) {
                emp = new empleado();
                emp.setId(rs.getInt("id"));
                emp.setNombre(rs.getString("nombre"));
                emp.setApellido(rs.getString("apellido"));
                emp.setCargo(rs.getString("cargo"));
                emp.setDep(rs.getString("dep"));
                emp.setFecIng(rs.getDate("fecIng"));
                emp.setSalario(rs.getFloat("salario"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (stmt != null) {
                    stmt.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return emp;
    }*/

    /*public void actualizarEmpleado(empleado emp) throws ClassNotFoundException {
        Connection conn = null;
        ConexionDB conexionServlet = new ConexionDB();
        PreparedStatement stmt = null;
        try {
            conn = conexionServlet.getConnection();
            String sql = "UPDATE empleados SET nombre = ?, apellido = ?, cargo = ?, departamento_id = ?, fecha_ingreso = ?, salario = ? WHERE id = ?";
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, emp.getNombre());
            stmt.setString(2, emp.getApellido());
            stmt.setString(3, emp.getCargo());
            stmt.setString(4, emp.getDep());
            stmt.setDate(5, new java.sql.Date(emp.getFecIng().getTime())); // Conversión de java.util.Date a java.sql.Date
            stmt.setFloat(6, emp.getSalario());
            stmt.setInt(7, emp.getId());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (stmt != null) {
                    stmt.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }*/

    public void eliminarProveedor(int id) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ConexionDB conexionServlet = new ConexionDB();
        ResultSet rs = null;
        try {
            conn = conexionServlet.getConnection();

            String sql = "DELETE FROM proveedores WHERE proveedor_id=?";
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);
            stmt.executeUpdate();
            stmt.close();
        } catch (Exception e1) {
            System.exit(0);
        }
    }

}
