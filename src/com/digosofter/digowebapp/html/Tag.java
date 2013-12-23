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
		// VARIÁVEIS
		// FIM VARIÁVEIS
		try {
			// AÇÕES

			if (_atrClass == null) {

				_atrClass = new Atributo("class");
				this.getLstAtr().add(_atrClass);
			}

			// FIM AÇÕES
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
		// VARIÁVEIS
		// FIM VARIÁVEIS
		try {
			// AÇÕES

			if (_atrType == null) {

				_atrType = new Atributo("type");
				this.getLstAtr().add(_atrType);
			}

			// FIM AÇÕES
		} catch (Exception ex) {

			new Erro("Erro inesperado.\n", ex);

		} finally {
		}

		return _atrType;
	}

	private void setAtrType(Atributo atrType) {
		_atrType = atrType;
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

	private String _strFechamento = ">";

	protected String getStrFechamento() {
		return _strFechamento;
	}

	private void setStrFechamento(String strFechamento) {
		_strFechamento = strFechamento;
	}

	private String _strId = Utils.STRING_VAZIA;

	public String getStrId() {
		// VARIÁVEIS
		// FIM VARIÁVEIS
		try {
			// AÇÕES

			if (Utils.getBooStrVazia(_strId)) {

				_strId = "id" + String.valueOf(this.getIntId());
				this.getLstAtr().add(new Atributo("id", _strId));
			}

			// FIM AÇÕES
		} catch (Exception ex) {

			new Erro("Erro inesperado.\n", ex);

		} finally {
		}

		return _strId;
	}

	public void setStrId(String strId) {
		// VARIÁVEIS
		// FIM VARIÁVEIS
		try {
			// AÇÕES

			_strId = strId;
			this.getLstAtr().add(new Atributo("id", _strId));

			// FIM AÇÕES
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

	private String _strTagNome = "div";

	protected String getStrTagNome() {
		return _strTagNome;
	}

	protected void setStrTagNome(String strTagNome) {
		_strTagNome = strTagNome;
	}

	private Tag _tagPai;

	public Tag getTagPai() {
		return _tagPai;
	}

	public void setTagPai(Tag tagPai) {
		// VARIÁVEIS
		// FIM VARIÁVEIS
		try {
			// AÇÕES

			_tagPai = tagPai;
			_tagPai.getLstTag().add(this);

			// FIM AÇÕES
		} catch (Exception ex) {

			new Erro("Erro inesperado.\n", ex);

		} finally {
		}
	}

	// FIM ATRIBUTOS

	// CONSTRUTORES
	// FIM CONSTRUTORES

	// MÉTODOS

	public void adicionarCss(String strClassCss) {
		// VARIÁVEIS
		// FIM VARIÁVEIS
		try {
			// AÇÕES

			this.getAtrClass().getLstStrValor().add(strClassCss);

			// FIM AÇÕES
		} catch (Exception ex) {

			new Erro("Erro inesperado.\n", ex);

		} finally {
		}
	}

	protected String getStrAtributoFormatado() {
		// VARIÁVEIS

		String strAtributoIncluido = Utils.STRING_VAZIA;
		StringBuilder stbAtrFormatado = new StringBuilder();

		// FIM VARIÁVEIS
		try {
			// AÇÕES

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

			// FIM AÇÕES
		} catch (Exception ex) {

			new Erro("Erro inesperado.\n", ex);

		} finally {
		}

		return stbAtrFormatado.toString();
	}

	public String getStrTagFormatada() {
		// VARIÁVEIS

		StringBuilder stbTagFormatada = new StringBuilder();

		// FIM VARIÁVEIS
		try {
			// AÇÕES

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
				stbTagFormatada.append("/");
				stbTagFormatada.append(this.getStrTagNome());
				stbTagFormatada.append(this.getStrFechamento());

			} else {

				stbTagFormatada.append(this.getStrAbertura());
				stbTagFormatada.append(this.getStrTagNome());
				stbTagFormatada.append(this.getStrAtributoFormatado());
				stbTagFormatada.append("/");
				stbTagFormatada.append(this.getStrFechamento());
				
				if (!Utils.getBooStrVazia(this.getStrLink())) {
					stbTagFormatada.append("</a>");
				}
			}

			// FIM AÇÕES
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

	// FIM MÉTODOS

	// EVENTOS
	// FIM EVENTOS
}
