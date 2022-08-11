"use strict";
// Class definition
var KTAppCActividad = function () {

    var formEl;
    var initSubmit = function () {
        var btn = formEl.find('[data-ktwizard-type="action-submit"]');
        btn.on('click', function (e) {
            e.preventDefault();

            var iuser = $('#rut_r').val();
            var iacti = $('#id_act').val();
            var iserv = $('#id_serv').val();
            var ialer = $('#id_a').val();
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
                text: "Al cancelar no podra volver a gestionar la actividad",
                icon: 'warning',
                showCancelButton: true,
                confirmButtonText: 'Si, Confirmar!',
                cancelButtonText: 'No, Cancelar!',
                reverseButtons: true
            }).then((result) => {
                if (result.value) {
                    formEl.ajaxSubmit({
                        type: "POST",
                        url: '../../Servlet_CancelarActividadAl',
                         data: {"rut_usuario": iuser, "id_activi": iacti, "id_servici":iserv,"id_alerta":ialer},
                         success: function (data) {
                            switch (data) {
                             case'Cancelado':
                                setTimeout(function () {
                                    KTApp.unprogress(btn);
                                    formEl.clearForm();
                                    formEl.validate().resetForm();
                                    swal.fire({
                                        "title": "",
                                        "text": "Se cancelo correctamente actividad en sistema !",
                                        "type": "success",
                                        "confirmButtonClass": "btn btn-secondary"
                                    }).then(function () {
                                        window.location = "http://localhost:8080/nomasac/profesional/accidente/";
                                    });
                                }, 2000);
                                break;
                            case'Error':
                                setTimeout(function () {
                                    KTUtil.scrollTop();
                                    KTApp.unprogress(btn);
                                    swal.fire({
                                        "title": "",
                                        "text": "Ocurrio un error al cancelar actividad en sistema. Reintente mas tarde",
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
            formEl = $('#cancelaaccidente');
            initSubmit();
        }
    };
}();
jQuery(document).ready(function () {
    KTAppCActividad.init();
});
