/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

/**
 *
 * @author lberr
 */
public class Empresa {
    private String rut_empresa;
    private String rut_usuario;
    private String razon_social;
    private String direccion;
    private int telefono;
    private String correo;
    private String pagina;

    public Empresa() {
    }

    public Empresa(String rut_empresa, String rut_usuario, String razon_social, String direccion, int telefono, String correo, String pagina) {
        this.rut_empresa = rut_empresa;
        this.rut_usuario = rut_usuario;
        this.razon_social = razon_social;
        this.direccion = direccion;
        this.telefono = telefono;
        this.correo = correo;
        this.pagina = pagina;
    }

    public String getRut_empresa() {
        return rut_empresa;
    }

    public void setRut_empresa(String rut_empresa) {
        this.rut_empresa = rut_empresa;
    }

    public String getRut_usuario() {
        return rut_usuario;
    }

    public void setRut_usuario(String rut_usuario) {
        this.rut_usuario = rut_usuario;
    }

    public String getRazon_social() {
        return razon_social;
    }

    public void setRazon_social(String razon_social) {
        this.razon_social = razon_social;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getPagina() {
        return pagina;
    }

    public void setPagina(String pagina) {
        this.pagina = pagina;
    }

  
    
    
}
