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
import Clases.Usuario;
import Clases.Usuario_DB;
import Conexion.Conexion;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
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
@WebServlet(name = "Servlet_CrearCapacitacion", urlPatterns = {"/Servlet_CrearCapacitacion"})
public class Servlet_CrearCapacitacion extends HttpServlet {

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

        String rut_visita = request.getParameter("rut_usuario");
        String desc_visita = request.getParameter("descv");
        String nomb_serv = "Capacitacion";
        String nomb_activ = "Capacitacion";
        int valor_serv = 0;
        String desc_serv = "Servicio correspondiente a capacitación de empresa.";
        String desc_pago = "Pago correspondiente a capacitación de empresa.";

        String fecha_c = request.getParameter("fechav");
        ZoneId defaultZoneId = ZoneId.systemDefault();
        DateTimeFormatter df = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate datel = LocalDate.parse(fecha_c, df);
        Date date = Date.from(datel.atStartOfDay(defaultZoneId).toInstant());

        Pago p = new Pago();
        p.setDescripcion(desc_pago);

        Servicio s = new Servicio();
        s.setNombre_servicio(nomb_serv);
        s.setDescr_servicio(desc_serv);
        s.setValor_servicio(valor_serv);

        Actividad a = new Actividad();
        a.setNombre_actividad(nomb_activ);
        a.setDescr_actividad(desc_visita);
        a.setFecha_inicio(a.getFecha(date));
        a.setFecha_termino(a.getFecha(date));
        a.setServicio(s);
        a.setPago(p);

        Correo correo = new Correo();

        int existe = Actividad_DB.BuscarActividadesXFID(rut_visita, a.getFecha_inicio());
        int cantidad = Actividad_DB.BuscarCapacitacionesXM(rut_visita, a);

         try {

            if (cantidad >= 1) {
                response.getWriter().write("Maximo");
            } else {
                if (existe > 0) {
                    response.getWriter().write("Invalido");
                } else {
                    boolean respuesta = Actividad_DB.RegistrarCapacitacion(rut_visita, a);

                    if (respuesta) {
                        Usuario user = Usuario_DB.BuscarUsuarioRut(rut_visita);
                        String destinatario = user.getCorreo_usuario();
                        String asunto = "Capacitación Creada en Sistema";
                        String cuerpo = "Se realizo la creación de una capacitación para su empresa, ya puede ingresar al sistema para visualizar y gestionar actividad. Si no corresponde visita favor comunicarse con un supervisor.";
                        correo.enviarCorreo(destinatario, asunto, cuerpo);

                        response.getWriter().write("Ingresado");
                    } else {
                        response.getWriter().write("Error");
                    }

                }
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
