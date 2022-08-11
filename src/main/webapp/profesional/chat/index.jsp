<%-- 
    Document   : index
    Created on : 1/07/2020, 11:56:14 PM
    Author     : lberr
--%>

<%@page import="Clases.Interaccion_DB"%>
<%@page import="java.util.ArrayList"%>
<%@page import="Clases.Interaccion"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<%@include file="../header.jsp" %>
<%    String cod = (String) session.getAttribute("usuario");
%>
<div class="kt-grid__item kt-grid__item--fluid kt-grid kt-grid--hor">

    <!-- begin:: Subheader -->
    <div class="kt-subheader   kt-grid__item" id="kt_subheader">
        <div class="kt-subheader__main">
            <h3 class="kt-subheader__title">
                Modulo de Conversación </h3>
            <span class="kt-subheader__separator kt-subheader__separator--v"></span>
            <div class="kt-subheader__group" id="kt_subheader_search">
                <span class="kt-subheader__desc" id="kt_subheader_total">
                    Visualiza las solicitudes e ingresa al sistema de mensaje con nuestros clientes.</span>
            </div>

        </div>

    </div>

    <!-- end:: Subheader -->

    <!-- begin:: Content -->
    <div class="kt-content  kt-grid__item kt-grid__item--fluid" id="kt_content">

        <div class="kt-portlet kt-portlet--mobile">
            <div class="kt-portlet__head kt-portlet__head--lg">
                <div class="kt-portlet__head-label">
                    <span class="kt-portlet__head-icon">
                        <i class="kt-font-brand flaticon2-layers-1"></i>
                    </span>
                    <h3 class="kt-portlet__head-title">
                        Visualización de Solicitudes
                    </h3>
                </div>
                <div class="kt-portlet__head-toolbar">
                    <div class="kt-portlet__head-wrapper">

                    </div>
                </div>
            </div>
            <div class="kt-portlet__body">

                <!--begin: Datatable -->
                <table id="tabla_chatc" class="table table-striped- table-bordered table-hover table-checkable" style="width:100%">
                    <thead>
                        <tr>
                            <th colspan="4">Información de Usuario</th>
                            <th colspan="2">Información de Chat</th>
                            <th colspan="1">Acciones</th>
                        </tr>
                        <tr>
                            <th>Rut</th>
                            <th>Nombre</th>
                            <th>Correo</th>
                            <th>Telefono</th>
                            <th>Estado Chat</th>
                            <th>Fecha Interacción</th>
                            <th>Ingresar a Sala</th>
                        </tr>
                    </thead>
                    <tbody>
                        <%
                            ArrayList<Interaccion> lista = Interaccion_DB.obtenerChatSProfesional(cod);
                            for (int i = 0; i < lista.size(); i++) {
                                Interaccion inte = lista.get(i);
                        %>
                        <tr>
                            <td><%=inte.getUsuario().getRut_usuario()%></td>
                            <td><%=inte.getUsuario().getNombre_usuario() + ' ' + inte.getUsuario().getApellido_usuario()%></td>
                            <td><%=inte.getUsuario().getCorreo_usuario()%></td>
                            <td><%=inte.getUsuario().getTelefono_usuario()%></td>
                            <td><%=inte.getActividad().getEstado()%></td>
                            <td><%=inte.getFecha_interaccion()%></td>              
                            <td> 
                                <a href="chat.jsp?id=<%=inte.getActividad().getId_actividad()%>"  class="btn btn-sm btn-clean btn-icon btn-icon-md" title="Ingresar a Sala">
                                <i class="la la-leaf"></i>
                                </a> 
                            </td>          
                        </tr>
                        <%
                            }
                        %>
                    </tbody>
                </table>

                <!--end: Datatable -->
            </div>
        </div>
    </div>

    <!-- end:: Content -->
</div>


<%@include file="../footer.jsp" %>
