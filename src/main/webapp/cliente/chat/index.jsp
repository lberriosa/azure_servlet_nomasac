<%-- 
    Document   : index
    Created on : 1/07/2020, 03:06:13 PM
    Author     : lberr
--%>

<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<%@include file="../header.jsp" %>
<%    
    String cod = (String) session.getAttribute("usuario");
%>
<div class="kt-grid__item kt-grid__item--fluid kt-grid kt-grid--hor">

    <!-- begin:: Subheader -->
    <div class="kt-subheader   kt-grid__item" id="kt_subheader">
        <div class="kt-subheader__main">
            <h3 class="kt-subheader__title">
                Crear Conversación
            </h3>
            <span class="kt-subheader__separator kt-subheader__separator--v"></span>
            <div class="kt-subheader__group" id="kt_subheader_search">
                <span class="kt-subheader__desc" id="kt_subheader_total">
                    Crea una conversación con un profesional activo para solucionar todas tus consultas. </span>
            </div>
        </div>
        <div class="kt-subheader__toolbar">
            <a href="../chat/historico.jsp" class="btn btn-default btn-bold">
                Volver </a>
        </div>
    </div>
    <!-- end:: Subheader -->
    <div class="kt-content  kt-grid__item kt-grid__item--fluid" id="kt_content">
        <div class="row">
            <div class="col">
                <div class="alert alert-light alert-elevate fade show" role="alert">
                    <div class="alert-icon"><i class="flaticon-warning kt-font-brand"></i></div>
                    <div class="alert-text">
                        Esta acción no tiene cobro durante la semana. si desea asesoria durante sabados domingos u festivos se cobrara $10.000 por cada conversación 
                        <br>
                        Para mas información realizar la revisión de  <a class="kt-link kt-font-bold" href="#" >Terminos y condiciones</a>.
                    </div>
                </div>
            </div>
        </div>

        <!--Begin::Section-->
        <div class="row">
            <%                ArrayList<Usuario> lista = Usuario_DB.obtenerUsuarioProfAct();
                for (int i = 0; i < lista.size(); i++) {
                    Usuario usuario = lista.get(i);
            %>

            <div class="col-xl-3">

                <!--Begin::Portlet-->
                <div class="kt-portlet kt-portlet--height-fluid">
                    <div class="kt-portlet__head kt-portlet__head--noborder">
                        <div class="kt-portlet__head-label">
                            <h3 class="kt-portlet__head-title">
                            </h3>
                        </div>
                        <div class="kt-portlet__head-toolbar">
                            <a href="#" class="btn btn-icon" data-toggle="dropdown">
                                <i class="flaticon-reply kt-font-brand"></i>
                            </a>
                            <div class="dropdown-menu dropdown-menu-right">
                                <ul class="kt-nav">
                                    <li class="kt-nav__item">
                                        <a href="../dashboard/" class="kt-nav__link">
                                            <i class="kt-nav__link-icon flaticon-file"></i>
                                            <span class="kt-nav__link-text">Volver</span>
                                        </a>
                                    </li>
                                </ul>
                            </div>
                        </div>
                    </div>
                    <div class="kt-portlet__body">

                        <!--begin::Widget -->
                        <div class="kt-widget kt-widget--user-profile-2">
                            <div class="kt-widget__head">
                                <div class="kt-widget__media">
                                    <img class="kt-widget__img kt-hidden-" src="http://localhost:8080/nomasac/assets/media/logos/call_center.png" alt="image">
                                    <div class="kt-widget__pic kt-widget__pic--success kt-font-success kt-font-boldest kt-hidden">
                                        ChS
                                    </div>
                                </div>
                                <div class="kt-widget__info">
                                    <a href="#" class="kt-widget__username">
                                        <%=usuario.getNombre_usuario() + ' ' + usuario.getApellido_usuario()%>
                                    </a>
                                    <span class="kt-widget__desc">
                                        Asistente
                                    </span>
                                </div>
                            </div>
                            <div class="kt-widget__body">
                                <div class="kt-widget__item">
                                    <div class="kt-widget__contact">
                                        <span class="kt-widget__label">Rut:</span>
                                        <span class="kt-widget__data"><%=usuario.getRut_usuario()%></span>
                                    </div>
                                    <div class="kt-widget__contact">
                                        <span class="kt-widget__label">Correo:</span>
                                        <a href="#" class="kt-widget__data"><%=usuario.getCorreo_usuario()%></a>
                                    </div>
                                    <div class="kt-widget__contact">
                                        <span class="kt-widget__label">Telefono:</span>
                                        <a href="#" class="kt-widget__data"><%=usuario.getTelefono_usuario()%></a>
                                    </div> 
                                </div>
                            </div>
                            <div class="kt-widget__footer">
                                <form id="crear_salachat">
                                    <input type="hidden" value="<%=usuario.getRut_usuario() %>" id="rut_p" name="rut_p" >
                                    <input type="hidden" value="<%=cod %>" id="rut_u" name="rut_u" >
                                    <button type="submit" data-ktwizard-type="action-submit" class="btn btn-label-brand btn-lg btn-upper">Iniciar Coversación</button>                             
                                </form>
                                
                            </div>
                        </div>
                        <!--end::Widget -->
                    </div>
                </div>
                <!--End::Portlet-->
            </div>
            <%
                }
            %>
        </div>
        <!--End::Section-->
    </div> 
</div>


<%@include file="../footer.jsp" %>
