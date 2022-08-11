/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlet;

import Clases.Actividad_DB;
import Clases.Alerta;
import Clases.Alerta_DB;
import Clases.Correo;
import Clases.Usuario;
import Clases.Usuario_DB;
import Conexion.Conexion;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author lberr
 */
@WebServlet(name = "Servlet_CrearVFiscali", urlPatterns = {"/Servlet_CrearVFiscali"})
public class Servlet_CrearVFiscali extends HttpServlet {

 

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
        String id_actividad = request.getParameter("id_actividad");
        String id_alerta = request.getParameter("id_accidente");
        String desc_actividad = request.getParameter("descv"); 
        
        int idat;
        idat = Integer.parseInt(id_actividad);
        int ida;
        ida = Integer.parseInt(id_alerta);
        
        String fecha_visita = request.getParameter("fechav");
        ZoneId defaultZoneId = ZoneId.systemDefault();
        DateTimeFormatter df = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate datel = LocalDate.parse(fecha_visita, df);
        Date date = Date.from(datel.atStartOfDay(defaultZoneId).toInstant());
         
        Alerta al = new Alerta();
        
        int contador = Alerta_DB.BuscarActividadesXFID(rut_user, al.getFecha(date));
        Correo correo = new Correo();
        
        int estado = 2;
        
        if(contador > 0){
            response.getWriter().write("Invalido");
        }else{
            boolean respuesta = Alerta_DB.IngresarVisita(ida, estado);
            boolean respuesta2 = Actividad_DB.IngresarVisitaAlerta(al.getFecha(date), idat, desc_actividad);
            if(respuesta){
                Usuario user = Usuario_DB.BuscarUsuarioRut(rut_user);
                String destinatario = user.getCorreo_usuario();
                String asunto = "Visita Creada en Sistema";
                String cuerpo = "Supervisores evaluaron caso de fiscalización y formularon la creación de una visita para su empresa, ya puede ingresar al sistema para visualizar y gestionar actividad. Si no corresponde visita favor comunicarse con un supervisor.";
                correo.enviarCorreo(destinatario, asunto, cuerpo);
                
                response.getWriter().write("Ingresado");
            }else{
                response.getWriter().write("Error");
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
