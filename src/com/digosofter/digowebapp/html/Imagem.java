package com.digosofter.digowebapp.html;

import com.digosofter.digowebapp.erro.Erro;

public class Imagem extends Tag {
	// CONSTANTES
	// FIM CONSTANTES

	// ATRIBUTOS
	// FIM ATRIBUTOS

	// CONSTRUTORES

	public Imagem() {
		// VARIÁVEIS		
		// FIM VARIÁVEIS
		try {
			// AÇÕES
			
			this.setStrTagNome("img");
			this.setBooForcarTagDupla(true);

			// CSS
//			this.getAtrClass().getLstStrValor().add(CssTag.getCssMainInstancia().setTextAlign("center"));
			
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
