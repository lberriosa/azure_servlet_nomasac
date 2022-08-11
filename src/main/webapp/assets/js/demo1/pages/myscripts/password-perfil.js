"use strict";


var KTPassPerfil = function () {

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
        $('#kt_form_pass_recovery').click(function (e) {
            e.preventDefault();

            var btn = $(this);
            var form = $(this).closest('form');
            var user = $('#rut_r').val();
            var pwd = $('#password_r').val();
            var rpwd = $('#rpassword_r').val();
            var elem = document.getElementById('body');
            
            form.validate({
                rules: {
                    password_r: {
                        required: true
                    },
                    rpassword_r: {
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
                url: '../../Servlet_rpass',
                data: {"userr": user, "password": pwd, "rpassword": rpwd},
                success: function (data) {
                    switch (data) {
                        case'Exito':
                            setTimeout(function () {
                                if(elem !== null){
                                     elem.parentNode.removeChild(elem);
                                     btn.removeClass('kt-spinner kt-spinner--right kt-spinner--sm kt-spinner--light').attr('disabled', false);
                                    form.clearForm();
                                    form.validate().resetForm();
                                    showErrorMsg(form, 'success', 'Se restauro la contraseña correctamente. Deberá ser ocupada en el próximo inicio de sesión');
                                }else{
                                   btn.removeClass('kt-spinner kt-spinner--right kt-spinner--sm kt-spinner--light').attr('disabled', false);
                                    form.clearForm();
                                    form.validate().resetForm();
                                    showErrorMsg(form, 'success', 'Se restauro la contraseña correctamente. Deberá ser ocupada en el próximo inicio de sesión');
                                }
                            }, 2000);
                            break;
                        case'Error':
                            setTimeout(function () {
                                 if(elem !== null){
                                     elem.parentNode.removeChild(elem);
                                     btn.removeClass('kt-spinner kt-spinner--right kt-spinner--sm kt-spinner--light').attr('disabled', false);
                                     showErrorMsg(form, 'danger', 'Error! No se ha podido cambiar su contraseña.');
                                }else{
                                    btn.removeClass('kt-spinner kt-spinner--right kt-spinner--sm kt-spinner--light').attr('disabled', false);
                                    showErrorMsg(form, 'danger', 'Error! No se ha podido cambiar su contraseña.');
                                }
                            }, 2000);
                            break;
                        case'Invalido':
                            setTimeout(function () {
                                if(elem !== null){
                                     elem.parentNode.removeChild(elem);
                                     btn.removeClass('kt-spinner kt-spinner--right kt-spinner--sm kt-spinner--light').attr('disabled', false);
                                     showErrorMsg(form, 'danger', 'Error! Password no coindicen.');
                                }else{
                                    btn.removeClass('kt-spinner kt-spinner--right kt-spinner--sm kt-spinner--light').attr('disabled', false);
                                     showErrorMsg(form, 'danger', 'Error! Password no coindicen.');
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
            handlePassword();
        }
    };

}();

jQuery(document).ready(function () {
    KTPassPerfil.init();
});

