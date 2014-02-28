package com.digosofter.digowebapp.html;

import java.util.ArrayList;
import java.util.List;

import com.digosofter.digowebapp.Utils;
import com.digosofter.digowebapp.erro.Erro;

public class JavaScriptTag extends Tag {





	private Atributo _atrSrc;

	private int _intPrioridade = 5;

	private List<String> _lstStrMetodos = new ArrayList<String>();

	private String _strSrc;

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

	private Atributo getAtrSrc() {
		// VARI�VEIS
		// FIM VARI�VEIS
		try {
			// A��ES

			if (_atrSrc == null) {
				_atrSrc = new Atributo("src");
				this.getLstAtr().add(_atrSrc);
			}

			// FIM A��ES
		} catch (Exception ex) {

			new Erro("Erro inesperado.\n", ex);

		} finally {
		}

		return _atrSrc;
	}

	public int getIntPrioridade() {
		return _intPrioridade;
	}

	public List<String> getLstStrMetodos() {
		return _lstStrMetodos;
	}

	private String getStrSrc() {
		return _strSrc;
	}





	@Override
	public String getStrTagFormatada() {
		// VARI�VEIS

		StringBuilder strBuilder;

		// FIM VARI�VEIS
		try {
			// A��ES

			if (!this.getLstStrMetodos().isEmpty()) {

				strBuilder = new StringBuilder();
				strBuilder.append("$(document).ready(function(){");
				strBuilder.append(Utils.getStrConcatenarLst(
						this.getLstStrMetodos(), null, true));
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





	public void setIntPrioridade(int intPrioridade) {
		_intPrioridade = intPrioridade;
	}

	public void setStrSrc(String strSrc) {
		// VARI�VEIS
		// FIM VARI�VEIS
		try {
			// A��ES

			_strSrc = strSrc;

			if (_strSrc != null && !_strSrc.equals(Utils.STRING_VAZIA)) {
				this.getAtrSrc().setStrValor(strSrc);
			}

			// FIM A��ES
		} catch (Exception ex) {

			new Erro("Erro inesperado.\n", ex);

		} finally {
		}
	}





}
