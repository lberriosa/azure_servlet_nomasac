/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlet;

import Clases.Correo;
import Clases.Fondo;
import Clases.Fondo_DB;
import Clases.Pago;
import Clases.Pago_DB;
import Clases.Servicio_DB;
import Clases.Usuario;
import Clases.Usuario_DB;
import Conexion.Conexion;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
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
@WebServlet(name = "Servlet_PagarPendientes", urlPatterns = {"/Servlet_PagarPendientes"})
public class Servlet_PagarPendientes extends HttpServlet {

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
        Connection cn;
        Conexion con = new Conexion();
        cn = con.conectar();

        String rut_user = request.getParameter("userr");
        String monto_pago = request.getParameter("monto_p");
        String d_pago = request.getParameter("descripcion");
        String id_servicio = request.getParameter("id_servici");

        int ids;
        ids = Integer.parseInt(id_servicio);
        int pago;
        pago = Integer.parseInt(monto_pago);

        Fondo fondo = Fondo_DB.BuscarFondo(rut_user);
        int fondo_real = fondo.getMonto_abono();
        int fondo_actualizar = fondo_real - pago;

        Pago p = new Pago();
        p.setId_serv(ids);
        p.setMonto(pago);
        p.setDescripcion(d_pago);
        p.setFecha(Fondo.getFechaHoy());

        int estado = 1;
        int pagado = 1;

        if (fondo_real >= pago) {
            boolean r1 = Pago_DB.RegistrarPago(rut_user, p);
            boolean r2 = Servicio_DB.ActualizarServicioPE(ids, estado, pagado);
            boolean r3 = Fondo_DB.ActualizarFondos(rut_user, fondo_actualizar, Fondo.getFechaHoy());
            if (r2 == true && r1 == true && r3 == true) {

                //validacion pagado
                Usuario usu = Usuario_DB.BuscarUsuario(rut_user);
                String destinatario = usu.getCorreo_usuario();
                String asunto = "Se realizo un pago pendiente";
                String cuerpo = "Confirmamos un pago pendiente en nuestro sistema, recuerda visualizar voucher en nuestro sistema. Si no realizo esta acción favor comunicarse con su administrador.";
                c.enviarCorreo(destinatario, asunto, cuerpo);
                
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
