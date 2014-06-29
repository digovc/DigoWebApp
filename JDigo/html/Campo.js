// CONSTANTE
// FIM CONSTANTE
// ATRIBUTOS GLOBAIS
// FIM ATRIBUTOS GLOBAIS
// CLASSE

/**
 *
 */
function Campo(strId) {
	// HERANÇA

	Tag.apply(this);
	Objeto.apply(this);

	// FIM HERANÇA

	// ATRIBUTO

  var _this = this;

	var _strValor = null;
	this.getStrValor = function() {
		// VARIÁVEIS
		// FIM VARIÁVEIS
		try {
			// AÇÕES

			_strValor = this.getJq().val();

			// FIM AÇÕES
		} catch (e) {
			new Erro("Erro inesperado.", e);
		}

		return _strValor;
	}

	this.setStrValor = function(strValor) {
		// VARIÁVEIS
		// FIM VARIÁVEIS
		try {
			// AÇÕES

			_strValor = strValor;
			this.getJq().val(_strValor);

			// FIM AÇÕES
		} catch (e) {
			new Erro("Erro inesperado.", e);
		}
	}

	// FIM ATRIBUTO

	// MÉTODO
	// FIM MÉTODO

	/* Construtor */
	{
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