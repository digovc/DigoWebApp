// CONSTANTE
// ATRIBUTOS GLOBAIS
// CLASSE
function Botao(strId) {
	// HERANÇA

	Tag.apply(this);
	Objeto.apply(this);

	// ATRIBUTO

  var _this = this;

	// MÉTODO

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