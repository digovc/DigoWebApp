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

		JavaScriptTag objJsPainel = new JavaScriptTag("res/lib/DigoWebAppLib/js/html/Painel.js");

		// FIM VARIÁVEIS
		try {
			// AÇÕES
			
			this.setStrTagNome("div");
			this.setBooForcarTagDupla(true);
			
			PaginaHtml.getPagHtmlInstancia().getLstObjJavaScriptTag().add(objJsPainel);

			// CSS
			this.getAtrClass().getLstStrValor().add(CssTag.getCssMainInstancia().setTextAlign("center"));
			
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
