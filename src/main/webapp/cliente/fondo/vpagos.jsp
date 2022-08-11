<%-- 
    Document   : vpagos
    Created on : 26/05/2020, 10:58:51 PM
    Author     : lberr
--%>

<%@page import="Clases.Pago"%>
<%@page import="Clases.Pago_DB"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@include file="../header.jsp" %>

<%    
    String cod = (String) session.getAttribute("usuario");
%>


<div class="kt-grid__item kt-grid__item--fluid kt-grid kt-grid--hor">

    <!-- begin:: Subheader -->
    <div class="kt-subheader   kt-grid__item" id="kt_subheader">
        <div class="kt-subheader__main">
            <h3 class="kt-subheader__title">
                Visualizar Pagos </h3>
            <span class="kt-subheader__separator kt-subheader__separator--v"></span>
            <div class="kt-subheader__group" id="kt_subheader_search">
                <span class="kt-subheader__desc" id="kt_subheader_total">
                    Visualiza y gestiona sus pagos registrados en sistema </span>
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
                <div class="kt-portlet__head-toolbar">
                    <div class="kt-portlet__head-wrapper">
                        <div class="kt-portlet__head-actions">
                            <a href="addfondos.jsp" class="btn btn-brand btn-elevate btn-icon-sm">
                                <i class="la la-plus"></i>
                                Añadir Fondos
                            </a>
                        </div>
                    </div>
                </div>
            </div>
            <div class="kt-portlet__body">

                <!--begin: Datatable -->
                <table id="tabla_pagoc" class="table table-striped- table-bordered table-hover table-checkable" style="width:100%">
                    <thead>
                        <tr>
                            <th colspan="3">Información de Pago</th>
                            <th colspan="3">Información de Servicio</th>
                            <th colspan="1">Acciones</th>
                        </tr>
                        <tr>
                            <th>Fecha Pago</th>
                            <th>Descripción</th>
                            <th>Valor Pago</th>
                            <th>Nombre Servicio</th>
                            <th>Descripción</th>
                            <th>Estado</th>
                            <th>Voucher</th>
                        </tr>
                    </thead>
                    <tbody>
                        <%  
                            ArrayList<Pago> lista = Pago_DB.obtenerPagoClientes(cod);
                            for (int i = 0; i < lista.size(); i++) {
                            Pago pagos = lista.get(i);
                        %>
                        <tr>
                            <td><%=pagos.getFecha()%></td>
                            <td><%=pagos.getDescripcion() %></td>
                            <td><%=pagos.getMonto() %></td>
                            <td><%=pagos.getServicio().getNombre_servicio()%></td>
                            <td><%=pagos.getServicio().getDescr_servicio()%></td>
                            <td><%=pagos.getServicio().getHab_servicio() %></td>
                            <td> 
                                <a href="voucher.jsp?id=<%=pagos.getId_pago()%>" class="btn btn-sm btn-clean btn-icon btn-icon-md" title="Visualizar Voucher">
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

<%-- include footer --%>
<%@include file="../footer.jsp" %>
