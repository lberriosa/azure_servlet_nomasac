<%-- 
    Document   : index
    Created on : 18/04/2020, 02:17:26 PM
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
                Visualizar Clientes </h3>
           <span class="kt-subheader__separator kt-subheader__separator--v"></span>
            <div class="kt-subheader__group" id="kt_subheader_search">
                <span class="kt-subheader__desc" id="kt_subheader_total">
                    Visualiza y gestiona los clientes registrados en sistema </span>
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
                        Visualizar Clientes
                    </h3>
                </div>
                <div class="kt-portlet__head-toolbar">
                    <div class="kt-portlet__head-wrapper">
                        <div class="kt-portlet__head-actions">
                            <a href="crear.jsp" class="btn btn-brand btn-elevate btn-icon-sm">
                                <i class="la la-plus"></i>
                                Nuevo Cliente
                            </a>
                        </div>
                    </div>
                </div>
            </div>
            <div class="kt-portlet__body">

                <!--begin: Datatable -->
                <table class="table table-striped- table-bordered table-hover table-checkable" id="kt_table_1">
                    <thead>
                        <tr>
                            <th colspan="1">Rut Usuario</th>
                            <th colspan="3">Información Usuario</th>
                            <th colspan="5">Información Empresa</th>
                            <th colspan="2">Estadísticas</th>
                        </tr>
                        <tr>
                            <th>Rut Usuario</th>
                            <th>Nombre</th>
                            <th>Telefono</th>
                            <th>Correo</th>
                            <th>Rut Empresa</th>
                            <th>Razón Social</th>
                            <th>Dirección</th>
                            <th>Telefono</th>
                            <th>Correo</th>
                            <th>Estado</th>
                            <th>Acciones</th>
                        </tr>
                    </thead>
                    <tbody>
                    <%
                    ArrayList<Usuario> lista = Usuario_DB.obtenerUsuarioCliente();
                    for(int i=0; i<lista.size(); i++){
                        Usuario usuario = lista.get(i);
                    %>
                        <tr>
                            <td><%=usuario.getRut_usuario() %></td>
                            <td><%=usuario.getNombre_usuario() + ' '+ usuario.getApellido_usuario()%></td>
                            <td><%=usuario.getTelefono_usuario()%></td>
                            <td><%=usuario.getCorreo_usuario()%></td>
                            <td><%=usuario.getEmpresa().getRut_empresa()%></td>
                            <td><%=usuario.getEmpresa().getRazon_social()%></td>
                            <td><%=usuario.getEmpresa().getDireccion()%></td>
                            <td><%=usuario.getEmpresa().getTelefono()%></td>
                            <td><%=usuario.getEmpresa().getCorreo()%></td>
                            <% if(usuario.getHabilitado() == 1 ){%>
                            <td>4</td>
                            <% }
                            else{
                            %>
                            <td>6</td>
                            <% 
                                }
                            %>
                            <td> 
                                <span class="dropdown">
                                    <a href="#" class="btn btn-sm btn-clean btn-icon btn-icon-md" data-toggle="dropdown" aria-expanded="true">
                                        <i class="la la-ellipsis-h"></i>
                                    </a>
                                    <div class="dropdown-menu dropdown-menu-right">
                                        <a class="dropdown-item" href="ecliente.jsp?id=<%=usuario.getRut_usuario()%>"><i class="la la-edit"></i> Editar Datos Cliente</a>
                                        <a class="dropdown-item" href="empresac.jsp?id=<%=usuario.getRut_usuario()%>"><i class="la la-edit"></i> Editar Datos Empresa</a>
                                        <a class="dropdown-item" href="estadocliente.jsp?id=<%=usuario.getRut_usuario()%>"><i class="la la-star"></i> Cambiar Estado Cliente</a>
                                    </div>
                                </span>
                                <a href="informacion.jsp?id=<%=usuario.getRut_usuario()%>" class="btn btn-sm btn-clean btn-icon btn-icon-md" title="Visualizar Detalle">
                                    <i class="la la-leaf"></i>
                                </a>
                            </td>
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
