package com.digosofter.digowebapp.html;

import com.digosofter.digowebapp.erro.Erro;

public class LimiteFloat extends Tag {
	// CONSTANTES
	// FIM CONSTANTES

	// ATRIBUTOS
	// FIM ATRIBUTOS

	// CONSTRUTORES

	public LimiteFloat() {
		// VARI�VEIS		
		// FIM VARI�VEIS
		try {
			// A��ES
			
			this.setStrTagNome("div");
			this.setBooForcarTagDupla(true);

			// CSS
			this.getAtrClass().getLstStrValor().add(CssTag.getCssMainInstancia().setClearBoth());
			
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
