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
		// FIM VARI�VEIS
		try {
			// A��ES

			this.setStrTagNome("button");
			this.setStrConteudo("Bot�o");
			this.getLstAtr().add(new Atributo("type", "button"));
			this.adicionarCss(CssTag.getCssMainInstancia().setPaddingTop(5));
			this.adicionarCss(CssTag.getCssMainInstancia().setPaddingBottom(5));
			this.adicionarCss(CssTag.getCssMainInstancia().setPaddingLeft(15));
			this.adicionarCss(CssTag.getCssMainInstancia().setPaddingRight(15));

			PaginaHtml.getI().getLstObjJavaScriptTag().add(new JavaScriptTag("res/js/lib/JDigo/html/Botao.js"));

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
