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

	private static PaginaHtml i;

	public static PaginaHtml getI() {
		// VARIÁVEIS
		// FIM VARIÁVEIS
		try {
			// AÇÕES

			if (i == null) {
				i = new PaginaHtml();
			}

			// FIM AÇÕES
		} catch (Exception ex) {

			new Erro("Erro ao instanciar objeto do tipo 'PaginaHtml'.\n", ex);

		} finally {
		}

		return i;
	}

	private void setI(PaginaHtml _i) {
		i = _i;
	}

	private boolean _booCssMainAdicionado;

	private boolean getBooCssMainAdicionado() {
		return _booCssMainAdicionado;
	}

	private void setBooCssMainAdicionado(boolean booCssMainAdicionado) {
		_booCssMainAdicionado = booCssMainAdicionado;
	}

	private static CssTag _cssMain;

	public CssTag getCssMain() {
		// VARIÁVEIS
		// FIM VARIÁVEIS
		try {
			// AÇÕES

			if (_cssMain == null) {
				_cssMain = new CssTag();

				CssTag.setCssMainInstancia(_cssMain);
				_cssMain.setStrId("cssMain");
			}

			if (!this.getBooCssMainAdicionado()) {
				_cssMain.setTagPai(this.getTagHead());
				this.setBooCssMainAdicionado(true);
			}

			// FIM AÇÕES
		} catch (Exception ex) {

			new Erro("Erro inesperado.\n", ex);

		} finally {
		}

		return _cssMain;
	}

	private CssTag _cssImp;

	private CssTag getCssImp() {
		// VARIÁVEIS
		// FIM VARIÁVEIS
		try {
			// AÇÕES

			if (_cssImp == null) {

				_cssImp = new CssTag();
				_cssImp.setTagPai(this.getTagHead());
				_cssImp.setStrId("cssImp");
			}

			// FIM AÇÕES
		} catch (Exception ex) {

			new Erro("Erro inesperado.\n", ex);

		} finally {
		}

		return _cssImp;
	}

	private List<JavaScriptTag> _lstObjJavaScriptTag = new ArrayList<JavaScriptTag>();

	public List<JavaScriptTag> getLstObjJavaScriptTag() {
		return _lstObjJavaScriptTag;
	}

	private List<JavaScriptTag> _lstObjJavaScriptTagOrdenada;

	private List<JavaScriptTag> getLstObjJavaScriptTagOrdenada() {
		// VARIÁVEIS
		// FIM VARIÁVEIS
		try {
			// AÇÕES

			_lstObjJavaScriptTagOrdenada = this.getLstObjJavaScriptTag();

			Collections.sort(_lstObjJavaScriptTagOrdenada, new Comparator<JavaScriptTag>() {
				public int compare(final JavaScriptTag objJavaScriptTag1, final JavaScriptTag objJavaScriptTag2) {
					return objJavaScriptTag1.getIntPrioridade() < objJavaScriptTag2.getIntPrioridade() ? -1
							: (objJavaScriptTag1.getIntPrioridade() > objJavaScriptTag2.getIntPrioridade() ? +1 : 0);
				}
			});

			// FIM AÇÕES
		} catch (Exception ex) {

			new Erro("Erro inesperado.\n", ex);

		} finally {
		}

		return _lstObjJavaScriptTagOrdenada;
	}

	private JavaScriptTag _objJavaScriptMain;

	private JavaScriptTag getObjJavaScriptMain() {
		// VARIÁVEIS
		// FIM VARIÁVEIS
		try {
			// AÇÕES

			if (_objJavaScriptMain == null) {

				_objJavaScriptMain = new JavaScriptTag(null);
				_objJavaScriptMain.setIntPrioridade(6);

				this.getLstObjJavaScriptTag().add(_objJavaScriptMain);
			}

			// FIM AÇÕES
		} catch (Exception ex) {

			new Erro("Erro inesperado.\n", ex);

		} finally {
		}

		return _objJavaScriptMain;
	}

	private String _strTitulo;

	public String getStrTitulo() {
		return _strTitulo;
	}

	public void setStrTitulo(String strTitulo) {
		// VARIÁVEIS
		// FIM VARIÁVEIS
		try {
			// AÇÕES

			_strTitulo = strTitulo;
			_strTitulo += " - " + AppWeb.getI().getStrNome();

			this.getTagTitle().setStrConteudo(_strTitulo);

			// FIM AÇÕES
		} catch (Exception ex) {

			new Erro("Erro inesperado.\n", ex);

		} finally {
		}
	}

	@Override
	public void setStrNome(String strNome) {

		super.setStrNome(strNome);

		// VARIÁVEIS
		// FIM VARIÁVEIS
		try {
			// AÇÕES

			this.setStrTitulo(strNome);

			// FIM AÇÕES
		} catch (Exception ex) {

			new Erro("Erro inesperado.\n", ex);

		} finally {
		}
	}

	private Tag _tagBody;

	public Tag getTagBody() {
		// VARIÁVEIS
		// FIM VARIÁVEIS
		try {
			// AÇÕES

			if (_tagBody == null) {

				_tagBody = new Tag();
				_tagBody.setStrTagNome("body");
				_tagBody.setTagPai(this.getTagHtml());
			}

			// FIM AÇÕES
		} catch (Exception ex) {

			new Erro("Erro inesperado.\n", ex);

		} finally {
		}

		return _tagBody;
	}

	private Tag _tagDocType;

	private Tag getTagDocType() {
		// VARIÁVEIS
		// FIM VARIÁVEIS
		try {
			// AÇÕES

			if (_tagDocType == null) {

				_tagDocType = new Tag();
				_tagDocType.setBooBarraNoFinal(false);
				_tagDocType.setStrTagNome("!DOCTYPE html");
			}

			// FIM AÇÕES
		} catch (Exception ex) {

			new Erro("Erro inesperado.\n", ex);

		} finally {
		}

		return _tagDocType;
	}

	private Tag _tagHead;

	private Tag getTagHead() {
		// VARIÁVEIS
		// FIM VARIÁVEIS
		try {
			// AÇÕES

			if (_tagHead == null) {

				_tagHead = new Tag();
				_tagHead.setStrTagNome("head");
				_tagHead.setTagPai(this.getTagHtml());
			}

			// FIM AÇÕES
		} catch (Exception ex) {

			new Erro("Erro inesperado.\n", ex);

		} finally {
		}

		return _tagHead;
	}

	private Tag _tagHtml;

	private Tag getTagHtml() {
		// VARIÁVEIS
		// FIM VARIÁVEIS
		try {
			// AÇÕES

			if (_tagHtml == null) {

				_tagHtml = new Tag();
				_tagHtml.setStrTagNome("html");
				_tagHtml.getLstAtr().add(new Atributo("xmlns", "http://www.w3.org/1999/xhtml"));
				_tagHtml.getLstAtr().add(new Atributo("lang", "pt-br"));
			}

			// FIM AÇÕES
		} catch (Exception ex) {

			new Erro("Erro inesperado.\n", ex);

		} finally {
		}

		return _tagHtml;
	}

	private Tag _tagMeta;

	private Tag getTagMeta() {
		// VARIÁVEIS
		// FIM VARIÁVEIS
		try {
			// AÇÕES

			if (_tagMeta == null) {

				_tagMeta = new Tag();
				_tagMeta.setStrTagNome("meta");
				_tagMeta.setTagPai(this.getTagHead());
				_tagMeta.getLstAtr().add(new Atributo("http-equiv", "Content-Type"));
				_tagMeta.getLstAtr().add(new Atributo("content"));
				_tagMeta.getLstAtr().get(1).setStrDelimitador(";");
				_tagMeta.getLstAtr().get(1).getLstStrValor().add("text/html");
				_tagMeta.getLstAtr().get(1).getLstStrValor().add(" charset=ISO-8859-1");
			}

			// FIM AÇÕES
		} catch (Exception ex) {

			new Erro("Erro inesperado.\n", ex);

		} finally {
		}

		return _tagMeta;
	}

	private Tag _tagTitle;

	public Tag getTagTitle() {
		// VARIÁVEIS
		// FIM VARIÁVEIS
		try {
			// AÇÕES

			if (_tagTitle == null) {

				_tagTitle = new Tag();
				_tagTitle.setStrTagNome("title");
				_tagTitle.setTagPai(this.getTagHead());

				this.setStrTitulo("Página sem título");
			}

			// FIM AÇÕES
		} catch (Exception ex) {

			new Erro("Erro inesperado.\n", ex);

		} finally {
		}

		return _tagTitle;
	}

	// FIM ATRIBUTOS

	// CONSTRUTORES

	public PaginaHtml() {
		// VARIÁVEIS
		// FIM VARIÁVEIS
		try {
			// AÇÕES

			this.setI(this);
			this.adicionarJs();
			this.getTagDocType();
			this.getTagHead();
			this.getTagHtml();
			this.getTagMeta();
			this.getTagTitle();
			this.getCssMain();
			this.getCssImp();
			this.getTagBody();
			this.getObjJavaScriptMain().adicionarJsCodigo("appWeb.setStrSessionId('" + AppWeb.getI().getObjUsuarioAtual().getStrSessaoId() + "');");			

			// FIM AÇÕES
		} catch (Exception ex) {

			new Erro("Erro inesperado.\n", ex);

		} finally {
		}
	}

	// FIM CONSTRUTORES

	// MÉTODOS

	private void adicionarJs() {
		// VARIÁVEIS
		// FIM VARIÁVEIS
		try {
			// AÇÕES

			this.getLstObjJavaScriptTag().add(new JavaScriptTag("res/lib/DigoWebAppLib/js/lib/jquery-2.0.3.js"));
			this.getLstObjJavaScriptTag().add(new JavaScriptTag("res/lib/DigoWebAppLib/js/lib/md5.js"));
			this.getLstObjJavaScriptTag().add(new JavaScriptTag("res/lib/DigoWebAppLib/js/listas/LstStrErro.js"));
			this.getLstObjJavaScriptTag().add(new JavaScriptTag("res/lib/DigoWebAppLib/js/erro/Erro.js"));
			this.getLstObjJavaScriptTag().add(new JavaScriptTag("res/lib/DigoWebAppLib/js/Utils.js"));
			this.getLstObjJavaScriptTag().add(new JavaScriptTag("res/lib/DigoWebAppLib/js/Objeto.js"));
			this.getLstObjJavaScriptTag().add(new JavaScriptTag("res/lib/DigoWebAppLib/js/AppWeb.js"));
			this.getLstObjJavaScriptTag().add(new JavaScriptTag("res/lib/DigoWebAppLib/js/websocket/WebSocketMain.js"));
			this.getLstObjJavaScriptTag().add(new JavaScriptTag("res/lib/DigoWebAppLib/js/websocket/wsobjetos/WsObjetoMain.js"));
			this.getLstObjJavaScriptTag().add(new JavaScriptTag("res/lib/DigoWebAppLib/js/Usuario.js"));
			this.getLstObjJavaScriptTag().add(new JavaScriptTag("res/lib/DigoWebAppLib/js/html/Tag.js"));
			this.getLstObjJavaScriptTag().add(new JavaScriptTag("res/lib/DigoWebAppLib/js/html/PaginaHtml.js"));

			// FIM AÇÕES
		} catch (Exception ex) {

			new Erro("Erro inesperado.\n", ex);

		} finally {
		}
	}

	public void adicionarJsCodigo(String strJsCodigo) {
		// VARIÁVEIS
		// FIM VARIÁVEIS
		try {
			// AÇÕES

			this.getObjJavaScriptMain().adicionarJsCodigo(strJsCodigo);

			// FIM AÇÕES
		} catch (Exception ex) {

			new Erro("Erro inesperado.\n", ex);

		} finally {
		}
	}

	public String getStrPaginaFormatada() {
		// VARIÁVEIS

		StringBuilder stbPgFormatada = new StringBuilder();

		// FIM VARIÁVEIS
		try {
			// AÇÕES

			for (JavaScriptTag objJavaScriptTag : this.getLstObjJavaScriptTagOrdenada()) {
				objJavaScriptTag.setTagPai(this.getTagHead());
			}

			stbPgFormatada.append(this.getTagDocType().toString());
			stbPgFormatada.append(this.getTagHtml().toString());

			// FIM AÇÕES
		} catch (Exception ex) {

			new Erro("Erro inesperado.\n", ex);

		} finally {
		}

		return stbPgFormatada.toString();
	}

	public void mostrarMensagemInformacaoCliente(String strMensagem) {
		// VARIÁVEIS

		String strJsCodigo, strMensagemFormatada;

		// FIM VARIÁVEIS
		try {
			// AÇÕES

			strMensagemFormatada = "Informação:";
			strMensagemFormatada += "\\n\\n\\n";
			strMensagemFormatada += strMensagem;

			strJsCodigo = "alert('" + strMensagemFormatada + "');";

			this.adicionarJsCodigo(strJsCodigo);

			// FIM AÇÕES
		} catch (Exception ex) {

			new Erro("Erro inesperado.\n", ex);

		} finally {
		}
	}
	
	@Override
	public String toString() {
		return this.getStrPaginaFormatada();
	}

	// FIM MÉTODOS

	// EVENTOS
	// FIM EVENTOS
}
