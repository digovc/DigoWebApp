package com.digosofter.digowebapp;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.digosofter.digojava.App;
import com.digosofter.digojava.Utils;
import com.digosofter.digojava.erro.Erro;
import com.digosofter.digowebapp.design.PaletaCor;

public abstract class AppWeb extends App {

	private static List<PaletaCor> _lstObjPaletaCor;

	public static final String DIR_JS_BOTAO = "res/js/lib/JDigo/html/Botao.js";

	public static final String DIR_JS_CAMPO = "res/js/lib/JDigo/html/Campo.js";
	public static final String DIR_JS_COMBO_BOX = "res/js/lib/JDigo/html/ComboBox.js";
	public static final String DIR_JS_COMPONENTE_MAIN = "res/js/lib/JDigo/html/componente/ComponenteMain.js";
	public static final String DIR_JS_FORMULARIO = "res/js/lib/JDigo/html/Formulario.js";
	public static final String DIR_JS_FORMULARIO_TBL = "res/js/lib/JDigo/html/componente/FormularioTbl.js";
	public static final String DIR_JS_IMAGEM = "res/js/lib/JDigo/html/Imagem.js";
	public static final String DIR_JS_ITEM_MAIN = "res/js/lib/JDigo/html/componente/item/ItemMain.js";
	public static final String DIR_JS_MOOTOOLS = "res/js/lib/JDigo/lib/mootools-core-1.4.5.js";
	public static final String DIR_JS_PAINEL = "res/js/lib/JDigo/html/Painel.js";
	public static final String DIR_JS_POPUP = "res/js/lib/JDigo/html/componente/Popup.js";
	public static final String DIR_JS_POPUP_ITEM = "res/js/lib/JDigo/html/componente/item/PopupItem.js";
	public static final String DIR_JS_QUICKSEARCH = "res/js/lib/JDigo/lib/jquery.quicksearch.min.js";
	public static final String DIR_JS_RELATORIO_MAIN = "res/js/lib/JDigo/html/relatorio/RelatorioMain.js";
	public static final String DIR_JS_TABELA = "res/js/lib/JDigo/html/componente/Tabela.js";
	public static final String DIR_JS_TABLESORTER = "res/js/lib/JDigo/lib/jquery.tablesorter.min.js";
	public static final String DIR_JS_TAG = "res/js/lib/JDigo/html/Tag.js";
	public static final String DIR_JS_WEBSOCKET_FILE_TRANSFER = "res/js/lib/JDigo/lib/WebSocketFileTransfer.js";
	private static AppWeb i;

	public static AppWeb getI() {

		return i;
	}

	private boolean _booOcupado;
	private String _dirLocal;
	private List<Usuario> _lstUsr;
	private HttpServletRequest _objHttpServletRequest;
	private HttpServletResponse _objHttpServletResponse;
	private HttpSession _objHttpSession;
	private PaletaCor _objPaletaCor;
	private PrintWriter _objPrintWriter;
	private ServletContext _objServletContext;
	private String _strPagSolicitada;
	private Usuario _usrAtual;

	protected AppWeb(String strAppNome) {

		try {

			this.setI(this);
			this.setStrNome(strAppNome);
		} catch (Exception ex) {

			new Erro("Erro inesperado.\n", ex);
		} finally {
		}
	}

	public void addStrHtmlResposta(int intHtml) {

		try {

			this.getObjPrintWriter().print(intHtml);
		} catch (Exception ex) {

			new Erro("Erro inesperado.\n", ex);
		} finally {
		}
	}

	public void addStrHtmlResposta(String strHtml) {

		try {

			this.getObjPrintWriter().print(strHtml);
		} catch (Exception ex) {

			new Erro("Erro inesperado.\n", ex);
		} finally {
		}
	}

	public void addUsr(Usuario usr) {

		try {

			if (usr == null) {

				return;
			}

			if (this.getLstUsr().contains(usr)) {

				return;
			}

			this.getLstUsr().add(usr);
		} catch (Exception ex) {

			new Erro("Erro inesperado.\n", ex);
		} finally {
		}
	}

