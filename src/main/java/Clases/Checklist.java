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
public class Checklist {
    private int id_checklist;
    private String nom_archivo;
    private String nom_check;
    private String des_check;
    private Date fecha_check;

    public Checklist() {
    }

    public Checklist(int id_checklist, String nom_archivo, String nom_check, String des_check, Date fecha_check) {
        this.id_checklist = id_checklist;
        this.nom_archivo = nom_archivo;
        this.nom_check = nom_check;
        this.des_check = des_check;
        this.fecha_check = fecha_check;
    }

    public Checklist(String nom_archivo, String nom_check, String des_check, Date fecha_check) {
        this.nom_archivo = nom_archivo;
        this.nom_check = nom_check;
        this.des_check = des_check;
        this.fecha_check = fecha_check;
    }
    
    

    public int getId_checklist() {
        return id_checklist;
    }

    public void setId_checklist(int id_checklist) {
        this.id_checklist = id_checklist;
    }

    public String getNom_archivo() {
        return nom_archivo;
    }

    public void setNom_archivo(String nom_archivo) {
        this.nom_archivo = nom_archivo;
    }

    public String getNom_check() {
        return nom_check;
    }

    public void setNom_check(String nom_check) {
        this.nom_check = nom_check;
    }

    public String getDes_check() {
        return des_check;
    }

    public void setDes_check(String des_check) {
        this.des_check = des_check;
    }

    public Date getFecha_check() {
        return fecha_check;
    }

    public void setFecha_check(Date fecha_check) {
        this.fecha_check = fecha_check;
    }

    public static java.sql.Date getFechaHoy() {
        java.util.Date today = new java.util.Date();
        return new java.sql.Date(today.getTime());
    }

    public static java.sql.Date getFecha(java.util.Date d) {
        return new java.sql.Date(d.getTime());
    }
    
    
    
}
