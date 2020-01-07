window.onload=function(){
	//alert("code declenché au chargement de la page");
	var inputChangeMini = document.getElementById("txtChangeMini");
	var btnGetDevises = document.getElementById("btnGetDevises");
	var divRes = document.getElementById("divRes");
	
	btnGetDevises.addEventListener("click" , function (){
		//alert("click sur bouton");
		var changeMini = inputChangeMini.value;
		divRes.innerHTML="<b>"+ changeMini + "</b>";
	});
}