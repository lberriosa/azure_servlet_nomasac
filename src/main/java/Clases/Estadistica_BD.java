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
public class Estadistica_BD {
    //ESTADISTICA ADMINISTRADOR
    //cantidad total de actividaddes x mes
     public static ArrayList<Estadistica> cantidadActividadesT() {
        ArrayList<Estadistica> lista = new ArrayList<Estadistica>();

        Connection cn;
        Conexion con = new Conexion();
        cn = con.conectar();

        CallableStatement stmt = null;
        ResultSet rs = null;

        try {
            stmt = cn.prepareCall("CALL CANTIDAD_ACTIVIDAD_XM(?)");

            stmt.registerOutParameter(1, OracleTypes.CURSOR);
            stmt.execute();
            rs = (ResultSet) stmt.getObject(1);

            while (rs.next()) {
                Estadistica es = new Estadistica();
                es.setCantidad(rs.getInt("CONTADOR"));
                es.setMes(rs.getString("NOMBRE_MES"));
                lista.add(es);
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
     // TOTAL DE VISITAS
     public static int t_Visitas_Adm() {
        int resultado = 0;

        Connection cn;
        Conexion con = new Conexion();
        cn = con.conectar();

        CallableStatement stmt = null;
        ResultSet rs = null;
        try {
            stmt = cn.prepareCall("CALL ESTA_TOTAL_VISITAS_ADM(?)");

            stmt.registerOutParameter(1, OracleTypes.CURSOR);
            stmt.execute();
            rs = (ResultSet) stmt.getObject(1);

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
     
     
    // TOTAL DE CAPACITACIONES
     
     public static int t_Capaci_Adm() {
        int resultado = 0;

        Connection cn;
        Conexion con = new Conexion();
        cn = con.conectar();

        CallableStatement stmt = null;
        ResultSet rs = null;
        try {
            stmt = cn.prepareCall("CALL ESTA_TOTAL_CAPACI_ADM(?)");

            stmt.registerOutParameter(1, OracleTypes.CURSOR);
            stmt.execute();
            rs = (ResultSet) stmt.getObject(1);

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
     
     // TOTAL DE ALERTAS
    
        public static int t_Alertas_Adm() {
        int resultado = 0;

        Connection cn;
        Conexion con = new Conexion();
        cn = con.conectar();

        CallableStatement stmt = null;
        ResultSet rs = null;
        try {
            stmt = cn.prepareCall("CALL ESTA_TOTAL_ALERT_ADM(?)");

            stmt.registerOutParameter(1, OracleTypes.CURSOR);
            stmt.execute();
            rs = (ResultSet) stmt.getObject(1);

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
        
     // TOTAL DE ASISTENCIAS 
        
         public static int t_Asistencia_Adm() {
        int resultado = 0;

        Connection cn;
        Conexion con = new Conexion();
        cn = con.conectar();

        CallableStatement stmt = null;
        ResultSet rs = null;
        try {
            stmt = cn.prepareCall("CALL ESTA_TOTAL_ASIS_ADM(?)");

            stmt.registerOutParameter(1, OracleTypes.CURSOR);
            stmt.execute();
            rs = (ResultSet) stmt.getObject(1);

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
         
         
     // TOTAL DE USUARIOS ACTIVOS
      public static int t_Usuactivos_Adm() {
        int resultado = 0;

        Connection cn;
        Conexion con = new Conexion();
        cn = con.conectar();

        CallableStatement stmt = null;
        ResultSet rs = null;
        try {
            stmt = cn.prepareCall("CALL ESTA_TOTAL_USUA_ADM(?)");

            stmt.registerOutParameter(1, OracleTypes.CURSOR);
            stmt.execute();
            rs = (ResultSet) stmt.getObject(1);

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
         
         
    // TOTAL DE CONTRATOS CREADOS X MES     
     public static ArrayList<Estadistica> totalContratosM_Adm() {
        ArrayList<Estadistica> lista = new ArrayList<Estadistica>();

        Connection cn;
        Conexion con = new Conexion();
        cn = con.conectar();

        CallableStatement stmt = null;
        ResultSet rs = null;

        try {
            stmt = cn.prepareCall("CALL ESTA_TOTAL_CCREA_ADM(?)");

            stmt.registerOutParameter(1, OracleTypes.CURSOR);
            stmt.execute();
            rs = (ResultSet) stmt.getObject(1);

            while (rs.next()) {
                Estadistica es = new Estadistica();
                es.setCantidad(rs.getInt("CONTADOR"));
                es.setMes(rs.getString("NOMBRE_MES"));
                lista.add(es);
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
     
     //TOTAL DE PAGOS
     
       public static int t_Pagos_Adm() {
        int resultado = 0;

        Connection cn;
        Conexion con = new Conexion();
        cn = con.conectar();

        CallableStatement stmt = null;
        ResultSet rs = null;
        try {
            stmt = cn.prepareCall("CALL ESTA_TOTAL_PAGOS_ADM(?)");

            stmt.registerOutParameter(1, OracleTypes.CURSOR);
            stmt.execute();
            rs = (ResultSet) stmt.getObject(1);

            while (rs.next()) {
                resultado = rs.getInt("TOTAL_PAGO");
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
       
       
     //PAGOS X MES
       public static ArrayList<Estadistica> totalPagosxM_Adm() {
        ArrayList<Estadistica> lista = new ArrayList<Estadistica>();

        Connection cn;
        Conexion con = new Conexion();
        cn = con.conectar();

        CallableStatement stmt = null;
        ResultSet rs = null;

        try {
            stmt = cn.prepareCall("CALL ESTA_TOTAL_PXMES_ADM(?)");

            stmt.registerOutParameter(1, OracleTypes.CURSOR);
            stmt.execute();
            rs = (ResultSet) stmt.getObject(1);

            while (rs.next()) {
                Estadistica es = new Estadistica();
                es.setCantidad(rs.getInt("PAGOS_R"));
                es.setMes(rs.getString("NOMBRE_MES"));
                lista.add(es);
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
      
       
     //TOTAL X MES ASISTENCIAS Y CHATS -- RENDIMIENTO LABORAL 
       public static ArrayList<Estadistica> totalRendimiento_Adm() {
        ArrayList<Estadistica> lista = new ArrayList<Estadistica>();

        Connection cn;
        Conexion con = new Conexion();
        cn = con.conectar();

        CallableStatement stmt = null;
        ResultSet rs = null;

        try {
            stmt = cn.prepareCall("CALL ESTA_RENDIM_LAB_ADM(?)");

            stmt.registerOutParameter(1, OracleTypes.CURSOR);
            stmt.execute();
            rs = (ResultSet) stmt.getObject(1);

            while (rs.next()) {
                Estadistica es = new Estadistica();
                es.setCantidad(rs.getInt("RENDIMIENTO_CANT"));
                es.setMes(rs.getString("NOMBRE_MES"));
                lista.add(es);
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
       
     //TOTAL DE MEJORAS
        public static int t_Mejoras_Adm() {
        int resultado = 0;

        Connection cn;
        Conexion con = new Conexion();
        cn = con.conectar();

        CallableStatement stmt = null;
        ResultSet rs = null;
        try {
            stmt = cn.prepareCall("CALL ESTA_TOTAL_MEJORS_ADM(?)");

            stmt.registerOutParameter(1, OracleTypes.CURSOR);
            stmt.execute();
            rs = (ResultSet) stmt.getObject(1);

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
        
     //TOTAL DE PROFESIONALES
     public static int t_Profes_Adm() {
        int resultado = 0;

        Connection cn;
        Conexion con = new Conexion();
        cn = con.conectar();

        CallableStatement stmt = null;
        ResultSet rs = null;
        try {
            stmt = cn.prepareCall("CALL ESTA_TOTAL_PROF_ADM(?)");

            stmt.registerOutParameter(1, OracleTypes.CURSOR);
            stmt.execute();
            rs = (ResultSet) stmt.getObject(1);

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
        
     //TOTAL DE INASISTENCIAS 
      public static int t_Inasis_Adm() {
        int resultado = 0;

        Connection cn;
        Conexion con = new Conexion();
        cn = con.conectar();

        CallableStatement stmt = null;
        ResultSet rs = null;
        try {
            stmt = cn.prepareCall("CALL ESTA_TOTAL_INAS_ADM(?)");

            stmt.registerOutParameter(1, OracleTypes.CURSOR);
            stmt.execute();
            rs = (ResultSet) stmt.getObject(1);

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
     
     //TOTAL DE ACTIVIDADES GENERADAS 
     public static int t_Activi_Adm() {
        int resultado = 0;

        Connection cn;
        Conexion con = new Conexion();
        cn = con.conectar();

        CallableStatement stmt = null;
        ResultSet rs = null;
        try {
            stmt = cn.prepareCall("CALL ESTA_TOTAL_ACT_ADM(?)");

            stmt.registerOutParameter(1, OracleTypes.CURSOR);
            stmt.execute();
            rs = (ResultSet) stmt.getObject(1);

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
     //END ESTADISTICA ADMINISTRADOR 
     
     
    //ESTADISTICA CLIENTE 
     //TOTAL ACTIVIDAD X MES X RUT
     public static ArrayList<Estadistica> totalActividad_Cli(String id) {
        ArrayList<Estadistica> lista = new ArrayList<Estadistica>();

        Connection cn;
        Conexion con = new Conexion();
        cn = con.conectar();

        CallableStatement stmt = null;
        ResultSet rs = null;

        try {
            stmt = cn.prepareCall("CALL ESTA_T_ACTXM_CLI(?,?)");
            stmt.setString(1, id);
            stmt.registerOutParameter(2, OracleTypes.CURSOR);
            stmt.execute();
            rs = (ResultSet) stmt.getObject(2);

            while (rs.next()) {
                Estadistica es = new Estadistica();
                es.setCantidad(rs.getInt("CONTADOR"));
                es.setMes(rs.getString("NOMBRE_MES"));
                lista.add(es);
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
     
  
     //TOTAL VISITAS X RUT 
      public static int t_Visit_Cli(String id) {
        int resultado = 0;

        Connection cn;
        Conexion con = new Conexion();
        cn = con.conectar();

        CallableStatement stmt = null;
        ResultSet rs = null;
        try {
            stmt = cn.prepareCall("CALL ESTA_T_VISIT_CLI(?,?)");
            stmt.setString(1, id);
            stmt.registerOutParameter(2, OracleTypes.CURSOR);
            stmt.execute();
            rs = (ResultSet) stmt.getObject(2);

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
     
 
     //TOTAL CAPACITACIONES X RUT
      public static int t_Capaci_Cli(String id) {
        int resultado = 0;

        Connection cn;
        Conexion con = new Conexion();
        cn = con.conectar();

        CallableStatement stmt = null;
        ResultSet rs = null;
        try {
            stmt = cn.prepareCall("CALL ESTA_T_CAPACI_CLI(?,?)");
            stmt.setString(1, id);
            stmt.registerOutParameter(2, OracleTypes.CURSOR);
            stmt.execute();
            rs = (ResultSet) stmt.getObject(2);

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
      
     //TOTAL ALERTAS X RUT
     public static int t_Alert_Cli(String id) {
        int resultado = 0;

        Connection cn;
        Conexion con = new Conexion();
        cn = con.conectar();

        CallableStatement stmt = null;
        ResultSet rs = null;
        try {
            stmt = cn.prepareCall("CALL ESTA_T_ALERT_CLI(?,?)");
            stmt.setString(1, id);
            stmt.registerOutParameter(2, OracleTypes.CURSOR);
            stmt.execute();
            rs = (ResultSet) stmt.getObject(2);

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
 
     //TOTAL ASISTENCIA A TERRENO X RUT
      public static int t_Asis_Cli(String id) {
        int resultado = 0;

        Connection cn;
        Conexion con = new Conexion();
        cn = con.conectar();

        CallableStatement stmt = null;
        ResultSet rs = null;
        try {
            stmt = cn.prepareCall("CALL ESTA_T_ASISTE_CLI(?,?)");
            stmt.setString(1, id);
            stmt.registerOutParameter(2, OracleTypes.CURSOR);
            stmt.execute();
            rs = (ResultSet) stmt.getObject(2);

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
     
     //TOTAL DE PROFESIONALES ACTIVOS
       public static int t_Prof_Cli() {
        int resultado = 0;

        Connection cn;
        Conexion con = new Conexion();
        cn = con.conectar();

        CallableStatement stmt = null;
        ResultSet rs = null;
        try {
            stmt = cn.prepareCall("CALL ESTA_T_PROA_CLI(?)");
            stmt.registerOutParameter(1, OracleTypes.CURSOR);
            stmt.execute();
            rs = (ResultSet) stmt.getObject(1);

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
      

     //ACTIVIDADES X MES RESUELTAS
       public static ArrayList<Estadistica> totalActivXmes_Cli(String id) {
        ArrayList<Estadistica> lista = new ArrayList<Estadistica>();

        Connection cn;
        Conexion con = new Conexion();
        cn = con.conectar();

        CallableStatement stmt = null;
        ResultSet rs = null;

        try {
            stmt = cn.prepareCall("CALL ESTA_T_ACXMES_CLI(?,?)");
            stmt.setString(1, id);
            stmt.registerOutParameter(2, OracleTypes.CURSOR);
            stmt.execute();
            rs = (ResultSet) stmt.getObject(2);

            while (rs.next()) {
                Estadistica es = new Estadistica();
                es.setCantidad(rs.getInt("CONTADOR"));
                es.setMes(rs.getString("NOMBRE_MES"));
                lista.add(es);
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
       
     //PAGOS X MES X RUT
        public static ArrayList<Estadistica> totalPagosXmes_Cli(String id) {
        ArrayList<Estadistica> lista = new ArrayList<Estadistica>();

        Connection cn;
        Conexion con = new Conexion();
        cn = con.conectar();

        CallableStatement stmt = null;
        ResultSet rs = null;

        try {
            stmt = cn.prepareCall("CALL ESTA_P_XMES_CLI(?,?)");
            stmt.setString(1, id);
            stmt.registerOutParameter(2, OracleTypes.CURSOR);
            stmt.execute();
            rs = (ResultSet) stmt.getObject(2);

            while (rs.next()) {
                Estadistica es = new Estadistica();
                es.setCantidad(rs.getInt("PAGOS_R"));
                es.setMes(rs.getString("NOMBRE_MES"));
                lista.add(es);
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
         
     //TOTAL FONDOS X RUT
      public static int t_Fondos_Cli(String id) {
        int resultado = 0;

        Connection cn;
        Conexion con = new Conexion();
        cn = con.conectar();

        CallableStatement stmt = null;
        ResultSet rs = null;
        try {
            stmt = cn.prepareCall("CALL ESTA_T_FONDOS_CLI(?,?)");
            stmt.setString(1, id);
            stmt.registerOutParameter(2, OracleTypes.CURSOR);
            stmt.execute();
            rs = (ResultSet) stmt.getObject(2);

            while (rs.next()) {
                resultado = rs.getInt("MONTO");
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
        
     //TOTAL PAGADO X RUT
     public static int t_Pagado_Cli(String id) {
        int resultado = 0;

        Connection cn;
        Conexion con = new Conexion();
        cn = con.conectar();

        CallableStatement stmt = null;
        ResultSet rs = null;
        try {
            stmt = cn.prepareCall("CALL ESTA_T_PAGADO_CLI(?,?)");
            stmt.setString(1, id);
            stmt.registerOutParameter(2, OracleTypes.CURSOR);
            stmt.execute();
            rs = (ResultSet) stmt.getObject(2);

            while (rs.next()) {
                resultado = rs.getInt("MONTO");
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
      
      
     //TOTAL A PAGAR X RUT --> DEBE
     public static int t_Debe_Cli(String id) {
        int resultado = 0;

        Connection cn;
        Conexion con = new Conexion();
        cn = con.conectar();

        CallableStatement stmt = null;
        ResultSet rs = null;
        try {
            stmt = cn.prepareCall("CALL ESTA_T_DEBE_CLI(?,?)");
            stmt.setString(1, id);
            stmt.registerOutParameter(2, OracleTypes.CURSOR);
            stmt.execute();
            rs = (ResultSet) stmt.getObject(2);

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
     
     
     //CANTIDAD PAGADA X RUT -- PAGOS REALIZADOS   
     public static int t_CPagos_Cli(String id) {
        int resultado = 0;

        Connection cn;
        Conexion con = new Conexion();
        cn = con.conectar();

        CallableStatement stmt = null;
        ResultSet rs = null;
        try {
            stmt = cn.prepareCall("CALL ESTA_T_CPAGADA_CLI(?,?)");
            stmt.setString(1, id);
            stmt.registerOutParameter(2, OracleTypes.CURSOR);
            stmt.execute();
            rs = (ResultSet) stmt.getObject(2);

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
     
    //END ESTADISTICA CLIENTE 
     
     
    //ESTADISTICA SUPERVISOR 
     
    //TOTAL DE VISITAS Y ACCIDENTES X MES
      public static ArrayList<Estadistica> totalActivxMes_Sup() {
        ArrayList<Estadistica> lista = new ArrayList<Estadistica>();

        Connection cn;
        Conexion con = new Conexion();
        cn = con.conectar();

        CallableStatement stmt = null;
        ResultSet rs = null;

        try {
            stmt = cn.prepareCall("CALL ESTA_TACTI_SUPE(?)");
            stmt.registerOutParameter(1, OracleTypes.CURSOR);
            stmt.execute();
            rs = (ResultSet) stmt.getObject(1);

            while (rs.next()) {
                Estadistica es = new Estadistica();
                es.setCantidad(rs.getInt("CONTADOR"));
                es.setMes(rs.getString("NOMBRE_MES"));
                lista.add(es);
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
     
         
    //TOTAL DE VISITAS
       public static int t_Visitas_Sup() {
        int resultado = 0;

        Connection cn;
        Conexion con = new Conexion();
        cn = con.conectar();

        CallableStatement stmt = null;
        ResultSet rs = null;
        try {
            stmt = cn.prepareCall("CALL ESTA_TVISI_SUPE(?)");
            stmt.registerOutParameter(1, OracleTypes.CURSOR);
            stmt.execute();
            rs = (ResultSet) stmt.getObject(1);

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
       
    //TOTAL DE ACCIDENTES
       
       public static int t_Accid_Sup() {
        int resultado = 0;

        Connection cn;
        Conexion con = new Conexion();
        cn = con.conectar();

        CallableStatement stmt = null;
        ResultSet rs = null;
        try {
            stmt = cn.prepareCall("CALL ESTA_TACCI_SUPE(?)");
            stmt.registerOutParameter(1, OracleTypes.CURSOR);
            stmt.execute();
            rs = (ResultSet) stmt.getObject(1);

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
    
    //TOTAL DE FISCALIZACIONES 
       
         public static int t_Fisca_Sup() {
        int resultado = 0;

        Connection cn;
        Conexion con = new Conexion();
        cn = con.conectar();

        CallableStatement stmt = null;
        ResultSet rs = null;
        try {
            stmt = cn.prepareCall("CALL ESTA_TFIS_SUPE(?)");
            stmt.registerOutParameter(1, OracleTypes.CURSOR);
            stmt.execute();
            rs = (ResultSet) stmt.getObject(1);

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
    
    //TOTAL DE MEJORAS PROPUESTAS
         
     public static int t_Mejora_Sup() {
        int resultado = 0;

        Connection cn;
        Conexion con = new Conexion();
        cn = con.conectar();

        CallableStatement stmt = null;
        ResultSet rs = null;
        try {
            stmt = cn.prepareCall("CALL ESTA_TMEJO_SUPE(?)");
            stmt.registerOutParameter(1, OracleTypes.CURSOR);
            stmt.execute();
            rs = (ResultSet) stmt.getObject(1);

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
     
    //TOTAL DE ASISTENCIA X MES - VISITA-ACCIDENTE-FISCALIZACION
       public static ArrayList<Estadistica> totalAsisxMes_Sup() {
        ArrayList<Estadistica> lista = new ArrayList<Estadistica>();

        Connection cn;
        Conexion con = new Conexion();
        cn = con.conectar();

        CallableStatement stmt = null;
        ResultSet rs = null;

        try {
            stmt = cn.prepareCall("CALL ESTA_TASIS_SUPE(?)");
            stmt.registerOutParameter(1, OracleTypes.CURSOR);
            stmt.execute();
            rs = (ResultSet) stmt.getObject(1);

            while (rs.next()) {
                Estadistica es = new Estadistica();
                es.setCantidad(rs.getInt("CONTADOR"));
                es.setMes(rs.getString("NOMBRE_MES"));
                lista.add(es);
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
 
    //CANTIDAD DE ASISTENCIA - VISITA-ACCIDENTE-FISCALIZACION
     public static int t_CAsisten_Sup() {
        int resultado = 0;

        Connection cn;
        Conexion con = new Conexion();
        cn = con.conectar();

        CallableStatement stmt = null;
        ResultSet rs = null;
        try {
            stmt = cn.prepareCall("CALL ESTA_CASIS_SUPE(?)");
            stmt.registerOutParameter(1, OracleTypes.CURSOR);
            stmt.execute();
            rs = (ResultSet) stmt.getObject(1);

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
     

    //TOTAL DE USUARIOS ACTIVOS
      public static int t_UsuariosA_Sup() {
        int resultado = 0;

        Connection cn;
        Conexion con = new Conexion();
        cn = con.conectar();

        CallableStatement stmt = null;
        ResultSet rs = null;
        try {
            stmt = cn.prepareCall("CALL ESTA_TUSER_SUPE(?)");
            stmt.registerOutParameter(1, OracleTypes.CURSOR);
            stmt.execute();
            rs = (ResultSet) stmt.getObject(1);

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
     
     
    //TOTAL DE CONTRATOS CREADOS X MES 
     public static ArrayList<Estadistica> totalContraCre_Sup() {
        ArrayList<Estadistica> lista = new ArrayList<Estadistica>();

        Connection cn;
        Conexion con = new Conexion();
        cn = con.conectar();

        CallableStatement stmt = null;
        ResultSet rs = null;

        try {
            stmt = cn.prepareCall("CALL ESTA_CCONT_SUPE(?)");
            stmt.registerOutParameter(1, OracleTypes.CURSOR);
            stmt.execute();
            rs = (ResultSet) stmt.getObject(1);

            while (rs.next()) {
                Estadistica es = new Estadistica();
                es.setCantidad(rs.getInt("CONTADOR"));
                es.setMes(rs.getString("NOMBRE_MES"));
                lista.add(es);
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
         
     //END ESTADISTICA SUPERVISOR 

     //ESTADISTICA CAPACITADOR
     
     //TOTAL DE CAPACITACIONES X MES
      public static ArrayList<Estadistica> totalCapacita_Capa() {
        ArrayList<Estadistica> lista = new ArrayList<Estadistica>();

        Connection cn;
        Conexion con = new Conexion();
        cn = con.conectar();

        CallableStatement stmt = null;
        ResultSet rs = null;

        try {
            stmt = cn.prepareCall("CALL ESTA_T_CAPXM_CAP(?)");
            stmt.registerOutParameter(1, OracleTypes.CURSOR);
            stmt.execute();
            rs = (ResultSet) stmt.getObject(1);

            while (rs.next()) {
                Estadistica es = new Estadistica();
                es.setCantidad(rs.getInt("CONTADOR"));
                es.setMes(rs.getString("NOMBRE_MES"));
                lista.add(es);
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
     
     //TOTAL DE CAPACITACIONES 
     public static int t_Capacitaciones_Capa() {
        int resultado = 0;

        Connection cn;
        Conexion con = new Conexion();
        cn = con.conectar();

        CallableStatement stmt = null;
        ResultSet rs = null;
        try {
            stmt = cn.prepareCall("CALL ESTA_T_CAPAC_CAP(?)");
            stmt.registerOutParameter(1, OracleTypes.CURSOR);
            stmt.execute();
            rs = (ResultSet) stmt.getObject(1);

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
      
     //TOTAL DE CAPACITACIONES FINALIZADAS
    public static int t_CapacitaF_Capa() {
        int resultado = 0;

        Connection cn;
        Conexion con = new Conexion();
        cn = con.conectar();

        CallableStatement stmt = null;
        ResultSet rs = null;
        try {
            stmt = cn.prepareCall("CALL ESTA_T_CAPACF_CAP(?)");
            stmt.registerOutParameter(1, OracleTypes.CURSOR);
            stmt.execute();
            rs = (ResultSet) stmt.getObject(1);

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
     
     //TOTAL DE ASISTENCIA X MES - CAPACITACION
    public static ArrayList<Estadistica> totalAsista_Capa() {
        ArrayList<Estadistica> lista = new ArrayList<Estadistica>();

        Connection cn;
        Conexion con = new Conexion();
        cn = con.conectar();

        CallableStatement stmt = null;
        ResultSet rs = null;

        try {
            stmt = cn.prepareCall("CALL ESTA_T_ASIXM_CAP(?)");
            stmt.registerOutParameter(1, OracleTypes.CURSOR);
            stmt.execute();
            rs = (ResultSet) stmt.getObject(1);

            while (rs.next()) {
                Estadistica es = new Estadistica();
                es.setCantidad(rs.getInt("CONTADOR"));
                es.setMes(rs.getString("NOMBRE_MES"));
                lista.add(es);
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
    
    
     //CAPACITACIONES REALIZADAS
      public static int t_CapacitaC_Capa() {
        int resultado = 0;

        Connection cn;
        Conexion con = new Conexion();
        cn = con.conectar();

        CallableStatement stmt = null;
        ResultSet rs = null;
        try {
            stmt = cn.prepareCall("CALL ESTA_T_CAPAR_CAP(?)");
            stmt.registerOutParameter(1, OracleTypes.CURSOR);
            stmt.execute();
            rs = (ResultSet) stmt.getObject(1);

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
     
     
     //END ESTADISTICA CAPACITADOR 
      
      
      //ESTADISTICA ASISTENTE 
      // TOTAL DE INTERACCIONES X MES X USUARIO 
      public static ArrayList<Estadistica> totalInterac_ASI(String id) {
        ArrayList<Estadistica> lista = new ArrayList<Estadistica>();

        Connection cn;
        Conexion con = new Conexion();
        cn = con.conectar();

        CallableStatement stmt = null;
        ResultSet rs = null;

        try {
            stmt = cn.prepareCall("CALL ESTA_T_INTERAXM_ASI(?,?)");
            stmt.setString(1, id);
            stmt.registerOutParameter(2, OracleTypes.CURSOR);
            stmt.execute();
            rs = (ResultSet) stmt.getObject(2);

            while (rs.next()) {
                Estadistica es = new Estadistica();
                es.setCantidad(rs.getInt("CONTADOR"));
                es.setMes(rs.getString("NOMBRE_MES"));
                lista.add(es);
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
      
      // TOTAL DE INTERACCIONES X USUARIO
    public static int t_Interacciones_Asi(String id) {
        int resultado = 0;

        Connection cn;
        Conexion con = new Conexion();
        cn = con.conectar();

        CallableStatement stmt = null;
        ResultSet rs = null;
        try {
            stmt = cn.prepareCall("CALL ESTA_T_INTERA_ASI(?,?)");
            stmt.setString(1, id);
            stmt.registerOutParameter(2, OracleTypes.CURSOR);
            stmt.execute();
            rs = (ResultSet) stmt.getObject(2);

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
    
      // TOTAL DE APROBADAS X USUARIO
    public static int t_IAprobadas_Asi(String id) {
        int resultado = 0;

        Connection cn;
        Conexion con = new Conexion();
        cn = con.conectar();

        CallableStatement stmt = null;
        ResultSet rs = null;
        try {
            stmt = cn.prepareCall("CALL ESTA_T_APROBA_ASI(?,?)");
            stmt.setString(1, id);
            stmt.registerOutParameter(2, OracleTypes.CURSOR);
            stmt.execute();
            rs = (ResultSet) stmt.getObject(2);

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
    
      
      //END ESTADISTICA ASISTENTE 
}
