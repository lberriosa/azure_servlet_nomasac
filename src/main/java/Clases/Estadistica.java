/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import com.google.gson.Gson;
import java.util.ArrayList;

/**
 *
 * @author lberr
 */
public class Estadistica {
    private String mes;
    private int cantidad;

    public Estadistica() {
    }

    public String getMes() {
        return mes;
    }

    public void setMes(String mes) {
        this.mes = mes;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
    
    public static String toJSON(ArrayList<Estadistica> list) {
    Gson gson = new Gson();
    StringBuilder sb = new StringBuilder();
    for(Estadistica d : list) {
        sb.append(gson.toJson(d));
    }
    return sb.toString();
}
    
}
