<%-- 
    Document   : cancelar
    Created on : 3/07/2020, 10:38:07 PM
    Author     : lberr
--%>

<%@page import="Clases.Actividad"%>
<%@page import="Clases.Actividad_DB"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@include file="../header.jsp" %>

<%      
    String id = request.getParameter("id");
    int ida;
    ida = Integer.parseInt(id);
    
    Actividad acti = Actividad_DB.BuscarActividadC(ida);
    Usuario user = Usuario_DB.BuscarUsuarioRut(acti.getServicio().getUsuario().getRut_usuario());
    
%>


<div class="kt-grid__item kt-grid__item--fluid kt-grid kt-grid--hor">

    <!-- begin:: Subheader -->
    <div class="kt-subheader   kt-grid__item" id="kt_subheader">
        <div class="kt-subheader__main">
            <h3 class="kt-subheader__title">
                Cancelar Capacitación
            </h3>
            <span class="kt-subheader__separator kt-subheader__separator--v"></span>
            <div class="kt-subheader__group" id="kt_subheader_search">
                <span class="kt-subheader__desc" id="kt_subheader_total">
                    Solicita la cancelación de una capacitación a terreno. </span>
            </div>
        </div>
        <div class="kt-subheader__toolbar">
            <a href="../capacitacion/" class="btn btn-default btn-bold">
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
                        Al cancelar esta actividad, no tendra derecho a reactivar la visita. Se contara como actividad "realizada".  
                        <br>
                        Para mas información realizar la revisión de  <a class="kt-link kt-font-bold" href="#" >Terminos y condiciones</a>.
                    </div>
                </div>
            </div>
        </div>

        <!--begin::Portlet-->
        <div class="kt-portlet">
            <div class="kt-portlet__head">
                <div class="kt-portlet__head-label">
                    <h3 class="kt-portlet__head-title">
                        Cancelar Capacitación
                    </h3>
                </div>
            </div>

            <!--begin::Form-->
            <form class="kt-form kt-form--fit kt-form--label-right" id="cancelcapaccli">
                <div class="kt-portlet__body">
                    <div class="form-group row">
                        <label class="col-form-label col-lg-3 col-sm-12"></label>

                        <div class="kt-wizard-v2__content" data-ktwizard-type="step-content">
                            <div class="kt-heading kt-heading--md">Revisa Detalladamente los Datos y Confirma Resultados</div>
                            <div class="kt-form__section kt-form__section--first">
                                <div class="kt-wizard-v4__review">
                                    <div class="kt-wizard-v4__review-item">
                                        <div class="kt-wizard-v4__review-title">
                                            <h5>Datos de Capacitación</h5>
                                        </div>
                                        <div class="kt-wizard-v4__review-content">
                                            <div>Fecha Visita : <%=acti.getFecha_inicio()%></div>
                                            <div>Nombre       : <%=acti.getNombre_actividad()  %></div>
                                            <div>Descripción  : <%=acti.getDescr_actividad()  %></div>
                                        </div>
                                        <div class="kt-wizard-v4__review-content"></div>
                                        <div class="kt-wizard-v4__review-title">
                                            <h5>Datos de Usuario</h5>
                                        </div>
                                        <div class="kt-wizard-v4__review-content">
                                            <div>Rut     : <%=acti.getServicio().getUsuario().getRut_usuario()%></div>
                                            <div>Nombre  : <%=user.getNombre_usuario() %></div>
                                            <div>Correo  : <%=user.getCorreo_usuario() %> </div>
                                        </div> 
                                        <div class="kt-wizard-v4__review-content"></div>
                                        <div class="kt-wizard-v4__review-title">
                                            <h5>Datos de Empresa</h5>
                                        </div>
                                        <div class="kt-wizard-v4__review-content">
                                            <div>Telefono       :<%=user.getEmpresa().getTelefono() %></div>
                                            <div>Razon Social  :<%=user.getEmpresa().getRazon_social() %></div>
                                            <div>Dirección     :<%=user.getEmpresa().getDireccion() %> </div>
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
                                <input type="hidden" value="<%=acti.getServicio().getUsuario().getRut_usuario() %>" id="rut_r" name="rut_r" >
                                <input type="hidden" value="<%=ida %>" id="id_a" name="id_a" >
                                <input type="hidden" value="<%=acti.getServicio().getId_servicio() %>" id="id_s" name="id_s" >
                                <button type="submit" data-ktwizard-type="action-submit" class="btn btn-brand">Cancelar Capacitación</button>
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
