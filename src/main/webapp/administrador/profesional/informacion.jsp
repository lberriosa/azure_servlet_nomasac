<%-- 
    Document   : informacion
    Created on : 29/04/2020, 04:30:12 PM
    Author     : lberr
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@include file="../header.jsp" %>

<div class="kt-grid__item kt-grid__item--fluid kt-grid kt-grid--hor">

    <!-- begin:: Subheader -->
    <div class="kt-subheader   kt-grid__item" id="kt_subheader">
        <div class="kt-subheader__main">
            <button class="kt-subheader__mobile-toggle kt-subheader__mobile-toggle--left" id="kt_subheader_mobile_toggle"><span></span></button>
            <h3 class="kt-subheader__title">
                Información Profesional </h3>
            <span class="kt-subheader__separator kt-hidden"></span>
            <div class="kt-subheader__breadcrumbs">
                <a href="#" class="kt-subheader__breadcrumbs-home"><i class="flaticon2-shelter"></i></a>
                <span class="kt-subheader__breadcrumbs-separator"></span>
            </div>
        </div>
        <div class="kt-subheader__toolbar">
            <div class="kt-subheader__wrapper">
                <a href="../profesional/" class="btn kt-subheader__btn-primary">
                    Volver &nbsp; </a>
            </div>
        </div>
    </div>

    <!-- end:: Subheader -->

    <!-- begin:: Content -->
    <div class="kt-content  kt-grid__item kt-grid__item--fluid" id="kt_content">

        <!--Begin::App-->
        <div class="kt-grid kt-grid--desktop kt-grid--ver kt-grid--ver-desktop kt-app">

            <!--Begin:: App Aside Mobile Toggle-->
            <button class="kt-app__aside-close" id="kt_user_profile_aside_close">
                <i class="la la-close"></i>
            </button>

            <!--End:: App Aside Mobile Toggle-->

            <!--Begin:: App Aside-->
            <div class="kt-grid__item kt-app__toggle kt-app__aside" id="kt_user_profile_aside">

                <!--begin:: Widgets/Applications/User/Profile4-->
                <div class="kt-portlet kt-portlet--height-fluid-">
                    <div class="kt-portlet__body">

                        <!--begin::Widget -->
                        <div class="kt-widget kt-widget--user-profile-4">
                            <div class="kt-widget__head">
                                <div class="kt-widget__media">
                                    <img class="kt-widget__img kt-hidden-" src="http://localhost:8080/nomasac/assets/media/users/cliente.png" alt="image">
                                    <div class="kt-widget__pic kt-widget__pic--danger kt-font-danger kt-font-boldest kt-font-light kt-hidden">
                                        C
                                    </div>
                                </div>
                                <div class="kt-widget__content">
                                    <div class="kt-widget__section">
                                        <%  
                                            Usuario usuario = Usuario_DB.BuscarUsuarioRutP(request.getParameter("id"));
                                        %>
                                        <a href="#" class="kt-widget__username">
                                            Usuario: <%=usuario.getNombre_usuario() + ' ' + usuario.getApellido_usuario()%>
                                        </a>
                                          <a href="#" class="kt-widget__username">
                                            Profesión: <%=usuario.getProfesion() %>
                                        </a>

                                        <%
                                            if (usuario.getHabilitado() == 1) {
                                        %>
                                        <div class="kt-widget__button">
                                            <span class="btn btn-label btn-sm">Usuario Activo</span>
                                        </div>
                                        <%
                                        } else {
                                        %>
                                        <div class="kt-widget__button">
                                            <span class="btn btn-label-warning btn-sm">Usuario Deshabilitado</span>
                                        </div>
                                        <%
                                            }
                                        %>
                                    </div>
                                </div>
                            </div>
                            <div class="kt-widget__body">
                                <a href="#" class="kt-widget__item kt-widget__item--active">
                                    Resumen General
                                </a>
                                <a href="eprofesional.jsp?id=<%=request.getParameter("id")%>" class="kt-widget__item">
                                    Información de Profesional
                                </a>
                                <a href="estadoprofesional.jsp?id=<%=request.getParameter("id")%>" class="kt-widget__item">
                                    Cambiar Estado
                                </a>
                                <a href="passwordp.jsp?id=<%=request.getParameter("id")%>" class="kt-widget__item">
                                    Cambiar Contraseña
                                </a>
                            </div>
                        </div>
                        <!--end::Widget -->
                    </div>
                </div>

                <!--end:: Widgets/Applications/User/Profile4-->
                     <!--Begin:: Portlet-->
                <div class="kt-portlet">
                    <div class="kt-portlet__body">
                        <div class="kt-widget1 kt-widget1--fit">
                            <div class="kt-widget1__item">
                                <div class="kt-widget1__info">
                                    <h3 class="kt-widget1__title">Calculo de Actividades</h3>
                                    <span class="kt-widget1__desc">En proceso....</span>
                                </div>
                                <span class="kt-widget1__number kt-font-brand">+$0</span>
                            </div>
 
                            <div class="kt-widget1__item">
                                <div class="kt-widget1__info">
                                    <h3 class="kt-widget1__title">Porcentaje de Cumplimiento</h3>
                                    <span class="kt-widget1__desc">En proceso....</span>
                                </div>
                                <span class="kt-widget1__number kt-font-warning">0%</span>
                            </div>

                        </div>
                    </div>
                </div>

                <!--end:: Portlet-->
            </div>

            <!--End:: App Aside-->

            <!--Begin:: App Content-->
            <div class="kt-grid__item kt-grid__item--fluid kt-app__content">
                <div class="row">
                    <div class="col-xl-6">
                    </div>
                    <div class="col-xl-6">
                        <!--end:: Widgets/Last Updates-->
                    </div>
                </div>
                <div class="row">
                    <div class="col-xl-12">

                        <!--begin:: Widgets/Best Sellers-->
                        <div class="kt-portlet kt-portlet--height-fluid">
                            <div class="kt-portlet__head">
                                <div class="kt-portlet__head-label">
                                    <h3 class="kt-portlet__head-title">
                                        Informe de actividades realizadas
                                    </h3>
                                </div>
                                <div class="kt-portlet__head-toolbar">
                                    <ul class="nav nav-pills nav-pills-sm nav-pills-label nav-pills-bold" role="tablist">
                                        <li class="nav-item">
                                            <a class="nav-link active" data-toggle="tab" href="#kt_widget5_tab1_content" role="tab">
                                                Último Mes
                                            </a>
                                        </li>
                                        <li class="nav-item">
                                            <a class="nav-link" data-toggle="tab" href="#kt_widget5_tab3_content" role="tab">
                                                Todas
                                            </a>
                                        </li>
                                    </ul>
                                </div>
                            </div>
                            <div class="kt-portlet__body">
                                <div class="tab-content">
                                    <div class="tab-pane active" id="kt_widget5_tab1_content" aria-expanded="true">
                                        <div class="kt-widget5">
                                            <div class="kt-widget5__item">
                                                <div class="kt-widget5__content">
                                                    <div class="kt-widget5__section">
                                                        <a href="#" class="kt-widget5__title">
                                                            En proceso...
                                                        </a>
                                                        <p class="kt-widget5__desc">
                                                            En proceso...
                                                        </p>
                                                        <div class="kt-widget5__info">
                                                            <span>Actividad:</span>
                                                            <span class="kt-font-info"></span>
                                                            <span>Fecha:</span>
                                                            <span class="kt-font-info"></span>
                                                        </div>
                                                    </div>
                                                </div>
                                                <div class="kt-widget5__content">
                                                    <div class="kt-widget5__stats">
                                                        <span class="kt-widget5__number">0</span>
                                                        <span class="kt-widget5__sales">%</span>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                    </div>


                                    <div class="tab-pane" id="kt_widget5_tab3_content">
                                        <div class="kt-widget5">
                                            <div class="kt-widget5__item">
                                                <div class="kt-widget5__content">
                                                    <div class="kt-widget5__section">
                                                        <a href="#" class="kt-widget5__title">
                                                            En proceso...
                                                        </a>
                                                        <p class="kt-widget5__desc">
                                                            En proceso...
                                                        </p>
                                                        <div class="kt-widget5__info">
                                                            <span>Actividad:</span>
                                                            <span class="kt-font-info"></span>
                                                            <span>Fecha:</span>
                                                            <span class="kt-font-info"></span>
                                                        </div>
                                                    </div>
                                                </div>
                                                <div class="kt-widget5__content">
                                                    <div class="kt-widget5__stats">
                                                        <span class="kt-widget5__number">0</span>
                                                        <span class="kt-widget5__sales">%</span>
                                                    </div>
                                                </div>    
                                            </div>
                                        </div>
                                    </div>

                                </div>
                            </div>
                        </div>

                        <!--end:: Widgets/Best Sellers-->
                    </div>
                </div>
                <div class="row">
                    <div class="col-xl-12">


                    </div>
                </div>
            </div>
            <!--End:: App Content-->
        </div>


<%-- include footer --%>
<%@include file="../footer.jsp" %>


