$(document).ready(function () {
        var table = $('#tabla_inasistc');

        // begin first table
        table.DataTable({
            responsive: true,
            columnDefs: [
                {
                    targets: 6,
                    render: function (data, type, full, meta) {
                        var status = {
                            1: {'title': 'Asistencia', 'class': 'kt-badge--success'},
                            2: {'title': 'Inasistencia', 'class': ' kt-badge--warning'}
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