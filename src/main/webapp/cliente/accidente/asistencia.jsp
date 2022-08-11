<%-- 
    Document   : asistencia
    Created on : 20/06/2020, 03:41:50 PM
    Author     : lberr
--%>

<%@page import="Clases.Alerta"%>
<%@page import="Clases.Alerta_DB"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@include file="../header.jsp" %>
<%    
    String id = request.getParameter("id");
    int idalerta;
    idalerta = Integer.parseInt(id);

    Alerta alert = Alerta_DB.buscarAlertaID(idalerta);
%>

<div class="kt-grid__item kt-grid__item--fluid kt-grid kt-grid--hor">

    <!-- begin:: Subheader -->
    <div class="kt-subheader   kt-grid__item" id="kt_subheader">
        <div class="kt-subheader__main">
            <h3 class="kt-subheader__title">
                Marcar Asistencia
            </h3>
            <span class="kt-subheader__separator kt-subheader__separator--v"></span>
            <div class="kt-subheader__group" id="kt_subheader_search">
                <span class="kt-subheader__desc" id="kt_subheader_total">
                    Marca la asistencia/inasistencia de una actividad presencial. </span>
            </div>
        </div>
        <div class="kt-subheader__toolbar">
            <a href="../accidente/" class="btn btn-default btn-bold">
                Volver </a>
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
                        Si marca inasistencia actividad sera cancelada  
                        <br>
                        Para mas información realizar la revisión de  <a class="kt-link kt-font-bold" href="#" >Terminos y condiciones</a>.
                    </div>
                </div>
            </div>
        </div>

        <!--begin::Portlet-->
        <div class="kt-portlet">


            <!--begin::Form-->
            <form class="kt-form" id="asistenciac_al">
                <div class="kt-portlet__body">
                    <div class="kt-section kt-section--first">
                        <div class="kt-section__body">
                            <div class="alert alert-text alert-bold fade show kt-margin-t-20 kt-margin-b-40" role="alert">
                                <div class="alert-icon"><i class="fas fa-info-circle"></i></div>
                                <div class="alert-text">Al momento de marcar asistencia/inasistencia ya no podra reintentar operación en sistema.  </div>
                                <div class="alert-close">
                                    <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                                        <span aria-hidden="true"><i class="la la-close"></i></span>
                                    </button>
                                </div>
                            </div>
                            <div class="form-group form-group-marginless">
                                <label>Selecciona :</label>
                                <div class="row">
                                    <div class="col-lg-6">
                                        <label class="kt-option">
                                            <span class="kt-option__control">
                                                <span class="kt-radio kt-radio--check-bold">
                                                    <input type="radio" class="asistencia_pro" id="asistencia_pro" name="asistencia_pro" value="1" checked>

                                                    <span></span>
                                                </span>
                                            </span>
                                            <span class="kt-option__label">
                                                <span class="kt-option__head">
                                                    <span class="kt-option__title">
                                                        Marcar Asistencia
                                                    </span>
                                                    <span class="kt-option__focus">
                                                        -
                                                    </span>
                                                </span>
                                                <span class="kt-option__body">
                                                    Profesional asiste a realizar la visita
                                                    correspondiente a empresa en el dia estipulado. 
                                                </span>
                                            </span>
                                        </label>
                                    </div>

                                    <div class="col-lg-6">
                                        <label class="kt-option">
                                            <span class="kt-option__control">
                                                <span class="kt-radio kt-radio--check-bold">
                                                    <input type="radio" class="asistencia_pro" id="asistencia_pro" name="asistencia_pro" value="2">

                                                    <span></span>
                                                </span>
                                            </span>
                                            <span class="kt-option__label">
                                                <span class="kt-option__head">
                                                    <span class="kt-option__title">
                                                        Marcar Inasistencia
                                                    </span>
                                                    <span class="kt-option__focus">
                                                        -
                                                    </span>
                                                </span>
                                                <span class="kt-option__body">
                                                    Profesional no se presenta a realizar evaluación a empresa.
                                                </span>
                                            </span>
                                        </label>
                                    </div>

                                </div>
                            </div>

                            <!--begin: Form Wizard Step 1-->
                            <div class="kt-wizard-v2__content" data-ktwizard-type="step-content" data-ktwizard-state="current">
                                <div class="kt-heading kt-heading--md"></div>
                                <div class="kt-form__section kt-form__section--first">
                                    <div class="kt-wizard-v2__form">
                                        <div class="form-group">
                                            <label>Descripción de asistencia</label>
                                            <input type="text" class="form-control" name="descp" id="descp" placeholder="Descripción" >
                                            <span class="form-text text-muted">Ingrese alguna observación acerca de la asistencia del profesional.</span>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <input type="hidden" value="<%=alert.getActividad().getServicio().getUsuario().getRut_usuario()%>" id="rut_r" name="rut_r" >
                <input type="hidden" value="<%=idalerta %>" id="id_a" name="id_a" >
                <input type="hidden" value="<%=alert.getActividad().getId_actividad()%>" id="id_act" name="id_act" >
                <input type="hidden" value="<%=alert.getActividad().getServicio().getId_servicio()%>" id="id_serv" name="id_serv" >
                <div class="kt-portlet__foot">
                    <div class="kt-form__actions">
                        <div class="row">
                            <div class="col-lg-3 col-xl-3">
                            </div>
                            <div class="col-lg-9 col-xl-9">
                                <button id="kt_form_mark_asistencia_al" type="submit"  class="btn btn-brand btn-bold">Marcar Asistencia</button>&nbsp;
                            </div>
                        </div>
                    </div>
                </div>
            </form>

            <!--end::Form-->
        </div>
        <!--end::Portlet-->
    </div>
    <!-- end:: Content -->




</div>
<%-- include footer --%>
<%@include file="../footer.jsp" %>