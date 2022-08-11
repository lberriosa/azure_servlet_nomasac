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
public class Actividad_DB {

    public static boolean RegistrarVisita(String rut_usuario, Actividad actividad) {
        boolean respuesta = false;
        Connection cn;
        Conexion con = new Conexion();
        cn = con.conectar();

        CallableStatement stmt = null;

        try {
            stmt = cn.prepareCall("CALL CREAR_ACTIVIDAD_COMPLETA_W(?,?,?,?,?,?,?,?,?,?)");
            stmt.setString(1, rut_usuario);
            stmt.setString(2, actividad.getServicio().getNombre_servicio());
            stmt.setInt(3, actividad.getServicio().getValor_servicio());
            stmt.setString(4, actividad.getServicio().getDescr_servicio());
            stmt.setString(5, actividad.getNombre_actividad());
            stmt.setString(6, actividad.getDescr_actividad());
            stmt.setString(7, actividad.getPago().getDescripcion());
            stmt.setDate(8, actividad.getFecha_inicio());
            stmt.setDate(9, actividad.getFecha_termino());
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

    public static int BuscarVisitaxUsuarioF(String rut_usuario, Actividad actividad) {
        int resultado = 0;

        Connection cn;
        Conexion con = new Conexion();
        cn = con.conectar();

        CallableStatement stmt = null;
        ResultSet rs = null;
        try {
            stmt = cn.prepareCall("CALL BUSCAR_VISITA_XUF(?,?,?)");
            stmt.setString(1, rut_usuario);
            stmt.setDate(2, actividad.getFecha_inicio());

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

    public static int BuscarVisitaxUsuarioM(String rut_usuario, Actividad actividad) {
        int resultado = 0;

        Connection cn;
        Conexion con = new Conexion();
        cn = con.conectar();

        CallableStatement stmt = null;
        ResultSet rs = null;
        try {
            stmt = cn.prepareCall("CALL BUSCAR_VISITA_XUM(?,?,?)");
            stmt.setString(1, rut_usuario);
            stmt.setDate(2, actividad.getFecha_inicio());

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

    public static ArrayList<Actividad> obtenerVisitas() {
        ArrayList<Actividad> lista = new ArrayList<Actividad>();

        Connection cn;
        Conexion con = new Conexion();
        cn = con.conectar();

        CallableStatement stmt = null;
        ResultSet rs = null;

        try {
            stmt = cn.prepareCall("CALL BUSCAR_VISITA(?)");

            stmt.registerOutParameter(1, OracleTypes.CURSOR);
            stmt.execute();
            rs = (ResultSet) stmt.getObject(1);

            while (rs.next()) {
                Usuario u = new Usuario(rs.getString("RUT_USUARIO"));
                Servicio s = new Servicio(rs.getInt("ID_SERVICIO"), rs.getInt("ESTADO_S"), rs.getInt("PAGADO"), u);
                Actividad a = new Actividad(rs.getInt("ID_ACTIVIDAD"), rs.getString("NOMBRE_ACTIVIDAD"), rs.getString("DESCRIPCION_ACTIVIDAD"), rs.getInt("ESTADO_A"), rs.getDate("FECHA_INICIO"), rs.getDate("FECHA_TERMINO"), s);
                lista.add(a);
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

    public static ArrayList<Actividad> obtenerVisitasCliente(String rut_usuario) {
        ArrayList<Actividad> lista = new ArrayList<Actividad>();

        Connection cn;
        Conexion con = new Conexion();
        cn = con.conectar();

        CallableStatement stmt = null;
        ResultSet rs = null;

        try {
            stmt = cn.prepareCall("CALL BUSCAR_VISITA_XRUT(?,?)");
            stmt.setString(1, rut_usuario);
            stmt.registerOutParameter(2, OracleTypes.CURSOR);
            stmt.execute();
            rs = (ResultSet) stmt.getObject(2);

            while (rs.next()) {
                Usuario u = new Usuario(rs.getString("RUT_USUARIO"));
                Servicio s = new Servicio(rs.getInt("ID_SERVICIO"), rs.getInt("ESTADO_S"), rs.getInt("PAGADO"), u);
                Actividad a = new Actividad(rs.getInt("ID_ACTIVIDAD"), rs.getString("NOMBRE_ACTIVIDAD"), rs.getString("DESCRIPCION_ACTIVIDAD"), rs.getInt("ESTADO_A"), rs.getDate("FECHA_INICIO"), rs.getDate("FECHA_TERMINO"), s);
                lista.add(a);
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

    public static Actividad BuscarActividad(int id) {
        Actividad actividad = new Actividad();

        Connection cn;
        Conexion con = new Conexion();
        cn = con.conectar();

        CallableStatement stmt = null;
        ResultSet rs = null;

        try {
            stmt = cn.prepareCall("CALL BUSCAR_VISITA_XIDA(?,?)");
            stmt.setInt(1, id);

            stmt.registerOutParameter(2, OracleTypes.CURSOR);
            stmt.execute();
            rs = (ResultSet) stmt.getObject(2);

            while (rs.next()) {
                Usuario u = new Usuario(rs.getString("RUT_USUARIO"));
                Servicio s = new Servicio(rs.getInt("ID_SERVICIO"), rs.getInt("ESTADO_S"), rs.getInt("PAGADO"), u);
                actividad.setId_actividad(rs.getInt("ID_ACTIVIDAD"));
                actividad.setNombre_actividad(rs.getString("NOMBRE_ACTIVIDAD"));
                actividad.setDescr_actividad(rs.getString("DESCRIPCION_ACTIVIDAD"));
                actividad.setEstado(rs.getInt("ESTADO_A"));
                actividad.setFecha_inicio(rs.getDate("FECHA_INICIO"));
                actividad.setFecha_termino(rs.getDate("FECHA_TERMINO"));
                actividad.setServicio(s);
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
        return actividad;
    }

    public static boolean CancelarVisita(int ea, int ida, int es, int ids) {
        boolean respuesta = false;

        Connection cn;
        Conexion con = new Conexion();
        cn = con.conectar();

        CallableStatement stmt = null;

        try {
            stmt = cn.prepareCall("CALL EDITAR_CANCELAR_VISITA_W(?,?,?,?,?)");
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

    public static int BuscarVisitasReproXA(String rut_usuario, Actividad actividad) {
        int resultado = 0;

        Connection cn;
        Conexion con = new Conexion();
        cn = con.conectar();

        CallableStatement stmt = null;
        ResultSet rs = null;
        try {
            stmt = cn.prepareCall("CALL BUSCAR_RCVISITA_XA(?,?,?)");
            stmt.setString(1, rut_usuario);
            stmt.setDate(2, actividad.getFecha_inicio());

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

    public static boolean EditarVisitaF(int ida, int ids, int es, Date fecha) {
        boolean respuesta = false;

        Connection cn;
        Conexion con = new Conexion();
        cn = con.conectar();

        CallableStatement stmt = null;

        try {
            stmt = cn.prepareCall("CALL EDITAR_FECHA_VISITA_W(?,?,?,?,?)");
            stmt.setInt(1, ida);
            stmt.setInt(2, ids);
            stmt.setInt(3, es);
            stmt.setDate(4, fecha);
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

    public static boolean EditarEstadoA(int es, int ida) {
        boolean respuesta = false;

        Connection cn;
        Conexion con = new Conexion();
        cn = con.conectar();

        CallableStatement stmt = null;

        try {
            stmt = cn.prepareCall("CALL EDITAR_ESTADO_ACTIVID_W(?,?,?)");
            stmt.setInt(1, es);
            stmt.setInt(2, ida);
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

    public static boolean FinalizarVisita(int ea, int ida) {
        boolean respuesta = false;

        Connection cn;
        Conexion con = new Conexion();
        cn = con.conectar();

        CallableStatement stmt = null;

        try {
            stmt = cn.prepareCall("CALL EDITAR_FIN_VISITA_W(?,?,?)");
            stmt.setInt(1, ea);
            stmt.setInt(2, ida);
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

    public static boolean IngresarVisitaAlerta(Date fecha, int id_acti, String descripcion) {
        boolean respuesta = false;

        Connection cn;
        Conexion con = new Conexion();
        cn = con.conectar();

        CallableStatement stmt = null;

        try {
            stmt = cn.prepareCall("CALL EDITAR_ACTIVIDAD_ALVI_W(?,?,?,?)");
            stmt.setInt(1, id_acti);
            stmt.setDate(2, fecha);
            stmt.setString(3, descripcion);
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

    public static boolean RegistrarActividad(String rut_usuario, Actividad actividad) {
        boolean respuesta = false;
        Connection cn;
        Conexion con = new Conexion();
        cn = con.conectar();

        CallableStatement stmt = null;

        try {
            stmt = cn.prepareCall("CALL CREAR_ACTIVIDAD_COMPLETA_W(?,?,?,?,?,?,?,?,?,?)");
            stmt.setString(1, rut_usuario);
            stmt.setString(2, actividad.getServicio().getNombre_servicio());
            stmt.setInt(3, actividad.getServicio().getValor_servicio());
            stmt.setString(4, actividad.getServicio().getDescr_servicio());
            stmt.setString(5, actividad.getNombre_actividad());
            stmt.setString(6, actividad.getDescr_actividad());
            stmt.setString(7, actividad.getPago().getDescripcion());
            stmt.setDate(8, actividad.getFecha_inicio());
            stmt.setDate(9, actividad.getFecha_termino());
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

    public static boolean RegistrarActividadCh(String rut_usuario, String rut_profesional, Actividad actividad) {
        boolean respuesta = false;
        Connection cn;
        Conexion con = new Conexion();
        cn = con.conectar();

        CallableStatement stmt = null;

        try {
            stmt = cn.prepareCall("CALL CREAR_ACTIVIDAD_CCHAT_W(?,?,?,?,?,?,?,?,?,?,?)");
            stmt.setString(1, rut_usuario);
            stmt.setString(2, actividad.getServicio().getNombre_servicio());
            stmt.setInt(3, actividad.getServicio().getValor_servicio());
            stmt.setString(4, actividad.getServicio().getDescr_servicio());
            stmt.setString(5, actividad.getNombre_actividad());
            stmt.setString(6, actividad.getDescr_actividad());
            stmt.setString(7, actividad.getPago().getDescripcion());
            stmt.setDate(8, actividad.getFecha_inicio());
            stmt.setDate(9, actividad.getFecha_termino());
            stmt.setString(10, rut_profesional);
            stmt.registerOutParameter(11, java.sql.Types.VARCHAR);
            stmt.executeUpdate();

            //read the OUT parameter now
            String result = stmt.getString(11);

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

    public static boolean RegistrarCapacitacion(String rut_usuario, Actividad actividad) {
        boolean respuesta = false;
        Connection cn;
        Conexion con = new Conexion();
        cn = con.conectar();

        CallableStatement stmt = null;

        try {
            stmt = cn.prepareCall("CALL CREAR_ACTIVIDAD_COMPLETA_W(?,?,?,?,?,?,?,?,?,?)");
            stmt.setString(1, rut_usuario);
            stmt.setString(2, actividad.getServicio().getNombre_servicio());
            stmt.setInt(3, actividad.getServicio().getValor_servicio());
            stmt.setString(4, actividad.getServicio().getDescr_servicio());
            stmt.setString(5, actividad.getNombre_actividad());
            stmt.setString(6, actividad.getDescr_actividad());
            stmt.setString(7, actividad.getPago().getDescripcion());
            stmt.setDate(8, actividad.getFecha_inicio());
            stmt.setDate(9, actividad.getFecha_termino());
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

    public static int BuscarCapacitacionesXM(String rut_usuario, Actividad actividad) {
        int resultado = 0;

        Connection cn;
        Conexion con = new Conexion();
        cn = con.conectar();

        CallableStatement stmt = null;
        ResultSet rs = null;
        try {
            stmt = cn.prepareCall("CALL BUSCAR_CAPACIAID_XA(?,?,?)");
            stmt.setString(1, rut_usuario);
            stmt.setDate(2, actividad.getFecha_inicio());

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

    public static int BuscarActividadesXFID(String rut_usuario, Date fecha) {
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

    public static ArrayList<Actividad> obtenerCapacitaciones() {
        ArrayList<Actividad> lista = new ArrayList<Actividad>();

        Connection cn;
        Conexion con = new Conexion();
        cn = con.conectar();

        CallableStatement stmt = null;
        ResultSet rs = null;

        try {
            stmt = cn.prepareCall("CALL BUSCAR_CAPACITACION(?)");

            stmt.registerOutParameter(1, OracleTypes.CURSOR);
            stmt.execute();
            rs = (ResultSet) stmt.getObject(1);

            while (rs.next()) {
                Usuario u = new Usuario(rs.getString("RUT_USUARIO"));
                Servicio s = new Servicio(rs.getInt("ID_SERVICIO"), rs.getInt("ESTADO_S"), rs.getInt("PAGADO"), u);
                Actividad a = new Actividad(rs.getInt("ID_ACTIVIDAD"), rs.getString("NOMBRE_ACTIVIDAD"), rs.getString("DESCRIPCION_ACTIVIDAD"), rs.getInt("ESTADO_A"), rs.getDate("FECHA_INICIO"), rs.getDate("FECHA_TERMINO"), s);
                lista.add(a);
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

    public static Actividad BuscarActividadC(int id) {
        Actividad actividad = new Actividad();

        Connection cn;
        Conexion con = new Conexion();
        cn = con.conectar();

        CallableStatement stmt = null;
        ResultSet rs = null;

        try {
            stmt = cn.prepareCall("CALL BUSCAR_CAPACITA_XIDA(?,?)");
            stmt.setInt(1, id);

            stmt.registerOutParameter(2, OracleTypes.CURSOR);
            stmt.execute();
            rs = (ResultSet) stmt.getObject(2);

            while (rs.next()) {
                Usuario u = new Usuario(rs.getString("RUT_USUARIO"));
                Servicio s = new Servicio(rs.getInt("ID_SERVICIO"), rs.getInt("ESTADO_S"), rs.getInt("PAGADO"), u);
                actividad.setId_actividad(rs.getInt("ID_ACTIVIDAD"));
                actividad.setNombre_actividad(rs.getString("NOMBRE_ACTIVIDAD"));
                actividad.setDescr_actividad(rs.getString("DESCRIPCION_ACTIVIDAD"));
                actividad.setEstado(rs.getInt("ESTADO_A"));
                actividad.setFecha_inicio(rs.getDate("FECHA_INICIO"));
                actividad.setFecha_termino(rs.getDate("FECHA_TERMINO"));
                actividad.setServicio(s);
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
        return actividad;
    }

    public static ArrayList<Actividad> obtenerCapacitaCliente(String rut_usuario) {
        ArrayList<Actividad> lista = new ArrayList<Actividad>();

        Connection cn;
        Conexion con = new Conexion();
        cn = con.conectar();

        CallableStatement stmt = null;
        ResultSet rs = null;

        try {
            stmt = cn.prepareCall("CALL BUSCAR_CAPACITA_XRUT(?,?)");
            stmt.setString(1, rut_usuario);
            stmt.registerOutParameter(2, OracleTypes.CURSOR);
            stmt.execute();
            rs = (ResultSet) stmt.getObject(2);

            while (rs.next()) {
                Usuario u = new Usuario(rs.getString("RUT_USUARIO"));
                Servicio s = new Servicio(rs.getInt("ID_SERVICIO"), rs.getInt("ESTADO_S"), rs.getInt("PAGADO"), u);
                Actividad a = new Actividad(rs.getInt("ID_ACTIVIDAD"), rs.getString("NOMBRE_ACTIVIDAD"), rs.getString("DESCRIPCION_ACTIVIDAD"), rs.getInt("ESTADO_A"), rs.getDate("FECHA_INICIO"), rs.getDate("FECHA_TERMINO"), s);
                lista.add(a);
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
    
    
    public static boolean CancelarCapaci(int ea, int ida, int es, int ids) {
        boolean respuesta = false;

        Connection cn;
        Conexion con = new Conexion();
        cn = con.conectar();

        CallableStatement stmt = null;

        try {
            stmt = cn.prepareCall("CALL EDITAR_CANCELAR_CAPACITA_W(?,?,?,?,?)");
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

}
