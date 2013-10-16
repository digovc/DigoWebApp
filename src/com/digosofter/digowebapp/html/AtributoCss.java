package com.digosofter.digowebapp.html;

import com.digosofter.digowebapp.erro.Erro;

public class AtributoCss extends Atributo {
	// CONSTANTES
	// FIM CONSTANTES

	// ATRIBUTOS

	private String _strClassAssociada;

	public String getStrClassAssociada() {
		return _strClassAssociada;
	}

	public void setStrClassAssociada(String strClassAssociada) {
		_strClassAssociada = strClassAssociada;
	}

	// FIM ATRIBUTOS

	// CONSTRUTORES

	public AtributoCss(String strNome, String strValor) {
		// VARI�VEIS

		super(strNome);

		// FIM VARI�VEIS
		try {
			// A��ES
			
			this.setStrValor(strValor);
			
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
