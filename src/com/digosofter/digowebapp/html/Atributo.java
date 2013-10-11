package com.digosofter.digowebapp.html;

import java.util.ArrayList;
import java.util.List;

import com.digosofter.digowebapp.Objeto;
import com.digosofter.digowebapp.Utils;
import com.digosofter.digowebapp.erro.Erro;

public class Atributo extends Objeto {
	// CONSTANTES
	// FIM CONSTANTES

	// ATRIBUTOS

	private List<String> _lstStrValor = new ArrayList<String>();

	public List<String> getLstStrValor() {
		return _lstStrValor;
	}

	private void setLstStrValor(List<String> lstStrValor) {
		_lstStrValor = lstStrValor;
	}

	private String _strDelimitador = " ";

	public String getStrDelimitador() {
		return _strDelimitador;
	}

	public void setStrDelimitador(String strDelimitador) {
		_strDelimitador = strDelimitador;
	}

	private String _strValor;

	public String getStrValor() {
		return _strValor;
	}

	public void setStrValor(String strValor) {
		_strValor = strValor;
		this.getLstStrValor().clear();
		this.getLstStrValor().add(_strValor);
	}

	// FIM ATRIBUTOS

	// CONSTRUTORES

	public Atributo(String strNome) {
		// VARI�VEIS
		// FIM VARI�VEIS
		try {
			// A��ES

			if (Utils.getBooStrVazia(strNome)) {
				strNome = "attr";
			}
			this.setStrNome(strNome);

			// FIM A��ES
		} catch (Exception ex) {

			new Erro("Erro inesperado.\n", ex.getMessage());

		} finally {
		}
	}

	public Atributo(String strNome, String strValor) {
		// VARI�VEIS
		// FIM VARI�VEIS
		try {
			// A��ES

			if (Utils.getBooStrVazia(strNome)) {
				strNome = "attr";
			}
			this.setStrNome(strNome);
			this.setStrValor(strValor);			

			// FIM A��ES
		} catch (Exception ex) {

			new Erro("Erro inesperado.\n", ex.getMessage());

		} finally {
		}
	}

	// FIM CONSTRUTORES

	// M�TODOS
	// FIM M�TODOS

	// EVENTOS
	// FIM EVENTOS
}
