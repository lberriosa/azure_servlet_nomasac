/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlet;

import Clases.Actividad;
import Clases.Actividad_DB;
import Clases.Correo;
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
@WebServlet(name = "Servlet_ReproVisita", urlPatterns = {"/Servlet_ReproVisita"})
public class Servlet_ReproVisita extends HttpServlet {

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

        Date d = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(d); 
        calendar.add(Calendar.DAY_OF_YEAR, 30); 
        Date fechaSalida = calendar.getTime(); 
        
        String noms = "Reprogramación";
        String desc = "Visita Reprogramada, excede solicitudes gratuitas";
        int vals = 50000;
        
        Actividad a = new Actividad();
        a.setFecha_inicio(a.getFecha(date));
        
        Servicio s = new Servicio();
        s.setNombre_servicio(noms);
        s.setValor_servicio(vals);
        s.setDescr_servicio(desc);
        s.setFecha_inicio(s.getFechaHoy());
        s.setFecha_termino(s.getFecha(fechaSalida));

        int reprogramadas = Actividad_DB.BuscarVisitasReproXA(rut_user, a);
        int existe = Actividad_DB.BuscarVisitaxUsuarioF(rut_user, a);

        Correo correo = new Correo();

        if (existe > 0) {
            response.getWriter().write("Invalido");

        } else {
            if (reprogramadas > 2) {
               
                int estado = 2;
                boolean r1 = Servicio_DB.RegistrarServicioCobroEx(rut_user, s);
                boolean r2 = Actividad_DB.EditarVisitaF(ida, ids, estado, a.getFecha(date));
                if(r1){
                    Usuario user = Usuario_DB.BuscarUsuarioRut(rut_user);
                    String destinatario = user.getCorreo_usuario();
                    String asunto = "Visita Reagendada en Sistema";
                    String cuerpo = "Se reagendo una visita a su empresa, (SE REALIZA COBRO EXTRA DE $50.000 YA QUE EXCEDE MAXIMO PERMITIDO EN CONTRATO )ya puede ingresar al sistema para visualizar y gestionar actividad. Si no corresponde visita favor comunicarse con un supervisor.";
                    correo.enviarCorreo(destinatario, asunto, cuerpo);
                    
                    response.getWriter().write("IngresadoCobro");
                }else{
                    response.getWriter().write("Error");
                }
                            
            } else {
                int estado = 2;
                boolean respuesta = Actividad_DB.EditarVisitaF(ida, ids, estado, a.getFecha(date));

                if (respuesta) {
                    Usuario user = Usuario_DB.BuscarUsuarioRut(rut_user);
                    String destinatario = user.getCorreo_usuario();
                    String asunto = "Visita Reagendada en Sistema";
                    String cuerpo = "Se reagendo una visita a su empresa, ya puede ingresar al sistema para visualizar y gestionar actividad. Si no corresponde visita favor comunicarse con un supervisor.";
                    correo.enviarCorreo(destinatario, asunto, cuerpo);

                    response.getWriter().write("Ingresado");
                } else {
                    response.getWriter().write("Error");
                }

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
