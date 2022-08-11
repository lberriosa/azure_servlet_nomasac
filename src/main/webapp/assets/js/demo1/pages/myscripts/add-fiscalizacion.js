"use strict";


var KTFiscalizacion = function () {

    var showErrorMsg = function (form, type, msg) {
        var alert = $('<div id="body" class="kt-portlet__body">\
                           <div class="alert alert-' + type + ' alert-bold fade show " role="alert">\
                           <div class="alert-icon"><i class="fas fa-info-circle"></i></div>\
                           <div class="alert-text"><p></p></div>\
                           <div class="alert-close">\
                          <button type="button" class="close" data-dismiss="alert" aria-label="Close">\
                               <span aria-hidden="true"><i class="la la-close"></i></span>\
                           </button>\
                         </div>\
                        <\div>');

        form.find('.alert').remove();
        alert.prependTo(form);
        KTUtil.animateClass(alert[0], 'fadeIn animated');
        alert.find('p').html(msg);
    }

    var handlePassword = function () {
        $('#kt_form_mark_fiscalizacion').click(function (e) {
            e.preventDefault();

            var btn = $(this);
            var form = $(this).closest('form');
            var user = $('#rut_r').val();
            var desc = $('#desca').val();
            var fec = $('#kt_datepicker_8').val();
            var elem = document.getElementById('body');

            form.validate({
                rules: {
                    kt_datepicker_8: {
                        required: true
                    },
                    desca: {
                        required: true
                    }
                }
            });

            if (!form.valid()) {
                return;
            }

            btn.addClass('kt-spinner kt-spinner--right kt-spinner--sm kt-spinner--light').attr('disabled', true);

            const swalWithBootstrapButtons = Swal.mixin({
                customClass: {
                    confirmButton: 'btn btn-success',
                    cancelButton: 'btn btn-danger'
                },
                buttonsStyling: false
            })

            swalWithBootstrapButtons.fire({
                title: 'Desea informar fiscalización?',
                text: "Recuerde que solo podra acceder a este beneficio 10 veces al año.",
                icon: 'warning',
                showCancelButton: true,
                confirmButtonText: 'Si, Confirmar!',
                cancelButtonText: 'No, Cancelar!',
                reverseButtons: true
            }).then((result) => {
                if (result.value) {
                    form.ajaxSubmit({
                        type: "POST",
                        url: '../../Servlet_CrearFiscalizacion',
                        data: {"rut_usuario": user,"desc_acc": desc,"fech_acc":fec},
                        success: function (data) {
                            switch (data) {
                                case'Creado':
                                    setTimeout(function () {
                                        if (elem !== null) {
                                            elem.parentNode.removeChild(elem);
                                            btn.removeClass('kt-spinner kt-spinner--right kt-spinner--sm kt-spinner--light').attr('disabled', false);
                                            form.clearForm();
                                            form.validate().resetForm();
                                            showErrorMsg(form, 'success', 'Se informo correctamente la fiscalización. Supervisor evaluara visita a su empresa');
                                            swal.fire({
                                                "title": "",
                                                "text": "Se informo correctamente fiscalización en sistema !",
                                                "type": "success",
                                                "confirmButtonClass": "btn btn-secondary"
                                            }).then(function () {
                                                window.location = "http://localhost:8080/nomasac/cliente/fiscalizacion/";
                                            });

                                        } else {
                                            btn.removeClass('kt-spinner kt-spinner--right kt-spinner--sm kt-spinner--light').attr('disabled', false);
                                            form.clearForm();
                                            form.validate().resetForm();
                                            showErrorMsg(form, 'success', 'Se informo correctamente la fiscalización. Supervisor evaluara visita a su empresa');
                                            swal.fire({
                                                "title": "",
                                                "text": "Se informo correctamente fiscalización en sistema !",
                                                "type": "success",
                                                "confirmButtonClass": "btn btn-secondary"
                                            }).then(function () {
                                                window.location = "http://localhost:8080/nomasac/cliente/fiscalizacion/";
                                            });
                                        }
                                    }, 2000);
                                    break;
                                case'Limite':
                                    setTimeout(function () {
                                        if (elem !== null) {
                                            elem.parentNode.removeChild(elem);
                                            btn.removeClass('kt-spinner kt-spinner--right kt-spinner--sm kt-spinner--light').attr('disabled', false);
                                            showErrorMsg(form, 'danger', 'Error! Supera la cantidad máxima de informes.');
                                            swal.fire({
                                                "title": "",
                                                "text": "Ocurrio un error al informar fiscalización en sistema. Supera la cantidad máxima de informes",
                                                "type": "error",
                                                "buttonStyling": false,
                                                "confirmButtonClass": "btn btn-brand btn-sm btn-bold"
                                            });
                                        } else {
                                            btn.removeClass('kt-spinner kt-spinner--right kt-spinner--sm kt-spinner--light').attr('disabled', false);
                                            showErrorMsg(form, 'danger', 'Error! Supera la cantidad máxima de informes.');
                                            swal.fire({
                                                "title": "",
                                                "text": "Ocurrio un error al informar fiscalización en sistema. Supera la cantidad máxima de informes",
                                                "type": "error",
                                                "buttonStyling": false,
                                                "confirmButtonClass": "btn btn-brand btn-sm btn-bold"
                                            });
                                        }
                                    }, 2000);
                                    break;
                                case'Error':
                                    setTimeout(function () {
                                        if (elem !== null) {
                                            elem.parentNode.removeChild(elem);
                                            btn.removeClass('kt-spinner kt-spinner--right kt-spinner--sm kt-spinner--light').attr('disabled', false);
                                            showErrorMsg(form, 'danger', 'Error! No se ha podido informar accidente.');
                                            swal.fire({
                                                "title": "",
                                                "text": "Ocurrio un error al informar la fiscalización en sistema. Reintente mas tarde",
                                                "type": "error",
                                                "buttonStyling": false,
                                                "confirmButtonClass": "btn btn-brand btn-sm btn-bold"
                                            });
                                        } else {
                                            btn.removeClass('kt-spinner kt-spinner--right kt-spinner--sm kt-spinner--light').attr('disabled', false);
                                            showErrorMsg(form, 'danger', 'Error! No se ha podido informar fiscalización.');
                                            swal.fire({
                                                "title": "",
                                                "text": "Ocurrio un error al informar la fiscalización en sistema. Reintente mas tarde",
                                                "type": "error",
                                                "buttonStyling": false,
                                                "confirmButtonClass": "btn btn-brand btn-sm btn-bold"
                                            });
                                        }
                                    }, 2000);
                                    break;
                            }
                        }
                    });
                } else if (result.dismiss === Swal.DismissReason.cancel) {
                    btn.removeClass('kt-spinner kt-spinner--right kt-spinner--sm kt-spinner--light').attr('disabled', false);
                    return;

                }
            })
        });
    }


    return{
        init: function () {
            handlePassword();
        }
    };

}();

jQuery(document).ready(function () {
    KTFiscalizacion.init();
});