package com.digosofter.digowebapp.html;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import com.digosofter.digowebapp.AppWeb;
import com.digosofter.digowebapp.Objeto;
import com.digosofter.digowebapp.erro.Erro;

public class PaginaHtml extends Objeto {





	private static PaginaHtml i;

	private static CssTag _cssMain;

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

	private CssTag _cssImp;

	private List<JavaScriptTag> _lstObjJavaScriptTag = new ArrayList<JavaScriptTag>();

	private List<JavaScriptTag> _lstObjJavaScriptTagOrdenado;

	private JavaScriptTag _objJavaScriptMain;

	private String _strTitulo;

	private Tag _tagBody;

	private Tag _tagDocType;

	private Tag _tagHead;

	private Tag _tagHtml;

	private Tag _tagMeta;

	private Tag _tagTitle;

	public PaginaHtml() {
		// VARIÁVEIS
		// FIM VARIÁVEIS
		try {
			// AÇÕES

			this.setI(this);
			this.adicionarJs();
			this.adicionarJsCodigo();

			// FIM AÇÕES
		} catch (Exception ex) {

			new Erro("Erro inesperado.\n", ex);

		} finally {
		}
	}

	/**
	 * Acrescenta os arquivos de "JavaScript" para a "tagHead" na ordem correta.
	 */
	private void acrescentarJsAoCabecalho() {
		// VARIÁVEIS
		// FIM VARIÁVEIS
		try {
			// AÇÕES

			for (JavaScriptTag objJavaScriptTag : this
					.getLstObjJavaScriptTagOrdenado()) {
				objJavaScriptTag.setTagPai(this.getTagHead());
			}

			// FIM AÇÕES
		} catch (Exception ex) {

			new Erro("Erro inesperado.\n", ex);

		} finally {
		}
	}

	private void adicionarJs() {
		// VARIÁVEIS
		// FIM VARIÁVEIS
		try {
			// AÇÕES

			this.getLstObjJavaScriptTag().add(
					new JavaScriptTag("res/js/lib/JDigo/lib/jquery-2.0.3.js"));
			this.getLstObjJavaScriptTag().add(
					new JavaScriptTag("res/js/lib/JDigo/lib/md5.js"));
			this.getLstObjJavaScriptTag().add(
					new JavaScriptTag("res/js/lib/JDigo/listas/LstStrErro.js"));
			this.getLstObjJavaScriptTag().add(
					new JavaScriptTag("res/js/lib/JDigo/erro/Erro.js"));
			this.getLstObjJavaScriptTag().add(
					new JavaScriptTag("res/js/lib/JDigo/Utils.js"));
			this.getLstObjJavaScriptTag().add(
					new JavaScriptTag("res/js/lib/JDigo/Objeto.js"));
			this.getLstObjJavaScriptTag().add(
					new JavaScriptTag("res/js/lib/JDigo/AppWeb.js"));
			this.getLstObjJavaScriptTag().add(
					new JavaScriptTag(
							"res/js/lib/JDigo/websocket/WebSocketMain.js"));
			this.getLstObjJavaScriptTag()
					.add(new JavaScriptTag(
							"res/js/lib/JDigo/websocket/wsobjetos/WsObjetoMain.js"));
			this.getLstObjJavaScriptTag().add(
					new JavaScriptTag("res/js/lib/JDigo/Usuario.js"));
			this.getLstObjJavaScriptTag().add(
					new JavaScriptTag("res/js/lib/JDigo/html/Tag.js"));
			this.getLstObjJavaScriptTag().add(
					new JavaScriptTag("res/js/lib/JDigo/html/PaginaHtml.js"));

			// FIM AÇÕES
		} catch (Exception ex) {

			new Erro("Erro inesperado.\n", ex);

		} finally {
		}
	}

