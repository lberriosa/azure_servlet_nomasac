/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import java.sql.Date;

/**
 *    --ESTADO 1 : ASISTENTE
               2 : INASISTENTE 
 * @author lberr
 */
public class Asistencia {
    private int id_asistencia;
    private int id_tipo_a;
    private String descripcion_a;
    private int estado_a;
    private Date fecha_a;
    private Actividad actividad;

    public Asistencia() {
    }

    public Asistencia(String descripcion_a, int estado_a, Date fecha_a) {
        this.descripcion_a = descripcion_a;
        this.estado_a = estado_a;
        this.fecha_a = fecha_a;
    }

    public Asistencia(int id_asistencia, int id_tipo_a, String descripcion_a, int estado_a, Date fecha_a) {
        this.id_asistencia = id_asistencia;
        this.id_tipo_a = id_tipo_a;
        this.descripcion_a = descripcion_a;
        this.estado_a = estado_a;
        this.fecha_a = fecha_a;
    }

    public Asistencia(String descripcion_a, int estado_a, Date fecha_a, Actividad actividad) {
        this.descripcion_a = descripcion_a;
        this.estado_a = estado_a;
        this.fecha_a = fecha_a;
        this.actividad = actividad;
    }
    
 
    public Actividad getActividad() {
        return actividad;
    }

    public void setActividad(Actividad actividad) {
        this.actividad = actividad;
    }
    
    public int getId_asistencia() {
        return id_asistencia;
    }

    public void setId_asistencia(int id_asistencia) {
        this.id_asistencia = id_asistencia;
    }

    public int getId_tipo_a() {
        return id_tipo_a;
    }

    public void setId_tipo_a(int id_tipo_a) {
        this.id_tipo_a = id_tipo_a;
    }

    public String getDescripcion_a() {
        return descripcion_a;
    }

    public void setDescripcion_a(String descripcion_a) {
        this.descripcion_a = descripcion_a;
    }

    public int getEstado_a() {
        return estado_a;
    }

    public void setEstado_a(int estado_a) {
        this.estado_a = estado_a;
    }

    public Date getFecha_a() {
        return fecha_a;
    }

    public void setFecha_a(Date fecha_a) {
        this.fecha_a = fecha_a;
    }
    
    
     public static java.sql.Date getFechaHoy() {
        java.util.Date today = new java.util.Date();
        return new java.sql.Date(today.getTime());
    }

    public static java.sql.Date getFecha(java.util.Date d) {
        return new java.sql.Date(d.getTime());
    }
    
    
}
