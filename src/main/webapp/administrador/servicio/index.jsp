<%-- 
    Document   : index
    Created on : 17/05/2020, 03:37:36 PM
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
                Visualizar Servicios </h3>
            <span class="kt-subheader__separator kt-subheader__separator--v"></span>
            <div class="kt-subheader__group" id="kt_subheader_search">
                <span class="kt-subheader__desc" id="kt_subheader_total">
                    Visualiza y gestiona los servicios registrados en sistema </span>
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
                        Visualizar Servicios
                    </h3>
                </div>
               
            </div>
            <div class="kt-portlet__body">

                <!--begin: Datatable -->
                <table id="tabla_servicio" class="table table-striped- table-bordered table-hover table-checkable" style="width:100%">
                    <thead>
                        <tr>
                            <th colspan="1">Información Usuario</th>
                            <th colspan="1">Información Contrato</th>
                            <th colspan="5">Información Servicio</th>
                            <th colspan="3">Estadísticas</th>
                        </tr>
                        <tr>
                            <th>Rut Usuario</th>
                            <th>Folio Contrato</th>
                            <th>Nombre Servicio</th>
                            <th>Descripcion</th>
                            <th>Valor Servicio</th>
                            <th>Fecha Inicio</th>
                            <th>Fecha Termino</th>
                            <th>Estado</th>
                            <th>Servicio Pagado</th>
                        </tr>
                    </thead>
                    <tbody>
                    <%
                    ArrayList<Servicio> lista = Servicio_DB.obtenerServiciosGenerales();
                    for(int i=0; i<lista.size(); i++){
                        Servicio servicio = lista.get(i);
                    %>
                        <tr>
                            <td><%=servicio.getUsuario().getRut_usuario() %></td>
                            <td><%=servicio.getFolio_contratos() %></td>
                            <td><%=servicio.getNombre_servicio()%></td>
                            <td><%=servicio.getDescr_servicio()%></td>
                            <td><%=servicio.getValor_servicio()%></td>
                            <td><%=servicio.getFecha_inicio()%></td>
                            <td><%=servicio.getFecha_termino()%></td>
                            <td><%=servicio.getEstado_servicio()%></td>
                            <td><%=servicio.getHab_servicio()%></td>
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
