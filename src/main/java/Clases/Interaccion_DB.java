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
public class Interaccion_DB {
        
    public static ArrayList<Interaccion> obtenerChatSProfesional(String rut_profesional) {
        ArrayList<Interaccion> lista = new ArrayList<Interaccion>();

        Connection cn;
        Conexion con = new Conexion();
        cn = con.conectar();

        CallableStatement stmt = null;
        ResultSet rs = null;

        try {
            stmt = cn.prepareCall("CALL VISUALIZAR_PROF_CHAT_XID(?,?)");
            stmt.setString(1, rut_profesional);
            stmt.registerOutParameter(2, OracleTypes.CURSOR);
            stmt.execute();
            rs = (ResultSet) stmt.getObject(2);

            while (rs.next()) {
                Usuario u = new Usuario();
                u.setRut_usuario(rs.getString("RUT_USUARIO"));
                u.setNombre_usuario(rs.getString("NOMBRE_USUARIO"));
                u.setApellido_usuario(rs.getString("APELLIDO_USUARIO"));
                u.setCorreo_usuario(rs.getString("CORREO_USUARIO"));
                u.setTelefono_usuario(rs.getInt("TELEFONO_USUARIO"));
                
                Servicio s = new Servicio();
                s.setId_servicio(rs.getInt("ID_SERVICIO"));
                
                Actividad a = new Actividad();
                a.setId_actividad(rs.getInt("ID_ACTIVIDAD"));
                a.setEstado(rs.getInt("ESTADO"));
                a.setServicio(s);
                
                Interaccion i = new Interaccion();
                i.setId_profesional(rs.getString("ID_PROFESIONAL"));
                i.setFecha_interaccion(rs.getDate("FECHA_INTERACION"));
                i.setActividad(a);
                i.setUsuario(u);
                
                lista.add(i);
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
    
    
    
     public static ArrayList<Interaccion> obtenerChatHProfesional(String rut_profesional) {
        ArrayList<Interaccion> lista = new ArrayList<Interaccion>();

        Connection cn;
        Conexion con = new Conexion();
        cn = con.conectar();

        CallableStatement stmt = null;
        ResultSet rs = null;

        try {
            stmt = cn.prepareCall("CALL VISUALIZAR_PROF_CHAT(?,?)");
            stmt.setString(1, rut_profesional);
            stmt.registerOutParameter(2, OracleTypes.CURSOR);
            stmt.execute();
            rs = (ResultSet) stmt.getObject(2);

            while (rs.next()) {
                Usuario u = new Usuario();
                u.setRut_usuario(rs.getString("RUT_USUARIO"));
                u.setNombre_usuario(rs.getString("NOMBRE_USUARIO"));
                u.setApellido_usuario(rs.getString("APELLIDO_USUARIO"));
                u.setCorreo_usuario(rs.getString("CORREO_USUARIO"));
                u.setTelefono_usuario(rs.getInt("TELEFONO_USUARIO"));
                
                Servicio s = new Servicio();
                s.setId_servicio(rs.getInt("ID_SERVICIO"));
                
                Actividad a = new Actividad();
                a.setId_actividad(rs.getInt("ID_ACTIVIDAD"));
                a.setEstado(rs.getInt("ESTADO"));
                a.setServicio(s);
                
                Interaccion i = new Interaccion();
                i.setId_profesional(rs.getString("ID_PROFESIONAL"));
                i.setFecha_interaccion(rs.getDate("FECHA_INTERACION"));
                i.setActividad(a);
                i.setUsuario(u);
                
                lista.add(i);
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
     
     
     
     public static ArrayList<Interaccion> obtenerChatHCliente(String rut_usuario) {
        ArrayList<Interaccion> lista = new ArrayList<Interaccion>();

        Connection cn;
        Conexion con = new Conexion();
        cn = con.conectar();

        CallableStatement stmt = null;
        ResultSet rs = null;

        try {
            stmt = cn.prepareCall("CALL VISUALIZAR_USER_CHAT_XID(?,?)");
            stmt.setString(1, rut_usuario);
            stmt.registerOutParameter(2, OracleTypes.CURSOR);
            stmt.execute();
            rs = (ResultSet) stmt.getObject(2);

            while (rs.next()) {
                Usuario u = new Usuario();
                u.setRut_usuario(rs.getString("RUT_USUARIO"));
                u.setNombre_usuario(rs.getString("NOMBRE_USUARIO"));
                u.setApellido_usuario(rs.getString("APELLIDO_USUARIO"));
                u.setCorreo_usuario(rs.getString("CORREO_USUARIO"));
                u.setTelefono_usuario(rs.getInt("TELEFONO_USUARIO"));
                
                Servicio s = new Servicio();
                s.setId_servicio(rs.getInt("ID_SERVICIO"));
                
                Actividad a = new Actividad();
                a.setId_actividad(rs.getInt("ID_ACTIVIDAD"));
                a.setEstado(rs.getInt("ESTADO"));
                a.setServicio(s);
                
                Interaccion i = new Interaccion();
                i.setId_profesional(rs.getString("ID_PROFESIONAL"));
                i.setFecha_interaccion(rs.getDate("FECHA_INTERACION"));
                i.setActividad(a);
                i.setUsuario(u);
                
                lista.add(i);
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
     
     
      public static Interaccion ObtenerInfoChatC(int ida) {
        Interaccion interaccion = new Interaccion();

        Connection cn;
        Conexion con = new Conexion();
        cn = con.conectar();

        CallableStatement stmt = null;
        ResultSet rs = null;

        try {
            stmt = cn.prepareCall("CALL VISUALIZAR_CHAT_XIDAC(?,?)");
            stmt.setInt(1, ida);

            stmt.registerOutParameter(2, OracleTypes.CURSOR);
            stmt.execute();
            rs = (ResultSet) stmt.getObject(2);

            while (rs.next()) {
                Usuario u = new Usuario();
                u.setRut_usuario(rs.getString("RUT_USUARIO"));
                u.setNombre_usuario(rs.getString("NOMBRE_USUARIO"));
                u.setApellido_usuario(rs.getString("APELLIDO_USUARIO"));
                u.setCorreo_usuario(rs.getString("CORREO_USUARIO"));
                u.setTelefono_usuario(rs.getInt("TELEFONO_USUARIO"));
                
                Servicio s = new Servicio();
                s.setId_servicio(rs.getInt("ID_SERVICIO"));
                
                Actividad a = new Actividad();
                a.setId_actividad(rs.getInt("ID_ACTIVIDAD"));
                a.setEstado(rs.getInt("ESTADO"));
                a.setServicio(s);
                
                interaccion.setId_profesional(rs.getString("ID_PROFESIONAL"));
                interaccion.setFecha_interaccion(rs.getDate("FECHA_INTERACION"));
                interaccion.setActividad(a);
                interaccion.setUsuario(u);
                
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
        return interaccion;
    } 
     
    
     public static Interaccion ObtenerInfoChatP(int ida) {
        Interaccion interaccion = new Interaccion();

        Connection cn;
        Conexion con = new Conexion();
        cn = con.conectar();

        CallableStatement stmt = null;
        ResultSet rs = null;

        try {
            stmt = cn.prepareCall("CALL VISUALIZAR_CHAT_XIDAP(?,?)");
            stmt.setInt(1, ida);

            stmt.registerOutParameter(2, OracleTypes.CURSOR);
            stmt.execute();
            rs = (ResultSet) stmt.getObject(2);

            while (rs.next()) {
                Usuario u = new Usuario();
                u.setRut_usuario(rs.getString("RUT_USUARIO"));
                u.setNombre_usuario(rs.getString("NOMBRE_USUARIO"));
                u.setApellido_usuario(rs.getString("APELLIDO_USUARIO"));
                u.setCorreo_usuario(rs.getString("CORREO_USUARIO"));
                u.setTelefono_usuario(rs.getInt("TELEFONO_USUARIO"));
                
                Servicio s = new Servicio();
                s.setId_servicio(rs.getInt("ID_SERVICIO"));
                
                Actividad a = new Actividad();
                a.setId_actividad(rs.getInt("ID_ACTIVIDAD"));
                a.setEstado(rs.getInt("ESTADO"));
                a.setServicio(s);
                
                interaccion.setId_profesional(rs.getString("ID_PROFESIONAL"));
                interaccion.setFecha_interaccion(rs.getDate("FECHA_INTERACION"));
                interaccion.setActividad(a);
                interaccion.setUsuario(u);
                
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
        return interaccion;
    } 
     
     
     public static boolean CerrarChat(int ea, int ida, int es,int ids) {
        boolean respuesta = false;

        Connection cn;
        Conexion con = new Conexion();
        cn = con.conectar();

        CallableStatement stmt = null;

        try {
            stmt = cn.prepareCall("CALL EDITAR_CERRAR_CHAT_W(?,?,?,?,?)");
            stmt.setInt(1, ea);
            stmt.setInt(2, ida);
            stmt.setInt(3, es);
            stmt.setInt(4, ids);
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
     
     
     public static ArrayList<Interaccion> obtenerChatH() {
        ArrayList<Interaccion> lista = new ArrayList<Interaccion>();

        Connection cn;
        Conexion con = new Conexion();
        cn = con.conectar();

        CallableStatement stmt = null;
        ResultSet rs = null;

        try {
            stmt = cn.prepareCall("CALL VISUALIZAR_ADMIN_CHAT_XID(?)");
            stmt.registerOutParameter(1, OracleTypes.CURSOR);
            stmt.execute();
            rs = (ResultSet) stmt.getObject(1);

            while (rs.next()) {
                Usuario u = new Usuario();
                u.setRut_usuario(rs.getString("RUT_USUARIO"));
                u.setNombre_usuario(rs.getString("NOMBRE_USUARIO"));
                u.setApellido_usuario(rs.getString("APELLIDO_USUARIO"));
                u.setCorreo_usuario(rs.getString("CORREO_USUARIO"));
                u.setTelefono_usuario(rs.getInt("TELEFONO_USUARIO"));
                
                Servicio s = new Servicio();
                s.setId_servicio(rs.getInt("ID_SERVICIO"));
                
                Actividad a = new Actividad();
                a.setId_actividad(rs.getInt("ID_ACTIVIDAD"));
                a.setEstado(rs.getInt("ESTADO"));
                a.setServicio(s);
                
                Interaccion i = new Interaccion();
                i.setId_profesional(rs.getString("ID_PROFESIONAL"));
                i.setFecha_interaccion(rs.getDate("FECHA_INTERACION"));
                i.setActividad(a);
                i.setUsuario(u);
                
                lista.add(i);
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
