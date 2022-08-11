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
public class Alerta_DB {

    public static boolean RegistrarAlerta(String rut_usuario, Alerta alerta, String d_pago, int v_pago) {
        boolean respuesta = false;
        Connection cn;
        Conexion con = new Conexion();
        cn = con.conectar();

        CallableStatement stmt = null;

        try {
            stmt = cn.prepareCall("CALL CREAR_ALERTA_AF_W(?,?,?,?,?,?,?,?,?,?,?,?,?)");
            stmt.setString(1, rut_usuario);
            stmt.setString(2, alerta.getActividad().getServicio().getNombre_servicio());
            stmt.setString(3, alerta.getActividad().getServicio().getDescr_servicio());
            stmt.setInt(4, alerta.getActividad().getServicio().getValor_servicio());
            stmt.setString(5, d_pago);
            stmt.setInt(6, v_pago);
            stmt.setString(7, alerta.getActividad().getNombre_actividad());
            stmt.setString(8, alerta.getActividad().getDescr_actividad());
            stmt.setString(9, alerta.getNombre_alerta());
            stmt.setString(10, alerta.getDesc_alerta());
            stmt.setDate(11, alerta.getFecha_alerta());
            stmt.setDate(12, alerta.getActividad().getFecha_termino());
            stmt.registerOutParameter(13, java.sql.Types.VARCHAR);
            stmt.executeUpdate();

            //read the OUT parameter now
            String result = stmt.getString(13);

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

    public static ArrayList<Alerta> obtenerAccidentes() {
        ArrayList<Alerta> lista = new ArrayList<Alerta>();

        Connection cn;
        Conexion con = new Conexion();
        cn = con.conectar();

        CallableStatement stmt = null;
        ResultSet rs = null;

        try {
            stmt = cn.prepareCall("CALL VISUALIZAR_ACCIDENTES_UW(?)");
            stmt.registerOutParameter(1, OracleTypes.CURSOR);
            stmt.execute();
            rs = (ResultSet) stmt.getObject(1);

            while (rs.next()) {
                Usuario u = new Usuario(rs.getString("RUT_USUARIO"));

                Servicio s = new Servicio();
                s.setEstado_servicio(rs.getInt("ESTADO_SERVICIO"));
                s.setUsuario(u);

                Actividad a = new Actividad();
                a.setEstado(rs.getInt("ESTADO_ACTIVIDAD"));
                a.setServicio(s);

                Alerta al = new Alerta();
                al.setId_alerta(rs.getInt("ID_ALERTA"));
                al.setId_t_alerta(rs.getInt("ID_TIPO_ACTIVIDAD"));
                al.setFecha_alerta(rs.getDate("FECHA_ALERTA"));
                al.setNombre_alerta(rs.getString("NOMBRE_ALERTA"));
                al.setDesc_alerta(rs.getString("DESCRIPCION_ALERTA"));
                al.setEstado_alerta(rs.getInt("ESTADO_ALERTA"));
                al.setActividad(a);

                lista.add(al);
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

    public static ArrayList<Alerta> obtenerAccidentesXRut(String rut_usuario) {
        ArrayList<Alerta> lista = new ArrayList<Alerta>();

        Connection cn;
        Conexion con = new Conexion();
        cn = con.conectar();

        CallableStatement stmt = null;
        ResultSet rs = null;

        try {
            stmt = cn.prepareCall("CALL VISUALIZAR_ACCIDENTES_XID(?,?)");
            stmt.setString(1, rut_usuario);
            stmt.registerOutParameter(2, OracleTypes.CURSOR);
            stmt.execute();
            rs = (ResultSet) stmt.getObject(2);

            while (rs.next()) {
                Usuario u = new Usuario(rs.getString("RUT_USUARIO"));

                Servicio s = new Servicio();
                s.setEstado_servicio(rs.getInt("ESTADO_SERVICIO"));
                s.setUsuario(u);

                Actividad a = new Actividad();
                a.setEstado(rs.getInt("ESTADO_ACTIVIDAD"));
                a.setServicio(s);

                Alerta al = new Alerta();
                al.setId_alerta(rs.getInt("ID_ALERTA"));
                al.setId_t_alerta(rs.getInt("ID_TIPO_ACTIVIDAD"));
                al.setFecha_alerta(rs.getDate("FECHA_ALERTA"));
                al.setNombre_alerta(rs.getString("NOMBRE_ALERTA"));
                al.setDesc_alerta(rs.getString("DESCRIPCION_ALERTA"));
                al.setEstado_alerta(rs.getInt("ESTADO_ALERTA"));
                al.setActividad(a);

                lista.add(al);
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

    public static ArrayList<Alerta> obtenerFiscalizaciones() {
        ArrayList<Alerta> lista = new ArrayList<Alerta>();

        Connection cn;
        Conexion con = new Conexion();
        cn = con.conectar();

        CallableStatement stmt = null;
        ResultSet rs = null;

        try {
            stmt = cn.prepareCall("CALL VISUALIZAR_FISCALIZACION_UW(?)");
            stmt.registerOutParameter(1, OracleTypes.CURSOR);
            stmt.execute();
            rs = (ResultSet) stmt.getObject(1);

            while (rs.next()) {
                Usuario u = new Usuario(rs.getString("RUT_USUARIO"));

                Servicio s = new Servicio();
                s.setEstado_servicio(rs.getInt("ESTADO_SERVICIO"));
                s.setUsuario(u);

                Actividad a = new Actividad();
                a.setEstado(rs.getInt("ESTADO_ACTIVIDAD"));
                a.setServicio(s);

                Alerta al = new Alerta();
                al.setId_alerta(rs.getInt("ID_ALERTA"));
                al.setId_t_alerta(rs.getInt("ID_TIPO_ACTIVIDAD"));
                al.setFecha_alerta(rs.getDate("FECHA_ALERTA"));
                al.setNombre_alerta(rs.getString("NOMBRE_ALERTA"));
                al.setDesc_alerta(rs.getString("DESCRIPCION_ALERTA"));
                al.setEstado_alerta(rs.getInt("ESTADO_ALERTA"));
                al.setActividad(a);

                lista.add(al);
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

    public static ArrayList<Alerta> obtenerFiscalizacionesXRut(String rut_usuario) {
        ArrayList<Alerta> lista = new ArrayList<Alerta>();

        Connection cn;
        Conexion con = new Conexion();
        cn = con.conectar();

        CallableStatement stmt = null;
        ResultSet rs = null;

        try {
            stmt = cn.prepareCall("CALL VISUALIZAR_FISCALIZACION_XID(?,?)");
            stmt.setString(1, rut_usuario);
            stmt.registerOutParameter(2, OracleTypes.CURSOR);
            stmt.execute();
            rs = (ResultSet) stmt.getObject(2);

            while (rs.next()) {
                Usuario u = new Usuario(rs.getString("RUT_USUARIO"));

                Servicio s = new Servicio();
                s.setEstado_servicio(rs.getInt("ESTADO_SERVICIO"));
                s.setUsuario(u);

                Actividad a = new Actividad();
                a.setEstado(rs.getInt("ESTADO_ACTIVIDAD"));
                a.setServicio(s);

                Alerta al = new Alerta();
                al.setId_alerta(rs.getInt("ID_ALERTA"));
                al.setId_t_alerta(rs.getInt("ID_TIPO_ACTIVIDAD"));
                al.setFecha_alerta(rs.getDate("FECHA_ALERTA"));
                al.setNombre_alerta(rs.getString("NOMBRE_ALERTA"));
                al.setDesc_alerta(rs.getString("DESCRIPCION_ALERTA"));
                al.setEstado_alerta(rs.getInt("ESTADO_ALERTA"));
                al.setActividad(a);

                lista.add(al);
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

    public static Alerta buscarAlertaID(int id) {
        Alerta alerta = new Alerta();
        Actividad a = new Actividad();
        Servicio s = new Servicio();
        Usuario u = new Usuario();
        Empresa em = new Empresa();
        Connection cn;
        Conexion con = new Conexion();
        cn = con.conectar();

        CallableStatement stmt = null;
        ResultSet rs = null;

        try {
            stmt = cn.prepareCall("CALL VISUALIZAR_ALERTA_XID(?,?)");
            stmt.setInt(1, id);

            stmt.registerOutParameter(2, OracleTypes.CURSOR);
            stmt.execute();
            rs = (ResultSet) stmt.getObject(2);

            while (rs.next()) {
                em.setTelefono(rs.getInt("TELEFONO_EMPRESA"));
                em.setRazon_social(rs.getString("RAZON_SOCIAL_EMPRESA"));
                em.setDireccion(rs.getString("DIRECCION_EMPRESA"));
                u.setEmpresa(em);
                u.setRut_usuario(rs.getString("RUT_USUARIO"));
                u.setNombre_usuario(rs.getString("NOMBRE_USUARIO"));
                u.setCorreo_usuario(rs.getString("CORREO_USUARIO"));
                s.setId_servicio(rs.getInt("ID_SERVICIO"));
                s.setUsuario(u);
                s.setId_servicio(rs.getInt("ID_SERVICIO"));
                a.setServicio(s);
                a.setNombre_actividad(rs.getString("NOMBRE_ACTIVIDAD"));
                a.setDescr_actividad(rs.getString("DESCRIPCION_ACTIVIDAD"));
                a.setFecha_inicio(rs.getDate("FECHA_INICIO"));
                a.setId_actividad(rs.getInt("ID_ACTIVIDAD"));
                alerta.setActividad(a);
                alerta.setId_alerta(rs.getInt("ID_ALERTA"));
                alerta.setId_t_alerta(rs.getInt("ID_TIPO_ACTIVIDAD"));
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
        return alerta;
    }
    
    
    
    public static int BuscarCAlertasXA(String rut_usuario, Date fecha){
        int resultado = 0;
         
        Connection cn;
        Conexion con = new Conexion();
        cn = con.conectar();

        CallableStatement stmt = null;
        ResultSet rs = null;
         try {
            stmt = cn.prepareCall("CALL BUSCAR_ALERTAS_XA(?,?,?)");
            stmt.setString(1, rut_usuario);
            stmt.setDate(2, fecha);
            
            stmt.registerOutParameter(3, OracleTypes.CURSOR);
            stmt.execute();
            rs = (ResultSet) stmt.getObject(3);

            while (rs.next()) {
               resultado = rs.getInt("CONTADOR");  
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
    
    
     public static int BuscarActividadesXFID(String rut_usuario, Date fecha){
        int resultado = 0;
         
        Connection cn;
        Conexion con = new Conexion();
        cn = con.conectar();

        CallableStatement stmt = null;
        ResultSet rs = null;
         try {
            stmt = cn.prepareCall("CALL BUSCAR_ACTIVIDADES_EMXFID(?,?,?)");
            stmt.setString(1, rut_usuario);
            stmt.setDate(2, fecha);
            
            stmt.registerOutParameter(3, OracleTypes.CURSOR);
            stmt.execute();
            rs = (ResultSet) stmt.getObject(3);

            while (rs.next()) {
               resultado = rs.getInt("CONTADOR");  
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
     
     
     public static boolean IngresarVisita(int id_alert, int estado_a) {
        boolean respuesta = false;

        Connection cn;
        Conexion con = new Conexion();
        cn = con.conectar();

        CallableStatement stmt = null;

        try {
            stmt = cn.prepareCall("CALL EDITAR_ALERTA_ALVI_W(?,?,?)");
            stmt.setInt(1, id_alert);
            stmt.setInt(2, estado_a);
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

     
       public static boolean CancelarVisita(int ea, int ida, int es,int ids, int eal, int idal) {
        boolean respuesta = false;

        Connection cn;
        Conexion con = new Conexion();
        cn = con.conectar();

        CallableStatement stmt = null;

        try {
            stmt = cn.prepareCall("CALL EDITAR_CANCELAR_ALERTA_W(?,?,?,?,?,?,?)");
            stmt.setInt(1, ea);
            stmt.setInt(2, ida);
            stmt.setInt(3, es);
            stmt.setInt(4, ids);
            stmt.setInt(5, eal);
            stmt.setInt(6, idal);
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
     
       
     public static boolean CambiarEstadoAl(int id_alert, int estado_a) {
        boolean respuesta = false;

        Connection cn;
        Conexion con = new Conexion();
        cn = con.conectar();

        CallableStatement stmt = null;

        try {
            stmt = cn.prepareCall("CALL EDITAR_ALERTA_ALVI_W(?,?,?)");
            stmt.setInt(1, id_alert);
            stmt.setInt(2, estado_a);
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
     
}
