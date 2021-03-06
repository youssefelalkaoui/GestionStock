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
                        <h1 class="page-header"><fmt:message code="article.nouveau"/></h1>
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
                            <fmt:message code="article.nouveau"/>
                        </div>
                        <!-- /.card-body -->
                        <div class="card-body">
                            <c:url value="/article/enregistrer" var="urlEnregistrer"/>
                            <f:form modelAttribute="article" action="${urlEnregistrer }" method="post" enctype="multipart/form-data" role= "form">
                                  <f:hidden path="idArticle"/>
                                  <f:hidden path="photo"/>
                                  <div class="form-group">
                                        <label><fmt:message code="article.code"/></label>
                                        <f:input path="codeArticle" class="form-control" placeholder="code_Article"/>
                                  </div>
                                  <div class="form-group">
                                        <label><fmt:message code="article.designation"/></label>
                                        <f:input path="designation" class="form-control" placeholder="Prenom"/>
                                  </div>
                                  <div class="form-group">
                                        <label><fmt:message code="article.prix.unitaire.ht"/></label>
                                        <f:input id="prixUnitHT" path="prixUnitaireHT" class="form-control" placeholder="prixUnitaireHT" />
                                  </div>
                                  <div class="form-group">
                                        <label><fmt:message code="article.taux.tva"/></label>
                                        <f:input id="tauxTva" path="tauxTva" class="form-control" placeholder="tauxTva"/>
                                  </div>
                                  <div class="form-group">
                                        <label><fmt:message code="article.prix.unitaire.ttc"/></label>
                                        <f:input id="prixUnitTTC" path="prixUnitaireTTC" class="form-control" placeholder="prixUnitaireTTC"/>
                                  </div> 
                                  <div class="form-group">
                                        <label><fmt:message code="common.parametrage.category"/></label>
                                        <f:select class="form-control" path="category.idCategory" items="${categories }" itemLabel="code" itemValue="idCategory" />
                                  </div>
                                  <div class="form-group">
                                        <label><fmt:message code="common.photo"/></label>
                                        <input type="file" name="file"/>
                                  </div>
                                  <div class="card-footer">
                                    <button type="submit" class="btn btn-primary"><li><i class="fa fa-save">&nbsp;<fmt:message code="common.enregistrer"/><i/></i></i></button>
                                    <a href="<c:url value="/article/"/>" class="btn btn-danger"><li class="fa fa-arrow-left">&nbsp;<fmt:message code="common.annuler"/></li></a>
                                  </div>
                            </f:form>
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
<script src="<%=request.getContextPath() %>/resources/javascript/article.js"></script>
</body>

</html>