<%-- 
    Document   : chat
    Created on : 1/07/2020, 03:48:42 PM
    Author     : lberr
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<%@include file="../header.jsp" %>
<%    String cod = (String) session.getAttribute("usuario");
    Usuario us = Usuario_DB.BuscarUsuarioRutP(request.getParameter("id"));
    String rutp = request.getParameter("id");
%>
<div class="kt-grid__item kt-grid__item--fluid kt-grid kt-grid--hor">

    <!-- begin:: Subheader -->
    <div class="kt-subheader   kt-grid__item" id="kt_subheader">
        <div class="kt-subheader__main">
            <h3 class="kt-subheader__title">
                Módulo de Conversación
            </h3>
            <span class="kt-subheader__separator kt-subheader__separator--v"></span>
            <div class="kt-subheader__group" id="kt_subheader_search">
                <span class="kt-subheader__desc" id="kt_subheader_total">
                    Un espacio para solucionar todas tus dudas. </span>
            </div>
        </div>
        <div class="kt-subheader__toolbar">
            <a href="../chat/" class="btn btn-default btn-bold">
                Volver </a>
        </div>
    </div>
    <!-- end:: Subheader -->
    <div class="kt-content  kt-grid__item kt-grid__item--fluid" id="kt_chat_contenido">
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

        <!--Begin:: App Content-->

        <div class="kt-chat">
            <div class="kt-portlet kt-portlet--head-lg kt-portlet--last">
                <div class="kt-portlet__head">
                    <div class="kt-chat__head ">
                        <div class="kt-chat__left">
                            <input type="hidden" onload="connect();" value="<%=cod%>" id="username" placeholder="Username"/>
                        </div>
                        <div class="kt-chat__center">
                            <div class="kt-chat__label">
                                <a href="#" class="kt-chat__title"><%=us.getNombre_usuario() + ' ' + us.getApellido_usuario()%></a>
                                <span class="kt-chat__status">
                                    <span class="kt-badge kt-badge--dot kt-badge--success"></span> Activo
                                </span>
                            </div>

                        </div>
                        <div class="kt-chat__right">
                            <div class="dropdown dropdown-inline">
                                <button type="button" class="btn btn-clean btn-sm btn-icon btn-icon-md" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                    <i class="flaticon2-add-1"></i>
                                </button>
                                <div class="dropdown-menu dropdown-menu-fit dropdown-menu-right dropdown-menu-md">

                                    <!--begin::Nav-->
                                    <ul class="kt-nav">
                                        <li class="kt-nav__head">
                                            Acciones
                                            <i class="flaticon2-information" data-toggle="kt-tooltip" data-placement="right" title="Seleccionar acción..."></i>
                                        </li>
                                        <li class="kt-nav__separator"></li>
                                        <li class="kt-nav__item">
                                            <a href="historico.jsp" class="kt-nav__link">
                                                <i class="kt-nav__link-icon flaticon2-protected"></i>
                                                <span class="kt-nav__link-text">Cerrar chat</span>
                                            </a>


                                        </li> 
                                        <li class="kt-nav__item">
                                            <a href="historico.jsp" class="kt-nav__link">
                                                <i class="kt-nav__link-icon flaticon2-protected"></i>
                                                <span class="kt-nav__link-text">Visualizar Historico</span>
                                            </a>


                                        </li> 

                                    </ul>
                                    <!--end::Nav-->
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="kt-portlet__body">
                    <div class="kt-scroll kt-scroll--pull" data-mobile-height="300">
                        <div class="kt-chat__messages">
                            <div class="kt-chat__message">
                                <div class="kt-chat__user">
                                    <a href="#" class="kt-chat__username">Sistema</span></a>
                                    <span class="kt-chat__datetime">Justo Ahora</span>
                                </div>
                                <div class="kt-chat__text kt-bg-light-success">
                                    Hola! Bienvenido por favor para continuar escribenos un mensaje... <br>Un profesional vendrá lo mas rapido posible.
                                </div>
                            </div>
                            
                            <div class="kt-chat__message">
                                <div class="kt-chat__user">
                                    <a href="#" class="kt-chat__username">Sistema</span></a>
                                    <span class="kt-chat__datetime">Justo Ahora</span>
                                </div>
                                <div class="kt-chat__text kt-bg-light-success">
                                    Recuerda no cerrar la sala de conversación ! 
                                </div>
                            </div>
                            
                           
                        </div>
                    </div>
                </div>
                <div class="kt-portlet__foot">
                    <div class="kt-chat__input">
                        <div class="kt-chat__editor">
                            <input type="hidden" value="<%=rutp%>" size="15" id="to" placeholder="To"/>
                            <textarea style="height: 50px" id="msg" placeholder="Enviar Mensaje..."></textarea>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>

    <!--End:: App Content-->

</div>
<!--End::Section-->



<%@include file="../footer.jsp" %>