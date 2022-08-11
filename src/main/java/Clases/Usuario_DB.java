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
import java.util.Scanner;
import oracle.jdbc.OracleTypes;

/**
 *
 * @author lberr
 */
public class Usuario_DB {

    public static Usuario VerificarUsuario(String rut_usuario, String pass_usuario) {
        Usuario usuario = new Usuario();

        Connection cn;
        Conexion con = new Conexion();
        cn = con.conectar();

        CallableStatement stmt = null;
        ResultSet rs = null;

        try {
            stmt = cn.prepareCall("CALL VALIDAR_USUARIO(?,?,?)");
            stmt.setString(1, rut_usuario);
            stmt.setString(2, pass_usuario);

            stmt.registerOutParameter(3, OracleTypes.CURSOR);
            stmt.execute();
            rs = (ResultSet) stmt.getObject(3);

            while (rs.next()) {
                usuario.setRut_usuario(rs.getString("RUT_USUARIO"));
                usuario.setNombre_usuario(rs.getString("NOMBRE_USUARIO"));
                usuario.setApellido_usuario(rs.getString("APELLIDO_USUARIO"));
                usuario.setHabilitado(rs.getInt("HABILITADO"));
                usuario.setTipo_usuario(rs.getString("TIPO"));
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
        return usuario;
    }

    public static Usuario VerificarUsuarioRut(String rut_usuario) {
        Usuario usuario = new Usuario();

        Connection cn;
        Conexion con = new Conexion();
        cn = con.conectar();

        CallableStatement stmt = null;
        ResultSet rs = null;

        try {
            stmt = cn.prepareCall("CALL VALIDAR_USUARIO_RUT(?,?)");
            stmt.setString(1, rut_usuario);

            stmt.registerOutParameter(2, OracleTypes.CURSOR);
            stmt.execute();
            rs = (ResultSet) stmt.getObject(2);

            while (rs.next()) {
                usuario.setRut_usuario(rs.getString("RUT_USUARIO"));
                usuario.setNombre_usuario(rs.getString("NOMBRE_USUARIO"));
                usuario.setApellido_usuario(rs.getString("APELLIDO_USUARIO"));
                usuario.setHabilitado(rs.getInt("HABILITADO"));
                usuario.setTipo_usuario(rs.getString("TIPO"));
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
        return usuario;
    }

    public static boolean CambiarContraseña(String rut_usuario, String pass_usuario) {
        boolean respuesta = false;

        Connection cn;
        Conexion con = new Conexion();
        cn = con.conectar();

        CallableStatement stmt = null;

        try {
            stmt = cn.prepareCall("CALL CAMBIAR_CONTRASEÑA_W(?,?,?)");
            stmt.setString(1, rut_usuario);
            stmt.setString(2, pass_usuario);
            stmt.registerOutParameter(3, java.sql.Types.VARCHAR);
            stmt.executeUpdate();

            //read the OUT parameter now
            String result = stmt.getString(3);

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

    public static boolean RegistrarCliente(Usuario usuario, Empresa empresa) {
        boolean respuesta = false;

        Connection cn;
        Conexion con = new Conexion();
        cn = con.conectar();

        CallableStatement stmt = null;

        try {
            stmt = cn.prepareCall("CALL CREAR_USUARIO_CLIENTE_W(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
            stmt.setString(1, usuario.getRut_usuario());
            stmt.setString(2, usuario.getContraseña_usuario());
            stmt.setString(3, usuario.getTipo_usuario());
            stmt.setString(4, usuario.getNombre_usuario());
            stmt.setString(5, usuario.getApellido_usuario());
            stmt.setInt(6, usuario.getTelefono_usuario());
            stmt.setString(7, usuario.getCorreo_usuario());
            stmt.setString(8, usuario.getDireccion_usuario());
            stmt.setString(9, empresa.getRut_empresa());
            stmt.setString(10, empresa.getRazon_social());
            stmt.setString(11, empresa.getDireccion());
            stmt.setInt(12, empresa.getTelefono());
            stmt.setString(13, empresa.getCorreo());
            stmt.setString(14, empresa.getPagina());
            stmt.registerOutParameter(15, java.sql.Types.VARCHAR);
            stmt.executeUpdate();

            //read the OUT parameter now
            String result = stmt.getString(15);

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
    
    public static boolean RegistrarProfesional(Usuario usuario){
        boolean respuesta = false;
        Connection cn;
        Conexion con = new Conexion();
        cn = con.conectar();

        CallableStatement stmt = null;
        
            try {
            stmt = cn.prepareCall("CALL CREAR_USUARIO_PROFESIONAL_W(?,?,?,?,?,?,?,?,?,?)");
            stmt.setString(1, usuario.getRut_usuario());
            stmt.setString(2, usuario.getContraseña_usuario());
            stmt.setString(3, usuario.getTipo_usuario());
            stmt.setString(4, usuario.getNombre_usuario());
            stmt.setString(5, usuario.getApellido_usuario());
            stmt.setInt(6, usuario.getTelefono_usuario());
            stmt.setString(7, usuario.getCorreo_usuario());
            stmt.setString(8, usuario.getDireccion_usuario());
            stmt.setString(9, usuario.getProfesion());
            stmt.registerOutParameter(10, java.sql.Types.VARCHAR);
            stmt.executeUpdate();

            //read the OUT parameter now
            String result = stmt.getString(10);

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

    public static Usuario BuscarUsuario(String rut_usuario) {
        Usuario usuario = new Usuario();

        Connection cn;
        Conexion con = new Conexion();
        cn = con.conectar();

        CallableStatement stmt = null;
        ResultSet rs = null;

        try {
            stmt = cn.prepareCall("CALL BUSCAR_USUARIO(?,?)");
            stmt.setString(1, rut_usuario);

            stmt.registerOutParameter(2, OracleTypes.CURSOR);
            stmt.execute();
            rs = (ResultSet) stmt.getObject(2);

            while (rs.next()) {
                usuario.setNombre_usuario(rs.getString("NOMBRE_USUARIO"));
                usuario.setApellido_usuario(rs.getString("APELLIDO_USUARIO"));
                usuario.setDireccion_usuario(rs.getString("DOMICILIO_USUARIO"));
                usuario.setTelefono_usuario(rs.getInt("TELEFONO_USUARIO"));
                usuario.setCorreo_usuario(rs.getString("CORREO_USUARIO"));
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
        return usuario;
    }
    
    
      public static Usuario BuscarUsuarioProf(String rut_usuario) {
        Usuario usuario = new Usuario();

        Connection cn;
        Conexion con = new Conexion();
        cn = con.conectar();

        CallableStatement stmt = null;
        ResultSet rs = null;

        try {
            stmt = cn.prepareCall("CALL BUSCAR_USUARIO_PROFE(?,?)");
            stmt.setString(1, rut_usuario);

            stmt.registerOutParameter(2, OracleTypes.CURSOR);
            stmt.execute();
            rs = (ResultSet) stmt.getObject(2);

            while (rs.next()) {
                usuario.setNombre_usuario(rs.getString("NOMBRE_USUARIO"));
                usuario.setApellido_usuario(rs.getString("APELLIDO_USUARIO"));
                usuario.setDireccion_usuario(rs.getString("DOMICILIO_USUARIO"));
                usuario.setTelefono_usuario(rs.getInt("TELEFONO_USUARIO"));
                usuario.setCorreo_usuario(rs.getString("CORREO_USUARIO"));
                usuario.setProfesion(rs.getString("NOMBRE_PROFESION"));
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
        return usuario;
    }

    public static ArrayList<Usuario> obtenerUsuarioCliente() {
        ArrayList<Usuario> lista = new ArrayList<Usuario>();

        Connection cn;
        Conexion con = new Conexion();
        cn = con.conectar();

        CallableStatement stmt = null;
        ResultSet rs = null;

        try {
            stmt = cn.prepareCall("CALL VISUALIZAR_USUARIO_CLIENTE(?)");
            stmt.registerOutParameter(1, OracleTypes.CURSOR);
            stmt.execute();
            rs = (ResultSet) stmt.getObject(1);

            while (rs.next()) {
                Empresa e = new Empresa(rs.getString("RUT_EMPRESA"), rs.getString("RUT_USUARIO"), rs.getString("RAZON_SOCIAL_EMPRESA"), rs.getString("DIRECCION_EMPRESA"), rs.getInt("TELEFONO_EMPRESA"), rs.getString("CORREO_EMPRESA"), rs.getString("PAGINA_WEB_EMPRESA"));
                Usuario u = new Usuario(rs.getString("RUT_USUARIO"), rs.getString("CORREO_USUARIO"), rs.getString("NOMBRE_USUARIO"),rs.getString("APELLIDO_USUARIO"), rs.getString("DOMICILIO_USUARIO"),rs.getInt("TELEFONO_USUARIO"),rs.getInt("HABILITADO"), e);
               
                lista.add(u);
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
    
    
     public static ArrayList<Usuario> obtenerUsuarioClienteCC() {
        ArrayList<Usuario> lista = new ArrayList<Usuario>();

        Connection cn;
        Conexion con = new Conexion();
        cn = con.conectar();

        CallableStatement stmt = null;
        ResultSet rs = null;

        try {
            stmt = cn.prepareCall("CALL VISUALIZAR_USUARIO_CLIENTE_CC(?)");
            stmt.registerOutParameter(1, OracleTypes.CURSOR);
            stmt.execute();
            rs = (ResultSet) stmt.getObject(1);

            while (rs.next()) {
                Empresa e = new Empresa(rs.getString("RUT_EMPRESA"), rs.getString("RUT_USUARIO"), rs.getString("RAZON_SOCIAL_EMPRESA"), rs.getString("DIRECCION_EMPRESA"), rs.getInt("TELEFONO_EMPRESA"), rs.getString("CORREO_EMPRESA"), rs.getString("PAGINA_WEB_EMPRESA"));
                Usuario u = new Usuario(rs.getString("RUT_USUARIO"), rs.getString("CORREO_USUARIO"), rs.getString("NOMBRE_USUARIO"),rs.getString("APELLIDO_USUARIO"), rs.getString("DOMICILIO_USUARIO"),rs.getInt("TELEFONO_USUARIO"),rs.getInt("HABILITADO"), e);
               
                lista.add(u);
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
    
      public static ArrayList<Usuario> obtenerUsuarioProfesional() {
        ArrayList<Usuario> lista = new ArrayList<Usuario>();
      
        Connection cn;
        Conexion con = new Conexion();
        cn = con.conectar();

        CallableStatement stmt = null;
        ResultSet rs = null;
        
         try {
            stmt = cn.prepareCall("CALL VISUALIZAR_USUARIO_PROFESIONAL(?)");
            stmt.registerOutParameter(1, OracleTypes.CURSOR);
            stmt.execute();
            rs = (ResultSet) stmt.getObject(1);
            
             while (rs.next()) {
                Usuario u = new Usuario(rs.getString("RUT_USUARIO"), rs.getString("CORREO_USUARIO"), rs.getString("NOMBRE_USUARIO"), rs.getString("APELLIDO_USUARIO"), rs.getString("NOMBRE_PROFESION"), rs.getString("DOMICILIO_USUARIO"), rs.getInt("TELEFONO_USUARIO"), rs.getInt("HABILITADO"));
                lista.add(u);
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
    
    
    public static Usuario BuscarUsuarioRut(String rut_usuario){
        Usuario usuario = new Usuario();
        Empresa empresa = new Empresa();
        
        Connection cn;
        Conexion con = new Conexion();
        cn = con.conectar();

        CallableStatement stmt = null;
        ResultSet rs = null;
         try {
            stmt = cn.prepareCall("CALL VISUALIZAR_USUARIO_CLIENTE_RC(?,?)");
            stmt.setString(1, rut_usuario);

            stmt.registerOutParameter(2, OracleTypes.CURSOR);
            stmt.execute();
            rs = (ResultSet) stmt.getObject(2);

            while (rs.next()) {
                empresa.setRazon_social(rs.getString("RAZON_SOCIAL_EMPRESA"));
                empresa.setDireccion(rs.getString("DIRECCION_EMPRESA"));
                empresa.setTelefono(rs.getInt("TELEFONO_EMPRESA"));
                empresa.setCorreo(rs.getString("CORREO_EMPRESA"));
                empresa.setPagina(rs.getString("PAGINA_WEB_EMPRESA"));

                usuario.setNombre_usuario(rs.getString("NOMBRE_USUARIO"));
                usuario.setApellido_usuario(rs.getString("APELLIDO_USUARIO"));
                usuario.setDireccion_usuario(rs.getString("DOMICILIO_USUARIO"));
                usuario.setTelefono_usuario(rs.getInt("TELEFONO_USUARIO"));
                usuario.setCorreo_usuario(rs.getString("CORREO_USUARIO"));
                usuario.setHabilitado(rs.getInt("HABILITADO"));
                usuario.setEmpresa(empresa);
                
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
        return usuario;

    }
    
      public static Usuario BuscarUsuarioRutP(String rut_usuario){
        Usuario usuario = new Usuario();
        Connection cn;
        Conexion con = new Conexion();
        cn = con.conectar();

        CallableStatement stmt = null;
        ResultSet rs = null;
         try {
            stmt = cn.prepareCall("CALL VISUALIZAR_USUARIO_CLIENTE_RP(?,?)");
            stmt.setString(1, rut_usuario);

            stmt.registerOutParameter(2, OracleTypes.CURSOR);
            stmt.execute();
            rs = (ResultSet) stmt.getObject(2);

            while (rs.next()) {
                usuario.setNombre_usuario(rs.getString("NOMBRE_USUARIO"));
                usuario.setApellido_usuario(rs.getString("APELLIDO_USUARIO"));
                usuario.setDireccion_usuario(rs.getString("DOMICILIO_USUARIO"));
                usuario.setTelefono_usuario(rs.getInt("TELEFONO_USUARIO"));
                usuario.setCorreo_usuario(rs.getString("CORREO_USUARIO"));
                usuario.setHabilitado(rs.getInt("HABILITADO"));
                usuario.setProfesion(rs.getString("NOMBRE_PROFESION"));
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
        return usuario;

    }    
    

    public static boolean CambiarEstadoCliente(String rut_usuario,int estado_usuario){
          boolean respuesta = false;

        Connection cn;
        Conexion con = new Conexion();
        cn = con.conectar();

        CallableStatement stmt = null;

        try {
            stmt = cn.prepareCall("CALL MODIFICAR_ESTADO_USUARIO_W(?,?,?)");
            stmt.setString(1, rut_usuario);
            stmt.setInt(2, estado_usuario);
            stmt.registerOutParameter(3, java.sql.Types.VARCHAR);
            stmt.executeUpdate();

            //read the OUT parameter now
            String result = stmt.getString(3);

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
    
    
    public static boolean ActualizarUsuarioCliente(Usuario usuario){
    
      boolean respuesta = false;

        Connection cn;
        Conexion con = new Conexion();
        cn = con.conectar();

        CallableStatement stmt = null;

        try {
            stmt = cn.prepareCall("CALL MODIFICAR_USUARIO_W(?,?,?,?,?,?,?)");
            stmt.setString(1, usuario.getRut_usuario());
            stmt.setString(2, usuario.getNombre_usuario());
            stmt.setString(3, usuario.getApellido_usuario());
            stmt.setInt(4, usuario.getTelefono_usuario());
            stmt.setString(5, usuario.getCorreo_usuario());
            stmt.setString(6, usuario.getDireccion_usuario());
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
    
     
    public static boolean ActualizarUsuarioProfesional(Usuario usuario){
    
      boolean respuesta = false;

        Connection cn;
        Conexion con = new Conexion();
        cn = con.conectar();

        CallableStatement stmt = null;

        try {
            stmt = cn.prepareCall("CALL MODIFICAR_USUARIO_W(?,?,?,?,?,?,?)");
            stmt.setString(1, usuario.getRut_usuario());
            stmt.setString(2, usuario.getNombre_usuario());
            stmt.setString(3, usuario.getApellido_usuario());
            stmt.setInt(4, usuario.getTelefono_usuario());
            stmt.setString(5, usuario.getCorreo_usuario());
            stmt.setString(6, usuario.getDireccion_usuario());
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
    
    public static boolean ActualizarProfesion(Usuario usuario){
          boolean respuesta = false;

        Connection cn;
        Conexion con = new Conexion();
        cn = con.conectar();

        CallableStatement stmt = null;
        
                try {
            stmt = cn.prepareCall("CALL MODIFICAR_PROFESION_USUARIO_W(?,?,?)");
            stmt.setString(1, usuario.getRut_usuario());
            stmt.setString(2, usuario.getProfesion());
            stmt.registerOutParameter(3, java.sql.Types.VARCHAR);
            stmt.executeUpdate();

            //read the OUT parameter now
            String result = stmt.getString(3);

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
    
    
    
      public static boolean ActualizarUsuarioAdmin(Usuario usuario){
    
      boolean respuesta = false;

        Connection cn;
        Conexion con = new Conexion();
        cn = con.conectar();

        CallableStatement stmt = null;

        try {
            stmt = cn.prepareCall("CALL MODIFICAR_USUARIO_W(?,?,?,?,?,?,?)");
            stmt.setString(1, usuario.getRut_usuario());
            stmt.setString(2, usuario.getNombre_usuario());
            stmt.setString(3, usuario.getApellido_usuario());
            stmt.setInt(4, usuario.getTelefono_usuario());
            stmt.setString(5, usuario.getCorreo_usuario());
            stmt.setString(6, usuario.getDireccion_usuario());
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
      
      
      public static ArrayList<Usuario> obtenerUsuarioSinContrato() {
        ArrayList<Usuario> lista = new ArrayList<Usuario>();
      
        Connection cn;
        Conexion con = new Conexion();
        cn = con.conectar();

        CallableStatement stmt = null;
        ResultSet rs = null;
        
         try {
            stmt = cn.prepareCall("CALL VISUALIZAR_CLIENTES_SC(?)");
            stmt.registerOutParameter(1, OracleTypes.CURSOR);
            stmt.execute();
            rs = (ResultSet) stmt.getObject(1);
            
             while (rs.next()) {
                Usuario u = new Usuario(rs.getString("RUT_USUARIO"), rs.getString("CORREO_USUARIO"), rs.getString("NOMBRE_USUARIO"), rs.getString("APELLIDO_USUARIO"));
                lista.add(u);
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
                  
        public static ArrayList<Usuario> obtenerUsuarioConContrato() {
        ArrayList<Usuario> lista = new ArrayList<Usuario>();
      
        Connection cn;
        Conexion con = new Conexion();
        cn = con.conectar();

        CallableStatement stmt = null;
        ResultSet rs = null;
        
         try {
            stmt = cn.prepareCall("CALL VISUALIZAR_CLIENTES_CCA(?)");
            stmt.registerOutParameter(1, OracleTypes.CURSOR);
            stmt.execute();
            rs = (ResultSet) stmt.getObject(1);
            
             while (rs.next()) {
                Usuario u = new Usuario(rs.getString("RUT_USUARIO"), rs.getString("CORREO_USUARIO"), rs.getString("NOMBRE_USUARIO"), rs.getString("APELLIDO_USUARIO"));
                lista.add(u);
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
              
      
       public static String BuscarProfesionUP(String rut_usuario){
        String resultado = null;
         
        Connection cn;
        Conexion con = new Conexion();
        cn = con.conectar();

        CallableStatement stmt = null;
        ResultSet rs = null;
         try {
            stmt = cn.prepareCall("CALL BUSCAR_PROFESION_XU(?,?)");
            stmt.setString(1, rut_usuario);

            stmt.registerOutParameter(2, OracleTypes.CURSOR);
            stmt.execute();
            rs = (ResultSet) stmt.getObject(2);

            while (rs.next()) {
               resultado = rs.getString("NOMBRE_PROFESION");  
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
       
      public static ArrayList<Usuario> obtenerUsuarioProfAct() {
        ArrayList<Usuario> lista = new ArrayList<Usuario>();
      
        Connection cn;
        Conexion con = new Conexion();
        cn = con.conectar();

        CallableStatement stmt = null;
        ResultSet rs = null;
        
         try {
            stmt = cn.prepareCall("CALL VISUALIZAR_USUA_PROFES_ACT(?)");
            stmt.registerOutParameter(1, OracleTypes.CURSOR);
            stmt.execute();
            rs = (ResultSet) stmt.getObject(1);
            
             while (rs.next()) {
                Usuario u = new Usuario(rs.getString("RUT_USUARIO"), rs.getString("CORREO_USUARIO"), rs.getString("NOMBRE_USUARIO"), rs.getString("APELLIDO_USUARIO"), rs.getString("NOMBRE_PROFESION"), rs.getString("DOMICILIO_USUARIO"), rs.getInt("TELEFONO_USUARIO"), rs.getInt("HABILITADO"));
                lista.add(u);
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
