$(document).ready(function(){
	$("#codeArticle_search").on("keypress",function(e){
		if(e.which == '13'){
			var codeArticle = $("#codeArticle_search").val();
			if(codeArticle && verifierClient()){
					searchArticle(codeArticle);
			}
			}
	});
	$("#listClients").on("change",function(e){
		if(verifierClient()){
			creerCommande($("#listClients option:selected").val());
		}
	});
});

function verifierClient(){
	var idClient = $("#listClients option:selected").val();
	if(idClient){
	   if(idClient){
		   alert("Veuillez selectionner un client");
		   return false;
	   }
	   return true;
	}
}

function creerCommande(idClient){
	  if(idClient){
		    $.getJSON("creerCommande", {
		    	idClient: idClient,
		        ajax: true
		    },
		    function(data){
		    	 if(data){
		    		 $("#codeCommande").text(data.code);
		    		 $("#dateCommande").text(data.dateCommande);
		    	 }
		    });
	  }
}

function updateDetailCommande(idCommande){
	var json = $.parseJSON($("#json" + idCommande).text());
	var detailHtml = "";
	if(json) {
		for(index =0; index < json.lenght; index++){
			detailHtml += 
				        "<tr>"+
		                    "<td>" + json[index].article.codeArticle +  "</td>"+
		                    "<td>" + json[index].quantite +  "</td>"+
		                    "<td>" + json[index].quantite +  "</td>"+
		                    "<td>0</td>"+
		                    "<td></td>"+
		                "</tr>";
		}
		$("#detailCommande").html(detailHtml);
	}
}

function searchArticle(codeArticle){
	 if(codeArticle){
		 var detailHtml = "";
		 $.getJSON("detailArticle",{
			 codeArticle: codeArticle,
			 ajax: true
		 },
		 function(data){
			 if(data){
				 var total = data.quantite * data.prixUnitaire;
				 if($())
				 detailHtml += 
				        "<tr>"+
		                    "<td>" + data.article.codeArticle +  "</td>"+
		                    "<td id='gte" + data.article.codeArticle + "'>"  + data.quantite+ "</td>"+
		                    "<td>" + data.prixUnitaire +  "</td>"+
		                    "<td id='total" + data.article.codeArticle + "'>" + total +  "</td>"+
		                "</tr>";
				 $("#detailNouvelleCommande").append(detailHtml);
			 } else {
				 alert("article not found");
			 }      
		 });
	 }
}



