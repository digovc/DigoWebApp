// CONSTANTE
// ATRIBUTOS GLOBAIS
// CLASSE
function Painel(strId) {
	// HERAN�A

  Tag.apply(this);
	Objeto.apply(this);

	// ATRIBUTO
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