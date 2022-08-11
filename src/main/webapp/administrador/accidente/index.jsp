<%-- 
    Document   : index
    Created on : 18/06/2020, 10:05:23 PM
    Author     : lberr
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@include file="../header.jsp" %>

<div class="kt-grid__item kt-grid__item--fluid kt-grid kt-grid--hor">

    <!-- begin:: Subheader -->
    <div class="kt-subheader   kt-grid__item" id="kt_subheader">
        <div class="kt-subheader__main">
            <h3 class="kt-subheader__title">
                Visualizar Accidentes </h3>
            <span class="kt-subheader__separator kt-subheader__separator--v"></span>
            <div class="kt-subheader__group" id="kt_subheader_search">
                <span class="kt-subheader__desc" id="kt_subheader_total">
                    Visualiza los accidentes registrados en sistema </span>
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
                        Visualizar Accidentes
                    </h3>
                </div>
            </div>
            <div class="kt-portlet__body">

                <!--begin: Datatable -->
                <table id="tabla_alertaacc" class="table table-striped- table-bordered table-hover table-checkable" style="width:100%">
                    <thead>
                        <tr>
                            <th colspan="1">Información de Usuario</th>
                            <th colspan="4">Información de Accidente</th>
                            <th colspan="2">Información de Servicio</th>
                            <th colspan="1">Informe</th>
                        </tr>
                        <tr>
                            <th>Rut</th>
                            <th>Fecha Accidente</th>
                            <th>Nombre</th>
                            <th>Descripción</th>
                            <th>Estado Accidente</th>
                            <th>Estado Actividad</th>
                            <th>Estado Servicio</th>
                            <th>Ver Reporte</th>
                        </tr>
                    </thead>
                    <tbody>
                        <%  
                            ArrayList<Alerta> lista = Alerta_DB.obtenerAccidentes();
                            for (int i = 0; i < lista.size(); i++) {
                            Alerta alt = lista.get(i);
                        %>
                        <tr>
                            <td><%=alt.getActividad().getServicio().getUsuario().getRut_usuario() %></td>
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

                                if (estadose != 0 && estadoal == 3 && estadoac == 4) {
                                     String directory = "http://localhost:8080/nomasac/archivos/"; 
                                    String archivo = Reporte_DB.BuscarArchivoAID(alt.getId_t_alerta());
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