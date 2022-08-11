"use strict";

// Class definition
var KTAppFondo= function () {

    var formEl;
    var validator;

    var initValidation = function () {
        validator = formEl.validate({
            // Validate only visible fields
            ignore: ":hidden",

            // Validation rules
            rules: {
                //= Client Information(step 3)
                // Billing Information
                billing_card_name: {
                    required: true
                },
                billing_card_number: {
                    required: true,
                    creditcard:true
                },
                billing_card_exp_month: {
                    required: true
                },
                billing_card_exp_year: {
                    required: true
                },
                billing_card_cvv: {
                    required: true,
                    minlength: 2,
                    maxlength: 3
                },

                // Billing Address
                billing_address_1: {
                    required: true
                },
                billing_address_2: {
                    
                },
                billing_city: {
                    required: true
                },
                billing_state: {
                    required: true
                },
                billing_zip: {
                    required: true,
                    number: true
                },

                billing_delivery: {
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
                var iuser = $('#rut_r').val();
                var tfondo = $('#total_f').val();
                var monto = $('#kt_nouislider_2_input').val();

                KTApp.progress(btn);

                formEl.ajaxSubmit({
                    type: "POST",
                    url: '../../Servlet_AddFondos',
                    data: {"rut_usuario": iuser,"monto_abono": monto,"total_fondo": tfondo},
                    success: function (data) {
                        switch (data) {
                            case'Pagado':
                                setTimeout(function () {
                                    KTApp.unprogress(btn);
                                    formEl.clearForm();
                                    formEl.validate().resetForm();

                                    swal.fire({
                                        "title": "",
                                        "text": "Se añadieron fondos de manera correcta en el sistema!",
                                        "type": "success",
                                        "confirmButtonClass": "btn btn-secondary"
                                    }).then(function () {
                                    window.location = "http://localhost:8080/nomasac/cliente/fondo/addfondos.jsp";
                                });
                                }, 2000);
                                break;
                            case'Error':
                                setTimeout(function () {
                                    KTUtil.scrollTop();
                                    KTApp.unprogress(btn);
                                    swal.fire({
                                        "title": "",
                                        "text": "Ocurrio un error al ingresar fondos al sistema. Reintente mas tarde",
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
            formEl = $('#addfondos');

            initValidation();
            initSubmit();
        }
    };
}();

jQuery(document).ready(function () {
    KTAppFondo.init();
});



