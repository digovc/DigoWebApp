package com.digosofter.digowebapp.html;

import java.util.ArrayList;
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
			this.setStrTitulo("Página sem título - " + AppWeb.getInstancia().getStrNome());
		}
		return _tagTitle;
	}

	// FIM ATRIBUTOS

	// CONSTRUTORES

	public PaginaHtml() {
		// VARIÁVEIS

		JavaScriptTag objJsAppWeb = new JavaScriptTag("res/lib/DigoWebAppLib/js/AppWeb.js");
		JavaScriptTag objJsJQuery = new JavaScriptTag("res/lib/DigoWebAppLib/js/lib/jquery-2.0.3.js");
		JavaScriptTag objJsErro = new JavaScriptTag("res/lib/DigoWebAppLib/js/Erro.js");
		JavaScriptTag objJsObjeto = new JavaScriptTag("res/lib/DigoWebAppLib/js/Objeto.js");
		JavaScriptTag objJsPainel = new JavaScriptTag("res/lib/DigoWebAppLib/js/Painel.js");
		JavaScriptTag objJsTag = new JavaScriptTag("res/lib/DigoWebAppLib/js/Tag.js");

		// FIM VARIÁVEIS
		try {
			// AÇÕES

			this.getLstObjJavaScriptTag().add(objJsJQuery);
			this.getLstObjJavaScriptTag().add(objJsErro);
			this.getLstObjJavaScriptTag().add(objJsObjeto);
			this.getLstObjJavaScriptTag().add(objJsAppWeb);
			this.getLstObjJavaScriptTag().add(objJsTag);
			this.getLstObjJavaScriptTag().add(objJsPainel);

			this.getTagDocType();
			this.getTagHead();
			this.getTagHtml();
			this.getTagMeta();
			this.getTagTitle();
			this.getCssMain();
			this.getCssImp();
			this.getTagBody();

			// FIM AÇÕES
		} catch (Exception ex) {

			new Erro("Erro inesperado.\n", ex);

		} finally {
		}
	}

	// FIM CONSTRUTORES

	// MÉTODOS

	public String getStrPaginaFormatada() {
		// VARIÁVEIS

		StringBuilder objStringBuilderPaginaFormatada = new StringBuilder();

		// FIM VARIÁVEIS
		try {
			// AÇÕES

			for (JavaScriptTag objJavaScriptTag : this.getLstObjJavaScriptTag()) {
				objJavaScriptTag.setTagPai(this.getTagHead());
			}

			objStringBuilderPaginaFormatada.append(this.getTagDocType().toString());
			objStringBuilderPaginaFormatada.append(this.getTagHtml().toString());

			// FIM AÇÕES
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

	// FIM MÉTODOS

	// EVENTOS
	// FIM EVENTOS
}
