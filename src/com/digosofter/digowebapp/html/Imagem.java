package com.digosofter.digowebapp.html;

import com.digosofter.digowebapp.erro.Erro;

public class Imagem extends Tag {
	// CONSTANTES
	// FIM CONSTANTES

	// ATRIBUTOS
	// FIM ATRIBUTOS

	// CONSTRUTORES

	public Imagem() {
		// VARI�VEIS		

		JavaScriptTag objJsImagem = new JavaScriptTag("res/lib/DigoWebAppLib/js/html/Imagem.js");

		// FIM VARI�VEIS
		try {
			// A��ES
			
			this.setStrTagNome("img");
			this.setBooForcarTagDupla(true);

			// CSS
//			this.getAtrClass().getLstStrValor().add(CssTag.getCssMainInstancia().setTextAlign("center"));

			PaginaHtml.getPagHtmlInstancia().getLstObjJavaScriptTag().add(objJsImagem);

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
