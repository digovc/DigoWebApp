package com.digosofter.digowebapp;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.digosofter.digowebapp.design.PaletaCor;
import com.digosofter.digowebapp.erro.Erro;
import com.digosofter.digowebapp.websocket.WsConexaoMain;

public abstract class AppWeb extends Objeto {
	// CONSTANTES
	// FIM CONSTANTES

	// ATRIBUTOS

	private static AppWeb i;

	public static AppWeb getI() {
		return i;
	}

	private void setI(AppWeb _i) {
		i = _i;
	}

	private List<String> _lstStrGet;

	public List<String> getLstStrGet() {
		// VARI�VEIS
		// FIM VARI�VEIS
		try {
			// A��ES

			// FIM A��ES
		} catch (Exception ex) {

			new Erro("Erro inesperado.\n", ex);

		} finally {
		}
		return _lstStrGet;
	}

	private List<String> _lstStrPost;

	public List<String> getLstStrPost() {
		// VARI�VEIS
		// FIM VARI�VEIS
		try {
			// A��ES

			// FIM A��ES
		} catch (Exception ex) {

			new Erro("Erro inesperado.\n", ex);

		} finally {
		}
		return _lstStrPost;
	}

	private List<WsConexaoMain> _lstObjWsConexaoMain = new ArrayList<WsConexaoMain>();

	public List<WsConexaoMain> getLstObjWsConexaoMain() {
		return _lstObjWsConexaoMain;
	}

	private static List<PaletaCor> _lstObjPaletaCor;

	public List<PaletaCor> getLstObjPaletaCor() {
		if (_lstObjPaletaCor == null) {
			_lstObjPaletaCor = new ArrayList<PaletaCor>();
		}
		return _lstObjPaletaCor;
	}

	public void setLstObjPaletaCor(List<PaletaCor> lstObjPaletaCor) {
		_lstObjPaletaCor = lstObjPaletaCor;
	}

	private List<Usuario> _lstObjUsuarioSessao = new ArrayList<Usuario>();

	public List<Usuario> getLstObjUsuarioSessao() {
		return _lstObjUsuarioSessao;
	}

	private HttpServletRequest _objHttpServletRequest;

	private HttpServletRequest getObjHttpServletRequest() {
		return _objHttpServletRequest;
	}

	public void setObjHttpServletRequest(HttpServletRequest objHttpServletRequest) {
		// VARI�VEIS

		_objHttpServletRequest = objHttpServletRequest;

		// FIM VARI�VEIS
		try {
			// A��ES

			this.setStrPaginaSolicitada(_objHttpServletRequest.getRequestURI().replace("/relatar/app/", Utils.STRING_VAZIA));
			this.setObjHttpSession(this.getObjHttpServletRequest().getSession());

			// FIM A��ES
		} catch (Exception ex) {

			new Erro("Erro inesperado.\n", ex);

		} finally {
		}
	}

	private HttpServletResponse _objHttpServletResponse;

	private HttpServletResponse getObjHttpServletResponse() {
		return _objHttpServletResponse;
	}

	public void setObjHttpServletResponse(HttpServletResponse objHttpServletResponse) {
		// VARI�VEIS
		// FIM VARI�VEIS
		try {
			// A��ES

			_objHttpServletResponse = objHttpServletResponse;
			this.setObjPrintWriter(_objHttpServletResponse.getWriter());

			// FIM A��ES
		} catch (Exception ex) {

			new Erro("Erro inesperado.\n", ex);

		} finally {
		}
	}

	private HttpSession _objHttpSession;

	private HttpSession getObjHttpSession() {
		return _objHttpSession;
	}

	private void setObjHttpSession(HttpSession objHttpSession) {
		// VARI�VEIS

		_objHttpSession = objHttpSession;
		Usuario objUsuario = null;

		// FIM VARI�VEIS
		try {
			// A��ES

			if (!this.getBooUsuarioExiste(_objHttpSession.getId())) {
				objUsuario = new Usuario();
				objUsuario.setStrSessaoId(_objHttpSession.getId());
				this.getLstObjUsuarioSessao().add(objUsuario);
			}

			// FIM A��ES
		} catch (Exception ex) {

			new Erro("Erro inesperado.\n", ex);

		} finally {
		}
	}

	private PaletaCor _objPaletaCorSelecionada;

