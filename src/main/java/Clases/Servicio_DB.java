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
public class Servicio_DB {
    
  public static boolean RegistrarServicioContrato(Usuario usuario, Servicio servicio) {
        boolean respuesta = false;

        Connection cn;
        Conexion con = new Conexion();
        cn = con.conectar();

        CallableStatement stmt = null;

        try {
            stmt = cn.prepareCall("CALL CREAR_SERVICIO_CONTRATO_W(?,?,?,?,?,?,?)");
            stmt.setString(1, usuario.getRut_usuario());
            stmt.setString(2,servicio.getNombre_servicio());
            stmt.setInt(3,servicio.getValor_servicio());
            stmt.setString(4,servicio.getDescr_servicio());
            stmt.setDate(5,servicio.getFecha_inicio());
            stmt.setDate(6,servicio.getFecha_termino()) ;
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
  
  
      public static ArrayList<Servicio> obtenerServiciosGenerales() {
        ArrayList<Servicio> lista = new ArrayList<Servicio>();

        Connection cn;
        Conexion con = new Conexion();
        cn = con.conectar();

        CallableStatement stmt = null;
        ResultSet rs = null;

        try {
            stmt = cn.prepareCall("CALL VISUALIZAR_SERVICIOS_C(?)");
            stmt.registerOutParameter(1, OracleTypes.CURSOR);
            stmt.execute();
            rs = (ResultSet) stmt.getObject(1);

            while (rs.next()) {
                Usuario u = new Usuario(rs.getString("RUT_USUARIO"));
                Servicio s = new Servicio(rs.getInt("ID_SERVICIO"),rs.getInt("FOLIO_CONTRATO"),rs.getString("NOMBRE_SERVICIO"),rs.getInt("VALOR_SERVICIO"),rs.getString("DESCRIPCION_SERVICIO"),rs.getDate("FECHA_INICIO"),rs.getDate("FECHA_TERMINO"),rs.getInt("ESTADO"),rs.getInt("PAGADO"),u);
                lista.add(s);
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
      
      
       public static ArrayList<Servicio> obtenerServiciosXUsuario(String rut_usuario) {
        ArrayList<Servicio> lista = new ArrayList<Servicio>();

        Connection cn;
        Conexion con = new Conexion();
        cn = con.conectar();

        CallableStatement stmt = null;
        ResultSet rs = null;

        try {
            stmt = cn.prepareCall("CALL VISUALIZAR_SERVICIOS_CXID(?,?)");
            stmt.setString(1, rut_usuario);
            stmt.registerOutParameter(2, OracleTypes.CURSOR);
            stmt.execute();
            rs = (ResultSet) stmt.getObject(2);

            while (rs.next()) {
                Usuario u = new Usuario(rs.getString("RUT_USUARIO"));
                Servicio s = new Servicio(rs.getInt("ID_SERVICIO"),rs.getInt("FOLIO_CONTRATO"),rs.getString("NOMBRE_SERVICIO"),rs.getInt("VALOR_SERVICIO"),rs.getString("DESCRIPCION_SERVICIO"),rs.getDate("FECHA_INICIO"),rs.getDate("FECHA_TERMINO"),rs.getInt("ESTADO"),rs.getInt("PAGADO"),u);
                lista.add(s);
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
      
      
       public static boolean ActualizarServicioCU(String rut_usuario, Date fecha,int estado, int pagado) {
        boolean respuesta = false;

        Connection cn;
        Conexion con = new Conexion();
        cn = con.conectar();

        CallableStatement stmt = null;

        try {
            stmt = cn.prepareCall("CALL EDITAR_SERVICIOC_W(?,?,?,?,?)");
            stmt.setString(1, rut_usuario);
            stmt.setDate(2, fecha);
            stmt.setInt(3, estado);
            stmt.setInt(4, pagado);
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
       
       
     public static int BuscarIDContrato(String rut_usuario){
        int resultado = 0;
         
        Connection cn;
        Conexion con = new Conexion();
        cn = con.conectar();

        CallableStatement stmt = null;
        ResultSet rs = null;
         try {
            stmt = cn.prepareCall("CALL BUSCAR_SERVICIOC_XU(?,?)");
            stmt.setString(1, rut_usuario);

            stmt.registerOutParameter(2, OracleTypes.CURSOR);
            stmt.execute();
            rs = (ResultSet) stmt.getObject(2);

            while (rs.next()) {
               resultado = rs.getInt("ID_SERVICIO");  
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
     
     
     
       public static boolean RegistrarServicioCobroEx(String rut_usuario, Servicio servicio) {
        boolean respuesta = false;

        Connection cn;
        Conexion con = new Conexion();
        cn = con.conectar();

        CallableStatement stmt = null;

        try {
            stmt = cn.prepareCall("CALL CREAR_SERVICIO_PEX_W(?,?,?,?,?,?,?)");
            stmt.setString(1, rut_usuario);
            stmt.setString(2,servicio.getNombre_servicio());
            stmt.setInt(3,servicio.getValor_servicio());
            stmt.setString(4,servicio.getDescr_servicio());
            stmt.setDate(5,servicio.getFecha_inicio());
            stmt.setDate(6,servicio.getFecha_termino()) ;
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
       
       
        public static ArrayList<Servicio> obtenerServiciosPxUsuario(String rut_usuario) {
        ArrayList<Servicio> lista = new ArrayList<Servicio>();

        Connection cn;
        Conexion con = new Conexion();
        cn = con.conectar();

        CallableStatement stmt = null;
        ResultSet rs = null;

        try {
            stmt = cn.prepareCall("CALL BUSCAR_PAGOP_XIDU(?,?)");
            stmt.setString(1, rut_usuario);
            stmt.registerOutParameter(2, OracleTypes.CURSOR);
            stmt.execute();
            rs = (ResultSet) stmt.getObject(2);

            while (rs.next()) {
                
                Servicio s = new Servicio(rs.getInt("ID_SERVICIO"),rs.getString("NOMBRE_SERVICIO"),rs.getInt("VALOR_SERVICIO"),rs.getString("DESCRIPCION_SERVICIO"),rs.getDate("FECHA_INICIO"),rs.getDate("FECHA_TERMINO"));
                lista.add(s);
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
        
        
        public static Servicio obtenerServiciosPxIDE(int id_servicio) {
        Servicio servicio = new Servicio();

        Connection cn;
        Conexion con = new Conexion();
        cn = con.conectar();

        CallableStatement stmt = null;
        ResultSet rs = null;

        try {
            stmt = cn.prepareCall("CALL BUSCAR_PAGOP_XIDS(?,?)");
            stmt.setInt(1, id_servicio);
            stmt.registerOutParameter(2, OracleTypes.CURSOR);
            stmt.execute();
            rs = (ResultSet) stmt.getObject(2);

            while (rs.next()) {
                Usuario u = new Usuario(rs.getString("RUT_USUARIO"));
                
                servicio.setId_servicio(rs.getInt("ID_SERVICIO"));
                servicio.setNombre_servicio(rs.getString("NOMBRE_SERVICIO"));
                servicio.setValor_servicio(rs.getInt("VALOR_SERVICIO"));
                servicio.setDescr_servicio(rs.getString("DESCRIPCION_SERVICIO"));
                servicio.setFecha_inicio(rs.getDate("FECHA_INICIO"));
                servicio.setFecha_termino(rs.getDate("FECHA_TERMINO"));
                servicio.setUsuario(u);
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

        return servicio;
    }
  
      public static boolean ActualizarServicioPE(int ids, int est,int pag) {
        boolean respuesta = false;

        Connection cn;
        Conexion con = new Conexion();
        cn = con.conectar();

        CallableStatement stmt = null;

        try {
            stmt = cn.prepareCall("CALL EDITAR_SERVICIOPE_W(?,?,?,?)");
            stmt.setInt(1, ids);
            stmt.setInt(2, est);
            stmt.setInt(3, pag);
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
        
   public static boolean ActualizarEstadoServicio(int estado, int id) {
        boolean respuesta = false;

        Connection cn;
        Conexion con = new Conexion();
        cn = con.conectar();

        CallableStatement stmt = null;

        try {
            stmt = cn.prepareCall("CALL EDITAR_ESTADO_SERVICIO_W(?,?,?)");
            stmt.setInt(1, estado);
            stmt.setInt(2, id);
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
