<%-- 
    Document   : index
    Created on : 17/06/2020, 09:37:33 PM
    Author     : lberr
--%>

<%@page import="Clases.Reporte_DB"%>
<%@page import="Clases.Alerta"%>
<%@page import="java.util.ArrayList"%>
<%@page import="Clases.Alerta_DB"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@include file="../header.jsp" %>

<div class="kt-grid__item kt-grid__item--fluid kt-grid kt-grid--hor">

    <!-- begin:: Subheader -->
    <div class="kt-subheader   kt-grid__item" id="kt_subheader">
        <div class="kt-subheader__main">
            <h3 class="kt-subheader__title">
                Visualizar Fiscalización </h3>
            <span class="kt-subheader__separator kt-subheader__separator--v"></span>
            <div class="kt-subheader__group" id="kt_subheader_search">
                <span class="kt-subheader__desc" id="kt_subheader_total">
                    Visualiza y gestiona las fiscalizaciones registradas en sistema </span>
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
                        Visualizar Fiscalización
                    </h3>
                </div>
                <div class="kt-portlet__head-toolbar">
                    <div class="kt-portlet__head-wrapper">
                        <div class="kt-portlet__head-actions">
                            <a href="crear.jsp" class="btn btn-brand btn-elevate btn-icon-sm">
                                <i class="la la-plus"></i>
                                Informar Fiscalización
                            </a>
                        </div>
                    </div>
                </div>
            </div>
            <div class="kt-portlet__body">

                <!--begin: Datatable -->
                <table id="tabla_alertafis" class="table table-striped- table-bordered table-hover table-checkable" style="width:100%">
                    <thead>
                        <tr>
                            <th colspan="4">Información de Fiscalización</th>
                            <th colspan="2">Información de Servicio</th>
                            <th colspan="1">Acciones</th>
                        </tr>
                        <tr>
                            <th>Fecha Fiscalización</th>
                            <th>Nombre</th>
                            <th>Descripción</th>
                            <th>Estado Fiscalización</th>
                            <th>Estado Actividad</th>
                            <th>Estado Servicio</th>
                            <th>Interactuar</th>
                        </tr>
                    </thead>
                    <tbody>
                        <%  
                            ArrayList<Alerta> lista = Alerta_DB.obtenerFiscalizacionesXRut(codigo);
                            for (int i = 0; i < lista.size(); i++) {
                            Alerta alt = lista.get(i);
                        %>
                        <tr>
                            <td><%=alt.getFecha_alerta() %></td>
                            <td><%=alt.getNombre_alerta() %></td>
                            <td><%=alt.getDesc_alerta() %></td>
                            <td><%=alt.getEstado_alerta() %></td>
                            <td><%=alt.getActividad().getEstado() %></td>
                            <td><%=alt.getActividad().getServicio().getEstado_servicio() %></td>
                         <%
                                int estadoal = alt.getEstado_alerta();
                                int estadoac = alt.getActividad().getEstado();
                                int estadose = alt.getActividad().getServicio().getEstado_servicio();

                                if (estadose != 0 && estadoal == 1 && estadoac == 1) {
                            %>
                            <td>
                                <span class="dropdown">
                                    <a href="#" class="btn btn-sm btn-clean btn-icon btn-icon-md" data-toggle="dropdown" aria-expanded="true">
                                        <i class="la la-ellipsis-h"></i>
                                    </a>
                                    <div class="dropdown-menu dropdown-menu-right">
                                        <a class="dropdown-item" href="cancelar.jsp?id=<%=alt.getId_alerta()%>"><i class="la la-edit"></i> Cancelar Actividad</a>
                                    </div>
                                </span>
                                <a href="cancelar.jsp?id=<%=alt.getId_alerta()%>" class="btn btn-sm btn-clean btn-icon btn-icon-md" title="Cancelar Actividad">
                                    <i class="la la-leaf"></i>
                                </a> 
                            </td>
                            <%
                            } else if (estadose != 0 && estadoal == 2 && estadoac == 1) {
                            %>
                            <td>
                                <span class="dropdown">
                                    <a href="#" class="btn btn-sm btn-clean btn-icon btn-icon-md" data-toggle="dropdown" aria-expanded="true">
                                        <i class="la la-ellipsis-h"></i>
                                    </a>
                                    <div class="dropdown-menu dropdown-menu-right">
                                        <a class="dropdown-item" href="asistencia.jsp?id=<%=alt.getId_alerta()%>"><i class="la la-edit"></i> Marcar Asistencia</a>
                                        <a class="dropdown-item" href="visita.jsp?id=<%=alt.getId_alerta()%>"><i class="la la-edit"></i> Visualizar Datos de Visita</a>
                                        <a class="dropdown-item" href="reprogramar.jsp?id=<%=alt.getId_alerta()%>"><i class="la la-edit"></i> Reprogramar Visita</a>
                                        <a class="dropdown-item" href="cancelarv.jsp?id=<%=alt.getId_alerta()%>"><i class="la la-edit"></i> Cancelar Visita</a>
                                    </div>
                                </span>
                                <a href="asistencia.jsp?id=<%=alt.getId_alerta()%>" class="btn btn-sm btn-clean btn-icon btn-icon-md" title="Marcar Asistencia">
                                    <i class="la la-leaf"></i>
                                </a>   
                            </td>
                             <%
                            } else if (estadose != 0 && estadoal == 2 && estadoac == 2) {
                            %>   
                            <td>
                                <span class="dropdown">
                                    <a href="#" class="btn btn-sm btn-clean btn-icon btn-icon-md" data-toggle="dropdown" aria-expanded="true">
                                        <i class="la la-ellipsis-h"></i>
                                    </a>
                                    <div class="dropdown-menu dropdown-menu-right">
                                        <a class="dropdown-item" href="finalizar.jsp?id=<%=alt.getId_alerta() %>"><i class="la la-edit"></i> Finalizar Visita</a>
                                    </div>
                                </span>

                                <a href="finalizar.jsp?id=<%=alt.getId_alerta() %>" class="btn btn-sm btn-clean btn-icon btn-icon-md" title="Finalizar Visita">
                                    <i class="la la-leaf"></i>
                                </a>                               

                            </td> 
                            <%
                            } else if(estadose != 0 && estadoal == 3 && estadoac == 4){
                                 
                                    String directory = "http://localhost:8080/nomasac/archivos/"; 
                                    String archivo = Reporte_DB.BuscarArchivoFID(alt.getId_t_alerta());
                                    String ruta = directory+archivo;    
                            %> 
                              <td>
                                <span class="dropdown">
                                    <a href="#" class="btn btn-sm btn-clean btn-icon btn-icon-md" data-toggle="dropdown" aria-expanded="true">
                                        <i class="la la-ellipsis-h"></i>
                                    </a>
                                    <div class="dropdown-menu dropdown-menu-right">
                                        <a target="_blank" class="dropdown-item" href="<%=ruta %>" ><i class="la la-edit"></i> Visualizar Reporte</a>
                                    </div>
                                </span>

                                <a target="_blank" href="<%=ruta %>"  class="btn btn-sm btn-clean btn-icon btn-icon-md" title="Visualizar Reporte">
                                    <i class="la la-leaf"></i>
                                </a>                               

                            </td> 
                            <%
                                }else {
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

