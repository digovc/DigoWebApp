// CONSTANTE
// FIM CONSTANTE
// ATRIBUTOS GLOBAIS
// FIM ATRIBUTOS GLOBAIS
// CLASSE

/**
 *
 */
function Formulario(strId) {
	// HERAN�A

	Tag.apply(this);
	Objeto.apply(this);

	// FIM HERAN�A

	// ATRIBUTO
	// FIM ATRIBUTO

	// M�TODO

	this.enviar = function() {
		// VARI�VEIS
		// FIM VARI�VEIS
		try {
			// A��ES

			this.getJq().submit();

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

			if (!Utils.getBooStrVazia(strId)) {
				this.setStrId(strId);
			}

			// FIM A��ES
		} catch (e) {
			new Erro("Erro inesperado.", e);
		}
	}

}
// INICIALIZA��O

// var objFormulario;
// $(document).ready(function() {
// objFormulario = new Formulario();
// });

// FIM INICIALIZA��O
