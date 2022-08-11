/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import java.sql.Date;

/**
 *   --ESTADO 1: CREADA
    --       2: EN PROGRESO  
    --       3: S/INFORME
    --       4: TERMINADA
    --       5: CANCELADA
 * @author lberr
 */
public class Actividad {
    
    private int id_actividad;
    private String nombre_actividad;
    private String descr_actividad;
    private int estado;
    private Date fecha_inicio;
    private Date fecha_termino;
    private Servicio servicio;
    private Pago pago;

    public Actividad() {
    }

    public Actividad(int id_actividad, String nombre_actividad, String descr_actividad, int estado, Date fecha_inicio, Date fecha_termino, Servicio servicio, Pago pago) {
        this.id_actividad = id_actividad;
        this.nombre_actividad = nombre_actividad;
        this.descr_actividad = descr_actividad;
        this.estado = estado;
        this.fecha_inicio = fecha_inicio;
        this.fecha_termino = fecha_termino;
        this.servicio = servicio;
        this.pago = pago;
    }

    public Actividad(int id_actividad, String nombre_actividad, String descr_actividad, int estado, Date fecha_inicio, Date fecha_termino, Servicio servicio) {
        this.id_actividad = id_actividad;
        this.nombre_actividad = nombre_actividad;
        this.descr_actividad = descr_actividad;
        this.estado = estado;
        this.fecha_inicio = fecha_inicio;
        this.fecha_termino = fecha_termino;
        this.servicio = servicio;
    }

    public Actividad(String nombre_actividad, String descr_actividad, int estado, Date fecha_inicio, Date fecha_termino) {
        this.nombre_actividad = nombre_actividad;
        this.descr_actividad = descr_actividad;
        this.estado = estado;
        this.fecha_inicio = fecha_inicio;
        this.fecha_termino = fecha_termino;
    }
    
    
    
    public Pago getPago() {
        return pago;
    }

    public void setPago(Pago pago) {
        this.pago = pago;
    }

    public int getId_actividad() {
        return id_actividad;
    }

    public void setId_actividad(int id_actividad) {
        this.id_actividad = id_actividad;
    }

    public String getNombre_actividad() {
        return nombre_actividad;
    }

    public void setNombre_actividad(String nombre_actividad) {
        this.nombre_actividad = nombre_actividad;
    }

    public String getDescr_actividad() {
        return descr_actividad;
    }

    public void setDescr_actividad(String descr_actividad) {
        this.descr_actividad = descr_actividad;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    public Date getFecha_inicio() {
        return fecha_inicio;
    }

    public void setFecha_inicio(Date fecha_inicio) {
        this.fecha_inicio = fecha_inicio;
    }

    public Date getFecha_termino() {
        return fecha_termino;
    }

    public void setFecha_termino(Date fecha_termino) {
        this.fecha_termino = fecha_termino;
    }

    public Servicio getServicio() {
        return servicio;
    }

    public void setServicio(Servicio servicio) {
        this.servicio = servicio;
    }
    
    public static java.sql.Date getFechaHoy() {
        java.util.Date today = new java.util.Date();
        return new java.sql.Date(today.getTime());
    }

    public static java.sql.Date getFecha(java.util.Date d) {
        return new java.sql.Date(d.getTime());
    }
    
    
    
    
}
