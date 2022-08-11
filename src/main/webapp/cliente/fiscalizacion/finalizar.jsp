<%-- 
    Document   : finalizar
    Created on : 20/06/2020, 08:43:02 PM
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
                Terminar Visita
            </h3>
            <span class="kt-subheader__separator kt-subheader__separator--v"></span>
            <div class="kt-subheader__group" id="kt_subheader_search">
                <span class="kt-subheader__desc" id="kt_subheader_total">
                    Solicita el termino de una correcta visita a terreno. </span>
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
                        Al finalizar en conformidad esta actividad, profesional debera emitir un informe. Este podra ser visualizado en 7 días habiles.  
                        <br>
                        Para mas información u detalles comunicarse con el area de   <a class="kt-link kt-font-bold" href="#" >Call Center</a>.
                    </div>
                </div>
            </div>
        </div>

        <!--begin::Portlet-->
        <div class="kt-portlet">
            <div class="kt-portlet__head">
                <div class="kt-portlet__head-label">
                    <h3 class="kt-portlet__head-title">
                        Finalizar Visita
                    </h3>
                </div>
            </div>

            <!--begin::Form-->
            <form class="kt-form kt-form--fit kt-form--label-right" id="endvf">
                <div class="kt-portlet__body">
                    <div class="form-group row">
                        <label class="col-form-label col-lg-3 col-sm-12"></label>

                        <div class="kt-wizard-v2__content" data-ktwizard-type="step-content">
                            <div class="kt-heading kt-heading--md">Revisa Detalladamente los Datos y Confirma Resultados</div>
                            <div class="kt-form__section kt-form__section--first">
                                <div class="kt-wizard-v4__review">
                                    <div class="kt-wizard-v4__review-item">
                                        <div class="kt-wizard-v4__review-title">
                                            <h5>Datos de Visita</h5>
                                        </div>
                                        <div class="kt-wizard-v4__review-content">
                                            <div>Fecha        : <%=alert.getActividad().getFecha_inicio() %></div>
                                            <div>Nombre       : <%=alert.getActividad().getNombre_actividad() %></div>
                                            <div>Descripción  : <%=alert.getActividad().getDescr_actividad()  %></div>
                                        </div>
                                        <div class="kt-wizard-v4__review-content"></div>
                                        <div class="kt-wizard-v4__review-title">
                                            <h5>Datos de Usuario</h5>
                                        </div>
                                        <div class="kt-wizard-v4__review-content">
                                            <div>Rut     : <%=alert.getActividad().getServicio().getUsuario().getRut_usuario() %></div>
                                            <div>Nombre  : <%=alert.getActividad().getServicio().getUsuario().getNombre_usuario() %></div>
                                            <div>Correo  : <%=alert.getActividad().getServicio().getUsuario().getCorreo_usuario() %> </div>
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
                                    </div>
                                </div>
                            </div>
                        </div> 
                    </div>

                </div>
                <div class="kt-portlet__foot">
                    <div class="kt-form__actions">
                        <div class="row">
                            <div class="col-lg-9 ml-lg-auto">
                                 <input type="hidden" value="<%=alert.getActividad().getServicio().getUsuario().getRut_usuario() %>" id="rut_r" name="rut_r" >
                                 <input type="hidden" value="<%=idalerta %>" id="id_a" name="id_a" >
                                 <input type="hidden" value="<%=alert.getActividad().getId_actividad() %>" id="id_act" name="id_act" >
                                 <input type="hidden" value="<%=alert.getActividad().getServicio().getId_servicio() %>" id="id_serv" name="id_serv" >
                                <button type="submit" data-ktwizard-type="action-submit" class="btn btn-brand">Finalizar Visita</button>
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
