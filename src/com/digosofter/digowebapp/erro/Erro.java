package com.digosofter.digowebapp.erro;

import com.digosofter.digowebapp.Objeto;

public class Erro extends Objeto {
	// CONSTANTES
	// FIM CONSTANTES

	// ATRIBUTOS
	
	private String _strMensagem;
	
	private String getstrMensagem() {
		return _strMensagem;
	}
	
	private void setstrMensagem(String strMensagem) {
		_strMensagem = strMensagem;
	}
	
	private String _strMensagemDetalhada;

	private String getstrMensagemDetalhada() {
		return _strMensagemDetalhada;
	}

	private void setstrMensagemDetalhada(String strMensagemDetalhada) {
		_strMensagemDetalhada = strMensagemDetalhada;
	}
	
	// FIM ATRIBUTOS

	// CONSTRUTORES
	
	public  Erro(String strMensagem,String strMensagemDetalhada) {
		// VARIÁVEIS
		// FIM VARIÁVEIS
		try {
			// AÇÕES
			
			
			
			// FIM AÇÕES
		} catch (Exception ex) {

			new Erro("Erro inesperado.\n", ex.getMessage());

		} finally {
		}
	}
	
	// FIM CONSTRUTORES

	// MÉTODOS
	// FIM MÉTODOS

	// EVENTOS
	// FIM EVENTOS
}
