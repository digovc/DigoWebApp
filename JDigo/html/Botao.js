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