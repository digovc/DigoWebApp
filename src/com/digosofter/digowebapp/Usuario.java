package com.digosofter.digowebapp;

public class Usuario extends Objeto {
	// CONSTANTES
	// FIM CONSTANTES

	// ATRIBUTOS

	private boolean _booLogado = false;

	private boolean getBooLogado() {
		return _booLogado;
	}

	private void setBooLogado(boolean booLogado) {
		_booLogado = booLogado;
	}

	private String _strSessaoId;

	public String getStrSessaoId() {
		return _strSessaoId;
	}

	public void setStrSessaoId(String strSessaoId) {
		_strSessaoId = strSessaoId;
	}

	// FIM ATRIBUTOS

	// CONSTRUTORES
	// FIM CONSTRUTORES

	// MÉTODOS
	// FIM MÉTODOS

	// EVENTOS
	// FIM EVENTOS
}
