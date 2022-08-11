/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlet;

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
@WebServlet(name = "Servlet_login", urlPatterns = {"/Servlet_login"})
public class Servlet_login extends HttpServlet {

   

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
        
        String user = request.getParameter("user");
        String password = request.getParameter("password");
        
        try {
            Usuario usu = Usuario_DB.VerificarUsuario(user,password);
            
                if (user.equals(usu.getRut_usuario())) { 
                    if(usu.getHabilitado() == 1){
                        switch (usu.getTipo_usuario()) {
                            case "Administrador":
                                request.getSession().setAttribute("usuario", usu.getRut_usuario());
                                request.getSession().setAttribute("tipo", usu.getTipo_usuario());
                                response.getWriter().write("Truea");
                                break;
                            case "Profesional":
                                request.getSession().setAttribute("usuario", usu.getRut_usuario());
                                request.getSession().setAttribute("tipo", usu.getTipo_usuario());
                                response.getWriter().write("Truep");
                                break;
                            case "Cliente":
                                request.getSession().setAttribute("usuario", usu.getRut_usuario());
                                request.getSession().setAttribute("tipo", usu.getTipo_usuario());
                                response.getWriter().write("Truec");
                                break;
                            default:
                                response.getWriter().write("Error");
                                break;
                        }
                    }
                    else{
                        response.getWriter().write("Hab");
                    }
                } else {
                    response.getWriter().write("False");
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
