// CONSTANTE
// FIM CONSTANTE
// ATRIBUTOS GLOBAIS
// FIM ATRIBUTOS GLOBAIS
// CLASSE

/**
 *
 */
function FormularioTbl(strId) {
	// HERAN�A

  ComponenteMain.apply(this);
  Tag.apply(this);
  Objeto.apply(this);


	// FIM HERAN�A

	// ATRIBUTO
	// FIM ATRIBUTO

	// M�TODO
	// FIM M�TODO

	/* Construtor */{
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