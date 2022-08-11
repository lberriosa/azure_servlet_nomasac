"use strict";

var KTStatusPerfil = function () {

    var handleStatus = function () {
        $('#kt_form_pago_contrato').click(function (e) {
            e.preventDefault();

            var btn = $(this);
            var form = $(this).closest('form');
            var user = $('#rut_r').val();
            var mont = $('#monto_p').val();
            var desp = $('#desc_p').val();


            if (!form.valid()) {
                return;
            }

            btn.addClass('kt-spinner kt-spinner--right kt-spinner--sm kt-spinner--light').attr('disabled', true);

            form.ajaxSubmit({
                type: "POST",
                url: '../../Servlet_PagarContrato',
                data: {"userr": user, "montop": mont, "descrip": desp},
                success: function (data) {
                    switch (data) {
                        case'Pagado':
                            setTimeout(function () {
                                KTApp.unprogress(btn);
                                swal.fire({
                                    "title": "",
                                    "text": "Se realizo el pago del contrato en sistema. Debera volver a iniciar sesion para disfrutar de todas sus caracteristicas",
                                    "type": "success",
                                    "confirmButtonClass": "btn btn-secondary"
                                }).then(function () {
                                    window.location = "http://localhost:8080/nomasac/";
                                }); 
                            }, 2000);
                            break;
                        case'Fondos':
                            setTimeout(function () {
                                KTUtil.scrollTop();
                                KTApp.unprogress(btn);
                                swal.fire({
                                    "title": "",
                                    "text": "No hay fondos disponibles para realizar el pago. Añada fondos a traves del enlace superior.",
                                    "type": "error",
                                    "buttonStyling": false,
                                    "confirmButtonClass": "btn btn-brand btn-sm btn-bold"
                                });
                            }, 500);
                            break;
                        case'Error':
                            setTimeout(function () {
                                KTUtil.scrollTop();
                                KTApp.unprogress(btn);
                                swal.fire({
                                    "title": "",
                                    "text": "Ocurrio un error al realizar el pago del contrato en sistema. Reintente mas tarde",
                                    "type": "error",
                                    "buttonStyling": false,
                                    "confirmButtonClass": "btn btn-brand btn-sm btn-bold"
                                });
                            }, 500);
                            break;
                    }
                }
            });
        });
    }

    return{
        init: function () {
            handleStatus();
        }
    };

}();

jQuery(document).ready(function () {
    KTStatusPerfil.init();
});