	public boolean getBooOcupado() {

		return _booOcupado;
	}

	public boolean getBooUsuarioExiste(String strSessaoId) {

		try {

			if (Utils.getBooStrVazia(strSessaoId)) {

				return false;
			}

			for (Usuario usr : this.getLstUsr()) {

				if (usr == null) {

					continue;
				}

				if (!usr.getStrSessaoId().equals(strSessaoId)) {

					continue;
				}

				return true;
			}
		} catch (Exception ex) {

			new Erro("Erro inesperado.\n", ex);
		} finally {
		}

		return false;
	}

	public String getDirLocal() {

		try {

			if (!Utils.getBooStrVazia(_dirLocal)) {

				return _dirLocal;
			}

			_dirLocal = this.getObjServletContext().getRealPath("/");
		} catch (Exception ex) {

			new Erro("Erro inesperado.\n", ex);
		} finally {
		}

		return _dirLocal;
	}

	/**
	 * Retorna o valor do parâmetro "GET" ou "POST" vindo do cliente indicado
	 * pelo nome contido em "strParamNome". Caso não exista retorna "-1".
	 */
	public int getIntParam(String strParamNome) {

		String strParam;

		try {

			if (Utils.getBooStrVazia(strParamNome)) {

				return -1;
			}

			strParam = this.getObjHttpServletRequest().getParameter(strParamNome);
			strParam = !Utils.getBooStrVazia(strParam) ? strParam : "-1";

			return Integer.valueOf(strParam);
		} catch (Exception ex) {

			new Erro("Erro inesperado.\n", ex);
		} finally {
		}

		return -1;
	}

	public List<PaletaCor> getLstObjPaletaCor() {

		try {

			if (_lstObjPaletaCor != null) {

				return _lstObjPaletaCor;
			}

			_lstObjPaletaCor = new ArrayList<PaletaCor>();
		} catch (Exception ex) {

			new Erro("Erro inesperado.\n", ex);
		} finally {
		}

		return _lstObjPaletaCor;
	}

	public List<Usuario> getLstUsr() {

		try {

			if (_lstUsr != null) {

				return _lstUsr;
			}

			_lstUsr = new ArrayList<Usuario>();
		} catch (Exception ex) {

			new Erro("Erro inesperado.\n", ex);
		} finally {
		}

		return _lstUsr;
	}

	public HttpServletRequest getObjHttpServletRequest() {

		return _objHttpServletRequest;
	}

	protected HttpServletResponse getObjHttpServletResponse() {

		return _objHttpServletResponse;
	}

	public HttpSession getObjHttpSession() {

		return _objHttpSession;
	}

	public PaletaCor getObjPaletaCor() {

		try {

			if (_objPaletaCor != null) {

				return _objPaletaCor;
			}

			for (PaletaCor objPaletaCor : this.getLstObjPaletaCor()) {

				if (objPaletaCor == null) {

					continue;
				}

				if (!objPaletaCor.getBooSelecionado()) {

					continue;
				}

				_objPaletaCor = objPaletaCor;
				break;
			}

			if (_objPaletaCor == null) {

				_objPaletaCor = new PaletaCor("default");
			}
		} catch (Exception ex) {

			new Erro("Erro inesperado.\n", ex);
		} finally {
		}

		return _objPaletaCor;
	}

	private PrintWriter getObjPrintWriter() {

		return _objPrintWriter;
	}

	protected ServletContext getObjServletContext() {

		try {

			_objServletContext = this.getObjHttpServletRequest().getServletContext();
		} catch (Exception ex) {

			new Erro("Erro inesperado.\n", ex);
		} finally {
		}

		return _objServletContext;
	}

	public String getStrPagSolicitada() {

		return _strPagSolicitada;
	}

	/**
	 * Retorna o valor do parâmetro "GET" ou "POST" vindo do cliente indicado
	 * pelo nome contido em "strParamNome". Caso não exista retorna "null".
	 */
	public String getStrParam(String strParamNome) {

		try {

			if (Utils.getBooStrVazia(strParamNome)) {

				return null;
			}

			return this.getObjHttpServletRequest().getParameter(strParamNome);
		} catch (Exception ex) {

			new Erro("Erro inesperado.\n", ex);
		} finally {
		}

		return null;
	}

