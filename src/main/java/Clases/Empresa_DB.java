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
import java.util.Scanner;
import oracle.jdbc.OracleTypes;

/**
 *
 * @author lberr
 */
public class Empresa_DB {
    
      public static Empresa VerificarEmpresaRut(String rut_empresa){
            Empresa empresa = new Empresa();
            Connection cn;
            Conexion con = new Conexion();
            cn = con.conectar();
            
            CallableStatement stmt = null;  
            ResultSet rs = null;

            try{
               stmt = cn.prepareCall("CALL VALIDAR_EMPRESA_C(?,?)"); 
               stmt.setString(1, rut_empresa);
               
               stmt.registerOutParameter(2,OracleTypes.CURSOR);
               stmt.execute();
               rs = (ResultSet) stmt.getObject(2);
               
               while(rs.next()){
                   empresa.setRut_empresa(rs.getString("RUT_EMPRESA"));
               }
            }catch(Exception e){
			e.printStackTrace();
		}finally{
			try {
				stmt.close();
				cn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
            return empresa;            
    }
      
      public static boolean ActualizarEmpresa(Empresa empresa){
    
      boolean respuesta = false;

        Connection cn;
        Conexion con = new Conexion();
        cn = con.conectar();

        CallableStatement stmt = null;

        try {
            stmt = cn.prepareCall("CALL MODIFICAR_USUARIO_CLIENTE_E_W(?,?,?,?,?,?,?)");
            stmt.setString(1, empresa.getRut_usuario());
            stmt.setString(2, empresa.getRazon_social());
            stmt.setString(3, empresa.getDireccion());
            stmt.setInt(4, empresa.getTelefono());
            stmt.setString(5,empresa.getCorreo());
            stmt.setString(6, empresa.getPagina());
            stmt.registerOutParameter(7, java.sql.Types.VARCHAR);
            stmt.executeUpdate();

            //read the OUT parameter now
            String result = stmt.getString(7);

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
