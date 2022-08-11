<%-- 
    Document   : voucher
    Created on : 26/05/2020, 11:06:56 PM
    Author     : lberr
--%>

<%@page import="Clases.Pago"%>
<%@page import="Clases.Pago_DB"%>
<%@page import="Clases.Fondo_DB"%>
<%@page import="Clases.Fondo"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@include file="../header.jsp" %>

<%  
    String codig = (String) session.getAttribute("usuario");
    Fondo f = Fondo_DB.BuscarFondo(codig);
    int m_fondo = f.getMonto_abono();
    
    String ide = request.getParameter("id");
    int id = Integer.parseInt(ide);
    
    Pago pa = Pago_DB.obtenerPagoVoucher(id); 
%>


<div class="kt-grid__item kt-grid__item--fluid kt-grid kt-grid--hor">

    <!-- begin:: Subheader -->
    <div class="kt-subheader   kt-grid__item" id="kt_subheader">
        <div class="kt-subheader__main">
            <h3 class="kt-subheader__title">
                Voucher de Pago</h3>
            <span class="kt-subheader__separator kt-subheader__separator--v"></span>
            <div class="kt-subheader__group" id="kt_subheader_search">
                <span class="kt-subheader__desc" id="kt_subheader_total">
                    Visualiza los voucher de cada pago realizado. </span>
            </div>
        </div>

    </div>

    <!-- end:: Subheader -->

    <!-- begin:: Content -->
    <div class="kt-content  kt-grid__item kt-grid__item--fluid" id="kt_content">
        <div class="row">
            <div class="col">
                <div class="alert alert-light alert-elevate fade show" role="alert">
                    <div class="alert-icon"><i class="flaticon-warning kt-font-brand"></i></div>
                    <div class="alert-text">
                        Para poder continuar con todas las funcionalidades del sistema debe estionar los pagos.
                        <br>
                        Antes de realizar cualquier proceso en sistema debe revisar si posee los fondos suficientes  <a class="kt-link kt-font-bold" href="addfondos.jsp" >Añadir fondos</a>.
                    </div>
                </div>
            </div>
        </div>

        <div class="kt-portlet kt-portlet--mobile">
            <div class="kt-portlet__head kt-portlet__head--lg">
                <div class="kt-portlet__head-label">
                    <span class="kt-portlet__head-icon">
                        <i class="kt-font-brand flaticon2-layers-1"></i>
                    </span>
                    <h3 class="kt-portlet__head-title">
                        Total de Fondos : $ <%=m_fondo%>
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
        </div>

    </div>

    <!-- end:: Content -->

    <!-- begin:: Content -->
    <div class="kt-content  kt-grid__item kt-grid__item--fluid" id="kt_content">

        <div class="row">
            <div class="col-lg-12">
                <div class="kt-portlet">
                    <div class="kt-portlet__body kt-portlet__body--fit">
                        <div class="kt-invoice-2">
                            <div class="kt-invoice__wrapper">
                                <div class="kt-invoice__head">
                                    <div class="kt-invoice__container kt-invoice__container--centered">
                                        <div class="kt-invoice__logo">
                                            <a href="#">
                                                <h1>Resumen de Pago</h1>
                                            </a>
                                            <a href="#">
                                                <img src="http://localhost:8080/nomasac/assets/media/logos/logo.png">
                                            </a>
                                        </div>
                                        <span class="kt-invoice__desc">
                                            <span>No mas accidentes</span>
                                            <span>Empresa dedicada a la prevención de riesgos</span>
                                        </span>

                                    </div>
                                </div>
                                <div class="kt-invoice__body kt-invoice__body--centered">
                                    <div class="table-responsive">
                                        <table class="table">
                                            <thead>
                                                <tr>
                                                    <th>Descripción</th>
                                                    <th>Fecha de Pago</th>
                                                    <th></th>
                                                    <th>Monto Cancelado</th>
                                                </tr>
                                            </thead>
                                            <tbody>
                                                <tr>
                                                    <td><%=pa.getDescripcion()%></td>
                                                    <td><%=pa.getFecha() %></td>
                                                    <td></td>
                                                    <td class="kt-font-danger"><%=pa.getMonto()%></td>
                                                </tr>
                                            </tbody>
                                        </table>
                                    </div>

                                    <div class="kt-invoice__table  kt-invoice__table--centered table-responsive">
                                        <table class="table">
                                            <thead>
                                                <tr>
                                                    <th></th>
                                                    <th></th>
                                                    <th></th>
                                                    <th>Total Cancelado</th>
                                                </tr>
                                            </thead>
                                            <tbody>
                                                <tr>
                                                    <td></td>
                                                    <td></td>
                                                    <td></td>
                                                    <td class="kt-font-danger"><%=pa.getMonto() %></td>
                                                </tr>
                                            </tbody>
                                        </table>
                                    </div>
                                </div>

                                <div class="kt-invoice__footer">
                                    
                                </div>                
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>

    </div>

    <!-- end:: Content -->
</div>


<%-- include footer --%>
<%@include file="../footer.jsp" %>