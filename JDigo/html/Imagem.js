/**
 *
 */
function Imagem(strId) {
	// HERAN�A

	Tag.apply(this);
	Objeto.apply(this);

	// FIM HERAN�A

	// ATRIBUTO

  var _this = this;

	// FIM ATRIBUTO

	// M�TODO

	this.setObjImage = function(objImage) {
		// VARI�VEIS
		// FIM VARI�VEIS
		try {
			// A��ES

			this.getJq().attr("src", objImage.src)

			// FIM A��ES
		} catch (e) {
			new Erro("Erro inesperado.", e);
		}
	}

	// FIM M�TODO

	/* Construtor */{
		// VARI�VEIS
		// FIM VARI�VEIS
		try {
			// A��ES

			if (!Utils.getBooStrVazia(strId)) {

			  this.setStrId(strId);
			}

			// FIM A��ES
		} catch (e) {
			new Erro("Erro inesperado.", e);
		}
	}

}