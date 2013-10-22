package com.digosofter.digowebapp;

import com.digosofter.digowebapp.erro.Erro;

public abstract class Objeto {
	// CONSTANTES
	// FIM CONSTANTES

	// ATRIBUTOS

	private int _intId;

	public int getIntId() {
		return _intId;
	}

	public void setIntId(int intId) {
		_intId = intId;
	}

	private static int _intIndex;

	private static int getIntIndex() {
		return _intIndex;
	}

	private static void setIntIndex(int intIndex) {
		_intIndex = intIndex;
	}

	private String _strNome;

	public String getStrNome() {
		return _strNome;
	}

	public String getStrNomeSimplificado() {
		return Utils.getStrSimplificada(this.getStrNome());
	}

	public void setStrNome(String strNome) {
		_strNome = strNome;
	}

	private String _strNomeExibicao;

	public String getStrNomeExibicao() {
		if (_strNomeExibicao == null) {
			if (this.getStrNome() != null) {
				_strNomeExibicao = Character.toString(this.getStrNome().charAt(0)).toUpperCase() + this.getStrNome().substring(1);
			}
		}
		return _strNomeExibicao;
	}

	public void setStrNomeExibicao(String strNomeExibicao) {
		_strNomeExibicao = strNomeExibicao;
	}

	// FIM ATRIBUTOS

	// CONSTRUTORES

	public Objeto() {
		// VARIÁVEIS
		// FIM VARIÁVEIS
		try {
			// AÇÕES

			Objeto.setIntIndex(Objeto.getIntIndex() + 1);
			this.setIntId(Objeto.getIntIndex());

			// FIM AÇÕES
		} catch (Exception ex) {

			new Erro("Erro inesperado.\n", ex);

		} finally {
		}
	}

	// FIM CONSTRUTORES

	// MÉTODOS
	// FIM MÉTODOS

	// EVENTOS
	// FIM EVENTOS

}
