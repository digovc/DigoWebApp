// CONSTANTE
// ATRIBUTOS GLOBAIS
// CLASSE
function Erro(strMensagem, e) {
	// HERAN�A
	Objeto.apply(this);

	// ATRIBUTO
	var _strMensagem = "Erro inesperado.";
	var getStrMensagem = function() {
		return _strMensagem;
	}
	var setStrMensagem = function(strMensagem) {
		_strMensagem = strMensagem;
	}

	var _strMensagemFormatada;
	var getStrMensagemFormatada = function() {
		// VARI�VEIS
		try {
			// A��ES
			_strMensagemFormatada = "";
			_strMensagemFormatada += getStrMensagem();
			if (getStrMensagemTecnica() != "") {
				_strMensagemFormatada += "\n\n\n"
				_strMensagemFormatada += "Detalhe t�cnico:"
				_strMensagemFormatada += "\n\n"
				_strMensagemFormatada += getStrMensagemTecnica();
			}

		} catch (e) {
			new Erro("Erro inesperado.", e);
		}
		return _strMensagemFormatada;
	}

	var _strMensagemTecnica = "";
	var getStrMensagemTecnica = function() {
		return _strMensagemTecnica;
	}
	var setStrMensagemTecnica = function(strMensagemTecnica) {
		_strMensagemTecnica = strMensagemTecnica;
	}

	// M�TODO

	/* Construtor */
	{
		// VARI�VEL
		// A��O
		setStrMensagem(strMensagem);
		setStrMensagemTecnica(e.message)
		alert(getStrMensagemFormatada());
	}

}