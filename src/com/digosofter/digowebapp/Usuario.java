package com.digosofter.digowebapp;

import com.digosofter.digowebapp.erro.Erro;

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

	private int _intUsuarioId;

	public int getIntUsuarioId() {
		return _intUsuarioId;
	}

	public void setIntUsuarioId(int intUsuarioId) {
		_intUsuarioId = intUsuarioId;
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
	
	// FIM CONSTRUTORES

	// M�TODOS

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

	// FIM M�TODOS

	// EVENTOS
	// FIM EVENTOS
}