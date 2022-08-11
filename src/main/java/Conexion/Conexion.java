/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author lberr
 */
public class Conexion {
Connection conectar = null;
    
    public Connection conectar(){
        try{
            Class.forName("oracle.jdbc.OracleDriver");
            conectar = DriverManager.getConnection("jdbc:oracle:thin:@nomasacc.eastus.cloudapp.azure.com:1521:xe","prueba","prueba");
        }catch (ClassNotFoundException | SQLException e){
            System.out.println("Error al conectar: "+e.getMessage());
        }
        return conectar;
    }    
}
