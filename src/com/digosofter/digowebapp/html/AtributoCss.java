package com.digosofter.digowebapp.html;

import com.digosofter.digowebapp.erro.Erro;

public class AtributoCss extends Atributo {





	private String _strClassAssociada;

	public AtributoCss(String strNome, String strValor) {

		super(strNome);

		// VARI�VEIS
		// FIM VARI�VEIS
		try {
			// A��ES

			this.setStrValor(strValor);

			// FIM A��ES
		} catch (Exception ex) {

			new Erro("Erro inesperado.\n", ex);

		} finally {
		}

	}

	public String getStrClassAssociada() {
		return _strClassAssociada;
	}





	public void setStrClassAssociada(String strClassAssociada) {
		_strClassAssociada = strClassAssociada;
	}








}
