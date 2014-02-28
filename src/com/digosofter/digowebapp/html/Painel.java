package com.digosofter.digowebapp.html;

import com.digosofter.digowebapp.erro.Erro;

public class Painel extends Tag {

	// FIM CONSTANTES

	// ATRIBUTOS
	// FIM ATRIBUTOS

	// CONSTRUTORES

	public Painel() {
		// VARIÁVEIS
		// FIM VARIÁVEIS
		try {
			// AÇÕES

			this.setStrTagNome("div");
			this.setBooForcarTagDupla(true);
			this.adicionarCss(CssTag.getCssMainInstancia().setTextAlign(
					"center"));

			PaginaHtml.getI().getLstObjJavaScriptTag()
					.add(new JavaScriptTag("res/js/lib/JDigo/html/Painel.js"));

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
