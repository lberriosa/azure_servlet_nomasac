<%-- 
    Document   : asistencia
    Created on : 5/06/2020, 05:55:28 PM
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
                Visualizar Asistencia </h3>
            <span class="kt-subheader__separator kt-subheader__separator--v"></span>
            <div class="kt-subheader__group" id="kt_subheader_search">
                <span class="kt-subheader__desc" id="kt_subheader_total">
                    Visualiza las asistencias e inasistencias registradas en sistema </span>
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
                        Visualizar Asistencias
                    </h3>
                </div>
            </div>
            <div class="kt-portlet__body">

                <!--begin: Datatable -->
                <table id="tabla_inasistc" class="table table-striped- table-bordered table-hover table-checkable" style="width:100%">
                    <thead>
                        <tr>
                            <th colspan="4">Información de Actividad</th>
                            <th colspan="2">Información de Asistencia</th>
                            <th colspan="2">Estados</th>
                        </tr>
                        <tr>
                            <th>Nombre Actividad</th>
                            <th>Descripción</th>
                            <th>Fecha Inicio</th>
                            <th>Fecha Termino</th>
                            <th>Descripción Asistencia</th>
                            <th>Fecha Emisión</th>
                            <th>Asistencia</th>

                        </tr>
                    </thead>
                    <tbody>
                        <%  
                            ArrayList<Asistencia> lista = Asistencia_DB.obtenerInasistencias();
                            for (int i = 0; i < lista.size(); i++) {
                            Asistencia as = lista.get(i);
                        %>
                        <tr>
                            <td><%=as.getActividad().getNombre_actividad() %></td>
                            <td><%=as.getActividad().getDescr_actividad() %></td>
                            <td><%=as.getActividad().getFecha_inicio() %></td>
                            <td><%=as.getActividad().getFecha_termino() %></td>
                            <td><%=as.getDescripcion_a() %></td>
                            <td><%=as.getFecha_a() %></td>
                            <td><%=as.getEstado_a() %></td> 
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
