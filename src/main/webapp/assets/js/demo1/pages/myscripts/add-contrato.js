"use strict";

// Class definition
var KTAppContrato= function () {

    var formEl;
    var validator;

    var initValidation = function () {
        validator = formEl.validate({
            // Validate only visible fields
            ignore: ":hidden",

            // Validation rules
            rules: {
                //= Step 1
                kt_select2_1: {
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
                var iuser = $('#kt_select2_1').val();


                KTApp.progress(btn);

                formEl.ajaxSubmit({
                    type: "POST",
                    url: '../../Servlet_CrearContrato',
                    data: {"rut_usuario": iuser},
                    success: function (data) {
                        switch (data) {
                            case'Ingresado':
                                setTimeout(function () {
                                    KTApp.unprogress(btn);
                                    formEl.clearForm();
                                    formEl.validate().resetForm();

                                    swal.fire({
                                        "title": "",
                                        "text": "Se creo contrato de manera correcta en el sistema!",
                                        "type": "success",
                                        "confirmButtonClass": "btn btn-secondary"
                                    });
                                }, 2000);
                                break;
                            case'Error':
                                setTimeout(function () {
                                    KTUtil.scrollTop();
                                    KTApp.unprogress(btn);
                                    swal.fire({
                                        "title": "",
                                        "text": "Ocurrio un error al ingresar el contrato al sistema. Reintente mas tarde",
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
            formEl = $('#addcontrato');

            initValidation();
            initSubmit();
        }
    };
}();

jQuery(document).ready(function () {
    KTAppContrato.init();
});


