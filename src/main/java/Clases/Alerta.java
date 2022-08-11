/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import java.sql.Date;

/**
 *
 * @author lberr
 */

 /** ESTADO  1: CREADA 
                2: VISITA ACTIVA 
                3: FINALIZADA   
                4: CANCELADA
    **/
public class Alerta {
   
    private int id_alerta;
    private int id_t_alerta;
    private String nombre_alerta;
    private String desc_alerta;
    private int estado_alerta;
    private Date fecha_alerta;
    private Actividad actividad;

    public Alerta() {
    }

    public Alerta(int id_alerta, int id_t_alerta, String nombre_alerta, String desc_alerta, int estado_alerta, Date fecha_alerta) {
        this.id_alerta = id_alerta;
        this.id_t_alerta = id_t_alerta;
        this.nombre_alerta = nombre_alerta;
        this.desc_alerta = desc_alerta;
        this.estado_alerta = estado_alerta;
        this.fecha_alerta = fecha_alerta;
    }

    public Alerta(String nombre_alerta, String desc_alerta, Date fecha_alerta, Actividad actividad) {
        this.nombre_alerta = nombre_alerta;
        this.desc_alerta = desc_alerta;
        this.fecha_alerta = fecha_alerta;
        this.actividad = actividad;
    }

    public Actividad getActividad() {
        return actividad;
    }

    public void setActividad(Actividad actividad) {
        this.actividad = actividad;
    }

    public int getId_alerta() {
        return id_alerta;
    }

    public void setId_alerta(int id_alerta) {
        this.id_alerta = id_alerta;
    }

    public int getId_t_alerta() {
        return id_t_alerta;
    }

    public void setId_t_alerta(int id_t_alerta) {
        this.id_t_alerta = id_t_alerta;
    }

    public String getNombre_alerta() {
        return nombre_alerta;
    }

    public void setNombre_alerta(String nombre_alerta) {
        this.nombre_alerta = nombre_alerta;
    }

    public String getDesc_alerta() {
        return desc_alerta;
    }

    public void setDesc_alerta(String desc_alerta) {
        this.desc_alerta = desc_alerta;
    }

    public int getEstado_alerta() {
        return estado_alerta;
    }

    public void setEstado_alerta(int estado_alerta) {
        this.estado_alerta = estado_alerta;
    }

    public Date getFecha_alerta() {
        return fecha_alerta;
    }

    public void setFecha_alerta(Date fecha_alerta) {
        this.fecha_alerta = fecha_alerta;
    }
    
    public static java.sql.Date getFechaHoy() {
        java.util.Date today = new java.util.Date();
        return new java.sql.Date(today.getTime());
    }

    public static java.sql.Date getFecha(java.util.Date d) {
        return new java.sql.Date(d.getTime());
    }
        
    
}
