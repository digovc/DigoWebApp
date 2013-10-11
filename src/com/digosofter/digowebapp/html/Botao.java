package com.digosofter.digowebapp.html;

import com.digosofter.digowebapp.erro.Erro;

public class Botao extends Tag {
	// CONSTANTES
	// FIM CONSTANTES

	// ATRIBUTOS
	// FIM ATRIBUTOS

	// CONSTRUTORES

	public Botao() {
		// VARIÁVEIS
		// FIM VARIÁVEIS
		try {
			// AÇÕES
			
			this.setStrTagNome("button");
			this.setStrConteudo("Botão");
			this.getLstAtr().add(new Atributo("type", "button"));

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
