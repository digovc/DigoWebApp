package com.digosofter.digowebapp.html;

import java.util.ArrayList;
import java.util.List;

import com.digosofter.digowebapp.Objeto;
import com.digosofter.digowebapp.Utils;
import com.digosofter.digowebapp.erro.Erro;

public class Tag extends Objeto {
	// CONSTANTES
	// FIM CONSTANTES

	// ATRIBUTOS

	private Atributo _atrClass;

	public Atributo getAtrClass() {
		if (_atrClass == null) {
			_atrClass = new Atributo("class");

			this.getLstAtr().add(_atrClass);
		}
		return _atrClass;
	}

	private void setAtrClass(Atributo atrClass) {
		_atrClass = atrClass;
	}

	private boolean _booForcarTagDupla = false;

	protected boolean getBooForcarTagDupla() {
		return _booForcarTagDupla;
	}

	public void setBooForcarTagDupla(boolean booForcarTagDupla) {
		_booForcarTagDupla = booForcarTagDupla;
	}

	private List<Atributo> _lstAtr = new ArrayList<Atributo>();

	public List<Atributo> getLstAtr() {
		return _lstAtr;
	}

	private void setLstAtr(List<Atributo> lstAtr) {
		_lstAtr = lstAtr;
	}

	private List<Tag> _lstTag = new ArrayList<Tag>();

	protected List<Tag> getLstTag() {
		return _lstTag;
	}

	private void setLstTag(List<Tag> lstTag) {
		_lstTag = lstTag;
	}

	private String _strAbertura = "<";

	protected String getStrAbertura() {
		return _strAbertura;
	}

	private void setStrAbertura(String strAbertura) {
		_strAbertura = strAbertura;
	}

	private String _strConteudo = Utils.STRING_VAZIA;

	public String getStrConteudo() {
		return _strConteudo;
	}

	public void setStrConteudo(String strConteudo) {
		_strConteudo = strConteudo;
	}

	private String _strFechamento = ">";

	protected String getStrFechamento() {
		return _strFechamento;
	}

	private void setStrFechamento(String strFechamento) {
		_strFechamento = strFechamento;
	}

	private String _strId = Utils.STRING_VAZIA;

	public String getStrId() {
		if (Utils.getBooStrVazia(_strId)) {
			_strId = "id" + String.valueOf(this.getIntId());
			this.getLstAtr().add(new Atributo("id", _strId));
		}
		return _strId;
	}

	public void setStrId(String strId) {
		_strId = strId;
		this.getLstAtr().add(new Atributo("id", _strId));
	}

	private String _strTagNome = "div";

	protected String getStrTagNome() {
		return _strTagNome;
	}

	protected void setStrTagNome(String strTagNome) {
		_strTagNome = strTagNome;
	}

	private Tag _tagPai;

	private Tag getTagPai() {
		return _tagPai;
	}

	public void setTagPai(Tag tagPai) {
		_tagPai = tagPai;
		_tagPai.getLstTag().add(this);
	}

	// FIM ATRIBUTOS

	// CONSTRUTORES

	public Tag() {
		// VARI�VEIS
		// FIM VARI�VEIS
		try {
			// A��ES

			// FIM A��ES
		} catch (Exception ex) {

			new Erro("Erro inesperado.\n", ex.getMessage());

		} finally {
		}
	}

	// FIM CONSTRUTORES

	// M�TODOS

	protected String getStrAtributoFormatado() {
		// VARI�VEIS

		String strAtributoIncluido = Utils.STRING_VAZIA;
		StringBuilder strBuilderAtributoFormatado = new StringBuilder();

		// FIM VARI�VEIS
		try {
			// A��ES

			for (Atributo atr : this.getLstAtr()) {
				if (!strAtributoIncluido.contains("#" + atr.getStrNome() + "#")) {
					strAtributoIncluido += "#" + atr.getStrNome() + "#";
					strBuilderAtributoFormatado.append(" ");
					strBuilderAtributoFormatado.append(atr.getStrNome());
					strBuilderAtributoFormatado.append("=\"");
					strBuilderAtributoFormatado.append(Utils.getStrConcatenarLst(atr.getLstStrValor(), atr.getStrDelimitador(), true));
					strBuilderAtributoFormatado.append("\"");
				}
			}

			// FIM A��ES
		} catch (Exception ex) {

			new Erro("Erro inesperado.\n", ex.getMessage());

		} finally {
		}
		return strBuilderAtributoFormatado.toString();
	}

	public String getStrTagFormatada() {
		// VARI�VEIS

		StringBuilder strBuilderTagFormatadaResultado = new StringBuilder();

		// FIM VARI�VEIS
		try {
			// A��ES

			if (!Utils.getBooStrVazia(this.getStrConteudo()) || !this.getLstTag().isEmpty() || this.getBooForcarTagDupla()) {
				strBuilderTagFormatadaResultado.append(this.getStrAbertura());
				strBuilderTagFormatadaResultado.append(this.getStrTagNome());
				strBuilderTagFormatadaResultado.append(this.getStrAtributoFormatado());
				strBuilderTagFormatadaResultado.append(this.getStrFechamento());

				strBuilderTagFormatadaResultado.append(this.getStrConteudo());
				for (Tag tag : this.getLstTag()) {
					strBuilderTagFormatadaResultado.append(tag.getStrTagFormatada());
				}

				strBuilderTagFormatadaResultado.append(this.getStrAbertura());
				strBuilderTagFormatadaResultado.append("/");
				strBuilderTagFormatadaResultado.append(this.getStrTagNome());
				strBuilderTagFormatadaResultado.append(this.getStrFechamento());
			} else {
				strBuilderTagFormatadaResultado.append(this.getStrAbertura());
				strBuilderTagFormatadaResultado.append(this.getStrTagNome());
				strBuilderTagFormatadaResultado.append(this.getStrAtributoFormatado());
				strBuilderTagFormatadaResultado.append("/");
				strBuilderTagFormatadaResultado.append(this.getStrFechamento());
			}

			// FIM A��ES
		} catch (Exception ex) {

			new Erro("Erro inesperado.\n", ex.getMessage());

		} finally {
		}
		return strBuilderTagFormatadaResultado.toString();
	}

	public String toHtml() {
		return this.getStrTagFormatada();
	}

	@Override
	public String toString() {
		return this.getStrTagFormatada();
	}

	// FIM M�TODOS

	// EVENTOS
	// FIM EVENTOS
}
