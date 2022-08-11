"use strict";


var KTStatusPerfil = function () {

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

    var handleStatus = function () {
        $('#kt_form_change_status').click(function (e) {
            e.preventDefault();

            var btn = $(this);
            var form = $(this).closest('form');
            var user = $('#rut_r').val();
            var stat = $(".message_pri:checked").val();
            
            var elem = document.getElementById('body');
            
            form.validate({
                rules: {
                    m_option_1: {
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
                url: '../../Servlet_EstadoCliente',
                data: {"userr": user, "est": stat},
                success: function (data) {
                    switch (data) {
                        case'Exito':
                            setTimeout(function () {
                                if(elem !== null){
                                     elem.parentNode.removeChild(elem);
                                     btn.removeClass('kt-spinner kt-spinner--right kt-spinner--sm kt-spinner--light').attr('disabled', false);
                                    form.clearForm();
                                    form.validate().resetForm();
                                    showErrorMsg(form, 'success', 'Se generó el cambio correctamente de estado. Estos serán reflejados de inmediato. Favor actualizar pagina');
                                }else{
                                   btn.removeClass('kt-spinner kt-spinner--right kt-spinner--sm kt-spinner--light').attr('disabled', false);
                                    form.clearForm();
                                    form.validate().resetForm();
                                    showErrorMsg(form, 'success', 'Se generó el cambio correctamente de estado. Estos serán reflejados de inmediato. Favor actualizar pagina');
                                }
                            }, 2000);
                            break;
                        case'Error':
                            setTimeout(function () {
                                 if(elem !== null){
                                     elem.parentNode.removeChild(elem);
                                     btn.removeClass('kt-spinner kt-spinner--right kt-spinner--sm kt-spinner--light').attr('disabled', false);
                                     showErrorMsg(form, 'danger', 'Error! No se ha podido cambiar el estado del usuario.');
                                }else{
                                    btn.removeClass('kt-spinner kt-spinner--right kt-spinner--sm kt-spinner--light').attr('disabled', false);
                                    showErrorMsg(form, 'danger', 'Error! No se ha podido cambiar el estado del usuario.');
                                }
                            }, 2000);
                            break;
                        case'False':
                            setTimeout(function () {
                                if(elem !== null){
                                     elem.parentNode.removeChild(elem);
                                     btn.removeClass('kt-spinner kt-spinner--right kt-spinner--sm kt-spinner--light').attr('disabled', false);
                                     showErrorMsg(form, 'danger', 'Error! Usuario no es valido en sistema.');
                                }else{
                                   btn.removeClass('kt-spinner kt-spinner--right kt-spinner--sm kt-spinner--light').attr('disabled', false);
                                   showErrorMsg(form, 'danger', 'Error! Usuario no es valido en sistema.');
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
            handleStatus();
        }
    };

}();

jQuery(document).ready(function () {
    KTStatusPerfil.init();
});

