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
public class Asistencia_DB {
    
    public static boolean RegistrarAsistenciaVisita(int id, Asistencia asistencia) {
        boolean respuesta = false;

        Connection cn;
        Conexion con = new Conexion();
        cn = con.conectar();

        CallableStatement stmt = null;

        try {
            stmt = cn.prepareCall("CALL CREAR_ASISTENCIA_AID_W(?,?,?,?,?)");
            stmt.setInt(1, id);
            stmt.setString(2,asistencia.getDescripcion_a());
            stmt.setInt(3,asistencia.getEstado_a());
            stmt.setDate(4,asistencia.getFecha_a());
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
    
    
    public static ArrayList<Asistencia> obtenerInasistencias() {
        ArrayList<Asistencia> lista = new ArrayList<Asistencia>();
      
        Connection cn;
        Conexion con = new Conexion();
        cn = con.conectar();

        CallableStatement stmt = null;
        ResultSet rs = null;
        
         try {
            stmt = cn.prepareCall("CALL VISUALIZAR_ASISTENCIASA(?)");
            stmt.registerOutParameter(1, OracleTypes.CURSOR);
            stmt.execute();
            rs = (ResultSet) stmt.getObject(1);
            
             while (rs.next()) {
                Actividad ac = new Actividad(rs.getString("NOMBRE_ACTIVIDAD"), rs.getString("DESCRIPCION_ACTIVIDAD"), rs.getInt("ESTADOAC"), rs.getDate("FECHA_INICIO"), rs.getDate("FECHA_TERMINO"));
                Asistencia as = new Asistencia(rs.getString("DESCRIPCION_ASISTENCIA"), rs.getInt("ESTADOAS"), rs.getDate("FECHA_EMISION"), ac);
                lista.add(as);
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
