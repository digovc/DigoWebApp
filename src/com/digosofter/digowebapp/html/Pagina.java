package com.digosofter.digowebapp.html;

import com.digosofter.digowebapp.Objeto;
import com.digosofter.digowebapp.css.Css;
import com.digosofter.digowebapp.erro.Erro;

public class Pagina extends Objeto {
	// CONSTANTES
	// FIM CONSTANTES

	// ATRIBUTOS

	private CssTag _css;

	private CssTag getCss() {
		if (_css == null) {
			_css = Css.getCssMain();
			_css.setTagPai(this.getTagHead());
		}
		return _css;
	}

	private CssTag _cssImp;

	private CssTag getCssImp() {
		if (_cssImp == null) {
			_cssImp = new CssTag();
			_cssImp.setTagPai(this.getTagHead());
			_cssImp.setStrId("cssImp");
		}
		return _cssImp;
	}

	private Tag _tagBody;

	public Tag getTagBody() {
		if (_tagBody == null) {
			_tagBody = new Tag();
			_tagBody.setStrTagNome("body");
			_tagBody.setTagPai(this.getTagHtml());
		}
		return _tagBody;
	}

	private Tag _tagDocType;

	private Tag getTagDocType() {
		if (_tagDocType == null) {
			_tagDocType = new Tag();
			_tagDocType.setStrTagNome("!DOCTYPE html");
		}
		return _tagDocType;
	}

	private Tag _tagHead;

	private Tag getTagHead() {
		if (_tagHead == null) {
			_tagHead = new Tag();
			_tagHead.setStrTagNome("head");
			_tagHead.setTagPai(this.getTagHtml());
		}
		return _tagHead;
	}

	private Tag _tagHtml;

	private Tag getTagHtml() {
		if (_tagHtml == null) {
			_tagHtml = new Tag();
			_tagHtml.setStrTagNome("html");

			_tagHtml.getLstAtr().add(new Atributo("xmlns", "http://www.w3.org/1999/xhtml"));

			_tagHtml.getLstAtr().add(new Atributo("lang", "pt-br"));
		}
		return _tagHtml;
	}

	private Tag _tagMeta;

	private Tag getTagMeta() {
		if (_tagMeta == null) {
			_tagMeta = new Tag();
			_tagMeta.setStrTagNome("meta");
			_tagMeta.setTagPai(this.getTagHead());

			_tagMeta.getLstAtr().add(new Atributo("http-equiv", "Content-Type"));

			_tagMeta.getLstAtr().add(new Atributo("content"));
			_tagMeta.getLstAtr().get(1).setStrDelimitador(";");
			_tagMeta.getLstAtr().get(1).getLstStrValor().add("text/html");
			_tagMeta.getLstAtr().get(1).getLstStrValor().add(" charset=ISO-8859-1");
			// _tagMeta.getLstAtr().get(1).getLstStrValor().add(" charset=utf-8");
		}
		return _tagMeta;
	}

	// FIM ATRIBUTOS

	// CONSTRUTORES

	public Pagina() {
		// VARI�VEIS
		// FIM VARI�VEIS
		try {
			// A��ES

			this.getCss();
			this.getCssImp();
			this.getTagDocType();
			this.getTagHead();
			this.getTagHtml();
			this.getTagMeta();
			this.getTagBody();

			// FIM A��ES
		} catch (Exception ex) {

			new Erro("Erro inesperado.\n", ex.getMessage());

		} finally {
		}
	}

	// FIM CONSTRUTORES

	// M�TODOS

	public String getStrPaginaFormatada() {
		// VARI�VEIS

		StringBuilder objStringBuilderPaginaFormatada = new StringBuilder();

		// FIM VARI�VEIS
		try {
			// A��ES

			objStringBuilderPaginaFormatada.append(this.getTagDocType().toString());
			objStringBuilderPaginaFormatada.append(this.getTagHtml().toString());

			// FIM A��ES
		} catch (Exception ex) {

			new Erro("Erro inesperado.\n", ex.getMessage());

		} finally {
		}
		return objStringBuilderPaginaFormatada.toString();
	}

	@Override
	public String toString() {
		return this.getStrPaginaFormatada();
	}

	// FIM M�TODOS

	// EVENTOS
	// FIM EVENTOS
}
