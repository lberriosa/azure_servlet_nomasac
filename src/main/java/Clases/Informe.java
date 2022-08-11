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
public class Informe {
    private int id_informe;
    private int id_tipo_actividad;
    private String nom_archivo;
    private String nom_inform;
    private String des_inform;
    private Date fecha_inform; 

    public Informe() {
    }

    public Informe(int id_informe, int id_tipo_actividad, String nom_archivo, String nom_inform, String des_inform, Date fecha_inform) {
        this.id_informe = id_informe;
        this.id_tipo_actividad = id_tipo_actividad;
        this.nom_archivo = nom_archivo;
        this.nom_inform = nom_inform;
        this.des_inform = des_inform;
        this.fecha_inform = fecha_inform;
    }

    public int getId_informe() {
        return id_informe;
    }

    public void setId_informe(int id_informe) {
        this.id_informe = id_informe;
    }

    public int getId_tipo_actividad() {
        return id_tipo_actividad;
    }

    public void setId_tipo_actividad(int id_tipo_actividad) {
        this.id_tipo_actividad = id_tipo_actividad;
    }

    public String getNom_archivo() {
        return nom_archivo;
    }

    public void setNom_archivo(String nom_archivo) {
        this.nom_archivo = nom_archivo;
    }

    public String getNom_inform() {
        return nom_inform;
    }

    public void setNom_inform(String nom_inform) {
        this.nom_inform = nom_inform;
    }

    public String getDes_inform() {
        return des_inform;
    }

    public void setDes_inform(String des_inform) {
        this.des_inform = des_inform;
    }

    public Date getFecha_inform() {
        return fecha_inform;
    }

    public void setFecha_inform(Date fecha_inform) {
        this.fecha_inform = fecha_inform;
    }
    
    public static java.sql.Date getFechaHoy() {
        java.util.Date today = new java.util.Date();
        return new java.sql.Date(today.getTime());
    }

    public static java.sql.Date getFecha(java.util.Date d) {
        return new java.sql.Date(d.getTime());
    }
    
}
