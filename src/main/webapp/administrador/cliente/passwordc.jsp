<%-- 
    Document   : passwordc
    Created on : 18/04/2020, 05:25:48 PM
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
                Información Cliente </h3>
            <span class="kt-subheader__separator kt-hidden"></span>
            <div class="kt-subheader__breadcrumbs">
                <a href="#" class="kt-subheader__breadcrumbs-home"><i class="flaticon2-shelter"></i></a>
                <span class="kt-subheader__breadcrumbs-separator"></span>
            </div>
        </div>
        <div class="kt-subheader__toolbar">
            <div class="kt-subheader__wrapper">
                <a href="../cliente/" class="btn kt-subheader__btn-primary">
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
                                        <%                                            Usuario usuario = Usuario_DB.BuscarUsuarioRut(request.getParameter("id"));
                                            String rutu = request.getParameter("id");
                                        %>
                                        <a href="#" class="kt-widget__username">
                                            Usuario: <%=usuario.getNombre_usuario() + ' ' + usuario.getApellido_usuario()%>
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
                                <a href="informacion.jsp?id=<%=request.getParameter("id")%>" class="kt-widget__item">
                                    Resumen General
                                </a>
                                <a href="ecliente.jsp?id=<%=request.getParameter("id")%>" class="kt-widget__item">
                                    Información de Cliente
                                </a>
                                <a href="empresac.jsp?id=<%=request.getParameter("id")%>" class="kt-widget__item">
                                    Información de Empresa
                                </a>
                                <a href="estadocliente.jsp?id=<%=request.getParameter("id")%>" class="kt-widget__item">
                                    Cambiar Estado
                                </a>
                                <a href="#" class="kt-widget__item kt-widget__item--active">
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
                                    <h3 class="kt-widget1__title">Calculo de Pagos</h3>
                                    <span class="kt-widget1__desc">En proceso....</span>
                                </div>
                                <span class="kt-widget1__number kt-font-brand">+$0</span>
                            </div>

                            <div class="kt-widget1__item">
                                <div class="kt-widget1__info">
                                    <h3 class="kt-widget1__title">Calculo de Perdidas</h3>
                                    <span class="kt-widget1__desc">En proceso....</span>
                                </div>
                                <span class="kt-widget1__number kt-font-success">-0%</span>
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
                    <div class="col-xl-12">
                        <div class="kt-portlet kt-portlet--height-fluid">
                            <div class="kt-portlet__head">
                                <div class="kt-portlet__head-label">
                                    <h3 class="kt-portlet__head-title">Cambiar Contraseña<small>cambia la contraseña</small></h3>
                                </div>
                                <div class="kt-portlet__head-toolbar kt-hidden">
                                    <div class="kt-portlet__head-toolbar">

                                    </div>
                                </div>
                            </div>
                            <form class="kt-form kt-form--label-right" action="">
                                <div class="kt-portlet__body">
                                    <div class="kt-section kt-section--first">
                                        <div class="kt-section__body">
                                            <div class="alert alert-text alert-bold fade show kt-margin-t-20 kt-margin-b-40" role="alert">
                                                <div class="alert-icon"><i class="fas fa-info-circle"></i></div>
                                                <div class="alert-text">Debido a nuestros terminos de seguridad recomendamos que cambies la contraseña periodicamente. </div>
                                                <div class="alert-close">
                                                    <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                                                        <span aria-hidden="true"><i class="la la-close"></i></span>
                                                    </button>
                                                </div>
                                            </div>
                                            <div class="row">
                                                <label class="col-xl-3"></label>
                                                <div class="col-lg-9 col-xl-6">
                                                    <h3 class="kt-section__title kt-section__title-sm">Cambia la contraseña:</h3>
                                                </div>
                                            </div>

                                            <div class="form-group row">
                                                <label class="col-xl-3 col-lg-3 col-form-label">Ingresa la Contraseña</label>
                                                <div class="col-lg-9 col-xl-6">
                                                    <input type="password" class="form-control" placeholder="Contraseña" id="password_r" name="password_r">
                                                </div>
                                            </div>
                                            <div class="form-group form-group-last row">
                                                <label class="col-xl-3 col-lg-3 col-form-label">Repite la Contraseña</label>
                                                <div class="col-lg-9 col-xl-6">
                                                    <input type="password" class="form-control" placeholder="Confirmar Contraseña" id="rpassword_r" name="rpassword_r" >
                                                    <input type="hidden" value="<%=rutu%>" id="rut_r" name="rut_r" >
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                <div class="kt-portlet__foot">
                                    <div class="kt-form__actions">
                                        <div class="row">
                                            <div class="col-lg-3 col-xl-3">
                                            </div>
                                            <div class="col-lg-9 col-xl-9">
                                                <button id="kt_form_pass_recovery" type="submit" class="btn btn-brand btn-bold">Cambiar Contraseña</button>&nbsp;
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </form>
                        </div>
                    </div>
                </div>
            </div>

            <!--End:: App Content-->
        </div>

        <!--End::App-->
    </div>

    <!-- end:: Content -->
</div>

<%-- include footer --%>
<%@include file="../footer.jsp" %>

