package com.digosofter.digowebapp.html;

import com.digosofter.digowebapp.erro.Erro;

public class AtributoCss extends Atributo {

	// FIM CONSTANTES

	// ATRIBUTOS

	private String _strClassAssociada;

	public AtributoCss(String strNome, String strValor) {

		super(strNome);

		// VARI�VEIS
		// FIM VARI�VEIS
		try {
			// A��ES

			this.setStrValor(strValor);

			// FIM A��ES
		} catch (Exception ex) {

			new Erro("Erro inesperado.\n", ex);

		} finally {
		}

	}

	public String getStrClassAssociada() {
		return _strClassAssociada;
	}

	// FIM ATRIBUTOS

	// CONSTRUTORES

	public void setStrClassAssociada(String strClassAssociada) {
		_strClassAssociada = strClassAssociada;
	}

	// FIM CONSTRUTORES

	// M�TODOS
	// FIM M�TODOS

	// EVENTOS
	// FIM EVENTOS
}
