<%-- 
    Document   : vpagosp
    Created on : 3/06/2020, 07:00:26 PM
    Author     : lberr
--%>

<%@page import="Clases.Servicio"%>
<%@page import="Clases.Servicio_DB"%>
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
                Visualizar Pagos Pendientes </h3>
            <span class="kt-subheader__separator kt-subheader__separator--v"></span>
            <div class="kt-subheader__group" id="kt_subheader_search">
                <span class="kt-subheader__desc" id="kt_subheader_total">
                    Visualiza y gestiona sus pagos pendientes en sistema </span>
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
                        Visualizar Pagos Pendientes
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
                <table id="tabla_pagope" class="table table-striped- table-bordered table-hover table-checkable" style="width:100%">
                    <thead>
                        <tr>
                            <th colspan="5">Información de Servicio</th>
                            <th colspan="1">Acciones</th>
                        </tr>
                        <tr>
                            <th>Nombre</th>
                            <th>Descripción</th>
                            <th>Fecha Inicio</th>
                            <th>Fecha Termino</th>
                            <th>Valor a Cancelar (CLP)</th>
                            <th>Realizar Pago</th>
                        </tr>
                    </thead>
                    <tbody>
                        <%  
                            ArrayList<Servicio> lista = Servicio_DB.obtenerServiciosPxUsuario(cod);
                            for (int i = 0; i < lista.size(); i++) {
                            Servicio servicios = lista.get(i);
                        %>
                        <tr>
                            <td><%=servicios.getNombre_servicio() %></td>
                            <td><%=servicios.getDescr_servicio() %></td>
                            <td><%=servicios.getFecha_inicio() %></td>
                            <td><%=servicios.getFecha_termino() %></td>
                            <td><%=servicios.getValor_servicio() %></td>
                            <td> 
                                <a href="pago.jsp?id=<%=servicios.getId_servicio()%>" class="btn btn-sm btn-clean btn-icon btn-icon-md" title="Realizar Pago">
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