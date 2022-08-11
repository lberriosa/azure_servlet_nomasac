/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlet;

import Clases.Usuario;
import Clases.Usuario_DB;
import Clases.Correo;
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
@WebServlet(name = "Servlet_rpass", urlPatterns = {"/Servlet_rpass"})
public class Servlet_rpass extends HttpServlet {

  
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
        Correo c = new Correo();
        Connection cn;
        Conexion con = new Conexion();
        cn = con.conectar();
        
        String user = request.getParameter("userr");
        String password = request.getParameter("password");
        String passwordr = request.getParameter("rpassword");
        
        try {
            Usuario usu = Usuario_DB.VerificarUsuarioRut(user);
            if (user.equals(usu.getRut_usuario())) {
                if(password.equals(passwordr)){
                    boolean respuesta = Usuario_DB.CambiarContraseña(user, password);
                    if (respuesta) {
                        Usuario usu2 = Usuario_DB.BuscarUsuario(user);
                        String destinatario = usu2.getCorreo_usuario();
                        String asunto = "Cambio de contraseña exitoso";
                        String cuerpo = "Se a realizado el cambio de su contraseña. Si no realizo esta acción favor comunicarse con su administrador.";
                        c.enviarCorreo(destinatario, asunto, cuerpo);
                        response.getWriter().write("Exito");
                    } else {
                        response.getWriter().write("Error");
                    }
                } 
                else {
                    response.getWriter().write("Invalido");
                } 
            } else {
                response.getWriter().write("False");
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
