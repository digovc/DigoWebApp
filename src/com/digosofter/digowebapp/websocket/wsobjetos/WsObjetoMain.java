package com.digosofter.digowebapp.websocket.wsobjetos;

import com.digosofter.digowebapp.Objeto;
import com.digosofter.digowebapp.erro.Erro;

public class WsObjetoMain extends Objeto {





	private int _intMensagemId;

	private String _strJsonFilho;

	public WsObjetoMain(int intMensagemId) {
		// VARIÁVEIS
		// FIM VARIÁVEIS
		try {
			// AÇÕES

			this.setIntMensagemId(intMensagemId);

			// FIM AÇÕES
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





	public void setStrJsonFilho(String strJsonFilho) {
		_strJsonFilho = strJsonFilho;
	}








}
