  $(document).ready(function () {
        var table = $('#tabla_contrato');

        // begin first table
        table.DataTable({
            responsive: true,
            columnDefs: [
                {
                    targets: 6,
                    render: function (data, type, full, meta) {
                        var status = {
                            0: {'title': 'No Pagado', 'class': 'kt-badge--danger'},
                            1: {'title': 'Contrato Activo', 'class': ' kt-badge--success'},
                            2: {'title': 'Contrato Deshabilitado', 'class': ' kt-badge--warning'},
                        };
                        if (typeof status[data] === 'undefined') {
                            return data;
                        }
                        return '<span class="kt-badge ' + status[data].class + ' kt-badge--inline kt-badge--pill">' + status[data].title + '</span>';
                    },
                },
                
                  {
                    targets: 5,
                    render: function (data, type, full, meta) {
                        var status = {
                            0: {'title': 'No Modificado', 'class': 'kt-badge--success'},
                            1: {'title': 'Contrato Modificado', 'class': ' kt-badge--warning'},
                        };
                        if (typeof status[data] === 'undefined') {
                            return data;
                        }
                        return '<span class="kt-badge ' + status[data].class + ' kt-badge--inline kt-badge--pill">' + status[data].title + '</span>';
                    },
                },
            ],
        });


    });





