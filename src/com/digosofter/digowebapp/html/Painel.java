package com.digosofter.digowebapp.html;

import com.digosofter.digowebapp.erro.Erro;

public class Painel extends Tag {








	public Painel() {
		// VARI�VEIS
		// FIM VARI�VEIS
		try {
			// A��ES

			this.setStrTagNome("div");
			this.setBooForcarTagDupla(true);
			this.adicionarCss(CssTag.getCssMainInstancia().setTextAlign(
					"center"));

			PaginaHtml.getI().getLstObjJavaScriptTag()
					.add(new JavaScriptTag("res/js/lib/JDigo/html/Painel.js"));

			// FIM A��ES
		} catch (Exception ex) {

			new Erro("Erro inesperado.\n", ex);

		} finally {
		}
	}








}
