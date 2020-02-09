<%@ include file="/WEB-INF/views/includes/includes.jsp" %>
<!DOCTYPE html>
<html lang="fr">

<head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>SB Admin 2 - Bootstrap Admin Theme</title>

    <!-- Bootstrap Core CSS -->
    <link href="<%=request.getContextPath() %>/resources/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

    <!-- MetisMenu CSS -->
    <link href="<%=request.getContextPath() %>/resources/vendor/metisMenu/metisMenu.min.css" rel="stylesheet">

    <!-- Custom CSS -->
    <link href="<%=request.getContextPath() %>/resources/dist/css/sb-admin-2.css" rel="stylesheet">

    <!-- Morris Charts CSS -->
    <link href="<%=request.getContextPath() %>/resources/vendor/morrisjs/morris.css" rel="stylesheet">

    <!-- Custom Fonts -->
    <link href="<%=request.getContextPath() %>/resources/vendor/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">

    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
    <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->

</head>

<body>
<div id="wrapper">
    <!-- Navigation -->
    <!-- topMenu -->
    <%@ include file="/WEB-INF/views/menu_top/topMenu.jsp" %>
    
    <div class="d-md-flex">
    
     <!-- leftMenu -->
     <%@ include file="/WEB-INF/views/menu_left/leftMenu.jsp" %>
     
        <!-- Page Content -->
        <div id="page-wrapper" class="p-4">
            <div class="container-fluid">
                <div class="row">
                    <div class="col-xl-12">
                        <h1 class="page-header"><fmt:message code="common.client.commande"/></h1>
                    </div>
                    <!-- /.col-xl-12 -->
                </div>
                <div class="row">
                    <div class="col-xl-12">
                        <ol class="list-inline">
                           <li class="list-inline-item"><a href="<c:url value="/commandeClient/nouveau"/>"><i class="fa fa-plus">&nbsp;<fmt:message code="common.ajouter"/></i></a></li>
                           <li class="list-inline-item"><a href="#"><i class="fa fa-download">&nbsp;<fmt:message code="common.exporter"/></i></a></li>
                           <li class="list-inline-item"><a href="#"><i class="fa fa-upload">&nbsp;<fmt:message code="common.importer"/></i></a></li>
                         </ol>
                    </div>
                    <!-- /.col-xl-12 -->
                </div>
                <!-- /.row -->
            </div>
            <!-- /.container-fluid -->
            <div class="row">
                <div class="col-xl-12">
                    <div class="card card-primary">
                        <!-- /.card-header -->
                        <div class="card-header">
                            <fmt:message code="commande.client.list"/>
                        </div>
                        <!-- /.card-body -->
                        <div class="card-body">
                            <table width="100%" class="table table-striped table-bordered table-hover"
                                   id="dataTables-example">
                                <thead>
                                <tr>
                                    <th><fmt:message code="common.code"/></th>
                                    <th><fmt:message code="common.date"/></th>
                                    <th><fmt:message code="common.client"/></th>
                                    <th><fmt:message code="common.total"/></th>
                                    <th><fmt:message code="common.actions"/></th>
                                </tr>
                                </thead>
                                <tbody>
                                    <c:forEach items="${commandesClient }" var="cde">
                                        <tr class="odd gradeX">
                                           <td>${cde.getCode() }</td>
                                           <td>${cde.getDateCommande() }</td>
                                           <td>${cde.getClient().getNom() }</td>
                                            <td>${cde.getTotalCommande() }</td>
                                           <td>
                                               <textArea id="json${cde.getIdCommandeClient() }" style="display: none;">${cde.getLigneCommandeJson() }</textArea>
                                               <a href="javascript:void(0);" onclick="updateDetailCommande(${cde.getIdCommandeClient() });"><i class="fa fa-th-list"></i></a>
                                               &nbsp;|&nbsp;
                                               <c:url value="/commandeClient/modifier/${cde.getIdCommandeClient() }" var="urlModif" />
                                               <a href="${urlModif }"><i class="fa fa-edit"></i></a>
                                               &nbsp;|&nbsp;
                                               <a href="javascript:void(0);" data-toggle="modal" data-target="#modalarticle${cde.getIdCommandeClient() }"><i class="fa fa-trash-o"></i></a>
                                               &nbsp;|&nbsp;
                                               <div class="modal fade" id="modalarticle${cde.getIdCommandeClient() }" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
                                                  <div class="modal-dialog" role="document">
                                                     <div class="modal-content">
                                                         <div class="modal-header">
                                                              <h5 class="modal-title" id="myModalLabel"><fmt:message code="common.confirm.suppression"/></h5>
                                                              <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                                              <span aria-hidden="true">&times;</span>
                                                              </button>
                                                         </div>
                                               <div class="modal-body">
                                                   <fmt:message code="article.confirm.suppression.msg"/>
                                               </div>
                                        <div class="modal-footer">
                                            <button type="button" class="btn btn-secondary" data-dismiss="modal"><fmt:message code="common.annuler"/></button>
                                            <c:url value="/commandeClient/supprimer/${cde.getIdCommandeClient() }" var="urlSuppression" />
                                            <a href="${urlSuppression }" class="btn btn-danger"><i class="fa fa-trash-o"></i>&nbsp;<fmt:message code="common.supprimer"/></a>
                                        </div>
                                    </div>
                                </div>
                            </div>
                                           </td>
                                        </tr>
                                    </c:forEach>
                                </tbody>
                            </table>
                            <!-- /.table-responsive -->
                        </div>
                        <!-- /.card-body -->
                    </div>
                    <!-- /.panel -->
                </div>
                <!-- /.col-xl-12 -->
            </div>
            
             <!-- Details de la commande -->
            
            <div class="row">
                <div class="col-xl-12">
                    <div class="card card-primary">
                        <!-- /.card-header -->
                        <div class="card-header">
                            <fmt:message code="commande.client.detail"/>
                        </div>
                        <!-- /.card-body -->
                        <div class="card-body">
                            <table width="100%" class="table table-striped table-bordered table-hover"
                                   id="dataTables-example">
                                <thead>
                                <tr>
                                    <th><fmt:message code="common.article"/></th>
                                    <th><fmt:message code="common.qte"/></th>
                                    <th><fmt:message code="article.prix.unitaire.ttc"/></th>
                                    <th><fmt:message code="common.total"/></th>
                                    <th><fmt:message code="common.actions"/></th>
                                </tr>
                                </thead>
                                <tbody id="detailCommande">
                                    <tr>
                                      <td></td>
                                      <td></td>
                                      <td></td>
                                      <td></td>
                                    </tr>
                                </tbody>
                            </table>
                            <!-- /.table-responsive -->
                        </div>
                        <!-- /.card-body -->
                    </div>
                    <!-- /.panel -->
                </div>
                <!-- /.col-xl-12 -->
            </div>
        </div>
    </div>
    <!-- /#page-wrapper -->
</div>
<!-- /#wrapper -->

<!-- jQuery -->
<script src="<%=request.getContextPath() %>/resources/vendor/jquery/jquery.min.js"></script>

<!-- Bootstrap Core JavaScript -->
<script src="<%=request.getContextPath() %>/resources/vendor/popper/popper.min.js"></script>
<script src="<%=request.getContextPath() %>/resources/vendor/bootstrap/js/bootstrap.min.js"></script>

<!-- Metis Menu Plugin JavaScript -->
<script src="<%=request.getContextPath() %>/resources/vendor/metisMenu/metisMenu.min.js"></script>

<!-- Custom Theme JavaScript -->
<script src="<%=request.getContextPath() %>/resources/javascript/commandeClient.js"></script>
</body>

</html>