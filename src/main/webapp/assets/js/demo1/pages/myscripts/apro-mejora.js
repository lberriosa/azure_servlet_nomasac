"use strict";
// Class definition
var KTAppAMejora = function () {

    var formEl;
    var initSubmit = function () {
        var btn = formEl.find('[data-ktwizard-type="action-submit"]');
        btn.on('click', function (e) {
            e.preventDefault();

            var iuser = $('#rut_r').val();
            var iprof = $('#id_p').val();
            var ictiv = $('#id_a').val();
            var iserv = $('#id_s').val();
            var imejo = $('#id_m').val();
            var iapro = $('#id_ap').val();
            KTApp.progress(btn);

            const swalWithBootstrapButtons = Swal.mixin({
                customClass: {
                    confirmButton: 'btn btn-success',
                    cancelButton: 'btn btn-danger'
                },
                buttonsStyling: false
            })

            swalWithBootstrapButtons.fire({
                title: 'Estas Segur@?',
                text: "Al aprobar mejora quedara visible para cliente y aplicable a empresa",
                icon: 'warning',
                showCancelButton: true,
                confirmButtonText: 'Si, Confirmar!',
                cancelButtonText: 'No, Cancelar!',
                reverseButtons: true
            }).then((result) => {
                if (result.value) {
                    formEl.ajaxSubmit({
                        type: "POST",
                        url: '../../Servlet_AprobarMejora',
                         data: {"rut_usuario": iuser,"rut_profes": iprof, "id_activi": ictiv, "id_servici":iserv,"id_mejora":imejo,"id_aprob":iapro},
                         success: function (data) {
                            switch (data) {
                             case'Aprobado':
                                setTimeout(function () {
                                    KTApp.unprogress(btn);
                                    formEl.clearForm();
                                    formEl.validate().resetForm();
                                    swal.fire({
                                        "title": "",
                                        "text": "Se aprobo correctamente mejora en sistema !",
                                        "type": "success",
                                        "confirmButtonClass": "btn btn-secondary"
                                    }).then(function () {
                                        window.location = "http://localhost:8080/nomasac/profesional/mejora/";
                                    });
                                }, 2000);
                                break;
                            case'Error':
                                setTimeout(function () {
                                    KTUtil.scrollTop();
                                    KTApp.unprogress(btn);
                                    swal.fire({
                                        "title": "",
                                        "text": "Ocurrio un error al aprobar mejora en sistema. Reintente mas tarde",
                                        "type": "error",
                                        "buttonStyling": false,
                                        "confirmButtonClass": "btn btn-brand btn-sm btn-bold"
                                    });
                                }, 2000);
                                break;
                            }
                         }
                     }); 
                } else if ( result.dismiss === Swal.DismissReason.cancel) {
                    KTApp.unprogress(btn);
                    return;    
                }
            })


        });
    }

    return {
        // public functions
        init: function () {
            formEl = $('#aprobar_mejora');
            initSubmit();
        }
    };
}();
jQuery(document).ready(function () {
    KTAppAMejora.init();
});