/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlet;

import Clases.Alerta_DB;
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
@WebServlet(name = "Servlet_CancelarMejora", urlPatterns = {"/Servlet_CancelarMejora"})
public class Servlet_CancelarMejora extends HttpServlet {

    

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
        
        int se = 0;
        int ac = 5;
        int me = 3;

        Correo correo = new Correo();

        try {
                boolean respuesta = Mejora_DB.CancelarMejora(ida, ac, ids, se, idm, me, Mejora.getFechaHoy());
                
            if (respuesta) {
                Usuario user = Usuario_DB.BuscarUsuarioRut(rut_user);
                String destinatario = user.getCorreo_usuario();
                String asunto = "Mejora - Cancelada en Sistema";
                String cuerpo = "Se realizo la cancelación de una mejora creada para su empresa. Profesional buscara la forma de volver a adecuar estandares para aumentar la calidad.";
                correo.enviarCorreo(destinatario, asunto, cuerpo);

                response.getWriter().write("Cancelado");
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
