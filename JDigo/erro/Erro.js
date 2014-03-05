// CONSTANTE
// ATRIBUTOS GLOBAIS
// CLASSE
function Erro(strMensagem, e) {
	// HERAN�A

  Objeto.apply(this);

	// ATRIBUTO
	var _strMensagem = "Erro inesperado.";
	this.getStrMensagem = function() {
		return _strMensagem;
	}
	this.setStrMensagem = function(strMensagem) {
		_strMensagem = strMensagem;
	}

	var _strMensagemFormatada;
	this.getStrMensagemFormatada = function() {
		// VARI�VEIS
		try {
			// A��ES
			_strMensagemFormatada = "";
			_strMensagemFormatada += this.getStrMensagem();
			if (this.getStrMensagemTecnica() != "") {
				_strMensagemFormatada += "\n\n\n"
				_strMensagemFormatada += "Detalhes:"
				_strMensagemFormatada += "\n\n"
				_strMensagemFormatada += this.getStrMensagemTecnica();
			}

		} catch (e) {
			new Erro("Erro inesperado.", e);
		}
		return _strMensagemFormatada;
	}

	var _strMensagemTecnica = "<Sem detalhes>";
	this.getStrMensagemTecnica = function() {
		return _strMensagemTecnica;
	}
	this.setStrMensagemTecnica = function(strMensagemTecnica) {
		_strMensagemTecnica = strMensagemTecnica;
	}

	// M�TODO

	/* Construtor */
	{
		// VARI�VEL
		// A��O
		this.setStrMensagem(strMensagem);
		if (e != null) {
			this.setStrMensagemTecnica(e.message)
		}
		alert(this.getStrMensagemFormatada());
	}

}