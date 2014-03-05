/**
 *
 */
function Imagem() {
	// HERANÇA

	Tag.apply(this);
	Objeto.apply(this);

	// FIM HERANÇA

	// ATRIBUTO
	// FIM ATRIBUTO

	// MÉTODO

	this.setObjImage = function(objImage) {
		// VARIÁVEIS
		// FIM VARIÁVEIS
		try {
			// AÇÕES

			this.getJq().attr("src", objImage.src)

			// FIM AÇÕES
		} catch (e) {
			new Erro("Erro inesperado.", e);
		}
	}

	// FIM MÉTODO

	/* Construtor */{
		// VARIÁVEL
		// AÇÃO
	}

}
// INICIALIZAÇÃO

// var objImagem;
// $(document).ready(function() {
//	objImagem = new Imagem();
// });

// FIM INICIALIZAÇÃO
