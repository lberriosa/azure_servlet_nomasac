"use strict";

// Class definition
var KTAppProAdd = function () {
    // Base elements
    var wizardEl;
    var formEl;
    var validator;
    var wizard;

    // Private functions
    var initWizard = function () {
        // Initialize form wizard
        wizard = new KTWizard('kt_wizard_v1', {
            startStep: 1
        });

        // Validation before going to next page
        wizard.on('beforeNext', function (wizardObj) {
            if (validator.form() !== true) {
                wizardObj.stop();  // don't go to the next step
            }
        })

        // Change event
        wizard.on('change', function (wizard) {
            setTimeout(function () {
                KTUtil.scrollTop();
            }, 500);
        });
    }

    var initValidation = function () {
        validator = formEl.validate({
            // Validate only visible fields
            ignore: ":hidden",

            // Validation rules
            rules: {
                //= Step 1
                rutp: {
                    required: true,
                    minlength: 9,
                    maxlength: 11
                },
                nompro: {
                    required: true
                },
                apppro: {
                    required: true
                },
                telpro: {
                    required: true,
                    digits: true,
                    minlength: 9,
                    maxlength: 10
                },
                emapro: {
                    required: true,
                    email: true
                },
                profepro: {
                    required: true
                },
                direpro: {
                    required: true
                },

                //= Step 2
                passp: {
                    required: true
                },
                confpassp: {
                    required: true
                },

            },

            // Display error  
            invalidHandler: function (event, validator) {
                KTUtil.scrollTop();

                swal.fire({
                    "title": "",
                    "text": "Hay algunos errores en su envío. Por favor corríjalos.",
                    "type": "error",
                    "buttonStyling": false,
                    "confirmButtonClass": "btn btn-brand btn-sm btn-bold"
                });
            },

            // Submit valid form
            submitHandler: function (form) {

            }
        });
    }

    var initSubmit = function () {
        var btn = formEl.find('[data-ktwizard-type="action-submit"]');

        btn.on('click', function (e) {
            e.preventDefault();

            if (validator.form()) {
                var pwd = $('#passp').val();
                var rpwd = $('#confpassp').val();
                var rutp = $('#rutp').val();
                var nomp = $('#nompro').val();
                var appp = $('#apppro').val();
                var telp = $('#telpro').val();
                var corp = $('#emapro').val();
                var dirp = $('#direpro').val();
                var prop = $('#profepro').val();

                KTApp.progress(btn);

                formEl.ajaxSubmit({
                    type: "POST",
                    url: '../../Servlet_CrearProfesional',
                    data: {"pass": pwd, "rpass": rpwd, "rut_usuario": rutp,
                        "nom_usuario": nomp, app_usuario: appp,
                        "tel_usuario": telp, "corr_usuario": corp, dom_usuario: dirp,
                        "pro_usuario": prop},
                    success: function (data) {
                        switch (data) {
                            case'Invalido':
                                setTimeout(function () {
                                    KTUtil.scrollTop();
                                    KTApp.unprogress(btn);
                                    swal.fire({
                                        "title": "",
                                        "text": "Password no coinciden. Favor revisar",
                                        "type": "error",
                                        "buttonStyling": false,
                                        "confirmButtonClass": "btn btn-brand btn-sm btn-bold"
                                    });
                                }, 2000);
                                break;
                            case'Ingresado':
                                setTimeout(function () {
                                    KTApp.unprogress(btn);
                                    formEl.clearForm();
                                    formEl.validate().resetForm();

                                    swal.fire({
                                        "title": "",
                                        "text": "Se creo profesional de manera correcta en el sistema!",
                                        "type": "success",
                                        "confirmButtonClass": "btn btn-secondary"
                                    });
                                }, 2000);
                                break;
                            case'Existeu':
                                setTimeout(function () {
                                    KTUtil.scrollTop();
                                    KTApp.unprogress(btn);
                                    swal.fire({
                                        "title": "",
                                        "text": "Usuario ya existe en sistema.",
                                        "type": "error",
                                        "buttonStyling": false,
                                        "confirmButtonClass": "btn btn-brand btn-sm btn-bold"
                                    });
                                }, 2000);
                                break;
                            case'Error':
                                setTimeout(function () {
                                    KTUtil.scrollTop();
                                    KTApp.unprogress(btn);
                                    swal.fire({
                                        "title": "",
                                        "text": "Ocurrio un error al ingresar el usuario al sistema. Reintente mas tarde",
                                        "type": "error",
                                        "buttonStyling": false,
                                        "confirmButtonClass": "btn btn-brand btn-sm btn-bold"
                                    });
                                }, 2000);
                                break;
                        }
                    }
                });
            }
        });
    }

    return {
        // public functions
        init: function () {
            wizardEl = KTUtil.get('kt_wizard_v1');
            formEl = $('#addpro');

            initWizard();
            initValidation();
            initSubmit();
        }
    };
}();

jQuery(document).ready(function () {
    KTAppProAdd.init();
});