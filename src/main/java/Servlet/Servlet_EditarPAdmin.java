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
@WebServlet(name = "Servlet_EditarPAdmin", urlPatterns = {"/Servlet_EditarPAdmin"})
public class Servlet_EditarPAdmin extends HttpServlet {

   

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
        Usuario u = new Usuario();
        Connection cn;
        Conexion con = new Conexion();
        cn = con.conectar();
        
        String user = request.getParameter("userr");
        String nomu = request.getParameter("nomb_user");
        String appu = request.getParameter("app_user");
        int telu = Integer.parseInt(request.getParameter("tel_user"));
        String diru = request.getParameter("dir_user");
        String coru = request.getParameter("cor_user");
        
        u.setRut_usuario(user);
        u.setNombre_usuario(nomu);
        u.setApellido_usuario(appu);
        u.setTelefono_usuario(telu);
        u.setDireccion_usuario(diru);
        u.setCorreo_usuario(coru);

        try {
            Usuario usu = Usuario_DB.VerificarUsuarioRut(user);
            if (user.equals(usu.getRut_usuario())) {
                    boolean respuesta = Usuario_DB.ActualizarUsuarioAdmin(u);
                    if (respuesta) {
                        String destinatario = coru;
                        String asunto = "Se realizo un cambio de datos";
                        String cuerpo = "Se realizo el cambio de datos relacionados a tu información personal.";
                        c.enviarCorreo(destinatario, asunto, cuerpo);
                        response.getWriter().write("Exito");
                    } else {
                        response.getWriter().write("Error");
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
