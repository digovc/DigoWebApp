package com.digosofter.digowebapp.erro;

import com.digosofter.digowebapp.Objeto;

public class Erro extends Objeto {





	private String _strMensagem;

	private String _strMensagemDetalhada;

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

	protected String getStrMensagem() {
		return _strMensagem;
	}

	protected String getStrMensagemDetalhada() {
		return _strMensagemDetalhada;
	}

	protected void setStrMensagem(String strMensagem) {
		_strMensagem = strMensagem;
	}





	protected void setStrMensagemDetalhada(String strMensagemDetalhada) {
		_strMensagemDetalhada = strMensagemDetalhada;
	}








}
