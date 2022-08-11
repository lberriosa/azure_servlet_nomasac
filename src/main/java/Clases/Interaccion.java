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
public class Interaccion {
    private int id_interaccion;
    private int id_tipo_activi;
    private String id_profesional;
    private Date fecha_interaccion;
    private Usuario usuario;
    private Actividad actividad;

    public Interaccion() {
    }

    public Interaccion(int id_interaccion, int id_tipo_activi, String id_profesional, Date fecha_interaccion, Usuario usuario, Actividad actividad) {
        this.id_interaccion = id_interaccion;
        this.id_tipo_activi = id_tipo_activi;
        this.id_profesional = id_profesional;
        this.fecha_interaccion = fecha_interaccion;
        this.usuario = usuario;
        this.actividad = actividad;
    }

    public Interaccion(String id_profesional, Date fecha_interaccion, Usuario usuario, Actividad actividad) {
        this.id_profesional = id_profesional;
        this.fecha_interaccion = fecha_interaccion;
        this.usuario = usuario;
        this.actividad = actividad;
    }

    public int getId_interaccion() {
        return id_interaccion;
    }

    public void setId_interaccion(int id_interaccion) {
        this.id_interaccion = id_interaccion;
    }

    public int getId_tipo_activi() {
        return id_tipo_activi;
    }

    public void setId_tipo_activi(int id_tipo_activi) {
        this.id_tipo_activi = id_tipo_activi;
    }

    public String getId_profesional() {
        return id_profesional;
    }

    public void setId_profesional(String id_profesional) {
        this.id_profesional = id_profesional;
    }

    public Date getFecha_interaccion() {
        return fecha_interaccion;
    }

    public void setFecha_interaccion(Date fecha_interaccion) {
        this.fecha_interaccion = fecha_interaccion;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Actividad getActividad() {
        return actividad;
    }

    public void setActividad(Actividad actividad) {
        this.actividad = actividad;
    }
    
      public static java.sql.Date getFechaHoy() {
        java.util.Date today = new java.util.Date();
        return new java.sql.Date(today.getTime());
    }

    public static java.sql.Date getFecha(java.util.Date d) {
        return new java.sql.Date(d.getTime());
    }
}
