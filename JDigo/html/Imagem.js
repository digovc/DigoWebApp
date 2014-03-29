/**
 *
 */
function Imagem(strId) {
	// HERANÇA

	Tag.apply(this);
	Objeto.apply(this);

	// FIM HERANÇA

	// ATRIBUTO

  var _this = this;

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
		// VARIÁVEIS
		// FIM VARIÁVEIS
		try {
			// AÇÕES

			if (!Utils.getBooStrVazia(strId)) {

			  this.setStrId(strId);
			}

			// FIM AÇÕES
		} catch (e) {
			new Erro("Erro inesperado.", e);
		}
	}

}