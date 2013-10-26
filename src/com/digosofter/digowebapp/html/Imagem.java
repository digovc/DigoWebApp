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

		JavaScriptTag objJsImagem = new JavaScriptTag("res/lib/DigoWebAppLib/js/html/Imagem.js");

		// FIM VARIÁVEIS
		try {
			// AÇÕES
			
			this.setStrTagNome("img");
			this.setBooForcarTagDupla(true);

			// CSS
//			this.getAtrClass().getLstStrValor().add(CssTag.getCssMainInstancia().setTextAlign("center"));

			PaginaHtml.getPagHtmlInstancia().getLstObjJavaScriptTag().add(objJsImagem);

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
