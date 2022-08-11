/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import java.sql.Date;



/**
 *--ESTADO 0 : NO PAGADO 
    --       1 : ACTIVO
    --       2 : DESHABILITADO
    
    --MODIFICADO 0 : NO MODIFICADO
    --           1 : MODIFICADO
 * @author lberr
 */
public class Contrato {
    private int folio_contrato;
    private Date fecha_contrato;
    private String plazo_contrato;
    private int monto_contrato;
    private int modificado;
    private int estado;
    private Usuario usuario;

    public Contrato(int folio_contrato, Date fecha_contrato, String plazo_contrato, int monto_contrato, int modificado, int estado, Usuario usuario) {
        this.folio_contrato = folio_contrato;
        this.fecha_contrato = fecha_contrato;
        this.plazo_contrato = plazo_contrato;
        this.monto_contrato = monto_contrato;
        this.modificado = modificado;
        this.estado = estado;
        this.usuario = usuario;
    }

    public Contrato(int folio_contrato, int modificado, int estado) {
        this.folio_contrato = folio_contrato;
        this.modificado = modificado;
        this.estado = estado;
    }
    
    public Contrato(Date fecha_contrato, String plazo_contrato, int monto_contrato, int modificado, int estado) {
        this.fecha_contrato = fecha_contrato;
        this.plazo_contrato = plazo_contrato;
        this.monto_contrato = monto_contrato;
        this.modificado = modificado;
        this.estado = estado;
    }

    public Contrato(int folio_contrato) {
        this.folio_contrato = folio_contrato;
    }
    
    
    
    public static java.sql.Date getFechaHoy() {
        java.util.Date today = new java.util.Date();
     return new java.sql.Date(today.getTime());
    }
    
     public static java.sql.Date getFecha(java.util.Date d) {
        return new java.sql.Date(d.getTime());
    }
    
    public Contrato() {
    }

    public int getFolio_contrato() {
        return folio_contrato;
    }

    public void setFolio_contrato(int folio_contrato) {
        this.folio_contrato = folio_contrato;
    }

    public Date getFecha_contrato() {
        return fecha_contrato;
    }

    public void setFecha_contrato(Date fecha_contrato) {
        this.fecha_contrato = fecha_contrato;
    }

    public String getPlazo_contrato() {
        return plazo_contrato;
    }

    public void setPlazo_contrato(String plazo_contrato) {
        this.plazo_contrato = plazo_contrato;
    }

    public int getMonto_contrato() {
        return monto_contrato;
    }

    public void setMonto_contrato(int monto_contrato) {
        this.monto_contrato = monto_contrato;
    }

    public int getModificado() {
        return modificado;
    }

    public void setModificado(int modificado) {
        this.modificado = modificado;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    
    
    

   

   



    
    
}
