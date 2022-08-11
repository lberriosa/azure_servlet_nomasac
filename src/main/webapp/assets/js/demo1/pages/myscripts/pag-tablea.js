$(document).ready(function () {
        var table = $('#tabla_pagoa');

        // begin first table
        table.DataTable({
            responsive: true,
            columnDefs: [
                {
                    targets: 7,
                    render: function (data, type, full, meta) {
                        var status = {
                            0: {'title': 'Deshabilitado', 'class': 'kt-badge--danger'},
                            1: {'title': 'Activo', 'class': ' kt-badge--success'},
                            2: {'title': 'Editado', 'class': ' kt-badge--warning'},
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
