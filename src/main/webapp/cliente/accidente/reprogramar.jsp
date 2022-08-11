<%-- 
    Document   : reprogramar
    Created on : 20/06/2020, 03:42:10 PM
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
                Reprogramar Visita
            </h3>
            <span class="kt-subheader__separator kt-subheader__separator--v"></span>
            <div class="kt-subheader__group" id="kt_subheader_search">
                <span class="kt-subheader__desc" id="kt_subheader_total">
                    Reprograma una visita creada para tu empresa. </span>
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
                        Toda reprogramación sera avisada por correo electronico . Al ser un caso especial se podra reprogramar las veces necesarias para aliviar el suceso.
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
                <div class="kt-grid  kt-wizard-v2 kt-wizard-v2--white" id="kt_wizard_v20" data-ktwizard-state="step-first">
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
                                                Datos de Visita
                                            </div>
                                            <div class="kt-wizard-v2__nav-label-desc">
                                                Ingresa la nueva fecha para la creación de una visita.
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
                                                Revisa y reprograma visita en sistema
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
                        <form class="kt-form" id="visitacc_rform">

                            <!--begin: Form Wizard Step 1-->
                            <div class="kt-wizard-v2__content" data-ktwizard-type="step-content" data-ktwizard-state="current">
                                <div class="kt-heading kt-heading--md">Ingresa los datos para la creación de una nueva visita.</div>
                                <div class="kt-form__section kt-form__section--first">
                                    <div class="kt-wizard-v2__form">

                                        <div class="form-group">
                                            <label>Descripción de visita</label>
                                            <input type="text" class="form-control" disabled name="desca" value="<%=alert.getActividad().getDescr_actividad()%>" id="desca" placeholder="Descripción" >  
                                        </div>

                                        <div class="form-group">
                                            <label>Fecha acutal de visita</label>
                                            <div class="input-group date">
                                                <input type="text" class="form-control" disabled value="<%=alert.getActividad().getFecha_inicio()%>" placeholder="Seleccionar Fecha" name="kt_datepicker_1" id="kt_datepicker_1" />
                                                <div class="input-group-append">
                                                    <span class="input-group-text">
                                                        <i class="la la-calendar-check-o"></i>
                                                    </span>
                                                </div>
                                            </div>
                                        </div>  

                                        <div class="kt-heading kt-heading--md">Reprograma la visita</div>

                                        <div class="form-group">
                                            <label>Selecciona la nueva fecha</label>
                                            <div class="input-group date">
                                                <input type="text" onchange="resumen()" class="form-control" readonly placeholder="Seleccionar Fecha" name="kt_datepicker_2" id="kt_datepicker_2" />
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
                                                <h5>Datos de Visita</h5>
                                            </div>
                                            <div class="kt-wizard-v4__review-content">
                                                <div>Fecha Anterior : <%=alert.getActividad().getFecha_inicio()%></div>
                                                <div id="res_date" > </div>
                                                <div>Nombre       : <%=alert.getActividad().getNombre_actividad()%></div>
                                                <div>Descripción  : <%=alert.getActividad().getDescr_actividad() %></div>
                                            </div>
                                            <div class="kt-wizard-v4__review-content"></div>
                                            <div class="kt-wizard-v4__review-title">
                                                <h5>Datos de Usuario</h5>
                                            </div>
                                            <div class="kt-wizard-v4__review-content">
                                                <div>Rut     : <%=alert.getActividad().getServicio().getUsuario().getRut_usuario()%></div>
                                                <div>Nombre  : <%=alert.getActividad().getServicio().getUsuario().getNombre_usuario()%></div>
                                                <div>Correo  : <%=alert.getActividad().getServicio().getUsuario().getCorreo_usuario()%> </div>
                                            </div> 
                                            <div class="kt-wizard-v4__review-content"></div>
                                            <div class="kt-wizard-v4__review-title">
                                                <h5>Datos de Empresa</h5>
                                            </div>
                                            <div class="kt-wizard-v4__review-content">
                                                <div>Telefono       :<%=alert.getActividad().getServicio().getUsuario().getEmpresa().getTelefono() %></div>
                                                <div>Razon Social  :<%=alert.getActividad().getServicio().getUsuario().getEmpresa().getRazon_social()%></div>
                                                <div>Dirección     :<%=alert.getActividad().getServicio().getUsuario().getEmpresa().getDireccion()%> </div>
                                            </div>
                                            <input type="hidden" value="<%=alert.getActividad().getServicio().getUsuario().getRut_usuario() %>" id="rut_r" name="rut_r" >
                                             <input type="hidden" value="<%=alert.getActividad().getId_actividad() %>" id="id_act" name="id_act" >
                                            <input type="hidden" value="<%=alert.getActividad().getServicio().getId_servicio() %>" id="id_serv" name="id_serv" >

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
        var au = document.getElementById("kt_datepicker_2").value;
        document.getElementById("res_date").innerHTML = "Fecha Reprogramada : " + au;
    }
</script>

<%-- include footer --%>
<%@include file="../footer.jsp" %>
