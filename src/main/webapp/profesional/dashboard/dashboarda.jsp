<%-- 
    Document   : dashboarda
    Created on : 9/07/2020, 06:04:33 PM
    Author     : lberr
--%>

<%@page import="Clases.*"%>
<%@page import="com.google.gson.Gson"%>
<%@page import="java.util.ArrayList"%>
<%
    String code = (String) session.getAttribute("usuario");
%>
<div class="kt-content  kt-grid__item kt-grid__item--fluid" id="kt_content">

    <!--Begin::Dashboard 1-->

    <!--Begin::Section-->
    <div class="row">
        <div class="col-xl-4">

            <!--begin:: Widgets/Activity-->
            <div class="kt-portlet kt-portlet--fit kt-portlet--head-lg kt-portlet--head-overlay kt-portlet--skin-solid kt-portlet--height-fluid">
                <div class="kt-portlet__head kt-portlet__head--noborder kt-portlet__space-x">
                    <div class="kt-portlet__head-label">
                        <h3 class="kt-portlet__head-title">
                            Actividades
                        </h3>
                    </div>

                </div>
                <div class="kt-portlet__body kt-portlet__body--fit">
                    <div class="kt-widget17">
                        <div class="kt-widget17__visual kt-widget17__visual--chart kt-portlet-fit--top kt-portlet-fit--sides" style="background-color: #fd397a">
                            <div class="kt-widget17__chart" style="height:320px;">
                                <canvas id="kt_chart_activities"></canvas>
                                    <%
                                        ArrayList<Estadistica> listaa = Estadistica_BD.totalInterac_ASI(code);
                                        String jsona = new Gson().toJson(listaa);

                                        int t_interacciona = Estadistica_BD.t_Interacciones_Asi(code);
                                        int t_interaccionap = Estadistica_BD.t_IAprobadas_Asi(code);
                                    %>

                                <input type="hidden" value='<%=jsona%>' id="e_esta_t">

                            </div>
                        </div>
                        <div class="kt-widget17__stats">
                            <div class="kt-widget17__items">
                                <div class="kt-widget17__item">
                                    <span class="kt-widget17__icon">
                                        <svg xmlns="http://www.w3.org/2000/svg" xmlns:xlink="http://www.w3.org/1999/xlink" width="24px" height="24px" viewBox="0 0 24 24" version="1.1" class="kt-svg-icon kt-svg-icon--brand">
                                            <g stroke="none" stroke-width="1" fill="none" fill-rule="evenodd">
                                                <rect id="bound" x="0" y="0" width="24" height="24" />
                                                <path d="M5,3 L6,3 C6.55228475,3 7,3.44771525 7,4 L7,20 C7,20.5522847 6.55228475,21 6,21 L5,21 C4.44771525,21 4,20.5522847 4,20 L4,4 C4,3.44771525 4.44771525,3 5,3 Z M10,3 L11,3 C11.5522847,3 12,3.44771525 12,4 L12,20 C12,20.5522847 11.5522847,21 11,21 L10,21 C9.44771525,21 9,20.5522847 9,20 L9,4 C9,3.44771525 9.44771525,3 10,3 Z" id="Combined-Shape" fill="#000000" />
                                                <rect id="Rectangle-Copy-2" fill="#000000" opacity="0.3" transform="translate(17.825568, 11.945519) rotate(-19.000000) translate(-17.825568, -11.945519) " x="16.3255682" y="2.94551858" width="3" height="18" rx="1" />
                                            </g>
                                        </svg> </span>
                                    <span class="kt-widget17__subtitle">
                                        Interacciones
                                    </span>
                                    <span class="kt-widget17__desc">
                                        <%=t_interacciona%> en total
                                    </span>
                                </div>
                                <div class="kt-widget17__item">
                                    <span class="kt-widget17__icon">
                                        <svg xmlns="http://www.w3.org/2000/svg" xmlns:xlink="http://www.w3.org/1999/xlink" width="24px" height="24px" viewBox="0 0 24 24" version="1.1" class="kt-svg-icon kt-svg-icon--success">
                                            <g stroke="none" stroke-width="1" fill="none" fill-rule="evenodd">
                                                <polygon id="Bound" points="0 0 24 0 24 24 0 24" />
                                                <path d="M12.9336061,16.072447 L19.36,10.9564761 L19.5181585,10.8312381 C20.1676248,10.3169571 20.2772143,9.3735535 19.7629333,8.72408713 C19.6917232,8.63415859 19.6104327,8.55269514 19.5206557,8.48129411 L12.9336854,3.24257445 C12.3871201,2.80788259 11.6128799,2.80788259 11.0663146,3.24257445 L4.47482784,8.48488609 C3.82645598,9.00054628 3.71887192,9.94418071 4.23453211,10.5925526 C4.30500305,10.6811601 4.38527899,10.7615046 4.47382636,10.8320511 L4.63,10.9564761 L11.0659024,16.0730648 C11.6126744,16.5077525 12.3871218,16.5074963 12.9336061,16.072447 Z" id="Shape" fill="#000000" fill-rule="nonzero" />
                                                <path d="M11.0563554,18.6706981 L5.33593024,14.122919 C4.94553994,13.8125559 4.37746707,13.8774308 4.06710397,14.2678211 C4.06471678,14.2708238 4.06234874,14.2738418 4.06,14.2768747 L4.06,14.2768747 C3.75257288,14.6738539 3.82516916,15.244888 4.22214834,15.5523151 C4.22358765,15.5534297 4.2250303,15.55454 4.22647627,15.555646 L11.0872776,20.8031356 C11.6250734,21.2144692 12.371757,21.2145375 12.909628,20.8033023 L19.7677785,15.559828 C20.1693192,15.2528257 20.2459576,14.6784381 19.9389553,14.2768974 C19.9376429,14.2751809 19.9363245,14.2734691 19.935,14.2717619 L19.935,14.2717619 C19.6266937,13.8743807 19.0546209,13.8021712 18.6572397,14.1104775 C18.654352,14.112718 18.6514778,14.1149757 18.6486172,14.1172508 L12.9235044,18.6705218 C12.377022,19.1051477 11.6029199,19.1052208 11.0563554,18.6706981 Z" id="Path" fill="#000000" opacity="0.3" />
                                            </g>
                                        </svg> </span>
                                    <span class="kt-widget17__subtitle">
                                        Cumplidas
                                    </span>
                                    <span class="kt-widget17__desc">
                                        <%=t_interaccionap%> aprobadas
                                    </span>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>

            <!--end:: Widgets/Activity-->
        </div>
          <div class="col-xl-4">

            <!--begin:: Widgets/Inbound Bandwidth-->
                <div class="kt-portlet kt-portlet--fit kt-portlet--head-noborder kt-portlet--height-fluid-half">
                    <div class="kt-portlet__head kt-portlet__space-x">
                        <div class="kt-portlet__head-label">
                            <h3 class="kt-portlet__head-title">
                                Profesionales
                            </h3>
                        </div>
                        <%
                            int t_profesio_a = Estadistica_BD.t_Prof_Cli();
                            ArrayList<Estadistica> lista2a = Estadistica_BD.totalRendimiento_Adm();
                            String json2a = new Gson().toJson(lista2a);
                        %>
                    </div>
                    <input type="hidden" value='<%=json2a%>' id="e_t_actividadesprom">

                    <div class="kt-portlet__body kt-portlet__body--fluid">
                        <div class="kt-widget20">
                            <div class="kt-widget20__content kt-portlet__space-x">
                                <span class="kt-widget20__number kt-font-brand"><%=t_profesio_a%></span>
                                <span class="kt-widget20__desc">Activos en sistema</span>
                            </div>
                            <div class="kt-widget20__chart" style="height:130px;">
                                <canvas id="kt_chart_bandwidth3"></canvas>
                            </div>
                        </div>
                    </div>
                </div>

            <!--end:: Widgets/Inbound Bandwidth-->
            <div class="kt-space-20"></div>

            <!--begin:: Widgets/Outbound Bandwidth-->
            <div class="kt-portlet kt-portlet--fit kt-portlet--head-noborder kt-portlet--height-fluid-half">
                <div class="kt-portlet__head kt-portlet__space-x">
                    <div class="kt-portlet__head-label">
                        <h3 class="kt-portlet__head-title">
                            Clientes
                        </h3>
                    </div>
                    <%
                        int t_clientesa = Estadistica_BD.t_UsuariosA_Sup();
                        ArrayList<Estadistica> lista3a = Estadistica_BD.totalContraCre_Sup();
                        String json3a = new Gson().toJson(lista3a);
                    %>
                </div>
                <input type="hidden" value='<%=json3a%>' id="e_t_clientesacm">

                    <div class="kt-portlet__body kt-portlet__body--fluid">
                        <div class="kt-widget20">
                            <div class="kt-widget20__content kt-portlet__space-x">
                                <span class="kt-widget20__number kt-font-danger"><%=t_clientesa%></span>
                                <span class="kt-widget20__desc">activos en sistema</span>
                            </div>
                            <div class="kt-widget20__chart" style="height:130px;">
                                <canvas id="kt_chart_bandwidth5"></canvas>
                            </div>
                        </div>
                    </div>
            </div>

            <!--end:: Widgets/Outbound Bandwidth-->
        </div>

    </div>

    <!--End::Section-->


    <!--End::Dashboard 1-->
</div>