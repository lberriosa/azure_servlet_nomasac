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
import java.util.Scanner;
import oracle.jdbc.OracleTypes;

/**
 *
 * @author lberr
 */
public class Contrato_DB {
    
     public static boolean RegistrarContrato(Usuario usuario, Contrato contrato) {
        boolean respuesta = false;

        Connection cn;
        Conexion con = new Conexion();
        cn = con.conectar();

        CallableStatement stmt = null;

        try {
            stmt = cn.prepareCall("CALL CREAR_CONTRATO_W(?,?,?,?,?)");
            stmt.setString(1, usuario.getRut_usuario());
            stmt.setDate(2, (Date) contrato.getFecha_contrato());
            stmt.setString(3, contrato.getPlazo_contrato());
            stmt.setInt(4, contrato.getMonto_contrato());
            stmt.registerOutParameter(5, java.sql.Types.VARCHAR);
            stmt.executeUpdate();

            //read the OUT parameter now
            String result = stmt.getString(5);

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
     
     
     
     
    public static ArrayList<Contrato> obtenerClientesCContrato() {
        ArrayList<Contrato> lista = new ArrayList<Contrato>();

        Connection cn;
        Conexion con = new Conexion();
        cn = con.conectar();

        CallableStatement stmt = null;
        ResultSet rs = null;

        try {
            stmt = cn.prepareCall("CALL VISUALIZAR_CLIENTES_CC(?)");
            stmt.registerOutParameter(1, OracleTypes.CURSOR);
            stmt.execute();
            rs = (ResultSet) stmt.getObject(1);

            while (rs.next()) {
                Usuario u = new Usuario(rs.getString("RUT_USUARIO"), rs.getString("CORREO_USUARIO"), rs.getString("NOMBRE_USUARIO"),rs.getString("APELLIDO_USUARIO"));
                Contrato c = new Contrato(rs.getInt("FOLIO_CONTRATO"),rs.getDate("FECHA_CONTRATO"),rs.getString("PLAZO_CONTRATO"),rs.getInt("MONTO_PAGO"),rs.getInt("MODIFICADO"),rs.getInt("ESTADO"),u);
                lista.add(c);
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
    
    
     public static Contrato BuscarContrato(String rut_usuario) {
        Contrato contrato = new Contrato();

        Connection cn;
        Conexion con = new Conexion();
        cn = con.conectar();

        CallableStatement stmt = null;
        ResultSet rs = null;

        try {
            stmt = cn.prepareCall("CALL VISUALIZAR_PCLIENTE_CONTRATO(?,?)");
            stmt.setString(1, rut_usuario);

            stmt.registerOutParameter(2, OracleTypes.CURSOR);
            stmt.execute();
            rs = (ResultSet) stmt.getObject(2);

            while (rs.next()) {
                contrato.setFolio_contrato(rs.getInt("FOLIO_CONTRATO"));
                contrato.setModificado(rs.getInt("MODIFICADO"));
                contrato.setEstado(rs.getInt("ESTADO"));
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
        return contrato;
    }
    
     
     public static boolean ActualizarContratoXU(String rut_usuario, int modificado, int estado) {
        boolean respuesta = false;

        Connection cn;
        Conexion con = new Conexion();
        cn = con.conectar();

        CallableStatement stmt = null;

        try {
            stmt = cn.prepareCall("CALL EDITAR_ESTADO_CONTRATOU_W(?,?,?,?)");
            stmt.setString(1, rut_usuario);
            stmt.setInt(2, modificado);
            stmt.setInt(3, estado);
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
    
    
}
