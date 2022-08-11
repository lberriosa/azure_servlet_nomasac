"use strict";


var KTEditUserA = function () {

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
        $('#kt_form_edit_admin').click(function (e) {
            e.preventDefault();

            var btn = $(this);
            var form = $(this).closest('form');
            var user = $('#rut_r').val();
            var nuser = $('#nomb_admin').val();
            var auser = $('#app_admin').val();
            var duser = $('#dire_admin').val();
            var tuser = $('#tele_admin').val();
            var cuser = $('#corr_admin').val();
            
            var elem = document.getElementById('body');
            
            form.validate({
                rules: {
                    tele_admin: {
                        required: true,
                        digits: true,
                        minlength: 9,
                        maxlength: 12
                    },
                    corr_admin: {
                        required: true,
                        email: true
                    },
                    nomb_admin: {
                        required: true
                    },
                    app_admin: {
                        required: true
                    },
                    dire_admin: {
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
                url: '../../Servlet_EditarPAdmin',
                data: {"userr": user, "nomb_user": nuser, "app_user": auser,"dir_user": duser , "tel_user": tuser , "cor_user": cuser},
                success: function (data) {
                    switch (data) {
                        case'Exito':
                            setTimeout(function () {
                                if(elem !== null){
                                     elem.parentNode.removeChild(elem);
                                     btn.removeClass('kt-spinner kt-spinner--right kt-spinner--sm kt-spinner--light').attr('disabled', false);
                                    showErrorMsg(form, 'success', 'Se actualizaron tus datos correctamente. Cambios serán reflejados al momento de actualizar');
                                }else{
                                   btn.removeClass('kt-spinner kt-spinner--right kt-spinner--sm kt-spinner--light').attr('disabled', false);   
                                    showErrorMsg(form, 'success', 'Se actualizaron tus datos correctamente. Cambios serán reflejados al momento de actualizar');
                                }
                            }, 2000);
                            break;
                        case'Error':
                            setTimeout(function () {
                                 if(elem !== null){
                                     elem.parentNode.removeChild(elem);
                                     btn.removeClass('kt-spinner kt-spinner--right kt-spinner--sm kt-spinner--light').attr('disabled', false);
                                     showErrorMsg(form, 'danger', 'Error! No se ha podido actualizar los datos de tu usuario.');
                                }else{
                                    btn.removeClass('kt-spinner kt-spinner--right kt-spinner--sm kt-spinner--light').attr('disabled', false);
                                    showErrorMsg(form, 'danger', 'Error! No se ha podido actualizar los datos de tu usuario.');
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
            handleEdit();
        }
    };

}();

jQuery(document).ready(function () {
    KTEditUserA.init();
});




