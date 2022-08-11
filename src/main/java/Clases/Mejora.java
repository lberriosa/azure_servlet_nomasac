/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import java.sql.Date;

/**
 *-- ESTADO     1: CREADA 
    -- MEJORA     2: FINALIZADA
    --            3: CANCELADA 
 * @author lberr
 */
public class Mejora {
    private int id_mejora;
    private int id_t_mejora;
    private String nomb_mejora;
    private String desc_mejora;
    private String arch_mejora;
    private int estado_mejora;
    private Date fecha_inicio;
    private Date fecha_termino;
    private Aprobar aprobar;
    private Actividad actividad;
    private Usuario usuario;

    public Mejora() {
    }

    public Mejora(int id_mejora, int id_t_mejora, String nomb_mejora, String desc_mejora, String arch_mejora, int estado_mejora, Date fecha_inicio, Date fecha_termino, Aprobar aprobar) {
        this.id_mejora = id_mejora;
        this.id_t_mejora = id_t_mejora;
        this.nomb_mejora = nomb_mejora;
        this.desc_mejora = desc_mejora;
        this.arch_mejora = arch_mejora;
        this.estado_mejora = estado_mejora;
        this.fecha_inicio = fecha_inicio;
        this.fecha_termino = fecha_termino;
        this.aprobar = aprobar;
    }

    public Mejora(String nomb_mejora, String desc_mejora, String arch_mejora, Date fecha_inicio, Date fecha_termino, Aprobar aprobar) {
        this.nomb_mejora = nomb_mejora;
        this.desc_mejora = desc_mejora;
        this.arch_mejora = arch_mejora;
        this.fecha_inicio = fecha_inicio;
        this.fecha_termino = fecha_termino;
        this.aprobar = aprobar;
    }

    public Mejora(int id_mejora, int id_t_mejora, String nomb_mejora, String desc_mejora, String arch_mejora, int estado_mejora, Date fecha_inicio, Date fecha_termino, Aprobar aprobar, Actividad actividad, Usuario usuario) {
        this.id_mejora = id_mejora;
        this.id_t_mejora = id_t_mejora;
        this.nomb_mejora = nomb_mejora;
        this.desc_mejora = desc_mejora;
        this.arch_mejora = arch_mejora;
        this.estado_mejora = estado_mejora;
        this.fecha_inicio = fecha_inicio;
        this.fecha_termino = fecha_termino;
        this.aprobar = aprobar;
        this.actividad = actividad;
        this.usuario = usuario;
    }
    
    
    public Actividad getActividad() {
        return actividad;
    }

    public void setActividad(Actividad actividad) {
        this.actividad = actividad;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    
    

    public Aprobar getAprobar() {
        return aprobar;
    }

    public void setAprobar(Aprobar aprobar) {
        this.aprobar = aprobar;
    }

    public int getId_mejora() {
        return id_mejora;
    }

    public void setId_mejora(int id_mejora) {
        this.id_mejora = id_mejora;
    }

    public int getId_t_mejora() {
        return id_t_mejora;
    }

    public void setId_t_mejora(int id_t_mejora) {
        this.id_t_mejora = id_t_mejora;
    }

    public String getNomb_mejora() {
        return nomb_mejora;
    }

    public void setNomb_mejora(String nomb_mejora) {
        this.nomb_mejora = nomb_mejora;
    }

    public String getDesc_mejora() {
        return desc_mejora;
    }

    public void setDesc_mejora(String desc_mejora) {
        this.desc_mejora = desc_mejora;
    }

    public String getArch_mejora() {
        return arch_mejora;
    }

    public void setArch_mejora(String arch_mejora) {
        this.arch_mejora = arch_mejora;
    }

    public int getEstado_mejora() {
        return estado_mejora;
    }

    public void setEstado_mejora(int estado_mejora) {
        this.estado_mejora = estado_mejora;
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
    
     public static java.sql.Date getFechaHoy() {
        java.util.Date today = new java.util.Date();
        return new java.sql.Date(today.getTime());
    }

    public static java.sql.Date getFecha(java.util.Date d) {
        return new java.sql.Date(d.getTime());
    }
    
}
