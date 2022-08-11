/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlet;

import Clases.Actividad_DB;
import Clases.Alerta_DB;
import Clases.Asistencia;
import Clases.Asistencia_DB;
import Clases.Correo;
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
import jdk.nashorn.internal.runtime.regexp.joni.EncodingHelper;

/**
 *
 * @author lberr
 */
@WebServlet(name = "Servlet_CrearAsistenciaAcc", urlPatterns = {"/Servlet_CrearAsistenciaAcc"})
public class Servlet_CrearAsistenciaAcc extends HttpServlet {

 

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
        
        String ruser = request.getParameter("userr");
        String desc = request.getParameter("desc_a");
        int asistencia = Integer.parseInt(request.getParameter("check_a"));
        int id_actividad = Integer.parseInt(request.getParameter("id_act"));
        int id_servicio = Integer.parseInt(request.getParameter("id_ser"));
        int id_alertas = Integer.parseInt(request.getParameter("id_alerta"));
        
        Asistencia as = new Asistencia();
        as.setDescripcion_a(desc);
        as.setEstado_a(asistencia);
        as.setFecha_a(as.getFechaHoy());
        
        
        int ea = 2;
        
        
        int se = 0;
        int ac = 5;
        int al = 4;

        Correo correo = new Correo();
        
        
         switch (asistencia) {
            case 1:
                boolean r1 = Asistencia_DB.RegistrarAsistenciaVisita(id_actividad, as);
                boolean r2 = Actividad_DB.EditarEstadoA(ea, id_actividad);
                if(r1){
                    Usuario user = Usuario_DB.BuscarUsuarioRut(ruser);
                    String destinatario = user.getCorreo_usuario();
                    String asunto = "Marco correctamente la asistencia de profesional";
                    String cuerpo = "Genero correctamente la asistencia para profesional asignado a la visita a su empresa, ya puede ingresar al sistema para gestionar actividad. Si no corresponde favor comunicarse con un supervisor.";
                    correo.enviarCorreo(destinatario, asunto, cuerpo);

                    response.getWriter().write("Ingresado");
                    break;
                }else{
                    response.getWriter().write("Error");
                    break;
                }  
            case 2:
                boolean r3 = Asistencia_DB.RegistrarAsistenciaVisita(id_actividad, as);
                boolean r4 = Alerta_DB.CancelarVisita(ac, id_actividad, se, id_servicio, al, id_alertas);

                if(r3){
                    Usuario user = Usuario_DB.BuscarUsuarioRut(ruser);
                    String destinatario = user.getCorreo_usuario();
                    String asunto = "Marco correctamente la inasistencia de profesional";
                    String cuerpo = "Genero correctamente la inasistencia para profesional a la visita de su empresa, caso de inasistencia se vera internamente por supervisores. Si no corresponde favor comunicarse con un supervisor.";
                    correo.enviarCorreo(destinatario, asunto, cuerpo);

                    response.getWriter().write("IngresadoA"); 
                    break;
                }else{
                    response.getWriter().write("Error");
                    break;
                } 
                
            default:
                response.getWriter().write("Error");
                break;
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
