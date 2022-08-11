<%-- 
    Document   : crear
    Created on : 3/07/2020, 12:10:44 AM
    Author     : lberr
--%>

<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<%@include file="../header.jsp" %>

<div class="kt-grid__item kt-grid__item--fluid kt-grid kt-grid--hor">

    <!-- begin:: Subheader -->
    <div class="kt-subheader   kt-grid__item" id="kt_subheader">
        <div class="kt-subheader__main">
            <h3 class="kt-subheader__title">
                Nueva Capacitación
            </h3>
            <span class="kt-subheader__separator kt-subheader__separator--v"></span>
            <div class="kt-subheader__group" id="kt_subheader_search">
                <span class="kt-subheader__desc" id="kt_subheader_total">
                    Genera la creación de una capacitación a la empresa de un cliente activo en sistema. </span>
            </div>
        </div>
        <div class="kt-subheader__toolbar">
            <a href="../dashboard/" class="btn btn-default btn-bold">
                Cancelar </a>
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
                        Cliente solo debe tener una capacitación al mes y debe ser programada con 15 dias de anticipación. Estas no deben intervenir una actividad ya creada.
                        <br>
                        Para mas información realizar la revisión de  <a class="kt-link kt-font-bold" href="#" >Terminos y condiciones</a>.
                    </div>
                </div>
            </div>
        </div>

        <!--begin::Portlet-->
        <!-- begin:: Content -->

        <div class="kt-portlet">
            <div class="kt-portlet__body kt-portlet__body--fit">
                <div class="kt-grid  kt-wizard-v2 kt-wizard-v2--white" id="kt_wizard_v40" data-ktwizard-state="step-first">
                    <div class="kt-grid__item kt-wizard-v2__aside">

                        <!--begin: Form Wizard Nav -->
                        <div class="kt-wizard-v2__nav">
                            <div class="kt-wizard-v2__nav-items">
                                <a class="kt-wizard-v2__nav-item" href="#" data-ktwizard-type="step" data-ktwizard-state="current">
                                    <div class="kt-wizard-v2__nav-body">
                                        <div class="kt-wizard-v2__nav-icon">
                                            <i class="flaticon-globe"></i>
                                        </div>
                                        <div class="kt-wizard-v2__nav-label">
                                            <div class="kt-wizard-v2__nav-label-title">
                                                Datos de Capacitación
                                            </div>
                                            <div class="kt-wizard-v2__nav-label-desc">
                                                Ingresa los datos para la creación de una capacitación.
                                            </div>
                                        </div>
                                    </div>
                                </a>

                                <a class="kt-wizard-v2__nav-item" href="#" data-ktwizard-type="step">
                                    <div class="kt-wizard-v2__nav-body">
                                        <div class="kt-wizard-v2__nav-icon">
                                            <i class="flaticon-confetti"></i>
                                        </div>
                                        <div class="kt-wizard-v2__nav-label">
                                            <div class="kt-wizard-v2__nav-label-title">
                                                Completado!
                                            </div>
                                            <div class="kt-wizard-v2__nav-label-desc">
                                                Revisa e ingresa visita en sistema
                                            </div>
                                        </div>
                                    </div>
                                </a>
                            </div>
                        </div>

                        <!--end: Form Wizard Nav -->
                    </div>
                    <div class="kt-grid__item kt-grid__item--fluid kt-wizard-v2__wrapper">

                        <!--begin: Form Wizard Form-->
                        <form class="kt-form" id="capaci_form">

                            <!--begin: Form Wizard Step 1-->
                            <div class="kt-wizard-v2__content" data-ktwizard-type="step-content" data-ktwizard-state="current">
                                <div class="kt-heading kt-heading--md">Ingresa los datos para la creación de una nueva capacitación.</div>
                                <div class="kt-form__section kt-form__section--first">
                                    <div class="kt-wizard-v2__form">
                                        <div class="form-group">
                                            <label>Selecciona Cliente</label>
                                            <select onchange="resumen()" class="form-control kt-select2" id="kt_select2_1" name="kt_select2_1">
                                                <option value="">Seleccione Cliente</option> 
                                                <%                                                    
                                                    ArrayList<Usuario> lista = Usuario_DB.obtenerUsuarioConContrato();
                                                    for (int i = 0; i < lista.size(); i++) {
                                                        Usuario usuario = lista.get(i);
                                                %>
                                                <option value="<%=usuario.getRut_usuario()%>"><%=usuario.getRut_usuario() + " | " + usuario.getNombre_usuario() + ' ' + usuario.getApellido_usuario()%></option> 
                                                <%
                                                    }
                                                %>
                                            </select>
                                            <span class="form-text text-muted">Selecciona un cliente activo en sistema.</span>
                                        </div>
                                        <div class="form-group">
                                            <label>Descripción de capacitación</label>
                                            <input type="text" oninput="resumen()" class="form-control" name="desca" id="desca" placeholder="Descripción" >
                                            <span class="form-text text-muted">Ingresa motivo u descripción de capacitación.</span>
                                        </div>

                                        <div class="form-group">
                                            <label>Fecha de Visita</label>
                                            <div class="input-group date">
                                                <input type="text" onchange="resumen()" class="form-control" readonly placeholder="Seleccionar Fecha" name="kt_datepicker_9" id="kt_datepicker_9" />
                                                <div class="input-group-append">
                                                    <span class="input-group-text">
                                                        <i class="la la-calendar-check-o"></i>
                                                    </span>
                                                </div>
                                            </div>
                                        </div>  


                                    </div>
                                </div>
                            </div>

                            <!--end: Form Wizard Step 1-->


                            <!--begin: Form Wizard Step 2-->
                            <div class="kt-wizard-v2__content" data-ktwizard-type="step-content">
                                <div class="kt-heading kt-heading--md">Revisa Detalladamente y Confirma Resultados</div>
                                <div class="kt-form__section kt-form__section--first">
                                    <div class="kt-wizard-v4__review">
                                        <div class="kt-wizard-v4__review-item">
                                            <div class="kt-wizard-v4__review-title">
                                                Datos de Capacitación
                                            </div>
                                            <div class="kt-wizard-v4__review-content">
                                                <div id="res_rut" > </div>
                                                <div id="res_desc" > </div>
                                                <div id="res_date" > </div>
                                            </div> 
                                        </div>
                                    </div>
                                </div>
                            </div>

                            <!--end: Form Wizard Step 2-->

                            <!--begin: Form Actions -->
                            <div class="kt-form__actions">
                                <div class="btn btn-secondary btn-md btn-tall btn-wide kt-font-bold kt-font-transform-u" data-ktwizard-type="action-prev">
                                    Anterior
                                </div>
                                <div class="btn btn-success btn-md btn-tall btn-wide kt-font-bold kt-font-transform-u" data-ktwizard-type="action-submit">
                                    Confirmar
                                </div>
                                <div class="btn btn-brand btn-md btn-tall btn-wide kt-font-bold kt-font-transform-u" data-ktwizard-type="action-next">
                                    Siguiente
                                </div>
                            </div>

                            <!--end: Form Actions -->
                        </form>

                        <!--end: Form Wizard Form-->
                    </div>
                </div>
            </div>
        </div>


        <!-- end:: Content -->



        <!--end::Portlet-->
    </div>
    <!-- end:: Content -->

</div>

<script>
    function resumen() {
        // DATOS USUARIO
        var ru = document.getElementById("kt_select2_1").value;
        document.getElementById("res_rut").innerHTML = "Rut de Cliente : " + ru;

        var nu = document.getElementById("desca").value;
        document.getElementById("res_desc").innerHTML = "Descripción de Visita : " + nu;

        var au = document.getElementById("kt_datepicker_9").value;
        document.getElementById("res_date").innerHTML = "Fecha Agendada : " + au;

    }
</script>




<%@include file="../footer.jsp" %>
