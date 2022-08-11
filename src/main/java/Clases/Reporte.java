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
public class Reporte {
    private int id_reporte;
    private String nom_repo;
    private String nom_archivo;
    private String des_repo;
    private Date fecha_repo;

    public Reporte() {
    }

    public Reporte(int id_reporte, String nom_repo, String nom_archivo, String des_repo, Date fecha_repo) {
        this.id_reporte = id_reporte;
        this.nom_repo = nom_repo;
        this.nom_archivo = nom_archivo;
        this.des_repo = des_repo;
        this.fecha_repo = fecha_repo;
    }

    public Reporte(String nom_repo, String nom_archivo, String des_repo, Date fecha_repo) {
        this.nom_repo = nom_repo;
        this.nom_archivo = nom_archivo;
        this.des_repo = des_repo;
        this.fecha_repo = fecha_repo;
    }
    
    

    public int getId_reporte() {
        return id_reporte;
    }

    public void setId_reporte(int id_reporte) {
        this.id_reporte = id_reporte;
    }

    public String getNom_repo() {
        return nom_repo;
    }

    public void setNom_repo(String nom_repo) {
        this.nom_repo = nom_repo;
    }

    public String getNom_archivo() {
        return nom_archivo;
    }

    public void setNom_archivo(String nom_archivo) {
        this.nom_archivo = nom_archivo;
    }

    public String getDes_repo() {
        return des_repo;
    }

    public void setDes_repo(String des_repo) {
        this.des_repo = des_repo;
    }

    public Date getFecha_repo() {
        return fecha_repo;
    }

    public void setFecha_repo(Date fecha_repo) {
        this.fecha_repo = fecha_repo;
    }
    
      public static java.sql.Date getFechaHoy() {
        java.util.Date today = new java.util.Date();
        return new java.sql.Date(today.getTime());
    }

    public static java.sql.Date getFecha(java.util.Date d) {
        return new java.sql.Date(d.getTime());
    }
    
    
}
