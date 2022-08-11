<%-- 
    Document   : vfondos
    Created on : 27/05/2020, 02:48:20 PM
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
                Visualizar Fondos Monetarios </h3>
            <span class="kt-subheader__separator kt-subheader__separator--v"></span>
            <div class="kt-subheader__group" id="kt_subheader_search">
                <span class="kt-subheader__desc" id="kt_subheader_total">
                    Visualiza los fondos monetarios de cada cliente registrados en sistema </span>
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
                        Visualizar Fondo Monetario
                    </h3>
                </div>
            </div>
            <div class="kt-portlet__body">

                <!--begin: Datatable -->
                <table id="tabla_fondosa" class="table table-striped- table-bordered table-hover table-checkable" style="width:100%">
                    <thead>
                        <tr>
                            <th colspan="1">Información de Usuario</th>
                            <th colspan="1">Información de Contrato</th>
                            <th colspan="2">Información de Fondo</th>
                        </tr>
                        <tr>
                            <th>Rut Usuario</th>
                            <th>Folio</th>
                            <th>Monto Abono</th>
                            <th>Fecha Abono</th>
                        </tr>
                    </thead>
                    <tbody>
                        <%  
                            ArrayList<Fondo> lista = Fondo_DB.obtenerFondosClientes();
                            for (int i = 0; i < lista.size(); i++) {
                            Fondo fondos = lista.get(i);
                        %>
                        <tr>
                            <td><%=fondos.getUsuario().getRut_usuario() %></td>
                            <td><%=fondos.getId_folio()%></td>
                            <td><%=fondos.getMonto_abono() %></td>
                            <td><%=fondos.getFecha_abono() %></td>
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
