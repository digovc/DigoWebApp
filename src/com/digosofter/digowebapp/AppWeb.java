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
		// VARI�VEIS
		// FIM VARI�VEIS
		try {
			// A��ES

			if (i == null) {
				i = _i;
			}

			// FIM A��ES
		} catch (Exception ex) {

			new Erro("Erro ao instanciar objeto do tipo 'AppWeb'.\n", ex);

		} finally {
		}
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

	private List<WsConexaoMain> _lstObjWsConexaoMain;

	public List<WsConexaoMain> getLstObjWsConexaoMain() {
		// VARI�VEIS
		// FIM VARI�VEIS
		try {
			// A��ES

			if (_lstObjWsConexaoMain == null) {
				_lstObjWsConexaoMain = new ArrayList<WsConexaoMain>();
			}

			// FIM A��ES
		} catch (Exception ex) {

			new Erro("Erro inesperado.\n", ex);

		} finally {
		}

		return _lstObjWsConexaoMain;
	}

	private static List<PaletaCor> _lstObjPaletaCor;

	public List<PaletaCor> getLstObjPaletaCor() {
		// VARI�VEIS
		// FIM VARI�VEIS
		try {
			// A��ES

			if (_lstObjPaletaCor == null) {
				_lstObjPaletaCor = new ArrayList<PaletaCor>();
			}

			// FIM A��ES
		} catch (Exception ex) {

			new Erro("Erro inesperado.\n", ex);

		} finally {
		}

		return _lstObjPaletaCor;
	}

	private List<Usuario> _lstObjUsuarioSessao;

	public List<Usuario> getLstObjUsuarioSessao() {
		// VARI�VEIS
		// FIM VARI�VEIS
		try {
			// A��ES

			if (_lstObjUsuarioSessao == null) {
				_lstObjUsuarioSessao = new ArrayList<Usuario>();
			}

			// FIM A��ES
		} catch (Exception ex) {

			new Erro("Erro inesperado.\n", ex);

		} finally {
		}

		return _lstObjUsuarioSessao;
	}

	private HttpServletRequest _objHttpServletRequest;

	public HttpServletRequest getObjHttpServletRequest() {
		return _objHttpServletRequest;
	}

	public void setObjHttpServletRequest(HttpServletRequest objHttpServletRequest) {
		// VARI�VEIS
		// FIM VARI�VEIS
		try {
			// A��ES


			_objHttpServletRequest = objHttpServletRequest;
			this.setStrPaginaSolicitada(_objHttpServletRequest.getRequestURI().replace(_objHttpServletRequest.getContextPath() + "/app/", Utils.STRING_VAZIA));
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

		Usuario objUsuario;

		// FIM VARI�VEIS
		try {
			// A��ES

			_objHttpSession = objHttpSession;

			if (!this.getBooUsuarioExiste(_objHttpSession.getId())) {

				objUsuario = new Usuario();
				objUsuario.setStrSessaoId(_objHttpSession.getId());
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

			if (_objPaletaCorSelecionada == null) {
				this.getLstObjPaletaCor();
			}

			// FIM A��ES
		} catch (Exception ex) {

			new Erro("Erro inesperado.\n", ex);

		} finally {
		}

		return _objPaletaCorSelecionada;
	}

	public void setObjPaletaCorSelecionada(PaletaCor objPaletaCorSelecionada) {
		_objPaletaCorSelecionada = objPaletaCorSelecionada;
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
		// VARI�VEIS
		// FIM VARI�VEIS
		try {
			// A��ES

			for (Usuario objUsuario : this.getLstObjUsuarioSessao()) {
				if (objUsuario.getStrSessaoId() == this.getObjHttpSession().getId()) {
					_objUsuarioAtual = objUsuario;
					break;
				}
			}

			// FIM A��ES
		} catch (Exception ex) {

			new Erro("Erro inesperado.\n", ex);

		} finally {
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

		boolean booResultado = false;

		// FIM VARI�VEIS
		try {
			// A��ES

			for (Usuario usuario : this.getLstObjUsuarioSessao()) {
				if (usuario.getStrSessaoId().equals(strSessaoId)) {
					booResultado = true;
					break;
				}
			}

			// FIM A��ES
		} catch (Exception ex) {

			new Erro("Erro inesperado.\n", ex);

		} finally {
		}
		
		return booResultado;
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
