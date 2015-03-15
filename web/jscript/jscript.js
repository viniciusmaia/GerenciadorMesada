function valorMes(_mes)
{
	switch(_mes)
	{
		case "Jan":
			return "01";
		break;
		case "Fev":
			return "02";
		break;
		case "Mar":
			return "03";
		break;
		case "Abr":
			return "04";
		break;
		case "Mai":
			return "05";
		break;
		case "Jun":
			return "06";
		break;
		case "Jul":
			return "07";
		break;
		case "Ago":
			return "08";
		break;
		case "Set":
			return "09";
		break;
		case "Out":
			return "10";
		break;
		case "Nov":
			return "11";
		break;
		case "Dez":
			return "12";
		break;
	}
}

function dropdownMesChangeMeta(selecionado)
{
	if (selecionado.toString() != "Selecione")
	{
		var corte = selecionado.toString().split("/");
		document.getElementById("txtAno").value = corte[1];
		document.getElementById("txtMes").value = valorMes(corte[0]);
	}
}

function _iframe(link)
{
	var frame = document.getElementById("iframeBody");
	frame.src = link;
}

function validaEmail(_email)
{
	exp_reg = /^([a-zA-Z0-9_.-])+@([a-zA-Z0-9_.-])+\.([a-zA-Z])+([a-zA-Z])+/;
	if (exp_reg.test(_email) == false)
	{
		return false;
	}
	return true;
}

function validaMes(valor)
{
	num = parseInt(valor);
	if (num <= 12 && num >= 1) return true;
	return false;
}

function validaData(_data)
{
	if (_data == "dd/mm/aaaa") return false;
	return true;
}

function loginSubmit()
{
	var login = document.getElementById("txtLogin");
	
	if (validaEmail(login.value))
	{
		document.getElementById('formLogin').submit();
	}
}

function validaDecimal(valor)
{
	exp_reg = /^\d+(\.\d+)?/;
	if (exp_reg.test(valor) == false)
	{
		return false;
	}
	return true;
}

function validaNumero(valor)
{
	exp_reg = /^[0-9]+/;
	if (exp_reg.test(valor) == false)
	{
		return true;
	}
	return false;
}

function cadastroSubmit()
{
	var check = true;
	var mesada = document.getElementById("txtMesada");
	var nome = document.getElementById("txtNome");
	var email = document.getElementById("txtEmail");
	var senha = document.getElementById("txtSenha");
	var data = document.getElementById("txtData").value;
	
	if (nome.value == "")
	{
		check = false;
		document.getElementById("lblNome").style.visibility = "visible";
	}
	else document.getElementById("lblNome").style.visibility = "hidden";
	
	if (senha.value == "")
	{
		check = false;
		document.getElementById("lblSenha").style.visibility = "visible";
	}
	else document.getElementById("lblSenha").style.visibility = "hidden"; 
	
	if (mesada.value == "" || validaDecimal(mesada.value) == false)
	{
		check = false;
		document.getElementById("lblMesada").style.visibility = "visible";
	}
	else document.getElementById("lblMesada").style.visibility = "hidden";
	
	if (email.value == "" || validaEmail(email.value) == false)
	{
		check = false;
		document.getElementById("lblEmail").style.visibility = "visible";
	}
	else document.getElementById("lblEmail").style.visibility = "hidden";
	
	if (data == "" || validaData(data) == false)
	{
		check = false;
		document.getElementById("lblData").style.visibility = "visible";
	}
	else document.getElementById("lblData").style.visibility = "hidden";
	if (check) document.getElementById("formCadastro").submit();
}

function cadastroMetaSubmit()
{
	var check = true;
	var valor = document.getElementById("txtValor");
	var mes = document.getElementById("txtMes");
	var ano = document.getElementById("txtAno");
	
	if (ano.value == "" || validaNumero(ano.value))
	{
		check = false;
		document.getElementById("lblAno").style.visibility = "visible";
	}
	else document.getElementById("lblAno").style.visibility = "hidden";
	if (valor.value == "" || validaDecimal(valor.value) == false)
	{
		check = false;
		document.getElementById("lblValor").style.visibility = "visible";
	}
	else document.getElementById("lblValor").style.visibility = "hidden";
	if (mes.value == "" || validaMes(mes.value) == false)
	{
		check = false;
		document.getElementById("lblMes").style.visibility = "visible";
	}
	else document.getElementById("lblMes").style.visibility = "hidden";
	if (check) document.getElementById("formCadastro").submit();
}

function cadastroGastoSubmit()
{
	var check = true;
	var valor = document.getElementById("txtValor").value;
	var data = document.getElementById("txtData").value;
	var categoria = document.getElementById("ddlCategoria").value;

	if (categoria == "" || categoria == "Selecione")
	{
		check = false;
		document.getElementById("lblCategoria").style.visibility = "visible";
	}
	else document.getElementById("lblCategoria").style.visibility = "hidden";
	
	if (valor == "" || validaDecimal(valor) == false)
	{
		check = false;
		document.getElementById("lblValor").style.visibility = "visible";
	}
	else document.getElementById("lblValor").style.visibility = "hidden";
	
	if (data == "" || validaData(data) == false)
	{
		check = false;
		document.getElementById("lblData").style.visibility = "visible";
	}
	else document.getElementById("lblData").style.visibility = "hidden";
	
	if (check) document.getElementById("formCadastro").submit();
}

