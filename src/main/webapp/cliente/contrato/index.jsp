<%-- 
    Document   : index
    Created on : 17/05/2020, 09:55:59 PM
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
                Visualizar Contrato
            </h3>
            <span class="kt-subheader__separator kt-subheader__separator--v"></span>
            <div class="kt-subheader__group" id="kt_subheader_search">
                <span class="kt-subheader__desc" id="kt_subheader_total">
                    Visualiza los terminos y condiciones sujetos a tu contrato. </span>
            </div>
        </div>
        <div class="kt-subheader__toolbar">
            <a href="../dashboard/" class="btn btn-default btn-bold">
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
                        Contrato expuesto a cambios de terminos y condiciones. Toda modificación debe ser auditado y aprobado por usted.
                        <br>
                        Para mas información u problemas contactar a <a class="kt-link kt-font-bold" href="#" >Administrador</a>.
                    </div>
                </div>
            </div>
        </div>

    </div>
    <!-- end:: Content -->
    


</div>

<div class="kt-content  kt-grid__item kt-grid__item--fluid" id="kt_content">

    <!--begin::Portlet-->
    <div class="kt-portlet kt-faq-v1">
        <div class="kt-portlet__head">
            <div class="kt-portlet__head-label">
                <h3 class="kt-portlet__head-title">
                    Terminos y Condiciones del Contrato
                </h3>
            </div>
        </div>
        <div class="kt-portlet__body">
            <div class="row">
                <div class="col-xl-3">
                    <ul class="kt-nav" id="kt_nav" role="tablist">
                        <li class="kt-nav__item">
                            <a href="#" class="kt-nav__link">
                                <span class="kt-nav__link-text">Terminos & Condiciones</span>
                            </a>
                        </li>
                    </ul>
                </div>
                <div class="col-xl-9">
                    <div class="accordion accordion-solid accordion-toggle-plus" id="accordionExample1">
                        <div class="card">
                            <div class="card-header" id="headingOne">
                                <div class="card-title" data-toggle="collapse" data-target="#collapseOne1" aria-expanded="false" aria-controls="collapseOne1">
                                    Terminos y beneficios.
                                </div>
                            </div>
                            <div id="collapseOne1" class="collapse show" aria-labelledby="headingOne" data-parent="#accordionExample1" style="">
                                <div class="card-body">
                                    <p>
                                        Al crear tu contrato, se realizara un cobro de $2.000.000 correspondiente a la asignacion de profesional, pago por visitas a terreno, asistencia 24/7 y procesos de mejora en tu lugar de trabajo.
                                    </p>
                                    <p>
                                        Todos los modulos se habilitaran luego de que se proceda a efectuar el pago correspondiente al cobro incial del contrato. Pago corresponde a servicio anual de nuestros servicios.
                                    </p>
                                    <p>
                                        Servicio de visitas solo podra ser modificable 2 veces al año, Se realizara un cobro extra de $100.000 por cada modificacion extra. Servicios de call center fuera de horario sera cobrado con un valor de $25.000 por atención.
                                    </p>
                                    <p>
                                        Cada cambio de contrato u cobro sera avisado con 90 dias de anterioridad al representante legal de la empresa.
                                    </p>
                                </div>
                            </div>
                        </div>
                        <div class="card">
                            <div class="card-header" id="headingTwo">
                                <div class="card-title collapsed" data-toggle="collapse" data-target="#collapseTwo1" aria-expanded="false" aria-controls="collapseTwo1">
                                    Pagos y Fondos ingresados.
                                </div>
                            </div>
                            <div id="collapseTwo1" class="collapse" aria-labelledby="headingTwo1" data-parent="#accordionExample1">
                                <div class="card-body">
                                    <p>
                                        Todo fondo monetario ingresado queda excento de cobro por IVA y no sera reembolsable por la empresa "no mas accidentes".
                                    </p>
                                    <p>
                                        Facturación entregada directamente por via correo electronico. Podra visualizar detalle en modulo correspondiente
                                    </p>
                                    <p>
                                        Notas de credito debera ser revisado y gestionado directamente con el area de finanzas de la empresa.
                                    </p>
                                    <p>
                                        En caso de cobros ilegales, patentes no firmadas, visitas no realizadas empresa debera gestionar la devolucion directa 
                                        a cuenta bancaria de cliente.
                                    </p>
                                </div>
                            </div>
                        </div>
                        <div class="card">
                            <div class="card-header" id="headingThree1">
                                <div class="card-title collapsed" data-toggle="collapse" data-target="#collapseThree1" aria-expanded="false" aria-controls="collapseThree1">
                                    Cancelación de servicios.
                                </div>
                            </div>
                            <div id="collapseThree1" class="collapse" aria-labelledby="headingThree1" data-parent="#accordionExample1">
                                <div class="card-body">
                                    <p>
                                        Podra solicitar la cancelación y reapertura de servicios en cualquier momento. No debe poseer deudas en servicios u pagos extras pendientes
                                    </p>
                                    <p>
                                        Cancelación de contrato evitara que cliente realice cambios y solicitudes en modalidades especiales.
                                    </p>
                                    <p>
                                        La cancelación dejara canceladas las credenciales para ingresar al sistema. Debera solicitar la reactivacion de manera externa.
                                    </p>
                                    <p>
                                        Empresa "no mas accidentes" deja en disposicion la posibilidad de cancelar actividades si no dan las condiciones dadas para la correcta revision.
                                    </p>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>

    <!--end::Portlet-->
</div>

<%-- include footer --%>
<%@include file="../footer.jsp" %>
