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
		// VARIÁVEIS
		// FIM VARIÁVEIS
		try {
			// AÇÕES

			// FIM AÇÕES
		} catch (Exception ex) {

			new Erro("Erro inesperado.\n", ex);

		} finally {
		}
		return _lstStrGet;
	}

	private List<String> _lstStrPost;

	public List<String> getLstStrPost() {
		// VARIÁVEIS
		// FIM VARIÁVEIS
		try {
			// AÇÕES

			// FIM AÇÕES
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
		// VARIÁVEIS

		_objHttpServletRequest = objHttpServletRequest;

		// FIM VARIÁVEIS
		try {
			// AÇÕES

			this.setStrPaginaSolicitada(_objHttpServletRequest.getRequestURI().replace("/relatar/app/", Utils.STRING_VAZIA));
			this.setObjHttpSession(this.getObjHttpServletRequest().getSession());

			// FIM AÇÕES
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

	private HttpSession _objHttpSession;

	private HttpSession getObjHttpSession() {
		return _objHttpSession;
	}

	private void setObjHttpSession(HttpSession objHttpSession) {
		// VARIÁVEIS

		_objHttpSession = objHttpSession;
		Usuario objUsuario = null;

		// FIM VARIÁVEIS
		try {
			// AÇÕES

			if (!this.getBooUsuarioExiste(_objHttpSession.getId())) {
				objUsuario = new Usuario();
				objUsuario.setStrSessaoId(_objHttpSession.getId());
				this.getLstObjUsuarioSessao().add(objUsuario);
			}

			// FIM AÇÕES
		} catch (Exception ex) {

			new Erro("Erro inesperado.\n", ex);

		} finally {
		}
	}

	private PaletaCor _objPaletaCorSelecionada;

	public PaletaCor getObjPaletaCorSelecionada() {
		// VARIÁVEIS
		// FIM VARIÁVEIS
		try {
			// AÇÕES

			for (PaletaCor objPaletaCor : this.getLstObjPaletaCor()) {
				if (objPaletaCor.getBooSelecionado()) {
					_objPaletaCorSelecionada = objPaletaCor;
					break;
				}
			}

			// FIM AÇÕES
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

	// FIM CONSTRUTORES

	// MÉTODOS

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

		boolean booUsuarioExisteResultado = false;

		// FIM VARIÁVEIS
		try {
			// AÇÕES

			for (Usuario usuario : this.getLstObjUsuarioSessao()) {
				if (usuario.getStrSessaoId().equals(strSessaoId)) {
					booUsuarioExisteResultado = true;
					break;
				}
			}

			// FIM AÇÕES
		} catch (Exception ex) {

			new Erro("Erro inesperado.\n", ex);

		} finally {
		}
		return booUsuarioExisteResultado;
	}

	public void getResposta(HttpServletRequest objRequest, HttpServletResponse objResponse) {
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

	public String getStrPostParametro(String strParametroNome) {
		// VARIÁVEIS

		String strParametroValorResultado = Utils.STRING_VAZIA;

		// FIM VARIÁVEIS
		try {
			// AÇÕES

			strParametroValorResultado = this.getObjHttpServletRequest().getParameter(strParametroNome);

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

	// FIM MÉTODOS

	// EVENTOS
	// FIM EVENTOS
}
