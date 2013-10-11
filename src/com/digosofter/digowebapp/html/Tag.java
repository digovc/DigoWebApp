package com.digosofter.digowebapp.html;

import java.util.ArrayList;
import java.util.List;

import org.apache.tomcat.util.codec.binary.StringUtils;

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

	private boolean getBooForcarTagDupla() {
		return _booForcarTagDupla;
	}

	public void setBooForcarTagDupla(boolean booForcarTagDupla) {
		_booForcarTagDupla = booForcarTagDupla;
	}

	private int _intPaddingBottom;

	private int getIntPaddingBottom() {
		return _intPaddingBottom;
	}

	private void setIntPaddingBottom(int intPaddingBottom) {
		_intPaddingBottom = intPaddingBottom;
	}

	private List<Atributo> _lstAtr = new ArrayList<Atributo>();

	public List<Atributo> getLstAtr() {
		return _lstAtr;
	}

	private void setLstAtr(List<Atributo> lstAtr) {
		_lstAtr = lstAtr;
	}

	private List<Tag> _lstTag = new ArrayList<Tag>();

	private List<Tag> getLstTag() {
		return _lstTag;
	}

	private void setLstTag(List<Tag> lstTag) {
		_lstTag = lstTag;
	}

	private String _strAbertura = "<";

	private String getStrAbertura() {
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

	private String getStrFechamento() {
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

	private String getStrTagNome() {
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
	// FIM CONSTRUTORES

	// MÉTODOS

	private String getStrAtributoFormatado() {
		// VARIÁVEIS

		StringBuilder strBuilderAtributoFormatado = new StringBuilder();

		// FIM VARIÁVEIS
		try {
			// AÇÕES

			for (Atributo atr : this.getLstAtr()) {
				strBuilderAtributoFormatado.append(" ");
				strBuilderAtributoFormatado.append(atr.getStrNome());
				strBuilderAtributoFormatado.append("=\"");
				strBuilderAtributoFormatado.append(Utils.getStrConcatenarLst(atr.getLstStrValor(), atr.getStrDelimitador()));
				strBuilderAtributoFormatado.append("\"");
			}

			// FIM AÇÕES
		} catch (Exception ex) {

			new Erro("Erro inesperado.\n", ex.getMessage());

		} finally {
		}
		return strBuilderAtributoFormatado.toString();
	}

	public String getStrTagFormatada() {
		// VARIÁVEIS

		StringBuilder strBuilderTagFormatadaResultado = new StringBuilder();

		// FIM VARIÁVEIS
		try {
			// AÇÕES

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

			// FIM AÇÕES
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

	// FIM MÉTODOS

	// EVENTOS
	// FIM EVENTOS
}
