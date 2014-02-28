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
		// VARIÁVEIS
		// FIM VARIÁVEIS
		try {
			// AÇÕES

			this.setI(this);
			this.setStrNome(strAppNome);

			// FIM AÇÕES
		} catch (Exception ex) {

			new Erro("Erro inesperado.\n", ex);

		} finally {
		}
	}

	public void escreverStrHtmlResposta(String strHtml) {
		// VARIÁVEIS
		// FIM VARIÁVEIS
		try {
			// AÇÕES

			this.getObjPrintWriter().print(strHtml);

			// FIM AÇÕES
		} catch (Exception ex) {

			new Erro("Erro inesperado.\n", ex);

		} finally {
		}
	}

	public boolean getBooUsuarioExiste(String strSessaoId) {
		// VARIÁVEIS

		boolean booResultado = false;

		// FIM VARIÁVEIS
		try {
			// AÇÕES

			for (Usuario usuario : this.getLstObjUsuarioSessao()) {
				if (usuario.getStrSessaoId().equals(strSessaoId)) {
					booResultado = true;
					break;
				}
			}

			// FIM AÇÕES
		} catch (Exception ex) {

			new Erro("Erro inesperado.\n", ex);

		} finally {
		}

		return booResultado;
	}

	public List<PaletaCor> getLstObjPaletaCor() {
		// VARIÁVEIS
		// FIM VARIÁVEIS
		try {
			// AÇÕES

			if (_lstObjPaletaCor == null) {
				_lstObjPaletaCor = new ArrayList<PaletaCor>();
			}

			// FIM AÇÕES
		} catch (Exception ex) {

			new Erro("Erro inesperado.\n", ex);

		} finally {
		}

		return _lstObjPaletaCor;
	}

	public List<Usuario> getLstObjUsuarioSessao() {
		// VARIÁVEIS
		// FIM VARIÁVEIS
		try {
			// AÇÕES

			if (_lstObjUsuarioSessao == null) {
				_lstObjUsuarioSessao = new ArrayList<Usuario>();
			}

			// FIM AÇÕES
		} catch (Exception ex) {

			new Erro("Erro inesperado.\n", ex);

		} finally {
		}

		return _lstObjUsuarioSessao;
	}

	public List<WsConexaoMain> getLstObjWsConexaoMain() {
		// VARIÁVEIS
		// FIM VARIÁVEIS
		try {
			// AÇÕES

			if (_lstObjWsConexaoMain == null) {
				_lstObjWsConexaoMain = new ArrayList<WsConexaoMain>();
			}

			// FIM AÇÕES
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
		// VARIÁVEIS
		// FIM VARIÁVEIS
		try {
			// AÇÕES

			if (_objPaletaCorSelecionada == null) {
				this.getLstObjPaletaCor();
			}

			// FIM AÇÕES
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
		// VARIÁVEIS
		// FIM VARIÁVEIS
		try {
			// AÇÕES

			for (Usuario objUsuario : this.getLstObjUsuarioSessao()) {
				if (objUsuario.getStrSessaoId() == this.getObjHttpSession()
						.getId()) {
					_objUsuarioAtual = objUsuario;
					break;
				}
			}

			// FIM AÇÕES
		} catch (Exception ex) {

			new Erro("Erro inesperado.\n", ex);

		} finally {
		}

		return _objUsuarioAtual;
	}

	/**
	 * Retorna o valor do parâmetro get ou post vindo do cliente indicado pelo
	 * nome contido em "strParamNome". Caso não exista retorna "null".
	 */
	public String getParametro(String strParamNome) {
		// VARIÁVEIS

		String strResultado = null;

		// FIM VARIÁVEIS
		try {
			// AÇÕES

			strResultado = this.getObjHttpServletRequest().getParameter(
					strParamNome);

			// FIM AÇÕES
		} catch (Exception ex) {

			new Erro("Erro inesperado.\n", ex);

		} finally {
		}

		return strResultado;
	}

	public void getResposta(HttpServletRequest objRequest,
			HttpServletResponse objResponse) {
		// VARIÁVEIS
		// FIM VARIÁVEIS
		try {
			// AÇÕES

			this.setObjHttpServletRequest(objRequest);
			this.setObjHttpServletResponse(objResponse);

			// FIM AÇÕES
		} catch (Exception ex) {

			new Erro("Erro inesperado.\n", ex);

		} finally {
		}
	}

	public String getStrPaginaSolicitada() {
		return _strPaginaSolicitada;
	}

	public String getStrPostParametro(String strParametroNome) {
		// VARIÁVEIS

		String strParametroValorResultado = Utils.STRING_VAZIA;

		// FIM VARIÁVEIS
		try {
			// AÇÕES

			strParametroValorResultado = this.getObjHttpServletRequest()
					.getParameter(strParametroNome);

			// FIM AÇÕES
		} catch (Exception ex) {

			new Erro("Erro inesperado.\n", ex);

		} finally {
		}
		return strParametroValorResultado;
	}

	public void reencaminhar(String strUrl) {
		// VARIÁVEIS
		// FIM VARIÁVEIS
		try {
			// AÇÕES

			this.getObjHttpServletResponse().sendRedirect(strUrl);

			// FIM AÇÕES
		} catch (Exception ex) {

			new Erro("Erro inesperado.\n", ex);

		} finally {
		}
	}

	private void setI(AppWeb _i) {
		// VARIÁVEIS
		// FIM VARIÁVEIS
		try {
			// AÇÕES

			if (i == null) {
				i = _i;
			}

			// FIM AÇÕES
		} catch (Exception ex) {

			new Erro("Erro ao instanciar objeto do tipo 'AppWeb'.\n", ex);

		} finally {
		}
	}

	public void setObjHttpServletRequest(
			HttpServletRequest objHttpServletRequest) {
		// VARIÁVEIS
		// FIM VARIÁVEIS
		try {
			// AÇÕES

			_objHttpServletRequest = objHttpServletRequest;
			this.setStrPaginaSolicitada(_objHttpServletRequest.getRequestURI()
					.replace(_objHttpServletRequest.getContextPath() + "/app/",
							Utils.STRING_VAZIA));
			this.setObjHttpSession(_objHttpServletRequest.getSession());

			// FIM AÇÕES
		} catch (Exception ex) {

			new Erro("Erro inesperado.\n", ex);

		} finally {
		}
	}

	public void setObjHttpServletResponse(
			HttpServletResponse objHttpServletResponse) {
		// VARIÁVEIS
		// FIM VARIÁVEIS
		try {
			// AÇÕES

			_objHttpServletResponse = objHttpServletResponse;
			this.setObjPrintWriter(_objHttpServletResponse.getWriter());

			// FIM AÇÕES
		} catch (Exception ex) {

			new Erro("Erro inesperado.\n", ex);

		} finally {
		}
	}

	private void setObjHttpSession(HttpSession objHttpSession) {
		// VARIÁVEIS

		Usuario objUsuario;

		// FIM VARIÁVEIS
		try {
			// AÇÕES

			_objHttpSession = objHttpSession;

			if (!this.getBooUsuarioExiste(_objHttpSession.getId())) {

				objUsuario = new Usuario();
				objUsuario.setStrSessaoId(_objHttpSession.getId());
			}

			// FIM AÇÕES
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
