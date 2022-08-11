<%-- 
    Document   : index
    Created on : 16/05/2020, 12:28:53 PM
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
                Visualizar Contratos </h3>
            <span class="kt-subheader__separator kt-subheader__separator--v"></span>
            <div class="kt-subheader__group" id="kt_subheader_search">
                <span class="kt-subheader__desc" id="kt_subheader_total">
                    Visualiza y gestiona los contratos registrados en sistema </span>
            </div>

        </div>

    </div>

    <!-- end:: Subheader -->

    <!-- begin:: Content -->
    <div class="kt-content  kt-grid__item kt-grid__item--fluid" id="kt_content">

        <div class="kt-portlet kt-portlet--mobile">
            <div class="kt-portlet__head kt-portlet__head--lg">
                <div class="kt-portlet__head-label">
                    <span class="kt-portlet__head-icon">
                        <i class="kt-font-brand flaticon2-layers-1"></i>
                    </span>
                    <h3 class="kt-portlet__head-title">
                        Visualizar Contratos
                    </h3>
                </div>
                <div class="kt-portlet__head-toolbar">
                    <div class="kt-portlet__head-wrapper">
                        <div class="kt-portlet__head-actions">
                            <a href="crear.jsp" class="btn btn-brand btn-elevate btn-icon-sm">
                                <i class="la la-plus"></i>
                                Nuevo Contrato
                            </a>
                        </div>
                    </div>
                </div>
            </div>
            <div class="kt-portlet__body">

                <!--begin: Datatable -->
                <table id="tabla_contrato" class="table table-striped- table-bordered table-hover table-checkable" style="width:100%">
                    <thead>
                        <tr>
                            <th colspan="2">Información Usuario</th>
                            <th colspan="3">Información Contrato</th>
                            <th colspan="2">Estadísticas</th>
                        </tr>
                        <tr>
                            <th>Rut Usuario</th>
                            <th>Nombre Usuario</th>
                            <th>Folio</th>
                            <th>Fecha Creación</th>
                            <th>Monto Pago</th>
                            <th>Modificado</th>
                            <th>Estado</th>
                        </tr>
                    </thead>
                    <tbody>
                    <%
                    ArrayList<Contrato> lista = Contrato_DB.obtenerClientesCContrato();
                    for(int i=0; i<lista.size(); i++){
                        Contrato contrato = lista.get(i);
                    %>
                        <tr>
                            <td><%=contrato.getUsuario().getRut_usuario() %></td>
                            <td><%=contrato.getUsuario().getNombre_usuario() + ' '+ contrato.getUsuario().getApellido_usuario()%></td>
                            <td><%=contrato.getFolio_contrato()%></td>
                            <td><%=contrato.getFecha_contrato() %></td>
                            <td><%=contrato.getMonto_contrato() %></td>
                            <td><%=contrato.getModificado() %></td>
                            <td><%=contrato.getEstado() %></td>
                        </tr> 
                       <%
                            }
                        %>
                    </tbody>
                </table>

                <!--end: Datatable -->
            </div>
        </div>
    </div>

    <!-- end:: Content -->
</div>



<%-- include footer --%>
<%@include file="../footer.jsp" %>
