/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlet;

import Clases.Contrato;
import Clases.Contrato_DB;
import Clases.Correo;
import Clases.Fondo;
import Clases.Fondo_DB;
import Clases.Servicio;
import Clases.Servicio_DB;
import Clases.Usuario;
import Clases.Usuario_DB;
import Conexion.Conexion;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
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
@WebServlet(name = "Servlet_CrearContrato", urlPatterns = {"/Servlet_CrearContrato"})
public class Servlet_CrearContrato extends HttpServlet {



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
        
        String plazo = "Anual";
        String nom_servicio = "Contrato";
        String desc_servicio = "Valor inicial correspondiente a la creacion de contrato";
        int monto = 2000000;
        int abono = 0;
        
        Servicio servicio = new Servicio();
        
        Date d = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(d); 
        calendar.add(Calendar.DAY_OF_YEAR, 15); 
        Date fechaSalida = calendar.getTime(); 
        
     
        Usuario user = new Usuario();
        user.setRut_usuario(rut_user);
        
        Contrato contrato = new Contrato();
        contrato.setFecha_contrato(contrato.getFechaHoy());
        contrato.setPlazo_contrato(plazo);
        contrato.setMonto_contrato(monto);
        
        
        servicio.setNombre_servicio(nom_servicio);
        servicio.setValor_servicio(monto);
        servicio.setDescr_servicio(desc_servicio);
        servicio.setFecha_inicio(servicio.getFechaHoy());
        servicio.setFecha_termino(servicio.getFecha(fechaSalida));
        
        Fondo fondo_monetario = new Fondo();
        fondo_monetario.setMonto_abono(abono);
        fondo_monetario.setFecha_abono(fondo_monetario.getFechaHoy());
        
        /** METODO PARA INGRESAR FECHA EXACTA 
        String testDate = "29-02-2020";
        DateFormat formatter = new SimpleDateFormat("d-MM-yyyy");
        
        try {
            Date date = formatter.parse(testDate);
            user.setRut_usuario(rut_user);
            contrato.setFecha_contrato(contrato.getFecha(date));
            contrato.setPlazo_contrato(plazo);
            contrato.setMonto_contrato(monto);
        } catch (ParseException ex) {
            Logger.getLogger(Servlet_CrearContrato.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        **/
        
        Correo correo = new Correo();
        try {
            boolean respuesta = Contrato_DB.RegistrarContrato(user, contrato);
            boolean respuesta_s = Servicio_DB.RegistrarServicioContrato(user, servicio);
            boolean respuesta_f = Fondo_DB.RegistrarFondoMonetario(user, fondo_monetario);
            
            if (respuesta) {
                Usuario user2 = Usuario_DB.BuscarUsuarioRut(rut_user);
                String destinatario = user2.getCorreo_usuario();
                String asunto = "Contrato Creado! No mas Accidentes";
                String cuerpo = "Se realizo correctamente la creacion del contrato, ya puede ingresar al sistema para aprobar y realizar el pago. Le recordamos leer los terminos y condiciones antes de aprobar";
                correo.enviarCorreo(destinatario, asunto, cuerpo);
                
                response.getWriter().write("Ingresado");
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
