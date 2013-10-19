package com.digosofter.digowebapp.html;

import com.digosofter.digowebapp.erro.Erro;

public class JavaScriptTag extends Tag {
	// CONSTANTES
	// FIM CONSTANTES

	// ATRIBUTOS

	private Atributo _atrSrc;

	private Atributo getAtrSrc() {
		if (_atrSrc == null) {
			_atrSrc = new Atributo("src");
			this.getLstAtr().add(_atrSrc);
		}
		return _atrSrc;
	}

	private String _strSrc;

	private String getStrSrc() {
		return _strSrc;
	}

	public void setStrSrc(String strSrc) {
		_strSrc = strSrc;
		this.getAtrSrc().setStrValor(strSrc);
	}

	// FIM ATRIBUTOS

	// CONSTRUTORES

	public JavaScriptTag(String strSrc) {
		// VARI�VEIS
		// FIM VARI�VEIS
		try {
			// A��ES

			this.setStrTagNome("script");
			this.setBooForcarTagDupla(true);
			this.getLstAtr().add(new Atributo("type", "text/javascript"));
			this.setStrSrc(strSrc);

			// FIM A��ES
		} catch (Exception ex) {

			new Erro("Erro inesperado.\n", ex.getMessage());

		} finally {
		}
	}

	// FIM CONSTRUTORES

	// M�TODOS
	// FIM M�TODOS

	// EVENTOS
	// FIM EVENTOS
}
