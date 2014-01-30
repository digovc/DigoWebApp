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
		// FIM VARI�VEIS
		try {
			// A��ES

			this.setStrTagNome("img");
			this.setBooForcarTagDupla(true);

			PaginaHtml.getI().getLstObjJavaScriptTag().add(new JavaScriptTag("res/js/lib/JDigo/html/Imagem.js"));

			// FIM A��ES
		} catch (Exception ex) {

			new Erro("Erro inesperado.\n", ex);

		} finally {
		}
	}

	// FIM CONSTRUTORES

	// M�TODOS

	public void setStrSrc(String strImagemSrc) {
		// VARI�VEIS
		// FIM VARI�VEIS
		try {
			// A��ES

			this.getLstAtr().add(new Atributo("src", strImagemSrc));

			// FIM A��ES
		} catch (Exception ex) {

			new Erro("Erro inesperado.\n", ex);

		} finally {
		}
	}

	// FIM M�TODOS

	// EVENTOS
	// FIM EVENTOS
}
