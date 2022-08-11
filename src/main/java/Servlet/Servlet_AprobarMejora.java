/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlet;

import Clases.Correo;
import Clases.Mejora;
import Clases.Mejora_DB;
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
@WebServlet(name = "Servlet_AprobarMejora", urlPatterns = {"/Servlet_AprobarMejora"})
public class Servlet_AprobarMejora extends HttpServlet {

    

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
        
        String rut_user = request.getParameter("rut_usuario");
        String rut_prof = request.getParameter("rut_profes");
        String id_actividad = request.getParameter("id_activi");
        String id_servicio = request.getParameter("id_servici");
        String id_mejora = request.getParameter("id_mejora");
        String id_aprob = request.getParameter("id_aprob");
        
        int ida;
        ida = Integer.parseInt(id_actividad);
        int ids;
        ids = Integer.parseInt(id_servicio);
        int idm;
        idm = Integer.parseInt(id_mejora);
        int idap;
        idap = Integer.parseInt(id_aprob);
        
        int ac = 4;
        int me = 2;
        int ap = 2;

        Correo correo = new Correo();

        try {
                boolean respuesta = Mejora_DB.AprobarMejora(ida,ac,idap,ap,rut_prof,idm,me,Mejora.getFechaHoy());
                
            if (respuesta) {
                Usuario user = Usuario_DB.BuscarUsuarioRut(rut_user);
                String destinatario = user.getCorreo_usuario();
                String asunto = "Mejora - Aprobada en Sistema";
                String cuerpo = "Se realizo la aprobación de una mejora creada para su empresa. Podra visualizar los datos necesarios en sistema.";
                correo.enviarCorreo(destinatario, asunto, cuerpo);

                response.getWriter().write("Aprobado");
            } else {
                response.getWriter().write("Error");
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