	public Usuario getUsr(String strSessaoId) {

		try {

			for (Usuario usr : this.getLstUsr()) {

				if (usr == null) {

					continue;
				}

				if (!usr.getStrSessaoId().equals(strSessaoId)) {

					continue;
				}

				return usr;
			}
		} catch (Exception ex) {

			new Erro("Erro inesperado.\n", ex);
		} finally {
		}

		return null;
	}

	public Usuario getUsrAtual() {

		try {

			if (_usrAtual != null && _usrAtual.getStrSessaoId().equals(this.getObjHttpSession().getId())) {

				return _usrAtual;
			}

			for (Usuario usr : this.getLstUsr()) {

				if (usr == null) {

					continue;
				}

				if (!usr.getStrSessaoId().equals(this.getObjHttpSession().getId())) {

					continue;
				}

				_usrAtual = usr;

				break;
			}
		} catch (Exception ex) {

			new Erro("Erro inesperado.\n", ex);
		} finally {
		}

		return _usrAtual;
	}

	public void reencaminhar(String strUrl) {

		try {

			if (Utils.getBooStrVazia(strUrl)) {

				return;
			}

			this.getObjHttpServletResponse().sendRedirect(strUrl);
		} catch (Exception ex) {

			new Erro("Erro inesperado.\n", ex);
		} finally {
		}
	}

	public void responder(HttpServletRequest objRequest, HttpServletResponse objResponse) {

		try {

			this.setObjHttpServletRequest(objRequest);
			this.setObjHttpServletResponse(objResponse);
		} catch (Exception ex) {

			new Erro("Erro inesperado.\n", ex);
		} finally {
		}
	}

	public synchronized void setBooOcupado(boolean booOcupado) {

		_booOcupado = booOcupado;
	}

	private void setI(AppWeb _i) {

		try {

			if (i != null) {

				return;
			}

			i = _i;
		} catch (Exception ex) {

			new Erro("Erro ao instanciar objeto do tipo 'AppWeb'.\n", ex);
		} finally {
		}
	}

	private void setObjHttpServletRequest(HttpServletRequest objHttpServletRequest) {

		try {

			_objHttpServletRequest = objHttpServletRequest;

			if (_objHttpServletRequest == null) {

				return;
			}

			this.setStrPagSolicitada(_objHttpServletRequest.getRequestURI()
					.replace(_objHttpServletRequest.getContextPath() + "/app/", Utils.STR_VAZIA));
			this.setObjHttpSession(_objHttpServletRequest.getSession());
		} catch (Exception ex) {

			new Erro("Erro inesperado.\n", ex);
		} finally {
		}
	}

	private void setObjHttpServletResponse(HttpServletResponse objHttpServletResponse) {

		try {

			_objHttpServletResponse = objHttpServletResponse;

			if (_objHttpServletResponse == null) {

				return;
			}

			this.setObjPrintWriter(_objHttpServletResponse.getWriter());
		} catch (Exception ex) {

			new Erro("Erro inesperado.\n", ex);
		} finally {
		}
	}

	private void setObjHttpSession(HttpSession objHttpSession) {

		Usuario usr;

		try {

			_objHttpSession = objHttpSession;

			if (_objHttpSession == null) {

				return;
			}

			if (this.getBooUsuarioExiste(_objHttpSession.getId())) {

				return;
			}

			usr = new Usuario();
			usr.setStrSessaoId(_objHttpSession.getId());
		} catch (Exception ex) {

			new Erro("Erro inesperado.\n", ex);
		} finally {
		}
	}

	public void setObjPaletaCorSelecionada(PaletaCor objPaletaCorSelecionada) {

		_objPaletaCor = objPaletaCorSelecionada;
	}

	public void setObjPrintWriter(PrintWriter objPrintWriter) {

		_objPrintWriter = objPrintWriter;
	}

	private void setStrPagSolicitada(String strPagSolicitada) {

		_strPagSolicitada = strPagSolicitada;
	}
}