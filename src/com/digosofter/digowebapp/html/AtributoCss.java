package com.digosofter.digowebapp.html;

import com.digosofter.digowebapp.erro.Erro;

public class AtributoCss extends Atributo {

	// FIM CONSTANTES

	// ATRIBUTOS

	private String _strClassAssociada;

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

	public String getStrClassAssociada() {
		return _strClassAssociada;
	}

	// FIM ATRIBUTOS

	// CONSTRUTORES

	public void setStrClassAssociada(String strClassAssociada) {
		_strClassAssociada = strClassAssociada;
	}

	// FIM CONSTRUTORES

	// MÉTODOS
	// FIM MÉTODOS

	// EVENTOS
	// FIM EVENTOS
}
