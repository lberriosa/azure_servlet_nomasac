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
import Clases.Servicio_DB;
import Clases.Usuario;
import Clases.Usuario_DB;
import Conexion.Conexion;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
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
@WebServlet(name = "Servlet_ReproAccidente", urlPatterns = {"/Servlet_ReproAccidente"})
public class Servlet_ReproAccidente extends HttpServlet {

   

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

        int ida;
        ida = Integer.parseInt(id_actividad);
        int ids;
        ids = Integer.parseInt(id_servicio);

        String fecha_visita = request.getParameter("fechav");
        ZoneId defaultZoneId = ZoneId.systemDefault();
        DateTimeFormatter df = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate datel = LocalDate.parse(fecha_visita, df);
        Date date = Date.from(datel.atStartOfDay(defaultZoneId).toInstant());

        Correo correo = new Correo();
        
        Alerta al = new Alerta();
        
        int contador = Alerta_DB.BuscarActividadesXFID(rut_user, al.getFecha(date));
        String desc_actividad = "Reprogramada - Visita excepcional por informe de accidente ";
        int es = 2;
        
        if(contador > 0){
            response.getWriter().write("Invalido");
        }else{
            boolean respuesta = Actividad_DB.IngresarVisitaAlerta(al.getFecha(date), ida, desc_actividad);
            boolean respuesta2 = Servicio_DB.ActualizarEstadoServicio(es, ids);
            
            if(respuesta){
                Usuario user = Usuario_DB.BuscarUsuarioRut(rut_user);
                String destinatario = user.getCorreo_usuario();
                String asunto = "Visita reprogramada en Sistema";
                String cuerpo = "Supervisores evaluaron caso de accidente y formularon la reprogramación de una visita para su empresa, ya puede ingresar al sistema para visualizar y gestionar actividad. Si no corresponde acción favor comunicarse con un supervisor.";
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
