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
		
		JavaScriptTag objJsBotao = new JavaScriptTag("res/lib/DigoWebAppLib/js/html/Botao.js");

		// FIM VARI�VEIS
		try {
			// A��ES

			this.setStrTagNome("button");
			this.setStrConteudo("Bot�o");
			this.getLstAtr().add(new Atributo("type", "button"));

			PaginaHtml.getPagHtmlInstancia().getLstObjJavaScriptTag().add(objJsBotao);

			// CSS
			this.adicionaCss(CssTag.getCssMainInstancia().setPaddingTop(5));
			this.adicionaCss(CssTag.getCssMainInstancia().setPaddingBottom(5));
			this.adicionaCss(CssTag.getCssMainInstancia().setPaddingLeft(15));
			this.adicionaCss(CssTag.getCssMainInstancia().setPaddingRight(15));

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
