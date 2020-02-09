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
                        <h1 class="page-header"><fmt:message code="commande.client.nouveau"/></h1>
                    </div>
                    <!-- /.col-xl-12 -->
                </div>
                <!-- /.row -->
                
            </div>
            <div class="row">
                <div class="col-xl-12">
                    <div class="card card-primary">
                        <!-- /.card-header -->
                        <div class="card-header">
                            <fmt:message code="commande.client.nouveau"/>
                        </div>
                        <!-- /.card-body -->
                        <div class="card-body">
                            <form  action=""  enctype="multipart/form-data" role= "form">
                                  <div class="form-row">
	                                  <div class="col-md-4 mb3">
	                                        <label><fmt:message code="common.code"/></label>
	                                        <input class="form-control" placeholder="Code" id="codeCommande" value = "" disabled />
	                                  </div>
	                                  <div class="col-md-4 mb3">
	                                        <label><fmt:message code="common.date"/></label>
	                                        <input class="form-control" placeholder="Prenom" id="dateCommande" value = "" disabled />
	                                  </div>
	                                  <div class="col-md-4 mb3">
	                                        <label><fmt:message code="common.client"/></label>
	                                        <select class="form-control" id="listClients">
	                                          <option value="-1"><fmt:message code="commande.client.select.client" /></option>
	                                          <c:forEach items = "${clients }" var="clt">
	                                              <option value = "${clt.getIdClient() }">${clt.getNom() }</option>
	                                          </c:forEach>
	                                        </select>
	                                  </div>
	                                  <br/><br/><br/>
	                                  <div class="card-footer">
	                                    <button type="submit" class="btn btn-primary"><li><i class="fa fa-save">&nbsp;<fmt:message code="common.enregistrer"/><i/></i></i></button>
	                                    <a href="<c:url value="/commandeClient/"/>" class="btn btn-danger"><li class="fa fa-arrow-left">&nbsp;<fmt:message code="common.annuler"/></li></a>
	                                  </div>
                                  </div> 
                            </form>
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
                            <div class="form-row">
                                <div class="col-md-4 mb-3">
                                  <label><fmt:message code="common.article"/></label>
                                  <input class="form-control" type="text" id="codeArticle_search"/>
                                </div>
                                <div class="col-md-4 mb-3">
                                  <label><fmt:message code="commande.client.article.notfound"/></label>
                                </div>
                            </div>  
                            <br/> <br/> <br/> <br/> 
                            <table width="100%" class="table table-striped table-bordered table-hover"
                                   id="dataTables-example">
                                <thead>
                                <tr>
                                    <th><fmt:message code="common.article"/></th>
                                    <th><fmt:message code="common.qte"/></th>
                                    <th><fmt:message code="article.prix.unitaire.ttc"/></th>
                                    <th><fmt:message code="common.total"/></th>
                                </tr>
                                </thead>
                                <tbody id="detailNouvelleCommande">
                                    
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