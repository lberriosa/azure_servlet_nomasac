<%-- 
    Document   : crear
    Created on : 17/04/2020, 02:52:40 PM
    Author     : lberr
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@include file="../header.jsp" %>

<div class="kt-grid__item kt-grid__item--fluid kt-grid kt-grid--hor">

    <!-- begin:: Content Head -->
    <div class="kt-subheader   kt-grid__item" id="kt_subheader">
        <div class="kt-subheader__main">
            <h3 class="kt-subheader__title">
                Nuevo Cliente
            </h3>
            <span class="kt-subheader__separator kt-subheader__separator--v"></span>
            <div class="kt-subheader__group" id="kt_subheader_search">
                <span class="kt-subheader__desc" id="kt_subheader_total">
                    Ingresa los datos para la creación de un nuevo cliente </span>
            </div>
        </div>
        <div class="kt-subheader__toolbar">
            <a href="../dashboard/" class="btn btn-default btn-bold">
                Cancelar </a>
        </div>
    </div>
    <!-- end:: Content Head -->
    <!-- begin:: Content -->
    <div class="kt-content  kt-grid__item kt-grid__item--fluid" id="kt_content">
        <div class="kt-wizard-v4" id="kt_apps_user_add_user" data-ktwizard-state="step-first">

            <!--begin: Form Wizard Nav -->
            <div class="kt-wizard-v4__nav">
                <div class="kt-wizard-v4__nav-items nav">
                    <a class="kt-wizard-v4__nav-item nav-item" href="#" data-ktwizard-type="step" data-ktwizard-state="current">
                        <div class="kt-wizard-v4__nav-body">
                            <div class="kt-wizard-v4__nav-number">
                                1
                            </div>
                            <div class="kt-wizard-v4__nav-label">
                                <div class="kt-wizard-v4__nav-label-title">
                                    Usuario
                                </div>
                                <div class="kt-wizard-v4__nav-label-desc">
                                    Ingresar Información Personal de Usuario 
                                </div>
                            </div>
                        </div>
                    </a>
                    <a class="kt-wizard-v4__nav-item nav-item" href="#" data-ktwizard-type="step">
                        <div class="kt-wizard-v4__nav-body">
                            <div class="kt-wizard-v4__nav-number">
                                2
                            </div>
                            <div class="kt-wizard-v4__nav-label">
                                <div class="kt-wizard-v4__nav-label-title">
                                    Empresa
                                </div>
                                <div class="kt-wizard-v4__nav-label-desc">
                                    Ingresar Datos de Empresa
                                </div>
                            </div>
                        </div>
                    </a>
                    <a class="kt-wizard-v4__nav-item nav-item" href="#" data-ktwizard-type="step">
                        <div class="kt-wizard-v4__nav-body">
                            <div class="kt-wizard-v4__nav-number">
                                3
                            </div>
                            <div class="kt-wizard-v4__nav-label">
                                <div class="kt-wizard-v4__nav-label-title">
                                    Sesión
                                </div>
                                <div class="kt-wizard-v4__nav-label-desc">
                                    Ingresar Datos para el inicio al Sistema.
                                </div>
                            </div>
                        </div>
                    </a>
                    <a class="kt-wizard-v4__nav-item nav-item" href="#" data-ktwizard-type="step">
                        <div class="kt-wizard-v4__nav-body">
                            <div class="kt-wizard-v4__nav-number">
                                4
                            </div>
                            <div class="kt-wizard-v4__nav-label">
                                <div class="kt-wizard-v4__nav-label-title">
                                    Confirmar
                                </div>
                                <div class="kt-wizard-v4__nav-label-desc">
                                    Revisar Datos y Confirmar Operación
                                </div>
                            </div>
                        </div>
                    </a>
                </div>
            </div>

            <!--end: Form Wizard Nav -->
            <div class="kt-portlet">
                <div class="kt-portlet__body kt-portlet__body--fit">
                    <div class="kt-grid">
                        <div class="kt-grid__item kt-grid__item--fluid kt-wizard-v4__wrapper">

                            <!--begin: Form Wizard Form-->
                            <form class="kt-form" id="kt_apps_user_add_user_form">

                                <!--begin: Form Wizard Step 1-->
                                <div class="kt-wizard-v4__content" data-ktwizard-type="step-content" data-ktwizard-state="current">
                                    <div class="kt-heading kt-heading--md">Información Personal de Usuario:</div>
                                    <div class="kt-section kt-section--first">
                                        <div class="kt-wizard-v4__form">
                                            <div class="row">
                                                <div class="col-xl-12">
                                                    <div class="kt-section__body">
                                                        <div class="form-group row">
                                                            <label class="col-xl-3 col-lg-3 col-form-label">Rut Usuario:</label>
                                                            <div class="col-lg-9 col-xl-9">
                                                                <input class="form-control" type="text" id="rutu" required name="rutu" oninput="resumen();checkRut(this);"  placeholder="Rut Usuario">
                                                            </div>
                                                        </div>
                                                        <div class="form-group row">
                                                            <label class="col-xl-3 col-lg-3 col-form-label">Nombres Usuario:</label>
                                                            <div class="col-lg-9 col-xl-9">
                                                                <input class="form-control" type="text" id="nomusu" name="nomusu" oninput="resumen()" placeholder="Nombres">
                                                            </div>
                                                        </div>
                                                        <div class="form-group row">
                                                            <label class="col-xl-3 col-lg-3 col-form-label">Apellidos Usuario:</label>
                                                            <div class="col-lg-9 col-xl-9">
                                                                <input class="form-control" type="text" id="appusu" name="appusu" oninput="resumen()" placeholder="Apellidos">
                                                            </div>
                                                        </div>
                                                        <div class="form-group row">
                                                            <label class="col-xl-3 col-lg-3 col-form-label">Telefono Usuario:</label>
                                                            <div class="col-lg-9 col-xl-9">
                                                                <div class="input-group">
                                                                    <div class="input-group-prepend"><span class="input-group-text"><i class="la la-phone"></i></span></div>
                                                                    <input type="text" class="form-control" id="telusu" name="telusu" oninput="resumen()" placeholder="Telefono" >
                                                                </div>
                                                                <span class="form-text text-muted">No compartiremos tu información personal.</span>
                                                            </div>
                                                        </div>
                                                        <div class="form-group row">
                                                            <label class="col-xl-3 col-lg-3 col-form-label">Correo Usuario:</label>
                                                            <div class="col-lg-9 col-xl-9">
                                                                <div class="input-group">
                                                                    <div class="input-group-prepend"><span class="input-group-text"><i class="la la-at"></i></span></div>
                                                                    <input type="email" class="form-control" id="emausu" name="emausu" oninput="resumen()" placeholder="Email">
                                                                </div>
                                                            </div>
                                                        </div>
                                                        <div class="form-group form-group-last row">
                                                            <label class="col-xl-3 col-lg-3 col-form-label">Domicilio Usuario:</label>
                                                            <div class="col-lg-9 col-xl-9">
                                                                <div class="input-group">
                                                                    <input type="text" class="form-control" id="direusu" name="direusu" oninput="resumen()" placeholder="Dirección" value="" >
                                                                </div>
                                                                <span class="form-text text-muted">Dirección solo usada de referencia.</span>
                                                            </div>
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>

                                <!--end: Form Wizard Step 1-->


                                <!--begin: Form Wizard Step 2-->
                                <div class="kt-wizard-v4__content" data-ktwizard-type="step-content" data-ktwizard-state="current">
                                    <div class="kt-heading kt-heading--md">Datos de Empresa: </div>
                                    <div class="kt-form__section kt-form__section--first">
                                        <div class="kt-wizard-v4__form">
                                            <div class="form-group row">
                                                <label class="col-xl-3 col-lg-3 col-form-label">Rut Empresa:</label>
                                                <div class="col-lg-9 col-xl-9">
                                                    <input class="form-control" type="text" id="rut_empr" name="rut_empr" oninput="resumen();checkRut(this);" placeholder="Rut Empresa">
                                                </div>
                                            </div>
                                            <div class="form-group row">
                                                <label class="col-xl-3 col-lg-3 col-form-label">Razón Social Empresa:</label>
                                                <div class="col-lg-9 col-xl-9">
                                                    <input class="form-control" type="text" id="raz_empr" name="raz_empr" oninput="resumen()" placeholder="Razón Social Empresa">
                                                </div>
                                            </div>
                                            <div class="form-group row">
                                                <label class="col-xl-3 col-lg-3 col-form-label">Dirección Empresa:</label>
                                                <div class="col-lg-9 col-xl-9">
                                                    <input class="form-control" type="text" id="dir_empr" name="dir_empr" oninput="resumen()" placeholder="Dirección Empresa">
                                                </div>
                                            </div>
                                            <div class="form-group row">
                                                <label class="col-xl-3 col-lg-3 col-form-label">Telefono Empresa:</label>
                                                <div class="col-lg-9 col-xl-9">
                                                    <div class="input-group">
                                                        <div class="input-group-prepend"><span class="input-group-text"><i class="la la-phone"></i></span></div>
                                                        <input type="text" class="form-control" id="tel_empr" name="tel_empr" oninput="resumen()" placeholder="Telefono Empresa" >
                                                    </div>
                                                    <span class="form-text text-muted">No compartiremos tu información empresarial.</span>
                                                </div>
                                            </div>
                                            <div class="form-group row">
                                                <label class="col-xl-3 col-lg-3 col-form-label">Correo Empresa</label>
                                                <div class="col-lg-9 col-xl-9">
                                                    <div class="input-group">
                                                        <div class="input-group-prepend"><span class="input-group-text"><i class="la la-at"></i></span></div>
                                                        <input type="email" class="form-control" id="cor_empr" name="cor_empr" oninput="resumen()" placeholder="Correo Empresa">
                                                    </div>
                                                </div>
                                            </div>
                                            <div class="form-group form-group-last row">
                                                <label class="col-xl-3 col-lg-3 col-form-label">Página Web Empresa:</label>
                                                <div class="col-lg-9 col-xl-9">
                                                    <div class="input-group">
                                                        <input type="text" class="form-control" id="pag_empr" name="pag_empr" oninput="resumen()"  placeholder="Página Web"  >
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>

                                <!--end: Form Wizard Step 2-->

                                <!--begin: Form Wizard Step 3-->
                                <div class="kt-wizard-v4__content" data-ktwizard-type="step-content" data-ktwizard-state="current">
                                    <div class="kt-heading kt-heading--md">Ingresa la Contraseña</div>
                                    <div class="kt-form__section kt-form__section--first">
                                        <div class="kt-wizard-v4__form">
                                            <div class="form-group">
                                                <label>Contraseña</label>
                                                <input type="password" class="form-control" id="passu" name="passu" placeholder="Contraseña" value="">
                                                <span class="form-text text-muted">Por favor ingresa tu contraseña.</span>
                                            </div>
                                            <div class="form-group">
                                                <label>Confirmar Contraseña</label>
                                                <input type="password" class="form-control" id="confpassu" name="confpassu" placeholder="Confirmar Contraseña" value="">
                                                <span class="form-text text-muted">Confirma la contraseña de usuario.</span>
                                            </div>
                                        </div>
                                    </div>
                                </div>

                                <!--end: Form Wizard Step 3-->

                                <!--begin: Form Wizard Step 4-->
                                <div class="kt-wizard-v4__content" data-ktwizard-type="step-content">
                                    <div class="kt-heading kt-heading--md">Revisa Detalladamente y Confirma Resultados</div>
                                    <div class="kt-form__section kt-form__section--first">
                                        <div class="kt-wizard-v4__review">
                                            <div class="kt-wizard-v4__review-item">
                                                <div class="kt-wizard-v4__review-title">
                                                    Datos de Usuario
                                                </div>
                                                <div class="kt-wizard-v4__review-content">
                                                    <div id="res_rut" > </div>
                                                    <div id="res_nom" > </div>
                                                    <div id="res_app" > </div>
                                                    <div id="res_tel" > </div>
                                                    <div id="res_cor" > </div>
                                                    <div id="res_dom" > </div>
                                                </div> 
                                            </div>
                                            <div class="kt-wizard-v4__review-item">
                                                <div class="kt-wizard-v4__review-title">
                                                    Datos de Empresa
                                                </div>
                                                <div class="kt-wizard-v4__review-content">
                                                    <div id="res_rute" > </div>
                                                    <div id="res_raze" > </div>
                                                    <div id="res_dire" > </div>
                                                    <div id="res_tele" > </div>
                                                    <div id="res_core" > </div>
                                                    <div id="res_page" > </div>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                <!--end: Form Wizard Step 4-->

                                <!--begin: Form Actions -->
                                <div class="kt-form__actions">
                                    <div class="btn btn-secondary btn-md btn-tall btn-wide kt-font-bold kt-font-transform-u" data-ktwizard-type="action-prev">
                                        Anterior
                                    </div>
                                    <div class="btn btn-success btn-md btn-tall btn-wide kt-font-bold kt-font-transform-u" data-ktwizard-type="action-submit">
                                        Confirmar
                                    </div>
                                    <div class="btn btn-brand btn-md btn-tall btn-wide kt-font-bold kt-font-transform-u" data-ktwizard-type="action-next">
                                        Siguiente
                                    </div>
                                </div>
                                <!--end: Form Actions -->
                            </form>
                            <!--end: Form Wizard Form-->
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>


    <script>
        function resumen() {
            // DATOS USUARIO
            var ru = document.getElementById("rutu").value;
            document.getElementById("res_rut").innerHTML = "Rut    : " + ru;

            var nu = document.getElementById("nomusu").value;
            document.getElementById("res_nom").innerHTML = "Nombre : " + nu;

            var au = document.getElementById("appusu").value;
            document.getElementById("res_app").innerHTML = "Apellido : " + au;

            var tu = document.getElementById("telusu").value;
            document.getElementById("res_tel").innerHTML = "Telefono : " + tu;

            var cu = document.getElementById("emausu").value;
            document.getElementById("res_cor").innerHTML = "Email : " + cu;

            var du = document.getElementById("direusu").value;
            document.getElementById("res_dom").innerHTML = "Domicilio : " + du;

            // DATOS EMPRESA 

            var re = document.getElementById("rut_empr").value;
            document.getElementById("res_rute").innerHTML = "Rut    : " + re;

            var rae = document.getElementById("raz_empr").value;
            document.getElementById("res_raze").innerHTML = "Razón Social : " + rae;

            var de = document.getElementById("dir_empr").value;
            document.getElementById("res_dire").innerHTML = "Dirección : " + de;

            var te = document.getElementById("tel_empr").value;
            document.getElementById("res_tele").innerHTML = "Telefono : " + te;

            var ce = document.getElementById("cor_empr").value;
            document.getElementById("res_core").innerHTML = "Email : " + ce;

            var pe = document.getElementById("pag_empr").value;
            document.getElementById("res_page").innerHTML = "Pagina Web : " + pe;

        }
    </script>

    <!-- begin: Script Rut-->
    <script>
        function checkRut(rut) {
            // Despejar Puntos
            var valor = rut.value.replace('.', '');
            // Despejar Guión
            valor = valor.replace('-', '');

            // Aislar Cuerpo y Dígito Verificador
            cuerpo = valor.slice(0, -1);
            dv = valor.slice(-1).toUpperCase();

            // Formatear RUN
            rut.value = cuerpo + '-' + dv

            // Si no cumple con el mínimo ej. (n.nnn.nnn)
            if (cuerpo.length < 7) {
                rut.setCustomValidity("RUT Incompleto");
                return false;
            }

            // Calcular Dígito Verificador
            suma = 0;
            multiplo = 2;

            // Para cada dígito del Cuerpo
            for (i = 1; i <= cuerpo.length; i++) {

                // Obtener su Producto con el Múltiplo Correspondiente
                index = multiplo * valor.charAt(cuerpo.length - i);

                // Sumar al Contador General
                suma = suma + index;

                // Consolidar Múltiplo dentro del rango [2,7]
                if (multiplo < 7) {
                    multiplo = multiplo + 1;
                } else {
                    multiplo = 2;
                }

            }

            // Calcular Dígito Verificador en base al Módulo 11
            dvEsperado = 11 - (suma % 11);

            // Casos Especiales (0 y K)
            dv = (dv == 'K') ? 10 : dv;
            dv = (dv == 0) ? 11 : dv;

            // Validar que el Cuerpo coincide con su Dígito Verificador
            if (dvEsperado != dv) {
                rut.setCustomValidity("RUT Inválido");
                return false;
            }

            // Si todo sale bien, eliminar errores (decretar que es válido)
            rut.setCustomValidity('');
        }

    </script>
    <!-- end:: Content -->
</div>

<%-- include footer --%>
<%@include file="../footer.jsp" %>