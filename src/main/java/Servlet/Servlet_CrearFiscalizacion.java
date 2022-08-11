/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlet;

import Clases.Actividad;
import Clases.Alerta;
import Clases.Alerta_DB;
import Clases.Correo;
import Clases.Servicio;
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
@WebServlet(name = "Servlet_CrearFiscalizacion", urlPatterns = {"/Servlet_CrearFiscalizacion"})
public class Servlet_CrearFiscalizacion extends HttpServlet {

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
        Correo correo = new Correo();

        String rut_user = request.getParameter("rut_usuario");
        String des_accidente = request.getParameter("desc_acc");
        String fecha_accidente = request.getParameter("fech_acc");

        ZoneId defaultZoneId = ZoneId.systemDefault();
        DateTimeFormatter df = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate datel = LocalDate.parse(fecha_accidente, df);
        Date date = Date.from(datel.atStartOfDay(defaultZoneId).toInstant());

        Date d = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(d);
        calendar.add(Calendar.DAY_OF_YEAR, 30);
        Date fechaSalida = calendar.getTime();

        String n_servicio = "Fiscalizacion";
        String d_servicio = "Servicio correspondiente al informe de fiscalizacion";
        int v_servicio = 0;
        Servicio s = new Servicio();
        s.setNombre_servicio(n_servicio);
        s.setDescr_servicio(d_servicio);
        s.setValor_servicio(v_servicio);

        String n_actividad = "Fiscalizacion";
        String d_actividad = des_accidente;
        Actividad a = new Actividad();
        a.setNombre_actividad(n_actividad);
        a.setDescr_actividad(d_actividad);
        a.setFecha_termino(a.getFecha(fechaSalida));
        a.setServicio(s);

        Alerta al = new Alerta();
        al.setNombre_alerta(n_actividad);
        al.setDesc_alerta(des_accidente);
        al.setFecha_alerta(al.getFecha(date));
        al.setActividad(a);

        String d_pago = "Servicio correspondiente al informe de fiscalizacion";
        int v_pago = 0;

        int cantidad = Alerta_DB.BuscarCAlertasXA(rut_user, al.getFecha(date));

        if (cantidad < 11) {
            boolean respuesta = Alerta_DB.RegistrarAlerta(rut_user, al, d_pago, v_pago);
            if (respuesta) {

                Usuario user = Usuario_DB.BuscarUsuarioRut(rut_user);
                String destinatario = user.getCorreo_usuario();
                String asunto = "Se informo correctamente sobre una fiscalización";
                String cuerpo = "Hemos recibido correctamente la alerta de una fiscalización a su empresa. Supervisor agendara visita a su empresa lo antes posible, se avisara cuando este disponible la fecha de visita y la opción de gestionar actividad. Si no corresponde alerta favor comunicarse con un supervisor.";
                correo.enviarCorreo(destinatario, asunto, cuerpo);

                response.getWriter().write("Creado");

            } else {
                response.getWriter().write("Error");
            }
        } else {
            response.getWriter().write("Limite");
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
