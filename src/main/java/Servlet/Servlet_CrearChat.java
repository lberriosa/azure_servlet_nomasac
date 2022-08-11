/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlet;

import Clases.Actividad;
import Clases.Actividad_DB;
import Clases.Correo;
import Clases.Pago;
import Clases.Servicio;
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
@WebServlet(name = "Servlet_CrearChat", urlPatterns = {"/Servlet_CrearChat"})
public class Servlet_CrearChat extends HttpServlet {

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

        Calendar c = Calendar.getInstance();
        c.setTime(Actividad.getFechaHoy());
        int dayOfWeek = c.get(Calendar.DAY_OF_WEEK);

        Connection cn;
        Conexion con = new Conexion();
        cn = con.conectar();

        String rut_usuario = request.getParameter("rut_usuario");
        String rut_profesi = request.getParameter("rut_profesional");
        String desc_activi = "Actividad correspondiente a conversación con profesional via chat.";
        String nomb_serv = "Chat";
        String nomb_activ = "Chat";
        int valor_serv = 0;
        String desc_serv = "Servicio correspondiente a conversación con profesional via chat.";
        String desc_pago = "Pago correspondiente a servicio de chat.";

        Pago p = new Pago();
        p.setDescripcion(desc_pago);

        Servicio s = new Servicio();
        s.setNombre_servicio(nomb_serv);
        s.setDescr_servicio(desc_serv);
        s.setValor_servicio(valor_serv);

        Actividad a = new Actividad();
        a.setNombre_actividad(nomb_activ);
        a.setDescr_actividad(desc_activi);
        a.setFecha_inicio(a.getFechaHoy());
        a.setFecha_termino(a.getFechaHoy());
        a.setServicio(s);
        a.setPago(p);
        
        int valor_e = 10000;
        Servicio se = new Servicio();
        se.setNombre_servicio(nomb_serv);
        se.setDescr_servicio(desc_serv);
        se.setValor_servicio(valor_e);
        se.setFecha_inicio(se.getFechaHoy());
        se.setFecha_termino(se.getFechaHoy());

        Correo correo = new Correo();

        if (dayOfWeek == 6 || dayOfWeek == 7) {
            boolean cobro = Servicio_DB.RegistrarServicioCobroEx(rut_usuario, se);
            boolean respuesta = Actividad_DB.RegistrarActividadCh(rut_usuario,rut_profesi, a);
            if (respuesta) {
                Usuario user = Usuario_DB.BuscarUsuarioRut(rut_usuario);
                String destinatario = user.getCorreo_usuario();
                String asunto = "Chat Creado en Sistema";
                String cuerpo = "Se realizo la creación de una solicitud de conversación con uno de nuestros ejecutivos. Si no corresponde actividad favor comunicarse con un supervisor.";
                correo.enviarCorreo(destinatario, asunto, cuerpo);

                response.getWriter().write("Creado");
            } else {
                response.getWriter().write("Error");
            }

        } else {
            boolean respuesta = Actividad_DB.RegistrarActividadCh(rut_usuario,rut_profesi, a);
            if (respuesta) {
                Usuario user = Usuario_DB.BuscarUsuarioRut(rut_usuario);
                String destinatario = user.getCorreo_usuario();
                String asunto = "Chat Creado en Sistema";
                String cuerpo = "Se realizo la creación de una solicitud de conversación con uno de nuestros ejecutivos. Si no corresponde actividad favor comunicarse con un supervisor.";
                correo.enviarCorreo(destinatario, asunto, cuerpo);

                response.getWriter().write("Creado");
            } else {
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
