
<div class="sidebar" role="navigation">
            <div class="sidebar-nav collapse navbar-collapse show" id="side-menu-wrapper">
                <ul class="nav navbar-nav navbar-collapse flex-column side-nav list-group" id="side-menu">
                    <li class="sidebar-search">
                        <div class="input-group custom-search-form">
                            <input type="text" class="form-control" placeholder="Recherche...">
                            <span class="input-group-btn">
                                <button class="btn btn-white" type="button">
                                    <i class="fa fa-search"></i>
                                </button>
                            </span>
                        </div>
                        <!-- /input-group -->
                    </li>
                    <c:url value="/home/" var="home"/>
                    <li class="list-group-item">
                        <a href="${home }"><i class="fa fa-dashboard fa-fw"></i><fmt:message code="common.dashbord"/></a>
                    </li>
                     <c:url value="/article/" var="article"/>
                    <li class="list-group-item">
                        <a href="${article }"><i class="fa fa-dashboard fa-fw"></i><fmt:message code="common.article"/></a>
                    </li>
                    <li class="list-group-item">
                        <a href="#"><i class="fa fa-bar-chart-o fa-fw"></i><fmt:message code="common.client"/><span class="fa arrow"></span></a>
                        <ul class="nav-second-level list-group nested">
                         <c:url value="/client/" var="client"/>
                            <li class="list-group-item">
                                <a href="${client }"><fmt:message code="common.client"/></a>
                            </li>
                            <c:url value="/commandeClient/" var="cdtClient"/>
                            <li class="list-group-item">
                                <a href="${cdtClient }"><fmt:message code="common.client.commande"/></a>
                            </li>
                        </ul>
                        <!-- /.nav-second-level -->
                    </li>
                    <li class="list-group-item">
                        <a href="#"><i class="fa fa-bar-chart-o fa-fw"></i><fmt:message code="common.fournisseur"/><span class="fa arrow"></span></a>
                        <ul class="nav-second-level list-group nested">
                            <c:url value="/fournisseur/" var="fournisseur"/>
                            <li class="list-group-item">
                                <a href="${fournisseur }"><fmt:message code="common.fournisseur"/></a>
                            </li>
                            <c:url value="/commandefournisseur/" var="cdtfournisseur"/>
                            <li class="list-group-item">
                                <a href="${cdtfournisseur }"><fmt:message code="common.fournisseur.commande"/></a>
                            </li>
                        </ul>
                        <!-- /.nav-second-level -->
                    </li>
                    <c:url value="/stock/" var="stock"/>
                    <li class="list-group-item">
                        <a href="${stock }"><i class="fa fa-table fa-fw"></i><fmt:message code="common.stock"/></a>
                    </li>
                    <c:url value="/vente/" var="vente"/>
                    <li class="list-group-item">
                        <a href="${vente }"><i class="fa fa-edit fa-fw"></i><fmt:message code="common.vente"/></a>
                    </li>
                    <li class="list-group-item">
                        <a href="#"><i class="fa fa-wrench fa-fw"></i><fmt:message code="common.parametrage"/><span class="fa arrow"></span></a>
                        <ul class="nav-second-level list-group nested">
                            <c:url value="/utilisateur/" var="user"/>
                            <li class="list-group-item">
                                <a href="${user }"><fmt:message code="common.parametrage.utilisateur"/></a>
                            </li>
                            <c:url value="/category/" var="category"/>
                            <li class="list-group-item">
                                <a href="${category }"><fmt:message code="common.parametrage.category"/></a>
                            </li>
                     
  
                        <!-- /.nav-second-level -->
                    </li>
                
                </ul>
            </div>
            <!-- /.sidebar-collapse -->
        </div>