/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import Conexion.Conexion;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import oracle.jdbc.OracleTypes;

/**
 *
 * @author lberr
 */
public class Pago_DB {

    public static boolean RegistrarServicioContrato(String rut_usuario, Pago pago) {
        boolean respuesta = false;

        Connection cn;
        Conexion con = new Conexion();
        cn = con.conectar();

        CallableStatement stmt = null;

        try {
            stmt = cn.prepareCall("CALL CREAR_PAGO_SERVICIO_W(?,?,?,?,?,?)");
            stmt.setString(1, rut_usuario);
            stmt.setInt(2, pago.getId_serv());
            stmt.setString(3, pago.getDescripcion());
            stmt.setInt(4, pago.getMonto());
            stmt.setDate(5, pago.getFecha());
            stmt.registerOutParameter(6, java.sql.Types.VARCHAR);
            stmt.executeUpdate();

            //read the OUT parameter now
            String result = stmt.getString(6);

            if (result.equals("TRUE")) {
                respuesta = true;
            } else {
                respuesta = false;
            }

        } catch (Exception e) {
            System.out.println(e);
        } finally {
            try {
                stmt.close();
                cn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return respuesta;
    }

    public static ArrayList<Pago> obtenerPagoClientes(String rut_usuario) {
        ArrayList<Pago> lista = new ArrayList<Pago>();

        Connection cn;
        Conexion con = new Conexion();
        cn = con.conectar();

        CallableStatement stmt = null;
        ResultSet rs = null;

        try {
            stmt = cn.prepareCall("CALL BUSCAR_PAGOS_XU(?,?)");
            stmt.setString(1, rut_usuario);
            stmt.registerOutParameter(2, OracleTypes.CURSOR);
            stmt.execute();
            rs = (ResultSet) stmt.getObject(2);

            while (rs.next()) {

                Servicio s = new Servicio(rs.getString("NOMBRE_SERVICIO"), rs.getString("DESCRIPCION_SERVICIO"), rs.getInt("PAGADO"));
                Pago p = new Pago(rs.getInt("ID_PAGO"), rs.getInt("VALOR_TOTAL"), rs.getString("DESCRIPCION"), rs.getDate("FECHA_PAGO"), s);

                lista.add(p);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                stmt.close();
                cn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return lista;
    }

    public static Pago obtenerPagoVoucher(int id) {
        Pago pago = new Pago();

        Connection cn;
        Conexion con = new Conexion();
        cn = con.conectar();

        CallableStatement stmt = null;
        ResultSet rs = null;

        try {
            stmt = cn.prepareCall("CALL BUSCAR_PAGOS_XID(?,?)");
            stmt.setInt(1, id);

            stmt.registerOutParameter(2, OracleTypes.CURSOR);
            stmt.execute();
            rs = (ResultSet) stmt.getObject(2);

            while (rs.next()) {
                pago.setMonto(rs.getInt("VALOR_TOTAL"));
                pago.setDescripcion(rs.getString("DESCRIPCION"));
                pago.setFecha(rs.getDate("FECHA_PAGO"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                stmt.close();
                cn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return pago;
    }

     public static ArrayList<Pago> obtenerPagoClientesAdmin() {
        ArrayList<Pago> lista = new ArrayList<Pago>();

        Connection cn;
        Conexion con = new Conexion();
        cn = con.conectar();

        CallableStatement stmt = null;
        ResultSet rs = null;

        try {
            stmt = cn.prepareCall("CALL BUSCAR_PAGOS_XAD(?)");
            stmt.registerOutParameter(1, OracleTypes.CURSOR);
            stmt.execute();
            rs = (ResultSet) stmt.getObject(1);

            while (rs.next()) {
                Usuario u = new Usuario(rs.getString("RUT_USUARIO"));
                Servicio s = new Servicio(rs.getString("NOMBRE_SERVICIO"), rs.getString("DESCRIPCION_SERVICIO"),rs.getInt("ESTADO"), rs.getInt("PAGADO"));
                Pago p = new Pago(rs.getInt("ID_PAGO"), rs.getInt("VALOR_TOTAL"), rs.getString("DESCRIPCION"), rs.getDate("FECHA_PAGO"), s,u);

                lista.add(p);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                stmt.close();
                cn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return lista;
    }
     
     
      public static boolean RegistrarPago(String rut_usuario, Pago pago) {
        boolean respuesta = false;

        Connection cn;
        Conexion con = new Conexion();
        cn = con.conectar();

        CallableStatement stmt = null;

        try {
            stmt = cn.prepareCall("CALL CREAR_PAGO_W(?,?,?,?,?,?)");
            stmt.setString(1, rut_usuario);
            stmt.setInt(2, pago.getId_serv());
            stmt.setString(3, pago.getDescripcion());
            stmt.setInt(4, pago.getMonto());
            stmt.setDate(5, pago.getFecha());
            stmt.registerOutParameter(6, java.sql.Types.VARCHAR);
            stmt.executeUpdate();

            //read the OUT parameter now
            String result = stmt.getString(6);

            if (result.equals("TRUE")) {
                respuesta = true;
            } else {
                respuesta = false;
            }

        } catch (Exception e) {
            System.out.println(e);
        } finally {
            try {
                stmt.close();
                cn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return respuesta;
    }
    
    
    
}
