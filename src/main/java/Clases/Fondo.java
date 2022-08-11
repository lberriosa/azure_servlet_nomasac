/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import java.sql.Date;
import java.util.ArrayList;

/**
 *
 * @author lberr
 */
public class Fondo {

    private int id_fondo;
    private int id_folio;
    private int monto_abono;
    private Date fecha_abono;
    private Contrato contrato;
    private Usuario usuario;

    public Fondo() {
    }

    public Fondo(int monto_abono) {
        this.monto_abono = monto_abono;
    }

    
    public Fondo(int monto_abono, Contrato contrato) {
        this.monto_abono = monto_abono;
        this.contrato = contrato;
    }

    public Fondo(int monto_abono, Date fecha_abono) {
        this.monto_abono = monto_abono;
        this.fecha_abono = fecha_abono;
    }

    public Fondo(int id_folio, int monto_abono, Date fecha_abono, Usuario usuario) {
        this.id_folio = id_folio;
        this.monto_abono = monto_abono;
        this.fecha_abono = fecha_abono;
        this.usuario = usuario;
    }

   
    
    

    public int getId_fondo() {
        return id_fondo;
    }

    public void setId_fondo(int id_fondo) {
        this.id_fondo = id_fondo;
    }

    public int getId_folio() {
        return id_folio;
    }

    public void setId_folio(int id_folio) {
        this.id_folio = id_folio;
    }

    public int getMonto_abono() {
        return monto_abono;
    }

    public void setMonto_abono(int monto_abono) {
        this.monto_abono = monto_abono;
    }

    public Date getFecha_abono() {
        return fecha_abono;
    }

    public void setFecha_abono(Date fecha_abono) {
        this.fecha_abono = fecha_abono;
    }

    public Contrato getContrato() {
        return contrato;
    }

    public void setContrato(Contrato contrato) {
        this.contrato = contrato;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    
    
    public static java.sql.Date getFechaHoy() {
        java.util.Date today = new java.util.Date();
        return new java.sql.Date(today.getTime());
    }

    public static java.sql.Date getFecha(java.util.Date d) {
        return new java.sql.Date(d.getTime());
    }

   

}
