// CONSTANTE
// FIM CONSTANTE
// ATRIBUTOS GLOBAIS
// FIM ATRIBUTOS GLOBAIS
// CLASSE

/**
 *
 */
function Formulario(strId) {
	// HERANÇA

	Tag.apply(this);
	Objeto.apply(this);

	// FIM HERANÇA

	// ATRIBUTO

  var _this = this;

	// FIM ATRIBUTO

	// MÉTODO

	this.enviar = function() {
		// VARIÁVEIS
		
		try {
			

			this.getJq().submit();

			// FIM AÇÕES
		} catch (e) {
			new Erro("Erro inesperado.", e);
		}
	}

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