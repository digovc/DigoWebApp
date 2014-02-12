package com.digosofter.digowebapp.html;

import java.util.ArrayList;
import java.util.List;

import com.digosofter.digowebapp.erro.Erro;

public class CampoComboBox extends Campo {
	// CONSTANTES
	// FIM CONSTANTES

	// ATRIBUTOS

	private List<String> _lstStrNome;

	public List<String> getLstStrNome() {
		// VARI�VEIS
		// FIM VARI�VEIS
		try {
			// A��ES

			if (_lstStrNome == null) {
				_lstStrNome = new ArrayList<String>();
			}

			// FIM A��ES
		} catch (Exception ex) {

			new Erro("Erro inesperado.\n", ex);

		} finally {
		}

		return _lstStrNome;
	}

	public void setLstStrNome(List<String> lstStrNome) {
		_lstStrNome = lstStrNome;
	}

	private List<String> _lstStrValor;

	public List<String> getLstStrValor() {
		// VARI�VEIS
		// FIM VARI�VEIS
		try {
			// A��ES

			if (_lstStrValor == null) {
				_lstStrValor = new ArrayList<String>();
			}

			// FIM A��ES
		} catch (Exception ex) {

			new Erro("Erro inesperado.\n", ex);

		} finally {
		}

		return _lstStrValor;
	}

	public void setLstStrValor(List<String> lstStrValor) {
		_lstStrValor = lstStrValor;
	}

	private String _strValorSelecionado;

	private String getStrValorSelecionado() {
		return _strValorSelecionado;
	}

	public void setStrValorSelecionado(String strValorSelecionado) {
		_strValorSelecionado = strValorSelecionado;
	}

	// FIM ATRIBUTOS

	// CONSTRUTORES

	public CampoComboBox() {
		// VARI�VEIS
		// FIM VARI�VEIS
		try {
			// A��ES

			this.setStrTagNome("select");

			// FIM A��ES
		} catch (Exception ex) {

			new Erro("Erro inesperado.\n", ex);

		} finally {
		}
	}

	// FIM CONSTRUTORES

	// M�TODOS

	@Override
	public String getStrTagFormatada() {
		// VARI�VEIS

		String strTagNome;
		Tag tag;

		// FIM VARI�VEIS
		try {
			// A��ES

			if (this.getLstStrValor().size() == 0) {

				this.getLstStrValor().add("-1");
				this.getLstStrNome().add("");
			}

			for (int intIndex = 0; intIndex < this.getLstStrValor().size(); intIndex++) {

				strTagNome = this.getStrValorSelecionado() == this.getLstStrValor().get(intIndex) ? "option selected" : "option";

				tag = new Tag();
				tag.setStrTagNome(strTagNome);
				tag.adicionarAtr("value", this.getLstStrValor().get(intIndex));
				tag.setStrConteudo(this.getLstStrNome().get(intIndex));
				tag.setTagPai(this);
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
