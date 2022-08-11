"use strict";

var KTPayPendientes = function () {

    var handleStatus = function () {
        $('#kt_form_pago').click(function (e) {
            e.preventDefault();

            var btn = $(this);
            var form = $(this).closest('form');
            var user = $('#rut_r').val();
            var mont = $('#monto_p').val();
            var desc = $('#desc_p').val();
            var idse = $('#idserv').val();


            if (!form.valid()) {
                return;
            }

            btn.addClass('kt-spinner kt-spinner--right kt-spinner--sm kt-spinner--light').attr('disabled', true);

            form.ajaxSubmit({
                type: "POST",
                url: '../../Servlet_PagarPendientes',
                data: {"userr": user,"monto_p":mont,"descripcion":desc,"id_servici":idse},
                success: function (data) {
                    switch (data) {
                        case'Pagado':
                            setTimeout(function () {
                                KTApp.unprogress(btn);
                                swal.fire({
                                    "title": "",
                                    "text": "Se realizo correctamente el pago en sistema.",
                                    "type": "success",
                                    "confirmButtonClass": "btn btn-secondary"
                                }).then(function () {
                                    window.location = "http://localhost:8080/nomasac/cliente/fondo/vpagos.jsp";
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
                                    "text": "Ocurrio un error al realizar el pago en sistema. Reintente mas tarde",
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
    KTPayPendientes.init();
});

