  $(document).ready(function () {
        var table = $('#tabla_chatc');

        // begin first table
        table.DataTable({
            responsive: true,
            columnDefs: [
                {
                    targets: 4,
                    render: function (data, type, full, meta) {
                        var status = {
                            1: {'title': 'Chat Activo', 'class': 'kt-badge--success'},
                            4: {'title': 'Solucionado', 'class': ' kt-badge--warning'},
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
