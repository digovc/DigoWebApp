// CONSTANTE
// FIM CONSTANTE
// ATRIBUTOS GLOBAIS
// FIM ATRIBUTOS GLOBAIS
// CLASSE

/**
 *
 */
function FormularioTbl(strId) {
	// HERANÇA

  ComponenteMain.apply(this);
  Tag.apply(this);
  Objeto.apply(this);


	// FIM HERANÇA

	// ATRIBUTO
	// FIM ATRIBUTO

	// MÉTODO
	// FIM MÉTODO

	/* Construtor */{
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