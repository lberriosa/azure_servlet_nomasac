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
public class Mejora_DB {

    public static boolean RegistrarMejora(String id_usuario, String id_profesional, Actividad actividad, Mejora mejora) {
        boolean respuesta = false;

        Connection cn;
        Conexion con = new Conexion();
        cn = con.conectar();

        CallableStatement stmt = null;

        try {
            stmt = cn.prepareCall("CALL CREAR_MEJORA_W(?,?,?,?,?,?,?,?,?,?,?,?)");
            stmt.setString(1, id_usuario);
            stmt.setString(2, id_profesional);
            stmt.setString(3, actividad.getServicio().getNombre_servicio());
            stmt.setString(4, actividad.getServicio().getDescr_servicio());
            stmt.setInt(5, actividad.getServicio().getValor_servicio());
            stmt.setString(6, actividad.getNombre_actividad());
            stmt.setString(7, actividad.getDescr_actividad());
            stmt.setString(8, mejora.getNomb_mejora());
            stmt.setString(9, mejora.getDesc_mejora());
            stmt.setString(10, mejora.getArch_mejora());
            stmt.setDate(11, mejora.getFecha_inicio());
            stmt.registerOutParameter(12, java.sql.Types.VARCHAR);
            stmt.executeUpdate();

            //read the OUT parameter now
            String result = stmt.getString(12);

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

    public static ArrayList<Mejora> obtenerMejorasProf() {
        ArrayList<Mejora> lista = new ArrayList<Mejora>();

        Connection cn;
        Conexion con = new Conexion();
        cn = con.conectar();

        CallableStatement stmt = null;
        ResultSet rs = null;

        try {
            stmt = cn.prepareCall("CALL BUSCAR_MEJORAS_PROFES(?)");
            stmt.registerOutParameter(1, OracleTypes.CURSOR);
            stmt.execute();
            rs = (ResultSet) stmt.getObject(1);

            while (rs.next()) {
                Usuario u = new Usuario();
                u.setRut_usuario(rs.getString("RUT_USUARIO"));

                Servicio s = new Servicio();
                s.setId_servicio(rs.getInt("ID_SERVICIO"));

                Actividad a = new Actividad();
                a.setId_actividad(rs.getInt("ID_ACTIVIDAD"));
                a.setServicio(s);

                Aprobar ap = new Aprobar();
                ap.setId_aprobacion(rs.getInt("ID_APROBACION"));
                ap.setEstado_aprobacion(rs.getInt("ESTADO_APROBACION"));
                ap.setFecha_aprobacion(rs.getDate("FECHA_APROBACION"));

                Mejora m = new Mejora();
                m.setId_mejora(rs.getInt("ID_MEJORA"));
                m.setDesc_mejora(rs.getString("DESCRIPCION_MEJORA"));
                m.setNomb_mejora(rs.getString("NOMBRE_MEJORA"));
                m.setEstado_mejora(rs.getInt("ESTADO_MEJORA"));
                m.setArch_mejora(rs.getString("ARCHIVO"));
                m.setFecha_inicio(rs.getDate("FECHA_INICIO"));
                m.setUsuario(u);
                m.setActividad(a);
                m.setAprobar(ap);

                lista.add(m);
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

    public static Mejora obtenerMejoraxIDE(int id_mejora) {
        Mejora m = new Mejora();

        Connection cn;
        Conexion con = new Conexion();
        cn = con.conectar();

        CallableStatement stmt = null;
        ResultSet rs = null;

        try {
            stmt = cn.prepareCall("CALL BUSCAR_MEJORAS_PROFXID(?,?)");
            stmt.setInt(1, id_mejora);
            stmt.registerOutParameter(2, OracleTypes.CURSOR);
            stmt.execute();
            rs = (ResultSet) stmt.getObject(2);

            while (rs.next()) {
                Usuario u = new Usuario();
                u.setRut_usuario(rs.getString("RUT_USUARIO"));

                Servicio s = new Servicio();
                s.setId_servicio(rs.getInt("ID_SERVICIO"));

                Actividad a = new Actividad();
                a.setId_actividad(rs.getInt("ID_ACTIVIDAD"));
                a.setServicio(s);

                Aprobar ap = new Aprobar();
                ap.setId_aprobacion(rs.getInt("ID_APROBACION"));

                m.setId_mejora(rs.getInt("ID_MEJORA"));
                m.setDesc_mejora(rs.getString("DESCRIPCION_MEJORA"));
                m.setNomb_mejora(rs.getString("NOMBRE_MEJORA"));
                m.setArch_mejora(rs.getString("ARCHIVO"));
                m.setFecha_inicio(rs.getDate("FECHA_INICIO"));
                m.setUsuario(u);
                m.setActividad(a);
                m.setAprobar(ap);
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

        return m;
    }

    public static boolean CancelarMejora(int ida, int estadoa, int ids, int estados, int idm,
            int estadom, Date fecha) {
        boolean respuesta = false;
        Connection cn;
        Conexion con = new Conexion();
        cn = con.conectar();

        CallableStatement stmt = null;

        try {
            stmt = cn.prepareCall("CALL EDITAR_MEJORA_CANCEL_W(?,?,?,?,?,?,?,?)");
            stmt.setInt(1, ida);
            stmt.setInt(2, estadoa);
            stmt.setInt(3, ids);
            stmt.setInt(4, estados);
            stmt.setInt(5, idm);
            stmt.setInt(6, estadom);
            stmt.setDate(7, fecha);
            stmt.registerOutParameter(8, java.sql.Types.VARCHAR);
            stmt.executeUpdate();

            //read the OUT parameter now
            String result = stmt.getString(8);

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

    public static boolean AprobarMejora(int ida, int estadoa,
            int idap, int estadoap, String user_p,
            int idm, int estadom, Date fecha) {
        boolean respuesta = false;
        Connection cn;
        Conexion con = new Conexion();
        cn = con.conectar();

        CallableStatement stmt = null;

        try {
            stmt = cn.prepareCall("CALL EDITAR_MEJORA_APROBAR_W(?,?,?,?,?,?,?,?,?)");
            stmt.setInt(1, ida);
            stmt.setInt(2, estadoa);
            stmt.setInt(3, idap);
            stmt.setInt(4, estadoap);
            stmt.setString(5, user_p);
            stmt.setInt(6, idm);
            stmt.setInt(7, estadom);
            stmt.setDate(8, fecha);
            stmt.registerOutParameter(9, java.sql.Types.VARCHAR);
            stmt.executeUpdate();

            //read the OUT parameter now
            String result = stmt.getString(9);

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

    public static ArrayList<Mejora> obtenerMejorasXCliente(String rut_usuario) {
        ArrayList<Mejora> lista = new ArrayList<Mejora>();

        Connection cn;
        Conexion con = new Conexion();
        cn = con.conectar();

        CallableStatement stmt = null;
        ResultSet rs = null;

        try {
            stmt = cn.prepareCall("CALL BUSCAR_MEJORAS_XRUT(?,?)");
            stmt.setString(1, rut_usuario);
            stmt.registerOutParameter(2, OracleTypes.CURSOR);
            stmt.execute();
            rs = (ResultSet) stmt.getObject(2);

            while (rs.next()) {
                Usuario u = new Usuario();
                u.setRut_usuario(rs.getString("RUT_USUARIO"));

                Aprobar ap = new Aprobar();
                ap.setEstado_aprobacion(rs.getInt("ESTADO_APROBACION"));
                ap.setFecha_aprobacion(rs.getDate("FECHA_APROBACION"));

                Mejora m = new Mejora();
                m.setDesc_mejora(rs.getString("DESCRIPCION_MEJORA"));
                m.setNomb_mejora(rs.getString("NOMBRE_MEJORA"));
                m.setEstado_mejora(rs.getInt("ESTADO_MEJORA"));
                m.setArch_mejora(rs.getString("ARCHIVO"));
                m.setFecha_inicio(rs.getDate("FECHA_INICIO"));
                m.setUsuario(u);
                m.setAprobar(ap);

                lista.add(m);
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

    public static ArrayList<Mejora> obtenerMejorasAdmin() {
        ArrayList<Mejora> lista = new ArrayList<Mejora>();

        Connection cn;
        Conexion con = new Conexion();
        cn = con.conectar();

        CallableStatement stmt = null;
        ResultSet rs = null;

        try {
            stmt = cn.prepareCall("CALL BUSCAR_MEJORAS_ADMIN(?)");
            stmt.registerOutParameter(1, OracleTypes.CURSOR);
            stmt.execute();
            rs = (ResultSet) stmt.getObject(1);

            while (rs.next()) {
                Usuario u = new Usuario();
                u.setRut_usuario(rs.getString("RUT_USUARIO"));

                Aprobar ap = new Aprobar();
                ap.setEstado_aprobacion(rs.getInt("ESTADO_APROBACION"));
                ap.setFecha_aprobacion(rs.getDate("FECHA_APROBACION"));

                Mejora m = new Mejora();
                m.setDesc_mejora(rs.getString("DESCRIPCION_MEJORA"));
                m.setNomb_mejora(rs.getString("NOMBRE_MEJORA"));
                m.setEstado_mejora(rs.getInt("ESTADO_MEJORA"));
                m.setArch_mejora(rs.getString("ARCHIVO"));
                m.setFecha_inicio(rs.getDate("FECHA_INICIO"));
                m.setUsuario(u);
                m.setAprobar(ap);

                lista.add(m);
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
