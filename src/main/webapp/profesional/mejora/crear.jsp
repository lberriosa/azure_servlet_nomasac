<%-- 
    Document   : crear
    Created on : 27/06/2020, 05:33:32 PM
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
                Crear Mejora
            </h3>
            <span class="kt-subheader__separator kt-subheader__separator--v"></span>
            <div class="kt-subheader__group" id="kt_subheader_search">
                <span class="kt-subheader__desc" id="kt_subheader_total">
                    Solicita la creación de una mejora para ser validada por la comunidad. </span>
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
                        Para que cliente visualice la mejora debe ser validad por otro supervisor en el foro de mejoras.
                        <br>
                        Puede realizar el seguimiento de las mejoras actuales <a class="kt-link kt-font-bold" href="../mejora/" >aquí</a>.
                    </div>
                </div>
            </div>
        </div>

        <!--begin::Portlet-->
        <div class="kt-portlet">
            <div class="kt-portlet__head">
                <div class="kt-portlet__head-label">
                    <h3 class="kt-portlet__head-title">
                        Crear Mejora
                    </h3>
                </div>
            </div>

            <!--begin::Form-->
            <form class="kt-form" id="addmejora" enctype="multipart/form-data">
                <div class="kt-portlet__body">
                    <div class="kt-section kt-section--first">
                        <div class="kt-section__body">
                            <!--begin: Form Wizard Step 1-->
                            <div class="kt-wizard-v2__content" data-ktwizard-type="step-content" data-ktwizard-state="current">
                                <div class="kt-heading kt-heading--md"></div>
                                <div class="kt-form__section kt-form__section--first">
                                    <div class="kt-wizard-v2__form">

                                        <div class="form-group">
                                            <label>Seleccione cliente : </label>
                                            <select class="form-control kt-select2" id="kt_select2_1" name="kt_select2_1">
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
                                        </div>
                                        <div class="form-group">
                                            <label>Nombre de Mejora:</label>
                                            <input type="text" class="form-control" name="nombb" id="nombb" placeholder="Descripción" >
                                            <span class="form-text text-muted">Ingrese un nombre acerca de la mejora.</span>
                                        </div>
                                            
                                         <div class="form-group">
                                            <label>Descripción de Mejora:</label>
                                            <input type="text" class="form-control" name="descc" id="descc" placeholder="Descripción" >
                                            <span class="form-text text-muted">Ingrese una observación acerca de la mejora.</span>
                                        </div>
                                            
                                        <input type="hidden" value="<%=cod %>" id="id_p" name="id_p" >
                                        
                                        <div class="form-group">
                                            <label>Buscar Archivo</label>
                                            <div></div>
                                            <div class="custom-file">
                                                <input type="file" class="custom-file-input" accept="application/pdf, application/vnd.ms-excel" name="file" id="file">
                                                <label class="custom-file-label" for="customFile">Buscar Archivo</label>
                                                <span class="form-text text-muted">Seleccione un archivo con todo lo fundamental a mejorar.</span>
                                            </div>
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
                            <div class="col-lg-3 col-xl-3">
                            </div>
                            <div class="col-lg-9 col-xl-9">
                                <button id="kt_form_ingresar_mjra" type="submit"  class="btn btn-brand btn-bold">Informar Mejora</button>&nbsp;
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