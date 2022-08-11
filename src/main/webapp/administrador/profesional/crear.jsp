<%-- 
    Document   : crear.jsp
    Created on : 27/04/2020, 07:17:19 PM
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
                Nuevo Profesional
            </h3>
            <span class="kt-subheader__separator kt-subheader__separator--v"></span>
            <div class="kt-subheader__group" id="kt_subheader_search">
                <span class="kt-subheader__desc" id="kt_subheader_total">
                    Ingresa los datos para la creación de un nuevo profesional </span>
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
        <div class="kt-portlet">
            <div class="kt-portlet__body kt-portlet__body--fit">
                <div class="kt-grid  kt-wizard-v1 kt-wizard-v1--white" id="kt_wizard_v1" data-ktwizard-state="step-first">
                    <div class="kt-grid__item">

                        <!--begin: Form Wizard Nav -->
                        <div class="kt-wizard-v1__nav">
                            <div class="kt-wizard-v1__nav-items">
                                <a class="kt-wizard-v1__nav-item" href="#" data-ktwizard-type="step" data-ktwizard-state="current">
                                    <div class="kt-wizard-v1__nav-body">
                                        <div class="kt-wizard-v1__nav-icon">
                                            <i class="flaticon-profile-1"></i>
                                        </div>
                                        <div class="kt-wizard-v1__nav-label">
                                            1) Datos de Usuario
                                        </div>
                                    </div>
                                </a>
                                <a class="kt-wizard-v1__nav-item" href="#" data-ktwizard-type="step">
                                    <div class="kt-wizard-v1__nav-body">
                                        <div class="kt-wizard-v1__nav-icon">
                                            <i class="flaticon-list"></i>
                                        </div>
                                        <div class="kt-wizard-v1__nav-label">
                                            2) Datos de Sesión
                                        </div>
                                    </div>
                                </a>
                                <a class="kt-wizard-v1__nav-item" href="#" data-ktwizard-type="step">
                                    <div class="kt-wizard-v1__nav-body">
                                        <div class="kt-wizard-v1__nav-icon">
                                            <i class="flaticon-globe"></i>
                                        </div>
                                        <div class="kt-wizard-v1__nav-label">
                                            3) Revisar y Confirmar
                                        </div>
                                    </div>
                                </a>
                            </div>
                        </div>

                        <!--end: Form Wizard Nav -->
                    </div>
                    <div class="kt-grid__item kt-grid__item--fluid kt-wizard-v1__wrapper">

                        <!--begin: Form Wizard Form-->
                        <form class="kt-form" id="addpro">

                            <!--begin: Form Wizard Step 1-->
                            <div class="kt-wizard-v1__content" data-ktwizard-type="step-content" data-ktwizard-state="current">
                                <div class="kt-heading kt-heading--md">Información Personal de Profesional: </div>
                                <div class="kt-form__section kt-form__section--first">
                                    <div class="kt-wizard-v1__form">
                                        <div class="kt-section__body">
                                            <div class="form-group row">
                                                <label class="col-xl-3 col-lg-3 col-form-label">Rut Profesional:</label>
                                                <div class="col-lg-9 col-xl-9">
                                                    <input class="form-control" type="text" id="rutp" required name="rutp" oninput="resumen();checkRut(this);"  placeholder="Rut Profesional">
                                                </div>
                                            </div>
                                            <div class="form-group row">
                                                <label class="col-xl-3 col-lg-3 col-form-label">Nombres Profesional:</label>
                                                <div class="col-lg-9 col-xl-9">
                                                    <input class="form-control" type="text" id="nompro" name="nompro" oninput="resumen()" placeholder="Nombres">
                                                </div>
                                            </div>
                                            <div class="form-group row">
                                                <label class="col-xl-3 col-lg-3 col-form-label">Apellidos Profesional:</label>
                                                <div class="col-lg-9 col-xl-9">
                                                    <input class="form-control" type="text" id="apppro" name="apppro" oninput="resumen()" placeholder="Apellidos">
                                                </div>
                                            </div>
                                            <div class="form-group row">
                                                <label class="col-xl-3 col-lg-3 col-form-label">Telefono Profesional:</label>
                                                <div class="col-lg-9 col-xl-9">
                                                    <div class="input-group">
                                                        <div class="input-group-prepend"><span class="input-group-text"><i class="la la-phone"></i></span></div>
                                                        <input type="text" class="form-control" id="telpro" name="telpro" oninput="resumen()" placeholder="Telefono" >
                                                    </div>
                                                    <span class="form-text text-muted">No compartiremos tu información personal.</span>
                                                </div>
                                            </div>
                                            <div class="form-group row">
                                                <label class="col-xl-3 col-lg-3 col-form-label">Correo Profesional:</label>
                                                <div class="col-lg-9 col-xl-9">
                                                    <div class="input-group">
                                                        <div class="input-group-prepend"><span class="input-group-text"><i class="la la-at"></i></span></div>
                                                        <input type="email" class="form-control" id="emapro" name="emapro" oninput="resumen()" placeholder="Email">
                                                    </div>
                                                </div>
                                            </div>
                                            <div class="form-group row">
                                                <label class="col-xl-3 col-lg-3 col-form-label">Profesión Asignada:</label>
                                                <div class="col-lg-9 col-xl-9">
                                                    <div class="input-group">
                                                        <select name="profepro" id="profepro" oninput="resumen()" class="form-control">
                                                            <option value="">Seleccionar Profesión</option>
                                                            <option value="Supervisor">Supervisor</option>
                                                            <option value="Asistente">Asistente</option>
                                                            <option value="Capacitador">Capacitador</option>
                                                        </select>
                                                    </div> 
                                                    <span class="form-text text-muted">Profesión podra ser cambiada dependiendo de su progreso en la empresa.</span>
                                                </div>
                                            </div>
                                            <div class="form-group form-group-last row">
                                                <label class="col-xl-3 col-lg-3 col-form-label">Domicilio Profesional:</label>
                                                <div class="col-lg-9 col-xl-9">
                                                    <div class="input-group">
                                                        <input type="text" class="form-control" id="direpro" name="direpro" oninput="resumen()" placeholder="Dirección" value="" >
                                                    </div>
                                                    <span class="form-text text-muted">Dirección solo usada de referencia.</span>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>

                            <!--end: Form Wizard Step 1-->


                            <!--begin: Form Wizard Step 2-->
                            <div class="kt-wizard-v1__content" data-ktwizard-type="step-content">
                                <div class="kt-heading kt-heading--md">Ingresa la Contraseña: </div>
                                <div class="kt-form__section kt-form__section--first">
                                    <div class="kt-wizard-v4__form">
                                        <div class="form-group">
                                            <label>Contraseña</label>
                                            <input type="password" class="form-control" id="passp" name="passp" placeholder="Contraseña" value="">
                                            <span class="form-text text-muted">Por favor ingresa tu contraseña.</span>
                                        </div>
                                        <div class="form-group">
                                            <label>Confirmar Contraseña</label>
                                            <input type="password" class="form-control" id="confpassp" name="confpassp" placeholder="Confirmar Contraseña" value="">
                                            <span class="form-text text-muted">Confirma la contraseña de usuario.</span>
                                        </div>
                                    </div>
                                </div>
                            </div>

                            <!--end: Form Wizard Step 2-->



                            <!--begin: Form Wizard Step 3-->
                            <div class="kt-wizard-v1__content" data-ktwizard-type="step-content">
                                <div class="kt-heading kt-heading--md">Revisa Detalladamente y Confirma Resultados</div>
                                <div class="kt-form__section kt-form__section--first">
                                    <div class="kt-wizard-v1__review">
                                        <div class="kt-wizard-v1__review-item">
                                            <div class="kt-wizard-v1__review-title">
                                                Datos de Profesional
                                            </div>
                                            <div class="kt-wizard-v1__review-content">
                                                <div id="res_rut" > </div>
                                                <div id="res_nom" > </div>
                                                <div id="res_app" > </div>
                                                <div id="res_tel" > </div>
                                                <div id="res_cor" > </div>
                                                <div id="res_pro" > </div>
                                                <div id="res_dom" > </div>
                                            </div> 
                                        </div>
                                    </div>
                                </div>
                            </div>

                            <!--end: Form Wizard Step 3-->

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

    <!-- end:: Content -->

        <script>
        function resumen() {
            // DATOS PROFESIONAL
            var rp = document.getElementById("rutp").value;
            document.getElementById("res_rut").innerHTML = "Rut    : " + rp;

            var np = document.getElementById("nompro").value;
            document.getElementById("res_nom").innerHTML = "Nombre : " + np;

            var ap = document.getElementById("apppro").value;
            document.getElementById("res_app").innerHTML = "Apellido : " + ap;

            var tp = document.getElementById("telpro").value;
            document.getElementById("res_tel").innerHTML = "Telefono : " + tp;

            var cp = document.getElementById("emapro").value;
            document.getElementById("res_cor").innerHTML = "Email : " + cp;
            
            var pp = document.getElementById("profepro");
            var prop = pp.options[pp.selectedIndex].text;
            document.getElementById("res_pro").innerHTML = "Profesión : " + prop;
            
            var dp = document.getElementById("direpro").value;
            document.getElementById("res_dom").innerHTML = "Domicilio : " + dp;

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
