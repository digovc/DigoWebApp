package com.digosofter.digowebapp.html;

import com.digosofter.digowebapp.erro.Erro;

public class Painel extends Tag {
	// CONSTANTES
	// FIM CONSTANTES

	// ATRIBUTOS
	// FIM ATRIBUTOS

	// CONSTRUTORES

	public Painel() {
		// VARIÁVEIS		
		// FIM VARIÁVEIS
		try {
			// AÇÕES
			
			this.setStrTagNome("div");

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
