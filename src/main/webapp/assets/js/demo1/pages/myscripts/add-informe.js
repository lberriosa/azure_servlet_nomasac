"use strict";


var KTInserInforme = function () {

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
        $('#kt_form_ing_informe').click(function (e) {
            e.preventDefault();

            var btn = $(this);
            var form = $(this).closest('form');
            var desc = $('#descc').val();
            var rut = $('#rut_r').val();
            var ida = $('#id_a').val();

            if (document.getElementById("file").files.length === 0) {
                console.log("no files selected");
            } else {
                var file_data = $('#file').prop('files')[0];
                var form_data = new FormData();
                form_data.append('file', file_data);
                form_data.append('descripcion', desc);
                form_data.append('rut_user', rut);
                form_data.append('ide_acti', ida);
            }


            var elem = document.getElementById('body');

            form.validate({
                rules: {
                    descc: {
                        required: true
                    }
                }
            });

            if (!form.valid()) {
                return;
            }

            btn.addClass('kt-spinner kt-spinner--right kt-spinner--sm kt-spinner--light').attr('disabled', true);

            $.ajax({
                type: "POST",
                encType: "multipart/form-data",
                url: '../../Servlet_IngresarInforme',
                cache: false,
                processData: false,
                contentType: false,
                data: form_data,
                success: function (data) {
                    switch (data) {
                        case'Ingresado':
                            setTimeout(function () {
                                if (elem !== null) {
                                    elem.parentNode.removeChild(elem);
                                    btn.removeClass('kt-spinner kt-spinner--right kt-spinner--sm kt-spinner--light').attr('disabled', false);
                                    showErrorMsg(form, 'success', 'Se ingreso correctamente informe en sistema. Cambios seran reflejados a la brevedad');
                                } else {
                                    btn.removeClass('kt-spinner kt-spinner--right kt-spinner--sm kt-spinner--light').attr('disabled', false);
                                    showErrorMsg(form, 'success', 'Se ingreso correctamente informe en sistema. Cambios seran reflejados a la brevedad');
                                }

                                swal.fire({
                                    "title": "",
                                    "text": "Se ingresaron correctamente los datos en sistema !",
                                    "type": "success",
                                    "confirmButtonClass": "btn btn-secondary"
                                }).then(function () {
                                    window.location = "http://localhost:8080/nomasac/profesional/capacitacion/";
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
    KTInserInforme.init();
});