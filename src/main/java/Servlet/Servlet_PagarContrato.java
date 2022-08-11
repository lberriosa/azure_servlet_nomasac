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
import Clases.Pago;
import Clases.Pago_DB;
import Clases.Servicio;
import Clases.Servicio_DB;
import Clases.Usuario;
import Clases.Usuario_DB;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author lberr
 */
@WebServlet(name = "Servlet_PagarContrato", urlPatterns = {"/Servlet_PagarContrato"})
public class Servlet_PagarContrato extends HttpServlet {

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
        //datos de pago y usuario necesarios
        Correo c = new Correo();
        String user = request.getParameter("userr");
        int pago;
        pago = Integer.parseInt(request.getParameter("montop"));
        
        String desc = request.getParameter("descrip");
        //validacion fondos
        Fondo fondo = Fondo_DB.BuscarFondoContrato(user);
        int fondo_real = fondo.getMonto_abono();
        int fondo_actualizar = fondo_real - pago;
        
        int servicio = Servicio_DB.BuscarIDContrato(user);
        
        Pago p = new Pago();
        p.setId_serv(servicio);
        p.setMonto(pago);
        p.setDescripcion(desc);
        p.setFecha(Fondo.getFechaHoy());
        
        
        if (fondo_real >= pago) {

            boolean r1 = Contrato_DB.ActualizarContratoXU(user, 0, 1);
            boolean r2 = Servicio_DB.ActualizarServicioCU(user, Servicio.getFechaHoy(), 1, 1);
            boolean r3 = Fondo_DB.ActualizarFondos(user, fondo_actualizar, Fondo.getFechaHoy());
            boolean r4 = Pago_DB.RegistrarServicioContrato(user, p);
            
            if (r2 == true && r1 == true && r3 == true && r4 ==true ) {
                //validacion pagado
                Usuario usu2 = Usuario_DB.BuscarUsuario(user);
                String destinatario = usu2.getCorreo_usuario();
                String asunto = "Aceptaste tu contrato";
                String cuerpo = "Gracias por aceptar nuestros servicios de ahora en adelante podra disfrutar todas los beneficios en nuestro sistema. Si no realizo esta acción favor comunicarse con su administrador."; 
                c.enviarCorreo(destinatario, asunto, cuerpo);
                
                HttpSession session = request.getSession();
                session.invalidate();
                
                response.getWriter().write("Pagado");
            } else {
                response.getWriter().write("Error");
            }

        } else {
            response.getWriter().write("Fondos");
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
