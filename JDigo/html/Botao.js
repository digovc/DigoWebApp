// CONSTANTE
// ATRIBUTOS GLOBAIS
// CLASSE
function Botao(strId) {
	// HERAN�A

	Tag.apply(this);
	Objeto.apply(this);

	// ATRIBUTO

  var _this = this;

	// M�TODO

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