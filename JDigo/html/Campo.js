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
		
		try {
			

			_strValor = this.getJq().val();

			// FIM AÇÕES
		} catch (e) {
			new Erro("Erro inesperado.", e);
		}

		return _strValor;
	}

	this.setStrValor = function(strValor) {
		// VARIÁVEIS
		
		try {
			

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
		
		try {
			

			if (!Utils.getBooStrVazia(strId)) {
				this.setStrId(strId);
			}

			// FIM AÇÕES
		} catch (e) {
			new Erro("Erro inesperado.", e);
		}
	}

}