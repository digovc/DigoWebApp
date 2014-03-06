// CONSTANTE
// FIM CONSTANTE
// ATRIBUTOS GLOBAIS
// FIM ATRIBUTOS GLOBAIS
// CLASSE

/**
 *
 */
function _Utils() {
	// HERAN�A
	// FIM HERAN�A

	// ATRIBUTO
	// FIM ATRIBUTO

	// M�TODO

	this.carregarImagem = function(strSrc, evtOnLoad) {
		// VARI�VEIS

		var img;

		// FIM VARI�VEIS
		try {
			// A��ES

			img = new Image;
			img.src = strSrc;
			img.onload = evtOnLoad;

			// FIM A��ES
		} catch (e) {
			new Erro("Erro inesperado.", e);
		}

		return img;
	}

	this.getBooStrVazia = function(str) {
		// VARI�VEIS

		var booResultado = false;

		// FIM VARI�VEIS
		try {
			// A��ES

			if (str == null) {
				booResultado = true;
			} else if (str == "") {
				booResultado = true;
			}

			// FIM A��ES
		} catch (e) {
			new Erro("Erro inesperado.", e);
		}

		return booResultado;
	}

	this.getBooValidarEmail = function(strEmail) {
		// VARI�VEIS

		var booResultado = false;
		var objRe;

		// FIM VARI�VEIS
		try {
			// A��ES

			objRe = new RegExp(
					/^[A-Za-z0-9_\-\.]+@[A-Za-z0-9_\-\.]{2,}\.[A-Za-z0-9]{2,}(\.[A-Za-z0-9])?/);

			if (Utils.getBooVazia(strEmail)) {
				booResultado = true;
			} else if (objRe.test(strEmail)) {
				booResultado = true;
			}

			// FIM A��ES
		} catch (e) {
			new Erro("Erro inesperado.", e);
		}

		return booResultado;
	}

	this.mostrarLstMensagemInformacao = function(lstStrMensagem) {
		// VARI�VEIS

		var strMensagemFormatada = "";

		// FIM VARI�VEIS
		try {
			// A��ES

			strMensagemFormatada = "Informa��o:";
			strMensagemFormatada += "\n\n\n";

			if (lstStrMensagem != null && lstStrMensagem.length > 0) {

				for ( var intIndex in lstStrMensagem) {
					strMensagemFormatada += "\n";
					strMensagemFormatada += lstStrMensagem[intIndex];
				}
			}

			Utils.mostrarMensagemInformacao(strMensagemFormatada)

			// FIM A��ES
		} catch (e) {
			new Erro("Erro inesperado.", e);
		}
	}

	this.mostrarMensagemInformacao = function(strMensagem) {
		// VARI�VEIS

		var strMensagemFormatada;

		// FIM VARI�VEIS
		try {
			// A��ES

			strMensagemFormatada += strMensagem;

			alert(strMensagemFormatada);

			// FIM A��ES
		} catch (e) {
			new Erro("Erro inesperado.", e);
		}
	}

	// FIM M�TODO

	/* Construtor */
	{
		// VARI�VEIS
		// FIM VARI�VEIS
		try {
			// A��ES
			// FIM A��ES
		} catch (e) {
			new Erro("Erro inesperado.", e);
		}
	}

}

// INICIALIZA��O

var Utils;

$(document).ready(function() {

	Utils = new _Utils();

});

// FIM INICIALIZA��O
