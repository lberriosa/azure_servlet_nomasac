/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import Conexion.Conexion;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import oracle.jdbc.OracleTypes;

/**
 *
 * @author lberr
 */
public class Fondo_DB {
    
      public static boolean RegistrarFondoMonetario(Usuario usuario, Fondo fondom) {
        boolean respuesta = false;

        Connection cn;
        Conexion con = new Conexion();
        cn = con.conectar();

        CallableStatement stmt = null;

        try {
            stmt = cn.prepareCall("CALL CREAR_FONDO_MONETARIO_W(?,?,?,?)");
            stmt.setString(1, usuario.getRut_usuario());
            stmt.setInt(2,fondom.getMonto_abono());
            stmt.setDate(3,fondom.getFecha_abono());
            stmt.registerOutParameter(4, java.sql.Types.VARCHAR);
            stmt.executeUpdate();

            //read the OUT parameter now
            String result = stmt.getString(4);

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
      
      
      public static Fondo BuscarFondoContrato(String rut_usuario) {
        Fondo fondo = new Fondo();
        Contrato contrato = new Contrato();
        
        Connection cn;
        Conexion con = new Conexion();
        cn = con.conectar();

        CallableStatement stmt = null;
        ResultSet rs = null;

        try {
            stmt = cn.prepareCall("CALL VISUALIZAR_FONDO_PCONTRATO(?,?)");
            stmt.setString(1, rut_usuario);
            stmt.registerOutParameter(2, OracleTypes.CURSOR);
            stmt.execute();
            rs = (ResultSet) stmt.getObject(2);

            while (rs.next()) {
                contrato.setMonto_contrato(rs.getInt("MONTO_PAGO"));
                fondo.setMonto_abono(rs.getInt("MONTO_ABONO"));
                fondo.setContrato(contrato);
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
        return fondo;
    }
      
     public static boolean ActualizarFondos(String rut_usuario, int monto, Date fecha) {
        boolean respuesta = false;

        Connection cn;
        Conexion con = new Conexion();
        cn = con.conectar();

        CallableStatement stmt = null;

        try {
            stmt = cn.prepareCall("CALL EDITAR_FONDO_MONETARIO_W(?,?,?,?)");
            stmt.setString(1, rut_usuario);
            stmt.setInt(2, monto);
            stmt.setDate(3, fecha);
            stmt.registerOutParameter(4, java.sql.Types.VARCHAR);
            stmt.executeUpdate();

            //read the OUT parameter now
            String result = stmt.getString(4);

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
     
     
       public static Fondo BuscarFondo(String rut_usuario) {
        Fondo fondo = new Fondo();
        
        Connection cn;
        Conexion con = new Conexion();
        cn = con.conectar();

        CallableStatement stmt = null;
        ResultSet rs = null;

        try {
            stmt = cn.prepareCall("CALL VISUALIZAR_FONDO_PU(?,?)");
            stmt.setString(1, rut_usuario);
            stmt.registerOutParameter(2, OracleTypes.CURSOR);
            stmt.execute();
            rs = (ResultSet) stmt.getObject(2);

            while (rs.next()) {
                fondo.setMonto_abono(rs.getInt("MONTO_ABONO"));
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
        return fondo;
    }
      
    public static ArrayList<Fondo> obtenerFondosClientes() {
        ArrayList<Fondo> lista = new ArrayList<Fondo>();

        Connection cn;
        Conexion con = new Conexion();
        cn = con.conectar();

        CallableStatement stmt = null;
        ResultSet rs = null;

        try {
            stmt = cn.prepareCall("CALL BUSCAR_FONDOS_XAD(?)");
            stmt.registerOutParameter(1, OracleTypes.CURSOR);
            stmt.execute();
            rs = (ResultSet) stmt.getObject(1);

            while (rs.next()) {
               
               Usuario  u = new Usuario(rs.getString("RUT_USUARIO"));
               Fondo f = new Fondo(rs.getInt("FOLIO_CONTRATO"),rs.getInt("MONTO_ABONO"),rs.getDate("FECHA_ABONO"),u);

              lista.add(f);
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
}
