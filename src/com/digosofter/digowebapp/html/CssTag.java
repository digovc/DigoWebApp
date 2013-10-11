package com.digosofter.digowebapp.html;

import com.digosofter.digowebapp.erro.Erro;

public class CssTag extends Tag {
	// CONSTANTES
	// FIM CONSTANTES

	// ATRIBUTOS
	// FIM ATRIBUTOS

	// CONSTRUTORES

	public CssTag() {
		// VARI�VEIS
		// FIM VARI�VEIS
		try {
			// A��ES
			
			this.setStrTagNome("style");
			this.setBooForcarTagDupla(true);
			this.getLstAtr().add(new Atributo("type", "text/css"));
			
			// FIM A��ES
		} catch (Exception ex) {

			new Erro("Erro inesperado.\n", ex.getMessage());

		} finally {
		}
	}

	// FIM CONSTRUTORES

	// M�TODOS
	// FIM M�TODOS

	// EVENTOS
	// FIM EVENTOS
}
