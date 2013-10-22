package com.digosofter.digowebapp.html;

import com.digosofter.digowebapp.erro.Erro;

public class Formulario extends Tag {
	// CONSTANTES
	// FIM CONSTANTES

	// ATRIBUTOS
	// FIM ATRIBUTOS

	// CONSTRUTORES

	public Formulario() {
		// VARIÁVEIS
		// FIM VARIÁVEIS
		try {
			// AÇÕES
			
			this.setStrTagNome("form");

			// FIM AÇÕES
		} catch (Exception ex) {

			new Erro("Erro inesperado.\n", ex);

		} finally {
		}
	}

	// FIM CONSTRUTORES

	// MÉTODOS
	// FIM MÉTODOS

	// EVENTOS
	// FIM EVENTOS
}
