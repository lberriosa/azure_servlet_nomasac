<%-- 
    Document   : index
    Created on : 2/07/2020, 11:33:14 PM
    Author     : lberr
--%>

<%@page import="Clases.Informe_DB"%>
<%@page import="java.util.ArrayList"%>
<%@page import="Clases.Actividad"%>
<%@page import="Clases.Actividad_DB"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@include file="../header.jsp" %>
<div class="kt-grid__item kt-grid__item--fluid kt-grid kt-grid--hor">

    <!-- begin:: Subheader -->
    <div class="kt-subheader   kt-grid__item" id="kt_subheader">
        <div class="kt-subheader__main">
            <h3 class="kt-subheader__title">
                Visualizar Capacitación </h3>
            <span class="kt-subheader__separator kt-subheader__separator--v"></span>
            <div class="kt-subheader__group" id="kt_subheader_search">
                <span class="kt-subheader__desc" id="kt_subheader_total">
                    Visualiza y gestiona las capacitaciones registradas en sistema </span>
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
                        Visualizar Capacitaciones
                    </h3>
                </div>

            </div>
            <div class="kt-portlet__body">

                <!--begin: Datatable -->
                <table id="tabla_capacitaxc" class="table table-striped- table-bordered table-hover table-checkable" style="width:100%">
                    <thead>
                        <tr>
                            <th colspan="1">Información de Usuario</th>
                            <th colspan="5">Información de Actividad</th>
                            <th colspan="2">Información de Servicio</th>
                            <th colspan="1">Acciones</th>
                        </tr>
                        <tr>
                            <th>Rut</th>
                            <th>Nombre</th>
                            <th>Descripción</th>
                            <th>Fecha Inicio</th>
                            <th>Fecha Termino</th>
                            <th>Estado Actividad</th>
                            <th>Pagado</th>
                            <th>Estado</th>
                            <th>Interactuar</th>
                        </tr>
                    </thead>
                    <tbody>
                        <%                           
                            ArrayList<Actividad> lista = Actividad_DB.obtenerCapacitaCliente(codigo);
                            for (int i = 0; i < lista.size(); i++) {
                                Actividad act = lista.get(i);
                        %>
                        <tr>
                            <td><%=act.getServicio().getUsuario().getRut_usuario()%></td>
                            <td><%=act.getNombre_actividad()%></td>
                            <td><%=act.getDescr_actividad()%></td>
                            <td><%=act.getFecha_inicio()%></td>
                            <td><%=act.getFecha_termino()%></td>
                            <td><%=act.getEstado()%></td>
                            <td><%=act.getServicio().getHab_servicio()%></td>
                            <td><%=act.getServicio().getEstado_servicio()%></td>
                            <%
                                int estado = act.getEstado();
                                int estados = act.getServicio().getEstado_servicio();
                                if (estado == 1 && estados > 0) {
                            %>
                            <td>
                                <span class="dropdown">
                                    <a href="#" class="btn btn-sm btn-clean btn-icon btn-icon-md" data-toggle="dropdown" aria-expanded="true">
                                        <i class="la la-ellipsis-h"></i>
                                    </a>
                                    <div class="dropdown-menu dropdown-menu-right">
                                        <a class="dropdown-item" href="asistencia.jsp?id=<%=act.getId_actividad()%>"><i class="la la-edit"></i> Marcar Asistencia</a>
                                        <a class="dropdown-item" href="cancelar.jsp?id=<%=act.getId_actividad()%>"><i class="la la-edit"></i> Cancelar Capacitación</a>
                                    </div>
                                </span>
                                <a href="asistencia.jsp?id=<%=act.getId_actividad()%>" class="btn btn-sm btn-clean btn-icon btn-icon-md" title="Marcar Asistencia">
                                    <i class="la la-leaf"></i>
                                </a>                               

                            </td>

                            <%
                            } else if (estado == 2 && estados > 0) {
                            %>   
                            <td>
                                <span class="dropdown">
                                    <a href="#" class="btn btn-sm btn-clean btn-icon btn-icon-md" data-toggle="dropdown" aria-expanded="true">
                                        <i class="la la-ellipsis-h"></i>
                                    </a>
                                    <div class="dropdown-menu dropdown-menu-right">
                                        <a class="dropdown-item" href="finalizar.jsp?id=<%=act.getId_actividad()%>"><i class="la la-edit"></i> Finalizar Capacitación</a>
                                    </div>
                                </span>

                                <a href="finalizar.jsp?id=<%=act.getId_actividad()%>" class="btn btn-sm btn-clean btn-icon btn-icon-md" title="Finalizar Capacitación">
                                    <i class="la la-leaf"></i>
                                </a>                               

                            </td>    
                            <%
                            } else if (estado == 4 && estados > 0) {
                               
                              
                               String directory = "http://localhost:8080/nomasac/archivos/"; 
                               String archivo = Informe_DB.BuscarInformeID(act.getId_actividad());
                               String ruta = directory+archivo;
                            %>   
                            <td>
                                <span class="dropdown">
                                    <a href="#" class="btn btn-sm btn-clean btn-icon btn-icon-md" data-toggle="dropdown" aria-expanded="true">
                                        <i class="la la-ellipsis-h"></i>
                                    </a>
                                    <div class="dropdown-menu dropdown-menu-right">
                                        <a target="_blank" class="dropdown-item" href="<%=ruta %>" ><i class="la la-edit"></i> Visualizar Informe</a>
                                    </div>
                                </span>

                                <a target="_blank" href="<%=ruta %>"  class="btn btn-sm btn-clean btn-icon btn-icon-md" title="Visualizar Informe">
                                    <i class="la la-leaf"></i>
                                </a>                               

                            </td>    
                            <%
                            } else {
                            %>
                            <td></td>
                            <%
                                }
                            %> 
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


<%-- include footer --%>
<%@include file="../footer.jsp" %>
