package com.digosofter.digowebapp.html;

import com.digosofter.digowebapp.erro.Erro;

public class CssTag extends Tag {
	// CONSTANTES
	// FIM CONSTANTES

	// ATRIBUTOS
	// FIM ATRIBUTOS

	// CONSTRUTORES

	public CssTag() {
		// VARIÁVEIS
		// FIM VARIÁVEIS
		try {
			// AÇÕES
			
			this.setStrTagNome("style");
			this.setBooForcarTagDupla(true);
			this.getLstAtr().add(new Atributo("type", "text/css"));
			
			// FIM AÇÕES
		} catch (Exception ex) {

			new Erro("Erro inesperado.\n", ex.getMessage());

		} finally {
		}
	}

	// FIM CONSTRUTORES

	// MÉTODOS
	// FIM MÉTODOS

	// EVENTOS
	// FIM EVENTOS
}
