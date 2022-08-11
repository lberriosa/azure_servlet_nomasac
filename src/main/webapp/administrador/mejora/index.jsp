<%-- 
    Document   : index
    Created on : 1/07/2020, 01:08:32 AM
    Author     : lberr
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@include file="../header.jsp" %>

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
                    visualizar y realizar seguimiento de mejoras creadas por supervisores. </span>
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
                ArrayList<Mejora> lista = Mejora_DB.obtenerMejorasAdmin();
                for (int i = 0; i < lista.size(); i++) {
                    Mejora mejora_l = lista.get(i);
                    int estado_m = mejora_l.getEstado_mejora();
                    int estado_a = mejora_l.getAprobar().getEstado_aprobacion();
                    String directory = "http://localhost:8080/nomasac/archivos/";
                    String archivo = mejora_l.getArch_mejora();
                    String ruta = directory + archivo;
            %>

            <%
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
                }
            %>

        </div> 
    </div>
    <!-- end:: Content -->
</div>

<%-- include footer --%>
<%@include file="../footer.jsp" %>
