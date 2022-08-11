/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlet;

import Clases.Correo;
import Clases.Empresa;
import Clases.Empresa_DB;
import Clases.Usuario;
import Clases.Usuario_DB;
import Conexion.Conexion;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author lberr
 */
@WebServlet(name = "Servlet_CrearCliente", urlPatterns = {"/Servlet_CrearCliente"})
public class Servlet_CrearCliente extends HttpServlet {

   

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Connection cn;
        Conexion con = new Conexion();
        cn = con.conectar();
        
        String password = request.getParameter("pass");
        String passwordr = request.getParameter("rpass");
        String rut_user = request.getParameter("rut_usuario");
        String nom_user = request.getParameter("nom_usuario");
        String app_user = request.getParameter("app_usuario");
        String corr_user = request.getParameter("corr_usuario");
        String dom_user = request.getParameter("dom_usuario");
        
        String rut_empresa = request.getParameter("rut_empresa");
        String raz_empre = request.getParameter("raz_empresa");
        String dir_empre = request.getParameter("dir_empresa");
        String cor_empre = request.getParameter("cor_empresa");
        String pag_empre = request.getParameter("pag_empresa");
        
        Usuario user_ingreso = new Usuario();
        user_ingreso.setRut_usuario(rut_user);
        user_ingreso.setNombre_usuario(nom_user);
        user_ingreso.setApellido_usuario(app_user);
        user_ingreso.setTelefono_usuario(Integer.parseInt(request.getParameter("tel_usuario")));
        user_ingreso.setCorreo_usuario(corr_user);
        user_ingreso.setDireccion_usuario(dom_user);
        user_ingreso.setContraseña_usuario(password);
        user_ingreso.setTipo_usuario("Cliente");
        
        Empresa empresa_ingreso = new Empresa();
        empresa_ingreso.setRut_empresa(rut_empresa);
        empresa_ingreso.setRazon_social(raz_empre);
        empresa_ingreso.setDireccion(dir_empre);
        empresa_ingreso.setTelefono(Integer.parseInt(request.getParameter("tel_empresa")));
        empresa_ingreso.setCorreo(cor_empre);
        empresa_ingreso.setPagina(pag_empre);
        
        Empresa empr = Empresa_DB.VerificarEmpresaRut(rut_empresa);
        Usuario user = Usuario_DB.VerificarUsuarioRut(rut_user);
        
        Correo correo = new Correo();
        try{
            if(password.equals(passwordr)){
                if(rut_user.equals(user.getRut_usuario())){
                    response.getWriter().write("Existeu"); 
                }
                else{
                    if(rut_empresa.equals(empr.getRut_empresa())){
                        response.getWriter().write("Existee");
                    }
                    else{
                        boolean respuesta = Usuario_DB.RegistrarCliente(user_ingreso,empresa_ingreso);
                        if(respuesta){
                            String asunto = "Bienvenido a no más accidentes";
                            String mensaje = "Se realizo correctamente la creacion del usuario, ya puede ingresar al sistema para visualizar y gestionar todos sus beneficios";
                            correo.enviarCorreo(corr_user, asunto, mensaje);
                            response.getWriter().write("Ingresado");
                        }else{
                            response.getWriter().write("Error");
                        }  
                    } 
                }
            }
            else{
               response.getWriter().write("Invalido"); 
            }
        } catch (Exception e) {
             e.printStackTrace();
         }finally {
            try {

                cn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

     
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
