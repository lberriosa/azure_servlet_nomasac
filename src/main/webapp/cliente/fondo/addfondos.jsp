<%-- 
    Document   : addfondos
    Created on : 19/05/2020, 07:20:28 PM
    Author     : lberr
--%>

<%@page import="Clases.Fondo_DB"%>
<%@page import="Clases.Fondo"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@include file="../header.jsp" %>

<%  
    String codig = (String) session.getAttribute("usuario");
    Fondo f = Fondo_DB.BuscarFondo(codig);
    int m_fondo = f.getMonto_abono();
%>

<div class="kt-grid__item kt-grid__item--fluid kt-grid kt-grid--hor">

    <!-- begin:: Subheader -->
    <div class="kt-subheader   kt-grid__item" id="kt_subheader">
        <div class="kt-subheader__main">
            <h3 class="kt-subheader__title">
                Añadir Fondos </h3>
            <span class="kt-subheader__separator kt-subheader__separator--v"></span>
            <div class="kt-subheader__group" id="kt_subheader_search">
                <span class="kt-subheader__desc" id="kt_subheader_total">
                    Añade fondos a tu cuenta personal. </span>
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
                        Total de Fondos : $ <%=m_fondo%>
                    </h3>
                </div>
            </div>
        </div>

        <!--begin::Portlet-->
        <div class="kt-portlet">
            <div class="kt-portlet__head">
                <div class="kt-portlet__head-label">
                    <h3 class="kt-portlet__head-title">
                        Formulario de Adición de Fondos
                    </h3>
                </div>
            </div>

            <!--begin::Form-->
            <form class="kt-form kt-form--fit kt-form--label-right" id="addfondos">
                <div class="kt-portlet__body">
                    <div class="form-group row">
                        <label class="col-form-label col-lg-3 col-sm-12">Fondos: </label>
                        <div class="col-lg-6 col-md-12 col-sm-12">
                            <div class="row align-items-center">
                                <div class="col-4">
                                    <input type="text" class="form-control" id="kt_nouislider_2_input" placeholder="Monto a añadir">
                                </div>
                                <div class="col-8">
                                    <div id="kt_nouislider_2" class="kt-nouislider kt-nouislider--handle-danger"></div>
                                </div>
                            </div>
                            <span class="form-text text-muted">Todo monto ingresado queda excento de IVA. No queda a disposicion la realización de notas de credito por abono.</span>
                        </div>
                    </div>
                    <div class="kt-separator kt-separator--border-dashed kt-separator--space-lg"></div>


                    <div class="kt-section">
                        <h3 class="kt-section__title">
                            Información de Pago:
                        </h3>
                        <div class="kt-section__content">
                             <div class="form-group row">
                                <label class="col-form-label col-lg-3 col-sm-12">* Titular de Tarjeta:</label>
                                <div class="col-lg-9 col-md-9 col-sm-12">
                                    <div class="input-group">
                                       <input type="text" name="billing_card_name" class="form-control" placeholder="" value="">
                                        <div class="input-group-append"><span class="input-group-text"><i class="la la-credit-card"></i></span></div>
                                    </div>
                                    <span class="form-text text-muted">Ingresa el titular de la tarjeta</span>
                                </div>
                            </div>
                            <div class="form-group row">
                                <label class="col-form-label col-lg-3 col-sm-12">* N° Tarjeta:</label>
                                <div class="col-lg-9 col-md-9 col-sm-12">
                                    <div class="input-group">
                                        <input type="text" name="billing_card_number" class="form-control" placeholder="" value="">
                                        <div class="input-group-append"><span class="input-group-text"><i class="la la-credit-card"></i></span></div>
                                    </div>
                                    <span class="form-text text-muted">Ingresa tu número de tarjeta</span>
                                </div>
                            </div>
                            <div class="form-group row">
                                <label class="col-form-label col-lg-3 col-sm-12">* Mes:</label>
                                <div class="col-lg-9 col-md-9 col-sm-12">
                                    <div class="input-group">
                                    <select class="form-control" name="billing_card_exp_month">
                                        <option value="">Seleccionar</option>
                                        <option value="01">01</option>
                                        <option value="02">02</option>
                                        <option value="03">03</option>
                                        <option value="04">04</option>
                                        <option value="05">05</option>
                                        <option value="06">06</option>
                                        <option value="07">07</option>
                                        <option value="08">08</option>
                                        <option value="09">09</option>
                                        <option value="10">10</option>
                                        <option value="11">11</option>
                                        <option value="12">12</option>
                                    </select>
                                    </div>
                                </div>
                            </div>
                            <div class="form-group row">
                                <label class="col-form-label col-lg-3 col-sm-12">* Año:</label>
                                <div class="col-lg-9 col-md-9 col-sm-12">
                                    <div class="input-group">
                                    <select class="form-control" name="billing_card_exp_year">
                                        <option value="">Seleccionar</option>
                                        <option value="2018">2020</option>
                                        <option value="2019">2021</option>
                                        <option value="2020">2022</option>
                                        <option value="2021">2023</option>
                                        <option value="2022">2024</option>
                                        <option value="2023">2025</option>
                                        <option value="2024">2026</option>
                                    </select>
                                    </div>
                                </div>
                            </div>
                            <div class="form-group row">
                                <label class="col-form-label col-lg-3 col-sm-12">* CVV:</label>
                                <div class="col-lg-9 col-md-9 col-sm-12">
                                    <div class="input-group">
                                        <input type="number" class="form-control" name="billing_card_cvv" placeholder="" value="">
                                        <div class="input-group-append"><span class="input-group-text"><i class="la la-credit-card"></i></span></div>
                                    </div>
                                </div>
                            </div>
                            
                        </div>
                    </div>
                    <div class="kt-separator kt-separator--border-dashed kt-separator--space-xl"></div>
                    <div class="kt-section">
                        <h3 class="kt-section__title">
                            Información de Facturación:
                            <i data-toggle="kt-tooltip" data-width="auto" class="kt-section__help" title="If different than the corresponding address"></i>
                        </h3>
                        <div class="kt-section__content">
                            <div class="form-group row">
                                <div class="col-lg-12">
                                    <label class="form-control-label">* Dirección:</label>
                                    <input type="text" name="billing_address_1" class="form-control" placeholder="" value="">
                                </div>
                            </div>
                            <div class="form-group row">
                                <div class="col-lg-12">
                                    <label class="form-control-label">Dirección 2:</label>
                                    <input type="text" name="billing_address_2" class="form-control" placeholder="" value="">
                                </div>
                            </div>
                            <div class="form-group form-group-last row">
                                <div class="col-lg-5 form-group-sub">
                                    <label class="form-control-label">* Ciudad:</label>
                                    <input type="text" class="form-control" name="billing_city" placeholder="" value="">
                                </div>
                                <div class="col-lg-5 form-group-sub">
                                    <label class="form-control-label">* Region:</label>
                                    <input type="text" class="form-control" name="billing_state" placeholder="" value="">
                                </div>
                                <div class="col-lg-2 form-group-sub">
                                    <label class="form-control-label">* Codigo Postal:</label>
                                    <input type="text" class="form-control" name="billing_zip" placeholder="" value="">
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="kt-separator kt-separator--border-dashed kt-separator--space-xl"></div>
                    <input type="hidden" value="<%=codig%>" id="rut_r" name="rut_r" >
                    <input type="hidden" value="<%=m_fondo%>" id="total_f" name="total_f" >

                </div>
                
                <div class="kt-portlet__foot kt-portlet__foot--fit-x">
                    <div class="kt-form__actions">
                        <div class="row">
                            <div class="col-lg-9 ml-lg-auto">
                                <button type="submit" data-ktwizard-type="action-submit" class="btn btn-brand">Confirmar Ingreso</button>
                            </div>
                        </div>
                    </div>
                </div>
                
            </form>

            <!--end::Form-->
        </div>            


    </div>

    <!-- end:: Content -->

</div>
<%-- include footer --%>
<%@include file="../footer.jsp" %>
