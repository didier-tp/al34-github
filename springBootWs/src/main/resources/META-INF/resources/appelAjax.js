var divRes ;

window.onload=function(){
	//alert("code declenché au chargement de la page");
	var inputChangeMini = document.getElementById("txtChangeMini");
	var btnGetDevises = document.getElementById("btnGetDevises");
	divRes = document.getElementById("divRes");
	
	btnGetDevises.addEventListener("click" , function (){
		//alert("click sur bouton");
		var changeMini = inputChangeMini.value;
		//divRes.innerHTML="<b>"+ changeMini + "</b>";
		makeAjaxGetRequest("./devise-api/public/devise?changeMini="+changeMini ,
				           cbGererResultat);
	});
}

function cbGererResultat(texteReponse){
	divRes.innerHTML = texteReponse;
}

function makeAjaxGetRequest(url,callback) {
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function() {
		if (xhr.readyState == 4 && (xhr.status == 200 || xhr.status == 0)) {
		callback(xhr.responseText);
		}
	};
	xhr.open("GET", url, true);
	xhr.send(null);
	}