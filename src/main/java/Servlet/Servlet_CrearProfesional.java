/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlet;

import Clases.Correo;
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
@WebServlet(name = "Servlet_CrearProfesional", urlPatterns = {"/Servlet_CrearProfesional"})
public class Servlet_CrearProfesional extends HttpServlet {

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
        String pro_user = request.getParameter("pro_usuario");

        Usuario user_ingreso = new Usuario();
        user_ingreso.setRut_usuario(rut_user);
        user_ingreso.setNombre_usuario(nom_user);
        user_ingreso.setApellido_usuario(app_user);
        user_ingreso.setTelefono_usuario(Integer.parseInt(request.getParameter("tel_usuario")));
        user_ingreso.setCorreo_usuario(corr_user);
        user_ingreso.setDireccion_usuario(dom_user);
        user_ingreso.setContraseña_usuario(password);
        user_ingreso.setTipo_usuario("Profesional");
        user_ingreso.setProfesion(pro_user);

        Usuario user = Usuario_DB.VerificarUsuarioRut(rut_user);
        Correo correo = new Correo();

        try {
            if (password.equals(passwordr)) {
                if (rut_user.equals(user.getRut_usuario())) {
                    response.getWriter().write("Existeu");
                } else {
                    boolean respuesta = Usuario_DB.RegistrarProfesional(user_ingreso);
                    if (respuesta) {
                        String asunto = "Bienvenido a no más accidentes";
                        String mensaje = "Se realizo correctamente la creacion del usuario, ya puede ingresar al sistema para visualizar y gestionar todas sus actividades";
                        correo.enviarCorreo(corr_user, asunto, mensaje);
                        response.getWriter().write("Ingresado");
                    } else {
                        response.getWriter().write("Error");
                    }

                }
            } else {
                response.getWriter().write("Invalido");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
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
