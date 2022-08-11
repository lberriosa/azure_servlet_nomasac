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
public class Pago {
    private int id_pago;
    private int id_serv;
    private int monto;
    private String descripcion;
    private Date fecha;
    private Servicio servicio;
    private Usuario usuario;

    public Pago() {
    }
    
    public Pago(int id_pago, int id_serv, int monto, String descripcion, Date fecha) {
        this.id_pago = id_pago;
        this.id_serv = id_serv;
        this.monto = monto;
        this.descripcion = descripcion;
        this.fecha = fecha;
    }

    public Pago(int id_pago, int monto, String descripcion, Date fecha, Servicio servicio) {
        this.id_pago = id_pago;
        this.monto = monto;
        this.descripcion = descripcion;
        this.fecha = fecha;
        this.servicio = servicio;
    }

    public Pago(int monto, String descripcion, Date fecha) {
        this.monto = monto;
        this.descripcion = descripcion;
        this.fecha = fecha;
    }

    public Pago(int id_pago, int monto, String descripcion, Date fecha, Servicio servicio, Usuario usuario) {
        this.id_pago = id_pago;
        this.monto = monto;
        this.descripcion = descripcion;
        this.fecha = fecha;
        this.servicio = servicio;
        this.usuario = usuario;
    }
    
    
    
   
    public Servicio getServicio() {
        return servicio;
    }

    public void setServicio(Servicio servicio) {
        this.servicio = servicio;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    
    

    public int getId_pago() {
        return id_pago;
    }

    public void setId_pago(int id_pago) {
        this.id_pago = id_pago;
    }

    public int getId_serv() {
        return id_serv;
    }

    public void setId_serv(int id_serv) {
        this.id_serv = id_serv;
    }

    public int getMonto() {
        return monto;
    }

    public void setMonto(int monto) {
        this.monto = monto;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
    
     public static java.sql.Date getFechaHoy() {
        java.util.Date today = new java.util.Date();
     return new java.sql.Date(today.getTime());
    }
    
     public static java.sql.Date getFecha(java.util.Date d) {
        return new java.sql.Date(d.getTime());
    }
            
            
}
