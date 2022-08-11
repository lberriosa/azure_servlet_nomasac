"use strict";


var KTInserAsisAL = function () {

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

    var handleEdit = function () {
        $('#kt_form_mark_asistencia_al').click(function (e) {
            e.preventDefault();

            var btn = $(this);
            var form = $(this).closest('form');
            var user = $('#rut_r').val();
            var ida = $('#id_act').val();
            var ids = $('#id_serv').val();
            var idal = $('#id_a').val();
            var asis = $(".asistencia_pro:checked").val();
            var desc = $('#descp').val();
            
            var elem = document.getElementById('body');

            form.validate({
                rules: {
                    descp: {
                        required: true
                    }
                }
            });

            if (!form.valid()) {
                return;
            }

            btn.addClass('kt-spinner kt-spinner--right kt-spinner--sm kt-spinner--light').attr('disabled', true);

            form.ajaxSubmit({
                type: "POST",
                url: '../../Servlet_CrearAsistenciaAcc',
                data: {"userr": user,"id_act":ida,"id_ser":ids,"id_alerta":idal, "check_a":asis,"desc_a":desc},
                success: function (data) {
                    switch (data) {
                        case'Ingresado':
                            setTimeout(function () {
                                if (elem !== null) {
                                    elem.parentNode.removeChild(elem);
                                    btn.removeClass('kt-spinner kt-spinner--right kt-spinner--sm kt-spinner--light').attr('disabled', false);
                                    showErrorMsg(form, 'success', 'Se ingreso correctamente dato en sistema. Cambios seran reflejados a la brevedad');
                                } else {
                                    btn.removeClass('kt-spinner kt-spinner--right kt-spinner--sm kt-spinner--light').attr('disabled', false);
                                    showErrorMsg(form, 'success', 'Se ingreso correctamente dato en sistema. Cambios seran reflejados a la brevedad');
                                }

                                swal.fire({
                                    "title": "",
                                    "text": "Se ingresaron correctamente los datos en sistema !",
                                    "type": "success",
                                    "confirmButtonClass": "btn btn-secondary"
                                }).then(function () {
                                    window.location = "http://localhost:8080/nomasac/cliente/accidente/";
                                });


                            }, 2000);
                            break;
                        case'IngresadoA':
                            setTimeout(function () {
                                if (elem !== null) {
                                    elem.parentNode.removeChild(elem);
                                    btn.removeClass('kt-spinner kt-spinner--right kt-spinner--sm kt-spinner--light').attr('disabled', false);
                                    showErrorMsg(form, 'success', 'Se ingreso correctamente dato en sistema. Actividad sera cerrada por sistema');
                                } else {
                                    btn.removeClass('kt-spinner kt-spinner--right kt-spinner--sm kt-spinner--light').attr('disabled', false);
                                    showErrorMsg(form, 'success', 'Se ingreso correctamente dato en sistema. Actividad sera cerrada por sistema');
                                }

                                swal.fire({
                                    "title": "",
                                    "text": "Se ingresaron correctamente los datos en sistema !",
                                    "type": "success",
                                    "confirmButtonClass": "btn btn-secondary"
                                }).then(function () {
                                    window.location = "http://localhost:8080/nomasac/cliente/accidente/";
                                });


                            }, 2000);
                            break;
                        case'Error':
                            setTimeout(function () {
                                if (elem !== null) {
                                    elem.parentNode.removeChild(elem);
                                    btn.removeClass('kt-spinner kt-spinner--right kt-spinner--sm kt-spinner--light').attr('disabled', false);
                                    showErrorMsg(form, 'danger', 'Error! No se ha podido ingresar los datos correctamente. reintente mas tarde.');
                                } else {
                                    btn.removeClass('kt-spinner kt-spinner--right kt-spinner--sm kt-spinner--light').attr('disabled', false);
                                    showErrorMsg(form, 'danger', 'Error! No se ha podido ingresar los datos correctamente. reintente mas tarde.');
                                }
                            }, 2000);
                            break;
                    }
                }
            });
        });
    }

    return{
        init: function () {
            handleEdit();
        }
    };

}();

jQuery(document).ready(function () {
    KTInserAsisAL.init();
});
