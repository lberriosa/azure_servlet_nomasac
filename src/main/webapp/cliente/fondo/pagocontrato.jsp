<%-- 
    Document   : pagocontrato
    Created on : 17/05/2020, 11:35:25 PM
    Author     : lberr
--%>

<%@page import="Clases.Fondo"%>
<%@page import="Clases.Fondo_DB"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@include file="../header.jsp" %>

<%    String codig = (String) session.getAttribute("usuario");
    Fondo f = Fondo_DB.BuscarFondoContrato(codig);
    int m_fondo = f.getMonto_abono();
    int m_pagoc = f.getContrato().getMonto_contrato();
    String desc = "Servicio Anual Contractual Con Empresa 'No mas Accidentes'";

%>

<div class="kt-grid__item kt-grid__item--fluid kt-grid kt-grid--hor">

    <!-- begin:: Subheader -->
    <div class="kt-subheader   kt-grid__item" id="kt_subheader">
        <div class="kt-subheader__main">
            <h3 class="kt-subheader__title">
                Pago de Contrato</h3>
            <span class="kt-subheader__separator kt-subheader__separator--v"></span>
            <div class="kt-subheader__group" id="kt_subheader_search">
                <span class="kt-subheader__desc" id="kt_subheader_total">
                    Gestiona el pago inicial por el servicio anual de tu contrato. </span>
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
                        Para poder acceder a todas las funcionalidades del sistema es necesario una aceptación y pago previo correspondiente a gastos anuales.
                        <br>
                        Antes de realizar el pago debe revisar si posee los fondos suficientes  <a class="kt-link kt-font-bold" href="addfondos.jsp" >Añadir fondos</a>.
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
                                                    <th></th>
                                                    <th></th>
                                                    <th>Monto a cancelar</th>
                                                </tr>
                                            </thead>
                                            <tbody>
                                                <tr>
                                                    <td><%=desc%></td>
                                                    <td></td>
                                                    <td></td>
                                                    <td class="kt-font-danger"><%=m_pagoc%></td>
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
                                                    <th>Total a Pagar</th>
                                                </tr>
                                            </thead>
                                            <tbody>
                                                <tr>
                                                    <td></td>
                                                    <td></td>
                                                    <td></td>
                                                    <td class="kt-font-danger"><%=m_pagoc%></td>
                                                </tr>
                                            </tbody>
                                        </table>
                                    </div>
                                </div>

                                <div class="kt-invoice__footer">
                                    <form class="kt-form kt-form--fit kt-form--label-right" id="pagarc">
                                        <input type="hidden" value="<%=m_pagoc%>" id="monto_p" name="monto_p" >
                                        <input type="hidden" value="<%=codig%>" id="rut_r" name="rut_r" >
                                        <input type="hidden" value="<%=desc%>" id="desc_p" name="desc_p" >
                                        
                                        <div class="col-lg-9 col-xl-9">
                                            <button type="submit" style="font-size: 15px; margin: -27px; " id="kt_form_pago_contrato" class="btn btn-success pull-right">Realizar Pago</button>&nbsp;                                    
                                        </div>
                                    </form>
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
