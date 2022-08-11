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
import oracle.jdbc.OracleTypes;

/**
 *
 * @author lberr
 */
public class Reporte_DB {
    
    public static boolean RegistrarReporte(int ida ,Reporte repo){
        boolean respuesta = false;
        Connection cn;
        Conexion con = new Conexion();
        cn = con.conectar();

        CallableStatement stmt = null;
        
            try {
            stmt = cn.prepareCall("CALL CREAR_REPORTE_V_W(?,?,?,?,?,?)");
            stmt.setInt(1,ida);
            stmt.setString(2, repo.getNom_archivo());
            stmt.setString(3, repo.getNom_repo());
            stmt.setString(4, repo.getDes_repo());
            stmt.setDate(5, repo.getFecha_repo());
           
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
    
    
    public static String BuscarArchivoAID(int ida){
        String resultado = null;
         
        Connection cn;
        Conexion con = new Conexion();
        cn = con.conectar();

        CallableStatement stmt = null;
        ResultSet rs = null;
         try {
            stmt = cn.prepareCall("CALL BUSCAR_ARCHIVOAC_XID(?,?)");
            stmt.setInt(1, ida);

            stmt.registerOutParameter(2, OracleTypes.CURSOR);
            stmt.execute();
            rs = (ResultSet) stmt.getObject(2);

            while (rs.next()) {
               resultado = rs.getString("ARCHIVO");  
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
        return resultado;
         
     }
    
    public static String BuscarArchivoFID(int ida){
        String resultado = null;
         
        Connection cn;
        Conexion con = new Conexion();
        cn = con.conectar();

        CallableStatement stmt = null;
        ResultSet rs = null;
         try {
            stmt = cn.prepareCall("CALL BUSCAR_ARCHIVOFI_XID(?,?)");
            stmt.setInt(1, ida);

            stmt.registerOutParameter(2, OracleTypes.CURSOR);
            stmt.execute();
            rs = (ResultSet) stmt.getObject(2);

            while (rs.next()) {
               resultado = rs.getString("ARCHIVO");  
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
        return resultado;
         
     }
    
    
}
