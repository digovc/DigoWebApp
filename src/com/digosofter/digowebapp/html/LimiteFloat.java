package com.digosofter.digowebapp.html;

import com.digosofter.digowebapp.erro.Erro;

public class LimiteFloat extends Tag {
	// CONSTANTES
	// FIM CONSTANTES

	// ATRIBUTOS
	// FIM ATRIBUTOS

	// CONSTRUTORES

	public LimiteFloat() {
		// VARIÁVEIS		
		// FIM VARIÁVEIS
		try {
			// AÇÕES
			
			this.setStrTagNome("div");
			this.setBooForcarTagDupla(true);
			this.adicionarCss(CssTag.getCssMainInstancia().setClearBoth());
			
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
