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
public class Checklist_DB {
    
     public static boolean RegistrarChecklist(int ida ,Checklist chk){
        boolean respuesta = false;
        Connection cn;
        Conexion con = new Conexion();
        cn = con.conectar();

        CallableStatement stmt = null;
        
            try {
            stmt = cn.prepareCall("CALL CREAR_CHECKLIST_V_W(?,?,?,?,?,?)");
            stmt.setInt(1,ida);
            stmt.setString(2, chk.getNom_archivo());
            stmt.setString(3, chk.getNom_check());
            stmt.setString(4, chk.getDes_check());
            stmt.setDate(5, chk.getFecha_check());
           
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
     
     
     
     public static String BuscarArchivoID(int ida){
        String resultado = null;
         
        Connection cn;
        Conexion con = new Conexion();
        cn = con.conectar();

        CallableStatement stmt = null;
        ResultSet rs = null;
         try {
            stmt = cn.prepareCall("CALL BUSCAR_ARCHIVO_XID(?,?)");
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
