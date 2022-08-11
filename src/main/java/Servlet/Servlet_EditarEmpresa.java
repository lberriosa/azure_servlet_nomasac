/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlet;

import Clases.*;
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
@WebServlet(name = "Servlet_EditarEmpresa", urlPatterns = {"/Servlet_EditarEmpresa"})
public class Servlet_EditarEmpresa extends HttpServlet {

    

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
        Empresa em = new Empresa();
        Connection cn;
        Conexion con = new Conexion();
        cn = con.conectar();
        
        String user = request.getParameter("userr");
        String empre = request.getParameter("usere");
        String razone = request.getParameter("razon_empre");
        String direce = request.getParameter("dire_empre");
        int tele = Integer.parseInt(request.getParameter("tel_empre"));
        String core = request.getParameter("cor_empre");
        String page = request.getParameter("pagina_empre");
        
        em.setRut_usuario(user);
        em.setRut_empresa(empre);
        em.setRazon_social(razone);
        em.setDireccion(direce);
        em.setTelefono(tele);
        em.setCorreo(core);
        em.setPagina(page);
        
        try {
            Usuario usu = Usuario_DB.VerificarUsuarioRut(user);
            if (user.equals(usu.getRut_usuario())) {
                    boolean respuesta = Empresa_DB.ActualizarEmpresa(em);
                    if (respuesta) {
                        Usuario usu2 = Usuario_DB.BuscarUsuario(user);
                        String destinatario = usu2.getCorreo_usuario();
                        String asunto = "Se realizo un cambio de datos";
                        String cuerpo = "Se realizo el cambio de datos relacionados a la información de la empresa. Si no realizo esta acción favor comunicarse con su administrador.";
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
