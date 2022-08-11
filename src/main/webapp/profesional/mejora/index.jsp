<%-- 
    Document   : index
    Created on : 27/06/2020, 05:33:41 PM
    Author     : lberr
--%>

<%@page import="Clases.Mejora"%>
<%@page import="java.util.ArrayList"%>
<%@page import="Clases.Mejora_DB"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@include file="../header.jsp" %>
<%    String cod = (String) session.getAttribute("usuario");
%>

<div class="kt-grid__item kt-grid__item--fluid kt-grid kt-grid--hor">

    <!-- begin:: Subheader -->
    <div class="kt-subheader   kt-grid__item" id="kt_subheader">
        <div class="kt-subheader__main">
            <h3 class="kt-subheader__title">
                Visualizar Mejoras
            </h3>
            <span class="kt-subheader__separator kt-subheader__separator--v"></span>
            <div class="kt-subheader__group" id="kt_subheader_search">
                <span class="kt-subheader__desc" id="kt_subheader_total">
                    Foro creado especialmente para mejorar la calidad de nuestros clientes. </span>
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
            <%
                ArrayList<Mejora> lista = Mejora_DB.obtenerMejorasProf();
                for (int i = 0; i < lista.size(); i++) {
                    Mejora mejora_l = lista.get(i);
                    String creador = mejora_l.getUsuario().getRut_usuario();
                    int estado_m = mejora_l.getEstado_mejora();
                    int estado_a = mejora_l.getAprobar().getEstado_aprobacion();
                    String directory = "http://localhost:8080/nomasac/archivos/";
                    String archivo = mejora_l.getArch_mejora();
                    String ruta = directory + archivo;

            %>

            <%                if (creador.equals(cod)) {
                    if (estado_m == 3 && estado_a == 1) {
            %>            
            <div class="col-lg-6">
                <!--begin::Portlet-->
                <div class="kt-portlet">
                    <div class="kt-portlet__head">
                        <div class="kt-portlet__head-label">
                            <span class="kt-portlet__head-icon">
                                <i class="flaticon2-shield"></i>
                            </span>
                            <h3 class="kt-portlet__head-title">
                                <%=mejora_l.getNomb_mejora()%>
                            </h3>
                        </div>
                        <div class="kt-portlet__head-toolbar">
                            <div class="kt-portlet__head-actions">
                            </div>
                        </div>
                    </div>
                    <div class="kt-portlet__body">
                        <%=mejora_l.getDesc_mejora()%>
                    </div>
                    <div class="kt-portlet__foot">
                        <div class="row align-items-center">
                            <div class="col-lg-6 m--valign-middle">
                                <div class="kt-portlet__head-actions">
                                    <a href="#" class="btn btn-danger btn-pill btn-sm">
                                        cancelado
                                    </a>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <!--end::Portlet-->           
            </div>
            <%            } else if (estado_m == 2 && estado_a == 2) {
            %>
            <div class="col-lg-6">
                <!--begin::Portlet-->
                <div class="kt-portlet">
                    <div class="kt-portlet__head">
                        <div class="kt-portlet__head-label">
                            <span class="kt-portlet__head-icon">
                                <i class="flaticon2-shield"></i>
                            </span>
                            <h3 class="kt-portlet__head-title">
                                <%=mejora_l.getNomb_mejora()%>
                            </h3>
                        </div>
                        <div class="kt-portlet__head-toolbar">
                            <div class="kt-portlet__head-actions">
                                <a href="<%=ruta%>" target="_blank" data-toggle="kt-tooltip" title data-original-title="Ver Archivo" class="btn btn-outline-info btn-sm btn-icon btn-icon-md">
                                    <i class="flaticon2-graphic-design"></i>
                                </a>
                            </div>
                        </div>
                    </div>
                    <div class="kt-portlet__body">
                        <%=mejora_l.getDesc_mejora()%>
                    </div>
                    <div class="kt-portlet__foot">
                        <div class="row align-items-center">
                            <div class="col-lg-6 m--valign-middle">
                                <div class="kt-portlet__head-actions">
                                    <a href="#" class="btn btn-success btn-pill btn-sm">
                                        aprobado
                                    </a>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <!--end::Portlet-->           
            </div>
            <%            } else if (estado_m == 1 && estado_a == 1) {
            %>   

            <div class="col-lg-6">
                <!--begin::Portlet-->
                <div class="kt-portlet">
                    <div class="kt-portlet__head">
                        <div class="kt-portlet__head-label">
                            <span class="kt-portlet__head-icon">
                                <i class="flaticon2-shield"></i>
                            </span>
                            <h3 class="kt-portlet__head-title">
                                <%=mejora_l.getNomb_mejora()%>
                            </h3>
                        </div>
                        <div class="kt-portlet__head-toolbar">
                            <div class="kt-portlet__head-actions">
                                <a href="<%=ruta%>" target="_blank" data-toggle="kt-tooltip" title data-original-title="Ver Archivo" class="btn btn-outline-info btn-sm btn-icon btn-icon-md">
                                    <i class="flaticon2-graphic-design"></i>
                                </a>
                                <a href="cancelar.jsp?id=<%=mejora_l.getId_mejora()%>" data-toggle="kt-tooltip" title data-original-title="Cancelar" class="btn btn-outline-danger btn-sm btn-icon btn-icon-md">
                                    <i class="flaticon2-delete"></i>
                                </a>
                            </div>
                        </div>
                    </div>
                    <div class="kt-portlet__body">
                        <%=mejora_l.getDesc_mejora()%>
                    </div>
                    <div class="kt-portlet__foot">
                        <div class="row align-items-center">
                            <div class="col-lg-6 m--valign-middle">
                                <div class="kt-portlet__head-actions">
                                    <a href="#" class="btn btn-info btn-pill btn-sm">
                                        creado
                                    </a>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <!--end::Portlet-->           
            </div>

            <%      }
            } else {
                if (estado_m == 3 && estado_a == 1) {
            %>
            <div class="col-lg-6">
                <!--begin::Portlet-->
                <div class="kt-portlet">
                    <div class="kt-portlet__head">
                        <div class="kt-portlet__head-label">
                            <span class="kt-portlet__head-icon">
                                <i class="flaticon2-shield"></i>
                            </span>
                            <h3 class="kt-portlet__head-title">
                                <%=mejora_l.getNomb_mejora()%>
                            </h3>
                        </div>
                        <div class="kt-portlet__head-toolbar">
                            <div class="kt-portlet__head-actions">
                            </div>
                        </div>
                    </div>
                    <div class="kt-portlet__body">
                        <%=mejora_l.getDesc_mejora()%>
                    </div>
                    <div class="kt-portlet__foot">
                        <div class="row align-items-center">
                            <div class="col-lg-6 m--valign-middle">
                                <div class="kt-portlet__head-actions">
                                    <a href="#" class="btn btn-danger btn-pill btn-sm">
                                        cancelado
                                    </a>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <!--end::Portlet-->           
            </div>
            <%
            } else if (estado_m == 2 && estado_a == 2) {
            %>
            <div class="col-lg-6">
                <!--begin::Portlet-->
                <div class="kt-portlet">
                    <div class="kt-portlet__head">
                        <div class="kt-portlet__head-label">
                            <span class="kt-portlet__head-icon">
                                <i class="flaticon2-shield"></i>
                            </span>
                            <h3 class="kt-portlet__head-title">
                                <%=mejora_l.getNomb_mejora()%>
                            </h3>
                        </div>
                        <div class="kt-portlet__head-toolbar">
                            <div class="kt-portlet__head-actions">
                                <a href="<%=ruta%>" target="_blank" data-toggle="kt-tooltip" title data-original-title="Ver Archivo" class="btn btn-outline-info btn-sm btn-icon btn-icon-md">
                                    <i class="flaticon2-graphic-design"></i>
                                </a>
                            </div>
                        </div>
                    </div>
                    <div class="kt-portlet__body">
                        <%=mejora_l.getDesc_mejora()%>
                    </div>
                    <div class="kt-portlet__foot">
                        <div class="row align-items-center">
                            <div class="col-lg-6 m--valign-middle">
                                <div class="kt-portlet__head-actions">
                                    <a href="#" class="btn btn-success btn-pill btn-sm">
                                        aprobado
                                    </a>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <!--end::Portlet-->           
            </div>

            <%
            } else if (estado_m == 1 && estado_a == 1) {
            %>
            <div class="col-lg-6">
                <!--begin::Portlet-->
                <div class="kt-portlet">
                    <div class="kt-portlet__head">
                        <div class="kt-portlet__head-label">
                            <span class="kt-portlet__head-icon">
                                <i class="flaticon2-shield"></i>
                            </span>
                            <h3 class="kt-portlet__head-title">
                                <%=mejora_l.getNomb_mejora()%>
                            </h3>
                        </div>
                        <div class="kt-portlet__head-toolbar">
                            <div class="kt-portlet__head-actions">
                                <a href="<%=ruta%>" target="_blank"data-toggle="kt-tooltip" title data-original-title="Ver Archivo" class="btn btn-outline-info btn-sm btn-icon btn-icon-md">
                                    <i class="flaticon2-graphic-design"></i>
                                </a>

                                <a href="aprobar.jsp?id=<%=mejora_l.getId_mejora()%>" data-toggle="kt-tooltip" title data-original-title="Aprobar" class="btn btn-outline-success btn-sm btn-icon btn-icon-md">
                                    <i class="flaticon2-check-mark"></i>
                                </a>
                            </div>
                        </div>
                    </div>
                    <div class="kt-portlet__body">
                        <%=mejora_l.getDesc_mejora()%>
                    </div>
                    <div class="kt-portlet__foot">
                        <div class="row align-items-center">
                            <div class="col-lg-6 m--valign-middle">
                                <div class="kt-portlet__head-actions">
                                    <a href="#" class="btn btn-info btn-pill btn-sm">
                                        creado
                                    </a>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <!--end::Portlet-->           
            </div>
            <%
                    }
                }
            %>

            <%
                }
            %>

        </div> 
    </div>
    <!-- end:: Content -->
</div>

<%-- include footer --%>
<%@include file="../footer.jsp" %>