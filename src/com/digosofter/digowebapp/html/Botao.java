package com.digosofter.digowebapp.html;

import com.digosofter.digowebapp.erro.Erro;

public class Botao extends Tag {

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
			this.adicionarCss(CssTag.getCssMainInstancia().setFloat("right"));
			this.adicionarCss(CssTag.getCssMainInstancia().setPaddingBottom(7));
			this.adicionarCss(CssTag.getCssMainInstancia().setPaddingLeft(25));
			this.adicionarCss(CssTag.getCssMainInstancia().setPaddingRight(25));
			this.adicionarCss(CssTag.getCssMainInstancia().setPaddingTop(7));

			PaginaHtml.getI().getLstObjJavaScriptTag()
					.add(new JavaScriptTag("res/js/lib/JDigo/html/Botao.js"));

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
