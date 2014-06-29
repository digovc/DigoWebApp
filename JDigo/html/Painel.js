// CONSTANTE
// ATRIBUTOS GLOBAIS
// CLASSE
function Painel(strId) {
	// HERANÇA

  Tag.apply(this);
	Objeto.apply(this);

	// ATRIBUTO
	// MÉTODO

	/* Construtor */
	{
		// VARIÁVEIS

	  var _this = this;

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