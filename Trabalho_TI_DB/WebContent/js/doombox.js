function compararSenha() {

	var senha1 = document.getElementById("senha").value;
	var senha2 = document.getElementById("check").value;
	var obj = document.getElementById("seq");

	if (senha1 == senha2) {
		obj.setAttribute("style", "color: red; visibility:hidden;");
	} else {
		obj.setAttribute("style", "color: red; visibility:visible;");
	}

	if (senha2 == "") {
		obj.setAttribute("style", "color: red; visibility:hidden;");
	}

}

function checarSenha() {

	var senha1 = document.getElementById("senha").value;
	var senha2 = document.getElementById("check").value;
	var valido;

	if (senha1 == senha2) {
		valido=true;
	} else {
		valido=false;
		alert('As senhas devem ser iguais.');
	}
	return valido;

}

function excluir(id){
	var apagar=confirm('Deseja excluir o arquivo/pasta?\nSe for uma pasta, todos os seus arquivos ser�o apagados');
	if(apagar){
		alert('apagou');
	}else{
		alert('n�o apagou');
	}
}

function radioDiv(){
	var divArq=document.getElementById('arquivoDiv');
	var divDir=document.getElementById('diretorioDiv');
	var radio=document.getElementById('radio');
	if(radio.checked==true){
		divArq.setAttribute("style", 'border: ridge; border-color: #aba9a6; border-width: 5px; background-color: #FFFFFF; position:absolute; left:100px; top:390px; visibility: visible;');
		divDir.setAttribute("style", 'position:absolute; left:100px; top:350px; visibility: hidden;');
	}else{
		divDir.setAttribute("style", 'border: ridge; border-color: #aba9a6; border-width: 5px; background-color: #FFFFFF; position:absolute; left:100px; top:390px; visibility: visible;');
		divArq.setAttribute("style", 'position:absolute; left:100px; top:350px; visibility: hidden;');
	}
}