/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import java.sql.Date;
import java.util.Calendar;

/**
 *
 * --ESTADO 1 : ACTIVO
    --       0 : DESHABILITADO 
    --       2 : EDITADA
    
    --PAGADO 0 : NO PAGADO
    --       1 : PAGADO
 * @author lberr
 */
public class Servicio {

    private int id_servicio;
    private int folio_contratos;
    private String nombre_servicio;
    private int valor_servicio;
    private String descr_servicio;
    private Date fecha_inicio;
    private Date fecha_termino;
    private int estado_servicio;
    //pagado 
    private int hab_servicio;
    private Usuario usuario;
    
    public Servicio() {
    }

    public Servicio(String nombre_servicio, int valor_servicio, String descr_servicio, Date fecha_inicio, Date fecha_termino, int estado_servicio, int hab_servicio) {
        this.nombre_servicio = nombre_servicio;
        this.valor_servicio = valor_servicio;
        this.descr_servicio = descr_servicio;
        this.fecha_inicio = fecha_inicio;
        this.fecha_termino = fecha_termino;
        this.estado_servicio = estado_servicio;
        this.hab_servicio = hab_servicio;
    }

    public Servicio(int id_servicio, int folio_contratos, String nombre_servicio, int valor_servicio, String descr_servicio, Date fecha_inicio, Date fecha_termino, int estado_servicio, int hab_servicio, Usuario usuario) {
        this.id_servicio = id_servicio;
        this.folio_contratos = folio_contratos;
        this.nombre_servicio = nombre_servicio;
        this.valor_servicio = valor_servicio;
        this.descr_servicio = descr_servicio;
        this.fecha_inicio = fecha_inicio;
        this.fecha_termino = fecha_termino;
        this.estado_servicio = estado_servicio;
        this.hab_servicio = hab_servicio;
        this.usuario = usuario;
    }

    public Servicio(String nombre_servicio, String descr_servicio, int hab_servicio) {
        this.nombre_servicio = nombre_servicio;
        this.descr_servicio = descr_servicio;
        this.hab_servicio = hab_servicio;
    }

    public Servicio(String nombre_servicio, String descr_servicio, int estado_servicio, int hab_servicio) {
        this.nombre_servicio = nombre_servicio;
        this.descr_servicio = descr_servicio;
        this.estado_servicio = estado_servicio;
        this.hab_servicio = hab_servicio;
    }

    public Servicio(int id_servicio, int estado_servicio, int hab_servicio, Usuario usuario) {
        this.id_servicio = id_servicio;
        this.estado_servicio = estado_servicio;
        this.hab_servicio = hab_servicio;
        this.usuario = usuario;
    }

    public Servicio(int id_servicio, String nombre_servicio, int valor_servicio, String descr_servicio, Date fecha_inicio, Date fecha_termino, Usuario usuario) {
        this.id_servicio = id_servicio;
        this.nombre_servicio = nombre_servicio;
        this.valor_servicio = valor_servicio;
        this.descr_servicio = descr_servicio;
        this.fecha_inicio = fecha_inicio;
        this.fecha_termino = fecha_termino;
        this.usuario = usuario;
    }

    public Servicio(int id_servicio, String nombre_servicio, int valor_servicio, String descr_servicio, Date fecha_inicio, Date fecha_termino) {
        this.id_servicio = id_servicio;
        this.nombre_servicio = nombre_servicio;
        this.valor_servicio = valor_servicio;
        this.descr_servicio = descr_servicio;
        this.fecha_inicio = fecha_inicio;
        this.fecha_termino = fecha_termino;
    }
    
    
    
    

    

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    
    public int getId_servicio() {
        return id_servicio;
    }

    public void setId_servicio(int id_servicio) {
        this.id_servicio = id_servicio;
    }

    public int getFolio_contratos() {
        return folio_contratos;
    }

    public void setFolio_contratos(int folio_contratos) {
        this.folio_contratos = folio_contratos;
    }

    public String getNombre_servicio() {
        return nombre_servicio;
    }

    public void setNombre_servicio(String nombre_servicio) {
        this.nombre_servicio = nombre_servicio;
    }

    public int getValor_servicio() {
        return valor_servicio;
    }

    public void setValor_servicio(int valor_servicio) {
        this.valor_servicio = valor_servicio;
    }

    public String getDescr_servicio() {
        return descr_servicio;
    }

    public void setDescr_servicio(String descr_servicio) {
        this.descr_servicio = descr_servicio;
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

    public int getEstado_servicio() {
        return estado_servicio;
    }

    public void setEstado_servicio(int estado_servicio) {
        this.estado_servicio = estado_servicio;
    }

    public int getHab_servicio() {
        return hab_servicio;
    }

    public void setHab_servicio(int hab_servicio) {
        this.hab_servicio = hab_servicio;
    }

    public static java.sql.Date getFechaHoy() {
        java.util.Date today = new java.util.Date();
        return new java.sql.Date(today.getTime());
    }

    public static java.sql.Date getFecha(java.util.Date d) {
        return new java.sql.Date(d.getTime());
    }


}
