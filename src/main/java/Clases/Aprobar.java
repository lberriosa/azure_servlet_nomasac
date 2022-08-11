/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import java.sql.Date;

/**
 *-- ESTADO     1: NO APROBADA 
    -- APROBAR     2: APROBADA
 * @author lberr
 */
public class Aprobar {
    
    private int id_aprobacion;
    private int id_profesion;
    private int id_mejora;
    private String nombre_aprobacion;
    private String desc_aprobacion;
    private int estado_aprobacion;
    private Date fecha_aprobacion;

    public Aprobar() {
    }

    public Aprobar(int id_aprobacion, int id_profesion, int id_mejora, String nombre_aprobacion, String desc_aprobacion, int estado_aprobacion, Date fecha_aprobacion) {
        this.id_aprobacion = id_aprobacion;
        this.id_profesion = id_profesion;
        this.id_mejora = id_mejora;
        this.nombre_aprobacion = nombre_aprobacion;
        this.desc_aprobacion = desc_aprobacion;
        this.estado_aprobacion = estado_aprobacion;
        this.fecha_aprobacion = fecha_aprobacion;
    }

    public int getId_aprobacion() {
        return id_aprobacion;
    }

    public void setId_aprobacion(int id_aprobacion) {
        this.id_aprobacion = id_aprobacion;
    }

    public int getId_profesion() {
        return id_profesion;
    }

    public void setId_profesion(int id_profesion) {
        this.id_profesion = id_profesion;
    }

    public int getId_mejora() {
        return id_mejora;
    }

    public void setId_mejora(int id_mejora) {
        this.id_mejora = id_mejora;
    }

    public String getNombre_aprobacion() {
        return nombre_aprobacion;
    }

    public void setNombre_aprobacion(String nombre_aprobacion) {
        this.nombre_aprobacion = nombre_aprobacion;
    }

    public String getDesc_aprobacion() {
        return desc_aprobacion;
    }

    public void setDesc_aprobacion(String desc_aprobacion) {
        this.desc_aprobacion = desc_aprobacion;
    }

    public int getEstado_aprobacion() {
        return estado_aprobacion;
    }

    public void setEstado_aprobacion(int estado_aprobacion) {
        this.estado_aprobacion = estado_aprobacion;
    }

    public Date getFecha_aprobacion() {
        return fecha_aprobacion;
    }

    public void setFecha_aprobacion(Date fecha_aprobacion) {
        this.fecha_aprobacion = fecha_aprobacion;
    }
    
     public static java.sql.Date getFechaHoy() {
        java.util.Date today = new java.util.Date();
        return new java.sql.Date(today.getTime());
    }

    public static java.sql.Date getFecha(java.util.Date d) {
        return new java.sql.Date(d.getTime());
    }
    
    
}
