package com.digosofter.digowebapp.html;

import com.digosofter.digowebapp.erro.Erro;

public class Painel extends Tag {
	// CONSTANTES
	// FIM CONSTANTES

	// ATRIBUTOS
	// FIM ATRIBUTOS

	// CONSTRUTORES

	public Painel() {
		// VARI�VEIS	

		JavaScriptTag objJsPainel = new JavaScriptTag("res/lib/DigoWebAppLib/js/html/Painel.js");

		// FIM VARI�VEIS
		try {
			// A��ES
			
			this.setStrTagNome("div");
			this.setBooForcarTagDupla(true);
			
			PaginaHtml.getPagHtmlInstancia().getLstObjJavaScriptTag().add(objJsPainel);

			// CSS
			this.getAtrClass().getLstStrValor().add(CssTag.getCssMainInstancia().setTextAlign("center"));
			
			// FIM A��ES
		} catch (Exception ex) {

			new Erro("Erro inesperado.\n", ex);

		} finally {
		}
	}

	// FIM CONSTRUTORES

	// M�TODOS
	// FIM M�TODOS

	// EVENTOS
	// FIM EVENTOS
}
