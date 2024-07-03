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

public class DAOListadoEmpleado {

    public ArrayList<empleado> ListaEmpleados() {
        ArrayList<empleado> listapel = null;

        Connection conn = null;
        Statement stmt = null;
        ConexionDB conexionServlet = new ConexionDB();
        ResultSet rs = null;

        try {
            conn = conexionServlet.getConnection();
            stmt = conn.createStatement();
            String sql = "SELECT empleado_id,nombre,apellidos,dni,telefono,areadescp,cargodescp,fecha_hora FROM empleados,area,cargo_trab WHERE empleados.area_id = area.area_id AND empleados.cargo_id = cargo_trab.cargo_id";
            listapel = new ArrayList<empleado>();
            rs = stmt.executeQuery(sql);
            while (rs.next()) {
                empleado emp = new empleado();
                emp.setEmpid(rs.getInt("empleado_id"));
                emp.setNombres(rs.getString("nombre"));
                emp.setApellidos(rs.getString("apellidos"));
                emp.setDni(rs.getString("dni"));
                emp.setTelf(rs.getString("telefono"));
                emp.setAreadescp(rs.getString("areadescp"));
                emp.setCargodescp(rs.getString("cargodescp"));
                emp.setFecha(rs.getString("fecha_hora"));
                listapel.add(emp);
            }
            stmt.close();
            // desconectar();
        } catch (Exception e1) {
            System.exit(0);
        }
        return listapel;
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

    public void eliminarEmpleado(int id) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ConexionDB conexionServlet = new ConexionDB();
        ResultSet rs = null;
        try {
            conn = conexionServlet.getConnection();

            String sql = "DELETE FROM empleados WHERE empleado_id=?";
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);
            stmt.executeUpdate();
            stmt.close();
        } catch (Exception e1) {
            System.exit(0);
        }
    }

}
