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
		// VARI�VEIS
		// FIM VARI�VEIS
		try {
			// A��ES

			Exception objException = new Exception(ex.toString());
			objException.printStackTrace();

			// FIM A��ES
		} catch (Exception ex2) {
		} finally {
		}
	}

	// FIM CONSTRUTORES

	// M�TODOS
	// FIM M�TODOS

	// EVENTOS
	// FIM EVENTOS
}
