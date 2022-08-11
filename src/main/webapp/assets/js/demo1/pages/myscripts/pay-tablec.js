  $(document).ready(function () {
        var table = $('#tabla_pagoc');

        // begin first table
        table.DataTable({
            responsive: true,
            columnDefs: [
                {
                    targets: 5,
                    render: function (data, type, full, meta) {
                        var status = {
                            0: {'title': 'No Pagado', 'class': 'kt-badge--danger'},
                            1: {'title': 'Pagado', 'class': ' kt-badge--success'},
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