package com.digosofter.digowebapp;

public class Usuario extends Objeto {
	// CONSTANTES
	// FIM CONSTANTES

	// ATRIBUTOS

	private boolean _booLogado = false;

	public boolean getBooLogado() {
		return _booLogado;
	}

	public void setBooLogado(boolean booLogado) {
		_booLogado = booLogado;
	}

	private String _strId;

	public String getStrId() {
		return _strId;
	}

	public void setStrId(String strId) {
		_strId = strId;
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