/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlet;

import Clases.Correo;
import Clases.Fondo;
import Clases.Fondo_DB;
import Clases.Usuario;
import Clases.Usuario_DB;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author lberr
 */
@WebServlet(name = "Servlet_AddFondos", urlPatterns = {"/Servlet_AddFondos"})
public class Servlet_AddFondos extends HttpServlet {



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
        String user = request.getParameter("rut_usuario");
        String str = request.getParameter("monto_abono");
        
        str = str.replaceAll("[^\\dA-Za-z]", "");
        str = str.replaceAll("[^0-9]", "");
        
        int pago;
        pago = Integer.parseInt(str);
        
        int total;
        total = Integer.parseInt(request.getParameter("total_fondo"));
        
        int ingresar;
        ingresar = pago + total;
        
        
         if (pago > 0) {
            boolean resp =  Fondo_DB.ActualizarFondos(user, ingresar, Fondo.getFechaHoy());
            
            if(resp == true){
                Usuario usu2 = Usuario_DB.BuscarUsuario(user);
                String destinatario = usu2.getCorreo_usuario();
                String asunto = "Se añadieron fondos a tu cuenta personal";
                String cuerpo = "Se realizado el ingreso de dinero a tu fondo monetario. Si no realizo esta acción favor comunicarse con su administrador.";
                c.enviarCorreo(destinatario, asunto, cuerpo);
               response.getWriter().write("Pagado");
            }else{
                response.getWriter().write("Error");
            }
            
        } else {
            response.getWriter().write("Error");
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
