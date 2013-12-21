package com.digosofter.digowebapp.erro;

import com.digosofter.digowebapp.Objeto;

public class Erro extends Objeto {
	// CONSTANTES
	// FIM CONSTANTES

	// ATRIBUTOS

	private String _strMensagem;

	private String getStrMensagem() {
		return _strMensagem;
	}

	private void setStrMensagem(String strMensagem) {
		_strMensagem = strMensagem;
	}

	private String _strMensagemDetalhada;

	private String getStrMensagemDetalhada() {
		return _strMensagemDetalhada;
	}

	private void setStrMensagemDetalhada(String strMensagemDetalhada) {
		_strMensagemDetalhada = strMensagemDetalhada;
	}

	// FIM ATRIBUTOS

	// CONSTRUTORES

	public Erro(String strMensagem, Exception ex) {
		// VARIÁVEIS
		// FIM VARIÁVEIS
		try {
			// AÇÕES

			Exception objException = new Exception(ex.toString());
			objException.printStackTrace();

			// FIM AÇÕES
		} catch (Exception ex2) {
		} finally {
		}
	}

	// FIM CONSTRUTORES

	// MÉTODOS
	// FIM MÉTODOS

	// EVENTOS
	// FIM EVENTOS
}
