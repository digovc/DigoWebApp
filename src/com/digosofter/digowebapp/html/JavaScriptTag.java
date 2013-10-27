package com.digosofter.digowebapp.html;

import java.util.ArrayList;
import java.util.List;

import com.digosofter.digowebapp.Utils;
import com.digosofter.digowebapp.erro.Erro;

public class JavaScriptTag extends Tag {
	// CONSTANTES
	// FIM CONSTANTES

	// ATRIBUTOS

	private Atributo _atrSrc;

	private Atributo getAtrSrc() {
		if (_atrSrc == null) {
			_atrSrc = new Atributo("src");
			this.getLstAtr().add(_atrSrc);
		}
		return _atrSrc;
	}

	private int _intPrioridade = 5;

	public int getIntPrioridade() {
		return _intPrioridade;
	}

	public void setIntPrioridade(int intPrioridade) {
		_intPrioridade = intPrioridade;
	}

	private List<String> _lstStrMetodos = new ArrayList<String>();

	public List<String> getLstStrMetodos() {
		return _lstStrMetodos;
	}

	private String _strSrc;

	private String getStrSrc() {
		return _strSrc;
	}

	public void setStrSrc(String strSrc) {
		_strSrc = strSrc;
		if (_strSrc != null && !_strSrc.equals(Utils.STRING_VAZIA)) {
			this.getAtrSrc().setStrValor(strSrc);
		}
	}

	// FIM ATRIBUTOS

	// CONSTRUTORES

	public JavaScriptTag(String strSrc) {
		// VARI�VEIS
		// FIM VARI�VEIS
		try {
			// A��ES

			this.setStrTagNome("script");
			this.setBooForcarTagDupla(true);
			this.getLstAtr().add(new Atributo("type", "text/javascript"));
			this.setStrSrc(strSrc);

			// FIM A��ES
		} catch (Exception ex) {

			new Erro("Erro inesperado.\n", ex);

		} finally {
		}
	}

	// FIM CONSTRUTORES

	// M�TODOS

	public void adicionarJsCodigo(String strJsCodigo) {
		// VARI�VEIS
		// FIM VARI�VEIS
		try {
			// A��ES

			getLstStrMetodos().add(strJsCodigo);

			// FIM A��ES
		} catch (Exception ex) {

			new Erro("Erro inesperado.\n", ex);

		} finally {
		}
	}

	@Override
	public String getStrTagFormatada() {
		// VARI�VEIS

		StringBuilder strBuilder = new StringBuilder();

		// FIM VARI�VEIS
		try {
			// A��ES

			if (!this.getLstStrMetodos().isEmpty()) {
				strBuilder.append("$(document).ready(function(){");
				strBuilder.append(Utils.getStrConcatenarLst(this.getLstStrMetodos(), null, true));
				strBuilder.append("});");

				this.setStrConteudo(strBuilder.toString());
			}

			// FIM A��ES
		} catch (Exception ex) {

			new Erro("Erro inesperado.\n", ex);

		} finally {
		} 
		return super.getStrTagFormatada();
	}

	// FIM M�TODOS

	// EVENTOS
	// FIM EVENTOS
}
