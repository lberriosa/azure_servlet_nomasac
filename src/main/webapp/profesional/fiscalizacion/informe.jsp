<%-- 
    Document   : informe
    Created on : 20/06/2020, 11:52:47 PM
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
                Ingresar Reporte
            </h3>
            <span class="kt-subheader__separator kt-subheader__separator--v"></span>
            <div class="kt-subheader__group" id="kt_subheader_search">
                <span class="kt-subheader__desc" id="kt_subheader_total">
                    Ingrese reporte correspondiente a la visita realizada. </span>
            </div>
        </div>
        <div class="kt-subheader__toolbar">
            <a href="../fiscalizacion/" class="btn btn-default btn-bold">
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
                        Al ingresar reporte verifique los datos, ya que seran visibles de inmediato para el cliente.  
                        <br>
                        En caso de equivocación comunicarse con un <a class="kt-link kt-font-bold" href="#" >Administrador</a>.
                    </div>
                </div>
            </div>
        </div>

        <!--begin::Portlet-->
        <div class="kt-portlet">


            <!--begin::Form-->
            <form class="kt-form" id="reporteafform" enctype="multipart/form-data">
                <div class="kt-portlet__body">
                    <div class="kt-section kt-section--first">
                        <div class="kt-section__body">
                            <div class="alert alert-text alert-bold fade show kt-margin-t-20 kt-margin-b-40" role="alert">
                                <div class="alert-icon"><i class="fas fa-info-circle"></i></div>
                                <div class="alert-text">Al ingresar Reporte ya no podra reintentar operación en sistema.  </div>
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
                                            <label>Buscar Checklist</label>
                                            <div></div>
                                            <div class="custom-file">
                                                <input type="file" class="custom-file-input" accept="application/pdf, application/vnd.ms-excel" name="file" id="file">
                                                <label class="custom-file-label" for="customFile">Buscar Checklist</label>
                                            </div>
                                        </div>

                                        <div class="form-group">
                                            <label>Descripción de Informe</label>
                                            <input type="text" class="form-control" name="descc" id="descc" placeholder="Descripción" >
                                            <span class="form-text text-muted">Ingrese alguna observación acerca del reporte.</span>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                  <input type="hidden" value="<%=alert.getActividad().getServicio().getUsuario().getRut_usuario() %>" id="rut_r" name="rut_r" >
                  <input type="hidden" value="<%=alert.getActividad().getId_actividad() %>" id="id_a" name="id_a" >

                <div class="kt-portlet__foot">
                    <div class="kt-form__actions">
                        <div class="row">
                            <div class="col-lg-3 col-xl-3">
                            </div>
                            <div class="col-lg-9 col-xl-9">
                                <button id="kt_form_ingresar_repof" type="submit"  class="btn btn-brand btn-bold">Ingresar Reporte</button>&nbsp;
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