	public PaletaCor getObjPaletaCorSelecionada() {
		// VARI�VEIS
		// FIM VARI�VEIS
		try {
			// A��ES

			for (PaletaCor objPaletaCor : this.getLstObjPaletaCor()) {
				if (objPaletaCor.getBooSelecionado()) {
					_objPaletaCorSelecionada = objPaletaCor;
					break;
				}
			}

			// FIM A��ES
		} catch (Exception ex) {

			new Erro("Erro inesperado.\n", ex);

		} finally {
		}

		return _objPaletaCorSelecionada;
	}

	private PrintWriter _objPrintWriter;

	private PrintWriter getObjPrintWriter() {
		return _objPrintWriter;
	}

	public void setObjPrintWriter(PrintWriter objPrintWriter) {
		_objPrintWriter = objPrintWriter;
	}

	private String _strPaginaSolicitada;

	public String getStrPaginaSolicitada() {
		return _strPaginaSolicitada;
	}

	private void setStrPaginaSolicitada(String strPaginaSolicitada) {
		_strPaginaSolicitada = strPaginaSolicitada;
	}

	private Usuario _objUsuarioAtual;

	public Usuario getObjUsuarioAtual() {
		for (Usuario objUsuario : this.getLstObjUsuarioSessao()) {
			if (objUsuario.getStrSessaoId() == this.getObjHttpSession().getId()) {
				_objUsuarioAtual = objUsuario;
				break;
			}
		}
		return _objUsuarioAtual;
	}

	// FIM ATRIBUTOS

	// CONSTRUTORES

	public AppWeb(String strAppNome) {
		// VARI�VEIS
		// FIM VARI�VEIS
		try {
			// A��ES

			this.setI(this);
			this.setStrNome(strAppNome);

			// FIM A��ES
		} catch (Exception ex) {

			new Erro("Erro inesperado.\n", ex);

		} finally {
		}
	}

	// FIM CONSTRUTORES

	// M�TODOS

	public void escreverStrHtmlResposta(String strHtml) {
		// VARI�VEIS
		// FIM VARI�VEIS
		try {
			// A��ES

			this.getObjPrintWriter().print(strHtml);

			// FIM A��ES
		} catch (Exception ex) {

			new Erro("Erro inesperado.\n", ex);

		} finally {
		}
	}

	public boolean getBooUsuarioExiste(String strSessaoId) {
		// VARI�VEIS

		boolean booUsuarioExisteResultado = false;

		// FIM VARI�VEIS
		try {
			// A��ES

			for (Usuario usuario : this.getLstObjUsuarioSessao()) {
				if (usuario.getStrSessaoId().equals(strSessaoId)) {
					booUsuarioExisteResultado = true;
					break;
				}
			}

			// FIM A��ES
		} catch (Exception ex) {

			new Erro("Erro inesperado.\n", ex);

		} finally {
		}
		return booUsuarioExisteResultado;
	}

	public void getResposta(HttpServletRequest objRequest, HttpServletResponse objResponse) {
		// VARI�VEIS
		// FIM VARI�VEIS
		try {
			// A��ES

			this.setObjHttpServletRequest(objRequest);
			this.setObjHttpServletResponse(objResponse);

			// FIM A��ES
		} catch (Exception ex) {

			new Erro("Erro inesperado.\n", ex);

		} finally {
		}
	}

	public String getStrPostParametro(String strParametroNome) {
		// VARI�VEIS

		String strParametroValorResultado = Utils.STRING_VAZIA;

		// FIM VARI�VEIS
		try {
			// A��ES

			strParametroValorResultado = this.getObjHttpServletRequest().getParameter(strParametroNome);

			// FIM A��ES
		} catch (Exception ex) {

			new Erro("Erro inesperado.\n", ex);

		} finally {
		}
		return strParametroValorResultado;
	}

	public void reencaminhar(String strUrl) {
		// VARI�VEIS
		// FIM VARI�VEIS
		try {
			// A��ES

			this.getObjHttpServletResponse().sendRedirect(strUrl);

			// FIM A��ES
		} catch (Exception ex) {

			new Erro("Erro inesperado.\n", ex);

		} finally {
		}
	}

	// FIM M�TODOS

	// EVENTOS
	// FIM EVENTOS
}
