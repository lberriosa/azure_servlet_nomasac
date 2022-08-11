<%-- 
    Document   : vpagos
    Created on : 27/05/2020, 02:47:58 PM
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
                Visualizar Pagos </h3>
            <span class="kt-subheader__separator kt-subheader__separator--v"></span>
            <div class="kt-subheader__group" id="kt_subheader_search">
                <span class="kt-subheader__desc" id="kt_subheader_total">
                    Visualiza los pagos registrados en sistema </span>
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
                        Visualizar Pagos
                    </h3>
                </div>
            </div>
            <div class="kt-portlet__body">

                <!--begin: Datatable -->
                <table id="tabla_pagoa" class="table table-striped- table-bordered table-hover table-checkable" style="width:100%">
                    <thead>
                        <tr>
                            <th colspan="1">Información de Usuario</th>
                            <th colspan="3">Información de Pago</th>
                            <th colspan="4">Información de Servicio</th>
                        </tr>
                        <tr>
                            <th>Rut Usuario</th>
                            <th>Fecha Pago</th>
                            <th>Descripción</th>
                            <th>Valor Pago</th>
                            <th>Nombre Servicio</th>
                            <th>Descripción</th>
                            <th>Pagado</th>
                            <th>Estado</th>
                        </tr>
                    </thead>
                    <tbody>
                        <%  
                            ArrayList<Pago> lista = Pago_DB.obtenerPagoClientesAdmin();
                            for (int i = 0; i < lista.size(); i++) {
                            Pago pagos = lista.get(i);
                        %>
                        <tr>
                            <td><%=pagos.getUsuario().getRut_usuario() %></td>
                            <td><%=pagos.getFecha()%></td>
                            <td><%=pagos.getDescripcion() %></td>
                            <td><%=pagos.getMonto() %></td>
                            <td><%=pagos.getServicio().getNombre_servicio()%></td>
                            <td><%=pagos.getServicio().getDescr_servicio()%></td>
                            <td><%=pagos.getServicio().getHab_servicio() %></td>
                            <td><%=pagos.getServicio().getEstado_servicio() %></td>
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
