package com.digosofter.digowebapp;

import com.digosofter.digowebapp.erro.Erro;

public class Usuario extends Objeto {

	// FIM CONSTANTES

	// ATRIBUTOS

	public static Usuario getObjUsuarioPelaSessionId(String strSessionId) {
		// VARI�VEIS

		Usuario objUsuarioResultado = null;

		// FIM VARI�VEIS
		try {
			// A��ES

			for (Usuario objUsuario : AppWeb.getI().getLstObjUsuarioSessao()) {
				if (objUsuario.getStrSessaoId().equals(strSessionId)) {
					objUsuarioResultado = objUsuario;
					break;
				}
			}

			// FIM A��ES
		} catch (Exception ex) {

			new Erro("Erro inesperado.\n", ex);

		} finally {
		}

		return objUsuarioResultado;
	}

	private boolean _booLogado = false;

	private int _intUsuarioId;

	private String _strSessaoId;

	public Usuario() {
		// VARI�VEIS
		// FIM VARI�VEIS
		try {
			// A��ES

			AppWeb.getI().getLstObjUsuarioSessao().add(this);

			// FIM A��ES
		} catch (Exception ex) {

			new Erro("Erro inesperado.\n", ex);

		} finally {
		}
	}

	public boolean getBooLogado() {
		return _booLogado;
	}

	public int getIntUsuarioId() {
		return _intUsuarioId;
	}

	public String getStrSessaoId() {
		return _strSessaoId;
	}

	public void setBooLogado(boolean booLogado) {
		_booLogado = booLogado;
	}

	// FIM ATRIBUTOS

	// CONSTRUTORES

	public void setIntUsuarioId(int intUsuarioId) {
		_intUsuarioId = intUsuarioId;
	}

	// FIM CONSTRUTORES

	// M�TODOS

	public void setStrSessaoId(String strSessaoId) {
		_strSessaoId = strSessaoId;
	}

	// FIM M�TODOS

	// EVENTOS
	// FIM EVENTOS
}