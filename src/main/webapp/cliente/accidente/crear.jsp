<%-- 
    Document   : crear
    Created on : 17/06/2020, 09:37:06 PM
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
                Informar Accidente
            </h3>
            <span class="kt-subheader__separator kt-subheader__separator--v"></span>
            <div class="kt-subheader__group" id="kt_subheader_search">
                <span class="kt-subheader__desc" id="kt_subheader_total">
                    Informa un suceso de un accidente ocurrido en empresa. </span>
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
                        Esta acción tiene un maximo de 10 veces que son sumadas en conjunto con los informes de fiscalización. 
                        <br>
                        Para mas información realizar la revisión de  <a class="kt-link kt-font-bold" href="#" >Terminos y condiciones</a>.
                    </div>
                </div>
            </div>
        </div>

        <!--begin::Portlet-->
        <div class="kt-portlet">


            <!--begin::Form-->
            <form class="kt-form" id="crea_acci">
                <div class="kt-portlet__body">
                    <div class="kt-section kt-section--first">
                        <div class="kt-section__body">
                            <div class="alert alert-text alert-bold fade show kt-margin-t-20 kt-margin-b-40" role="alert">
                                <div class="alert-icon"><i class="fas fa-info-circle"></i></div>
                                <div class="alert-text">Al momento de informar accidente, supervisores tomaran el caso y generaran visita y evaluación a terreno. Si fecha no es conveniente tendra la posibilidad de realizar una reprogramación.</div>
                                <div class="alert-close">
                                    <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                                        <span aria-hidden="true"><i class="la la-close"></i></span>
                                    </button>
                                </div>
                            </div>


                            <!--begin: Form Wizard Step 1-->
                            <div class="kt-wizard-v2__content" data-ktwizard-type="step-content" data-ktwizard-state="current">
                                <div class="kt-heading kt-heading--md"></div>
                                <div class="kt-form__section kt-form__section--first">
                                    <div class="kt-wizard-v2__form">
                                        <div class="form-group">
                                            <label>Descripción de accidente</label>
                                            <input type="text" class="form-control" name="desca" id="desca" placeholder="Descripción" >
                                            <span class="form-text text-muted">Ingrese alguna observación acerca del accidente ocurrido.</span>
                                        </div>
                                    </div>
                                </div>
                            </div>

                            <div class="form-group">
                                <label>Selecciona la fecha del suceso</label>
                                <div class="input-group date">
                                    <input type="text" class="form-control" readonly placeholder="Seleccionar Fecha" name="kt_datepicker_7" id="kt_datepicker_7" />    
                                    <div class="input-group-append">
                                        <span class="input-group-text">
                                            <i class="la la-calendar-check-o"></i>
                                        </span>
                                    </div>
                                </div>
                                <span class="form-text text-muted">Solo podra seleccionar una fecha entre 3 semanas previas al dia de hoy.</span>
                            </div>  

                        </div>
                    </div>
                </div>
                <input type="hidden" value="<%=codigo %>" id="rut_r" name="rut_r" >
                <div class="kt-portlet__foot">
                    <div class="kt-form__actions">
                        <div class="row">
                            <div class="col-lg-3 col-xl-3">
                            </div>
                            <div class="col-lg-9 col-xl-9">
                                <button id="kt_form_mark_accidente" type="submit"  class="btn btn-brand btn-bold">Informar Accidente</button>&nbsp;
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
