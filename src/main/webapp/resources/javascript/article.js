$(document).ready(function(){
	$("#tauxTva").on("keyup",function(){
		tvaKeyUpFunction();
	});
});

tvaKeyUpFunction = function(){
	var prixunitHT = $("#prixUnitHT").val();
	var tauxTva = $("#tauxTva").val();
	var prixUnitTTC = parseFloat(parseFloat(prixunitHT) * parseFloat(tauxTva) /100 + parseFloat(prixunitHT));
	$("#prixUnitTTC").val(prixUnitTTC);
}
	
