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

		super(strNome);

		// VARIÁVEIS
		// FIM VARIÁVEIS
		try {
			// AÇÕES

			this.setStrValor(strValor);

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
