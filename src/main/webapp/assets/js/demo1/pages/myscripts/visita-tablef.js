  $(document).ready(function () {
        var table = $('#tabla_visitasc');

        // begin first table
        table.DataTable({
            responsive: true,
            columnDefs: [
                {
                    targets: 5,
                    render: function (data, type, full, meta) {
                        var status = {
                            1: {'title': 'Creada', 'class': 'kt-badge--info'},
                            2: {'title': 'En Progreso', 'class': ' kt-badge--primary'},
                            3: {'title': 'Sin Informe', 'class': ' kt-badge--warning'},
                            4: {'title': 'Terminada', 'class': ' kt-badge--success'},
                            5: {'title': 'Cancelada', 'class': ' kt-badge--danger'},
                        };
                        if (typeof status[data] === 'undefined') {
                            return data;
                        }
                        return '<span class="kt-badge ' + status[data].class + ' kt-badge--inline kt-badge--pill">' + status[data].title + '</span>';
                    },
                },
                
                  {
                    targets: 6,
                    render: function (data, type, full, meta) {
                        var status = {
                            0: {'title': 'No Pagado', 'class': 'kt-badge--danger'},
                            1: {'title': 'Pagado', 'class': ' kt-badge--success'} 
                        };
                        if (typeof status[data] === 'undefined') {
                            return data;
                        }
                        return '<span class="kt-badge ' + status[data].class + ' kt-badge--inline kt-badge--pill">' + status[data].title + '</span>';
                    },
                },
                
                  {
                    targets: 7,
                    render: function (data, type, full, meta) {
                        var status = {
                            0: {'title': 'Deshabilitado', 'class': 'kt-badge--danger'},
                            1: {'title': 'Activo', 'class': ' kt-badge--success'},
                            2: {'title': 'Reprogramado', 'class': ' kt-badge--warning'},
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

