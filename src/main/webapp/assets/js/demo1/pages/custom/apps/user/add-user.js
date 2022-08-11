"use strict";

// Class definition
var KTAppUserAdd = function () {
    // Base elements
    var wizardEl;
    var formEl;
    var validator;
    var wizard;
    var avatar;

    // Private functions
    var initWizard = function () {
        // Initialize form wizard
        wizard = new KTWizard('kt_apps_user_add_user', {
            startStep: 1,
        });

        // Validation before going to next page
        wizard.on('beforeNext', function (wizardObj) {
            if (validator.form() !== true) {
                wizardObj.stop();  // don't go to the next step
            }
        })

        // Change event
        wizard.on('change', function (wizard) {
            KTUtil.scrollTop();
        });
    }

    var initValidation = function () {
        validator = formEl.validate({
            // Validate only visible fields
            ignore: ":hidden",

            // Validation rules
            rules: {
                // Step 1
                rutu: {
                    required: true,
                    minlength: 9,
                    maxlength: 11
                },
                nomusu: {
                    required: true
                },
                appusu: {
                    required: true
                },
                telusu: {
                    required: true,
                    digits: true,
                    minlength: 9,
                    maxlength: 10
                },
                emausu: {
                    required: true,
                    email: true
                },
                direusu: {
                    required: true
                },
                rut_empr: {
                    required: true,
                    minlength: 9,
                    maxlength: 11
                },
                raz_empr: {
                    required: true
                },
                dir_empr: {
                    required: true
                },
                tel_empr: {
                    required: true,
                     digits: true,
                    minlength: 9,
                    maxlength: 10
                },
                cor_empr: {
                    required: true,
                    email: true
                },
                pag_empr: {
                    required: true
                },
                passu: {
                    required: true
                },
                confpassu: {
                    required: true
                }
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
                
                var pwd = $('#passu').val();
                var rpwd = $('#confpassu').val();
                var rutu = $('#rutu').val();
                var nomu = $('#nomusu').val();
                var appu = $('#appusu').val();
                var telu = $('#telusu').val();
                var coru = $('#emausu').val();
                var diru = $('#direusu').val();
                
                var rute = $('#rut_empr').val();
                var raze = $('#raz_empr').val();
                var dire = $('#dir_empr').val();
                var tele = $('#tel_empr').val();
                var core = $('#cor_empr').val();
                var page = $('#pag_empr').val();
                
                KTApp.progress(btn);

                formEl.ajaxSubmit({
                    type: "POST",
                    url: '../../Servlet_CrearCliente',
                    data: {"pass": pwd, "rpass": rpwd, "rut_usuario": rutu,
                           "rut_empresa": rute,"nom_usuario": nomu,app_usuario:appu,
                           "tel_usuario": telu,"corr_usuario": coru,dom_usuario: diru,
                           "raz_empresa": raze,"dir_empresa": dire,tel_empresa:tele,
                           "cor_empresa": core,"pag_empresa": page},
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
                                        "text": "Se creo usuario de manera correcta en el sistema!",
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
                            case'Existee':
                                setTimeout(function () {
                                    KTUtil.scrollTop();
                                    KTApp.unprogress(btn);
                                    swal.fire({
                                        "title": "",
                                        "text": "Empresa ya existe en sistema.",
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

    var initKTAppsUserAdd = function () {
        avatar = new KTAvatar('kt_apps_user_add_user_avatar');
    }

    return {
        // public functions
        init: function () {
            formEl = $('#kt_apps_user_add_user_form');

            initWizard();
            initValidation();
            initSubmit();
            initKTAppsUserAdd();
        }
    };
}();

jQuery(document).ready(function () {
    KTAppUserAdd.init();
});