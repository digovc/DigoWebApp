package com.digosofter.digowebapp.html;

import java.util.ArrayList;
import java.util.List;

import com.digosofter.digowebapp.erro.Erro;

public class CssTag extends Tag {
	// CONSTANTES
	// FIM CONSTANTES

	// ATRIBUTOS

	private List<Atributo> _lstAtrCss = new ArrayList<Atributo>();

	public List<Atributo> getLstAtrCss() {
		return _lstAtrCss;
	}

	private void setLstAtrCss(List<Atributo> lstAtrCss) {
		_lstAtrCss = lstAtrCss;
	}

	private String _strConteudo;

	@Override
	public String getStrConteudo() {
		// VARIÁVEIS

		StringBuilder strBuilder = new StringBuilder();

		// FIM VARIÁVEIS
		try {
			// AÇÕES

			for (Atributo atrCss : this.getLstAtrCss()) {
				strBuilder.append("_class");
				strBuilder.append("{");
				strBuilder.append(atrCss.getStrNome());
				strBuilder.append(":");
				for (String strValor : atrCss.getLstStrValor()) {
					strBuilder.append(strValor);
					strBuilder.append(";");
				}
				strBuilder.append("}");
			}

			// FIM AÇÕES
		} catch (Exception ex) {

			new Erro("Erro inesperado.\n", ex.getMessage());

		} finally {
		}
		return _strConteudo;
	}

	// FIM ATRIBUTOS

	// CONSTRUTORES

	public CssTag() {
		// VARIÁVEIS
		// FIM VARIÁVEIS
		try {
			// AÇÕES

			this.setStrTagNome("style");
			this.setBooForcarTagDupla(true);
			this.getLstAtr().add(new Atributo("type", "text/css"));

			// FIM AÇÕES
		} catch (Exception ex) {

			new Erro("Erro inesperado.\n", ex.getMessage());

		} finally {
		}
	}

	// FIM CONSTRUTORES

	// MÉTODOS
	// FIM MÉTODOS

	// EVENTOS
	// FIM EVENTOS
}
