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
		// VARIÁVEIS
		// FIM VARIÁVEIS
		try {
			// AÇÕES
			
			AppWeb.getI().getLstObjUsuarioSessao().add(this);
			
			// FIM AÇÕES
		} catch (Exception ex) {

			new Erro("Erro inesperado.\n", ex);

		} finally {
		}
	}
	
	// FIM CONSTRUTORES

	// MÉTODOS

	public static Usuario getObjUsuarioPelaSessionId(String strSessionId) {
		// VARIÁVEIS

		Usuario objUsuarioResultado = null;

		// FIM VARIÁVEIS
		try {
			// AÇÕES

			for (Usuario objUsuario : AppWeb.getI().getLstObjUsuarioSessao()) {
				if (objUsuario.getStrSessaoId().equals(strSessionId)) {
					objUsuarioResultado = objUsuario;
					break;
				}
			}

			// FIM AÇÕES
		} catch (Exception ex) {

			new Erro("Erro inesperado.\n", ex);

		} finally {
		}
		
		return objUsuarioResultado;
	}

	// FIM MÉTODOS

	// EVENTOS
	// FIM EVENTOS
}