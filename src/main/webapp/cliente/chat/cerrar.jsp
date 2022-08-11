<%-- 
    Document   : cerrar
    Created on : 2/07/2020, 09:39:56 PM
    Author     : lberr
--%>

<%@page import="Clases.Interaccion"%>
<%@page import="Clases.Interaccion_DB"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<%@include file="../header.jsp" %>
<%      
    String id = request.getParameter("id");
    int ida;
    ida = Integer.parseInt(id);
    
    Interaccion ini = Interaccion_DB.ObtenerInfoChatC(ida);
    
%>


<div class="kt-grid__item kt-grid__item--fluid kt-grid kt-grid--hor">

    <!-- begin:: Subheader -->
    <div class="kt-subheader   kt-grid__item" id="kt_subheader">
        <div class="kt-subheader__main">
            <h3 class="kt-subheader__title">
                Cerrar chat
            </h3>
            <span class="kt-subheader__separator kt-subheader__separator--v"></span>
            <div class="kt-subheader__group" id="kt_subheader_search">
                <span class="kt-subheader__desc" id="kt_subheader_total">
                    Genera el correcto cierre a los chats generados. </span>
            </div>
        </div>
        <div class="kt-subheader__toolbar">
            <a href="../chat/historico.jsp" class="btn btn-default btn-bold">
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
                        Al cerrar chat, queda en conformidad la resolución por parte del profesional. 
                        <br>
                        Cada 30 días se realizara una limpieza manual por parte de un <a class="kt-link kt-font-bold" href="#" >Administrador</a>.
                    </div>
                </div>
            </div>
        </div>

        <!--begin::Portlet-->
        <div class="kt-portlet">
            <div class="kt-portlet__head">
                <div class="kt-portlet__head-label">
                    <h3 class="kt-portlet__head-title">
                        Cerrar chat
                    </h3>
                </div>
            </div>

            <!--begin::Form-->
            <form class="kt-form kt-form--fit kt-form--label-right" id="cierra_chat">
                <div class="kt-portlet__body">
                    <div class="form-group row">
                        <label class="col-form-label col-lg-3 col-sm-12"></label>

                        <div class="kt-wizard-v2__content" data-ktwizard-type="step-content">
                            <div class="kt-heading kt-heading--md">Revisa Detalladamente los Datos y Confirma Resultados</div>
                            <div class="kt-form__section kt-form__section--first">
                                <div class="kt-wizard-v4__review">
                                    <div class="kt-wizard-v4__review-item">
                                        <div class="kt-wizard-v4__review-title">
                                            <h5>Dato de Chat</h5>
                                        </div>
                                        <div class="kt-wizard-v4__review-content">
                                            <div>Fecha Interacción : <%=ini.getFecha_interaccion() %></div>
                                        </div>
                                        <div class="kt-wizard-v4__review-content"></div>
                                        <div class="kt-wizard-v4__review-title">
                                            <h5>Datos de Profesional</h5>
                                        </div>
                                        <div class="kt-wizard-v4__review-content">
                                            <div>Rut     : <%=ini.getId_profesional() %></div>
                                            <div>Nombre  : <%=ini.getUsuario().getNombre_usuario() + ' ' + ini.getUsuario().getApellido_usuario() %></div>
                                            <div>Correo  : <%=ini.getUsuario().getCorreo_usuario() %> </div>
                                            <div>Telefono  : <%=ini.getUsuario().getTelefono_usuario() %> </div>        
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
                                <input type="hidden" value="<%=ini.getUsuario().getRut_usuario() %>" id="rut_r" name="rut_r" >
                                <input type="hidden" value="<%=ida %>" id="id_a" name="id_a" >
                                <input type="hidden" value="<%=ini.getActividad().getServicio().getId_servicio() %>" id="id_s" name="id_s" >
                                <button type="submit" data-ktwizard-type="action-submit" class="btn btn-brand">Cerrar Chat</button>
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

<%@include file="../footer.jsp" %>