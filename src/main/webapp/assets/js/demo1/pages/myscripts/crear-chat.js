"use strict";
// Class definition
var KTAppCrChat = function () {

    var formEl;
    var initSubmit = function () {
        var btn = formEl.find('[data-ktwizard-type="action-submit"]');
        btn.on('click', function (e) {
            e.preventDefault();

            var iuser = $('#rut_u').val();
            var iprof = $('#rut_p').val();
            KTApp.progress(btn);

            const swalWithBootstrapButtons = Swal.mixin({
                customClass: {
                    confirmButton: 'btn btn-success',
                    cancelButton: 'btn btn-danger'
                },
                buttonsStyling: false
            })

            swalWithBootstrapButtons.fire({
                title: 'Confirmar Conversación',
                text: "Esta sera confidencial con el profesional elegido. continuar?",
                icon: 'warning',
                showCancelButton: true,
                confirmButtonText: 'Si, Continuar!',
                cancelButtonText: 'No, Cancelar!',
                reverseButtons: true
            }).then((result) => {
                if (result.value) {
                    formEl.ajaxSubmit({
                        type: "POST",
                        url: '../../Servlet_CrearChat',
                         data: {"rut_usuario": iuser, "rut_profesional": iprof},
                         success: function (data) {
                            switch (data) {
                             case'Creado':
                                setTimeout(function () {
                                    KTApp.unprogress(btn);
                                    formEl.clearForm();
                                    formEl.validate().resetForm();
                                    swal.fire({
                                        "title": "",
                                        "text": "Sala creada correctamente. PRESIONAR OK PARA CONTINUAR",
                                        "type": "success",
                                        "confirmButtonClass": "btn btn-secondary"
                                    }).then(function () {
                                        window.location = "http://localhost:8080/nomasac/cliente/chat/chat.jsp?id="+iprof;
                                    });
                                }, 2000);
                                break;
                            case'Error':
                                setTimeout(function () {
                                    KTUtil.scrollTop();
                                    KTApp.unprogress(btn);
                                    swal.fire({
                                        "title": "",
                                        "text": "Ocurrio un error al crear sala de chat. Reintente mas tarde",
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
            formEl = $('#crear_salachat');
            initSubmit();
        }
    };
}();
jQuery(document).ready(function () {
    KTAppCrChat.init();
});
