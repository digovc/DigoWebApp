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

	private static AppWeb i;

	public static AppWeb getI() {
		return i;
	}

	private List<WsConexaoMain> _lstObjWsConexaoMain;

	private static List<PaletaCor> _lstObjPaletaCor;

	private List<Usuario> _lstObjUsuarioSessao;

	private HttpServletRequest _objHttpServletRequest;

	private HttpServletResponse _objHttpServletResponse;

	private HttpSession _objHttpSession;

	private PaletaCor _objPaletaCorSelecionada;

	private PrintWriter _objPrintWriter;

	private String _strPaginaSolicitada;

	private Usuario _objUsuarioAtual;

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

	public HttpServletRequest getObjHttpServletRequest() {
		return _objHttpServletRequest;
	}

	private HttpServletResponse getObjHttpServletResponse() {
		return _objHttpServletResponse;
	}

	private HttpSession getObjHttpSession() {
		return _objHttpSession;
	}

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

	private PrintWriter getObjPrintWriter() {
		return _objPrintWriter;
	}

	public Usuario getObjUsuarioAtual() {
		// VARI�VEIS
		// FIM VARI�VEIS
		try {
			// A��ES

			for (Usuario objUsuario : this.getLstObjUsuarioSessao()) {
				if (objUsuario.getStrSessaoId() == this.getObjHttpSession()
						.getId()) {
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

	/**
	 * Retorna o valor do par�metro get ou post vindo do cliente indicado pelo
	 * nome contido em "strParamNome". Caso n�o exista retorna "null".
	 */
	public String getParametro(String strParamNome) {
		// VARI�VEIS

		String strResultado = null;

		// FIM VARI�VEIS
		try {
			// A��ES

			strResultado = this.getObjHttpServletRequest().getParameter(
					strParamNome);

			// FIM A��ES
		} catch (Exception ex) {

			new Erro("Erro inesperado.\n", ex);

		} finally {
		}

		return strResultado;
	}

	public void getResposta(HttpServletRequest objRequest,
			HttpServletResponse objResponse) {
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

	public String getStrPaginaSolicitada() {
		return _strPaginaSolicitada;
	}

	public String getStrPostParametro(String strParametroNome) {
		// VARI�VEIS

		String strParametroValorResultado = Utils.STRING_VAZIA;

		// FIM VARI�VEIS
		try {
			// A��ES

			strParametroValorResultado = this.getObjHttpServletRequest()
					.getParameter(strParametroNome);

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

	public void setObjHttpServletRequest(
			HttpServletRequest objHttpServletRequest) {
		// VARI�VEIS
		// FIM VARI�VEIS
		try {
			// A��ES

			_objHttpServletRequest = objHttpServletRequest;
			this.setStrPaginaSolicitada(_objHttpServletRequest.getRequestURI()
					.replace(_objHttpServletRequest.getContextPath() + "/app/",
							Utils.STRING_VAZIA));
			this.setObjHttpSession(_objHttpServletRequest.getSession());

			// FIM A��ES
		} catch (Exception ex) {

			new Erro("Erro inesperado.\n", ex);

		} finally {
		}
	}

	public void setObjHttpServletResponse(
			HttpServletResponse objHttpServletResponse) {
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

	public void setObjPaletaCorSelecionada(PaletaCor objPaletaCorSelecionada) {
		_objPaletaCorSelecionada = objPaletaCorSelecionada;
	}

	public void setObjPrintWriter(PrintWriter objPrintWriter) {
		_objPrintWriter = objPrintWriter;
	}

	private void setStrPaginaSolicitada(String strPaginaSolicitada) {
		_strPaginaSolicitada = strPaginaSolicitada;
	}

}
