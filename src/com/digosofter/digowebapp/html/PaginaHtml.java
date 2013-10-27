package com.digosofter.digowebapp.html;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import com.digosofter.digowebapp.AppWeb;
import com.digosofter.digowebapp.Objeto;
import com.digosofter.digowebapp.erro.Erro;

public class PaginaHtml extends Objeto {
	// CONSTANTES
	// FIM CONSTANTES

	// ATRIBUTOS

	private CssTag _cssMain;

	public CssTag getCssMain() {
		if (_cssMain == null) {
			_cssMain = new CssTag();

			_cssMain.setCssMainInstancia(_cssMain);
			_cssMain.setTagPai(this.getTagHead());
			_cssMain.setStrId("cssMain");
		}
		return _cssMain;
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

	private List<JavaScriptTag> _lstObjJavaScriptTag = new ArrayList<JavaScriptTag>();

	public List<JavaScriptTag> getLstObjJavaScriptTag() {
		return _lstObjJavaScriptTag;
	}

	private List<JavaScriptTag> _lstObjJavaScriptTagOrdenada;

	private List<JavaScriptTag> getLstObjJavaScriptTagOrdenada() {
		// VARI�VEIS
		// FIM VARI�VEIS
		try {
			// A��ES

			_lstObjJavaScriptTagOrdenada = this.getLstObjJavaScriptTag();
			Collections.sort(_lstObjJavaScriptTagOrdenada, new Comparator<JavaScriptTag>() {
				public int compare(final JavaScriptTag objJavaScriptTag1, final JavaScriptTag objJavaScriptTag2) {
					return objJavaScriptTag1.getIntPrioridade() < objJavaScriptTag2.getIntPrioridade() ? -1
							: (objJavaScriptTag1.getIntPrioridade() > objJavaScriptTag2.getIntPrioridade() ? +1 : 0);
				}
			});

			// FIM A��ES
		} catch (Exception ex) {

			new Erro("Erro inesperado.\n", ex);

		} finally {
		}
		return _lstObjJavaScriptTagOrdenada;
	}

	private JavaScriptTag _objJavaScriptMain;

	private JavaScriptTag getObjJavaScriptMain() {
		if (_objJavaScriptMain == null) {
			_objJavaScriptMain = new JavaScriptTag(null);

			this.getLstObjJavaScriptTag().add(_objJavaScriptMain);
			_objJavaScriptMain.setIntPrioridade(6);
		}
		return _objJavaScriptMain;
	}

	private static PaginaHtml _pagHtmlInstancia;

	public static PaginaHtml getPagHtmlInstancia() {
		return _pagHtmlInstancia;
	}

	private static void setPagHtmlInstancia(PaginaHtml pagHtmlInstancia) {
		_pagHtmlInstancia = pagHtmlInstancia;
	}

	private String _strTitulo;

	public String getStrTitulo() {
		return _strTitulo;
	}

	public void setStrTitulo(String strTitulo) {
		_strTitulo = strTitulo;
		_strTitulo = _strTitulo + " - " + AppWeb.getInstancia().getStrNome();
		this.getTagTitle().setStrConteudo(_strTitulo);
	}

	@Override
	public void setStrNome(String strNome) {
		super.setStrNome(strNome);
		this.setStrTitulo(strNome);
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

	private Tag _tagTitle;

	public Tag getTagTitle() {
		if (_tagTitle == null) {
			_tagTitle = new Tag();
			_tagTitle.setStrTagNome("title");
			_tagTitle.setTagPai(this.getTagHead());
			this.setStrTitulo("P�gina sem t�tulo - " + AppWeb.getInstancia().getStrNome());
		}
		return _tagTitle;
	}

	// FIM ATRIBUTOS

	// CONSTRUTORES

	public PaginaHtml() {
		// VARI�VEIS
		// FIM VARI�VEIS
		try {
			// A��ES

			PaginaHtml.setPagHtmlInstancia(this);

			this.adicionarJs();

			this.getTagDocType();
			this.getTagHead();
			this.getTagHtml();
			this.getTagMeta();
			this.getTagTitle();
			this.getCssMain();
			this.getCssImp();
			this.getTagBody();

			// FIM A��ES
		} catch (Exception ex) {

			new Erro("Erro inesperado.\n", ex);

		} finally {
		}
	}

	// FIM CONSTRUTORES

	// M�TODOS

	private void adicionarJs() {
		// VARI�VEIS

		JavaScriptTag objJsAppWeb = new JavaScriptTag("res/lib/DigoWebAppLib/js/AppWeb.js");
		JavaScriptTag objJsErro = new JavaScriptTag("res/lib/DigoWebAppLib/js/Erro.js");
		JavaScriptTag objJsUsuario = new JavaScriptTag("res/lib/DigoWebAppLib/js/Usuario.js");
		JavaScriptTag objJsJQuery = new JavaScriptTag("res/lib/DigoWebAppLib/js/lib/jquery-2.0.3.js");
		JavaScriptTag objJsMd5 = new JavaScriptTag("res/lib/DigoWebAppLib/js/lib/md5.js");
		JavaScriptTag objJsObjeto = new JavaScriptTag("res/lib/DigoWebAppLib/js/Objeto.js");
		JavaScriptTag objJsTag = new JavaScriptTag("res/lib/DigoWebAppLib/js/html/Tag.js");

		// FIM VARI�VEIS
		try {
			// A��ES

			this.getLstObjJavaScriptTag().add(objJsJQuery);
			this.getLstObjJavaScriptTag().add(objJsMd5);
			this.getLstObjJavaScriptTag().add(objJsErro);
			this.getLstObjJavaScriptTag().add(objJsObjeto);
			this.getLstObjJavaScriptTag().add(objJsAppWeb);
			this.getLstObjJavaScriptTag().add(objJsUsuario);
			this.getLstObjJavaScriptTag().add(objJsTag);

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

			this.getObjJavaScriptMain().adicionarJsCodigo(strJsCodigo);

			// FIM A��ES
		} catch (Exception ex) {

			new Erro("Erro inesperado.\n", ex);

		} finally {
		}
	}

	public String getStrPaginaFormatada() {
		// VARI�VEIS

		StringBuilder objStringBuilderPaginaFormatada = new StringBuilder();

		// FIM VARI�VEIS
		try {
			// A��ES

			for (JavaScriptTag objJavaScriptTag : this.getLstObjJavaScriptTagOrdenada()) {
				objJavaScriptTag.setTagPai(this.getTagHead());
			}

			objStringBuilderPaginaFormatada.append(this.getTagDocType().toString());
			objStringBuilderPaginaFormatada.append(this.getTagHtml().toString());

			// FIM A��ES
		} catch (Exception ex) {

			new Erro("Erro inesperado.\n", ex);

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
