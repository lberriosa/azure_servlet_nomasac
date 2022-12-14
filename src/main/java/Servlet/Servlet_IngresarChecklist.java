/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlet;

import Clases.Actividad_DB;
import Clases.Checklist;
import Clases.Checklist_DB;
import Clases.Correo;
import Clases.Usuario;
import Clases.Usuario_DB;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.nio.file.Paths;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

/**
 *
 * @author lberr
 */
@WebServlet(name = "Servlet_IngresarChecklist", urlPatterns = {"/Servlet_IngresarChecklist"})
@MultipartConfig
public class Servlet_IngresarChecklist extends HttpServlet {

    private static final long serialVersionUID = 1L;

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

        String file = request.getParameter("ide_acti");

        if (file != null && !file.isEmpty()) {

            Correo correo = new Correo();
            String desc = request.getParameter("descripcion");
            String user = request.getParameter("rut_user");
            String id_actividad = request.getParameter("ide_acti");
            int ida;
            ida = Integer.parseInt(id_actividad);
            String nombre_ch = "Checklist Visita";
            int ac = 4;
            Checklist ch = new Checklist();

            String serverPath = getServletContext().getRealPath("/");
            String upload_directory = "archivos/"; // get path to the upload folder.
            String complete_path = serverPath + upload_directory; // get the complete path to the upload folder.

            String uploadPath = complete_path;
            File uploadDir = new File(uploadPath);
            if (!uploadDir.exists()) {
                uploadDir.mkdir();
            }

            //GETTING FILE 
            Part filePart = request.getPart("file");
            //GETTING FILE NAME
            String fileName = Paths.get(filePart.getSubmittedFileName()).getFileName().toString();

            filePart.write(uploadPath + File.separator + fileName);

            ch.setNom_archivo(fileName);
            ch.setNom_check(nombre_ch);
            ch.setDes_check(desc);
            ch.setFecha_check(ch.getFechaHoy());

            boolean r1 = Checklist_DB.RegistrarChecklist(ida, ch);
            boolean r2 = Actividad_DB.FinalizarVisita(ac, ida);

            if (r1) {
                Usuario usuar = Usuario_DB.BuscarUsuarioRut(user);
                String destinatario = usuar.getCorreo_usuario();
                String asunto = "Visita Finalizada en Sistema";
                String cuerpo = "Se realizo la subida del informe de la visita realizada. Podra realizar la revision en sistema. Si no corresponde acci??n favor comunicarse con un supervisor";
                correo.enviarCorreo(destinatario, asunto, cuerpo);

                response.getWriter().write("Ingresado");
            } else {
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
