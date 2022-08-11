<%-- 
    Document   : header
    Created on : 9/04/2020, 08:31:54 PM
    Author     : lberr
--%>

<%@page import="Clases.Contrato_DB"%>
<%@page import="Clases.Contrato"%>
<%@page import="Clases.Usuario_DB"%>
<%@page import="Clases.Usuario"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html lang="zxx">

    <!-- begin::Head -->
    <head>
        <%
            session = request.getSession(false);
            if (session.getAttribute("usuario") != null) {
                if (!session.getAttribute("tipo").equals("Cliente")) {
                    response.sendRedirect("../../");
                } else {
                }
            } else {
                response.sendRedirect("../../");
            }
        %> 

        <%
            String codigo = (String) session.getAttribute("usuario");
            Usuario u = Usuario_DB.BuscarUsuario(codigo);
        %>
        <!--end::Base Path -->
        <meta charset="utf-8" />
        <title>No Más Accidentes</title>
        <meta name="description" content="Updates and statistics">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

        <!--begin::Fonts -->
        <script src="https://ajax.googleapis.com/ajax/libs/webfont/1.6.16/webfont.js"></script>
        <script>
            WebFont.load({
                google: {
                    "families": ["Poppins:300,400,500,600,700", "Roboto:300,400,500,600,700"]
                },
                active: function () {
                    sessionStorage.fonts = true;
                }
            });
        </script>

        <!--end::Fonts -->

        <!--begin::Page Vendors Styles(used by this page) -->
        <link href="http://localhost:8080/nomasac/assets/vendors/custom/fullcalendar/fullcalendar.bundle.css" rel="stylesheet" type="text/css" />
        <link href="http://localhost:8080/nomasac/assets/css/demo1/pages/general/invoices/invoice-2.css" rel="stylesheet" type="text/css" />
        <link href="http://localhost:8080/nomasac/assets/vendors/custom/datatables/datatables.bundle.css" rel="stylesheet" type="text/css" />
        <link href="http://localhost:8080/nomasac/assets/css/demo1/pages/general/wizard/wizard-2.css" rel="stylesheet" type="text/css" />

        <!--end::Page Vendors Styles -->

        <!--begin:: Global Mandatory Vendors -->
        <link href="http://localhost:8080/nomasac/assets/vendors/general/perfect-scrollbar/css/perfect-scrollbar.css" rel="stylesheet" type="text/css" />

        <!--end:: Global Mandatory Vendors -->

        <!--begin:: Global Optional Vendors -->
        <link href="http://localhost:8080/nomasac/assets/vendors/general/tether/dist/css/tether.css" rel="stylesheet" type="text/css" />
        <link href="http://localhost:8080/nomasac/assets/vendors/general/bootstrap-datepicker/dist/css/bootstrap-datepicker3.css" rel="stylesheet" type="text/css" />
        <link href="http://localhost:8080/nomasac/assets/vendors/general/bootstrap-datetime-picker/css/bootstrap-datetimepicker.css" rel="stylesheet" type="text/css" />
        <link href="http://localhost:8080/nomasac/assets/vendors/general/bootstrap-timepicker/css/bootstrap-timepicker.css" rel="stylesheet" type="text/css" />
        <link href="http://localhost:8080/nomasac/assets/vendors/general/bootstrap-daterangepicker/daterangepicker.css" rel="stylesheet" type="text/css" />
        <link href="http://localhost:8080/nomasac/assets/vendors/general/bootstrap-touchspin/dist/jquery.bootstrap-touchspin.css" rel="stylesheet" type="text/css" />
        <link href="http://localhost:8080/nomasac/assets/vendors/general/bootstrap-select/dist/css/bootstrap-select.css" rel="stylesheet" type="text/css" />
        <link href="http://localhost:8080/nomasac/assets/vendors/general/bootstrap-switch/dist/css/bootstrap3/bootstrap-switch.css" rel="stylesheet" type="text/css" />
        <link href="http://localhost:8080/nomasac/assets/vendors/general/select2/dist/css/select2.css" rel="stylesheet" type="text/css" />
        <link href="http://localhost:8080/nomasac/assets/vendors/general/ion-rangeslider/css/ion.rangeSlider.css" rel="stylesheet" type="text/css" />
        <link href="http://localhost:8080/nomasac/assets/vendors/general/nouislider/distribute/nouislider.css" rel="stylesheet" type="text/css" />
        <link href="http://localhost:8080/nomasac/assets/vendors/general/owl.carousel/dist/assets/owl.carousel.css" rel="stylesheet" type="text/css" />
        <link href="http://localhost:8080/nomasac/assets/vendors/general/owl.carousel/dist/assets/owl.theme.default.css" rel="stylesheet" type="text/css" />
        <link href="http://localhost:8080/nomasac/assets/vendors/general/dropzone/dist/dropzone.css" rel="stylesheet" type="text/css" />
        <link href="http://localhost:8080/nomasac/assets/vendors/general/summernote/dist/summernote.css" rel="stylesheet" type="text/css" />
        <link href="http://localhost:8080/nomasac/assets/vendors/general/bootstrap-markdown/css/bootstrap-markdown.min.css" rel="stylesheet" type="text/css" />
        <link href="http://localhost:8080/nomasac/assets/vendors/general/animate.css/animate.css" rel="stylesheet" type="text/css" />
        <link href="http://localhost:8080/nomasac/assets/vendors/general/toastr/build/toastr.css" rel="stylesheet" type="text/css" />
        <link href="http://localhost:8080/nomasac/assets/vendors/general/morris.js/morris.css" rel="stylesheet" type="text/css" />
        <link href="http://localhost:8080/nomasac/assets/vendors/general/sweetalert2/dist/sweetalert2.css" rel="stylesheet" type="text/css" />
        <link href="http://localhost:8080/nomasac/assets/vendors/general/socicon/css/socicon.css" rel="stylesheet" type="text/css" />
        <link href="http://localhost:8080/nomasac/assets/vendors/custom/vendors/line-awesome/css/line-awesome.css" rel="stylesheet" type="text/css" />
        <link href="http://localhost:8080/nomasac/assets/vendors/custom/vendors/flaticon/flaticon.css" rel="stylesheet" type="text/css" />
        <link href="http://localhost:8080/nomasac/assets/vendors/custom/vendors/flaticon2/flaticon.css" rel="stylesheet" type="text/css" />
        <link href="http://localhost:8080/nomasac/assets/vendors/general/@fortawesome/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css" />

        <!--end:: Global Optional Vendors -->

        <!--begin::Global Theme Styles(used by all pages) -->
        <link href="http://localhost:8080/nomasac/assets/css/demo1/style.bundle.css" rel="stylesheet" type="text/css" />

        <!--end::Global Theme Styles -->

        <!--begin::Layout Skins(used by all pages) -->
        <link href="http://localhost:8080/nomasac/assets/css/demo1/skins/header/base/light.css" rel="stylesheet" type="text/css" />
        <link href="http://localhost:8080/nomasac/assets/css/demo1/skins/header/menu/light.css" rel="stylesheet" type="text/css" />
        <link href="http://localhost:8080/nomasac/assets/css/demo1/skins/brand/dark.css" rel="stylesheet" type="text/css" />
        <link href="http://localhost:8080/nomasac/assets/css/demo1/skins/aside/dark.css" rel="stylesheet" type="text/css" />

        <!--end::Layout Skins -->
        <link rel="shortcut icon" href="http://localhost:8080/nomasac/assets/media/logos/logo.png" />
    </head>

    <!-- end::Head -->

    <!-- begin::Body -->
    <body class="kt-quick-panel--right kt-demo-panel--right kt-offcanvas-panel--right kt-header--fixed kt-header-mobile--fixed kt-subheader--fixed kt-subheader--enabled kt-subheader--solid kt-aside--enabled kt-aside--fixed kt-page--loading">

        <%
            
            Contrato con = Contrato_DB.BuscarContrato(codigo);
            if (con.getFolio_contrato() == 0 && con.getEstado() == 0) {
        %>
            <%@include file="headersc.jsp" %> 
        <%
            } else if(con.getFolio_contrato() != 0 && con.getEstado() == 0) {
        %>
            <%@include file="headercc.jsp" %>
        <%
            } else if(con.getFolio_contrato() != 0 && con.getEstado() == 1){
        %>
            <%@include file="headerccp.jsp" %>
        <%
            } 
        %>