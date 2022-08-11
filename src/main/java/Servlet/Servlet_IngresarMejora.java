/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlet;

import Clases.Actividad;
import Clases.Correo;
import Clases.Mejora;
import Clases.Mejora_DB;
import Clases.Servicio;
import Clases.Usuario;
import Clases.Usuario_DB;
import java.io.File;
import java.io.IOException;
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
@WebServlet(name = "Servlet_IngresarMejora", urlPatterns = {"/Servlet_IngresarMejora"})
@MultipartConfig
public class Servlet_IngresarMejora extends HttpServlet {

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
        
        String file = request.getParameter("descripcion");
        
        if (file != null && !file.isEmpty()) {
            Correo correo = new Correo();
            String id_user = request.getParameter("rut_usuario");
            String id_prof = request.getParameter("rut_profes");
            String nombre_m = request.getParameter("nombre");
            String descri_m = request.getParameter("descripcion");
            String nombre_s = "Mejora";
            String descri_s = "Recomendación con fines de mejorar servicios e infraestructura a empresa";
            int valor_s = 0;
            String nombre_a = "Mejora";
            String descri_a = "Recomendación a cliente de mejoras a implementar en empresa";
            
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
            
            Servicio s = new Servicio();
            s.setNombre_servicio(nombre_s);
            s.setDescr_servicio(descri_s);
            s.setValor_servicio(valor_s);
            
            Actividad a = new Actividad();
            a.setNombre_actividad(nombre_a);
            a.setDescr_actividad(descri_a);
            a.setServicio(s);
            
            Mejora m = new Mejora();
            m.setNomb_mejora(nombre_m);
            m.setDesc_mejora(descri_m);
            m.setFecha_inicio(m.getFechaHoy());
            m.setArch_mejora(fileName);
          
            boolean r1 = Mejora_DB.RegistrarMejora(id_user, id_prof, a, m);
            
            if (r1) {
                Usuario usuar = Usuario_DB.BuscarUsuarioRut(id_user);
                String destinatario = usuar.getCorreo_usuario();
                String asunto = "Mejora Creada en Sistema";
                String cuerpo = "Se realizo la creacion de una mejora para su empresa. si es validada la podra visualizar en sistema mas adelante. Si no corresponde acción favor comunicarse con un supervisor";
                correo.enviarCorreo(destinatario, asunto, cuerpo);

                response.getWriter().write("Ingresado");
            } else {
                response.getWriter().write("Error");
            }
                        
        }
         else {
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
