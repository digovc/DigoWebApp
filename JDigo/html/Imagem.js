/**
 *
 */
function Imagem() {
	// HERAN�A

	Tag.apply(this);
	Objeto.apply(this);

	// FIM HERAN�A

	// ATRIBUTO
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
		// VARI�VEL
		// A��O
	}

}
// INICIALIZA��O

// var objImagem;
// $(document).ready(function() {
//	objImagem = new Imagem();
// });

// FIM INICIALIZA��O
