package com.digosofter.digowebapp.html;

import com.digosofter.digowebapp.erro.Erro;

public class Botao extends Tag {
	// CONSTANTES
	// FIM CONSTANTES

	// ATRIBUTOS
	// FIM ATRIBUTOS

	// CONSTRUTORES

	public Botao() {
		// VARI�VEIS
		// FIM VARI�VEIS
		try {
			// A��ES
			
			this.setStrTagNome("button");
			this.setStrConteudo("Bot�o");
			this.getLstAtr().add(new Atributo("type", "button"));

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
