// CONSTANTE
// FIM CONSTANTE
// ATRIBUTOS GLOBAIS
// FIM ATRIBUTOS GLOBAIS
// CLASSE

/**
 *
 */
function Campo(strId) {
	// HERAN�A

	Tag.apply(this);
	Objeto.apply(this);

	// FIM HERAN�A

	// ATRIBUTO

	var _strValor = null;
	this.getStrValor = function() {
		// VARI�VEIS
		// FIM VARI�VEIS
		try {
			// A��ES

			_strValor = this.getJq().val();

			// FIM A��ES
		} catch (e) {
			new Erro("Erro inesperado.", e);
		}

		return _strValor;
	}

	this.setStrValor = function(strValor) {
		// VARI�VEIS
		// FIM VARI�VEIS
		try {
			// A��ES

			_strValor = strValor;
			this.getJq().val(_strValor);

			// FIM A��ES
		} catch (e) {
			new Erro("Erro inesperado.", e);
		}
	}

	// FIM ATRIBUTO

	// M�TODO
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