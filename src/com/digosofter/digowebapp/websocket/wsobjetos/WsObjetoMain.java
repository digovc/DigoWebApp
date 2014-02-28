package com.digosofter.digowebapp.websocket.wsobjetos;

import com.digosofter.digowebapp.Objeto;
import com.digosofter.digowebapp.erro.Erro;

public class WsObjetoMain extends Objeto {

	// FIM CONSTANTES

	// ATRIBUTOS

	private int _intMensagemId;

	private String _strJsonFilho;

	public WsObjetoMain(int intMensagemId) {
		// VARI�VEIS
		// FIM VARI�VEIS
		try {
			// A��ES

			this.setIntMensagemId(intMensagemId);

			// FIM A��ES
		} catch (Exception ex) {

			new Erro("Erro inesperado.\n", ex);

		} finally {
		}
	}

	public int getIntMensagemId() {
		return _intMensagemId;
	}

	public String getStrJsonFilho() {
		return _strJsonFilho;
	}

	private void setIntMensagemId(int intMensagemId) {
		_intMensagemId = intMensagemId;
	}

	// FIM ATRIBUTOS

	// CONSTRUTORES

	public void setStrJsonFilho(String strJsonFilho) {
		_strJsonFilho = strJsonFilho;
	}

	// FIM CONSTRUTORES

	// M�TODOS
	// FIM M�TODOS

	// EVENTOS
	// FIM EVENTOS
}