	/**
	 * Adiciona códigos "JavaScript" indispensáveis para cada página.
	 */
	private void adicionarJsCodigo() {
		// VARIÁVEIS
		// FIM VARIÁVEIS
		try {
			// AÇÕES

			this.getObjJavaScriptMain().adicionarJsCodigo(
					"appWeb.setStrSessionId('"
							+ AppWeb.getI().getObjUsuarioAtual()
									.getStrSessaoId() + "');");

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

	private CssTag getCssImp() {
		// VARIÁVEIS
		// FIM VARIÁVEIS
		try {
			// AÇÕES

			if (_cssImp == null) {

				_cssImp = new CssTag();
				_cssImp.setStrId("cssImp");
			}

			// FIM AÇÕES
		} catch (Exception ex) {

			new Erro("Erro inesperado.\n", ex);

		} finally {
		}

		return _cssImp;
	}

	public CssTag getCssMain() {
		// VARIÁVEIS
		// FIM VARIÁVEIS
		try {
			// AÇÕES

			if (_cssMain == null) {

				CssTag.setCssMainInstancia(new CssTag());

				_cssMain = CssTag.getCssMainInstancia();
				_cssMain.setStrId("cssMain");
			}

			// FIM AÇÕES
		} catch (Exception ex) {

			new Erro("Erro inesperado.\n", ex);

		} finally {
		}

		return _cssMain;
	}

	public List<JavaScriptTag> getLstObjJavaScriptTag() {
		return _lstObjJavaScriptTag;
	}

	private List<JavaScriptTag> getLstObjJavaScriptTagOrdenado() {
		// VARIÁVEIS
		// FIM VARIÁVEIS
		try {
			// AÇÕES

			_lstObjJavaScriptTagOrdenado = this.getLstObjJavaScriptTag();

			Collections.sort(_lstObjJavaScriptTagOrdenado,
					new Comparator<JavaScriptTag>() {

						@Override
						public int compare(
								final JavaScriptTag objJavaScriptTag1,
								final JavaScriptTag objJavaScriptTag2) {

							return objJavaScriptTag1.getIntPrioridade() < objJavaScriptTag2
									.getIntPrioridade() ? -1
									: (objJavaScriptTag1.getIntPrioridade() > objJavaScriptTag2
											.getIntPrioridade() ? +1 : 0);
						}
					});

			// FIM AÇÕES
		} catch (Exception ex) {

			new Erro("Erro inesperado.\n", ex);

		} finally {
		}

		return _lstObjJavaScriptTagOrdenado;
	}

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

	public String getStrPaginaFormatada() {
		// VARIÁVEIS

		StringBuilder stbResultado = new StringBuilder();

		// FIM VARIÁVEIS
		try {
			// AÇÕES

			this.acrescentarJsAoCabecalho();
			this.montarLayout();

			stbResultado = new StringBuilder();
			stbResultado.append(this.getTagDocType().toString());
			stbResultado.append(this.getTagHtml().toString());

			// FIM AÇÕES
		} catch (Exception ex) {

			new Erro("Erro inesperado.\n", ex);

		} finally {
		}

		return stbResultado.toString();
	}

	public String getStrTitulo() {
		return _strTitulo;
	}

	public Tag getTagBody() {
		// VARIÁVEIS
		// FIM VARIÁVEIS
		try {
			// AÇÕES

			if (_tagBody == null) {

				_tagBody = new Tag();
				_tagBody.setStrTagNome("body");
			}

			// FIM AÇÕES
		} catch (Exception ex) {

			new Erro("Erro inesperado.\n", ex);

		} finally {
		}

		return _tagBody;
	}

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

	private Tag getTagHead() {
		// VARIÁVEIS
		// FIM VARIÁVEIS
		try {
			// AÇÕES

			if (_tagHead == null) {

				_tagHead = new Tag();
				_tagHead.setStrTagNome("head");
			}

			// FIM AÇÕES
		} catch (Exception ex) {

			new Erro("Erro inesperado.\n", ex);

		} finally {
		}

		return _tagHead;
	}





	private Tag getTagHtml() {
		// VARIÁVEIS
		// FIM VARIÁVEIS
		try {
			// AÇÕES

			if (_tagHtml == null) {

				_tagHtml = new Tag();
				_tagHtml.setStrTagNome("html");
				_tagHtml.getLstAtr().add(
						new Atributo("xmlns", "http://www.w3.org/1999/xhtml"));
				_tagHtml.getLstAtr().add(new Atributo("lang", "pt-br"));
			}

			// FIM AÇÕES
		} catch (Exception ex) {

			new Erro("Erro inesperado.\n", ex);

		} finally {
		}

		return _tagHtml;
	}





	private Tag getTagMeta() {
		// VARIÁVEIS
		// FIM VARIÁVEIS
		try {
			// AÇÕES

			if (_tagMeta == null) {

				_tagMeta = new Tag();
				_tagMeta.setStrTagNome("meta");
				_tagMeta.getLstAtr().add(
						new Atributo("http-equiv", "Content-Type"));
				_tagMeta.getLstAtr().add(new Atributo("content"));
				_tagMeta.getLstAtr().get(1).setStrDelimitador(";");
				_tagMeta.getLstAtr().get(1).getLstStrValor().add("text/html");
				_tagMeta.getLstAtr().get(1).getLstStrValor()
						.add(" charset=ISO-8859-1");
			}

			// FIM AÇÕES
		} catch (Exception ex) {

			new Erro("Erro inesperado.\n", ex);

		} finally {
		}

		return _tagMeta;
	}

	public Tag getTagTitle() {
		// VARIÁVEIS
		// FIM VARIÁVEIS
		try {
			// AÇÕES

			if (_tagTitle == null) {

				_tagTitle = new Tag();
				_tagTitle.setStrTagNome("title");

				this.setStrTitulo("Página sem título");
			}

			// FIM AÇÕES
		} catch (Exception ex) {

			new Erro("Erro inesperado.\n", ex);

		} finally {
		}

		return _tagTitle;
	}

	/**
	 * Método que monta o layout antes de gerar o html da página.
	 */
	public void montarLayout() {
		// VARIÁVEIS
		// FIM VARIÁVEIS
		try {
			// AÇÕES

			this.getTagHead().setTagPai(this.getTagHtml());
			this.getTagMeta().setTagPai(this.getTagHead());
			this.getTagTitle().setTagPai(this.getTagHead());
			this.getCssMain().setTagPai(this.getTagHead());
			this.getCssImp().setTagPai(this.getTagHead());
			this.getTagBody().setTagPai(this.getTagHtml());

			// FIM AÇÕES
		} catch (Exception ex) {

			new Erro("Erro inesperado.\n", ex);

		} finally {
		}
	}

	public void mostrarMsgInfoCliente(String strMensagem) {
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

	private void setI(PaginaHtml _i) {
		i = _i;
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
	};

	@Override
	public String toString() {
		return this.getStrPaginaFormatada();
	}





}
