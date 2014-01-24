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
		// VARI�VEIS
		// FIM VARI�VEIS
		try {
			// A��ES

			if (_atrClass == null) {

				_atrClass = new Atributo("class");
				this.getLstAtr().add(_atrClass);
			}

			// FIM A��ES
		} catch (Exception ex) {

			new Erro("Erro inesperado.\n", ex);

		} finally {
		}

		return _atrClass;
	}

	private void setAtrClass(Atributo atrClass) {
		_atrClass = atrClass;
	}

	private Atributo _atrType;

	public Atributo getAtrType() {
		// VARI�VEIS
		// FIM VARI�VEIS
		try {
			// A��ES

			if (_atrType == null) {

				_atrType = new Atributo("type");
				this.getLstAtr().add(_atrType);
			}

			// FIM A��ES
		} catch (Exception ex) {

			new Erro("Erro inesperado.\n", ex);

		} finally {
		}

		return _atrType;
	}

	private void setAtrType(Atributo atrType) {
		_atrType = atrType;
	}

	private boolean _booBarraNoFinal = true;

	private boolean getBooBarraNoFinal() {
		return _booBarraNoFinal;
	}

	public void setBooBarraNoFinal(boolean booBarraNoFinal) {
		_booBarraNoFinal = booBarraNoFinal;
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

	public List<Tag> getLstTag() {
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

	public void setStrConteudo(StringBuilder stbConteudo) {
		this.setStrConteudo(stbConteudo.toString());
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
		// VARI�VEIS
		// FIM VARI�VEIS
		try {
			// A��ES

			if (Utils.getBooStrVazia(_strId)) {

				_strId = "id" + String.valueOf(this.getIntId());
				this.getLstAtr().add(new Atributo("id", _strId));
			}

			// FIM A��ES
		} catch (Exception ex) {

			new Erro("Erro inesperado.\n", ex);

		} finally {
		}

		return _strId;
	}

	public void setStrId(String strId) {
		// VARI�VEIS
		// FIM VARI�VEIS
		try {
			// A��ES

			_strId = strId;
			this.getLstAtr().add(new Atributo("id", _strId));

			// FIM A��ES
		} catch (Exception ex) {

			new Erro("Erro inesperado.\n", ex);

		} finally {
		}
	}

	private String _strLink;

	private String getStrLink() {
		return _strLink;
	}

	public void setStrLink(String strLink) {
		_strLink = strLink;
	}

	public void setStrLinkNovaJanela(String strLink) {
		_strLink = strLink + "\"target=\"_blank\"";
	}

	private String _strTagNome = "div";

	protected String getStrTagNome() {
		return _strTagNome;
	}

	protected void setStrTagNome(String strTagNome) {
		_strTagNome = strTagNome;
	}

	private String _strTitle;

	private String getStrTitle() {
		return _strTitle;
	}

	public void setStrTitle(String strTitle) {
		// VARI�VEIS
		// FIM VARI�VEIS
		try {
			// A��ES

			_strTitle = strTitle;
			this.getLstAtr().add(new Atributo("title", _strTitle));

			// FIM A��ES
		} catch (Exception ex) {

			new Erro("Erro inesperado.\n", ex);

		} finally {
		}
	}

	public void setStrTitulo(String strTitulo) {
		this.setStrTitle(strTitulo);
	}

	private Tag _tagPai;

	public Tag getTagPai() {
		return _tagPai;
	}

	public void setTagPai(Tag tagPai) {
		// VARI�VEIS
		// FIM VARI�VEIS
		try {
			// A��ES

			_tagPai = tagPai;
			_tagPai.getLstTag().add(this);

			// FIM A��ES
		} catch (Exception ex) {

			new Erro("Erro inesperado.\n", ex);

		} finally {
		}
	}

	// FIM ATRIBUTOS

	// CONSTRUTORES
	// FIM CONSTRUTORES

	// M�TODOS

	public void adicionarCss(String strClassCss) {
		// VARI�VEIS
		// FIM VARI�VEIS
		try {
			// A��ES

			this.getAtrClass().getLstStrValor().add(strClassCss);

			// FIM A��ES
		} catch (Exception ex) {

			new Erro("Erro inesperado.\n", ex);

		} finally {
		}
	}

	public void adicionarAtr(String strNome, String strValor) {
		// VARI�VEIS
		// FIM VARI�VEIS
		try {
			// A��ES

			this.getLstAtr().add(new Atributo(strNome, strValor));

			// FIM A��ES
		} catch (Exception ex) {

			new Erro("Erro inesperado.\n", ex);

		} finally {
		}
	}

	protected String getStrAtributoFormatado() {
		// VARI�VEIS

		String strAtributoIncluido = Utils.STRING_VAZIA;
		StringBuilder stbAtrFormatado = new StringBuilder();

		// FIM VARI�VEIS
		try {
			// A��ES

			for (Atributo atr : this.getLstAtr()) {

				if (!strAtributoIncluido.contains("#" + atr.getStrNome() + "#")) {

					strAtributoIncluido += "#" + atr.getStrNome() + "#";
					stbAtrFormatado.append(" ");
					stbAtrFormatado.append(atr.getStrNome());
					stbAtrFormatado.append("=\"");
					stbAtrFormatado.append(Utils.getStrConcatenarLst(atr.getLstStrValor(), atr.getStrDelimitador(), true));
					stbAtrFormatado.append("\"");
				}
			}

			// FIM A��ES
		} catch (Exception ex) {

			new Erro("Erro inesperado.\n", ex);

		} finally {
		}

		return stbAtrFormatado.toString();
	}

	public String getStrTagFormatada() {
		// VARI�VEIS

		StringBuilder stbTagFormatada = new StringBuilder();

		// FIM VARI�VEIS
		try {
			// A��ES

			if (!Utils.getBooStrVazia(this.getStrConteudo()) || !this.getLstTag().isEmpty() || this.getBooForcarTagDupla()) {

				if (!Utils.getBooStrVazia(this.getStrLink())) {
					stbTagFormatada.append("<a href=\"");
					stbTagFormatada.append(this.getStrLink());
					stbTagFormatada.append("\">");
				}

				stbTagFormatada.append(this.getStrAbertura());
				stbTagFormatada.append(this.getStrTagNome());
				stbTagFormatada.append(this.getStrAtributoFormatado());
				stbTagFormatada.append(this.getStrFechamento());
				stbTagFormatada.append(this.getStrConteudo());

				for (Tag tag : this.getLstTag()) {
					stbTagFormatada.append(tag.getStrTagFormatada());
				}

				stbTagFormatada.append(this.getStrAbertura());

				if (this.getBooBarraNoFinal()) {
					stbTagFormatada.append("/");
				}

				stbTagFormatada.append(this.getStrTagNome());
				stbTagFormatada.append(this.getStrFechamento());

				if (!Utils.getBooStrVazia(this.getStrLink())) {
					stbTagFormatada.append("</a>");
				}

			} else {

				if (!Utils.getBooStrVazia(this.getStrLink())) {
					stbTagFormatada.append("<a href=\"");
					stbTagFormatada.append(this.getStrLink());
					stbTagFormatada.append("\">");
				}

				stbTagFormatada.append(this.getStrAbertura());
				stbTagFormatada.append(this.getStrTagNome());
				stbTagFormatada.append(this.getStrAtributoFormatado());

				if (this.getBooBarraNoFinal()) {
					stbTagFormatada.append("/");
				}

				stbTagFormatada.append(this.getStrFechamento());

				if (!Utils.getBooStrVazia(this.getStrLink())) {
					stbTagFormatada.append("</a>");
				}
			}

			// FIM A��ES
		} catch (Exception ex) {

			new Erro("Erro inesperado.\n", ex);

		} finally {
		}

		return stbTagFormatada.toString();
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
