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
public class Usuario {
    private String rut_usuario;
    private String tipo_usuario;
    private String correo_usuario;
    private String contraseña_usuario;
    private String nombre_usuario;
    private String apellido_usuario;
    private String profesion;
    private String direccion_usuario;
    private int telefono_usuario;
    private int habilitado;
    private Empresa empresa;

    public Usuario() {
    }

    public Usuario(String rut_usuario, String correo_usuario, String nombre_usuario, String apellido_usuario) {
        this.rut_usuario = rut_usuario;
        this.correo_usuario = correo_usuario;
        this.nombre_usuario = nombre_usuario;
        this.apellido_usuario = apellido_usuario;
    }

    public Usuario(String rut_usuario) {
        this.rut_usuario = rut_usuario;
    }
    
  
    //CONSTRUCTOR CLIENTE
    public Usuario(String rut_usuario, String correo_usuario, String nombre_usuario, String apellido_usuario, String direccion_usuario, int telefono_usuario, int habilitado, Empresa empresa) {
        this.rut_usuario = rut_usuario;
        this.correo_usuario = correo_usuario;
        this.nombre_usuario = nombre_usuario;
        this.apellido_usuario = apellido_usuario;
        this.direccion_usuario = direccion_usuario;
        this.telefono_usuario = telefono_usuario;
        this.habilitado = habilitado;
        this.empresa = empresa;
    }

    //CONSTRUCTOR PROFESIONAL
    public Usuario(String rut_usuario, String correo_usuario, String nombre_usuario, String apellido_usuario, String profesion, String direccion_usuario, int telefono_usuario, int habilitado) {
        this.rut_usuario = rut_usuario;
        this.correo_usuario = correo_usuario;
        this.nombre_usuario = nombre_usuario;
        this.apellido_usuario = apellido_usuario;
        this.profesion = profesion;
        this.direccion_usuario = direccion_usuario;
        this.telefono_usuario = telefono_usuario;
        this.habilitado = habilitado;
    }
    
    
    public Usuario(String rut_usuario, String tipo_usuario, String correo_usuario, String contraseña_usuario, String nombre_usuario, String apellido_usuario, String profesion, String direccion_usuario, int telefono_usuario, int habilitado, Empresa empresa) {
        this.rut_usuario = rut_usuario;
        this.tipo_usuario = tipo_usuario;
        this.correo_usuario = correo_usuario;
        this.contraseña_usuario = contraseña_usuario;
        this.nombre_usuario = nombre_usuario;
        this.apellido_usuario = apellido_usuario;
        this.profesion = profesion;
        this.direccion_usuario = direccion_usuario;
        this.telefono_usuario = telefono_usuario;
        this.habilitado = habilitado;
        this.empresa = empresa;
    }

    public String getRut_usuario() {
        return rut_usuario;
    }

    public void setRut_usuario(String rut_usuario) {
        this.rut_usuario = rut_usuario;
    }

    public String getTipo_usuario() {
        return tipo_usuario;
    }

    public void setTipo_usuario(String tipo_usuario) {
        this.tipo_usuario = tipo_usuario;
    }

    public String getCorreo_usuario() {
        return correo_usuario;
    }

    public void setCorreo_usuario(String correo_usuario) {
        this.correo_usuario = correo_usuario;
    }

    public String getContraseña_usuario() {
        return contraseña_usuario;
    }

    public void setContraseña_usuario(String contraseña_usuario) {
        this.contraseña_usuario = contraseña_usuario;
    }

    public String getNombre_usuario() {
        return nombre_usuario;
    }

    public void setNombre_usuario(String nombre_usuario) {
        this.nombre_usuario = nombre_usuario;
    }

    public String getApellido_usuario() {
        return apellido_usuario;
    }

    public void setApellido_usuario(String apellido_usuario) {
        this.apellido_usuario = apellido_usuario;
    }

    public String getProfesion() {
        return profesion;
    }

    public void setProfesion(String profesion) {
        this.profesion = profesion;
    }

    public String getDireccion_usuario() {
        return direccion_usuario;
    }

    public void setDireccion_usuario(String direccion_usuario) {
        this.direccion_usuario = direccion_usuario;
    }

    public int getTelefono_usuario() {
        return telefono_usuario;
    }

    public void setTelefono_usuario(int telefono_usuario) {
        this.telefono_usuario = telefono_usuario;
    }

    public int getHabilitado() {
        return habilitado;
    }

    public void setHabilitado(int habilitado) {
        this.habilitado = habilitado;
    }

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }

    

   
}
